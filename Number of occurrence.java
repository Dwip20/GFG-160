//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.countFreq(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    int countFreq(int[] arr, int target) {
        int first = findfirstoccurrence(arr,target);
        if (first= - 1){
            return 0;
        }
        int last = findlastoccurrence(arr,target);
        return last - first + 1;
    }
        
    private int findfirstoccurrence(arr,target){
        int low = 0 , high = arr.length - 1 ,first = - 1;
        while(low<=high){
            int mid =  low +(high - low)/ 2;
            if (arr[mid]==target){
                first=mid;
                high = mid - 1; 
            }
            else if(arr[mid]<target){
                low = mid + 1; 
            }
            else{
                high = mid - 1;
            }
        }
        return first;
    }
    
     private int findlastoccurrence(arr,target){
        int low = 0 , high = arr.length - 1 ,first = - 1;
        while(low<=high){
            int mid =  low +(high - low)/ 2;
            if (arr[mid]==target){
                last=mid;
                low = mid + 1; 
            }
            else if(arr[mid]<target){
                low = mid+ 1; 
            }
            else{
                high = mid - 1;
            }
        }
        return last;
    }
}
    
