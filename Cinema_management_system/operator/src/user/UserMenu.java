package user;

import javax.swing.*;
import java.awt.*;

public class UserMenu extends JFrame{
    private UserFunction userFunction=new UserFunction();
    private StringBuilder userInfo = new StringBuilder();
    public  UserMenu(User user) {
        //创建JFrame实例
        super("用户功能");
        //设置窗体宽高
        this.setSize(600, 450);
        //设置窗口居中显示
        this.setLocationRelativeTo(null);
        //设置窗体禁止调节大小
        this.setResizable(false);
        //创建面板
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        JLabel label = new JLabel("欢迎您!");
        label.setBounds(240, 5, 100, 25);
        label.setFont(new Font("微软雅黑", Font.BOLD, 25));
        label.setForeground(Color.green);
        jPanel.add(label);
        //关闭窗口结束程序
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        //显示窗口
        this.setVisible(true);
        //添加面板
        this.add(jPanel);
        //设置可见
        this.setVisible(true);

        //修改密码
        userFunction.revisepassword(user,jPanel,this);

        //查看所有电影放映信息
        JFrame frame2 = new JFrame();
        JPanel jPanel4 = new JPanel();
        userFunction.filmInformationJF(frame2, jPanel4);
        userFunction.show(jPanel, this, frame2, jPanel4);

        //查看指定电影放映信息
        JFrame frame3 = new JFrame();
        JPanel jPanel3 = new JPanel();
        userFunction.filmInformationJF(frame3, jPanel3);
        userFunction.showone(jPanel, this, frame3, jPanel3);

        //选定场次后查看座位信息
        JFrame frame8= new JFrame();
        JPanel jPanel8 = new JPanel();
        userFunction.filmInformationJF(frame8, jPanel8);
        userFunction.seat(jPanel, this, frame8, jPanel8);

        //付账
        JFrame frame6 = new JFrame();
        JPanel jPanel6 = new JPanel();
        userFunction.filmInformationJF(frame6, jPanel6);
        userFunction.buy(userInfo,jPanel, this, frame6, jPanel6);

        //取票
        JFrame frame7 = new JFrame();
        JPanel jPanel7 = new JPanel();
        userFunction.filmInformationJF(frame7, jPanel7);
        userFunction.taketicket(jPanel, this, frame7, jPanel7);

        //查看购票历史
        JFrame frame9 = new JFrame();
        JPanel jPanel9 = new JPanel();
        userFunction.filmInformationJF(frame9, jPanel9);
        userFunction.checkHistory(userInfo,jPanel, this, frame9, jPanel9);

        //退出登录
        userFunction.exit(jPanel,this);
    }
}
