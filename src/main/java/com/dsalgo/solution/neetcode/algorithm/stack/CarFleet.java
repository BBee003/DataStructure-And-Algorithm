package com.dsalgo.solution.neetcode.algorithm.stack;

import java.util.*;
import com.dsalgo.solution.neetcode.datastructure.stack.Stack;

public class CarFleet {

    /**
     * 
     * STEP:
     *      1. Iterate through for both position and speed at the same time.
     *          2. Calculate the individual car time and store along with the position.
     *      3. Sort each car based on the position.
     *      4. Process each car with position and time.
     *          5. if stack is empty, add the current car to stack.
     *          5. if not, compare current time with last car time in a stack.
     *              6. if current car time <= last car time: skip.
     *              6. if current car time > last car time: add to stack cuz new fleet happen.
     *      7. Return the length of the stack.
     * 
     * COMPLEXITY:
     *      1. Time: O(n log n)
     *      2. Space: O(n)
     */
    public int _v1Solve(int target, int[] position, int[] speed) {
        if (position.length == 0 || speed.length == 0 || position.length != speed.length) throw new IllegalArgumentException("Invalid input position or speed");

        // time[i][0] -> car position
        // time[i][1] -> car time
        double[][] time = new double[position.length][2];
        for (int i=0; i<position.length; i++) {
            time[i][0] = position[i];
            time[i][1] = (double) (target - position[i]) / speed[i];
        }

        // sort every case based on position
        Arrays.sort(time, (a, b) -> Double.compare(b[0], a[0]));

        // get the number of fleet
        Stack<double[]> fleet = new Stack<>();
        for (double[] individual: time) {
            if (fleet.isEmpty() || individual[1] > fleet.peek()[1]) {
                fleet.push(individual);
            }
        }

        return fleet.size();
    }
}
