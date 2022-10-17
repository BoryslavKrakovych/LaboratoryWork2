public class Main
{
    public static void main (String[]args) {

        var a=new Matrix(2,2);
        var b=new ImutableMatrix(a);
        var c=new ImutableMatrix(a);
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(c.hashCode());
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println(c.equals(b));
/*
        var a=new Matrix(2,2);
        a.init(1,10);
        try {
            System.out.println(a);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(a.getElement(1,1));
        System.out.println(a.getRow(1));
        System.out.println(a.getColumn(1));
        System.out.println(a.dimension());
        System.out.println(a.upperTriangularMatrix());

        var b=new ImutableMatrix(a);
        b.init(1,10);
        try {
            System.out.println(b);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(b.getElement(1,1));
        System.out.println(b.getRow(1));
        System.out.println(b.getColumn(1));
        System.out.println(b.dimension());
        System.out.println(b.upperTriangularMatrix());
*/
    }

    }
