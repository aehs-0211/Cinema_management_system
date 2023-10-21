package login;

import javax.swing.*;
import java.awt.*;

import static login.LoginJudge.count;

public class ChooseJf {
    public static int choice = 0;

    public ChooseJf() {
        count = 0;
        //创建JFrame实例
        JFrame chooseframe = new JFrame("选择登录方式");
        //设置窗体宽高
        chooseframe.setSize(350, 250);
        //设置窗口居中显示
        chooseframe.setLocationRelativeTo(null);
        //设置关闭窗口结束程序
        chooseframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗体禁止调节大小
        chooseframe.setResizable(false);
        //创建面板
        JPanel jPanel = new JPanel();
        //布局设置为空，之后可以手动设置组件的坐标位置和大小
        jPanel.setLayout(null);
        //添加面板
        chooseframe.add(jPanel);
        JLabel label = new JLabel("欢迎来到影院管理系统!");
        label.setBounds(40, 5, 350, 25);
        label.setFont(new Font("微软雅黑", Font.BOLD, 25));
        label.setForeground(Color.green);
        jPanel.add(label);
        //设置可见
        chooseframe.setVisible(true);
        //选择登录角色
        JButton butt1 = new JButton("管理员登录");
        butt1.setBounds(100, 45, 120, 25);
        jPanel.add(butt1);
        butt1.addActionListener(e -> {
            choice = 1;
            chooseframe.dispose();
            new LoginJF();
        });

        JButton butt2 = new JButton("经理登录");
        butt2.setBounds(100, 80, 120, 25);
        jPanel.add(butt2);
        butt2.addActionListener(e -> {
            choice = 2;
            chooseframe.dispose();
            new LoginJF();
        });

        JButton butt3 = new JButton("前台登录");
        butt3.setBounds(100, 115, 120, 25);
        jPanel.add(butt3);
        butt3.addActionListener(e -> {
            choice = 3;
            chooseframe.dispose();
            new LoginJF();
        });

        JButton butt4 = new JButton("用户登录");
        butt4.setBounds(100, 150, 120, 25);
        jPanel.add(butt4);
        butt4.addActionListener(e -> {
            choice = 0;
            chooseframe.dispose();
            new LoginJF();
        });
    }
}
