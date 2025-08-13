import java.io.*;
import java.util.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if(N==1){
            System.out.println(1);
            return;
        }

        int count = 1;

        if(N == 2) {
            if(M > 2) {
                int n1 = M % 2;
                int n2 = M / 2;

                count += Math.min(n1 == 1 ? n2 : n2 -1, 3);
            }
        } else {
            if(M > 5) {
                count = M - 2;
            } else {
                count += Math.min(M - 1, 3);
            }
        }

        System.out.println(count);
    }
}
