/****************************************************************************************
 * Dynamic Sliding Window
 * 
 * This class solves the problem:
 * "Find the shortest subarray with a sum greater than x"
 * Where the inputs are an array of integers and x is an integer.
 * 
 * Because the subarray can be any length, the sliding window pattern must
 * be modified to have a dynamic size.
 * 
 * The process looks like:
 * - Increment the right index and add to currentSum
 *      - If currentSum is still less than X, continuing looping
 *      - If currentSum is greater than X: 
 *          - Check if this is the minimum length solution so far
 *          - Increment the left index and subtract from currentSum
 *              - Check if this is the minimum lenght solution so far
 *              - Continue moving left until the sum is less than X or left == right
 * 
 * The tricky, potentially counterintuitive part of this process is moving the left
 * index. This is done to make the window smaller and see if we're still greater than
 * X, revealing a potentially shorter subarray. 
 * 
 ****************************************************************************************/

public class DynamicSlidingWindow {
    
    public static int shortestSubarrayGreaterThanX(int[] array, int x) {
        int minLength = Integer.MAX_VALUE;
        int currentSum = 0;
        int left = 0;
        
        for(int right = 0; right < array.length; right++) {
            currentSum += array[right];

            if(currentSum > x) {
                minLength = Math.min(right - left + 1, minLength);
                
                while(currentSum > x && left != right) {
                    left++;
                    currentSum -= array[left];

                    minLength = Math.min(right - left + 1, minLength);
                }
            }
        }

        return minLength;
    } 

    public static void main(String[] args) {
        System.out.println("________");

        int[] input = {1,2,3,4,5};
        int result = shortestSubarrayGreaterThanX(input, 8);

        System.out.println("Result is: " + result);
    }
}
