package test;

import java.io.Serializable;
import java.util.Objects;

/**
 * @ClassName HashCode
 * @Description
 * @Author xxh xinhui.xu@0071515.com
 * @Date 2020年11月05日 14:03
 **/
public class HashCode implements Serializable {

    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }



    public static void main(String[] args) {
    }


}
