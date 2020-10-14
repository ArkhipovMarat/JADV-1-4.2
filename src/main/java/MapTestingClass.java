import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapTestingClass {
    Map<Double, Double> synchronizedMap;
    Map<Double, Double> concurrentHashMap;
    Double[] randomArray;

    public MapTestingClass(Double[] randomArray) {
        this.synchronizedMap = Collections.synchronizedMap(new HashMap<>());
        this.concurrentHashMap = new ConcurrentHashMap<>();
        this.randomArray = randomArray;
    }

    public void writeToSynchronizedMap (int from, int to) {
        for (int i = from; i < to; i++) {
            Double element = randomArray[i];
            synchronizedMap.put(element,element);
        }
    }

    public void readFromSynchronizedMap (int from, int to) {
        for (int i = from; i < to; i++) {
            Double element = randomArray[i];
            synchronizedMap.get(element);
        }
    }

    public void writeToConcurrentHashMap (int from, int to) {
        for (int i = from; i < to; i++) {
            Double element = randomArray[i];
            concurrentHashMap.put(element,element);
        }
    }

    public void readFromConcurrentHashMap (int from, int to) {
        for (int i = from; i < to; i++) {
            Double element = randomArray[i];
            concurrentHashMap.get(element);
        }
    }

    public Map<Double, Double> getSynchronizedMap() {
        return synchronizedMap;
    }

    public Map<Double, Double> getConcurrentHashMap() {
        return concurrentHashMap;
    }
}
