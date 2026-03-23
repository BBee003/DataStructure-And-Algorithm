package com.dsalgo.solution.neetcode.algorithm.binarysearch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class Searcha2DMatrixTest {

    private Searcha2DMatrix searcha2DMatrix;

    @BeforeEach
    void setUp() {
        searcha2DMatrix = new Searcha2DMatrix();
    }

    @Test
    @DisplayName("Test target found in first row")
    void testTargetFoundInFirstRow() {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
        };
        int target = 3;
        assertTrue(searcha2DMatrix._v1Solve(matrix, target));
    }

    @Test
    @DisplayName("Test target found in last row")
    void testTargetFoundInLastRow() {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
        };
        int target = 34;
        assertTrue(searcha2DMatrix._v1Solve(matrix, target));
    }

    @Test
    @DisplayName("Test target found in middle row")
    void testTargetFoundInMiddleRow() {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
        };
        int target = 16;
        assertTrue(searcha2DMatrix._v1Solve(matrix, target));
    }

    @Test
    @DisplayName("Test target found at first element")
    void testTargetFoundAtFirstElement() {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
        };
        int target = 1;
        assertTrue(searcha2DMatrix._v1Solve(matrix, target));
    }

    @Test
    @DisplayName("Test target found at last element")
    void testTargetFoundAtLastElement() {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
        };
        int target = 50;
        assertTrue(searcha2DMatrix._v1Solve(matrix, target));
    }

    @Test
    @DisplayName("Test target not found")
    void testTargetNotFound() {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
        };
        int target = 13;
        assertFalse(searcha2DMatrix._v1Solve(matrix, target));
    }

    @Test
    @DisplayName("Test empty matrix")
    void testEmptyMatrix() {
        int[][] matrix = {};
        int target = 5;
        assertFalse(searcha2DMatrix._v1Solve(matrix, target));
    }

    @Test
    @DisplayName("Test matrix with empty rows")
    void testMatrixWithEmptyRows() {
        int[][] matrix = {{}};
        int target = 5;
        assertFalse(searcha2DMatrix._v1Solve(matrix, target));
    }

    @Test
    @DisplayName("Test single element matrix - target found")
    void testSingleElementMatrixTargetFound() {
        int[][] matrix = {{5}};
        int target = 5;
        assertTrue(searcha2DMatrix._v1Solve(matrix, target));
    }

    @Test
    @DisplayName("Test single element matrix - target not found")
    void testSingleElementMatrixTargetNotFound() {
        int[][] matrix = {{5}};
        int target = 3;
        assertFalse(searcha2DMatrix._v1Solve(matrix, target));
    }

    @Test
    @DisplayName("Test single row matrix")
    void testSingleRowMatrix() {
        int[][] matrix = {{1, 3, 5, 7, 9}};
        int target = 5;
        assertTrue(searcha2DMatrix._v1Solve(matrix, target));
    }

    @Test
    @DisplayName("Test single column matrix")
    void testSingleColumnMatrix() {
        int[][] matrix = {
            {1},
            {3},
            {5},
            {7},
            {9}
        };
        int target = 5;
        assertTrue(searcha2DMatrix._v1Solve(matrix, target));
    }

    @Test
    @DisplayName("Test two row matrix")
    void testTwoRowMatrix() {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6}
        };
        int target = 5;
        assertTrue(searcha2DMatrix._v1Solve(matrix, target));
    }

    @Test
    @DisplayName("Test target smaller than first element")
    void testTargetSmallerThanFirstElement() {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
        };
        int target = 0;
        assertFalse(searcha2DMatrix._v1Solve(matrix, target));
    }

    @Test
    @DisplayName("Test target larger than last element")
    void testTargetLargerThanLastElement() {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
        };
        int target = 100;
        assertFalse(searcha2DMatrix._v1Solve(matrix, target));
    }

    @Test
    @DisplayName("Test matrix with negative numbers")
    void testMatrixWithNegativeNumbers() {
        int[][] matrix = {
            {-10, -5, 0, 5},
            {10, 15, 20, 25},
            {30, 35, 40, 45}
        };
        int target = -5;
        assertTrue(searcha2DMatrix._v1Solve(matrix, target));
    }

    @Test
    @DisplayName("Test large matrix with proper row ordering")
    void testLargeMatrixWithProperRowOrdering() {
        int[][] matrix = new int[10][10];
        int value = 1;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                matrix[i][j] = value++;
            }
        }
        int target = 55; // Should be at row 5, column 4 (0-indexed)
        assertTrue(searcha2DMatrix._v1Solve(matrix, target));
    }

    @Test
    @DisplayName("Test matrix with equal elements in row (non-decreasing)")
    void testMatrixWithEqualElementsInRow() {
        int[][] matrix = {
            {1, 2, 2, 3},
            {4, 5, 5, 6},
            {7, 8, 8, 9}
        };
        int target = 5;
        assertTrue(searcha2DMatrix._v1Solve(matrix, target));
    }

    @Test
    @DisplayName("Test matrix with different row lengths but proper ordering")
    void testMatrixWithDifferentRowLengthsButProperOrdering() {
        int[][] matrix = {
            {1, 3, 5},
            {6, 8, 10},
            {11, 13, 15, 17}
        };
        int target = 8;
        assertTrue(searcha2DMatrix._v1Solve(matrix, target));
    }

    @Test
    @DisplayName("Test boundary conditions - minimum values")
    void testBoundaryConditionsMinValues() {
        int[][] matrix = {
            {Integer.MIN_VALUE, -1000, 0},
            {1, 1000, Integer.MAX_VALUE - 1000},
            {Integer.MAX_VALUE - 500, Integer.MAX_VALUE - 100, Integer.MAX_VALUE}
        };
        int target = Integer.MIN_VALUE;
        assertTrue(searcha2DMatrix._v1Solve(matrix, target));
    }

    @Test
    @DisplayName("Test boundary conditions - maximum values")
    void testBoundaryConditionsMaxValues() {
        int[][] matrix = {
            {Integer.MIN_VALUE, -1000, 0},
            {1, 1000, Integer.MAX_VALUE - 1000},
            {Integer.MAX_VALUE - 500, Integer.MAX_VALUE - 100, Integer.MAX_VALUE}
        };
        int target = Integer.MAX_VALUE;
        assertTrue(searcha2DMatrix._v1Solve(matrix, target));
    }

    @Test
    @DisplayName("Test target in range between rows but not in matrix")
    void testTargetInRangeBetweenRowsButNotInMatrix() {
        int[][] matrix = {
            {1, 5, 9},
            {15, 20, 25},
            {30, 35, 40}
        };
        int target = 12; // Between 9 and 15 but not in matrix
        assertFalse(searcha2DMatrix._v1Solve(matrix, target));
    }

    @Test
    @DisplayName("Test matrix with one row and one column")
    void testMatrixWithOneRowAndOneColumn() {
        int[][] matrix = {{42}};
        int target = 42;
        assertTrue(searcha2DMatrix._v1Solve(matrix, target));
    }

    @Test
    @DisplayName("Test matrix with zero target")
    void testMatrixWithZeroTarget() {
        int[][] matrix = {
            {-5, -2, 0},
            {1, 3, 5},
            {6, 8, 11}
        };
        int target = 0;
        assertTrue(searcha2DMatrix._v1Solve(matrix, target));
    }

    @Test
    @DisplayName("Test matrix with consecutive numbers")
    void testMatrixWithConsecutiveNumbers() {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int target = 6;
        assertTrue(searcha2DMatrix._v1Solve(matrix, target));
    }

    @Test
    @DisplayName("Test matrix with large gaps between rows")
    void testMatrixWithLargeGapsBetweenRows() {
        int[][] matrix = {
            {1, 2, 3},
            {100, 101, 102},
            {200, 201, 202}
        };
        int target = 101;
        assertTrue(searcha2DMatrix._v1Solve(matrix, target));
    }

    @Test
    @DisplayName("Test matrix with single element rows")
    void testMatrixWithSingleElementRows() {
        int[][] matrix = {
            {1},
            {5},
            {9},
            {13}
        };
        int target = 9;
        assertTrue(searcha2DMatrix._v1Solve(matrix, target));
    }

    @Test
    @DisplayName("Test matrix where target is exactly at row boundary")
    void testTargetAtRowBoundary() {
        int[][] matrix = {
            {1, 3, 5},
            {6, 8, 10},
            {11, 13, 15}
        };
        int target = 6; // First element of second row
        assertTrue(searcha2DMatrix._v1Solve(matrix, target));
    }

    @Test
    @DisplayName("Test matrix where target is last element of row")
    void testTargetAtLastElementOfRow() {
        int[][] matrix = {
            {1, 3, 5},
            {6, 8, 10},
            {11, 13, 15}
        };
        int target = 5; // Last element of first row
        assertTrue(searcha2DMatrix._v1Solve(matrix, target));
    }

    // ========== Tests for _v2Solve Method ==========
    
    @Test
    @DisplayName("Test _v2Solve - target found in first row")
    void testV2TargetFoundInFirstRow() {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
        };
        int target = 3;
        assertTrue(searcha2DMatrix._v2Solve(matrix, target));
    }

    @Test
    @DisplayName("Test _v2Solve - target found in last row")
    void testV2TargetFoundInLastRow() {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
        };
        int target = 34;
        assertTrue(searcha2DMatrix._v2Solve(matrix, target));
    }

    @Test
    @DisplayName("Test _v2Solve - target found in middle row")
    void testV2TargetFoundInMiddleRow() {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
        };
        int target = 16;
        assertTrue(searcha2DMatrix._v2Solve(matrix, target));
    }

    @Test
    @DisplayName("Test _v2Solve - target found at first element")
    void testV2TargetFoundAtFirstElement() {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
        };
        int target = 1;
        assertTrue(searcha2DMatrix._v2Solve(matrix, target));
    }

    @Test
    @DisplayName("Test _v2Solve - target found at last element")
    void testV2TargetFoundAtLastElement() {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
        };
        int target = 50;
        assertTrue(searcha2DMatrix._v2Solve(matrix, target));
    }

    @Test
    @DisplayName("Test _v2Solve - target not found")
    void testV2TargetNotFound() {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
        };
        int target = 13;
        assertFalse(searcha2DMatrix._v2Solve(matrix, target));
    }

    @Test
    @DisplayName("Test _v2Solve - empty matrix")
    void testV2EmptyMatrix() {
        int[][] matrix = {};
        int target = 5;
        assertFalse(searcha2DMatrix._v2Solve(matrix, target));
    }

    @Test
    @DisplayName("Test _v2Solve - matrix with empty rows")
    void testV2MatrixWithEmptyRows() {
        int[][] matrix = {{}};
        int target = 5;
        assertFalse(searcha2DMatrix._v2Solve(matrix, target));
    }

    @Test
    @DisplayName("Test _v2Solve - single element matrix - target found")
    void testV2SingleElementMatrixTargetFound() {
        int[][] matrix = {{5}};
        int target = 5;
        assertTrue(searcha2DMatrix._v2Solve(matrix, target));
    }

    @Test
    @DisplayName("Test _v2Solve - single element matrix - target not found")
    void testV2SingleElementMatrixTargetNotFound() {
        int[][] matrix = {{5}};
        int target = 3;
        assertFalse(searcha2DMatrix._v2Solve(matrix, target));
    }

    @Test
    @DisplayName("Test _v2Solve - single row matrix")
    void testV2SingleRowMatrix() {
        int[][] matrix = {{1, 3, 5, 7, 9}};
        int target = 5;
        assertTrue(searcha2DMatrix._v2Solve(matrix, target));
    }

    @Test
    @DisplayName("Test _v2Solve - single column matrix")
    void testV2SingleColumnMatrix() {
        int[][] matrix = {
            {1},
            {3},
            {5},
            {7},
            {9}
        };
        int target = 5;
        assertTrue(searcha2DMatrix._v2Solve(matrix, target));
    }

    @Test
    @DisplayName("Test _v2Solve - two row matrix")
    void testV2TwoRowMatrix() {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6}
        };
        int target = 5;
        assertTrue(searcha2DMatrix._v2Solve(matrix, target));
    }

    @Test
    @DisplayName("Test _v2Solve - target smaller than first element")
    void testV2TargetSmallerThanFirstElement() {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
        };
        int target = 0;
        assertFalse(searcha2DMatrix._v2Solve(matrix, target));
    }

    @Test
    @DisplayName("Test _v2Solve - target larger than last element")
    void testV2TargetLargerThanLastElement() {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
        };
        int target = 100;
        assertFalse(searcha2DMatrix._v2Solve(matrix, target));
    }

    @Test
    @DisplayName("Test _v2Solve - matrix with negative numbers")
    void testV2MatrixWithNegativeNumbers() {
        int[][] matrix = {
            {-10, -5, 0, 5},
            {10, 15, 20, 25},
            {30, 35, 40, 45}
        };
        int target = -5;
        assertTrue(searcha2DMatrix._v2Solve(matrix, target));
    }

    @Test
    @DisplayName("Test _v2Solve - large matrix with proper row ordering")
    void testV2LargeMatrixWithProperRowOrdering() {
        int[][] matrix = new int[10][10];
        int value = 1;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                matrix[i][j] = value++;
            }
        }
        int target = 55; // Should be at row 5, column 4 (0-indexed)
        assertTrue(searcha2DMatrix._v2Solve(matrix, target));
    }

    @Test
    @DisplayName("Test _v2Solve - matrix with equal elements in row (non-decreasing)")
    void testV2MatrixWithEqualElementsInRow() {
        int[][] matrix = {
            {1, 2, 2, 3},
            {4, 5, 5, 6},
            {7, 8, 8, 9}
        };
        int target = 5;
        assertTrue(searcha2DMatrix._v2Solve(matrix, target));
    }

    @Test
    @DisplayName("Test _v2Solve - boundary conditions - minimum values")
    void testV2BoundaryConditionsMinValues() {
        int[][] matrix = {
            {Integer.MIN_VALUE, -1000, 0},
            {1, 1000, Integer.MAX_VALUE - 1000},
            {Integer.MAX_VALUE - 500, Integer.MAX_VALUE - 100, Integer.MAX_VALUE}
        };
        int target = Integer.MIN_VALUE;
        assertTrue(searcha2DMatrix._v2Solve(matrix, target));
    }

    @Test
    @DisplayName("Test _v2Solve - boundary conditions - maximum values")
    void testV2BoundaryConditionsMaxValues() {
        int[][] matrix = {
            {Integer.MIN_VALUE, -1000, 0},
            {1, 1000, Integer.MAX_VALUE - 1000},
            {Integer.MAX_VALUE - 500, Integer.MAX_VALUE - 100, Integer.MAX_VALUE}
        };
        int target = Integer.MAX_VALUE;
        assertTrue(searcha2DMatrix._v2Solve(matrix, target));
    }

    @Test
    @DisplayName("Test _v2Solve - target in range between rows but not in matrix")
    void testV2TargetInRangeBetweenRowsButNotInMatrix() {
        int[][] matrix = {
            {1, 5, 9},
            {15, 20, 25},
            {30, 35, 40}
        };
        int target = 12; // Between 9 and 15 but not in matrix
        assertFalse(searcha2DMatrix._v2Solve(matrix, target));
    }

    @Test
    @DisplayName("Test _v2Solve - matrix with one row and one column")
    void testV2MatrixWithOneRowAndOneColumn() {
        int[][] matrix = {{42}};
        int target = 42;
        assertTrue(searcha2DMatrix._v2Solve(matrix, target));
    }

    @Test
    @DisplayName("Test _v2Solve - matrix with zero target")
    void testV2MatrixWithZeroTarget() {
        int[][] matrix = {
            {-5, -2, 0},
            {1, 3, 5},
            {6, 8, 11}
        };
        int target = 0;
        assertTrue(searcha2DMatrix._v2Solve(matrix, target));
    }

    @Test
    @DisplayName("Test _v2Solve - matrix with consecutive numbers")
    void testV2MatrixWithConsecutiveNumbers() {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int target = 6;
        assertTrue(searcha2DMatrix._v2Solve(matrix, target));
    }

    @Test
    @DisplayName("Test _v2Solve - matrix with large gaps between rows")
    void testV2MatrixWithLargeGapsBetweenRows() {
        int[][] matrix = {
            {1, 2, 3},
            {100, 101, 102},
            {200, 201, 202}
        };
        int target = 101;
        assertTrue(searcha2DMatrix._v2Solve(matrix, target));
    }

    @Test
    @DisplayName("Test _v2Solve - matrix with single element rows")
    void testV2MatrixWithSingleElementRows() {
        int[][] matrix = {
            {1},
            {5},
            {9},
            {13}
        };
        int target = 9;
        assertTrue(searcha2DMatrix._v2Solve(matrix, target));
    }

    @Test
    @DisplayName("Test _v2Solve - matrix where target is exactly at row boundary")
    void testV2TargetAtRowBoundary() {
        int[][] matrix = {
            {1, 3, 5},
            {6, 8, 10},
            {11, 13, 15}
        };
        int target = 6; // First element of second row
        assertTrue(searcha2DMatrix._v2Solve(matrix, target));
    }

    @Test
    @DisplayName("Test _v2Solve - matrix where target is last element of row")
    void testV2TargetAtLastElementOfRow() {
        int[][] matrix = {
            {1, 3, 5},
            {6, 8, 10},
            {11, 13, 15}
        };
        int target = 5; // Last element of first row
        assertTrue(searcha2DMatrix._v2Solve(matrix, target));
    }

    @Test
    @DisplayName("Test _v2Solve - rectangular matrix (more columns than rows)")
    void testV2RectangularMatrixMoreColumns() {
        int[][] matrix = {
            {1, 2, 3, 4, 5, 6},
            {7, 8, 9, 10, 11, 12}
        };
        int target = 9;
        assertTrue(searcha2DMatrix._v2Solve(matrix, target));
    }

    @Test
    @DisplayName("Test _v2Solve - rectangular matrix (more rows than columns)")
    void testV2RectangularMatrixMoreRows() {
        int[][] matrix = {
            {1, 2},
            {3, 4},
            {5, 6},
            {7, 8},
            {9, 10}
        };
        int target = 7;
        assertTrue(searcha2DMatrix._v2Solve(matrix, target));
    }
}
