public class Main
{
    public static void main (String[]args) {
        var a = new Matrix (4,4);
        a.init(1,10);
        for(int i = 0; i < 3; i++){
            try{
                a.setElement(i,0,i);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            System.out.println(a);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(a);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        a.upperTriangularMatrix();
        try {
            System.out.println(a);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}