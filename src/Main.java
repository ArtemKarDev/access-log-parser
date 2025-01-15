
public class Main {
    public static void main(String[] args) {

        Point a1 = new Point(1,3);
        Point a2 = new Point(1,3);
        Point a3 = new Point(5,8);
        System.out.println("points: "+a1+" "+a2+" "+a3);
        System.out.println("compare a1 a2: "+(a1==a2));
        System.out.println("compare a2 a3: "+(a2==a3));

        Point q1 = new Point3D(2,4,8);
        System.out.println(q1);
        Point3D q2 = new Point3D(4,2,1);


    }
}
