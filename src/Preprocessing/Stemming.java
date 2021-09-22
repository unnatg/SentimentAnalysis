package Preprocessing;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;


public class Stemming {

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
    public Stemming(){
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
    public static void main(String [] argv){
        Stemming sm = new Stemming();
        String word = "रास्ते";
        System.out.println(sm.stemprocess(word));
    }

}
