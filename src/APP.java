import java.util.Scanner;

public class APP {
    public static void main(String[] args) {
        System.out.println("欢迎来到学生管理系统");
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("请选择操作:1.登录\t2.注册\t3.忘记密码\t0.退出");
            String choice = sc.next();
            switch (choice) {
                case "0" -> {
                    System.out.println("退出");
                    System.exit(0);
                }
                case "1" -> {
                    System.out.println("登录");
                }
                case "2" -> {
                    System.out.println("注册");
                }
                case "3" -> {
                    System.out.println("忘记密码");
                }
                default -> System.out.println("输入有误，请重新输入");
            }
        }

    }
}
