package br.org.olabi.razenflix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RazenflixApplication {

	public static void main(String[] args) {
		SpringApplication.run(RazenflixApplication.class, args);
	}
	//http://localhost:8080/hello
	@GetMapping("/hello")
	public String hello(){
		return "Salve, Mundão!";
    }
}
