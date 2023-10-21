package login;

import user.User;

import javax.swing.*;
import java.awt.*;
import java.util.regex.Pattern;

import static user.User.addUser;
import static user.User.userList;

public class RegisterJF extends JFrame{

    public RegisterJF() {
        // 创建JFrame实例
        super("注册");
        // 设置窗体宽高
        this.setSize(800, 400);
        // 设置窗口居中显示
        this.setLocationRelativeTo(null);
        // 设置窗体禁止调节大小
        this.setResizable(false);
        // 创建面板
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);

        JLabel label = new JLabel("注册页面");
        label.setBounds(320, 30, 250, 30);
        label.setFont(new Font("微软雅黑", Font.BOLD, 30));
        label.setForeground(Color.green);
        jPanel.add(label);
        // 关闭窗口结束程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 显示窗口
        this.setVisible(true);

        // 添加面板
        this.add(jPanel);
        // 设置可见
        this.setVisible(true);

        JButton addButton = new JButton("注册新账号");
        addButton.setBounds(280, 100, 200, 30);
        jPanel.add(addButton);

        addButton.addActionListener(e -> {
            boolean accountRepeat = true;
            String username = null;
            while (accountRepeat) {
                username = JOptionPane.showInputDialog(null, "请输入账号：");
                // 验证用户名长度
                if (!Pattern.matches(".{5,}", username)) {
                    JOptionPane.showMessageDialog(null, "用户名长度不少于5个字符");
                    username = JOptionPane.showInputDialog(null, "请输入账号：");
                }
                for (User uacc : userList) {
                    if (uacc.getAccount() != null && uacc.getAccount().equals(username)) {
                        accountRepeat = true;
                        break;
                    } else {
                        accountRepeat = false;
                    }
                }
                if (accountRepeat) {
                    JOptionPane.showMessageDialog(null, "账号已存在！");
                }
            }
            String password = JOptionPane.showInputDialog(null, "请输入密码：");
            while (!Pattern.matches("^(?=.*\\d)(?=.*[a-zA-Z])[A-Za-z\\d]{8,}$", password)) {
                password = JOptionPane.showInputDialog(null, "密码长度必须大于8个字符，并且必须是大小写字母、数字和标点符号的组合,请重新输入密码：");
            }
            String phone = JOptionPane.showInputDialog(null, "新用户欢迎您！为了您的账号安全，请绑定您的手机号：");
            String email = JOptionPane.showInputDialog(null, "请绑定您的邮箱：");
            addUser(username, password,phone,email);
            JOptionPane.showMessageDialog(null, "注册成功！");
            this.dispose();
        });

        //添加返回按钮
        JButton exit1 = new JButton("返回");
        exit1.setBounds(280, 200, 200, 30);
        jPanel.add(exit1);
        exit1.addActionListener(e -> {
            this.setVisible(false);
        });
    }

}