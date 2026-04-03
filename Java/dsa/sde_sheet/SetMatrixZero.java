package dsa.sde_sheet;

import java.util.ArrayList;
import java.util.List;

class Pair {
    int row;
    int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class SetMatrixZero {

    private void basicMethod(int[][] mat) {
        List<Pair> list = new ArrayList<>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    list.add(new Pair(i, j));
                }
            }
        }

        for (Pair pair : list) {
            for (int i = 0; i < mat[0].length; i++) {
                mat[pair.row][i] = 0;
            }

            for (int i = 0; i < mat.length; i++) {
                mat[i][pair.col] = 0;
            }
        }
    }

    private void optimizeMethod(int [][] mat){

    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        SetMatrixZero obj = new SetMatrixZero();
        obj.basicMethod(matrix);

        // Print result
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}