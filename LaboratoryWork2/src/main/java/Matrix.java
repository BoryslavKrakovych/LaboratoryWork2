import java.util.Random;
import java.util.Scanner;


public class Matrix {
    private static int row = 0;
    private static int column = 0;
    private static int[][] array;


    public Matrix() {
        row = 0;
        column = 0;
    }

    public Matrix(int r, int c) {
        array = new int[r][c];
        row = r;
        column = c;
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                array[i][j] = 0;
    }

    public void copy(Matrix a) {
        array = new int[row][column];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++)
                array[r][c] = a.array[r][c];
        }
    }

    public static void init(int low, int up) {
        array = new int[row][column];
        Random rand = new Random();
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++)
                array[r][c] = rand.nextInt(up - low + 1) + low;
        }
    }

    public static void init_column(int low, int up) {
        array = new int[1][column];
        Random rand = new Random();
        for (int r = 0; r < 1; r++) {
            for (int c = 0; c < column; c++)
                array[r][c] = rand.nextInt(up - low + 1) + low;
        }
    }

    public int size1() {
        return array.length;
    }

    public int size2() {
        return array[0].length;
    }

    public void setElement(int r, int c, int v) {
        if (r >= row || c >= column)
            throw new RuntimeException("Going out of the array in method setElement\n");
        else {
            array[r][c] = v;
        }
    }

    public int getElement(int r, int c) {
        if (r >= row || c >= column)
            throw new RuntimeException("Going out of the array in method getElement\n");
        else {
            return array[r][c];
        }
    }
    public String getRow(int r) {
        StringBuilder res = new StringBuilder();
        if (r >= row)
            throw new RuntimeException("Going out of the array in method getRow\n");
        else {
            for (int j = 0; j < column; j++) {
                    res.append(" ").append(getElement(r, j));
                }
                res.append("\n");
            }
            return res.toString();
        }
    public String getColumn(int c) {
        StringBuilder res = new StringBuilder();
        if (c >= column)
            throw new RuntimeException("Going out of the array in method getColoumn\n");
        else {
            for (int i = 0; i < row; i++) {
                res.append(" ").append(getElement(i, c));
                res.append("\n");
            }
            res.append("\n");
        }
        return res.toString();
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                res.append(" ").append(getElement(i, j));
            }
            res.append("\n");
        }
        return res.toString();
    }

    public Matrix sum(Matrix a) {
        if (row != a.row || column != a.column) {
            throw new RuntimeException("The matrices in the method sum have a different size\n");
        } else {
            Matrix res = new Matrix(row, column);
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    int tmp = a.getElement(i, j) + this.getElement(i, j);
                    res.setElement(i, j, tmp);
                }
            }
            return res;
        }
    }

    public boolean equals(Object obj) {
        boolean match = false;
        if (obj instanceof Matrix) {
            Matrix otherMatrix = (Matrix) obj;
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < column; c++)
                    match = (array[r] == otherMatrix.array[r] && array[c] == otherMatrix.array[c]);
            }
        }
        return match;
    }

    public int hashCode() {
        int match=0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++){
                match=array[r].hashCode() * (1000_000_000 + 7) + array[c].hashCode();}
        }
        return match;
    }
    public void lowerTriangularMatrix()
    {
        int row = array.length;
        int col = array[0].length;

        if (row != col) {
            System.out.println("Matrix should be a Square Matrix");
        }
        else {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {


                    if (i < j) {
                        array[i][j] = 0;
                    }
                }
            }

        }
    }
    public void upperTriangularMatrix() {
        int row = array.length;
        int col = array[0].length;

        if (row != col) {
            System.out.println(
                    "Matrix should be a Square Matrix");
        }
        else {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {


                    if (i > j) {
                        array[i][j] = 0;
                    }
                }
            }

        }
    }
}
