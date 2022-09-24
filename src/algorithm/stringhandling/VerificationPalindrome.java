package algorithm.stringhandling;

public class VerificationPalindrome {

    public static void main(String[] args) {
        String s = "0P";
        boolean b=new VerificationPalindrome().isPalindrome(s);
        int a=1;
    }

    public boolean isPalindrome(String s) {
        int len=s.length();
        int l=0;
        int r=len-1;
        while(l<len&&r>=0&&l<=r){
            while(l<len&&!letterIsDigit(s.charAt(l))){
                l++;
            }
            while(r>=0&&!letterIsDigit(s.charAt(r))){
                r--;
            }
            if(l<=r){
                if(!elementEqual(s.charAt(l),s.charAt(r))){
                    return false;
                }
            }
            l++;
            r--;
        }
        return true;
    }

    private boolean elementEqual(char a, char b){
        boolean judgeAIsLetterOrDigit=letterOrDigit(a);
        boolean judgeBIsLetterOrDigit=letterOrDigit(b);

        if(judgeAIsLetterOrDigit==judgeBIsLetterOrDigit){
            if(!judgeAIsLetterOrDigit){ // is letter
                return Math.abs((int) a - (int) b)==32|| (int) a == (int) b;
            }else{ // is num
                return a==b;
            }
        }else{
            return false;
        }
    }

    private boolean letterIsDigit(char c){
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9';
    }

    private boolean letterOrDigit(char c){
        if(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z'){
            return false;
        }
        return true;
    }
}
