#include <iostream>

using namespace std;

/********************************************************************************
 * Problem:
 * 
 * There are N stations in a route, starting from 0 to N-1. A train moves from
 * the first station (0) to the last station (N - 1) in the forward direction
 * only. The cost of a ticket between any two stations is given. Find the
 * minimum cost of travel from station 0 to station N-1.
 * 
 * My first solution is recursiveCheapestRoute(). This finds the minimum
 * cost by recursively checking the cost between every combination of
 * start and destination. Its base cases are when the start/end are the same
 * (the cost is zero), and when the distance between the start/end is one station
 * (the cost is defined in the COST table).
 * 
 * The recursive solution works, but it has overlapping subproblems, e.g. it
 * solves the same problem over and over again. While this isn't a problem
 * with four stations, this will quickly spiral out of control like the
 * fibonacci sequence does.
 * 
 * memoization and dp solution coming soon... =) 
 * 
 * 
********************************************************************************/

int iterations = 0;

const int SIZE = 4;

// Given by the book. The cost[i][j] is the cost of a ticket from station i
// to station j. Since moving backward is forbidden, we use -1 where i > j.
// The diagonal is zero because it costs nothing to stay at your current
// station.
const int COST[SIZE][SIZE] = {
        {0, 10, 75, 94},
        {-1, 0, 35, 50},
        {-1, -1, 0, 80},
        {-1, -1, -1, 0}
    };

int recursiveCheapestRoute(int startIndex, int destinationIndex) {
    iterations++;

    // Sanity check
    if(startIndex < 0 || startIndex >= SIZE || COST[startIndex][startIndex] == -1) {
        cerr << "Invalid startIndex: " << startIndex << endl;
        return -1;
    }
    if(destinationIndex < 0 || destinationIndex >= SIZE || COST[startIndex][destinationIndex] == -1) {
        cerr << "Invalid destinationIndex: " << destinationIndex << " for startIndex: " << startIndex << endl;
    }
    
    if(destinationIndex == startIndex) {
        return 0;
    }
    if(startIndex == destinationIndex - 1) {
        return COST[startIndex][destinationIndex];
    }
    else {

        int minCost = COST[startIndex][destinationIndex];

        for(int i = startIndex + 1; i < destinationIndex; i++) {
            int tmp = recursiveCheapestRoute(startIndex, i) + recursiveCheapestRoute(i, destinationIndex);

            if(tmp < minCost) {
                minCost = tmp;
            }
        }

        return minCost;
    }

    return -1;
}

int main() {
    
    int result = recursiveCheapestRoute(0, 3);

    cout << "Result is: " << result << " with " << iterations << " iterations" <<  endl;

    return 0;
}