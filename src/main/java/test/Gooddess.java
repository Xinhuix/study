package test;

/**
 * @ClassName Gooddess
 * @Description TODO
 * @Author 徐鑫辉
 * @Date 2019年11月10日 10:42
 **/
public class Gooddess {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gooddess(String name) {
        this.name = name;
    }

    public Gooddess() {
        super();
    }

    @Override
    public String toString() {
        return "Gooddess{" +
                "name='" + name + '\'' +
                '}';
    }
}
