package 创建对象的4中方式;

/**
 * @ClassName createClassType
 * @Description
 * @Author xxh xinhui.xu@0071515.com
 * @Date 2020年11月09日 23:15
 **/
public class createClassType {


    /**
     * 1、通过普通的new的方式
     *
     * 2、通过反射机制创建对象
     * Constructor<User> constructor = User.class.getConstructor();
     * User user = constructor.newInstance();
     *
     * 3、使用clone方式创建
     *     无论何时我们调用一个对象的clone方法，JVM就会创建一个新的对象，将
     *     原始的对象数据全部克隆过去。
     */



}

class CloneTest implements Cloneable{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public CloneTest(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        try {
            CloneTest cloneTest = new CloneTest("wangql",18);
            CloneTest copyClone = (CloneTest) cloneTest.clone();
            System.out.println("newclone:"+cloneTest.getName());
            System.out.println("copyClone:"+copyClone.getName());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

}