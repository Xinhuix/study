/**
 * @ClassName StreamAPI
 * @Description TODO
 * @Author 徐鑫辉
 * @Date 2019年11月02日 9:36
 **/

import org.junit.Test;
import test.Employee;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 一、Stream 创建步骤
 *
 * 1.创建 Stream:
 *
 * 2.中间操作:
 *
 * 3.终止操作:
 */
public class StreamAPI {
    List<Employee> emps = Arrays.asList(
            new Employee(101,"第三",18,189999,Employee.Status.BUSY),
            new Employee(182,"李四",20,596666,Employee.Status.IDLE),
            new Employee(103,"王五",22,283333,Employee.Status.rest),
            new Employee(184,"赵六",33,87777,Employee.Status.BUSY),
            new Employee(105,"田七",33,385555, Employee.Status.rest)
    );

    //1.创建 Stream
    /** 可以通过Collection 系列集合提供的stream或是parallStream*/
    @Test
    public void test1(){
        List<String> list = new ArrayList<String>();

        /** 1.通过list集合获取到流*/
        Stream<String> stream = list.stream();
        /** 2.通过Arrays获取到流*/
        Employee[] emps =new Employee[10];
        Arrays.stream(emps);
        /** 3.通过 Stream类静态方法of()获取流*/
        Stream.of("aa","bb","cc","dd");
        /** 4.创建无限流*/
        //迭代创建
        Stream<Integer> iterate = Stream.iterate(0, (x) -> x + 2);
        iterate.limit(10).forEach(System.out::println);
        //生成创建
        Stream<Double> generate = Stream.generate(() -> Math.random());
        generate.forEach(System.out::println);
    }

    //2.中间操作

    /**
     * 筛选与切片
     * filter --接收lambda,从流中排除某些元素
     * limit --段截流，返回指定个数元素
     * skip -- 跳过指定元素
     * distinct --筛选，通过流生成的元素的hashCode和equals去除重复元素
     */
    @Test
    public void test2(){
        emps.stream()
                .filter((e) -> e.getAge()> 10)
                .limit(2)
                .forEach(System.out::println);
        emps.stream()
                .filter((e)->{
                    return e.getAge()>10;
                })
                .limit(2)
                .distinct() //需要实体支持hashCoed和equals方法
                .forEach(System.out::println);
    }

    /**
     * 映射
     * map --接收lambda,将元素转换或换成其他形式提前信息，
     * 接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
     * flatMap --接收一个函数作为参数，将流中的每个值度换成另外一个流，然后把所有流连成一个流
     */
    @Test
    public void test3(){
    emps.stream()
            .map((x) -> x.getName())
            .forEach(System.out::println);

    }

    /**
     * 排序
     */
    @Test
    public void test4(){
        emps.stream()
                .sorted((x,y)->{
                    if (x.getAge().equals(y.getAge())){
                        return x.getName().compareTo(y.getName());
                    }else {
                        return -x.getAge().compareTo(y.getAge());
                    }
                })
                .forEach(System.out::println);
    }

    /**
     * 查找与匹配
     * allMatch-检查是否匹配所有元素
     * anyMatch一检查是否至少匹配一个元素
     * noneMatch-检查是否没有匹配所有元素
     * findFirst-返回第一个元素
     * findAny一返回当前流中的任意元素
     * count一返回流中元素的总个数
     * max—返回流中最大值
     * min一返回流中最小值
     */
    @Test
    public void test5(){
        //检查所有status状态是否全是BUSY 是true不是false
        boolean allMatch = emps.stream()
                .allMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(allMatch);

        //检查所有status状态至少有一个是BUSY 是true不是false
        boolean anyMatch = emps.stream()
                .anyMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(anyMatch);

        //检查所有status状态无一个是BUSY 没有true有false
        boolean noneMatch = emps.stream()
                .noneMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(noneMatch);

        //findFirst-返回第一个元素
        Optional<Employee> first = emps.stream()
                .sorted((x, y) -> Integer.compare(x.getSlary(), y.getSlary()))
                .findFirst();
        System.out.println(first.get());

        //findFirst-去任意一个元素，一般我们会先用filter过滤
        Optional<Employee> any = emps.stream()
                .filter((x) -> x.getStatus().equals(Employee.Status.IDLE))
                .findAny();
        System.out.println(any.get());

        //返回条数
        long count = emps.stream()
                .filter((x) -> x.getStatus().equals(Employee.Status.rest))
                .count();
        System.out.println(count);

        //找出最大值
        Optional<Employee> max = emps.stream()
                .max((x, y) -> Integer.compare(x.getSlary(), y.getSlary()));
        System.out.println(max.get());

        //找出最小值
        Optional<Integer> min = emps.stream()
                .map(Employee::getAge)
                .min(Integer::compareTo);
        System.out.println(min.get());
    }

    /**
     * 归约
     * reduce（T identity，Binaryoperator）/reduce（Binaryoperator）
     * 可以将流中元素反复结合起来，得到一个值。
     */
    @Test
    public void test6(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Integer reduce = list.stream()
                .reduce(9, (x, y) -> x % y);
        System.out.println(reduce);

        Optional<Integer> reduce1 = emps.stream()
                .map(Employee::getSlary)
                .reduce((x, y) -> Integer.sum(x,y));
        System.out.println(reduce1.get());

    }

    /**
     * 收集
     * collect一将流转换为其他形式。接收一个Collector接口的实现，
     * 用于给Stream中元素做汇总的方法
     */
    @Test
    public void test7(){
        //先通过映射取出名字，在将名字放在Collectors集合中
        List<String> collect = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        for (String s : collect) {
            System.out.println(s);
        }

        Double collect1 = emps.stream()
                .collect(Collectors.averagingInt(Employee::getSlary));
        System.out.println(collect1);

        Double collect2 = emps.stream()
                .collect(Collectors.summingDouble(Employee::getAge));
        System.out.println(collect2);
    }

    /**
     * 分组
     */
    @Test
    public void test8(){
        Map<Employee.Status, List<Employee>> collect = emps.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(collect);

        /**
         * 多级分组
         */
        long startTime = System.currentTimeMillis();    //获取开始时间

        Map<Employee.Status, Map<String, List<Employee>>> collect1 = emps.stream()
                .collect(Collectors.groupingBy(Employee::getStatus,
                        Collectors.groupingBy((e) -> {
                            if (((Employee) e).getAge() <= 20) {
                                return "青年";
                            } else if (((Employee) e).getAge() <= 50) {
                                return "中年";
                            } else {
                                return "老年";
                            }
                        })));
        System.out.println(collect1);


        long endTime = System.currentTimeMillis();    //获取结束时间

        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
    }

    /**
     * 分区
     */
    @Test
    public void test9(){
        // 大于50000一个区，小于50000一个区
        Map<Boolean, List<Employee>> collect = emps.stream()
                .collect(Collectors.partitioningBy((e) -> e.getSlary() > 500000));
        System.out.println(collect);
    }

    //另外一种方式取值
    @Test
    public void test10(){
        DoubleSummaryStatistics collect = emps.stream()
                .collect(Collectors.summarizingDouble(Employee::getSlary));
        System.out.println(collect.getSum());
        System.out.println(collect.getMax());
    }

    /**
     * 连接
     */
    @Test
    public void test11(){
        String collect = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(","));
        System.out.println(collect);
    }

    @Test
    public void test12(){
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        Integer reduce = integers.stream()
                .reduce(0, (x, y) -> x * y);
        System.out.println(reduce);
    }
}
