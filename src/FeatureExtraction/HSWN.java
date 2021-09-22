package FeatureExtraction;

import Preprocessing.TxtReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

public class HSWN {
    String filePath;
    public HSWN(String filePath){
        this.filePath = filePath;
    }
    public List<String[]> readFile() throws IOException {
        TxtReader obj = new TxtReader(filePath);
        return obj.txtFileReader();
    }
    public void parseFile() throws IOException{
        Map<String[], Double[]> sentimentPolarity = new HashMap<>();
        List<String[]> hindiSentiWordNet = readFile();
        for(String[] sentence: hindiSentiWordNet){

        }
//        return sentimentPolarity;
    }
    public static void main(String[] args) throws IOException {
        String filePath = "Dataset/Hindi Lexicons/HindiSentiWordnet.txt";
        HSWN obj = new HSWN(filePath);

//        obj.parseFile();
    }
}
