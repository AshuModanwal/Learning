package dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation {


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
        return ans  ;
    }
    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Boolean> used = new ArrayList<>();
        for(int i=0; i<nums.length; i++)
            used.add(false);
        ans = fun(ans, nums,new ArrayList<>(), used );

        for(int i=0; i<ans.size(); i++){
            System.out.println("permutations.get("+i+"): "+ans.get(i));
        }

        return ans;

    }

    public static void main(String[] args){
        int [] nums = {1,2,3};
        System.out.println("Permutation for: "+nums);
        permute(nums);
    }

}
