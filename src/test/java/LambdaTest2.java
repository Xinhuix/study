import org.junit.Test;
import test.Employee;
import test.TestInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName LambdaTest2
 * @Description TODO
 * @Author 徐鑫辉
 * @Date 2019年10月26日 11:36
 **/
public class LambdaTest2 {

    List<Employee> emps = Arrays.asList(
            new Employee(101,"第三",18,189999,Employee.Status.BUSY),
            new Employee(182,"李四",20,596666,Employee.Status.IDLE),
            new Employee(103,"王五",22,283333,Employee.Status.rest),
            new Employee(184,"赵六",33,87777,Employee.Status.BUSY),
            new Employee(105,"田七",33,385555, Employee.Status.rest)
    );

    @Test
    public void test1(){
        Collections.sort(emps,(x,y) -> {
            if (x.getAge() == y.getAge()){
                return x.getName().compareTo(y.getName());
            }else {
                return Integer.compare(x.getAge(),y.getAge());
            }
        });
        for (Employee emp : emps) {
            System.out.println(emp);
        }
    }

    @Test
    public void test2(){
       String cc = strHandler("\t\t\t\t\t是是大V士大夫撒",(str) -> str.trim());
        System.out.println(cc);

        String s = strHandler("电风扇不要电", (str) -> str.substring(2, 5));
        System.out.println(s);

    }

    //用于处理字符串的一个方法
    public String strHandler(String str, TestInterface mf){
        return  mf.addTest(str);
    }

}
