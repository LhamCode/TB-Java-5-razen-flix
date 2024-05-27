package br.org.olabi.razenflix;

import br.org.olabi.razenflix.model.entity.Filme;
import br.org.olabi.razenflix.model.entity.Serie;
import br.org.olabi.razenflix.repository.FilmeRepository;
import br.org.olabi.razenflix.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class RazenflixApplication {

	@Autowired
	private final FilmeRepository repository;
	private final SerieRepository repositoryS;

	public RazenflixApplication(FilmeRepository repository, SerieRepository repositoryS){
		this.repository = repository;
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

	@PostMapping("/series")
	public ResponseEntity<Serie> createSerie(@RequestBody Serie serie){
		Serie savedSerie = repositoryS.save(serie);
		return ResponseEntity.ok(savedSerie);
	}
}

