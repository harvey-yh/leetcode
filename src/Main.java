import java.util.*;
import java.util.concurrent.*;

public class Main {

    public static final boolean FLAG = true;
    public static final byte BYTE = 123;
    public static final char X = 'X';
    public static final short SHORT = 12345;
    public static final int INT = 123456789;
    public static final long LONG = 12345678901L;
    public static final float PI = 3.14f;
    public static final double E = 2.71832;
    private int age;
    private String name;

    public Main() {}

    public Main(int age, String name) {
        this.age = age;
        this.name = name;
    }

    protected int add(int input) {
        int output = input+1;
        return output;
    }

    public static boolean compare(int a, int b) {
        return a > b;
    }

    public static void main(String[] args) throws RuntimeException {
        System.out.println("Hello World!");
        SnowFlake snowFlake=new SnowFlake(2,3);
        System.out.println(String.valueOf(snowFlake.nextId()));

        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.forEach(System.out::println);
        set.forEach(System.out::println);
    }


}
class Singleton{
    private static volatile Singleton singleton;
    private Singleton(){
    }
    public static synchronized Singleton getInstance(){
        if(singleton == null){
            synchronized (Singleton.class){
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}
