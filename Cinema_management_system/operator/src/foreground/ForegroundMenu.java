package foreground;

import javax.swing.*;
import java.awt.*;

public class ForegroundMenu extends JFrame {
    private ForegroundFunction foregroundFunction=new ForegroundFunction();

    public ForegroundMenu() {
        //创建JFrame实例
        super("前台功能");
        //设置窗体宽高
        this.setSize(600, 400);
        this.setLocationRelativeTo(null); //设置窗口居中显示
        //设置窗体禁止调节大小
        this.setResizable(false);
        //创建面板
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);

        JLabel label = new JLabel("欢迎来到前台!");
        label.setBounds(195, 10, 200, 25);
        label.setFont(new Font("微软雅黑", Font.BOLD, 25));
        label.setForeground(Color.green);
        jPanel.add(label);

        //查看所有电影放映信息
        JFrame frame2 = new JFrame();
        JPanel jPanel4 = new JPanel();
        foregroundFunction.filmInformationJF(frame2, jPanel4);
        foregroundFunction.showFilm(jPanel, this, frame2, jPanel4);

        //列出所有场次信息
        JFrame frame5 = new JFrame();
        JPanel jPanel5 = new JPanel();
        foregroundFunction.filmInformationJF(frame5, jPanel5);
        foregroundFunction.showCinema(jPanel, this, frame5, jPanel5);

        //列出指定电影和场次的信息
        JFrame frame6 = new JFrame();
        JPanel jPanel6 = new JPanel();
        foregroundFunction.filmInformationJF(frame6, jPanel6);
        foregroundFunction.showOneCinema(jPanel, this, frame6, jPanel6);

        //售票
        JFrame frame7 = new JFrame();
        JPanel jPanel7 = new JPanel();
        foregroundFunction.filmInformationJF(frame7, jPanel7);
        foregroundFunction.saleTicket(jPanel, this, frame7, jPanel7);

        //退出登录
        foregroundFunction.exit(jPanel,this);

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
