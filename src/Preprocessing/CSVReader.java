package Preprocessing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    String filePath;
    public CSVReader(String filePath) {
        this.filePath = filePath;
    }

    public List<String[]> csvFileReader() throws IOException {
        String line;
        List<String[]> list = new ArrayList<>();
        // Faster than Scanner
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        while ((line = br.readLine()) != null) {
//            System.out.println(line);
            String[] values = line.split(",");
            list.add(values);
        }
        return list;
    }
}
//    public static void main(String[] args) throws IOException {
//        //HindiText, Sentiment --> Two columns
//        CSVReader obj = new CSVReader();
//        String filePath = "Dataset/Hindi Movie Reviews/Cleaned/ShuffledHindiText.csv";
//        List<String[]> list = obj.csvFileReader(filePath);
//    }
//}
