/********************************************************************************
 * Minimum Index in an Array
 * 
 * This is the solution to an interview question I've been asked before. The
 * first component is just checking to see if you can code. The second portion
 * makes things a bit more interesting:
 * 
 * 1. Write a function that takes an array, a start index, and an end index.
 * Find the index of the minimum value between the start and end.
 * 
 * 2. Now assume that the array is a constant. You may use an initialization
 * method with unlimited processing time and memory usage. Can you improve
 * on the performance of your original implementation?
 * 
 * 
 *******************************************************************************/
public class MinArray {
    
    /****************************************************************************
     * Simple Minimum Array
     * 
     * This is the simple O(n) solution to the first component of this problem.
     * 
     * When I implemented this problem I was assured that the inputs would be
     * valid, but I've bulletproofed it here to demonstrate all possible cases
     * where the input could be incorrect.
     * 
     * The implementation is simple. Loop through each element from the given
     * start to the given end. Store the index of the minimum element found
     * so far.
     * 
     * I've compromised readability here a bit with a check for start == end.
     * This handles the case of array length == 1. Otherwise I would start
     * the for loop at i = start with minIndex = start, which is technically
     * a waste of a loop iteration. This is definitely the kind of question
     * that's easy to overthink :)
     * 
     ***************************************************************************/
    public static int simpleMinArray(int[] array, int start, int end) throws IllegalArgumentException {
        
        // Make sure our parameters are valid
        if(array.length == 0) {
            throw new IllegalArgumentException("Input array must have at least one element!");
        }
        else if(start < 0 || start >= array.length) {
            throw new IllegalArgumentException("Start index: " + start + " must be greater than" +
            " zero and less than " + array.length);
        }
        else if(end < 0 || end >= array.length) {
            throw new IllegalArgumentException("End index: " + end + " must be greater than" +
            " zero and less than " + array.length);
        }
        else if(end < start) {
            throw new IllegalArgumentException("End index: " + end + " must be greater than" +
            " or equal to start index: " + start);
        }
        
        // Ensure that there are at least two elements to find the min of
        if(start == end) {
            return start;
        }

        int minIndex = start;

        for(int i = start + 1; i <= end; i++) {
            if(array[i] < array[minIndex]) {
                minIndex = i;
            }
        }

        return minIndex;
    }

    // Constant input array
    public static final int[] minArray = {6, 5, 4, 3, 2, 1, 2, 3, 4, 5};

    // 2D array of minimum index for start/end combinations
    public static int[][] minCombinations;

    /****************************************************************************
     * Initialize
     * 
     * We take advantage of our unlimited memory and processing time to create
     * a 2D array of all possible start/end minimum combinations. 
     * 
     * Because the end must always be greater than or equal to the start, we
     * don't need to store any elements of the array where i < j. This allows
     * us to use a jagged array and save on our (unlimited) space. This is
     * at the cost of making our array indexing slightly more complicated.
     * 
     ***************************************************************************/
    public static void initialize() {

        minCombinations = new int[minArray.length][];

        for(int i = 0; i < minCombinations.length; i++) {

            minCombinations[i] = new int[minArray.length - i];

            for(int j = 0; j < minCombinations[i].length; j++) {
                minCombinations[i][j] = simpleMinArray(minArray, i, i + j);
            }
        }
    }

    /****************************************************************************
     * Initialized Minimum Array
     * 
     * With our minimum array initialized, finding the minimum array is a now
     * an O(1) operation with a single line of code
     ***************************************************************************/
    public static int initializedMinArray(int start, int end) {
        // Make sure our parameters are valid
        if(minArray.length == 0) {
            throw new IllegalArgumentException("Input array must have at least one element!");
        }
        else if(start < 0 || start >= minArray.length) {
            throw new IllegalArgumentException("Start index: " + start + " must be greater than" +
            " zero and less than " + minArray.length);
        }
        else if(end < 0 || end >= minArray.length) {
            throw new IllegalArgumentException("End index: " + end + " must be greater than" +
            " zero and less than " + minArray.length);
        }
        else if(end < start) {
            throw new IllegalArgumentException("End index: " + end + " must be greater than" +
            " or equal to start index: " + start);
        }

        return minCombinations[start][end];
    }

    /****************************************************************************
     * Driver
     * 
     * Runs the simple array example, initializes the minCombinations array,
     * and runs the initializedMinArray.
     ***************************************************************************/
    public static void main(String[] args) {
        // Simple Min Array Test
        int[] simpleArrayExample = {1, 2, 3, 4, 5};
        int start = 1;
        int end = 3;

        int result1 = simpleMinArray(simpleArrayExample, start, end);

        System.out.println("The minimum index between " +
        start + " and " + end + " is: " + result1);

        // Initialized Min Array Test
        initialize();

        int result2 = initializedMinArray(start, end);

        System.out.println("The minimum index of the initialized array" +
        " between " + start + " and " + end + " is: " + result2);
    }

}
