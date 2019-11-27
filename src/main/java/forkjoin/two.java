package forkjoin;

public class two {
    static int[] ints =new int[10];
    private static void init(){
        for (int i=0;i<ints.length;i++){
            ints[i]=i;
        }
    }
    private static int find(int i){



        return find1(0,ints.length-1,i);
    }

    private static int find1(int i, int length, int i1) {
        if (ints[i]>i1||ints[length]<i1){
            return -1;
        }
        int num=(i+length)/2;
        if (ints[num]==i1){
            return num;
        }else if (ints[num]<i1){
            return find1(num+1,length,i1);
        }else{
             return find1(0,num-1,i1);
        }
    }

    public static void main(String[] args) {

         two.init();
         System.out.println(find(11));


    }
}
