package com.rogadev.portfolio.security.JWT;

import com.rogadev.portfolio.security.JWT.CustomUsersDetailsService;
import com.rogadev.portfolio.security.JWT.JwtGenerador;
import com.rogadev.portfolio.security.model.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private CustomUsersDetailsService customUsersDetailsService;
    @Autowired
    private JwtGenerador jwtGenerador;

    private String obtenerTokenDeSolicitud(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }

    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String token = obtenerTokenDeSolicitud(request);

        if (StringUtils.hasText(token) && jwtGenerador.validarToken(token)) {

            String username = jwtGenerador.obtenerUsernameDeJwt(token);
            UserDetails userDetails = customUsersDetailsService.loadUserByUsername(username);
            List<String> userRoles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();




            if (userRoles.contains("USER") || userRoles.contains("ADMIN")) {

                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );

                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        filterChain.doFilter(request, response);
    }


}
