package LeetCode;

import java.util.ArrayList;
import java.util.List;

//Input:[4,3,2,7,8,2,3,1]
//Output:[5,6]

public class FindDisappearedNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        int len = nums.length;
        int arr[] = new int [len];
        for(int i=0; i<len; i++){
            if(arr[nums[i]-1]!=1) {
                arr[nums[i]-1] = 1;
            }
        }
        for(int i=0; i<len; i++){
            if(arr[i]!=1) res.add(i+1);
        }
        return res;
    }

    public static void main(String[] args) {
        int nums[]={4,3,2,7,8,2,3,1};
        FindDisappearedNumbers obj = new FindDisappearedNumbers();
        List<Integer> res = obj.findDisappearedNumbers(nums);
        System.out.println(res.toString());
    }
}
