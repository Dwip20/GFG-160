//Move All Zeroes to End
 class Solution {
    void pushZerosToEnd(int[] arr) {
        int i=0;
        int lh=arr.length;
        for(int j=0;j<lh;j++){
            if(arr[j]!=0){
                arr[i]=arr[j];
                i++;
            }
        }
        while(i<lh){
            arr[i]=0;
            i++;
        }
    }
} 