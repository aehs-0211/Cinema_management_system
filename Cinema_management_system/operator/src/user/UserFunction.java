package user;

import cinema.Cinema;
import cinema.Film;
import cinema.Ticket;
import login.ChooseJf;
import login.LoginJF;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.regex.Pattern;

import static cinema.Cinema.*;
import static cinema.Film.filmList;
import static cinema.Film.relevantFilmList;
import static user.User.userList;
import static user.User.userObj;

public class UserFunction {

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

    //查看所有电影放映信息
    public void show(JPanel jPanel, JFrame frame, JFrame frame1, JPanel jPane2) {
        JTextArea textArea = new JTextArea();
        textArea.setBounds(0, 0, 800, 730);
        jPane2.add(textArea);
        JButton shoeFilm = new JButton("列出所有正在上映影片的信息");
        shoeFilm.setBounds(180, 80, 200, 30);
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

    //添加购票历史
    public void addHistory(StringBuilder userInfo, Cinema cinema) {
        userInfo.append("片名：").append(cinema.getFilm().getName()).append("\n");
        userInfo.append("场次：").append(cinema.getShowtime()).append("\n");
        userInfo.append("座位：").append(cinema.getTicket().getSeatNumber()).append("\n");
        userInfo.append("票价：").append(cinema.getPrice()).append("\n");
        userInfo.append("购买时间：").append(cinema.getTicket().getBuyTime()).append("\n");
        userInfo.append("电子ID编号：").append(cinema.getTicket().getTicketID()).append("\n\n");
    }

    //修改密码
    public void revisepassword(User user, JPanel jPanel, JFrame frame) {
        JButton revisepw = new JButton("修改密码");
        revisepw.setBounds(180, 40, 200, 30);
        jPanel.add(revisepw);

        revisepw.addActionListener(e -> {
            String oldpassword = JOptionPane.showInputDialog(null, "请输入原密码：");
            if (user.getPassword().equals(oldpassword)) {
                String newpassword = JOptionPane.showInputDialog(null, "请输入新密码：");
                while (!Pattern.matches("^(?=.*\\d)(?=.*[a-zA-Z])[A-Za-z\\d]{8,}$", newpassword)) {
                    newpassword = JOptionPane.showInputDialog(null, "密码长度必须大于8个字符，并且必须是大小写字母、数字和标点符号的组合,请重新输入密码：");
                }
                user.setPassword(newpassword);
                JOptionPane.showMessageDialog(null, "密码重置成功！");
                frame.dispose();
                new LoginJF();
            } else {
                JOptionPane.showMessageDialog(null, "原密码错误！");
            }
        });
    }

    //重置密码
    public void resetPassword(JTextField user_text,JPanel jPanel, JFrame frame) {
        JButton resetpw = new JButton("忘记密码");
        resetpw.setBounds(200, 130, 82, 25);
        jPanel.add(resetpw);

        resetpw.addActionListener(e -> {
            userObj=null;
            for (User user:userList) {
                if(user_text.getText().equals(user.getAccount())){
                    userObj=user;
                    break;
                }
            }
            if(userObj!=null) {
                String mail = JOptionPane.showInputDialog(frame, "请输入您的邮箱：");
                if (userObj.getMail().equals(mail)) {
                    String resetpassword = GenerateRandomPasswords(8);
                    userObj.setPassword(resetpassword);
                    JOptionPane.showMessageDialog(frame, "密码重置成功！");
                    System.out.println(userObj.getMail() + ",您有一封信邮件:\n" + "影院管理系统：\n" + "    您正在重置密码，新密码为" + resetpassword);
                    frame.dispose();
                    new LoginJF();
                } else {
                    JOptionPane.showMessageDialog(frame, "邮箱错误！");
                }
            }else{
                JOptionPane.showMessageDialog(frame, "此账号不存在，请先注册账号！");
            }
        });
    }

    //生成随机密码
    public String GenerateRandomPasswords(int length) {
        // 验证码字符集
        String characters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%&";
        StringBuilder verificationCode = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            // 从字符集中随机选择一个字符
            char c = characters.charAt(random.nextInt(characters.length()));
            verificationCode.append(c);
        }

        return verificationCode.toString();
    }

