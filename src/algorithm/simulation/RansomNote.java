package algorithm.simulation;

// url:https://leetcode.cn/problems/ransom-note
// 这题可以用计数法，比较简单就不写了
public class RansomNote {

    public static void main(String[] args) {
        String a="aab",b="baa";
        boolean flag=new RansomNote().canConstruct(a,b);
        int i=1;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        for(int i=0;i<ransomNote.length();i++){
            for(int j=0;j<magazine.length();j++){
                if(ransomNote.charAt(i)==magazine.charAt(j)){
                    ransomNote=ransomNote.substring(0,i)+'#'+ransomNote.substring(i+1);
                    magazine=magazine.substring(0,j)+'#'+magazine.substring(j+1);
                    break;
                }
            }
        }
        for(int i=0;i<ransomNote.length();i++){
            if(ransomNote.charAt(i)!='#'){
                return false;
            }
        }
        return true;
    }
}
