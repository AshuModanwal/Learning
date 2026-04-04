package dsa.sde_sheet;

public class NumberOfLaserBeamInABank {
    private static int countOne(char [] arr){
        int n = arr.length;
        int cnt = 0;
        for(int i=0; i<n; i++){
            if(arr[i] == '1')
                cnt++;
        }

        return cnt;
    }

    private int  numberOfBean(String []bank){
        int numberOfBeans = 0;
        int n = bank.length;
        int prev = 0;
        for(int i=0; i<n-1; i++){
            int curr = countOne(bank[i].toCharArray());
            if(curr == 0)
                continue;

            numberOfBeans += curr * prev;
            prev = curr;

        }

        return numberOfBeans;
    }

    public static void main(String []args){

        String [] bank = {"011001","000000","010100","001000"};

        NumberOfLaserBeamInABank ob = new NumberOfLaserBeamInABank();
        System.out.println("number of bean in the bank:  "+ob.numberOfBean(bank));
    }
}
