import java.util.concurrent.Callable;

public class ConcurrentHashMapReader implements Callable<Object> {
    MapTestingClass mapTestingClass;
    int from;
    int to;

    public ConcurrentHashMapReader(MapTestingClass mapTestingClass, int from, int to) {
        this.mapTestingClass = mapTestingClass;
        this.from = from;
        this.to = to;
    }

    @Override
    public Object call() throws Exception {
        mapTestingClass.readFromConcurrentHashMap(from, to);
        return null;
    }
}
