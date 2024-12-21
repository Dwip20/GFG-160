//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().circularSubarraySum(arr));
            // System.out.println("~");
        }
    }
}
// } Driver Code Ends


 class Solution {
    public int circularSubarraySum(int arr[]) {
     int n=arr.length;
     int max=0 ,min=0;
     int max1=Integer.MIN_VALUE,min1=Integer.MAX_VALUE;
     int sum=0;
     for(int num:arr){
         max=Math.max(num,max+num);
         max1=Math.max(max1,max);
         min=Math.min(num,min+num);
         min1=Math.min(min1,min);
         sum+=num;
     }
     if(max1<0){
         return max1;
     }
     int maxcircular=sum-min1;
     return Math.max(max1,maxcircular);
    }
}  