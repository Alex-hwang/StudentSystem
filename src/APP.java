import java.util.ArrayList;
import java.util.Scanner;

public class APP {
    public static void main(String[] args) {
        ArrayList<User> list = new ArrayList<>();
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
                case "1" -> login(list);
                case "2" -> regiser(list);
                case "3" -> forgetPassword(list);
                default -> System.out.println("输入有误，请重新输入");
            }
        }
    }

    private static void forgetPassword(ArrayList<User> list) {

    }

    private static void regiser(ArrayList<User> list) {
        System.out.println("注册");
        User u = new User();

        Scanner sc = new Scanner(System.in);
        System.out.print("请输入用户名：");
        String username = sc.next();
    }

    public static void login(ArrayList<User> list) {
        System.out.print("请输入用户名：");
        Scanner sc = new Scanner(System.in);
        String username = sc.next();
        System.out.println();
        System.out.print("请输入密码：");
        String password = sc.next();
        System.out.println();
    }
}
