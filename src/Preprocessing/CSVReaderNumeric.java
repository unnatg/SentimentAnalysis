package Preprocessing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CSVReaderNumeric {
    String filePath;

    public CSVReaderNumeric(String filePath) {
        this.filePath = filePath;
    }

    public List<double[]> csvFileReader() throws IOException {
        String line;
        List<double[]> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        while ((line = br.readLine()) != null) {
            double[] numList = Stream.of(line.split(","))
                    .mapToDouble(Double::parseDouble)
                    .toArray();
            list.add(numList);
        }
        return list;
    }

//    public static void main(String[] args) throws IOException {
//        List<double[]> list = new CSVReaderNumeric("Dataset/SplitTfidf/Unigram/Training/x_train.csv").
//                csvFileReader();
//    }
}