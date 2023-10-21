package cinema;

import java.util.ArrayList;
import java.util.List;

public class Film {
    public static List<Film> filmList = new ArrayList<>();
    public static List<Film> relevantFilmList = new ArrayList<>();
    public static Film filmObj = null;
    String name;
    String director;
    String actor;
    String synopsis;
    String duration;

    public Film() {
    }

    public Film(String name, String director, String actor, String synopsis, String duration) {
        this.name = name;
        this.director = director;
        this.actor = actor;
        this.synopsis = synopsis;
        this.duration = duration;
    }

    public static void addFilm(String name, String director, String actor, String synopsis, String duration) {
        Film film = new Film(name, director, actor, synopsis, duration);
        filmList.add(film);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String toString() {
        return name;
    }

}
