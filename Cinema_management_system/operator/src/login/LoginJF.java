package login;

import user.UserFunction;

import javax.swing.*;
import java.awt.*;

import static login.ChooseJf.choice;

public class LoginJF {
    public LoginJF() {
        //创建JFrame实例
        JFrame frame = new JFrame("登录");
        //设置窗体宽高
        frame.setSize(350, 200);
        //设置窗口居中显示
        frame.setLocationRelativeTo(null);
        //设置关闭窗口结束程序
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗体禁止调节大小
        frame.setResizable(false);
        //创建面板
        JPanel jPanel = new JPanel();
        //布局设置为空，之后可以手动设置组件的坐标位置和大小
        jPanel.setLayout(null);

        //创建JLabel(用户名)
        JLabel user_label = new JLabel("用户名:");
        user_label.setFont(new Font("微软雅黑", 0, 13));
        //定义组件的位置和宽高
        user_label.setBounds(10, 20, 80, 25);
        //把组件添加到JPanel上
        jPanel.add(user_label);

        //创建文本域用于用户输入
        JTextField user_text = new JTextField(20);
        //设置文本域的位置和宽高
        user_text.setBounds(100, 20, 165, 25);
        //把文本域组件添加上
        jPanel.add(user_text);

        //创建JLabel(密码)
        JLabel password_label = new JLabel("密码:");
        password_label.setFont(new Font("微软雅黑", 0, 13));
        //设置位置和大小
        password_label.setBounds(10, 50, 80, 25);
        //添加组件
        jPanel.add(password_label);
        //添加面板
        frame.add(jPanel);
        //设置可见
        frame.setVisible(true);

        // 密码文本域输入
        JPasswordField password_text = new JPasswordField();  // 密码输入框，输入密码自动隐藏
        password_text.setBounds(100, 50, 165, 25);
        jPanel.add(password_text);

        // 显示密码按钮
        JToggleButton showPasswordButton = new JToggleButton();
        showPasswordButton.setBounds(275, 50, 25, 25);
        jPanel.add(showPasswordButton);
        showPasswordButton.addActionListener(e -> {
            if (showPasswordButton.isSelected()) {
                password_text.setEchoChar((char) 0);  // 显示密码
            } else {
                password_text.setEchoChar('•');  // 隐藏密码
            }
        });

        //登录按钮
        JButton login = new JButton("登录");
        login.setBounds(80, 100, 80, 25);
        login.addActionListener(e -> {
            new LoginJudge(frame, user_text, password_text);
        });

        //注册按钮
        JButton register = new JButton("注册");
        register.setBounds(200, 100, 82, 25);
        register.addActionListener(e -> {
            new RegisterJF();
        });

        //返回按钮
        JButton back = new JButton("返回");
        back.setBounds(200, 100, 80, 25);
        back.addActionListener(e -> {
            frame.dispose();
            new ChooseJf();
        });

        //不同用户登录界面按钮显示设置
        if (choice == 0) {
            jPanel.add(register);
            back.setBounds(80, 130, 80, 25);
            jPanel.add(back);
            new UserFunction().resetPassword(user_text,jPanel, frame);
        } else {
            jPanel.add(back);
        }

        jPanel.add(login);
    }
}



