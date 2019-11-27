package forkjoin;

public class QuickSort {

   protected static void quicksort(int left,int right,int[] arr){
       if (left>=right)
           return;
       int key=arr[left];
       int i=left;
       int j=right;
       while (i<j){
           while (arr[j]>=key&&i<j){
           j--;
       }

           while(arr[i]<=key&&i<j){
               i++;
           }

           if (i<j){
               arr[i]=arr[i]^arr[j];
               arr[j]=arr[i]^arr[j];
               arr[i]=arr[i]^arr[j];
           }

       }
       arr[left]=arr[i];
       arr[i]=key;
       quicksort(left,i-1,arr);
       quicksort(i+1,right,arr);

   }

    public static void main(String[] args) {
        int[] arr={2,4,65,7,1,3,57,86,35,68,156,45};
        quicksort(0,arr.length-1,arr);
        for (int num:arr){
            System.out.print(num+" ");
        }
    }
}
