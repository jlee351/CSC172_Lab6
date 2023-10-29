/******************************************************************************
 *  Compilation:  javac Sorting.java
 *  Execution:    java Sorting input.txt AlgorithmUsed
 *  Dependencies: StdOut.java In.java Stopwatch.java
 *  Data files:   http://algs4.cs.princeton.edu/14analysis/1Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/2Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/4Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/8Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/16Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/32Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/1Mints.txt
 *
 *  A program to play with various sorting algorithms.
 *
 *
 *  Example run:
 *  % java Sorting 2Kints.txt  2
 *
 ******************************************************************************/
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.io.FileWriter;
import java.util.Arrays;
import java.io.IOException;
import java.util.Random;

public class Sorting {


 /**
     *
     * Sorts the numbers present in the file based on the algorithm provided.
     * 0 = Arrays.sort() (Java Default)
     * 1 = Bubble Sort
     * 2 = Selection Sort
     * 3 = Insertion Sort
     * 4 = Mergesort
     * 5 = Quicksort
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args){
        In in = new In(args[0]);

		  // Storing file input in an array
        int[] a = in.readAllInts();

        int[] b = new int[a.length];
        for(int i = 0; i < a.length; i++){
            b[i] = a[i];
        }
        Arrays.sort(b);

        int[] c = new int[b.length];
        int temp = b.length-1;
        for(int i=0;i<b.length;i++){
            c[i]=b[temp];
            temp--;
        }

        int[] d = new int[c.length];
        Random rand = new Random();
        int swap = (int)(0.1*c.length);
        int temp1 = rand.nextInt(c.length);
        int temp2 = rand.nextInt(c.length);
        while(temp2 == temp1) {
            temp2 = rand.nextInt(c.length);
        }
        int i=0;
        while(i<swap){
            int temp3 = c[temp1];
            c[temp1] = c[temp2];
            c[temp2] = temp3;
            i++;
        }
        for(int k=0;k<c.length;k++){
            d[k]=c[k];
        }
        int SortAlgo = Integer.parseInt(args[1]);


        // TODO: Generate 3 other arrays, b, c, d where
        // b contains sorted integers from a (You can use Java Arrays.sort() method)
        // c contains all integers stored in reverse order
        // (you can have your own O(n) solution to get c from b
        // d contains almost sorted array
        //(You can copy b to a and then perform (0.1 * d.length)  many swaps to acheive this.

        //TODO:
        // Read the second argument and based on input select the sorting algorithm
        //  * 0 = Arrays.sort() (Java Default)
        //  * 1 = Bubble Sort
        //  * 2 = Selection Sort
        //  * 3 = Insertion Sort
        //  * 4 = Mergesort
        //  * 5 = Quicksort
        //  Perform sorting on a,b,c,d. Pring runtime for each case along with timestamp and record those.
        // For runtime and priting, you can use the same code from Lab 4 as follows:

         // TODO: For each array, a, b, c, d:
        Stopwatch timer = new Stopwatch();

        // TODO: Perform Sorting and store the result in an  array
        double time = timer.elapsedTimeMillis();
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

        //TODO: Replace with your own netid
        String netID = "31830539";

        //TODO: Replace with the algorithm used
        String algorithmUsed = "";
        if(SortAlgo == 0){
            algorithmUsed = "Arrays.sort()";
        }
        else if(SortAlgo == 1){
            algorithmUsed = "Bubble Sort";
        }
        else if(SortAlgo == 2){
            algorithmUsed = "Selection Sort";
        }
        else if(SortAlgo == 3){
            algorithmUsed = "Insertion Sort";
        }
        else if(SortAlgo == 4){
            algorithmUsed = "Mergesort";
        }
        else if(SortAlgo == 5){
            algorithmUsed = "Quicksort";
        }

        //TODO: Replace with the  array used
        //String arrayUsed = "a";
        Stopwatch timera = new Stopwatch();
        Sort(SortAlgo,a,"a.txt");
        double timea = timera.elapsedTimeMillis();
        StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, "a", timea, timeStamp, netID, args[0]);

        Stopwatch timerb = new Stopwatch();
        Sort(SortAlgo,b,"b.txt");
        double timeb = timerb.elapsedTimeMillis();
        StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, "b", timeb, timeStamp, netID, args[0]);

        Stopwatch timerc = new Stopwatch();
        Sort(SortAlgo,c,"c.txt");
        double timec = timerc.elapsedTimeMillis();
        StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, "c", timec, timeStamp, netID, args[0]);

        Stopwatch timerd = new Stopwatch();
        Sort(SortAlgo,d,"d.txt");
        double timed = timerd.elapsedTimeMillis();
        StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, "d", timed, timeStamp, netID, args[0]);
        // Write the resultant array to a file (Each time you run a program 4 output files should be generated. (one for each a,b,c, and d)

  }

  public static int[] ArraySort(int[] list) {
      Arrays.sort(list);
      return list;
  }

  public static int[] BubbleSort(int[] list){
      int temp;
      for(int i=0; i < list.length; i++){
          for(int j=1; j < (list.length-i); j++){
              if(list[j-1] > list[j]){
                  temp = list[j-1];
                  list[j-1] = list[j];
                  list[j] = temp;
              }
          }
      }
      return list;
  }

  public static int[] SelectionSort(int[] list){
      int temp;
      for (int i = 0; i < list.length - 1; i++){
          int index = i;
          for (int j = i + 1; j < list.length; j++){
              if (list[j] < list[index]){
                  index = j;
               }
           }
           temp = list[index];
           list[index] = list[i];
           list[i] = temp;
       }
       return list;
  }

  public static int[] InsertionSort(int[] list){
      for (int i = 0; i < list.length - 1; i++){
          int index = i;
          for (int j = i + 1; j < list.length; j++){
              if (list[j] < list[index]){
                  index = j;
              }
          }
          int smallerNumber = list[index];
          list[index] = list[i];
          list[i] = smallerNumber;
      }
      return list;

    }

    public static void merge(int arr[], int l, int m, int r){
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int [n1];
        int R[] = new int [n2];
        for (int i=0; i<n1; ++i){
                L[i] = arr[l + i];

            for (int j=0; j<n2; ++j){
                R[j] = arr[m + 1+ j];
                i = 0;
                j = 0;
                int k = l;


                while (i < n1 && j < n2){
                    if (L[i] <= R[j]){
                        arr[k] = L[i];
                        i++;
                    }
                    else{
                        arr[k] = R[j];
                        j++;
                    }
                    k++;
                }
                while (i < n1){
                    arr[k] = L[i];
                    i++;
                    k++;
                }
                while (j < n2){
                    arr[k] = R[j];
                    j++;
                    k++;
                }
            }
        }
    }
    public static int[] MergeSort(int[] list, int left, int right){
        int temp;

        if(left < right){
            temp = (left + right)/2;
            MergeSort(list, left, temp);
            MergeSort(list, temp+1, right);
            merge(list, left, temp, right);
        }

        return list;
    }

    public static int partition(int[] list,int low,int high){
        int pivot = list[high];
        int i = low-1;
        for(int j = low; j < high; j++){
            if(list[j] <= pivot){
                i++;
                int temp = list[i];
                list[i] = list[j];
                list[j] = temp;
            }
        }
        int temp = list[i+1];
        list[i+1] = list[high];
        list[high] = temp;
        return i+1;
    }

public static int[] QuickSort(int[] list,int low,int high){
    if(low < high){
        int pos=partition(list, low, high);
        QuickSort(list, low, pos-1);
        QuickSort(list, pos+1, high);
    }
    return list;
}

    public static void WriteFile(int[] list, String fileName){
        try{
            FileWriter fWriter = new FileWriter(fileName);
            for(int i=0;i<list.length;i++){
                fWriter.write(list[i]+"\n");
            }
            fWriter.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void Sort(int SortAlgo,int[] list,String fileName){
        if(SortAlgo == 0){
            list = ArraySort(list);
        }
        else if(SortAlgo == 1) {
            list = BubbleSort(list);
        }
        else if(SortAlgo == 2) {
            list = SelectionSort(list);
        }
        else if(SortAlgo == 3) {
            list = InsertionSort(list);
        }
        else if(SortAlgo == 4) {
            list = MergeSort(list,0,list.length-1);
        }
        else if(SortAlgo == 5) {
            list = QuickSort(list,0,list.length-1);
        }
        WriteFile(list, fileName);
    }



}
