//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);

            // Ensure input is read correctly
            inputLine = br.readLine().trim().split(" ");
            if (inputLine == null || inputLine.length == 0) {
                System.out.println("Invalid input");
                continue;
            }

            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().getMinDiff(arr, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
 class Solution {
    int getMinDiff(int[] arr, int k) {
        int n=arr.length;
        Arrays.sort(arr);
        int diff=arr[n-1]-arr[0];
        int smallest=arr[0]+k;
        int heighest=arr[n-1]-k;
        for(int i=0;i<n-1;i++){
            int min=Math.min(smallest,arr[i+1]-k);
            int max=Math.max(heighest,arr[i]+k);
            if(min<0)
            continue;
            diff=Math.min(diff,max-min);
        }
        return diff;
    }
}