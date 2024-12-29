//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s, patt;
            s = sc.next();
            patt = sc.next();

            Solution ob = new Solution();

            ArrayList<Integer> res = ob.search(patt, s);
            if (res.size() == 0)
                System.out.print("[]");
            else {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> result = new ArrayList<>();
        int m = pat.length(); // Length of the pattern
        int n = txt.length(); // Length of the text
        int base = 256; // Number of characters in the input alphabet
        int mod = 101; // A prime number to avoid overflow in hash computation

        if (m > n) return result; // If pattern length is greater than text length

        // Compute the hash value of the pattern and the first window of text
        int patHash = 0, txtHash = 0, h = 1;

        // The value of h would be "pow(base, m-1) % mod"
        for (int i = 0; i < m - 1; i++) {
            h = (h * base) % mod;
        }

        // Calculate initial hash values for pattern and first window of text
        for (int i = 0; i < m; i++) {
            patHash = (base * patHash + pat.charAt(i)) % mod;
            txtHash = (base * txtHash + txt.charAt(i)) % mod;
        }

        // Slide the pattern over the text
        for (int i = 0; i <= n - m; i++) {
            // Check if the hash values match
            if (patHash == txtHash) {
                // Verify the actual strings to avoid false positives due to hash collision
                if (txt.substring(i, i + m).equals(pat)) {
                    result.add(i); // Add 0-based index
                }
            }

            // Compute the hash value for the next window of text
            if (i < n - m) {
                txtHash = (base * (txtHash - txt.charAt(i) * h) + txt.charAt(i + m)) % mod;

                // If we get a negative hash, convert it to positive
                if (txtHash < 0) {
                    txtHash += mod;
                }
            }
        }

        return result;
    }

    // Test the function
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.search("geek", "geeksforgeeks")); // Output: [0, 8]
        System.out.println(sol.search("aaa", "aaaaaa"));         // Output: [0, 1, 2, 3]
        System.out.println(sol.search("xyz", "abcdef"));         // Output: []
    }
}
