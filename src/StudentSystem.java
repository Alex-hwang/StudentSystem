import java.util.ArrayList;
import java.util.Scanner;

public class StudentSystem {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        loop:while(true) {
            System.out.println("----------欢迎进入学生管理系统----------");
            System.out.println("1. 添加学生");
            System.out.println("2. 删除学生");
            System.out.println("3. 修改学生");
            System.out.println("4. 查看学生");
            System.out.println("5. 退出");
            System.out.print("请输入您的选择：");
            Scanner sc = new Scanner(System.in);
            String choice = sc.next();

            switch (choice) {
                case "1" -> addStudent(list);
                case "2" -> deleteStudent(list);
                case "3" -> updateStudent(list);
                case "4" -> queryStudent(list);
                case "5" -> {
                    System.out.println("感谢您的使用，再见！");
                    break loop;
                    // System.exit(0); 停止虚拟机运行
                }
                default -> System.out.println("输入有误，请重新输入");
            }
        }
    }

    public static void addStudent(ArrayList<Student> list) {
        System.out.println("添加学生");
        Scanner sc = new Scanner(System.in);
        String id;
        while(true) {
            System.out.print("请输入学号：");
            id = sc.next();
            if(isExists(list, id)) {
                System.out.println("学号已存在，请重新输入");
            } else {
                break;
            }
        }

        System.out.print("请输入姓名：");
        String name = sc.next();
        System.out.print("请输入年龄：");
        int age = sc.nextInt();
        System.out.print("请输入地址：");
        String address = sc.next();

        Student stu = new Student(name, age, id, address);
        list.add(stu);
        System.out.println("添加成功");

    }


    public static void deleteStudent(ArrayList<Student> list) {
        while (true) {
            System.out.println("删除学生");
            Scanner sc = new Scanner(System.in);
            System.out.print("请输入要删除的学号：");
            String id = sc.next();
            for (int i = 0; i < list.size(); i++) {
                Student stu = list.get(i);
                if (stu.getS_id().equals(id)) {
                    list.remove(i);
                    System.out.println("删除成功");
                    return;
                }
            }
            System.out.println("学号不存在，请重新输入");
        }
    }

    public static void updateStudent(ArrayList<Student> list) {
        System.out.println("修改学生");
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入要修改的学号：");
        String id = sc.next();

        int index = getIndex(list, id);
        if(index == -1) {
            System.out.println("学号不存在，请重新输入");
            return;
        }

        System.out.print("请输入新的姓名：");
        String name = sc.next();
        System.out.print("请输入新的年龄：");
        int age = sc.nextInt();
        System.out.print("请输入新的地址：");
        String address = sc.next();

        Student newStu = new Student(name, age, id, address);
        list.set(index, newStu);
        System.out.println("修改成功");
    }

    public static void queryStudent(ArrayList<Student> list) {
        System.out.println("查看学生");
        if(list.isEmpty()) {
            System.out.println("无信息，请先添加信息");
            return;
        }

        System.out.println("姓名\t年龄\t学号\t地址");

        for (Student stu : list) {
            System.out.println(STR."\{stu.getS_name()}\t\{stu.getS_age()}\t\{stu.getS_id()}\t\{stu.getS_address()}");
        }
    }

    public static boolean isExists(ArrayList<Student> list, String id) {
        return getIndex(list, id) != -1;
    }

    public static int getIndex(ArrayList<Student> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            if(stu.getS_id().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
