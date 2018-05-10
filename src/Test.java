import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Zhou Guanliang
 * @since 2018/5/10
 */
public class Test {
    private static ExecutorService pool= Executors.newFixedThreadPool(10);

    public static void start(){
        pool.submit(()->{
           while(true){
               Thread.sleep(2000);
               Game.pet.fallPiece();
               System.out.println(Game.pet.toString());
           }
        });
    }
}