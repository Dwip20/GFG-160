class Solution {
    public void reverseArray(int arr[]) {
        int lh=arr.length;
        int [] arr1=new int[lh];
        for(int i=0;i<lh;i++){
            arr1[i]=arr[lh-i-1];
        }
        for(int i=0;i<lh;i++){
            arr[i]=arr1[i];
        }
    }
}