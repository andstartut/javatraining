package collections.optionalTask;

import java.util.Deque;
import java.util.Queue;

public class OptionalTask9 {
    Queue<Integer> U;
    Deque<Float> I;
    int voltage;
    float amperage;

    public OptionalTask9(Queue<Integer> u, Deque<Float> i) {
        U = u;
        I = i;
    }

    public float getResistance() {
        while (!U.isEmpty()) {
            voltage += U.poll();
        }
        while (!I.isEmpty()) {
            amperage += I.pop();
        }
        return voltage / amperage;
    }
}
