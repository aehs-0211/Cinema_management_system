package administrator;

import java.util.ArrayList;
import java.util.List;

public class Admin {
    public static List<Admin> adminList = new ArrayList<>();
    public static Admin adminObj = null;
    private String account;
    private String password;

    public Admin(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public static void addAdmin(String account, String password) {
        Admin ad = new Admin(account, password);
        adminList.add(ad);
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

}
