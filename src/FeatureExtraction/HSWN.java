package FeatureExtraction;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HSWN {

    public void PrintFile (String filePath) {
        try {
            File obj = new File(filePath);
            Scanner myReader = new Scanner(obj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        HSWN obj = new HSWN();
        String filePath = "Dataset/Hindi Lexicons/HindiSentiWordnet.txt";
        obj.PrintFile(filePath);
    }
}
