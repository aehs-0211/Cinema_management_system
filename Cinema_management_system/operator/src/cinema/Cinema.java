package cinema;

import java.util.ArrayList;
import java.util.List;

import static cinema.Film.filmList;
import static cinema.Film.filmObj;

//场次
public class Cinema {
    public static List<Cinema> cinemaList = new ArrayList<>();
    public static Cinema cinemaObj = null;
    public static Cinema cinemaLock = null;
    public Film film;
    public Hall hall;
    public Ticket ticket;
    public String showtime;
    public double price;

    public Cinema() {
    }

    public Cinema(Film film, Hall hall, String showtime, double price) {
        this.film = film;
        this.hall = hall;
        this.showtime = showtime;
        this.price = price;
    }

    public static void addCinemas(String filmName,String hallName, String showtime, String prices) {
        filmObj=null;
        for (Film film : filmList) {
            if (film.getName().equals(filmName)) {
                filmObj = film;
                break;
            }
        }
        Hall hall=new Hall(hallName);
        int price=Integer.parseInt(prices);
        Cinema cinema = new Cinema(filmObj,hall, showtime, price);
        cinemaList.add(cinema);
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public String getShowtime() {
        return showtime;
    }

    public void setShowtime(String showtime) {
        this.showtime = showtime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

}
