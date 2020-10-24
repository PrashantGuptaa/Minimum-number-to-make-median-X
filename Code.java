import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            String[] line1 = br.readLine().split(" ");
            String[] line2 = br.readLine().split(" ");
            int size = Integer.parseInt(line1[0]);
            int target = Integer.parseInt(line1[1]);
            int[] a = new int[size + 1];
            int[] b;
            int ans2 = 0, ans;


            int lower = 0, higher = 0, equal = 0;
            for(int i = 1; i <= size ; i++) {
                a[i] = Integer.parseInt(line2[i - 1]);
                if(a[i] == target)
                    equal++;
                else if(a[i] < target)
                    lower++;
                else higher++;
            }
            if(equal >= 1 && equal <= Math.abs(lower - higher)) {
                ans = Math.abs(lower - higher) - equal + 1;
                System.out.println(ans);
            }
            else if(equal > Math.abs(lower - higher)){
                System.out.println(0);
            }
            // else if(higher == size || lower == size)
            //     System.out.println(size);
            else if(equal == 0){
                int ans1;

                ans1 = Math.abs(higher -lower) + 1;
                 // System.out.println("Cunt Highrr: "+ higher);
                  // System.out.println("Cunt lower: "+ lower);
                b = LowHighthantarget(a, size, target);
                int small = b[0];
                int big = b[1];
                int avg = (small + big)/2;
                if(avg == target){
                     //System.out.println("Equal loop Exec.");
                    int[] c;
                    c = countbiggerandsmaller(a, size, small, big);
                    int lowercount = c[0];
                    int highercount = c[1];
                    ans2 = Math.abs(lowercount - highercount);
                    ans = Math.min(ans1, ans2);
                    System.out.println(ans);
                }
                else if( avg < target){
                     // System.out.println("Lesser loop Exec.");
                    int[] c;
                    int add = (target*2) - big;
                    c = avglessthantarget(a, size, add, big);
                    int lowercount = c[0];
                    int highercount = c[1];
                    ans2 = Math.abs(lowercount - highercount) + 1;
                    ans = Math.min(ans1, ans2);
                    System.out.println(ans);
                }
                else if( avg > target){
               //     System.out.println("Higher loop Exec.");
                    int[] c;
                    int add = (target*2) - big;
                    c = avggreaterthantarget(a, size, small, add);
                    int lowercount = c[0];
                    int highercount = c[1];
                    ans2 = Math.abs(lowercount - highercount) + 1;
                    ans = Math.min(ans1, ans2);
                    //    System.out.println(ans1+" "+lowercount+" "+highercount);
                    //   System.out.println(ans2);

                    System.out.println(ans);
                }
            }

        }
    }
    static int[] LowHighthantarget(int[] a, int size, int target){
        int[] b = new int[2];
        int flag = 0;
        int low = 0 , high = 0;
        for(int i = 1 ; i <= size ; i++){
            if(a[i] > low && a[i] < target)
                low = a[i];
            if( high < target) {
                high = Math.max(high, a[i]);
            }
            if(a[i] < high && a[i] > target)
                high = a[i];
        }
        b[0] = low;
        b[1] = high;
        //    System.out.println("Lower: "+low);
        //    System.out.println("Higher: "+high);
        return b;
    }
    static int[] countbiggerandsmaller(int[] a, int size, int small , int big){
        int[] c = new int[2];
        int low = 0 , high = 0;
        for(int i = 1 ; i <= size ; i++){
            if(a[i] <= small)
                low++;
            else if(a[i] >= big)
                high++;
        }
        c[0] = low;
        c[1] = high;
        return c;
    }
    static int[] avglessthantarget(int[] a, int size, int add , int big){
        int[] c = new int[2];
        int low = 0 , high = 0;
        for(int i = 1 ; i <= size ; i++){
            if(a[i] <= add)
                low++;
            else if(a[i] >= big)
                high++;
        }
        c[0] = low ;
        c[1] = high - 1;
        return c;
    }
    static int[] avggreaterthantarget(int[] a, int size, int small , int add){
        int[] c = new int[2];
        int low = 0 , high = 0;
        for(int i = 1 ; i <= size ; i++){
            if(a[i] <= small)
                low++;
            else if(a[i] >= add)
                high++;
        }
        if(low == 0) {
        }
        else
        c[0] = low - 1;
        c[1] = high;
        return c;
    }
}
