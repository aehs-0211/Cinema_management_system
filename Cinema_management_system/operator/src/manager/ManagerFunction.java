package manager;

import cinema.Cinema;
import cinema.Film;
import cinema.Hall;
import login.ChooseJf;

import javax.swing.*;

import static cinema.Cinema.cinemaList;
import static cinema.Cinema.cinemaObj;
import static cinema.Film.*;
import static cinema.Hall.hallList;
import static cinema.Hall.hallObj;

public class ManagerFunction {
    //影片(场次)信息窗口
    public static void filmInformationJF(JFrame frame1, JPanel jPane2) {
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
    public static void shoeFilm(JPanel jPanel, JFrame frame, JFrame frame1, JPanel jPane2) {
        JTextArea textArea = new JTextArea();
        textArea.setBounds(0, 0, 800, 730);
        jPane2.add(textArea);
        JButton shoeFilm = new JButton("列出所有正在上映影片的信息");
        shoeFilm.setBounds(50, 160, 200, 30);
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

    //列出所有场次信息
    public static void showCinema(JPanel jPanel, JFrame frame, JFrame frame1, JPanel jPane2) {
        JTextArea textArea = new JTextArea();
        textArea.setBounds(0, 0, 800, 730);
        jPane2.add(textArea);
        JButton showCinema = new JButton("列出所有场次信息");
        showCinema.setBounds(300, 200, 200, 30);
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

    //添加影片的信息
    public void addFilm(JPanel jPanel, JFrame frame) {
        JButton addButton = new JButton("添加影片的信息");
        addButton.setBounds(50, 80, 200, 30);
        jPanel.add(addButton);

        addButton.addActionListener(e -> {
            boolean filmRepeat = true;
            String filmName = null;
            while (filmRepeat) {
                if (filmList.isEmpty()) {
                    filmRepeat = false;
                }
                filmName = JOptionPane.showInputDialog(frame, "请输入片名：");
                for (Film film : filmList) {
                    if (film.getName() != null && film.getName().equals(filmName)) {
                        filmRepeat = true;
                        break;
                    } else {
                        filmRepeat = false;
                    }
                }
                if (filmRepeat) {
                    JOptionPane.showMessageDialog(frame, "该影片已存在！");
                }
            }
            String director = JOptionPane.showInputDialog(frame, "请输入该影片的导演：");
            String actor = JOptionPane.showInputDialog(frame, "请输入该影片的主演：");
            String synopsis = JOptionPane.showInputDialog(frame, "请输入该影片的剧情简介：");
            String duration = JOptionPane.showInputDialog(frame, "请输入该影片的时长：");
            new Film().addFilm(filmName, director, actor, synopsis, duration);
            JOptionPane.showMessageDialog(frame, "影片信息添加成功！");
        });
    }

    //修改影片信息
    public void reviseFilm(JPanel jPanel, JFrame frame) {
        JButton reviseFilm = new JButton("修改影片信息");
        reviseFilm.setBounds(50, 120, 200, 30);
        jPanel.add(reviseFilm);
        reviseFilm.addActionListener(e -> {
            filmObj = null;
            String filmName = JOptionPane.showInputDialog(null, "请输入要修改的影片名字：");
            for (Film film : filmList) {
                if (film.getName().equals(filmName)) {
                    filmObj = film;
                    break;
                }
            }
            if (filmObj != null) {
                String reviseChoice = JOptionPane.showInputDialog(null, "请选择需要修改的内容(片名1/导演2/主演3/剧情简介4/时长5)：");
                int reviseChoiceNumber = Integer.valueOf(reviseChoice);
                switch (reviseChoiceNumber) {
                    case 1:
                        String name = JOptionPane.showInputDialog(null, "请输入修改后的片名：");
                        filmObj.setName(name);
                        break;
                    case 2:
                        String director = JOptionPane.showInputDialog(null, "请输入修改后的影片导演：");
                        filmObj.setDirector(director);
                        break;
                    case 3:
                        String actor = JOptionPane.showInputDialog(null, "请输入修改后的影片主演：");
                        filmObj.setActor(actor);
                        break;
                    case 4:
                        String synopsis = JOptionPane.showInputDialog(null, "请输入修改后的影片剧情简介：");
                        filmObj.setSynopsis(synopsis);
                        break;
                    case 5:
                        String duration = JOptionPane.showInputDialog(null, "请输入修改后的影片时长：");
                        filmObj.setDuration(duration);
                        break;
                }
                JOptionPane.showMessageDialog(null, "影片信息修改成功！");
            } else {
                JOptionPane.showMessageDialog(null, "该影片不存在！");
            }
        });
    }

    //删除影片信息
    public void deleteFilm(JPanel jPanel, JFrame frame) {
        JButton deleteButton = new JButton("删除影片信息");
        deleteButton.setBounds(50, 200, 200, 30);
        jPanel.add(deleteButton);
        deleteButton.addActionListener(e -> {
            String filmName = JOptionPane.showInputDialog(null, "请输入要删除的影片名字：");
            for (Film film : filmList) {
                if (film.getName().equals(filmName)) {
                    filmObj = film;
                    break;
                }
            }
            if (filmObj != null) {
                String waring = JOptionPane.showInputDialog(null, "影片删除后无法恢复，确认要删除该影片吗？Y/N");
                if (waring.equals("Y")) {
                    filmList.remove(filmObj);
                    JOptionPane.showMessageDialog(null, "影片删除成功！");
                } else {
                    JOptionPane.showMessageDialog(null, "影片删除取消！");
                }
            } else {
                JOptionPane.showMessageDialog(null, "该影片不存在！");
            }
        });
    }

    //查询影片的信息
    public void checkFilm(JPanel jPanel, JFrame frame, JFrame frame1, JPanel jPane2) {
        JTextArea textArea = new JTextArea();
        textArea.setBounds(0, 0, 800, 730);
        jPane2.add(textArea);

        //查询影片信息按钮
        JButton show = new JButton("查询影片信息");
        show.setBounds(50, 240, 200, 30);
        jPanel.add(show);
        show.addActionListener(e -> {
            relevantFilmList.clear();
            StringBuilder userInfo = new StringBuilder();
            Object[] objects = {"片名", "导演", "主演"};
            String checkChoice = (String) JOptionPane.showInputDialog(null, "请选择查找的内容\n", "相关内容",
                    JOptionPane.PLAIN_MESSAGE, new ImageIcon("icon.png"), objects, "片名");
            int checkChoiceNumber = 0;
            if (checkChoice.equals("片名")) {
                checkChoiceNumber = 1;
            } else if (checkChoice.equals("导演")) {
                checkChoiceNumber = 2;
            } else if (checkChoice.equals("主演")) {
                checkChoiceNumber = 3;
            }
            switch (checkChoiceNumber) {
                case 1:
                    String name = JOptionPane.showInputDialog(null, "请输入要查找的影片名字：");
                    for (Film film : filmList) {
                        if (film.getName().equals(name)) {
                            relevantFilmList.add(film);
                        }
                    }
                    break;
                case 2:
                    String director = JOptionPane.showInputDialog(null, "请输入要查找的影片导演：");
                    for (Film film : filmList) {
                        if (film.getDirector().equals(director)) {
                            relevantFilmList.add(film);
                            break;
                        }
                    }
                    break;
                case 3:
                    String actor = JOptionPane.showInputDialog(null, "请输入要查找的影片主演：");
                    for (Film film : filmList) {
                        if (film.getActor().equals(actor)) {
                            relevantFilmList.add(film);
                        }
                    }
                    break;
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

    // 增加场次
    public void addCinema(JPanel jPanel, JFrame frame) {
        JButton addButton = new JButton("添加场次信息");
        addButton.setBounds(300, 80, 200, 30);
        jPanel.add(addButton);

        addButton.addActionListener(e -> {
            boolean showTimeRepeat = true;
            String showTime = null;
            while (showTimeRepeat) {
                if (cinemaList.isEmpty()) {
                    showTimeRepeat = false;
                }
                showTime = JOptionPane.showInputDialog(frame, "请输入该场次的时段：");
                for (Cinema cinema : cinemaList) {
                    if (cinema.getShowtime() != null && cinema.getShowtime().equals(showTime)) {
                        showTimeRepeat = true;
                        break;
                    } else {
                        showTimeRepeat = false;
                    }
                }
                if (showTimeRepeat) {
                    JOptionPane.showMessageDialog(frame, "该场次已存在！");
                }
            }
            filmObj = null;
            String filmName = JOptionPane.showInputDialog(frame, "请输入该场次放映的影片：");
            for (Film film : filmList) {
                if (film.getName() != null && film.getName().equals(filmName)) {
                    filmObj = film;
                    break;
                }
            }
            if (filmObj == null) {
                JOptionPane.showMessageDialog(frame, "该影片不存在！");
            } else {
                String name = JOptionPane.showInputDialog(frame, "请输入该场次的放映厅名：");
                String prices = JOptionPane.showInputDialog(frame, "请输入该场次的价格：");
                new Cinema().addCinemas(filmName, name, showTime, prices);
                JOptionPane.showMessageDialog(frame, "场次添加成功！");
            }
        });
    }

    //修改场次信息
    public void reviseCinema(JPanel jPanel, JFrame frame) {
        JButton reviseCinema = new JButton("修改场次信息");
        reviseCinema.setBounds(300, 120, 200, 30);
        jPanel.add(reviseCinema);
        reviseCinema.addActionListener(e -> {
            cinemaObj = null;
            String showTime = JOptionPane.showInputDialog(null, "请输入要修改的场次：");
            for (Cinema cinema : cinemaList) {
                if (cinema.getShowtime() != null && cinema.getShowtime().equals(showTime)) {
                    cinemaObj = cinema;
                    break;
                }
            }
            if (cinemaObj != null) {
//                String reviseCinemaChoice = JOptionPane.showInputDialog(null, "请选择需要修改的内容(影片1/放映厅2/时段3/价格4)：");
                int reviseChoiceNumber = 0;
                Object[] objects = {"影片","放映厅","时段","价格"};
                String reviseCinemaChoice = (String) JOptionPane.showInputDialog(null, "请选择需要修改的内容\n", "相关内容",
                        JOptionPane.PLAIN_MESSAGE, new ImageIcon("icon.png"), objects, "影片");
                if (reviseCinemaChoice.equals("影片")) {
                    reviseChoiceNumber = 1;
                } else if (reviseCinemaChoice.equals("放映厅")) {
                    reviseChoiceNumber = 2;
                } else if (reviseCinemaChoice.equals("时段")) {
                    reviseChoiceNumber = 3;
                }else if (reviseCinemaChoice.equals("价格")) {
                    reviseChoiceNumber = 4;
                }
                switch (reviseChoiceNumber) {
                    case 1:
                        String filmName = JOptionPane.showInputDialog(null, "请输入修改后的影片：");
                        for (Film film : filmList) {
                            if (film.getName().equals(filmName)) {
                                filmObj = film;
                                break;
                            }
                        }
                        if (filmObj != null) {
                            cinemaObj.setFilm(filmObj);
                        } else {
                            JOptionPane.showMessageDialog(null, "该影片不存在！");
                        }
                        break;
                    case 2:
                        hallObj = null;
                        String hallName = JOptionPane.showInputDialog(null, "请输入修改后的放映厅名：");
                        for (Hall hall : hallList) {
                            if (hall.getName().equals(hallName)) {
                                hallObj = hall;
                                break;
                            }
                        }
                        cinemaObj.setHall(hallObj);
                        break;
                    case 3:
                        String showTimes = JOptionPane.showInputDialog(null, "请输入修改后的时段：");
                        cinemaObj.setShowtime(showTimes);
                        break;
                    case 4:
                        String prices = JOptionPane.showInputDialog(null, "请输入修改后的价格：");
                        double price = Integer.parseInt(prices);
                        cinemaObj.setPrice(price);
                        break;
                }
                JOptionPane.showMessageDialog(null, "场次信息修改成功！");
            } else {
                JOptionPane.showMessageDialog(null, "该场次不存在！");
            }
        });
    }

    //删除场次信息
    public void deleteCinema(JPanel jPanel, JFrame frame) {
        JButton deleteCinema = new JButton("删除场次信息");
        deleteCinema.setBounds(300, 160, 200, 30);
        jPanel.add(deleteCinema);
        deleteCinema.addActionListener(e -> {
            cinemaObj = null;
            String showTime = JOptionPane.showInputDialog(null, "请输入要删除的场次的时段：");
            for (Cinema cinema : cinemaList) {
                if (cinema.getShowtime().equals(showTime)) {
                    cinemaObj = cinema;
                    break;
                }
            }
            if (cinemaObj != null) {
                String waring = JOptionPane.showInputDialog(null, "场次删除后无法恢复，确认要删除该场次吗？Y/N");
                if (waring.equals("Y")) {
                    cinemaList.remove(cinemaObj);
                    JOptionPane.showMessageDialog(null, "场次删除成功！");
                } else {
                    JOptionPane.showMessageDialog(null, "场次删除取消！");
                }
            } else {
                JOptionPane.showMessageDialog(null, "该场次不存在！");
            }
        });
    }

    //退出登录
    public void exit(JPanel jPanel, JFrame frame) {
        JButton exit = new JButton("退出登录");
        exit.setBounds(300, 240, 200, 30);
        jPanel.add(exit);
        exit.addActionListener(e -> {
            frame.setVisible(false);
            new ChooseJf();
        });
    }

}
