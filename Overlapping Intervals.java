//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                String temp[] = br.readLine().trim().split(" ");
                arr[i][0] = Integer.parseInt(temp[0]);
                String x = temp[1];
                arr[i][1] = Integer.parseInt(x);
            }
            Solution obj = new Solution();
            // The mergeOverlap function now returns a List<int[]>
            List<int[]> ans = obj.mergeOverlap(arr);

            // Printing the merged arr
            for (int[] interval : ans) {
                System.out.print(interval[0] + " " + interval[1] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public List<int[]> mergeOverlap(int[][] arr) {
        // Edge case: if the input is empty, return an empty list
        if (arr.length == 0) {
            return new ArrayList<>();
        }
        
        // Step 1: Sort intervals based on the start of each interval
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        
        // List to hold the merged intervals
        List<int[]> result = new ArrayList<>();
        
        // Step 2: Initialize the first interval
        int[] currentInterval = arr[0];
        
        // Step 3: Iterate over the intervals
        for (int i = 1; i < arr.length; i++) {
            // If the current interval overlaps with the next interval
            if (arr[i][0] <= currentInterval[1]) {
                // Merge them by extending the end time of the current interval
                currentInterval[1] = Math.max(currentInterval[1], arr[i][1]);
            } else {
                // No overlap, so add the current interval to the result list
                result.add(currentInterval);
                // Move to the next interval
                currentInterval = arr[i];
            }
        }
        
        // Add the last merged interval to the result
        result.add(currentInterval);
        
        return result;
    }
}