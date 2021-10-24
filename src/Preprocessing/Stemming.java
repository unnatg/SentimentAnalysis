package Preprocessing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import edu.stanford.nlp.ling.CoreLabel;
import org.apache.commons.lang3.StringUtils;

public class Stemming {
    String filePath;
    public Stemming(String filePath){
        this.filePath = filePath;
    }
    private static final String [] stem1 = new String [] { "ो", "े", "ू", "ु", "ी", "ि", "ा" };
    private static final String [] stem2 = new String [] { "कर", "ाओ", "िए", "ाई", "ाए", "ने", "नी", "ना", "ते", "ीं", "ती",
            "ता", "ाँ", "ां", "ों", "ें" };
    private static final String [] stem3 = new String [] { "ाकर", "ाइए", "ाईं", "ाया", "ेगी", "ेगा", "ोगी", "ोगे", "ाने",
            "ाना", "ाते", "ाती", "ाता", "तीं", "ाओं", "ाएं", "ुओं", "ुएं", "ुआं" };
    private static final String [] stem4 = new String [] { "ाएगी", "ाएगा", "ाओगी", "ाओगे", "एंगी", "ेंगी", "एंगे", "ेंगे", "ूंगी",
            "ूंगा", "ातीं", "नाओं", "नाएं", "ताओं", "ताएं", "ियाँ", "ियों", "ियां" };
    private static final String [] stem5 = new String [] { "ाएंगी", "ाएंगे", "ाऊंगी", "ाऊंगा", "ाइयाँ", "ाइयों", "ाइयां" };
    private static final ArrayList<String []> stemList = new ArrayList<>(5);
    static int [] cut = new int [] { 0, 1, 1, 1, 2, 2 };
    static {
        stemList.add(stem5);
        stemList.add(stem4);
        stemList.add(stem3);
        stemList.add(stem2);
        stemList.add(stem1);
    }

    public ArrayList<List<CoreLabel>> tokenizeWords() throws IOException{
        Tokenization obj = new Tokenization(filePath);
        return (obj.tokenizeWords());
    }

    public String stemprocess(String word){
        int wlen = word.length();
        int wordlen = wlen*3;
        int icnt = 5;
        for (String [] stemwords : stemList){
            if(wordlen > (icnt + 1)){
                for(String sw: stemwords){
                    if(StringUtils.endsWith(word, sw)){
                        return StringUtils.substring(word, 0, wlen - cut[icnt]);
                    }
                }
            }
            icnt--;
        }
        return word;
    }

    public void stemmedWords() throws IOException{
        ArrayList<List<CoreLabel>> tokenizedWords = tokenizeWords();
//        for(List<CoreLabel> sentence: tokenizedWords){
//            for(CoreLabel coreLabel: sentence){
//                String words = String.valueOf(coreLabel);
//                //System.out.print(words+" ");
//                String stemmed_words = stemprocess(words);
//                System.out.print(stemmed_words+" ");
//            }
//            System.out.println();
//        }
        List<List<String>> stemmedList = new ArrayList<>();
        List<String> stemmedWords = new ArrayList<>();
        for(List<CoreLabel> sentence: tokenizedWords){
            for(CoreLabel coreLabel: sentence){
                String words = String.valueOf(coreLabel);
                String stemmedword = stemprocess(words);
                stemmedWords.add(stemmedword);
            }
            stemmedList.add(stemmedWords);
        }
        for(List<String> s: stemmedList){
            System.out.println(s+" ");
        }
    }

    public static void main(String [] argv) throws IOException {
        String filePath = "Dataset/Hindi Movie Reviews/Cleaned/ShuffledHindiText.csv";
        Stemming sm = new Stemming(filePath);
        sm.stemmedWords();
    }
}
