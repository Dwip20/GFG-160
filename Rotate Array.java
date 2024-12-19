class Solution {
    static void rotateArr(int arr[], int d) {
        int lh=arr.length;
        d=d%lh;
        
        reverse(arr,0,d-1);
        reverse(arr,d,lh-1);
        reverse(arr,0,lh-1);
    }
    static void reverse(int arr[],int st,int ed){
        int tem;
        while(st<ed){
            tem=arr[st];
            arr[st]=arr[ed];
            arr[ed]=tem;
            st++;
            ed--;
        }
    }
} 