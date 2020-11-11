package test;

import java.util.Optional;

/**
 * @ClassName NewMan
 * @Description TODO
 * @Author 徐鑫辉
 * @Date 2019年11月10日 10:52
 **/
public class NewMan {
    private Optional<Gooddess> gooddess = Optional.empty();

    public Optional<Gooddess> getGooddess() {
        return gooddess;
    }

    public void setGooddess(Optional<Gooddess> gooddess) {
        this.gooddess = gooddess;
    }

    @Override
    public String toString() {
        return "NewMan{" +
                "gooddess=" + gooddess +
                '}';
    }
}
