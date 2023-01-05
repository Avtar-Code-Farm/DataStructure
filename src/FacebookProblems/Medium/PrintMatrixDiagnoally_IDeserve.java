package FacebookProblems.Medium;

import java.util.Arrays;

public class PrintMatrixDiagnoally_IDeserve {
    public static void main(String[] args) {
        int row = 4, col = 5;
        int k = 1;
        int matrix[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = k++;
            }
        }

        System.out.println("Input Matrix");
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

        System.out.println("\nPrinting Matrix Diagonally");
        printMatrixDiagonallyOnDriection(matrix);
        printMatrixDiagonall(matrix);
    }

    private static void printMatrixDiagonall(int[][] matrix) {
        int row_len = matrix.length;
        int col_len = matrix[0].length;

        boolean up = true;
        int[] res = new int[row_len*col_len];
        int index =0;
        int row = 0, col = 0;
        while(row < row_len && col < col_len) {
            if(up) {
                while(row >=0 && col < col_len) {
                    res[index++] = matrix[row][col];
                    row--;
                    col++;
                }
                if(col >= col_len) {
                    row= row+2;
                    col = col-1;
                }
                if(row < 0)
                    row = row +1;
                up = false;
            }
            else {
                while(row < row_len &&  col >= 0) {
                    res[index++] = matrix[row][col];
                    row++;
                    col--;
                }
                if(row >= row_len) {
                    row = row - 1;
                    col = col + 2;
                }
                if(col < 0);
                {
                    col = col + 1;
                }
                up = true;
            }
        }

        for(int i = 0; i < res.length; i++) {
            System.out.print(" " + res[i]);
        }

    }

    private static void printMatrixDiagonallyOnDriection(int[][] matrix) {
        int row_count = matrix.length;
        int col_count = matrix[0].length;

        int row = 0;
        int col = 0;

        for(int k = 0; k < row_count; k++) {
            for(row = k, col= 0; row >= 0 && col <=col_count; row--, col++ ) {
                System.out.print(" " + matrix[row][col]);
            }
            System.out.println();
        }

        for(int k = 1; k < col_count; k++){
            for(row = row_count-1, col = k; row >= 0 && col < col_count; row--, col++) {
                System.out.print(" " + matrix[row][col]);
            }
            System.out.println();
        }













    }
}
