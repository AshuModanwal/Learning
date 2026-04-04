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
        int n = mat.length;

        int m = mat[0].length;

        Boolean [] row = new Boolean[n];
        Boolean []col = new Boolean[m];

        for(int i=0; i<n;i++)
            row[i]=false;
        for(int i=0; i<m; i++)
            col[i]=false;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    row[i]=true;
                    col[j]=true;
                }
            }
        }

        for(int i=0; i<n; i++){
            if(row[i]){
                for(int j=0; j<m; j++)
                    mat[i][j]=0;
            }
        }
        for(int i=0; i<m; i++){
            if(col[i]){
                for(int j=0; j<n; j++)
                    mat[j][i]=0;
            }
        }

    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        SetMatrixZero obj = new SetMatrixZero();
//        obj.basicMethod(matrix);

        obj.optimizeMethod(matrix);
        // Print result
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}