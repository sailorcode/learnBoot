import java.io.File;
import java.util.ArrayList;
import java.util.stream.Stream;

public class LamabdaTest {
    public static void main(String[] args) {
        int a=caculate(3,(b)->{
           return (int)b;
        });
        System.out.println(a);
        new File("").listFiles();
        //new ArrayList<String>().stream().map();
		develop System.out.println(a);
    }
 @FunctionalInterface
    interface handler<T>{
       int handle(T a);
    }

    public static int caculate (int a,handler h){
        return h.handle(a);
    }
}
