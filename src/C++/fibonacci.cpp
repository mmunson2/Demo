#include <iostream>

using namespace std;

/********************************************************************************
 * Fibonacci - Recursive vs. Iterative
 * 
 * This is a classic primer to dynamic programming problems. The fibonacci
 * sequence is created by summing the previous two numbers in the sequence
 * such that:
 * 
 * in:  0 1 2 3 4 5 6  7  ...
 * out: 1 1 2 3 5 8 13 21 ...
 * 
 * On first inspection, this problem appears to be a good candidate for a
 * recursive function. My recursiveFibonacci() has only three lines of code
 * and is easy to understand. However, as the invocations count will show,
 * this quickly creates an excessive amount of stack frames, and computing
 * a value over 40 will result in a stack overflow, or will simply
 * take forever.
 * 
 * The iterative solution for the fibonacci sequence isn't much more difficult
 * than the recursive method. It loops through the values and uses three
 * integers to track the two previous values and the current sum. This takes
 * a single stack frame, constant memory, and completes nearly instantly.
 * The only issue with this implementation is that the integer holding the
 * sum will quickly overflow :)
 * 
********************************************************************************/


// Globals are bad, but sometimes we need a simple counter
int invocations = 0;

int recursiveFibonacci(int input) {
    invocations++;

    if(input <= 1) {
        return 1;
    }

    return recursiveFibonacci(input - 1) + recursiveFibonacci(input - 2);
}

int iterativeFibonacci(int input) {
    if(input <= 1) {
        return 1;
    }

    // The previous number
    int back1 = 1;
    // The number before the previous number
    int back2 = 1;
    int current = 0;

    for(int i = 2; i <= input; i++) {
        invocations++;

        current = back2 + back1;
        back2 = back1;
        back1 = current;
    }

    return current;
}

int main() {
    for(int i = 0; i < 20; i++) {
        cout << "input: " << i << " result: " << recursiveFibonacci(i) << " invocations: " << invocations << endl;
        invocations = 0;
    }

    cout << "Now with DP!" << endl;

    for(int i = 0; i < 20; i++) {
        cout << "input: " << i << " result: " << iterativeFibonacci(i) << " invocations: " << invocations << endl;
        invocations = 0;
    }
}