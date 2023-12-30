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
    public static String[] stringLines = new String[10];
    public static char[] symbols = {'!', '@', '#', '$', '%', '^', '&', '*', '/', '-', '+'};

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
        int maxLength = 0;
        char[][] charArray = new char[stringLines.length][maxLength];
        for(int i = 0; i < stringLines.length; i++){
            for(int j = 0; j < stringLines[i].length() - 1; j++){
                charArray[i][j] = stringLines[i].charAt(j);
                System.out.println(charArray[i][j]);
            }
        }
    }
}

/*
 * array list of adding each index on which the number appears in the before row and after.
 * count each index and if there's a number then add it to the array list. then separate it to be single indexes
 * 
 */