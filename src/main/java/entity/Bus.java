package entity;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;

/**
 * @ClassName Bus
 * @Description TODO
 * @Author 徐鑫辉
 * @Date 2019年11月16日 10:25
 **/
public class Bus extends Vehicle {
    //座位
    int seats;
    Type type;
    public static void main(String[] args) {
        Bus bus = new Bus();
        int num[] =new  int[]{1,2};
        bus.type = Type.TYPE2;
        System.out.println(bus.getRent(5));
        ArrayList<Object> objects = new ArrayList<>();
        objects.add("1");
        objects.remove("1");
        System.out.println(50 << 1);
        System.out.println(50 << 2);
        System.out.println(50 << 3);
        System.out.println(50 << 4);
        System.out.println(50 << 5);

    }

    @Override
    public double getRent(int days) {

        switch (type){
            case TYP4:  return 4;
            case TYPE1: return 1;
            case TYPE2: return 2;
            case TYPE3: return 3;
        }

        return 0;
    }


    public  enum  Type{
        TYPE1,
        TYPE2,
        TYPE3,
        TYP4


    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }


    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
