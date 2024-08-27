package br.com.laplaza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@SpringBootApplication()
public class LaPlazaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaPlazaApplication.class, args);
	}

}
