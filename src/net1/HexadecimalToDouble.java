package net1;

public class HexadecimalToDouble {
    // 40170A3D70A3D70A
    // 5.76
    // 405F47AE147AE148
    // 125.12
    boolean zhengfu = true; // true正false负

    public static void main(String[] args) {
        String s = "40170A3D70A3D70A";
        //String s = "1";
        // 0100 0000 0101 1111 0100 0111 1010 1110 0001 0100 0111 1010 1110 0001 0100 1000
        HexadecimalToDouble h = new HexadecimalToDouble();
        char[] binary = h.hex2Dinary(s);
        h.hex2Double(binary);
    }



    private char[] hex2Dinary(String s) {
        char[] old = s.toCharArray();
        char[] nnew = new char[64];
        int i = 0;
        for(char a:old) {
            char[] aa = hex2DinSingle(a);
            int j = 3;
            while(j>=0) {
                try {
                    nnew[i++] = aa[j--];
                } catch (NullPointerException e) {
                    e.printStackTrace();
                    nnew[i] = 'X';
                }
            }
        }
        return nnew;
    }

    private char[] hex2DinSingle(char s) {
        if(0<=s-'0'&&9>=s-'0') {
            int i = s - '0';
            char[] c = new char[4];
            int j = 0;
            if(i==0) {
                char[] res = {'0', '0', '0', '0'};
                return res;
            }
            while(true) {
                if(i==1) {
                    c[j] = '1';
                    while(j < 3) {
                        c[++j] = '0';
                    }
                    break;
                }
                char cc = (char)(i%2+'0');
                c[j] = cc;
                j++;
                i = i/2;
            }
            return c;
        } else {
            switch (s) {
                case 'A':
                    char[] a = {'0','1','0','1'};
                    return a;
                case 'B':
                    char[] b = {'1','1','0','1'};
                    return b;
                case 'C':
                    char[] c = {'0','0','1','1'};
                    return c;
                case 'D':
                    char[] d = {'1','0','1','1'};
                    return d;
                case 'E':
                    char[] e = {'0','1','1','1'};
                    return e;
                case 'F':
                    char[] f = {'1','1','1','1'};
                    return f;
            }
        }
        return null;
    }

    private void hex2Double(char[] bin) {
        // 0 1-11 12-63
        int jiema = 0;
        for(int i=1;i<=11;i++) {
            jiema = 2*jiema + (bin[i]-'0');
        }
        jiema = jiema-1023;
        int zhengshu = 1;
        for(int i=12;i<=12+jiema-1;i++) {
            zhengshu = 2*zhengshu + (bin[i]-'0');
        }
        double xiaoshu = 0.0d;
        double base = 0.5d;
        // 理论上应该算不了那么多，所以小数位置只取前10位2进制
        for(int i=12+jiema;i<=21+jiema;i++) {
            xiaoshu = base*(bin[i]-'0')+xiaoshu;
            base = base*0.5;
        }
        double sum = xiaoshu+zhengshu;
        System.out.print(sum);
    }
}
