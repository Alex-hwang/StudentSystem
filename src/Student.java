public class Student {
    private String s_name;
    private int s_age;
    private String s_id;
    private String s_address;

    public Student() {
    }

    public Student(String s_name, int s_age, String s_id, String s_address) {
        this.s_name = s_name;
        this.s_age = s_age;
        this.s_id = s_id;
        this.s_address = s_address;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public int getS_age() {
        return s_age;
    }

    public void setS_age(int s_age) {
        this.s_age = s_age;
    }

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public String getS_address() {
        return s_address;
    }

    public void setS_address(String s_address) {
        this.s_address = s_address;
    }
}
