package java;

/**
 * @Auther: cyc
 * @Date: 2021/9/23 - 09 - 23
 * @Description: Apractice
 * @version: 1.0
 */
public class RandomQuickSort {
    public  void proccess2(int[] arr,int L,int R){
        if (L>=R){
            return;
        }
        // 随机快排的精髓，将快排的时间复杂度从O(N*N)变成O(N*logN)
        // 原理是将取值随机化，让最差情况变成随机行为的长期期望
        swap(arr, L + (int) (Math.random() * (R - L + 1)), R);

        int[] mid = threeColorSort(arr, L, R);
        proccess2(arr,L,mid[0]-1);
        proccess2(arr,mid[1]+1,R);
    }

    public int[] threeColorSort(int[] arr,int L,int R){

        if (L > R) {
            return new int[] { -1, -1 };
        }
        if (L == R) {
            return new int[] { L, R };
        }

        int lessi=L-1;
        int more = R+1;
        int cur=L;
        while (cur<more){
            if (arr[cur]<arr[R]){
                swap(arr,cur++,++lessi);
            }else if(arr[cur]>arr[R]){
                swap(arr,cur,--more);
            }else{
                cur++;
            }
        }
//        swap(arr,more,R);
        return new int[]{lessi+1,more-1};
    }

    public void swap(int[] arr,int a,int b){
        int temp =arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
