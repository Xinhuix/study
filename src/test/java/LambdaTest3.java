/**
 * @ClassName LambdaTest3
 * @Description TODO
 * @Author 徐鑫辉
 * @Date 2019年10月26日 13:39
 **/

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Java8中 内置的四大核心函数式接口
 *
 * 1.Consumer<T>: 消费型接口
 *          void accept(T t);
 *
 * 2.Supplier<T>: 供给型接口
 *          T get();
 *
 * 3.Function<T,R>: 函数型接口
 *          R apply(T t);
 *
 * 4.Predicate<T>: 断言型接口
 *          boolean test(T t);
 */
public class LambdaTest3 {

    //Consumer<T> 消费型接口:
    @Test
    public void test1(){
        happy(10000,(m) -> System.out.println(m));
    }

    public void happy(double money, Consumer<Double> con){
        con.accept(money);
    }

    //Supplier<T> 供给型接口:
    //需求:产生指定个数的整数，并放到集合中
    @Test
    public void test2(){
        List<Integer> numList = getNumList(10, () -> (int)(Math.random() * 100));
        for (Integer integer : numList) {
            System.out.println(integer);

        }
    }

    public List<Integer> getNumList(int num, Supplier<Integer> sup){
        List<Integer> arrayList = new ArrayList<>();
        for (int i=0;i< num;i++){
            Integer integer = sup.get();
            arrayList.add(integer);
        }
        return arrayList;
    }

    //Function<T,R> 函数型接口:
    //需求:参数一个字符串，返回一个字符串的长度
    @Test
    public void test3(){
        String cc = serHandler("徐鑫辉", (str) -> str.substring(1,2));
        System.out.println(cc);
    }
    public String serHandler(String str, Function<String,String> fun){
        return fun.apply(str);
    }

    //Predicate<T> 断言型接口:
    //需求: 将满足条件的字符串添加到集合中返回
    @Test
    public void test4(){
        List<String> asList =  Arrays.asList("Hello", "hah", "xxh", "ok");
        for (String s : filterStr(asList, (x) -> x.length() > 3)) {
            System.out.println(s);
        }
        ;
    }

    public List<String> filterStr(List<String> list, Predicate<String> pre){
        ArrayList<String> contact = new ArrayList<>();
        for (String str : list) {
            if (pre.test(str)){
                contact.add(str);
            }
        }
        return contact;
    }

    @Test
    public void test5(){
        //当前记录表有一条申请数据
        ArrayList<String> log = new ArrayList<>();
        log.add("xxh");

        //当前正在进行会议的数据
        ArrayList<String> scheduleList = new ArrayList<>();
        scheduleList.add("123");
        scheduleList.add("456");
        scheduleList.add("789");

        //我的终端是否在会议中
        ArrayList<Object> devNO = new ArrayList<>();
        devNO.add("123");

        if (devNO != null && devNO.size()>0){

        }
//第六集
    }
}
