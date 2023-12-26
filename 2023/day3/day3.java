import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class day3 {
    public static int finalAnswer = 0;
    public static ArrayList<Integer> finalNumbers = new ArrayList<Integer>();

    public static void main(String[] args){
        String file = "./2023/day3/day3input.txt";

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
        
        for(int i = 0; i < line.length(); i++){
            char letter = line.charAt(i);
            tempString += letter;

            if(Character.isDigit(letter)){
                stringNum += Character.toString(letter);
            }
            else if(!Character.isDigit(letter) && stringNum != ""){
                num = Integer.parseInt(stringNum);
                finalNumbers.add(num);
                stringNum = "";
            }
        }
        System.out.println(finalNumbers);
    }
}
