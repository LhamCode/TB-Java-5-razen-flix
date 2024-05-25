package br.org.olabi.razenflix.config;

import br.org.olabi.razenflix.model.entity.Filme;
import br.org.olabi.razenflix.model.value.Serie;
import br.org.olabi.razenflix.repository.FilmeRepository;
import br.org.olabi.razenflix.repository.SerieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DatabaseInitializer implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DatabaseInitializer.class);

    private final FilmeRepository filmeRepository;

    public DatabaseInitializer (FilmeRepository filmeRepository){
        this.filmeRepository = filmeRepository;
    }

    public static final List<Filme> filmes = List.of(
            Filme("Avatar", "2009", "PG-13", "18 Dec 2009", "162 min", "Action, Adventure, Fantasy", "James Cameron", "James Cameron", "Sam Worthington, Zoe Saldana, Sigourney Weaver, Stephen Lang", "A paraplegic marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home.", "English, Spanish", "USA, UK", "Won 3 Oscars. Another 80 wins & 121 nominations.")
            Filme("I Am Legend", "2007", "PG-13", "14 Dec 2007", "101 min", "Drama, Horror, Sci-Fi", "Francis Lawrence", "Mark Protosevich (screenplay), Akiva Goldsman (screenplay), Richard Matheson (novel), John William Corrington, Joyce Hooper Corrington", "Will Smith, Alice Braga, Charlie Tahan, Salli Richardson-Whitfield", "Years after a plague kills most of humanity and transforms the rest into monsters, the sole survivor in New York City struggles valiantly to find a cure.", "English", "USA", "9 wins & 21 nominations.")
            Filme("300", "2006", "R", "09 Mar 2007", "117 min", "Action, Drama, Fantasy", "Zack Snyder", "Zack Snyder (screenplay), Kurt Johnstad (screenplay), Michael Gordon (screenplay), Frank Miller (graphic novel), Lynn Varley (graphic novel)", "Gerard Butler, Lena Headey, Dominic West, David Wenham", "King Leonidas of Sparta and a force of 300 men fight the Persians at Thermopylae in 480 B.C.", "English", "USA", "16 wins & 42 nominations.")
            Filme("The Avengers", "2012", "PG-13", "04 May 2012", "143 min", "Action, Sci-Fi, Thriller", "Joss Whedon", "Joss Whedon (screenplay), Zak Penn (story), Joss Whedon (story)", "Robert Downey Jr., Chris Evans, Mark Ruffalo, Chris Hemsworth", "Earth's mightiest heroes must come together and learn to fight as a team if they are to stop the mischievous Loki and his alien army from enslaving humanity.", "English, Russian", "USA", "Nominated for 1 Oscar. Another 34 wins & 75 nominations.")
            Filme("The Wolf of Wall Street", "2013", "R", "25 Dec 2013", "180 min", "Biography, Comedy, Crime", "Martin Scorsese", "Terence Winter (screenplay), Jordan Belfort (book)", "Leonardo DiCaprio, Jonah Hill, Margot Robbie, Matthew McConaughey", "Based on the true story of Jordan Belfort, from his rise to a wealthy stock-broker living the high life to his fall involving crime, corruption and the federal government.", "English, French", "USA", "Nominated for 5 Oscars. Another 35 wins & 154 nominations.")
            Filme("Interstellar", "2014", "PG-13", "07 Nov 2014", "169 min", "Adventure, Drama, Sci-Fi", "Christopher Nolan", "Jonathan Nolan, Christopher Nolan", "Ellen Burstyn, Matthew McConaughey, Mackenzie Foy, John Lithgow", "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.", "English", "USA, UK", "Won 1 Oscar. Another 39 wins & 134 nominations.")
            Filme("Game of Thrones", "2011–", "TV-MA", "17 Apr 2011", "56 min", "Adventure, Drama, Fantasy", "N/A", "David Benioff, D.B. Weiss", "Peter Dinklage, Lena Headey, Emilia Clarke, Kit Harington", "While a civil war brews between several noble families in Westeros, the children of the former rulers of the land attempt to rise up to power. Meanwhile a forgotten race, bent on destruction, plans to return after thousands of years in the North.", "English", "USA, UK", "Won 1 Golden Globe. Another 185 wins & 334 nominations.")
            Filme("Vikings", "2013–", "TV-14", "03 Mar 2013", "44 min", "Action, Drama, History", "N/A", "Michael Hirst", "Travis Fimmel, Clive Standen, Gustaf Skarsgård, Katheryn Winnick", "The world of the Vikings is brought to life through the journey of Ragnar Lothbrok, the first Viking to emerge from Norse legend and onto the pages of history - a man on the edge of myth.", "English, Old English, Norse, Old, Latin", "Ireland, Canada", "Nominated for 7 Primetime Emmys. Another 17 wins & 49 nominations.")
            Filme("Gotham", "2014–", "TV-14", "01 Aug 2014", "42 min", "Action, Crime, Drama", "N/A", "Bruno Heller", "Ben McKenzie, Donal Logue, David Mazouz, Sean Pertwee", "The story behind Detective James Gordon's rise to prominence in Gotham City in the years before Batman's arrival.", "English", "USA", "Nominated for 4 Primetime Emmys. Another 3 wins & 22 nominations.")
            Filme("Power", "2014–", "TV-MA", "N/A", "50 min", "Crime, Drama", "N/A", "Courtney Kemp Agboh", "Omari Hardwick, Joseph Sikora, Andy Bean, Lela Loren", "James \"Ghost\" St. Patrick, a wealthy nightclub owner who has it all, catering to the city's elite and dreaming big, lives a double life as a drug kingpin.", "English", "USA", "N/A")
    );

    private final SerieRepository serieRepository;

    public DatabaseInitializer (SerieRepository serieRepository){
        this.serieRepository = serieRepository;
    }

    public static final List<Serie> series = List.of(

    );

    @Override

    public void run(String... args) throws Exception {
        log.info("Alô pepe moreno? o banco ta conectado");
        filmeRepository.saveAll(filmes);
        filmeRepository.findAll().forEach(filme -> System.out.println(filmes));
        serieRepository.saveAll(series);
        serieRepository.findAll().forEach(serie -> System.out.println(series));
    }


}
