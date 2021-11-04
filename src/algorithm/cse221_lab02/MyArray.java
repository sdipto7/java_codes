package algorithm.cse221_lab02;

public class MyArray {
    //A is an array of integers

    int a[];
    //Constructor

    public MyArray(int temp[]) {
        a = new int[temp.length];
        //Copying the values 
        for (int i = 0; i < temp.length; i++) {
            a[i] = temp[i];
        }
    }

    public void insertionSort() {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && key < a[j]) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }

    }

    public int[] mergeSort(int[] a) {
        int n = a.length;
        if (n == 1) {
            return a;
        }
        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];
        for (int i = 0; i < mid; i++) {
            left[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            right[i - mid] = a[i];
        }
        mergeSort(left);
        mergeSort(right);
        merge(left, right, a);
        return a;
    }

    public int[] merge(int[] left, int[] right, int[] a) {
        int nL = left.length;
        int nR = right.length;
        int i = 0, j = 0, k = 0;
        while (i < nL && j < nR) {
            if (left[i] <= right[j]) {
                a[k] = left[i];
                i++;
            } else {
                a[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < nL) {
            a[k++] = left[i++];
        }
        while (j < nR) {
            a[k++] = right[j++];
        }
        return a;
    }

    public void quickSort(int low, int high) {
        if(low<high){
            int p=partition(low,high);
            quickSort(low,p-1);
            quickSort(p+1,high);
        }
    }

    public int partition(int low, int high) {
        int pivot = a[low];
        int i=low;
        for(int j=low+1;j<=high;j++){
            if(a[j]<=pivot){
                i++;
                swap(i,j);
            }
        }
        swap(low,i);
        return i;
    }

    public void swap(int i, int j) {
        int icu = a[i];
        a[i] = a[j];
        a[j] = icu;
    }

    public String toString() {
        String s = "[ ";
        for (int i : a) {
            s += i + " ";
        }
        s += "]";
        return s;
    }

}
