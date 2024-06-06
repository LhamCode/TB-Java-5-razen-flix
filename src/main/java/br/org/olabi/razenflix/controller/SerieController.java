package br.org.olabi.razenflix.controller;
import br.org.olabi.razenflix.model.entity.Serie;
import br.org.olabi.razenflix.model.value.Ratings;
import br.org.olabi.razenflix.repository.SerieRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/series")
public class SerieController {

    private final SerieRepository repositoryS;

    public SerieController(SerieRepository repositoryS){

        this.repositoryS = repositoryS;
    }
    //Obtém todas as listas
    @GetMapping
    public List<Serie> getAll(){
        return repositoryS.findAll();
    }
    //busca por id
    @GetMapping("/{id}")
    public Optional<Serie> getById(@PathVariable UUID id){
        return repositoryS.findById(id);
    }
    //adiciona uma série
    @PostMapping("/criar")
    public ResponseEntity<Serie> createSerie(@RequestBody Serie serie){
        Serie savedSerie = repositoryS.save(serie);
        return ResponseEntity.ok(savedSerie);
    }
    //atualiza detalhes de uma série
    @PutMapping("/{id}")

        public ResponseEntity<?> put(@PathVariable UUID id, @RequestBody Serie serieBody) {
            Optional <Serie> serieEncontrada = repositoryS.findById(id);
            if (serieEncontrada.isPresent()) {
                Serie serie = serieEncontrada.get();
                serie.setTitle(serieBody.getTitle());
                serie.setTotalSeasons(serieBody.getTotalSeasons());
                serie.setGenre(serieBody.getGenre());
                serie.setWriters(serieBody.getWriters());
                serie.setPoster(serieBody.getPoster());
                serie.setActors(serieBody.getActors());
                serie.setRatings(serieBody.getRatings());

                Serie serieSalva = repositoryS.save(serie);
                return ResponseEntity.ok(serieSalva);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Série Inexistente");
            }
        }

    @PatchMapping("/{id}/like")
    public ResponseEntity<Serie> like(@PathVariable UUID id) throws IllegalAccessException {
        Optional<Serie> serieEncontrada = repositoryS.findById(id);

        if (serieEncontrada.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Serie serie = serieEncontrada.get();
        Ratings avaliacao = serie.getRatings();

        Integer likesAtuais = Integer.parseInt(avaliacao.getLikes());
        Integer like = likesAtuais + 1;
        avaliacao.setLikes(String.valueOf(like));

        return  ResponseEntity.ok(repositoryS.save(serie));

    }
    //exclui uma serie
    @DeleteMapping("/{id}/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> delete(@PathVariable UUID id){
        if (repositoryS.existsById(id)){
            repositoryS.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Série removida com sucesso.");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Série não encontrada.");
        }
    }
}



