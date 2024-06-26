import java.util.ArrayList;
import java.util.Random;
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
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入用户名：");
        String username = sc.next();
        if (!isExists(list, username)) {
            System.out.println("用户名" + username + "不存在，请重新输入");
            return;
        }
        System.out.print("请输入身份证号：");
        String idNumber = sc.next();
        if (!checkUserId(idNumber)) {
            System.out.println("身份证号格式不正确，请重新输入");
            return;
        }
        System.out.print("请输入手机号：");
        String phoneNumber = sc.next();
        if (!checkPhoneNumber(phoneNumber)) {
            System.out.println("手机号格式不正确，请重新输入");
            return;
        }

        int index = findIndex(list, username);
        User user = list.get(index);
        if (user.getIdNumber().equals(idNumber) && user.getPhoneNumber().equals(phoneNumber)) {
            System.out.println("验证成功");
            System.out.print("请输入新密码：");
            String newPassword = sc.next();
            user.setPassword(newPassword);
            System.out.println("密码修改成功");
        } else {
            System.out.println("验证失败");
        }
    }

    private static int findIndex(ArrayList<User> list, String username) {
        for (int i = 0; i < list.size(); i++) {
            User u = list.get(i);
            if (u.getUsername().equals(username)) {
                return i;
            }
        }
        return -1;
    }

    private static void register(ArrayList<User> list) {
        System.out.println("注册");
        String username;
        String password;
        String idNumber;
        String phoneNumber;

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("请输入用户名：");
            username = sc.next();
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
            password = sc.next();
            System.out.print("请确认密码：");
            String confirmPassword = sc.next();
            if(!password.equals(confirmPassword)) {
                System.out.println("两次密码不一致，请重新输入");
            } else {
                System.out.println("密码设置成功");
                break;
            }
        }

        while (true) {
            System.out.print("请输入身份证号：");
            idNumber = sc.next();
            if (checkUserId(idNumber)) {
                System.out.println("身份证号" + idNumber + "格式正确");
                break;
            } else {
                System.out.println("身份证号格式不正确，请重新输入");
            }
        }

        while (true) {
            System.out.print("请输入手机号：");
            phoneNumber = sc.next();
            if (checkPhoneNumber(phoneNumber)) {
                System.out.println("手机号" + phoneNumber + "格式正确");
                break;
            } else {
                System.out.println("手机号格式不正确，请重新输入");
            }
        }

        User user = new User(username, password, idNumber, phoneNumber);
        list.add(user);
        System.out.println("注册成功");

        printList(list);

    }

    private static void printList(ArrayList<User> list) {
        for (int i = 0; i < list.size(); i++) {
            User u = list.get(i);
            System.out.println("用户名：" + u.getUsername() + "\t密码：" + u.getPassword() + "\t身份证号：" + u.getIdNumber() + "\t手机号：" + u.getPhoneNumber());
        }
    }

    private static boolean checkPhoneNumber(String phoneNumber) {
        int length = phoneNumber.length();
        if (length != 11) {
            return false;
        }

        if (!phoneNumber.startsWith("1")) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            char ch = phoneNumber.charAt(i);
            if (ch < '0' || ch > '9') {
                return false;
            }
        }
        return true;
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
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.print("请输入用户名：");
            String username = sc.next();
            if (!isExists(list, username)) {
                System.out.println("用户名" + username + "不存在，请重新输入");
                return;
            }
            System.out.println();
            System.out.print("请输入密码：");
            String password = sc.next();
            System.out.println();

            while (true) {
                String checkCode = generateCheckCode();
                System.out.println("验证码：" + checkCode);
                System.out.print("请输入验证码：");
                String inputCheckCode = sc.next();
                if (!checkCode.equalsIgnoreCase(inputCheckCode)) {
                    System.out.println("验证码错误");
                } else {
                    System.out.println("验证码正确");
                    break;
                }
            }

            User userInfo = new User(username, password, null, null);
            if (checkUserInfo(list, userInfo)) {
                System.out.println("登录成功");
            } else {
                System.out.println("登录失败");
                if (i == 2) {
                    System.out.println("您已经连续3次输入错误，账号已锁定，请联系管理员");
                    return;
                } else {
                    System.out.println("您还有" + (2 - i) + "次机会");
                }
            }
        }
    }

    private static boolean checkUserInfo(ArrayList<User> list, User userInfo) {
        for (int i = 0; i < list.size(); i++) {
            User u = list.get(i);
            if (u.getUsername().equals(userInfo.getUsername()) && u.getPassword().equals(userInfo.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public static String generateCheckCode() {
        //创建集合
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add((char) ('a' + i));
            list.add((char) ('A' + i));
        }

        StringBuilder sb = new StringBuilder();
        //随机生成4个字符
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            int index = r.nextInt(list.size());
            char c = list.get(index);
            sb.append(c);
        }
        int number = r.nextInt(10);
        sb.append(number);
        char[] arr = sb.toString().toCharArray();
        int randomIndex = r.nextInt(arr.length);

        char temp = arr[randomIndex];
        arr[randomIndex] = arr[arr.length - 1];
        arr[arr.length - 1] = temp;

        return new String(arr);
    }
}
