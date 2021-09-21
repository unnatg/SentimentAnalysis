package Preprocessing;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Tokenization{
    String filePath;
    public Tokenization(String filePath){
        this.filePath = filePath;
    }
    public Properties buildTokenizePipeline(){
        // set up pipeline properties
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize");
        return props;
    }
    public List<String[]> readFile() throws IOException {
        CSVReader obj = new CSVReader(filePath);
        return obj.csvFileReader();
    }
    public ArrayList<List<CoreLabel>> tokenizeWords() throws IOException {
        // Pipeline Properties
        Properties prop = buildTokenizePipeline();
        // build the pipeline
        StanfordCoreNLP pipeline = new StanfordCoreNLP(prop);
        List<String[]> list = readFile();
        ArrayList<List<CoreLabel>> wordsList= new ArrayList<>();
        for(String[] text: list) {
            CoreDocument document = new CoreDocument(text[0]);
            pipeline.annotate(document);
            wordsList.add(document.tokens());
        }
        return wordsList;
    }
    public ArrayList<List<CoreLabel>> tokenizeLabels() throws IOException {
        // Pipeline Properties
        Properties prop = buildTokenizePipeline();
        // build the pipeline
        StanfordCoreNLP pipeline = new StanfordCoreNLP(prop);
        List<String[]> list = readFile();
        ArrayList<List<CoreLabel>> labelsList= new ArrayList<>();
        for(String[] text: list) {
            CoreDocument document = new CoreDocument(text[1]);
            pipeline.annotate(document);
            labelsList.add(document.tokens());
        }
        return labelsList;
    }

//    public static void main(String[] args) throws IOException {
//        String filePath = "Dataset/Hindi Movie Reviews/Cleaned/ShuffledHindiText.csv";
//        Tokenization obj = new Tokenization(filePath);
//        ArrayList<List<CoreLabel>> tokenizedWords = obj.tokenizeWords();
//        ArrayList<List<CoreLabel>> tokenizeLabels = obj.tokenizeLabels();
//        System.out.println(tokenizedWords);
//        System.out.println(tokenizeLabels);
//    }
}
