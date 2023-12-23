import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class day2 {
    public static void main(String[] args){
        String file = "./2023/day2/day2input.txt";

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

        for(int i = 0; i < fileLine.length(); i++){
            
        }
    }
}
