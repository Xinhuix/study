import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @ClassName BlockingTest
 * @Description
 * @Author xxh xinhui.xu@0071515.com
 * @Date 2020年10月23日 13:43
 **/
public class BlockingTest {

    public static void main(String[] args) throws InterruptedException {
        // 创建一个长度为 5 的阻塞队列
        ArrayBlockingQueue q1 = new ArrayBlockingQueue(5);

        // 新创建一个线程执行入列
        new Thread(() -> {

            // 循环 10 次
            for (int i = 0; i < 10; i++) {
                System.out.println("线程111");
                try {
                    q1.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(new Date() + " | ArrayBlockingQueue Size:" + q1.size());
            }
            System.out.println(new Date() + " | For End.");
        }).start();

        // 新创建一个线程执行出列
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("线程2");
                try {
                    // 休眠 1S
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (!q1.isEmpty()) {
                    try {
                        q1.take(); // 出列
                        System.out.println(q1.size());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
