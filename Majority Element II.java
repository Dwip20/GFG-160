class Solution {
    public List<Integer> findMajority(int[] nums) {
        int count1=0,count2=0,el1=Integer.MIN_VALUE,el2=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(count1==0 && el2!=nums[i]){
            count1=1;el1=nums[i];
            }
            else if(count2==0 && el1!=nums[i]){
                count2=1;el2=nums[i];
            }
            else if(el1==nums[i]) count1++;
            else if(el2==nums[i]) count2++;
            else{
                count1--;count2--;
            }
        }
        int ct=0,ct1=0;
        for(int i=0;i<nums.length;i++){
            if(el1==nums[i]) ct++;
            else if(el2==nums[i]) ct1++;
        }
        ArrayList<Integer> result=new ArrayList<>();
        if(ct>(nums.length/3)) result.add(el1);
        if(ct1>(nums.length/3)) result.add(el2);
        Collections.sort(result);
        return result;
    }
}
