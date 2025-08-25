class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int rows = mat.length, cols = mat[0].length, n = rows * cols;
        int[] arr = new int[n];
        int r = 0, c = 0, index = 0;
        boolean up = true; 

        for (int i = 0; i < n; i++) {
            arr[index++] = mat[r][c];

            int next_r_if_up = r - 1;
            int next_c_if_up = c + 1;
            int next_r_if_down = r + 1;
            int next_c_if_down = c - 1;

            if (up) {
                if (next_r_if_up >= 0 && next_c_if_up < cols) {
                    r = next_r_if_up;
                    c = next_c_if_up;
                } else {
                    up = false;

                    if (next_c_if_up >= cols) { 
                        r++; 
                    } else { 
                        c++; 
                    }
                }
            } else {
                if (next_r_if_down < rows && next_c_if_down >= 0) {
                    r = next_r_if_down;
                    c = next_c_if_down;
                } else {
                    up = true; 

                    if (next_r_if_down >= rows) { 
                        c++; 
                    } else { 
                        r++;
                    }
                }
            }
        }
        
        return arr;
    }
}
