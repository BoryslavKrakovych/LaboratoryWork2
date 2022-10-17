import java.util.Arrays;
import java.util.Objects;
import java.util.Random;


public class Matrix {
    public static int row = 0;
    public static int column = 0;
    public static int[][] array;
    public static int h=29;

    //Конструкція пустої матриці
    public Matrix() {
        row = 0;
        column = 0;
    }

    //Конструкція матриці заданого розміру
    public Matrix(int r, int c) {
        array = new int[r][c];
        row = r;
        column = c;
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
              array[i][j] = 0;
    }
    //Копія іншої матриці
    public Matrix copy() {
        Matrix copy = new Matrix(row,column);
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++)
                copy.setElement(r,c,array[r][c]);
        }
        return copy;
    }
    //Заповнення матриці випадковими значеннями
    public static void init(int low, int up) {
        Random rand = new Random();
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++)
                array[r][c] = rand.nextInt(up - low + 1) + low;
        }
    }
    //Розмірність матриці
    public String dimension() {
        return("Dimension of matrix:"+row+"x"+column);
    }
    //Розмірність матриці без виведення
    public int[] dim() {
        return new int[]{row,column};
    }

    //Встановлення елемента за індексом
    public void setElement(int r, int c, int v) {
        if (r > row || c > column)
            throw new RuntimeException("Going out of the array in method setElement\n");
        else {
            array[r][c] = v;
        }
    }
    //Отримання елемента за індексом
    public int getElement(int r, int c) {
        if (r >= row || c >= column)
            throw new RuntimeException("Going out of the array in method getElement\n");
        else {
            return array[r][c];
        }
    }

    //Отримання рядка
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

    //Отримання стовпчика
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

    //Переведення в тип String
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


    //Метод equals
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

    //Метод hashcode
    public int hashCode() {
       int match= Objects.hash(Integer.valueOf(row),Integer.valueOf(column),Integer.valueOf(this.getElement(0,0)), Arrays.hashCode(this.dim()),h);
        return match;
    }
    //Статичний метод створення матриці-рядка
    public static String RowMatrix(int c, int low, int up) {
        StringBuilder res = new StringBuilder();
        int[] array_new = new int[c];
        Random rand = new Random();
        for (int j = 0; j < c; j++){
            array_new[j] = rand.nextInt(up - low + 1) + low;
            res.append(" ").append(array_new[j]);}
        return res.toString();
    }

    //Нижня трикутна матриця
    public String lowerTriangularMatrix()
    {
        StringBuilder res = new StringBuilder();
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
            for (int i = 0; i < this.row; i++) {
                for (int j = 0; j < this.column; j++) {
                    res.append(" ").append(getElement(i, j));
                }
                res.append("\n");
            }
        }
        return res.toString();
    }
    //Верхня трикутна матриця
    public String upperTriangularMatrix()
    {
        StringBuilder res = new StringBuilder();
        int row = array.length;
        int col = array[0].length;

        if (row != col) {
            System.out.println("Matrix should be a Square Matrix");
        }
        else {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (i > j) {
                        array[i][j] = 0;
                    }
                }
            }
            for (int i = 0; i < this.row; i++) {
                for (int j = 0; j < this.column; j++) {
                    res.append(" ").append(getElement(i, j));
                }
                res.append("\n");
            }
        }
        return res.toString();
    }
}
