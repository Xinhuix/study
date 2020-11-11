/**
 * @ClassName LambdaTest
 * @Description TODO
 * @Author 徐鑫辉
 * @Date 2019年10月26日 9:40
 **/

import org.junit.Test;
import test.TestInterface;

import java.util.Collections;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * 一、Lambda在JKD1.8中引入新语法"->"箭头函数
 *   箭头函数将Lambda表达式拆分成两个部分
 *   左侧: Lambda 表达式参数列表
 *   右侧: Lambda 表达式中所需要执行的功能，即时Lambda体{}
 *
 *   1.语法格式: 接口方法无参，无返回值的格式
 *   {
 *     空号不给参数，则是无参  () -> 指向实现功能
 *   }
 *
 *   2.语法格式:有一个参数，无返回值
 *   {
 *                          空号有参数
 *    Consumer<String> con = (x) -> System.out.println(x);
 *   }
 *
 *   3.语法格式三: 若只有一个参数，小括号可以省略不写
 *   {
 *    Consumer<String> con = x -> System.out.println(x);
 *   }
 *
 *   4.语法格式四: 有两个以上的参数，有返回值，并且Lambda表达式有多条语句
 *   {
 *      //有多少个参数，空号就要给多少个参数
 *        有多条语句就要使用大括号
 *        并且有返回值还要return
 *      Comparator<Integer> com = (x,y) -> {
 *             System.out.println("3213");
 *             return Integer.compare(x,y);
 *         };
 *   }
 *
 *   5.语法格式五:若Lambda表达式只有一条语句，大括号和return可以省略
 *   {
 *          Comparator<Integer> com = (x,y) -> Integer.compare(x,y);
 *   }
 *
 *   6.语法格式六: Lambda空号参数列表的数据类型可以省略不写，
 *   因为jvm编译器可以通过上下文推断出，数据类型简称"数据推断"
 */

/**
 *  二、Lambda表达式需要"函数式接口"的支持
 *  函数式接口:接口中只一个抽象方法的接口，称为函数式接口,
 *  可以使用注解@FuntionalInterface 修饰
 *  可以检查是否是函数式接口
 */
public class LambdaTest {
    /**
     * Lambda表达式实现是匿名内部类实现，
     * 所以无法使用局部变量做运算
     */


    // 1.语法格式: 接口方法无参，无返回值的格式
    @Test
    public void test1(){
        int num =0;

        Runnable r = new Runnable() {
            public void run() {
                System.out.println("你好");
            }
        };
      r.run();
                    //无参 实现
        Runnable r1 = () -> System.out.println("你好");
        r1.run();
    }


    //2.语法格式:有一个参数，无返回值
    @Test
    public void test2(){
        Consumer<String> con = (x) -> System.out.println(x);
        con.accept("123");
    }

    //3.语法格式:有一个参数，小括号可以省略返回值
    @Test
    public void test3(){
        Consumer<String> con = x -> System.out.println(x);
        con.accept("123");
    }

    /**
     *     4.语法格式: 有两个以上的参数，有返回值，
     *     并且Lambda表达式有多条语句,箭头就必须指向大括号
     */
    @Test
    public void test4(){
        Comparator<Integer> com = (x,y) -> {
            System.out.println("3213");
            return Integer.compare(x,y);
        };

    }

    /**
     *  5.语法格式五:若Lambda表达式只有一条语句，
     *  大括号和return可以省略
     */
    @Test
    public void test5(){
        Comparator<Integer> com = (x,y) -> Integer.compare(x,y);
        }


    /**
     * 需求: 用参数做运算
      */
    @Test
    public void test6(){

    }


}
