package Task_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Task_3 {
    public static void main(String[] args) {
                try {
            Scanner scan = new Scanner(new File("src/Task_3/input.txt"));
            List<String> lines = new ArrayList<>();

            while (scan.hasNextLine()) {
                String s = scan.nextLine();
                lines.add(s);
                System.out.println(s);
            }

            Collections.sort(lines, LINE_LENGTH_COMPARATOR);
            System.out.println("\nSort poem\n");

            for (String line: lines) {
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Exeption");
            e.printStackTrace();
        }
    }

    private static final Comparator<String> LINE_LENGTH_COMPARATOR = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return o1.length() - o2.length();
        }
    };
}
