import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public final class ImutableMatrix {
    private final Matrix a;
    public static final int h=31;
    //Конструктор Imutable-матриці
    public ImutableMatrix(Matrix b) {
        this.a = b.copy();
    }
    //Розмірність Imutable-матриці
    public String dimension() {
        return (this.a.dimension());
    }
    //Розмірність Imutable-матриці без виведення
    public int[] dim() {
        return (this.a.dim());
    }
    //Заповнення Imutable-матриці випадковими значеннями
    public static void init(int low, int up) {
        Random rand = new Random();
        for (int r = 0; r < Matrix.row; r++) {
            for (int c = 0; c < Matrix.column; c++)
                Matrix.array[r][c] = rand.nextInt(up - low + 1) + low;
        }
    }
    //Копія іншої Imutable-матриці
    public ImutableMatrix copy() {
        Matrix copy = new Matrix(this.a.dim()[0],this.a.dim()[1]);
        for (int r = 0; r < this.a.dim()[0]; r++) {
            for (int c = 0; c < this.a.dim()[1]; c++)
                copy.setElement(r,c,this.a.getElement(r,c));
        }
        return new ImutableMatrix(copy);
    }
    //Отримання елемента за індексом
    public int getElement(int r,int c) {
        return (this.a.getElement(r,c));
        }
    //Отримання рядка
    public String getRow(int r) {
        StringBuilder res = new StringBuilder();
        if (r >= a.row)
            throw new RuntimeException("Going out of the array in method getRow\n");
        else {
            for (int j = 0; j < a.column; j++) {
                res.append(" ").append(getElement(r, j));
            }
            res.append("\n");
        }
        return res.toString();
    }
    //Отримання стовпчика
    public String getColumn(int c) {
        StringBuilder res = new StringBuilder();
        if (c >= a.column)
            throw new RuntimeException("Going out of the array in method getColoumn\n");
        else {
            for (int i = 0; i < a.row; i++) {
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
        for (int i = 0; i < this.a.dim()[0]; i++) {
            for (int j = 0; j < this.a.dim()[1]; j++) {
                res.append(" ").append(getElement(i, j));
            }
            res.append("\n");
        }
        return res.toString();
    }
    //Метод equals
    public boolean equals(Object obj) {
        boolean match = false;
        if (obj instanceof ImutableMatrix) {
            ImutableMatrix otherMatrix = (ImutableMatrix) obj;
            for (int r = 0; r < a.row; r++) {
                for (int c = 0; c < a.column; c++)
                    match = (a.array[r] == otherMatrix.a.array[r] && a.array[c] == otherMatrix.a.array[c]);
            }
        }
        return match;
    }
    //Метод hashcode
    public int hashCode() {
        int match= Objects.hash(Integer.valueOf(a.row),Integer.valueOf(a.column),Integer.valueOf(this.getElement(0,0)),
                Arrays.hashCode(this.dim()),h);
        return match;
    }
    //Статичний метод створення Imutable-матриці-рядка
    public static String RowMatrix(int c, int low, int up) {
        StringBuilder res = new StringBuilder();
        int[] array_new = new int[c];
        Random rand = new Random();
        for (int j = 0; j < c; j++){
            array_new[j] = rand.nextInt(up - low + 1) + low;
            res.append(" ").append(array_new[j]);}
        return res.toString();
    }
    //Нижня трикутна Imutable-матриця
    public String lowerTriangularMatrix()
    {
        StringBuilder res = new StringBuilder();
        int row = a.array.length;
        int col = a.array[0].length;

        if (row != col) {
            System.out.println(
                    "Matrix should be a Square Matrix");
        }
        else {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {


                    if (i < j) {
                        a.array[i][j] = 0;
                    }
                }
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    res.append(" ").append(getElement(i, j));
                }
                res.append("\n");
            }
        }
        return res.toString();
    }
    //Верхня трикутна Imutable-матриця
    public String upperTriangularMatrix()
    {
        StringBuilder res = new StringBuilder();
        int row = a.array.length;
        int col = a.array[0].length;

        if (row != col) {
            System.out.println(
                    "Matrix should be a Square Matrix");
        }
        else {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {


                    if (i > j) {
                        a.array[i][j] = 0;
                    }
                }
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    res.append(" ").append(getElement(i, j));
                }
                res.append("\n");
            }
        }
        return res.toString();
    }
    }
