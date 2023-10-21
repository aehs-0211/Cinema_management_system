package administrator;

import javax.swing.*;
import java.awt.*;

public class AdminMenu extends JFrame {
    private AdminFunction adminfunction = new AdminFunction();

    public AdminMenu() {
        //创建Jnull实例
        super("管理员功能");
        //设置窗体宽高
        this.setSize(600, 350);
        this.setLocationRelativeTo(null); //设置窗口居中显示
        //设置窗体禁止调节大小
        this.setResizable(false);
        //创建面板
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        JLabel label = new JLabel("管理员，欢迎您!");
        label.setBounds(190, 5, 200, 25);
        label.setFont(new Font("微软雅黑", Font.BOLD, 25));
        label.setForeground(Color.green);
        jPanel.add(label);

        //更改密码功能
        adminfunction.changepassword(jPanel, this);

        //重置用户密码
        adminfunction.resetpassword(jPanel, this);

        //删除用户信息
        adminfunction.delete(jPanel, this);

        //查询用户信息
        JFrame frame1 = new JFrame();
        JPanel jPane2 = new JPanel();
        adminfunction.userInformationJF(frame1, jPane2);
        adminfunction.checkuser(jPanel, this, frame1, jPane2);

        //退出登录
        adminfunction.exit(jPanel, this);
        //关闭窗口结束程序
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        //显示窗口
        this.setVisible(true);

        //添加面板
        this.add(jPanel);
        //设置可见
        this.setVisible(true);
    }
}
