import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class day1{
    // value of final answer
    private static int finalAnswer = 0;
    
    public static void main(String[] args){
        String filePath = "./2024/day1/day1-input-test.txt";

        // testing file
        String testFilePath = "./2024/day1/day1-input-test.txt";

        try(BufferedReader reader = new BufferedReader(new FileReader(testFilePath))){
            String line = "";

            while((line = reader.readLine()) != null){
                // calling function while the file has not reached the end.
                locationIdsPartOne();
            }
        } catch(IOException e){
            System.out.println("error" + e);
        }

    }

    private static void locationIdsPartOne(){

    }
}