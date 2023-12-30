/*
 * loop through first row, check if special char is next to num go next line. store special char indexes
 * loop through second row, check if special char is next to num, check if next to above special chars. store specal chars
 * loop through third row same, check if top row is char and bottom and current. 
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class day3 {
    public static int finalAnswer = 0;
    public static ArrayList<Integer> numbersList = new ArrayList<Integer>();
    public static String[] stringLines = new String[10];
    //public static char[] symbols = {'!', '@', '#', '$', '%', '^', '&', '*', '/', '-', '+'};
    public static ArrayList<Character> symbols = new ArrayList<Character>();

    public static void main(String[] args){
        // length of each line is 100
        String file = "./2023/day3/day3input.txt";

        // length of each line is 10
        String testFile = "./2023/day3/day3input-test.txt";
        int testCount = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader(testFile))){
            String line = "";

            while((line = reader.readLine()) != null){
                stringLines[testCount] = line;
                stringLines[testCount] += ".";
                testCount++;
            }
        }catch(IOException e){
            System.out.println("Error: " + e);
        }
        processLines(stringLines);
    }

    public static void processLines(String[] stringLines){
        String stringNum = "";
        String tempStringUp = "";
        String tempStringDown = "";
        char letterB = 'a';
        char letterF = 'a';
        int number = 0;

        symbols.add('!');
        symbols.add('@');
        symbols.add('#');
        symbols.add('$');
        symbols.add('%');
        symbols.add('^');
        symbols.add('&');
        symbols.add('*');
        symbols.add('/');
        symbols.add('-');
        symbols.add('+');

        for(int i = 0; i < stringLines.length; i++){
            for(int j = 0; j < stringLines[i].length(); j++){
                char letter = stringLines[i].charAt(j);
                if(j >= stringLines[i].length()){
                    letterF = stringLines[i].charAt(j + 1);
                }
                if(j > 0){
                    letterB = stringLines[i].charAt(j - 1);
                }
                
                
                if(Character.isDigit(letter) && (symbols.contains(letterB) || symbols.contains(letterF))){
                    stringNum += letter;
                }
                else if(!Character.isDigit(letter) && stringNum != ""){
                    number = Integer.parseInt(stringNum);
                    numbersList.add(number);
                    stringNum = "";
                }
            }
        }
    }
}
