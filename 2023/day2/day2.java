import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class day2 {
    public static int finalAnswer = 0;
    public static void main(String[] args){
        //String file = "./2023/day2/day2input.txt";

        // test file
        String file = "./2023/day2/day2input-test.txt";

        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line = "";

            while((line = reader.readLine()) != null){
                processLine(line);
            }
        }catch(IOException e){
            System.out.println("error: " + e);
        }
    }

    public static void processLine(String fileLine){
        int id = 0;
        int redCount = 0;
        int blueCount = 0;
        int greenCount = 0;

        // splitting everything into two sections. splitting in between the colon
        String[] sections = fileLine.split(":");

        // sections[0] is everything before the colon, and only grabbing the id number
        String numBefore = sections[0].replaceAll("[^0-9]", "");

        // sections[1] is everything after the colon
        String numAfter = sections[1];

        
    }
}
