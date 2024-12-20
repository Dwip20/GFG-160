class Solution {
    void nextPermutation(int[] arr) {
        int n=arr.length, idx=-1;
        for(int i=n-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                 idx=i;
                break;
            }
        }
        if(idx==-1){
            reverse(arr,0,n-1); return;
        }
        for(int i=n-1;i>idx;i--){
            if(arr[i]>arr[idx]){
                int temp=arr[idx];
                arr[idx]=arr[i];
                arr[i]=temp;
                break;
            }
        }
        reverse(arr,idx+1,n-1);
    }
    void reverse(int [] arr,int st,int ed){
        while(st<ed){
           int temp=arr[st];
            arr[st]=arr[ed];
            arr[ed]=temp;
            st++;ed--;
        }
    }
} 