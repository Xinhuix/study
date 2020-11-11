import org.junit.Test;
import test.Generator;
import test.GeneratorImpl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName testBigDecimal
 * @Description
 * @Author xxh xinhui.xu@0071515.com
 * @Date 2020年11月04日 14:01
 **/
public class testBigDecimal {



    @Test
    public void test2() {
        String a = new String("ab"); // a 为一个引用
        String b = new String("ab"); // b为另一个引用,对象的内容一样
        String aa = "ab"; // 放在常量池中
        String bb = "ab"; // 从常量池中查找
        if (aa == bb) // true
            System.out.println("aa==bb");
        if (a == b) // false，非同一对象
            System.out.println("a==b");
        if (a.equals(b)) // true
            System.out.println("aEQb");
        if (42 == 42.0) { // true
            System.out.println("true");
        }
    }


    @Test
    public void Test4() throws Exception {
        List<Integer> list = new ArrayList<>();

        list.add(12);
//这里直接添加会报错
        Class<? extends List> clazz = list.getClass();
        Method add = clazz.getDeclaredMethod("add", Object.class);
//但是通过反射添加，是可以的
        add.invoke(list, "kl");

        System.out.println(list);
    }

    public static void main(String[] args) {
        Generic<Integer> generic = new Generic<Integer>(123);
        System.out.println(generic.getKey());

        GeneratorImpl te = new GeneratorImpl();
        System.out.println(te.method());

        // 创建不同类型数组： Integer, Double 和 Character
        Integer[] intArray = { 1, 2, 3 };
        String[] stringArray = { "Hello", "World" };
        printArray(intArray);
        printArray(stringArray);

    }
    public static class Generic<T>{
        private T key;

        public Generic(T key) {
            this.key = key;
        }

        public T getKey(){
            return key;
        }
    }


    public static <E> void printArray(E[] inputArray )
    {
        for ( E element : inputArray ){
            System.out.println(element);
        }
        System.out.println();
    }

}
