package random;
import java.util.Scanner;
import java.util.Arrays;

public class BinarySearch {

    static long[] a = new long[10];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < a.length; i++) {
            a[i] = input.nextLong();
        }
        Arrays.sort(a);
        for (long i : a) {
            System.out.print(i + " ");
        }
        System.out.print("\n"+binSearch(29));
        
    }

    static long binSearch(long x) {
        int lo = 0, hi = a.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (a[mid] == x) {
                return mid;
            } else if (a[mid] > x) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }
}
