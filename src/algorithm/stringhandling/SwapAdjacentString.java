package algorithm.stringhandling;

// url:https://leetcode.cn/problems/swap-adjacent-in-lr-string
public class SwapAdjacentString {

    public boolean canTransform(String start, String target) {
        int i=0,j=0;
        int l=start.length();
        while(i<l&&j<l){
            while(i<l&&start.charAt(i)=='X'){
                i++;
            }
            while(j<l&&target.charAt(j)=='X'){
                j++;
            }
            if(i<l&&j<l){
                if(start.charAt(i)!=target.charAt(j)){
                    return false;
                }
                char c=start.charAt(i);
                if((c=='R'&&i>j)||(c=='L'&&i<j)){
                    return false;
                }
                i++;
                j++;
            }
        }
        while(i<l){
            if(start.charAt(i)!='X'){
                return false;
            }
            i++;
        }
        while(j<l){
            if(target.charAt(j)!='X'){
                return false;
            }
            j++;
        }
        return true;
    }
}
