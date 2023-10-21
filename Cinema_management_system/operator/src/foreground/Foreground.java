package foreground;

import java.util.ArrayList;
import java.util.List;

public class Foreground {
    public static List<Foreground> foregroundList = new ArrayList<>();
    public static Foreground foregroundObj = null;
    private String account;
    private String password;

    public static void addForeground(String account, String password) {
        Foreground fore = new Foreground(account, password);
        foregroundList.add(fore);
    }

    public Foreground(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

}
