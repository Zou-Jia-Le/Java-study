import java.util.Optional;

public class User {
    //成员变量
    String name;//姓
    String fullname;//全名

    //getter、setter方法
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getFullname1() {
        return fullname;
    }
    public Optional<String> getFullname2() {
        return Optional.ofNullable(fullname);
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    //构造方法
    public User() {
    }
    public User(String name, String fullname) {
        this.name = name;
        this.fullname = fullname;
    }
}