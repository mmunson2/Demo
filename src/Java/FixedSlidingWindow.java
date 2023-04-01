/********************************************************************************
 * Fixed-Size Sliding Window
 * 
 * This is the simplest form of a sliding window pattern. This class
 * solves the problem:
 * "Find the subarray with the greatest sum of k elements"
 * Where the inputs are an array of integers and k is an integer.
 * 
 * We know that the sliding window will always have the size k. 
 * 
 * The process looks like:
 * - Iterate through the first k elements, sum them, and store in currentSum
 * - Set maxSum = currentSum since this is our largest sum so far.
 * - Loop through the array. On each iteration:
 *      - Add the element k indices ahead of our current index
 *      - Subtract the element at index i
 *      - Check if our current sum exceeds the maximum sum
 * 
 * This solves the problem with a single loop through the array, making a 
 * worst-case complexity of O(n).
 * 
 ********************************************************************************/

class FixedSlidingWindow {

    public static int maxSubArray(int[] array, int size) {
        int maxSum = 0;
        int currentSum = 0;

        if(size > array.length) {
            System.err.println("Size must be less than the array length!");
            return 0;
        }

        for(int i = 0; i < size; i++) {
            currentSum += array[i];
        }

        maxSum = currentSum;

        for(int i = 0; i < array.length - size; i++) {
            currentSum -= array[i];
            currentSum += array[i + size];

            if(currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] input = {1,2,3,4,5,6};
        int size = 3;

        int result = maxSubArray(input, size);

        System.out.println("The max value is: " + result);
    }
}