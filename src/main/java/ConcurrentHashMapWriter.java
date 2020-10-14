import java.util.concurrent.Callable;

public class ConcurrentHashMapWriter implements Callable<Object> {
    MapTestingClass mapTestingClass;
    int from;
    int to;

    public ConcurrentHashMapWriter(MapTestingClass mapTestingClass, int from, int to) {
        this.mapTestingClass = mapTestingClass;
        this.from = from;
        this.to = to;
    }

    @Override
    public Object call() throws Exception {
        mapTestingClass.writeToSynchronizedMap(from,to);
        return null;
    }
}
