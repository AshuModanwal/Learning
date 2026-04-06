package dsa.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NextPermutation {

    private static List<List<Integer>> fun( List<List<Integer>> ans,int []nums, List<Integer> curr, List<Boolean>used){
        if(curr.size() ==nums.length){
            ans.add(new ArrayList<>(curr));
            return ans;
        }

        for(int i=0; i<nums.length; i++){
            if(used.get(i)==true)
                continue;
            used.set(i,true);
            curr.add(nums[i]);
            fun(ans, nums, curr, used);
            used.set(i, false);
            curr.remove(curr.size()-1);
        }
        return ans;
    }
    private static boolean isSame(List<Integer> num1,int[] nums){
        for(int i=0; i<num1.size(); i++)
        {
            if(!num1.get(i).equals(nums[i]))
                return false;
        }
        return true;
    }
    public static void nextPermutation(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        List<Boolean> used = new ArrayList<>();
        int []t = nums.clone();
        Arrays.sort(t);
        for(int i=0; i<nums.length; i++)
            used.add(false);
        permutations = fun(permutations,t ,new ArrayList<>(), used );


        List<Integer> next = new ArrayList<>();
        for(int i=0; i<permutations.size(); i++){

            if (isSame(permutations.get(i), nums)) {



                if (i + 1 < permutations.size())
                    next = permutations.get(i + 1);
                else
                    next = permutations.get(0);



            }
        }
        if (next != null) {
            for (int j = 0; j < nums.length; j++)
                nums[j] = next.get(j);
        }

        return;
    }

    static void main() {

        int []nums = {1,2,3};
        nextPermutation(nums);

        System.out.print("nextPermutation: { ");
        for(int i: nums){
            System.out.print(i+" ");
        }
        System.out.print("}");

    }

}
