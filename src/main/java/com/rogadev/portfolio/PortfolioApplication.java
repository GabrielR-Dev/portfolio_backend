package com.rogadev.portfolio;

import com.rogadev.portfolio.security.model.Roles;
import com.rogadev.portfolio.security.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;


@SpringBootApplication
@ServletComponentScan
public class PortfolioApplication {
	@Autowired
	 RolRepository rolRepository;
	public static void main(String[] args) {


		SpringApplication.run(PortfolioApplication.class, args);
	}


	public void verifiRol(){
		Boolean exist = rolRepository.existByName("USER");
		if (!exist) {
			Roles rol = new Roles();
			rol.setName("USER");
		}
	}

}
