package login;

import administrator.Admin;
import administrator.AdminMenu;
import foreground.Foreground;
import foreground.ForegroundMenu;
import manager.Manager;
import manager.ManagerMenu;
import user.User;
import user.UserMenu;

import javax.swing.*;

import static administrator.Admin.adminList;
import static administrator.Admin.adminObj;
import static foreground.Foreground.foregroundList;
import static foreground.Foreground.foregroundObj;
import static login.ChooseJf.choice;
import static manager.Manager.manangerList;
import static manager.Manager.manangerObj;
import static user.User.userList;
import static user.User.userObj;

public class LoginJudge {
    static int count = 0;
    private JTextField jt;//账号输入框对象
    private JPasswordField jp;//密码输入框对象
    private JFrame login;//定义一个窗体对象

    public LoginJudge(JFrame login, JTextField jt, JPasswordField jp) {
        this.login = login;//获取登录界面
        this.jt = jt;//获取登录界面中的账号输入框对象
        this.jp = jp;//获取登录界面中的密码输入框对象
        String username = jt.getText();
        String password = new String(jp.getPassword());
        //用户名密码判断
        switch (choice) {
            case 0:
                judgeUser(username, password);
                break;
            case 1:
                judgeAdmin(username, password);
                break;
            case 2:
                judgeManager(username, password);
                break;
            case 3:
                judgeForeground(username, password);
                break;
        }
    }

    //管理员判断
    public void judgeAdmin(String username, String password) {
        for (Admin ad : adminList) {
            if (ad.getAccount() != null && ad.getAccount().equals(username)) {
                adminObj = ad;
                break;
            }
        }
        if (adminObj != null && adminObj.getPassword().equals(password)) {
            //设置弹框
            JOptionPane.showMessageDialog(null, "登陆成功", "成功", 1);
            new AdminMenu();
            login.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "登录名或密码错误", "失败", 0);
        }
    }

    //经理判断
    private void judgeManager(String username, String password) {
        for (Manager mana : manangerList) {
            if (mana.getAccount() != null && mana.getAccount().equals(username)) {
                manangerObj = mana;
                break;
            }
        }
        if (manangerObj != null && manangerObj.getPassword().equals(password)) {
            //设置弹框
            JOptionPane.showMessageDialog(null, "登陆成功", "成功", 1);
            new ManagerMenu();
            login.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "登录名或密码错误", "失败", 0);
        }
    }

    //前台判断
    private void judgeForeground(String username, String password) {
        for (Foreground fore : foregroundList) {
            if (fore.getAccount() != null && fore.getAccount().equals(username)) {
                foregroundObj = fore;
                break;
            }
        }
        if (foregroundObj != null && foregroundObj.getPassword().equals(password)) {
            //设置弹框
            JOptionPane.showMessageDialog(null, "登陆成功", "成功", 1);
            new ForegroundMenu();
            login.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "登录名或密码错误", "失败", 0);
        }
    }

    //用户判断
    public void judgeUser(String username, String password) {
        userObj = null;
        for (User us : userList) {
            if (us.getAccount() != null && us.getAccount().equals(username)) {
                userObj = us;
                break;
            }
        }
        if (userObj != null && userObj.getPassword().equals(password) && count < 5) {
            //设置弹框
            JOptionPane.showMessageDialog(null, "登陆成功", "成功", 1);
            new UserMenu(userObj);
            login.dispose();
        } else {
            if (count < 5) {
                count++;
                System.out.print("剩余尝试次数：");
                System.out.println(5-count);
                JOptionPane.showMessageDialog(null, "登录名或密码错误", "失败", 0);
            } else {
                JOptionPane.showMessageDialog(null, "此账号已锁定", "失败", 0);
                new ChooseJf();
            }
        }
    }

}
