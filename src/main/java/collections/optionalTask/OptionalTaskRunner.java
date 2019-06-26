package collections.optionalTask;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class OptionalTaskRunner {
    public static void main(String[] args) throws IOException {

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        File file = new File(classLoader.getResource("bin").getFile());
        FileInputStream fileIn = new FileInputStream(file);
        byte i;
        OptionalTask3 stack = new OptionalTask3();
        while ((i = (byte) fileIn.read()) != -1) {
            stack.push(i);
        }
        System.out.println(stack.empty());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
        fileIn.close();

        List<String> verse = Arrays.asList(
                "В лесу родилась ёлочка,",
                "В лесу она росла.",
                "Зимой и летом стройная,",
                "Зелёная была."
        );
        Comparator<String> comparator = new OptionalTask6();
        Collections.sort(verse, comparator);
        for (String item : verse) {
            System.out.println(item);
        }

        Queue<Integer> voltage = Collections.asLifoQueue(new ArrayDeque<Integer>());
        voltage.addAll(Arrays.asList(12, 24, 48, 110, 220));
        Deque<Float> amperage = new ArrayDeque<>();
        amperage.addAll(Arrays.asList(5f, 2f, 1f, 0.5f, 0.25f));
        OptionalTask9 resistance = new OptionalTask9(voltage, amperage);
        System.out.println(resistance.getResistance());

        String brackets = "(, ), [, ], {, }";
        OptionalTask15 checkBrackets = new OptionalTask15(brackets);
        System.out.println(checkBrackets.sortBrackets());
    }
}



