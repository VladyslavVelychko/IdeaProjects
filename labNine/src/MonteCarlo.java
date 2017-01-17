import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MonteCarlo {

    public static final long DROPS = 10_000_000;

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        long startTime = System.currentTimeMillis();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Count of threads: ");
        int n = Integer.parseInt(reader.readLine());

        ExecutorService exec = Executors.newCachedThreadPool();
        List<Future<Double>> eList = new ArrayList<>();

        for (int i = 0; i < n; i++){
            eList.add(exec.submit(new ThreadPi(DROPS, n)));
        }

        exec.shutdown();

        double pi = 0;
        for (Future future : eList){
            pi += (double)future.get();
        }
        System.out.println("concurrent : " + pi / DROPS * 4);
        System.out.println("working : " + (System.currentTimeMillis() - startTime) + " ms");
    }

}