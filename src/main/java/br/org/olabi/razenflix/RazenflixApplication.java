package br.org.olabi.razenflix;

import br.org.olabi.razenflix.model.entity.Filme;
import br.org.olabi.razenflix.model.value.Serie;
import br.org.olabi.razenflix.repository.FilmeRepository;
import br.org.olabi.razenflix.repository.SerieRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@SpringBootApplication
@RestController
public class RazenflixApplication {

	private final FilmeRepository repository;

	public RazenflixApplication(FilmeRepository repository){
		this.repository = repository;
	}

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

	@GetMapping("/filmes")
	public List<Filme> getFilmes(){
		return repository.findAll();
	}

	@GetMapping("/series")
	public List<Serie> getSeries(){
		return repositoryS.findAll();
	}
}
