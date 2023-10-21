package cinema;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//放映厅
public class Hall {
    public static List<Hall> hallList = new ArrayList<>();
    public static Hall hallObj = null;
    public List<Ticket> ticketList = new ArrayList<>();
    public String name;
    public String[][] seats = new String[8][13];
    public int seatSum = 84;
    public int seatRemaining = 84;
    public int hen;
    public int lie;

    public Hall(String name) {
        this.name = name;
        initSeat();
    }

    public Hall(List<Ticket> ticketList, String name, String[][] seats, int seatSum, int seatRemaining) {
        this.ticketList = ticketList;
        this.name = name;
        this.seats = seats;
        this.seatSum = seatSum;
        this.seatRemaining = seatRemaining;
    }

    //占座
    public void changeSeat(int x,int y){
        this.seats[x][y]="X";
        this.setSeatRemaining(this.getSeatRemaining()-1);
        this.hen=x;
        this.lie=y;

    }

    //恢复座位
    public void reSeat(){
        this.setSeatRemaining(this.getSeatRemaining()+1);
        this.seats[hen][lie]="O";
    }

    //生成电影票的电子随机Id编号
    public String GenerateRandomId(int length) {
        // 验证码字符集
        String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder verificationCode = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            // 从字符集中随机选择一个字符
            char c = characters.charAt(random.nextInt(characters.length()));
            verificationCode.append(c);
        }

        return verificationCode.toString();
    }

    //初始化放映厅座位
    public void initSeat() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 13; j++) {
                this.seats[i][j] = "O";
                if (i != 0 || j != 0) {
                    Ticket ticket = new Ticket();
                    String randomticketId = this.GenerateRandomId(4);
                    ticket.setTicketID(randomticketId);
                    ticket.setSeatnumber("第" + i + "行，第" + j + "列");
                    ticketList.add(ticket);
                }
            }
        }

        for (int i = 0; i < 8; i++) {
            this.seats[i][0] = Integer.toString(i);
        }

        for (int j = 0; j < 13; j++) {
            this.seats[0][j] = Integer.toString(j);
        }

        this.seats[0][0] = "  ";
    }

    //展示放映厅座位
    public void showSeat(Cinema cinema, JTextArea textArea) {
        // 创建一个StringBuilder对象，用于存储放映厅座位信息
        StringBuilder seatInfo = new StringBuilder();
        for (int j = 0; j < 13; j++) {
            seatInfo.append(cinema.getHall().seats[0][j]).append("\t");
        }
        seatInfo.append("\n\n\n\n\n");

        for (int i = 1; i < 8; i++) {
            for (int j = 0; j < 13; j++) {
                seatInfo.append(cinema.getHall().seats[i][j]).append("\t");
            }
            seatInfo.append("\n\n\n\n\n");
        }
        // 将座位信息设置为文本区域的内容
        textArea.setText(seatInfo.toString());
    }

    //确定特定座位的电影票信息
    public void findTicket(Cinema cinema,int x, int y){
        for (Ticket ticket : ticketList) {
            if (ticket.getSeatNumber().equals("第" + x+ "行，第" +y + "列")) {
                cinema.setTicket(ticket);
                break;
            }
        }
    }

    //判断座位是否空余
    public boolean seatFree(int x, int y) {
        if (this.getSeats(x, y).equals("O"))
            return true;
        else return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

    public int getSeatSum() {
        return seatSum;
    }

    public int getSeatRemaining() {
        return seatRemaining;
    }

    public void setSeatRemaining(int seatRemaining) {
        this.seatRemaining = seatRemaining;
    }

    public String getSeats(int x, int y) {
        return seats[x][y];
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

}

