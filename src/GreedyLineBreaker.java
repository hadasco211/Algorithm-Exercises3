import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GreedyLineBreaker {

    public static class Line {
        List<String> words = new ArrayList<>();
        int currentLength = 0;

        public void addWord(String word) {
            if (!words.isEmpty()) {
                currentLength++;
            }
            words.add(word);
            currentLength += word.length();
        }

        public int getPenalty(int maxLineLength) {
            return maxLineLength - currentLength;
        }

        @Override
        public String toString() {
            return String.join(" ", words);
        }
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🧠 תרגיל שבירת טקסט לשורות (Greedy Line Breaking)");

        System.out.print("הכנס את אורך השורה המרבי (L): ");
        int maxLineLength = scanner.nextInt();
        scanner.nextLine(); 

        if (maxLineLength < 1) {
            System.out.println("❌ שגיאה: אורך שורה חייב להיות לפחות 1.");
            return;
        }

        System.out.println("הכנס את הטקסט (מילים מופרדות ברווח):");
        String text = scanner.nextLine().trim();

        if (text.isEmpty()) {
            System.out.println("❌ שגיאה: לא הוזנו מילים.");
            return;
        }

        List<String> words = List.of(text.split("\\s+"));

        for (String word : words) {
            if (word.length() > maxLineLength) {
                System.out.println("❌ שגיאה: המילה '" + word + "' ארוכה מהאורך המרבי של שורה (" + maxLineLength + ").");
                return;
            }
        }

        List<Line> lines = breakLines(words, maxLineLength);

        int totalPenalty = 0;
        System.out.println("\nשורות השבירה:");
        for (Line line : lines) {
            System.out.println(line);
            totalPenalty += line.getPenalty(maxLineLength);
        }

        System.out.println("\n📏 העונש הכולל: " + totalPenalty);
    }

    private static List<Line> breakLines(List<String> words, int maxLineLength) {
        List<Line> result = new ArrayList<>();
        Line currentLine = new Line();

        for (String word : words) {
            int neededLength = word.length() + (currentLine.words.isEmpty() ? 0 : 1);
            if (currentLine.currentLength + neededLength <= maxLineLength) {
                currentLine.addWord(word);
            } else {
                result.add(currentLine);
                currentLine = new Line();
                currentLine.addWord(word);
            }
        }

        if (!currentLine.words.isEmpty()) {
            result.add(currentLine);
        }

        return result;
    }
}
