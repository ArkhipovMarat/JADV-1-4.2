import java.util.concurrent.Callable;

public class SynchronizedMapWriter implements Callable<Object> {
    MapTestingClass mapTestingClass;
    int from;
    int to;

    public SynchronizedMapWriter(MapTestingClass mapTestingClass, int from, int to) {
        this.mapTestingClass = mapTestingClass;
        this.from = from;
        this.to = to;
    }


    @Override
    public Object call() throws Exception {
        mapTestingClass.writeToSynchronizedMap(from, to);
        return null;
    }
}
