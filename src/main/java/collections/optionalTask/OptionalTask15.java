package collections.optionalTask;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;

public class OptionalTask15 {
    String line;

    public OptionalTask15(String line) {
        this.line = line;
    }

    public String sortBrackets() {
        Queue<Character> stack = Collections.asLifoQueue(new ArrayDeque<>());
        for (int i = 0; i < line.length(); i++) {
            char bracket = line.charAt(i);
            if (bracket == '{') {
                stack.add(bracket);
            }
            if (bracket == '(') {
                stack.add(bracket);
            }
            if (bracket == '[') {
                stack.add(bracket);
            }
            if (bracket == '}') {
                stack.poll();
            }
            if (bracket == ')') {
                stack.poll();
            }
            if (bracket == ']') {
                stack.poll();
            }
        }
        if (stack.isEmpty()) {
            return "Скобки расставлены верно";
        }
        return "Скобки расставлены не верно";
    }
}
