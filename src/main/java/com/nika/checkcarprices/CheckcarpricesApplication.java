package com.nika.checkcarprices;

import com.nika.checkcarprices.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CheckcarpricesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CheckcarpricesApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        Principal principal = new Principal();
        principal.ExibeMenu();
    }
}
