import java.io.*;
import java.util.*;

public class day4 {
    static int finalAnswerPartOne = 0;

    public static void findXmasWord(char[][] xmasGrid){
        String xmas = "XMAS";

        int rows = xmasGrid.length;
        int cols = xmasGrid[0].length;

        int[][] directions = {
            {0, 1}, // right
            {0, -1}, // left
            {1, 0}, // down
            {-1, 0}, // up
            {1, 1}, // down right
            {-1, -1}, // up left
            {1, -1}, // down left
            {-1, 1}, // up right
        };

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                for(int[] multipleDir : directions){
                    int directionRow = multipleDir[0];
                    int directionCol = multipleDir[1];
                    
                    if(canFindWord(xmasGrid, xmas, r, c, directionRow, directionCol, rows, cols)){
                        finalAnswerPartOne++;
                    }
                }
            }
        }
    }

    public static boolean canFindWord(char[][] xmasGrid, String xmas, int r, int c, int directionRow, int directionCol, int rows, int cols){
        for(int i = 0; i < xmas.length(); i++){
            int newRow = r + i * directionRow;
            int newCol = c + i * directionCol;

            if(newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols || xmasGrid[newRow][newCol] != xmas.charAt(i)){
                return false;
            }
        }

        return true;
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

        System.out.println(finalAnswerPartOne);
    }
}
