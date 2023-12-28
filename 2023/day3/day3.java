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
    public static ArrayList<Integer> finalNumbers = new ArrayList<Integer>();
    public static ArrayList<Integer> specialCharIndex = new ArrayList<Integer>();

    public static void main(String[] args){
        // length of each line is 100
        String file = "./2023/day3/day3input.txt";

        // length of each line is 10
        String testFile = "./2023/day3/day3input-test.txt";

        try(BufferedReader reader = new BufferedReader(new FileReader(testFile))){
            String line = "";

            while((line = reader.readLine()) != null){
                processLine(line);
            }
        }catch(IOException e){
            System.out.println("Error: " + e);
        }
        
    }

    public static void processLine(String line){
        String tempString = "";
        String stringNum = "";
        int num = 0;
        int endOfLine = line.length() - 1;
        System.out.println(line.length());
        for(int i = 0; i < line.length(); i++){
            char letter = line.charAt(i);
            tempString += letter;
            
            if(Character.isDigit(letter)){
                if((i < 0 && line.charAt(i-1) != '.' && !Character.isDigit(letter)) 
                    || (i != endOfLine && line.charAt(i+1) != '.' && !Character.isDigit(letter))){
                        stringNum = "";
                        break;
                }
                else{
                    stringNum += Character.toString(letter);
                }
            }
            else if(!Character.isDigit(letter) && stringNum != ""){
                num = Integer.parseInt(stringNum);
                finalNumbers.add(num);
                stringNum = "";
            }
        }
        for(int j = 0; j < line.length(); j++){
            char letter = line.charAt(j);

            if(letter != '.' && !Character.isDigit(letter)){
                specialCharIndex.add(j);
            }
        }
        //System.out.println(specialCharIndex);        
         System.out.println(finalNumbers);
    }
}

/*
 * array list of adding each index on which the number appears in the before row and after.
 * count each index and if there's a number then add it to the array list. then separate it to be single indexes
 * 
 */