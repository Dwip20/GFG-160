//{ Driver Code Starts
// Initial template for JAVA

import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String str = sc.nextLine();

            Solution obj = new Solution();
            int num = obj.myAtoi(str);
            System.out.println(num);
            System.out.println("~");
            t--;
        }
    }
}
// } Driver Code Ends


class Solution {
    public int myAtoi(String s) {
        // Constants for 32-bit signed integer range
        int INT_MAX = Integer.MAX_VALUE; // 2^31 - 1
        int INT_MIN = Integer.MIN_VALUE; // -2^31
        
        // Step 1: Handle empty string
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        // Step 2: Skip leading whitespaces
        int i = 0;
        int n = s.length();
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        
        // If we have reached the end of the string
        if (i == n) {
            return 0;
        }
        
        // Step 3: Check for sign
        int sign = 1;
        if (s.charAt(i) == '+') {
            i++;
        } else if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        
        // Step 4: Convert digits to integer
        int num = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0'; // Convert char to digit
            
            // Step 5: Handle overflow
            if (num > (INT_MAX - digit) / 10) {
                return (sign == 1) ? INT_MAX : INT_MIN;
            }
            
            num = num * 10 + digit;
            i++;
        }
        
        // Step 6: Return the result with the sign
        return num * sign;
    }
}