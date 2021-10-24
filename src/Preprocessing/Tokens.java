package Preprocessing;

import java.io.IOException;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

public class Tokens {
    String filePath;

    public Tokens(String filePath) {
        this.filePath = filePath;
    }

    public List<String[]> readFile() throws IOException {
        CSVReader obj = new CSVReader(filePath);
        return obj.csvFileReader();
    }

    public List<List<String[]>> tokenizeText() throws IOException {
        List<String[]> file = readFile();
        file.remove(0);
        List<String[]> sentences = new ArrayList<>();
        List<List<String[]>> completeTextData = new ArrayList<>();
        for (String[] sentence : file) {
            String textData = sentence[0];
            String[] textDataArray = textData.split(" ");
            sentences.add(textDataArray);
            completeTextData.add(sentences);
        }
        return completeTextData;
    }

    public List<Integer> tokenizeLabels() throws IOException {
        List<String[]> file = readFile();
        file.remove(0);
        List<Integer> labelsData = new ArrayList<>();
        for (String[] sentence : file) {
            String labels = sentence[1];
            labelsData.add(Integer.parseInt(labels));
        }
        return labelsData;
    }
}
//    public static void main(String[] args) throws IOException {
//        String filePath = "Dataset/Hindi Movie Reviews/Cleaned/CombinedHindiText.csv";
//        Tokens obj = new Tokens(filePath);
//        List<String[]> file = obj.readFile();
//        for(String[] i: file){
//            System.out.println(Arrays.toString(i));
//        }
//        List<List<String[]>> text = obj.tokenizeText();
//        List<Integer> labels = obj.tokenizeLabels();
//        for(List<String[]> sentences: text){
//            for(String[] sentence: sentences){
//                for(String words: sentence){
//                    System.out.print(words+" ");
//                }
//                System.out.println();
//            }
//        }
//        for(Integer i: labels){
//            System.out.println(i);
//        }
//    }
//}
