import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class day3 {
    static int finalAnswerPartOne = 0;

    public static void mullItOverPartOne(String line){
        System.out.println("test");
    }

    public static void main(String[] args){
        // String filePath = "./2024/day3/day3-input.txt";
        String filePath = "./2024/day3/day3-input-test.txt";

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line = "";

            while((line = reader.readLine()) != null){
                mullItOverPartOne(line);
            }
        }catch(IOException e){
            System.out.println("Error: " + e);
        }
    }
}
