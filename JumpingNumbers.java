/*
---------------Problem Statement---------------
Given A Positive Number X. Find The Largest Jumping Number Which Is Smaller Than Or Equal To X. 
A Number Is Called Jumping Number If All Adjacent Digits In It Differ By Only 1. 
All Single-Digit Numbers Are Considered As Jumping Numbers. For Example 7, 8987 And 4343456 Are Jumping Numbers But 796, 677 And 89098 Are Not.

Input : 50
Output: 45 
*/

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
class JumpingNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long num = input.nextLong();
        input.close();
        System.out.println(jumpingNum(num));
    }
    static long jumpingNum(long num) {
        if(num <= 10) return num;
        Queue<Long> queue = new LinkedList<Long>();
        long n = num;
        while(n > 10) n /= 10;
        long startingDigit = n;
        for(long i = 1; i <= startingDigit; i++) queue.offer(i);
        long max = Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            long temp = queue.poll();
            if(temp > num) continue;
            max = Math.max(temp, max);
            if(temp%10 == 1){
                if((temp*10+2) <=num) queue.offer(temp*10+2);
                if((temp*10) <= num) queue.offer(temp*10);
            }
            else if(temp%10 == 9){
                if((temp*10+8) <= num) queue.offer(temp*10+8);
            }
            else if(temp%10 == 0){
                if((temp*10+1) <= num) queue.offer(temp*10+1);
            }
            else{
                if((temp*10+(temp%10)+1) <= num) queue.offer(temp*10+(temp%10)+1);
                if((temp*10+(temp%10)-1) <= num) queue.offer(temp*10+(temp%10)-1);
            }
        }
        return max;
    }
}

/*
Time Complexity : O(K)
Space Complexity: O(K)
Where K = Number Of Jumping Numbers Less Than Or Equal To 'N', Where 'N' Is Input.
*/