    //查看指定电影放映信息
    public void showone(JPanel jPanel, JFrame frame, JFrame frame1, JPanel jPane2) {
        JTextArea textArea = new JTextArea();
        textArea.setBounds(0, 0, 800, 730);
        jPane2.add(textArea);

        //查询影片信息按钮
        JButton show = new JButton("查询影片信息");
        show.setBounds(180, 120, 200, 30);
        jPanel.add(show);
        show.addActionListener(e -> {
            relevantFilmList.clear();
            StringBuilder userInfo = new StringBuilder();
            Object[] objects = {"片名", "导演", "主演"};
            String checkChoice = (String) JOptionPane.showInputDialog(null, "请选择查找的内容\n", "相关内容",
                    JOptionPane.PLAIN_MESSAGE, new ImageIcon("icon.png"), objects, "片名");
            int checkChoiceNumber;
            if (checkChoice.equals("片名")) {
                checkChoiceNumber = 1;
            } else if (checkChoice.equals("导演")) {
                checkChoiceNumber = 2;
            } else if (checkChoice.equals("主演")) {
                checkChoiceNumber = 3;
            } else {
                checkChoiceNumber = 0;
            }
            if (checkChoiceNumber == 1) {
                String name = JOptionPane.showInputDialog(null, "请输入要查找的影片名字：");
                for (Film film : filmList) {
                    if (film.getName().equals(name)) {
                        relevantFilmList.add(film);
                    }
                }
            } else if (checkChoiceNumber == 2) {
                String director = JOptionPane.showInputDialog(null, "请输入要查找的影片导演：");
                for (Film film : filmList) {
                    if (film.getDirector().equals(director)) {
                        relevantFilmList.add(film);
                        break;
                    }
                }
            } else if (checkChoiceNumber == 3) {
                String actor = JOptionPane.showInputDialog(null, "请输入要查找的影片主演：");
                for (Film film : filmList) {
                    if (film.getActor().equals(actor)) {
                        relevantFilmList.add(film);
                    }
                }
            }
            if (!relevantFilmList.isEmpty()) {
                JOptionPane.showMessageDialog(null, "查询成功！");
                for (Film film : relevantFilmList) {
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
            } else {
                JOptionPane.showMessageDialog(null, "未查询到相关信息！");
            }
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

    //选定场次和座位
    public void seat(JPanel jPanel, JFrame frame, JFrame frame1, JPanel jPane2) {
        JTextArea textArea = new JTextArea();
        frame1.setTitle("场次座位信息");
        frame1.setSize(1100, 800);
        textArea.setBounds(0, 0, 1100, 730);
        jPane2.add(textArea);
        JButton seat = new JButton("选择场次座位");
        seat.setBounds(180, 160, 200, 30);
        jPanel.add(seat);

        seat.addActionListener(e -> {
            cinemaLock = null;
            String showTime = JOptionPane.showInputDialog(null, "请输入场次：");
            for (Cinema cinema : cinemaList) {
                if (cinema.getShowtime().equals(showTime)) {
                    cinemaLock = cinema;
                    break;
                }
            }
            if (cinemaLock != null) {
                JOptionPane.showMessageDialog(null, "该场次座位信息如下！");
                cinemaLock.getHall().showSeat(cinemaLock, textArea);
                textArea.append("\t\t\t\t\t总座位数：" + cinemaLock.getHall().getSeatSum() + "\t\t");
                textArea.append("空闲座位数:" + cinemaLock.getHall().getSeatRemaining());
                frame.setVisible(false);
                frame1.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "未查询到相关信息！");
            }
        });
        //添加选择按钮
        JButton choose = new JButton("选择");
        choose.setBounds(400, 730, 82, 30);
        jPane2.add(choose);
        choose.addActionListener(e -> {
            int x = Integer.parseInt(JOptionPane.showInputDialog(null, "请输入要购买第几行的座位："));
            int y = Integer.parseInt(JOptionPane.showInputDialog(null, "请输入要购买第几列的座位："));
            if (x <= 7 && x > 0 && y > 0 && y <= 12) {
                if (cinemaLock.getHall().seatFree(x, y)) {
                    cinemaLock.getHall().findTicket(cinemaLock, x, y);
                    cinemaLock.getHall().changeSeat(x, y);
                    cinemaLock.getTicket().setBuyTime();
                    frame.setVisible(true);
                    frame1.setVisible(false);
                    JOptionPane.showMessageDialog(null, "您所选的座位已锁定，请在两分钟内完成支付！");
                } else {
                    JOptionPane.showMessageDialog(null, "此座位已售出！");
                }
            } else {
                JOptionPane.showMessageDialog(null, "请检查您输入的座位行和列是否正确！（0<行<8,0<列<13）");
            }
        });

        //添加返回按钮
        JButton exit1 = new JButton("返回");
        exit1.setBounds(600, 730, 82, 30);
        jPane2.add(exit1);
        exit1.addActionListener(e -> {
            frame1.setVisible(false);
            frame.setVisible(true);
        });
    }

    //支付
    public void buy(StringBuilder userInfo,JPanel jPanel, JFrame frame, JFrame frame1, JPanel jPane2) {
        JTextArea textArea = new JTextArea();
        frame1.setTitle("场次座位信息");
        frame1.setSize(1100, 800);
        textArea.setBounds(0, 0, 1100, 730);
        jPane2.add(textArea);
        JButton buy = new JButton("支付");
        buy.setBounds(180, 200, 200, 30);
        jPanel.add(buy);

        buy.addActionListener(e -> {
            if (cinemaLock != null) {
                Date date = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
                Date date1 = null;
                Date date2 = null;
                try {
                    date1 = dateFormat.parse(dateFormat.format(date));
                    date = dateFormat.parse(cinemaLock.getTicket().getBuyTime());
                    Calendar calendar = Calendar.getInstance(); // 获取Calendar实例
                    calendar.setTime(date); // 设置为当前时间
                    calendar.add(Calendar.MINUTE, 2); // 增加2分钟
                    date2 = calendar.getTime(); // 将Calendar类型转换为Date类型
                } catch (Exception w) {
                    w.printStackTrace();
                }
                assert date1 != null;
                if (date1.before(date2)) {
                    userObj = null;
                    String phone = JOptionPane.showInputDialog(null, "请输入手机号：");
                    for (User user : userList) {
                        if (user.getPhone().equals(phone)) {
                            userObj = user;
                            break;
                        }
                    }
                    if (userObj != null) {
                        String consumes = JOptionPane.showInputDialog(null, "您当前购买此票需要" + cinemaLock.getPrice() * userObj.getDisCount() + "元，请输入支付金额：");
                        double consume = Double.parseDouble(consumes);
                        if (cinemaLock.getPrice() * userObj.getDisCount() == consume) {
                            frame1.dispose();
                            frame.setVisible(true);
                            cinemaLock.getTicket().setBuyTime();
                            addHistory(userInfo, cinemaLock);
                            System.out.println("您有一条新消息：\n    微信支付" + cinemaLock.getPrice() * userObj.getDisCount() + "元，您在影院管理系统购票成功，您的电影票的电子ID编号为：" + cinemaLock.getTicket().getTicketID());
                            JOptionPane.showMessageDialog(null, "购买成功，您的电影票的电子ID编号为：" + cinemaLock.getTicket().getTicketID());
                            userObj.setConsumeSum(userObj.getConsumeSum() + consume);
                            userObj.setConsumeTimes(userObj.getConsumetimes() + 1);
                            userObj.changeVip();
                            cinemaLock = null;
                        } else {
                            JOptionPane.showMessageDialog(null, "支付金额输入错误！");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "此座位已售出！");
                    }
                } else {
                    cinemaLock.getHall().reSeat();
                    cinemaLock = null;
                    JOptionPane.showMessageDialog(null, "支付超时，该座位已释放，请重新选择场次座位！");
                }
            } else {
                JOptionPane.showMessageDialog(null, "请先选定场次和座位号！");
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

    //取票
    public void taketicket(JPanel jPanel, JFrame frame, JFrame frame1, JPanel jPane2) {
        JTextArea textArea = new JTextArea();
        frame1.setSize(400, 400);
        frame1.setLocationRelativeTo(null);
        textArea.setBounds(0, 0, 400, 330);
        jPane2.add(textArea);
        JButton taketicket = new JButton("取票");
        taketicket.setBounds(180, 240, 200, 30);
        jPanel.add(taketicket);

        taketicket.addActionListener(e -> {
            cinemaObj = null;
            String id = JOptionPane.showInputDialog(null, "请输入电影票的电子ID编号：");
            for (Cinema cinema : cinemaList) {
                for (Ticket ticket : cinema.getHall().getTicketList()) {
                    if (ticket.getTicketID().equals(id)) {
                        cinemaObj = cinema;
                        cinemaObj.setTicket(ticket);
                        break;
                    }
                }
            }
            if (cinemaObj != null) {
                if (cinemaObj.getTicket().getTicketState().equals("Y")) {
                    JOptionPane.showMessageDialog(null, "取票成功！");
                    StringBuilder userInfo = new StringBuilder();
                    userInfo.append("片名：").append(cinemaObj.getFilm().getName()).append("\n");
                    userInfo.append("场次：").append(cinemaObj.getShowtime()).append("\n");
                    userInfo.append("座位：").append(cinemaObj.getTicket().getSeatNumber()).append("\n");
                    userInfo.append("票价：").append(cinemaObj.getPrice()).append("\n");
                    userInfo.append("购票时间：").append(cinemaObj.getTicket().getBuyTime()).append("\n");
                    userInfo.append("电子ID编号：").append(cinemaObj.getTicket().getTicketID()).append("\n\n");
                    cinemaObj.getTicket().setTicketState("N");
                    // 将用户信息显示在文本区域中
                    textArea.setText(userInfo.toString());
                    frame.setVisible(false);
                    frame1.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "此电影票已被取出！");
                }
            } else {
                JOptionPane.showMessageDialog(null, "电影票的电子ID编号输入错误！");
            }
        });
        //添加返回按钮
        JButton exit1 = new JButton("返回");
        exit1.setBounds(150, 330, 82, 30);
        jPane2.add(exit1);
        exit1.addActionListener(e -> {
            frame1.setVisible(false);
            frame.setVisible(true);
        });
    }

    //查看购票历史
    public void checkHistory(StringBuilder userInfo,JPanel jPanel, JFrame frame, JFrame frame1, JPanel jPane2) {
        JTextArea textArea = new JTextArea();
        textArea.setBounds(0, 0, 800, 730);
        jPane2.add(textArea);
        JButton check = new JButton("查看购票历史");
        check.setBounds(180, 280, 200, 30);
        jPanel.add(check);

        check.addActionListener(e -> {
            if (userInfo != null) {
                // 将用户信息显示在文本区域中
                textArea.setText(userInfo.toString());
                frame.setVisible(false);
                frame1.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "暂无购票历史！");
            }
        });
        //添加返回按钮
        JButton exit1 = new JButton("返回");
        exit1.setBounds(350, 730, 82, 30);
        jPane2.add(exit1);
        exit1.addActionListener(e -> {
            frame1.setVisible(false);
            frame.setVisible(true);
        });
    }

    //退出登录
    public void exit(JPanel jPanel, JFrame frame) {
        JButton exit = new JButton("退出登录");
        exit.setBounds(180, 320, 200, 30);
        jPanel.add(exit);

        exit.addActionListener(e -> {
            frame.dispose();
            new ChooseJf();
        });
    }
}
