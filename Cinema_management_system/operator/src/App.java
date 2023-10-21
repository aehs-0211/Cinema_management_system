import login.ChooseJf;

import static administrator.Admin.addAdmin;
import static cinema.Cinema.addCinemas;
import static cinema.Film.addFilm;
import static foreground.Foreground.addForeground;
import static manager.Manager.addManager;
import static user.User.addUsers;

public class App {
    public static void main(String[] args) {
        addAdmin("admin","admin12345");
        addManager("manager","manager12345");
        addForeground("foreground","fore12345");
        addUsers("user1", "user12345", "001", "金牌用户", 100, 5, "15974662202", "user1@163.com");
        addUsers("user2", "user12345", "002", "银牌用户", 57, 3, "15974662203", "user2@163.com");
        addUsers("user3", "user12345", "003", "铜牌用户", 0, 0, "15974662204", "user3@163.com");
        addFilm("战狼2","吴京","吴京","该片讲述了脱下军装的冷锋被卷入了一场非洲国家的叛乱，本来能够安全撤离的他无法忘记军人的职责，重回战场展开救援的故事。","123 分钟");
        addFilm("流浪地球","郭帆","吴京","影片根据刘慈欣的同名小说改编，故事背景设定在2075年，讲述了太阳即将毁灭，毁灭之后的太阳系已经不适合人类生存，而面对绝\n境，人类将开启“流浪地球”计划，试图带着地球一起逃离太阳系，寻找人类新家园的故事。","125 分钟(137分钟（重映版）)");
        addCinemas("战狼2","放映厅B","2023/10/2 下午2:00","30");
        addCinemas("流浪地球","放映厅A","2023/10/1 上午9:00","20");
        new ChooseJf();
    }
}
