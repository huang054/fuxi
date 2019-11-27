package forkjoin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * Hello world!
 *
 */
public class App extends RecursiveAction
{

    private final File path;

    public App(File path) {
        this.path = path;
    }

    public static void main( String[] args )
    {
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        App app=new App(new File("/Users/huangjun"));
        forkJoinPool.submit(app);
        app.join();
        forkJoinPool.shutdown();

    }

    @Override
    protected void compute() {
        List<App> list=new ArrayList<>();
        File[] files=path.listFiles();
        if (files!=null) {
            for(File file:files) {
                if (file.isDirectory()) {
                   list.add(new App(file));
                } else {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
        if(list.size()!=0){
            for (App app:invokeAll(list)){
                app.join();
            }
        }

    }
}
