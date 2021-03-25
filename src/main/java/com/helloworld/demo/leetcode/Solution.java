package com.helloworld.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int[] order = new int[total];
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            order[i] = matrix[row][column];
            visited[row][column] = true;

            int nextRow = row + directions[directionIndex][0];
            int nextColumn = column + directions[directionIndex][1];

            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return order;
    }

    public int[] spiralOrder1(int[][] matrix) {
        //特判
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        //初始化
        int left = 0, top = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        int[] res = new int[(right + 1) * (bottom + 1)];
        int k = 0;

        //循环打印
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) { //从左到右
                res[k++] = matrix[top][i];
            }
            top++;
            for (int i = top; i <= bottom; i++) { //从上到下
                res[k++] = matrix[i][right];
            }
            right--;
            for (int i = right; i >= left && top <= bottom; i--) {    //从右到左
                res[k++] = matrix[bottom][i];
            }
            bottom--;
            for (int i = bottom; i >= top && left <= right; i--) {    //从下到上
                res[k++] = matrix[i][left];
            }
            left++;
        }
        return res;
    }


    public int[] spiralOrder2(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int[] result = new int[matrix.length * matrix[0].length];
        int u = 0, d = matrix.length - 1, l = 0, r = matrix[0].length - 1;
        int idx = 0;
        while (true) {
            for (int i = l; i <= r; i++) {
                result[idx++] = matrix[u][i];
            }
            if (++u > d) {
                break;
            }
            for (int i = u; i <= d; i++) {
                result[idx++] = matrix[i][r];
            }
            if (--r < l) {
                break;
            }
            for (int i = r; i >= l; i--) {
                result[idx++] = matrix[d][i];
            }
            if (--d < u) {
                break;
            }
            for (int i = d; i >= u; i--) {
                result[idx++] = matrix[i][l];
            }
            if (++l > r) {
                break;
            }
        }
        return result;
    }

    /**
     * 顺时针打印矩阵
     *
     * @param matrix
     * @return
     */
    public int[] spiralOrder3(int[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;
        int[] result = new int[height * width];
        //四个脚的坐标


        return result;
    }
}