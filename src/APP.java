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
                case "2" -> register(list);
                case "3" -> forgetPassword(list);
                default -> System.out.println("输入有误，请重新输入");
            }
        }
    }

    private static void forgetPassword(ArrayList<User> list) {

    }

    private static void register(ArrayList<User> list) {
        System.out.println("注册");
        User u = new User();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("请输入用户名：");
            String username = sc.next();
            //先验证格式是否正确
            //再验证是否唯一
            if(!checkUserName(username)) {
                System.out.println("用户名格式不正确,请重新输入!");
                continue;
            }
            if(isExists(list, username)) {
                System.out.println("用户名已存在,请重新输入!");
            } else {
                System.out.println("用户名" + username + "可用");
                break;
            }
        }

        while (true) {
            System.out.print("请输入密码：");
            String password = sc.next();
            System.out.print("请确认密码：");
            String confirmPassword = sc.next();
            if(!password.equals(confirmPassword)) {
                System.out.println("两次密码不一致，请重新输入");
            } else {
                System.out.println("密码设置成功");
                break;
            }
        }
        
        System.out.print("请输入身份证号：");
        String idNumber = sc.next();
        if(checkUserId(idNumber)) {
            System.out.println("身份证号" + idNumber + "格式正确");
        } else {
            System.out.println("身份证号格式不正确，请重新输入");
        }

    }

    private static boolean checkUserId(String idNumber) {
        int length = idNumber.length();
        if(length != 18) {
            return false;
        }
        
        if(idNumber.startsWith("0")) {
            return false;
        }

        for(int i = 0; i < length - 1; i++) {
            char ch = idNumber.charAt(i);
            if(ch < '0' || ch > '9') {
                return false;
            }
        }

        char ch = idNumber.charAt(length - 1);
        return ch >= '0' && (ch <= '9' || ch == 'X' || ch == 'x');
    }

    private static boolean isExists(ArrayList<User> list, String username) {
        for (int i = 0; i < list.size(); i++) {
            User u = list.get(i);
            String rightUsername = u.getUsername();
            if(rightUsername.equals(username)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkUserName(String username) {
        int length = username.length();
        if(length < 3 || length > 15) {
            return false;
        }

        for(int i = 0; i < length; i++) {
            char ch = username.charAt(i);
            if(!((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9'))) {
                return false;
            }
        }

        int count = 0;
        for(int i = 0; i < length; i++) {
            char ch = username.charAt(i);
            if(ch >= '0' && ch <= '9') {
                count++;
                break;
            }
        }
        return count > 0;
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
