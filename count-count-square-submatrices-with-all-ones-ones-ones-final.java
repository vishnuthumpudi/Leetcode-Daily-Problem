class Solution {
    public int countSquares(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int count = 0;

        for (int i = 1; i < rows; i++) if (matrix[i][0] == 1) matrix[i][0] = 1; 
        for (int j = 1; j < cols; j++) if (matrix[0][j] == 1) matrix[0][j] = 1;  
 
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = Math.min(matrix[i - 1][j], Math.min(matrix[i][j - 1], matrix[i - 1][j - 1])) + 1;
                }
            }
        }
        for (int i = 0; i < rows; i++) for (int j = 0; j < cols; j++) count += matrix[i][j];

        return count;
    }
}
