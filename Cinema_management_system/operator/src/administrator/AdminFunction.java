package administrator;

import login.ChooseJf;
import user.User;

import javax.swing.*;

import static administrator.Admin.adminList;
import static administrator.Admin.adminObj;
import static user.User.userList;
import static user.User.userObj;


public class AdminFunction {
    // 查询用户信息
    public void checkuser(JPanel jPanel, JFrame frame, JFrame frame1, JPanel jPane2) {
        JTextArea textArea = new JTextArea();
        textArea.setBounds(0, 0, 800, 730);
        jPane2.add(textArea);

        //查询用户信息按钮
        JButton show = new JButton("查询用户信息");
        show.setBounds(180, 160, 200, 30);
        jPanel.add(show);
        show.addActionListener(e -> {
            StringBuilder userInfo = new StringBuilder();
            for (User account : userList) {
                userInfo.append("用户ID：").append(account.getId()).append("\n");
                userInfo.append("用户名：").append(account.getAccount()).append("\n");
                userInfo.append("级别：").append(account.getVip()).append("\n");
                userInfo.append("注册时间：").append(account.getRegisterTime()).append("\n");
                userInfo.append("累计消费总金额：").append(account.getConsumeSum()).append("\n");
                userInfo.append("累计消费次数：").append(account.getConsumetimes()).append("\n");
                userInfo.append("用户手机号：").append(account.getPhone()).append("\n");
                userInfo.append("用户邮箱：").append(account.getMail()).append("\n\n");
            }
            // 将用户信息显示在文本区域中
            textArea.setText(userInfo.toString());
            frame.setVisible(false);
            frame1.setVisible(true);
        });
        //添加返回按钮
        JButton exit1 = new JButton("返回");
        exit1.setBounds(275, 730, 200, 30);
        jPane2.add(exit1);
        exit1.addActionListener(e -> {
            frame1.setVisible(false);
            frame.setVisible(true);
        });
    }

    //用户信息窗口
    public void userInformationJF(JFrame frame1, JPanel jPane2) {
        // 设置窗体宽高
        frame1.setSize(800, 800);
        frame1.setLocationRelativeTo(null); // 设置窗口居中显示
        // 设置窗体禁止调节大小
        frame1.setResizable(false);
        //布局设置为空，之后可以手动设置组件的坐标位置和大小
        jPane2.setLayout(null);
        // 关闭窗口结束程序
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 显示窗口
        frame1.setVisible(true);
        // 添加面板
        frame1.add(jPane2);
        // 设置可见
        frame1.setVisible(false);
    }

    //更改密码功能
    public void changepassword(JPanel jPanel, JFrame frame) {
        JButton changepw = new JButton("更改密码");
        changepw.setBounds(180, 40, 200, 30);
        jPanel.add(changepw);
        changepw.addActionListener(e -> {
            String ps = JOptionPane.showInputDialog(frame, "请输入新密码：");
            if (adminObj != null) {
                adminObj.setPassword(ps);
                adminList.add(adminObj);
                JOptionPane.showMessageDialog(frame, "更改密码成功！");
                frame.dispose();
                new ChooseJf();
            } else {
                JOptionPane.showMessageDialog(frame, "更改密码失败！");
            }
        });
    }

    //重置用户密码
    public void resetpassword(JPanel jPanel, JFrame frame) {
        JButton resetpw = new JButton("重置用户密码");
        resetpw.setBounds(180, 80, 200, 30);
        jPanel.add(resetpw);
        resetpw.addActionListener(e -> {
            String username = JOptionPane.showInputDialog(null, "请输入要重置密码的用户：");
            for (User acc : userList) {
                if (acc.getAccount().equals(username)) {
                    userObj = acc;
                    break;
                }
            }
            if (!userObj.equals(null)) {
                String initpw = "init0000";
                userObj.setPassword(initpw);
                System.out.println(userObj.getMail() + ",您有一封信邮件:\n" + "影院管理系统：\n" + "    您的密码已重置，重置密码为" + initpw);
                JOptionPane.showMessageDialog(null, "用户密码重置成功！");
            } else {
                JOptionPane.showMessageDialog(null, "账号不存在！");
            }
        });
    }

    //删除用户信息
    public void delete(JPanel jPanel, JFrame frame) {
        JButton deleteButton = new JButton("删除用户信息");
        deleteButton.setBounds(180, 120, 200, 30);
        jPanel.add(deleteButton);
        deleteButton.addActionListener(e -> {
            String username = JOptionPane.showInputDialog(null, "请输入要删除的用户：");
            for (User acc : userList) {
                if (acc.getAccount().equals(username)) {
                    userObj = acc;
                    break;
                }
            }
            if (userObj != null) {
                String waring = JOptionPane.showInputDialog(null, "确认要删除此用户吗？Y/N");
                if (waring.equals("Y")) {
                    userList.remove(userObj);
                    JOptionPane.showMessageDialog(null, "用户信息删除成功！");
                } else {
                    JOptionPane.showMessageDialog(null, "删除用户信息取消！");
                }
            } else {
                JOptionPane.showMessageDialog(null, "账号不存在！");
            }
        });
    }

    //退出登录
    public void exit(JPanel jPanel, JFrame frame) {
        JButton exit = new JButton("退出登录");
        exit.setBounds(180, 200, 200, 30);
        jPanel.add(exit);
        exit.addActionListener(e -> {
            frame.setVisible(false);
            new ChooseJf();

        });
    }
}
