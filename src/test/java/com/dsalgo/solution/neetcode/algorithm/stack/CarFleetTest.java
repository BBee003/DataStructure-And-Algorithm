package com.dsalgo.solution.neetcode.algorithm.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarFleetTest {

    private CarFleet carFleet;

    @BeforeEach
    void setUp() {
        carFleet = new CarFleet();
    }

    @Test
    void testBasicExample() {
        int target = 12;
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};
        int result = carFleet._v1Solve(target, position, speed);
        assertEquals(3, result);
    }

    @Test
    void testSingleCar() {
        int target = 10;
        int[] position = {5};
        int[] speed = {2};
        int result = carFleet._v1Solve(target, position, speed);
        assertEquals(1, result);
    }

    @Test
    void testAllCarsSameFleet() {
        int target = 10;
        int[] position = {2, 4, 6};
        int[] speed = {4, 3, 2};
        int result = carFleet._v1Solve(target, position, speed);
        assertEquals(1, result);
    }

    @Test
    void testAllCarsSeparateFleets() {
        int target = 100;
        int[] position = {10, 20, 30};
        int[] speed = {1, 1, 1};
        int result = carFleet._v1Solve(target, position, speed);
        assertEquals(3, result);
    }

    @Test
    void testCarsAtSamePosition() {
        int target = 10;
        int[] position = {5, 5};
        int[] speed = {1, 2};
        int result = carFleet._v1Solve(target, position, speed);
        assertEquals(1, result);
    }

    @Test
    void testCarSlowerButAhead() {
        int target = 20;
        int[] position = {15, 10};
        int[] speed = {1, 5};
        int result = carFleet._v1Solve(target, position, speed);
        assertEquals(1, result);
    }

    @Test
    void testVerySlowCars() {
        int target = 100;
        int[] position = {10, 20, 30};
        int[] speed = {1, 1, 1};
        int result = carFleet._v1Solve(target, position, speed);
        assertEquals(3, result);
    }

    @Test
    void testVeryFastCars() {
        int target = 100;
        int[] position = {90, 80, 70};
        int[] speed = {10, 20, 30};
        int result = carFleet._v1Solve(target, position, speed);
        assertEquals(1, result);
    }

    @Test
    void testMixedSpeedsAndPositions() {
        int target = 50;
        int[] position = {0, 10, 20, 30, 40, 45};
        int[] speed = {1, 2, 1, 3, 1, 5};
        int result = carFleet._v1Solve(target, position, speed);
        assertEquals(4, result);
    }

    @Test
    void testLargeNumberOfCars() {
        int target = 100;
        int[] position = new int[20];
        int[] speed = new int[20];
        for (int i = 0; i < 20; i++) {
            position[i] = i * 5;
            speed[i] = i % 3 + 1;
        }
        int result = carFleet._v1Solve(target, position, speed);
        assertTrue(result > 0 && result <= 20);
    }

    @Test
    void testCarsWithSameTime() {
        int target = 20;
        int[] position = {10, 5, 15};
        int[] speed = {2, 1, 1};
        int result = carFleet._v1Solve(target, position, speed);
        assertEquals(2, result);
    }

    @Test
    void testEdgeCaseTargetZero() {
        int target = 0;
        int[] position = {0, 0};
        int[] speed = {1, 2};
        int result = carFleet._v1Solve(target, position, speed);
        assertEquals(1, result);
    }

    @Test
    void testCarsBeyondTarget() {
        int target = 10;
        int[] position = {5, 12};
        int[] speed = {1, 1};
        int result = carFleet._v1Solve(target, position, speed);
        assertEquals(2, result);
    }

    @Test
    void testEmptyPositionArray() {
        int target = 10;
        int[] position = {};
        int[] speed = {};
        assertThrows(IllegalArgumentException.class, () -> {
            carFleet._v1Solve(target, position, speed);
        });
    }

    @Test
    void testEmptySpeedArray() {
        int target = 10;
        int[] position = {5};
        int[] speed = {};
        assertThrows(IllegalArgumentException.class, () -> {
            carFleet._v1Solve(target, position, speed);
        });
    }

    @Test
    void testMismatchedArrayLengths() {
        int target = 10;
        int[] position = {5, 8};
        int[] speed = {1};
        assertThrows(IllegalArgumentException.class, () -> {
            carFleet._v1Solve(target, position, speed);
        });
    }

    @Test
    void testSingleCarAtTarget() {
        int target = 10;
        int[] position = {10};
        int[] speed = {5};
        int result = carFleet._v1Solve(target, position, speed);
        assertEquals(1, result);
    }

    @Test
    void testAllCarsSamePosition() {
        int target = 20;
        int[] position = {5, 5, 5};
        int[] speed = {1, 2, 3};
        int result = carFleet._v1Solve(target, position, speed);
        assertEquals(1, result);
    }

    @Test
    void testConsecutivePositions() {
        int target = 10;
        int[] position = {1, 2, 3, 4, 5};
        int[] speed = {1, 1, 1, 1, 1};
        int result = carFleet._v1Solve(target, position, speed);
        assertEquals(5, result);
    }

    @Test
    void testVerySmallTarget() {
        int target = 1;
        int[] position = {0, 0, 0};
        int[] speed = {1, 2, 3};
        int result = carFleet._v1Solve(target, position, speed);
        assertEquals(1, result);
    }

    @Test
    void testDoubleTime() {
        int target = 10;
        int[] position = {6, 8};
        int[] speed = {3, 2};
        int result = carFleet._v1Solve(target, position, speed);
        assertEquals(2, result);
    }
}
