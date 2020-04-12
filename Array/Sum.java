package LeetCode.Array;

/**
 * Created by ChenJinghan
 * 2020/4/11 23:27
 */

import java.util.*;

import static java.lang.Math.abs;

public class Sum {
    /**
     * 题目限定了只有一种结果
     * 一种很蠢的做法
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int res[] = new int [2];
        ArrayList lst = new ArrayList<>();
        for(int i=0; i<nums.length;i++){
            lst.add(nums[i]);
        }
        Collections.sort(lst);

        for(int i=0; i<lst.size();i++){
            for(int j=lst.size()-1;j>i;j--){
                int tmp = Integer.parseInt(lst.get(i).toString())+Integer.parseInt(lst.get(j).toString());
                if(tmp<target) break;
                else if(tmp == target) {
                    int h = 0;
                    for(int k=0;k<nums.length;k++){
                        if(nums[k] == Integer.parseInt(lst.get(i).toString()) || nums[k] == Integer.parseInt(lst.get(j).toString()) ){ res[h] = k;h+=1;}
                    }
                    return res;
                }
            }
        }
        return res;
    }

    /**
     * 更优的方法：HashMap
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target){
        int res[] = new int[2];
        HashMap<Integer,Integer> m = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            m.put(nums[i],i);
        }
        for(int i=0; i<nums.length;i++){
            if(m.containsKey(target-nums[i]) && m.get(target-nums[i])!=i){
                res[0] = i;
                res[1] = m.get(target-nums[i]);
            }
        }
        return res;
    }

    /**
     * 更简单一点
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum3(int[] nums, int target){
        int res[] = new int[2];
        HashMap<Integer,Integer> m = new HashMap<>();
        for(int i=0; i<nums.length;i++){
            if(m.containsKey(target-nums[i]) && m.get(target-nums[i])!=i){
                res[0] = i;
                res[1] = m.get(target-nums[i]);
            }
            m.put(nums[i],i);
        }
        return res;
    }

    /**
     * 找和为0的三数之和,不能有重复项
     * 超时版
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList lst = new ArrayList();
        HashSet res = new HashSet();
        if(nums.length < 3) return new ArrayList<>(res);
        for(int i=0;i<nums.length;i++){
            lst.add(nums[i]);
        }
        Collections.sort(lst);
        for(int i=0;Integer.parseInt(lst.get(i).toString())<=0 && i<=lst.size()-2;i++){
            int target = 0 - Integer.parseInt(lst.get(i).toString());
            for(int a=i+1;a<lst.size();a++) {
                for (int b = lst.size() - 1; b > a; b--) {
                    if (Integer.parseInt(lst.get(a).toString()) + Integer.parseInt(lst.get(b).toString()) < target)
                        break;
                    if (Integer.parseInt(lst.get(a).toString()) + Integer.parseInt(lst.get(b).toString()) == target) {
                        ArrayList tmp = new ArrayList();
                        tmp.add(Integer.parseInt(lst.get(i).toString()));
                        tmp.add(Integer.parseInt(lst.get(a).toString()));
                        tmp.add(Integer.parseInt(lst.get(b).toString()));

                            res.add(tmp);
                            break;

                    }
                }
            }
        }
        return new ArrayList(res);
    }

    /**
     * 缩短运行时间
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        ArrayList lst = new ArrayList();
        HashSet res = new HashSet();
        if(nums.length < 3) return new ArrayList<>(res);
        for(int i=0;i<nums.length;i++){
            lst.add(nums[i]);
        }
        Collections.sort(lst);
        int flag = 0;
        for(int i=0;Integer.parseInt(lst.get(i).toString())<=0 && i<=lst.size()-2;i++){
            int target = 0 - Integer.parseInt(lst.get(i).toString());
            int a = i+1;
            int b = lst.size()-1;
            while (a<b){
                if(Integer.parseInt(lst.get(a).toString()) + Integer.parseInt(lst.get(b).toString()) == target){
                    ArrayList tmp = new ArrayList();
                    tmp.add(Integer.parseInt(lst.get(i).toString()));
                    tmp.add(Integer.parseInt(lst.get(a).toString()));
                    tmp.add(Integer.parseInt(lst.get(b).toString()));
                    res.add(tmp);
                    a++;b--;
                }
                else if(Integer.parseInt(lst.get(a).toString()) + Integer.parseInt(lst.get(b).toString())<target)a++;
                else b--;
            }
        }
        return new ArrayList(res);
    }

    /**
     * 找3个数之和离目标最近的那个
     * 草稿版
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        ArrayList lst = new ArrayList();
        int res = nums[0]+nums[1]+nums[2] ;
        for(int i=0;i<nums.length;i++){
            lst.add(nums[i]);
        }
        Collections.sort(lst);
        for(int i=0;i<=lst.size()-2;i++){
            int find = target - Integer.parseInt(lst.get(i).toString());
            int a = i+1;
            int b = lst.size()-1;
            while (a<b){
                if(Integer.parseInt(lst.get(a).toString()) + Integer.parseInt(lst.get(b).toString()) == find){
                    return target;
                }
                else if(Integer.parseInt(lst.get(a).toString()) + Integer.parseInt(lst.get(b).toString())<find){
                    if(abs(Integer.parseInt(lst.get(a).toString())+Integer.parseInt(lst.get(b).toString())+Integer.parseInt(lst.get(i).toString())-target) < abs(res-target))
                        res = Integer.parseInt(lst.get(a).toString())+Integer.parseInt(lst.get(b).toString())+Integer.parseInt(lst.get(i).toString());
                    a++;
                }
                else {
                    if(abs(Integer.parseInt(lst.get(a).toString())+Integer.parseInt(lst.get(b).toString())+Integer.parseInt(lst.get(i).toString())-target) < abs(res-target))
                        res = Integer.parseInt(lst.get(a).toString())+Integer.parseInt(lst.get(b).toString())+Integer.parseInt(lst.get(i).toString());
                    b--;
                }
            }
        }
        return res;
    }

    /**
     * 优化版
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest2(int[] nums, int target){
        ArrayList lst = new ArrayList();
        int res = nums[0]+nums[1]+nums[2] ;
        int diff = abs(res - target);

        for(int i=0;i<nums.length;i++){
            lst.add(nums[i]);
        }
        Collections.sort(lst);

        for(int i=0;i<=lst.size()-2;i++){
            int a = i+1;
            int b = lst.size()-1;
            while (a<b){
                int sum =((int)lst.get(i))+((int)lst.get(a)) + ((int)lst.get(b));
                int diff_tmp = abs(target - sum);
                if(diff_tmp < diff){
                    diff = diff_tmp;
                    res = sum;
                }
                if(sum < target) a+=1;
                else b -=1;

            }
        }
        return res;
    }

    /**
     * 循环的部分可以更早结束
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest3(int[] nums, int target){
        ArrayList lst = new ArrayList();
        int res = nums[0]+nums[1]+nums[2] ;
        int diff = abs(res - target);

        for(int i=0;i<nums.length;i++){
            lst.add(nums[i]);
        }
        Collections.sort(lst);

        for(int i=0;i<lst.size()-2;i++){
            if(((int)lst.get(i)) * 3 > target)
                return Math.min(res,((int)lst.get(i))+((int)lst.get(i+1)) + ((int)lst.get(i+2)));
            int a = i+1;
            int b = lst.size()-1;
            while (a<b){
                int sum =((int)lst.get(i))+((int)lst.get(a)) + ((int)lst.get(b));
                int diff_tmp = abs(target - sum);
                if(diff_tmp < diff){
                    diff = diff_tmp;
                    res = sum;
                }
                if(sum < target) a+=1;
                else b -=1;

            }
        }
        return res;
    }

    /**
     * 4个数之和为target  且结果不重复
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashSet res = new HashSet();
        if(nums.length<4) return new ArrayList<>(res);
        ArrayList lst = new ArrayList();
        for(int i=0; i<nums.length; i++){
            lst.add(nums[i]);
        }
        Collections.sort(lst);

        for(int i=0;i<lst.size()-3;i++){
            for(int j=i+1;j<lst.size()-2;j++){
                int a = j + 1;
                int b = lst.size()-1;
                while (a<b){
                    if((int)lst.get(i) +(int)lst.get(j) +(int)lst.get(a) +(int)lst.get(b) == target){
                        ArrayList tmp = new ArrayList();
                        tmp.add(lst.get(i));tmp.add(lst.get(j));tmp.add(lst.get(a));tmp.add(lst.get(b));
                        res.add(tmp);
                        a+=1;
                        b-=1;
                    }
                    else if((int)lst.get(i) +(int)lst.get(j) +(int)lst.get(a) +(int)lst.get(b)<target) a+=1;
                    else b-=1;
                }
            }
        }
        return new ArrayList<>(res);
    }





    public static void main(String[] args) {
        int nums[]={3,3};
        int target = 6;
        Sum obj = new Sum();
//        System.out.println(Arrays.toString(obj.twoSum3(nums, target)));

//        int nums1[] = {-10,5,-11,-15,7,-7,-10,-8,-3,13,9,-14,4,3,5,-7,13,1,-4,-11,5,9,-11,-4,14,0,3,-10,-3,-7,10,-5,13,14,-5,6,14,0,5,-12,-10,-1,-11,9,9,1,-13,0,-13,-1,4,0,-7,8,3,14,-15,-9,-10,-3,0,-15,-1,-2,6,9,11,6,-14,1,1,-9,-14,6,7,10,14,2,-13,-13,8,6,-6,8,-9,12,7,-9,-11,4,-4,-4,4,10,1,-12,-3,-2,1,-10,6,-13,-3,-1,0,11,-5,0,-2,-11,-6,-9,11,3,14,-13,0,7,-14,-4,-4,-11,-1,8,6,8,3};
//
//        long startTime = System.currentTimeMillis();
//        System.out.println(obj.threeSum(nums1));
//        long endTime = System.currentTimeMillis();
//        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
//
//        long startTime1 = System.currentTimeMillis();
//        System.out.println(obj.threeSum1(nums1));
//        long endTime1 = System.currentTimeMillis();
//        System.out.println("程序运行时间：" + (endTime1 - startTime1) + "ms");

        int nums2 []  = {1,0,-1,0,-2,2};
        int target2 = 0;
        System.out.println( obj.fourSum(nums2,target2));
    }

}

