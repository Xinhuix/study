import org.junit.Test;
import test.Employee;
import test.Gooddess;
import test.NewMan;

import java.util.Optional;

/**
 * @ClassName OptionalTest
 * @Description TODO
 * @Author 徐鑫辉
 * @Date 2019年11月09日 18:22
 **/
public class OptionalTest {
    /**
     * Optional 容器类的常用方法
     * Optional.of(T t) :创建一个Optional实例
     * Optional.empty() :创建一个空的Optional实例
     * Optional.ofNullable(T t):若 t 不为null，创建Optional实例，否则创建空实例
     * isPresent():判断是否包含值
     * orElse(T t): 如果调用对象包含值，返回该值，否则返回t
     * orElseGet(Supplier s):如果调用对象包含值，返回该值，否则返回s获取值
     * map（Function f）:如果有值对其处理，并返回处理后的Optional,否则返回optional.empty()
     * flatMap(Function f): 与map类似，要求返回值必须是Optional
     */

    //Optional.of(T t) :创建一个Optional实例
    @Test
    public void Test1(){
        Optional<Employee> employee = Optional.of(new Employee());
        Employee optional = employee.get();
        System.out.println(optional);
    }

    //Optional.empty():创建一个空的Optional实例
    @Test
    public void Test2(){
        Optional<Object> empty = Optional.empty();
        System.out.println(empty.get());
    }

    // Optional.ofNullable(T t):若 t 不为null，
    // 创建Optional实例，否则创建空实例
    @Test
    public  void Test3(){
        Optional<Object> o = Optional.ofNullable(new Employee());
        System.out.println(o.get());
    }

    //isPresent():判断是否包含值
    @Test
    public void Test4( ){
        Optional<Employee> employee = Optional.ofNullable(null);
        if (employee.isPresent())
            System.out.println("noNull");
        else
            System.out.println("null");
    }

    //orElse(T t): 如果调用对象包含值，返回该值，否则返回t
    @Test
    public void Test5( ){
        Optional<Object> o = Optional.ofNullable(null);
        //如果T不为空返回T,为空则返回orElse值
        Object o1 = o.orElse(new Employee(1,"23",22,33,Employee.Status.rest));
        System.out.println(o1);
    }

    //orElseGet(Supplier s):如果调用对象包含值，返回该值，
    // 否则返回s获取值
    @Test
    public void Test6( ){
        Optional<Employee> o = Optional.ofNullable(new Employee(1,"打算",22,33,Employee.Status.rest));
        Employee o1 = o.orElseGet(() -> {
            if (o.isPresent())
                return o.get();
            else
                return new Employee();
        });
        System.out.println(o1);
    }


    //map（Function f）:如果有值对其处理，
    // 并返回处理后的Optional,否则返回optional.empty()
    @Test
    public void Test7( ){
        Optional<Employee> o = Optional.ofNullable(
                new Employee(1,"32",33,22,Employee.Status.rest));
        Optional<Integer> integer = o.map((e) -> e.getAge());
        System.out.println(integer.get());
    }

    //flatMap(Function f): 与map类似，要求返回值必须是Optional
    @Test
    public void Test8( ){
        Optional<Employee> o = Optional.ofNullable(new Employee(1,"32",33,22,Employee.Status.rest));
        Optional<Integer> integer = o.flatMap((e) ->
                Optional.of(e.getAge()));
        System.out.println(integer.get());
    }

    @Test
    public void Test9( ){
        NewMan newMan = new NewMan();
        Optional<Gooddess> name = Optional.ofNullable(new Gooddess("莉莎"));
        newMan.setGooddess(name);
        Optional<NewMan> o = Optional.ofNullable(newMan);
        String s = newMan(o);
        System.out.println(s);

    }
    public String newMan(Optional<NewMan> newMan){

       return newMan.orElse(new NewMan())
               .getGooddess()
               .orElseGet(()->{
                   Gooddess gooddess = new Gooddess();
                   gooddess.setName("鑫辉");
                   return gooddess;
               }).getName();
    }
}
