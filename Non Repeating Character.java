//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String st = sc.next();

            char ans = new Solution().nonRepeatingChar(st);

            if (ans != '$')
                System.out.println(ans);
            else
                System.out.println(-1);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find the first non-repeating character in a string.
    static char nonRepeatingChar(String s) {
        // Step 1: Create an array to store character frequencies
        int[] freq = new int[26]; // For lowercase Latin letters
        
        // Step 2: Count the frequency of each character
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Step 3: Find the first non-repeating character
        for (char c : s.toCharArray()) {
            if (freq[c - 'a'] == 1) {
                return c; // Return the first non-repeating character
            }
        }

        // Step 4: If no non-repeating character, return '$'
        return '$';
    }
    
    // Test the function
    public static void main(String[] args) {
        System.out.println(nonRepeatingChar("geeksforgeeks")); // Output: 'f'
        System.out.println(nonRepeatingChar("racecar"));       // Output: 'e'
        System.out.println(nonRepeatingChar("aabbccc"));       // Output: '$'
    }
}
