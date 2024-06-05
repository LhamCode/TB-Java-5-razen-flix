package br.org.olabi.razenflix;



import br.org.olabi.razenflix.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
@RestController
public class RazenflixApplication {

	@Autowired

	private final SerieRepository repositoryS;

	public RazenflixApplication(SerieRepository repositoryS){

        this.repositoryS = repositoryS;
    }

	public static void main(String[] args) {
		SpringApplication.run(RazenflixApplication.class, args);
	}
	//http://localhost:8080/hello
	@GetMapping("/hello")
	public String hello(){
		return "Salve, Mundão!";
    }

}

