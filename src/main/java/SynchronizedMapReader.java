import java.util.concurrent.Callable;

public class SynchronizedMapReader implements Callable<Object> {
    MapTestingClass mapTestingClass;
    int from;
    int to;

    public SynchronizedMapReader(MapTestingClass mapTestingClass, int from, int to) {
        this.mapTestingClass = mapTestingClass;
        this.from = from;
        this.to = to;
    }

    @Override
    public Object call() throws Exception {
        mapTestingClass.readFromSynchronizedMap(from, to);
        return null;
    }
}
