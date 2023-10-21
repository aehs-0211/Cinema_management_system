package manager;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    public static List<Manager> manangerList = new ArrayList<>();
    public static Manager manangerObj = null;
    private String account;
    private String password;

    public static void addManager(String account, String password) {
        Manager ma = new Manager(account, password);
        manangerList.add(ma);
    }

    public Manager(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return this.password;
    }

}
