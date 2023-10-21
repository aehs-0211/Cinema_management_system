package cinema;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ticket {
    String ticketID;
    String seatNumber;
    String ticketState="Y";
    String buyTime;

    public void setBuyTime() {
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        this.buyTime=dateFormat.format(date);
    }

    public String getBuyTime() {
        return buyTime;
    }

    public Ticket() {
    }

    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatnumber(String seatnumber) {
        this.seatNumber = seatnumber;
    }

    public String getTicketState() {
        return ticketState;
    }

    public void setTicketState(String ticketState) {
        this.ticketState = ticketState;
    }

}
