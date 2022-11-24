package algorithm.pointer;

// url:https://leetcode.cn/problems/expressive-words/
public class ExpressiveWords {


    public int expressiveWords(String s, String[] words) {
        int res=0;
        for(String sub:words){
            if(can(s,sub)){
                res++;
            }
        }
        return res;
    }

    private boolean can(String main_, String word){
        int main_pointer=0,word_pointer=0;
        while(main_pointer<main_.length()&&word_pointer<word.length()){
            if(main_.charAt(main_pointer)!=word.charAt(word_pointer)){
                return false;
            }
            char mainch=main_.charAt(main_pointer);
            int mainnum=0;
            while(main_pointer<main_.length()&&main_.charAt(main_pointer)==mainch){
                mainnum++;
                main_pointer++;
            }
            char wordch=word.charAt(word_pointer);
            int wordnum=0;
            while(word_pointer<word.length()&&word.charAt(word_pointer)==wordch){
                wordnum++;
                word_pointer++;
            }
            if(mainnum<wordnum){
                return false;
            }
            if(mainnum!=wordnum&&mainnum<3){
                return false;
            }
        }
        return main_pointer==main_.length() && word_pointer==word.length();
    }
}
