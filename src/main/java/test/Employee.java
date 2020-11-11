package test;

/**
 * @ClassName Employess
 * @Description TODO
 * @Author 徐鑫辉
 * @Date 2019年10月26日 11:37
 **/
public class Employee {
    Integer id;
    String name;
    Integer age;
    Integer slary;
    Status  status;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", slary=" + slary +
                ", status=" + status +
                '}';
    }

    public Employee() {
        super();
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name){
         this.name=name;
    }

    public String getName(){
        return this.name;
    }

    public void setAge(Integer age){
        this.age=age;
    }

    public Integer getAge(){
        return this.age;
    }

    public void setSlary(Integer slary){
        this.slary=slary;
    }

    public Integer getSlary(){
        return this.slary;
    }

    public Employee(Integer id, String name, Integer age, Integer slary, Status status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.slary = slary;
        this.status = status;
    }

    public enum Status{
       IDLE,
       BUSY,
       rest;
   }


}
