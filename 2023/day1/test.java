import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<String> wordsToCheck = new ArrayList<>();
        wordsToCheck.add("first");
        wordsToCheck.add("thunder");
        wordsToCheck.add("stinky");

        String longString = "osidsfthundernasngoangoasfirstaosngasdasgasistinkyasibsgbagsdagabsodasndasd";

        for (String word : wordsToCheck) {
            if (longString.indexOf(word) != 1) {
                System.out.println("The word '" + word + "' is present in the long string.");
            } else {
                System.out.println("The word '" + word + "' is not present in the long string.");
            }
        }
    }
}
