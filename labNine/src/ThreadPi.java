import java.util.concurrent.Callable;

class ThreadPi implements Callable<Double> {

    private final long dropsToUse;

    public ThreadPi(long drops, long countOfThreads) {
        this.dropsToUse = drops / countOfThreads;
    }

    @Override
    public Double call() throws Exception {

        double in = 0;
        for (long i = 0; i < dropsToUse; i++) {
            double x = Math.random();
            double y = Math.random();

            if (x * x + y * y <= 1) {
                in++;
            }
        }
        return in;
    }

}