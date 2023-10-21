package user;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
    public static List<User> userList = new ArrayList<>();
    public static User userObj = null;
    public String id;
    public String vip;
    public double disCount;
    public double consumeSum;
    public int consumeTimes;
    public String phone;
    public String mail;
    public String registerTime;
    private String account;
    private String password;

    //根据总消费更换VIP级别
    public void changeVip(){
        if(this.consumeSum>0&&this.consumeSum<50){
            this.setVip("铜牌用户");
        }else if (this.consumeSum>50&&this.consumeSum<100){
            this.setVip("银牌用户");
        }else if (this.consumeSum>100) {
            this.setVip("金牌用户");
        }
    }

    //根据VIP级别获得折扣
    public double getDisCount() {
        if(this.getVip().equals("金牌用户")){
            this.setDisCount(0.88);
        }else if (this.getVip().equals("银牌用户")){
            this.setDisCount(0.95);
        }else {
            this.setDisCount(1);
        }
        return disCount;
    }

    public User(String account, String password,String phone,String mail) {
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        this.account = account;
        this.password = password;
        this.registerTime=dateFormat.format(date);
        this.id = "00" + (userList.size() + 1);
        this.vip = "铜牌用户";
        this.consumeSum = 0;
        this.consumeTimes = 0;
        this.phone = phone;
        this.mail = mail;
    }

    public User(String account, String password) {
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        this.account = account;
        this.password = password;
        this.registerTime=dateFormat.format(date);
        this.id = "00" + (userList.size() + 1);
        this.vip = "铜牌用户";
        this.consumeSum = 0;
        this.consumeTimes = 0;
        this.phone = "null";
        this.mail = "null";
    }

    public User(String account, String password, String id, String vip, double consumesum, int consumetimes, String phone, String mail) {
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        this.account = account;
        this.password = password;
        this.id = id;
        this.vip = vip;
        this.registerTime=dateFormat.format(date);
        this.consumeSum = consumesum;
        this.consumeTimes = consumetimes;
        this.phone = phone;
        this.mail = mail;
    }

    public static void addUser(String account, String password) {
        User us = new User(account, password);
        userList.add(us);
    }

    public static void addUser(String account, String password,String phone,String email) {
        User us = new User(account, password,phone,email);
        userList.add(us);
    }

    public static void addUsers(String account, String password, String id, String vip, double consumesum, int consumetimes, String phone, String mail) {
        User us = new User(account, password, id, vip, consumesum, consumetimes, phone, mail);
        userList.add(us);
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public String getId() {
        return id;
    }

    public String getVip() {
        return vip;
    }

    public void setVip(String vip) {
        this.vip = vip;
    }

    public double getConsumeSum() {
        return consumeSum;
    }

    public void setConsumeSum(double consumeSum) {
        this.consumeSum = consumeSum;
    }

    public int getConsumetimes() {
        return consumeTimes;
    }

    public String getPhone() {
        return phone;
    }

    public String getMail() {
        return mail;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConsumeTimes(int consumeTimes) {
        this.consumeTimes = consumeTimes;
    }

    public void setDisCount(double disCount) {
        this.disCount = disCount;
    }
}
