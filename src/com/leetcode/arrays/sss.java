package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

 */
public class sss {
    public static void main(String[] args) {
        sss solution = new sss();
        int[] arr1={6,6};
        int[] arr2={1};

        System.out.println(solution.minOperations(arr1,arr2));
    }
    public int minOperations(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int sum1= Arrays.stream(nums1).sum();
        int sum2= Arrays.stream(nums2).sum();
        int diff=sum1-sum2;
        int count=0;
        if(diff==0){
            return 0;
        }

        if(nums1.length> nums2.length){
            if(diff>0){
                for (int n:nums1){
                    count++;
                    diff=diff+1-n;
                    if(diff==0 || diff<0 && diff>-n){
                        return count;
                    }
                }
            }else{
                for (int n:nums2){
                    count++;
                    diff=diff+1-n;
                    if(diff==0 || diff<0 && diff>-n){
                        return count;
                    }
                }
            }
        }
        if(diff>0){
            for (int n:nums2){
                count++;
                diff=diff-6+n;
                if(diff==0 || diff<0 && diff<-n){
                    return count;
                }
            }
         }else{
            for (int n:nums1){
                count++;
                diff=diff-6+n;
                if(diff==0 || diff<0 && diff>-n){
                    return count;
                }
            }
        }

        return -1;
    }

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {


    return  -1;
    }



    class Item{
        String type;
        String color;
        String name;
        Item(String type,String color,String name){
            this.type=type;
            this.color=color;
            this.name=name;
        }
    }

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        List<Item> res=new ArrayList<>();
        for (List<String> item:items) {
            res.add(new Item(item.get(0),item.get(1),item.get(2)));
        }
            int count=0;
            for(Item item:res){
                if(ruleKey.equals("type")&&item.type.equals(ruleValue)){
                    count++;
                }else if(ruleKey.equals("color")&&item.color.equals(ruleValue)){
                    count++;
                }else if(ruleKey.equals("name")&&item.name.equals( ruleValue)){
                    count++;
                }
            }

        return  count;
    }
}