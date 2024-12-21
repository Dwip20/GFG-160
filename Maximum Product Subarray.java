//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int n = inputLine.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxProduct(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    int maxProduct(int[] arr) {
      int prefix=1,suffix=1,n=arr.length,ans=Integer.MIN_VALUE;
      for(int i=0;i<n;i++){
          if(prefix==0) prefix=1;
          if(suffix==0) suffix=1;
          prefix=prefix*arr[i];
          suffix=suffix*arr[n-1-i];
          ans=Math.max(ans,Math.max(prefix,suffix));
      }
          return ans;
    }
}  