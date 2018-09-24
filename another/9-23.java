LC 308:


class NumMatrix {
    
    //set the fields, which is the sum recording matrix
    int[][] sumMatrix;

    public NumMatrix(int[][] matrix) {
        //initialize the sum matrix
        if (matrix.length == 0) sumMatrix = new int[0][0];
        else {
            sumMatrix = new int[matrix.length][matrix[0].length];   //coner case?
            for (int i = 0; i < matrix.length; i ++) {
                for (int j = 0; j < matrix[0].length; j ++) {
                    sumMatrix[i][j] = matrix[i][j];
                    if (j > 0) sumMatrix[i][j] += sumMatrix[i][j - 1];      
                }
            }
        }
        
    }//O(n^2)
    
    public void update(int row, int col, int val) {
        //update the sum matrix, update the same row
        int origin = (col == 0) ? sumMatrix[row][col] : sumMatrix[row][col] - sumMatrix[row][col - 1];
        int diff = val - origin;
        for (int i = col; i < sumMatrix[0].length; i ++) {
            sumMatrix[row][i] += diff;
        }
    }//O(n)
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        //use the sum matrix to get the final results
        int sumPrevCol = 0, sumAll = 0;
        for (int i = row1; i <= row2 && col1 > 0; i ++) {
            sumPrevCol += sumMatrix[i][col1 - 1];
        }
        for (int i = row1; i <= row2; i ++) {
            sumAll += sumMatrix[i][col2];
        }
        return sumAll - sumPrevCol;
    }//O(n)
}

//the number of calls to update and sumRegion function is distributed evenly
//so this case, only add the row sum, can lead to O(n) time complexity



















































