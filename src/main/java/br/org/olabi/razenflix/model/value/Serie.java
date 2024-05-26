package br.org.olabi.razenflix.model.value;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "serie")
public class Serie {

    @Id
    @UuidGenerator
    private UUID id;
    private String title;
    private String totalSeasons;

    @ElementCollection
    private List<String> genre;

    @ElementCollection
    private List<String> writers;

    private String poster;

    @ElementCollection
    private List<String> actors;

    @Embedded
    private Ratings ratings;

    public Serie(String title, String totalSeasons, List<String> genre, List<String> writers, String poster, List<String> actors, Ratings ratings) {
        this.title = title;
        this.totalSeasons = totalSeasons;
        this.genre = genre;
        this.writers = writers;
        this.poster = poster;
        this.actors = actors;
        this.ratings = ratings;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getTotalSeasons() {
        return totalSeasons;
    }

    public List<String> getGenre() {
        return genre;
    }

    public List<String> getWriters() {
        return writers;
    }

    public String getPoster() {
        return poster;
    }

    public List<String> getActors() {
        return actors;
    }

    public Ratings getRatings() {
        return ratings;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTotalSeasons(String totalSeasons) {
        this.totalSeasons = totalSeasons;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    public void setWriters(List<String> writers) {
        this.writers = writers;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public void setRatings(Ratings ratings) {
        this.ratings = ratings;
    }

    @Embeddable
    public static class Ratings {
        private String rating;
        private String likes;

        // Constructors
        public Ratings() {}

        public Ratings(String rating, String likes) {
            this.rating = rating;
            this.likes = likes;
        }

        // Getters and Setters

        public String getRating() {
            return rating;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public String getLikes() {
            return likes;
        }

        public void setLikes(String likes) {
            this.likes = likes;
        }
    }

    protected Serie(){}

    @Override
    public String toString() {
        return "Serie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", totalSeasons='" + totalSeasons + '\'' +
                ", genre='" + genre + '\'' +
                ", writers='" + writers + '\'' +
                ", poster='" + poster + '\'' +
                ", actors='" + actors + '\'' +
                ", ratings='" + ratings + '\'' +
                '}';
    }
}
