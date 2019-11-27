package forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class Sum extends RecursiveTask<Long> {

    private static final long THRESHOLD = 10L;

    private final long from;

    private final long to;

    private final List<Long> longs;

    public Sum(long from, long to,List<Long> longs) {
        this.from = from;
        this.to = to;
        this.longs = longs;
    }


    @Override
    protected Long compute() {
        if (to-from<=THRESHOLD){
            long sum=0;
            for (int i=0;i<longs.size();i++){
                sum+=longs.get(i);
            }
            return sum;
        }else {
            long middle=(from+to)/2;
            Sum fr=new Sum(from,middle,longs);
            Sum t=new Sum(middle+1,to,longs);
            invokeAll(fr,t);
            return fr.join()+t.join();

        }

    }

    public static void main(String[] args) {
        List<Long> longs=new ArrayList<>();
        for (long i=0;i<100000;i++){
            longs.add(i);
        }
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Sum sum=new Sum(0,longs.size()-1,longs);
        forkJoinPool.invoke(sum);
        long ll= sum.join();
        System.out.println(ll);
    }
}
