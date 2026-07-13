class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
         int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;

        while (left < right) {
            int mid = (left + right) >> 1;

            int row = mid / cols;
            int col = mid % cols;

            if (matrix[row][col] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return matrix[left / cols][left % cols] == target;
    }
}