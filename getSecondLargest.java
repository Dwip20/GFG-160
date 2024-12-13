class Solution {
    public int getSecondLargest(int[] arr) {
        
        int maxarr=-1 ,maxarr2=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>maxarr){
                maxarr2=maxarr;
                maxarr=arr[i];
            }
            else if (arr[i]>maxarr2 && arr[i]!=maxarr){
                maxarr2=arr[i];
            }
        }
        return maxarr2;
    }
    public static void main(String args[]){
        Solution Solution =new Solution();
        int[] arr={12,35,1,10,34,1};
        System.out.println("Secend Largest Number :"+Solution.getSecondLargest(arr));
    }
}