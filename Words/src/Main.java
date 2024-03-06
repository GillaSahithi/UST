import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] words = {"Sahithi", "Srinu", "Manish", "Sai", "Laxmi", "Bhagya", "Ram", "Sravani"};
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length: ");
        int l = sc.nextInt();
        List<String> result = filterWordsByLength(words, l);
        System.out.println("words of length " +l + ": "+ result);
    }
    public static List<String> filterWordsByLength(String[] words, int length) {
        List<String> arr = new ArrayList<>();

        for (String word : words) {
            if (word.length() == length) {
                arr.add(word);
            }
        }
        return arr;
    }
}
