import java.io.*;
import java.util.*;

public class day4 {
    static int finalAnswerPartOne = 0;

    public static void findXmasWord(char[][] xmasGrid){
        String xmas = "XMAS";

        int rows = xmasGrid.length;
        int cols = xmasGrid[0].length;

        
    }
    
    public static void main(String[] args){
        String filePath = "./2024/day4/day4-input-test.txt";
        // String filePath = "./2024/day4/day4-input.txt";

        List<char[]> xmasList = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line = "";

            while((line = reader.readLine()) != null){
                // adding each line to a list, then going to convert that list into a 2d array
                xmasList.add(line.toCharArray());
            }
        }catch(IOException e){
            System.out.println("error: " + e);
        }
        
        // converting the list to a 2d array
        char[][] xmasListGrid = xmasList.toArray(new char[0][]);

        // call function for part 1 passing the 2d array
        findXmasWord(xmasListGrid);
    }
}
