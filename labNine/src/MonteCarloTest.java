import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MonteCarloTest {

    @Test
    public void Pull_1t_1e7_Test() throws Exception {
        final long drops = 10_000_000;
        ExecutorService ex = Executors.newCachedThreadPool();

        Future<Double> f =  ex.submit(new ThreadPi(drops, 1));
        ex.shutdown();

        double pi = Math.floor((f.get() / drops * 4) * 100) / 100;
        System.out.println(pi);
        Assert.assertTrue(pi == 3.14);
    }

    @Test
    public void Pull_2t_1e7_Test() throws Exception {
        final long drops = 10_000_000;
        ExecutorService ex = Executors.newCachedThreadPool();

        Future<Double> f1 =  ex.submit(new ThreadPi(drops, 2));
        Future<Double> f2 =  ex.submit(new ThreadPi(drops, 2));
        ex.shutdown();

        double pi = Math.floor(((f1.get() + f2.get()) / drops * 4) * 100) / 100;
        System.out.println(pi);
        Assert.assertTrue(pi == 3.14);

    }

    @Test
    public void Pull_4t_1e7_Test() throws Exception {
        final long drops = 10_000_000;
        ExecutorService ex = Executors.newCachedThreadPool();

        Future<Double> f1 =  ex.submit(new ThreadPi(drops, 4));
        Future<Double> f2 =  ex.submit(new ThreadPi(drops, 4));
        Future<Double> f3 =  ex.submit(new ThreadPi(drops, 4));
        Future<Double> f4 =  ex.submit(new ThreadPi(drops, 4));
        ex.shutdown();

        double pi = Math.floor(((f1.get() + f2.get() + f3.get() + f4.get()) / drops * 4) * 100) / 100;
        System.out.println(pi);
        Assert.assertTrue(pi == 3.14);
    }

    @Test
    public void Pull_1t_1e4_Test() throws Exception {
        final long drops = 10000;
        ExecutorService ex = Executors.newCachedThreadPool();

        Future<Double> f =  ex.submit(new ThreadPi(drops, 1));
        ex.shutdown();

        double pi = Math.floor((f.get() / drops * 4) * 100) / 100;
        System.out.println(pi);
        Assert.assertTrue(pi == 3.14);
    }


    @Test
    public void Old_1t_1e7_Test() throws Exception {
        final long drops = 10_000_000;

        OldThreadPi o = new OldThreadPi(drops, 1);
        o.start();

        o.join();

        double pi = Math.floor(((double) o.getpResult() / drops * 4) * 100) / 100;
        System.out.println(pi);
        Assert.assertTrue(pi == 3.14);

    }

    @Test
    public void Old_2t_1e7_Test() throws Exception {
        final long drops = 10_000_000;

        OldThreadPi o1 = new OldThreadPi(drops, 2);
        o1.start();
        OldThreadPi o2 = new OldThreadPi(drops, 2);
        o2.start();

        o1.join();
        o2.join();

        double res = o1.getpResult() + o2.getpResult();

        double pi = Math.floor((res / drops * 4) * 100) / 100;
        System.out.println(pi);
        Assert.assertTrue(pi == 3.14);
    }

    @Test
    public void Old_4t_1e7_Test() throws Exception {
        final long drops = 10_000_000;

        OldThreadPi o1 = new OldThreadPi(drops, 4);
        o1.start();
        OldThreadPi o2 = new OldThreadPi(drops, 4);
        o2.start();

        OldThreadPi o3 = new OldThreadPi(drops, 4);
        o3.start();
        OldThreadPi o4 = new OldThreadPi(drops, 4);
        o4.start();

        o1.join();
        o2.join();
        o3.join();
        o4.join();

        double res = o1.getpResult() + o2.getpResult() + o3.getpResult() + o4.getpResult();

        double pi = Math.floor((res / drops * 4) * 100) / 100;
        System.out.println(pi);
        Assert.assertTrue(pi == 3.14);

    }

}