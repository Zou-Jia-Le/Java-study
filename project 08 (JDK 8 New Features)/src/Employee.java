import java.util.Objects;

public class Employee {
    //成员变量
    private String name;//员工姓名
    private double money;//工资

    //getter、setter方法
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getMoney() {
        return money;
    }
    public void setMoney(double money) {
        this.money = money;
    }

    //构造方法
    public Employee() {
    }
    public Employee(String name, double money) {
        this.name = name;
        this.money = money;
    }

    //成员方法
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(money, employee.money) == 0 && Objects.equals(name, employee.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, money);
    }
}
