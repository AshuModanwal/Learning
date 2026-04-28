package dsa.sde_sheet.array;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDupFromSortArray {

    static void brute(int []arr){
        Set<Integer> set = new LinkedHashSet<>();

        for(int i: arr){
            set.add(i);
        }

        int i=0;
        for(Integer t: set){
            arr[i++]=t;
        }

        while(i<arr.length)
            arr[i++]=0;
    }

    static void twoPointer1(int []arr){
        int n = arr.length;
        for(int i=0; i<n; i++){
            int j=i+1;
            while(j<n && arr[i]==arr[j])
                arr[j++]=0;
            i=j-1;
        }
        int ind=0;
        for(int i=1; i<n; i++){
            if(arr[i]==0)
                continue;
            arr[++ind] = arr[i];
        }
        ind++;
        while(ind<n)
            arr[ind++]=0;
    }

    static void twoPointer2(int []arr){
        int n = arr.length;
        int i=0;
        for(int j=i+1; j<n; j++){
            if(arr[i]!=arr[j])
                arr[++i]=arr[j];
        }
        i++;
        while(i<n)
            arr[i++]=0;

    }

    static void main() {
        int []arr = {1,1,2,2,2,3,4,4,4,4,5,6,7,7,8,9,9,9};
//        brute(arr);

//        twoPointer1(arr);
        twoPointer2(arr);
        for(int i:arr)
            System.out.print(i+" ");

    }
}
