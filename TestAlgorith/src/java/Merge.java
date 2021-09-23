package java;

/**
 * @Auther: cyc
 * @Date: 2021/9/23 - 09 - 23
 * @Description: Apractice
 * @version: 1.0
 */
public class Merge {
    public void sort(int[] arr){
        if(arr.length == 0 || arr.length == 1){
            return ;
        }
        proccess(arr,0,arr.length-1);
    }

    public static void proccess(int[] arr,int L,int R){
        if(L == R){
            return  ;
        }
        int mid = L+((R-L)>>1);
        proccess(arr, L, mid);
        proccess(arr, mid + 1, R);

        meger(arr, L,mid,R);

    }

    public static void meger(int[] arr,int L,int mid,int R){
        int one=L; //第一个数组下标
        int another=mid+1; //第二个数组下标
        int cur = 0; //复制数组下标
        int[] arr1 = new int[R-L+1];
        //都不越界
        while(one<=mid && another<=R){
            arr1[cur++]=(arr[one]>arr[another]?arr[another++]:arr[one++]);
        }
        while(another<=R){
            arr1[cur++] = arr[another++];
        }
        while (one<=mid){
            arr1[cur++] = arr[one++];
        }
        //把中间数组复制回原数组
        cur = 0;
        for(int i=L;i<=R;i++){
            arr[i]=arr1[cur++];
        }

    }
}
