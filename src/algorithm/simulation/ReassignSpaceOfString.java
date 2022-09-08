package algorithm.simulation;

import java.util.ArrayList;
import java.util.List;

public class ReassignSpaceOfString {

    public static void main(String[] args) {
        ReassignSpaceOfString s = new ReassignSpaceOfString();
        s.reorderSpaces("  walks  udp package   into  bar a");
    }

    public String reorderSpaces(String text) {
        int len=text.length();
        List<String> cArray=new ArrayList<>(len);
        int numOfBlank=0;
        boolean wordOrSpace=true;
        boolean word=true,space=false;
        int idxWordStart=0;
        for(int i=0;i<len;i++){
            if(text.charAt(i)==' '){
                if(wordOrSpace==word){
                    if(idxWordStart!=i){
                        String sub=text.substring(idxWordStart, i);
                        cArray.add(sub);
                    }
                    wordOrSpace=space;
                }
                numOfBlank++;
            }else{
                if(wordOrSpace==space){
                    idxWordStart=i;
                    wordOrSpace=word;
                }
                if(i==len-1){
                    String sub=text.substring(idxWordStart);
                    cArray.add(sub);
                }
            }
        }

        StringBuilder sb=new StringBuilder(len);
        int lastLocationSpaceNum=0;

        if(cArray.size()==1){
            lastLocationSpaceNum=len-cArray.get(0).length();
            sb.append(cArray.get(0));
            sb.append(" ".repeat(Math.max(0, lastLocationSpaceNum)));

        }else {
            int averageSpaceNum = numOfBlank / (cArray.size() - 1);

            if (numOfBlank % (cArray.size() - 1) != 0) {
                lastLocationSpaceNum = numOfBlank - averageSpaceNum * (cArray.size() - 1);
            }
            for (int i = 0; i < cArray.size(); i++) {
                sb.append(cArray.get(i));
                if (i < cArray.size() - 1) {
                    sb.append(" ".repeat(Math.max(0, averageSpaceNum)));
                } else {
                    sb.append(" ".repeat(Math.max(0, lastLocationSpaceNum)));
                }
            }
        }
        return sb.toString();
    }
}
