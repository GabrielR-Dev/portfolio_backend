package com.rogadev.portfolio.security.JWT;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;


import java.util.Date;


@Component
public class JwtGenerador {

    public String generarToken(Authentication authentication) {


        String username = authentication.getName();
        //Usuarios usuario = (Usuarios) authentication.getPrincipal();

        Date tiempoActual = new Date();
        Date expiracionToken = new Date(tiempoActual.getTime() + ConstantesSeguridad.JWT_EXPIRATION_TOKEN);

        Claims claims = Jwts.claims();
        //claims.put("idUsuario", usuario.getIdUsuario());


        //Linea para generar el token
        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(expiracionToken)
                //.setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, ConstantesSeguridad.JWT_FIRMA)
                .compact();
        return token;
    }

    public String obtenerUsernameDeJwt(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(ConstantesSeguridad.JWT_FIRMA)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }



    public Boolean validarToken(String token) {
        try {
            Jwts.parser().setSigningKey(ConstantesSeguridad.JWT_FIRMA).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            throw new AuthenticationCredentialsNotFoundException("Jwt ah expirado o esta incorrecto");
        }
    }
}
