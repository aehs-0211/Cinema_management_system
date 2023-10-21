package manager;

import javax.swing.*;
import java.awt.*;

public class ManagerMenu extends JFrame {
    private ManagerFunction managerFunction = new ManagerFunction();

    public ManagerMenu() {
        //创建JFrame实例
        super("经理功能");
        //设置窗体宽高
        this.setSize(600, 400);
        //设置窗口居中显示
        this.setLocationRelativeTo(null);
        //设置窗体禁止调节大小
        this.setResizable(false);
        //创建面板
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);

        JLabel label = new JLabel("经理，欢迎您!");
        label.setBounds(195, 15, 200, 25);
        label.setFont(new Font("微软雅黑", Font.BOLD, 25));
        label.setForeground(Color.green);
        jPanel.add(label);

        //列出所有正在上映影片的信息
        JFrame frame1 = new JFrame();
        JPanel jPane2 = new JPanel();
        managerFunction.filmInformationJF(frame1, jPane2);
        managerFunction.shoeFilm(jPanel, this, frame1, jPane2);

        //添加影片的信息
        managerFunction.addFilm(jPanel, this);

        //修改电影的信息
        managerFunction.reviseFilm(jPanel, this);

        //删除影片信息
        managerFunction.deleteFilm(jPanel, this);

        //查询影片信息
        JFrame frame3 = new JFrame();
        JPanel jPanel3 = new JPanel();
        managerFunction.filmInformationJF(frame3, jPanel3);
        managerFunction.checkFilm(jPanel, this, frame3, jPanel3);

        //添加场次信息
        managerFunction.addCinema(jPanel, this);

        //修改场次信息
        managerFunction.reviseCinema(jPanel, this);

        //删除场次信息
        managerFunction.deleteCinema(jPanel, this);

        //列出所有场次信息
        JFrame frame2 = new JFrame();
        JPanel jPanel4 = new JPanel();
        managerFunction.filmInformationJF(frame2, jPanel4);
        managerFunction.showCinema(jPanel, this, frame2, jPanel4);

        //退出登录
        managerFunction.exit(jPanel, this);

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
