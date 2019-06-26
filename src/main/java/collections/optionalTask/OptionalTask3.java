package collections.optionalTask;

import java.util.ArrayList;
import java.util.List;

public class OptionalTask3 {
    List<Byte> stack = new ArrayList<>();

    public byte pop() {
        byte item = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        return item;
    }

    public void push(byte item) {
        stack.add(item);
    }

    public byte peek() {
        byte item = stack.get(stack.size() - 1);
        return item;
    }

    public boolean empty() {
        return stack.size() == 0;
    }
}
