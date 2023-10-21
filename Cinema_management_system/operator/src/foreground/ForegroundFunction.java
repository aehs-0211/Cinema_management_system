package foreground;

import cinema.Cinema;
import cinema.Film;
import login.ChooseJf;
import user.User;

import javax.swing.*;

import static cinema.Cinema.cinemaList;
import static cinema.Cinema.cinemaObj;
import static cinema.Film.filmList;
import static user.User.userList;
import static user.User.userObj;

public class ForegroundFunction {
    //影片(场次)信息窗口
    public void filmInformationJF(JFrame frame1, JPanel jPane2) {
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

    //列出所有正在上映影片的信息
    public void showFilm(JPanel jPanel, JFrame frame, JFrame frame1, JPanel jPane2) {
        JTextArea textArea = new JTextArea();
        textArea.setBounds(0, 0, 800, 730);
        jPane2.add(textArea);
        JButton shoeFilm = new JButton("列出所有正在上映影片的信息");
        shoeFilm.setBounds(180, 50, 200, 30);
        jPanel.add(shoeFilm);
        shoeFilm.addActionListener(e -> {
            StringBuilder userInfo = new StringBuilder();
            for (Film film : filmList) {
                userInfo.append("片名：").append(film.getName()).append("\n");
                userInfo.append("导演：").append(film.getDirector()).append("\n");
                userInfo.append("主演：").append(film.getActor()).append("\n");
                userInfo.append("剧情简介：").append(film.getSynopsis()).append("\n");
                userInfo.append("时长：").append(film.getDuration()).append("\n\n");
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

    //列出所有场次的信息
    public void showCinema(JPanel jPanel, JFrame frame, JFrame frame1, JPanel jPane2) {
        JTextArea textArea = new JTextArea();
        textArea.setBounds(0, 0, 800, 730);
        jPane2.add(textArea);
        JButton showCinema = new JButton("列出所有场次信息");
        showCinema.setBounds(180, 100, 200, 30);
        jPanel.add(showCinema);
        showCinema.addActionListener(e -> {
            StringBuilder userInfo = new StringBuilder();
            for (Cinema cinema : cinemaList) {
                userInfo.append("片名：").append(cinema.getFilm()).append("\n");
                userInfo.append("放映厅：").append(cinema.getHall()).append("\n");
                userInfo.append("时段：").append(cinema.getShowtime()).append("\n");
                userInfo.append("价格：").append(cinema.getPrice()).append("\n\n");
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

    //列出指定电影和场次的信息
    public void showOneCinema(JPanel jPanel, JFrame frame, JFrame frame1, JPanel jPane2) {
        JTextArea textArea = new JTextArea();
        frame1.setTitle("场次座位信息");
        frame1.setSize(1100, 800);
        textArea.setBounds(0, 0, 1100, 730);
        jPane2.add(textArea);
        JButton show = new JButton("列出指定电影和场次的信息");
        show.setBounds(180, 150, 200, 30);
        jPanel.add(show);
        show.addActionListener(e -> {
            cinemaObj = null;
            StringBuilder userInfo = new StringBuilder();
            String filmName = JOptionPane.showInputDialog(null, "请输入要查询的影片名字：");
            String shoeTime = JOptionPane.showInputDialog(null, "请输入查询的场次的时段：");
            for (Cinema cinema : cinemaList) {
                if (cinema.getFilm().getName().equals(filmName) && cinema.getShowtime().equals(shoeTime)) {
                    cinemaObj = cinema;
                    break;
                }
            }
            if (cinemaObj != null) {
                JOptionPane.showMessageDialog(null, "查询成功！");
                cinemaObj.getHall().showSeat(cinemaObj, textArea);
                textArea.append("\t\t\t\t\t总座位数：" + cinemaObj.getHall().getSeatSum() + "\t\t");
                textArea.append("空闲座位数:" + cinemaObj.getHall().getSeatRemaining());
                frame.setVisible(false);
                frame1.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "未查询到相关信息！");
            }
        });
        //添加返回按钮
        JButton exit1 = new JButton("返回");
        exit1.setBounds(490, 730, 82, 30);
        jPane2.add(exit1);
        exit1.addActionListener(e -> {
            frame1.setVisible(false);
            frame.setVisible(true);
        });
    }

    //售票
    public void saleTicket(JPanel jPanel, JFrame frame, JFrame frame1, JPanel jPane2) {
        JTextArea textArea = new JTextArea();
        frame1.setSize(400, 400);
        frame1.setLocationRelativeTo(null);
        textArea.setBounds(0, 0, 400, 330);
        jPane2.add(textArea);
        JButton sale = new JButton("售票");
        sale.setBounds(180, 200, 200, 30);
        jPanel.add(sale);

        sale.addActionListener(e -> {
            cinemaObj = null;
            String filmName = JOptionPane.showInputDialog(null, "请输入片名：");
            String shoeTime = JOptionPane.showInputDialog(null, "请输入场次：");
            for (Cinema cinema : cinemaList) {
                if (cinema.getFilm().getName().equals(filmName) && cinema.getShowtime().equals(shoeTime)) {
                    cinemaObj = cinema;
                    break;
                }
            }
            if (cinemaObj != null) {
                int x = Integer.parseInt(JOptionPane.showInputDialog(null, "请输入要购买第几行的座位："));
                int y = Integer.parseInt(JOptionPane.showInputDialog(null, "请输入要购买第几列的座位："));
                if (x <= 7 && x > 0 && y > 0 && y <= 12) {
                    boolean seatFree = cinemaObj.getHall().seatFree(x, y);
                    if (seatFree) {
                        cinemaObj.getHall().findTicket(cinemaObj,x, y);
                        userObj = null;
                        String userName = JOptionPane.showInputDialog(null, "请输入要购票的用户名：");
                        String phone = JOptionPane.showInputDialog(null, "请输入该用户的手机号：");
                        for (User user : userList) {
                            if (user.getAccount().equals(userName) && user.getPhone().equals(phone)) {
                                userObj = user;
                                break;
                            }
                        }
                        if (userObj != null) {
                            String consumes = JOptionPane.showInputDialog(null, "您当前购买此票需要" + cinemaObj.getPrice() * userObj.getDisCount() + "元，请输入支付金额：");
                            double consume = Double.parseDouble(consumes);
                            if (cinemaObj.getPrice() * userObj.getDisCount() == consume) {
                                System.out.println("您有一条新消息：\n    微信支付" + cinemaObj.getPrice() * userObj.getDisCount() + "元，您在影院管理系统购票成功,您的电影票的电子ID编号为：" + cinemaObj.getTicket().getTicketID());
                                JOptionPane.showMessageDialog(null, "购买成功,您的电影票的电子ID编号为：" + cinemaObj.getTicket().getTicketID());
                                //展示电影票信息
                                StringBuilder userInfo = new StringBuilder();
                                userInfo.append("片名：").append(cinemaObj.getFilm().getName()).append("\n");
                                userInfo.append("场次：").append(cinemaObj.getShowtime()).append("\n");
                                userInfo.append("座位：").append(cinemaObj.getTicket().getSeatNumber()).append("\n");
                                userInfo.append("票价：").append(cinemaObj.getPrice()).append("\n");
                                userInfo.append("电子ID编号：").append(cinemaObj.getTicket().getTicketID()).append("\n\n");
                                userObj.setConsumeSum(userObj.getConsumeSum() + consume);
                                userObj.setConsumeTimes(userObj.getConsumetimes() + 1);
                                userObj.changeVip();
                                cinemaObj.getHall().changeSeat(x, y);
                                // 将用户信息显示在文本区域中
                                textArea.setText(userInfo.toString());
                                frame.setVisible(false);
                                frame1.setVisible(true);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "用户名或手机号输入错误！");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "此座位已售出！");
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "请检查您输入的座位行和列是否正确！（0<行<8,0<列<13）");
                }
            } else {
                JOptionPane.showMessageDialog(null, "未搜索到相关信息，请检查电影名或场次是否输入错误。");
            }
        });
        //添加返回按钮
        JButton exit1 = new JButton("返回");
        exit1.setBounds(170, 330, 82, 30);
        jPane2.add(exit1);
        exit1.addActionListener(e -> {
            frame1.setVisible(false);
            frame.setVisible(true);
        });
    }

    //退出登录
    public void exit(JPanel jPanel, JFrame frame) {
        JButton exit = new JButton("退出登录");
        exit.setBounds(180, 250, 200, 30);
        jPanel.add(exit);

        exit.addActionListener(e -> {
            frame.dispose();
            new ChooseJf();
        });
    }
}
