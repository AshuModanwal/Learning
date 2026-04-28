package dsa.sde_sheet.array;

public class SecondLargest {

    static int secondLargest(int [] arr){
        int lar = arr[0];
        int sec = Integer.MIN_VALUE;

        for(int i: arr){
            if(i > lar){
                sec = lar;
                lar = i;
            }

            if(i > sec && i != lar){
                sec = i;
            }
        }
        return  sec;
    }

    static void main() {
        int [] arr = {3,2,1,5,4,6};

        int sec = secondLargest(arr);
        System.out.println("Second Largest: "+ sec);
    }
}
