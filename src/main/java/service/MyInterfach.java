package service;

/**
 * @ClassName MyInterfach
 * @Description TODO
 * @Author 徐鑫辉
 * @Date 2019年11月10日 11:31
 **/
public interface MyInterfach {

    default String getName(){
        return "鑫辉";
    }

    String getAgeTest();


}
