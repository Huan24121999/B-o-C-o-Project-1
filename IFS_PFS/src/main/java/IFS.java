import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IFS {
    private static int m;
    private static int n;
    private static int k;
    public static void main(String[] args) {
        System.out.println("Nhập số bệnh nhân, triệu chứng và bênh");
        Scanner scanner=new Scanner(System.in);
        m=scanner.nextInt();
        n=scanner.nextInt();
        k=scanner.nextInt();
        Point[][] A=nhapDL(m,n,"bệnh nhân","triệu chứng");
        Point[][] B=nhapDL(n,k,"triệu chứng"," bệnh");
        inDLfloat(m,k,xuly(m,n,k,A,B));
        ketLuan(m,k,xuly(m,n,k,A,B));


    }
    public static Point[][] nhapDL(int m,int n, String s1, String s2){
        Scanner scanner=new Scanner(System.in);
        Point[][] A=new Point[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.println("Nhập giá trị cho "+s1+" thứ "+(i+1)+
                        s2+" thứ "+(j+1));
                Point point=new Point();
                point.setX(scanner.nextFloat());
                point.setY(scanner.nextFloat());
                A[i][j]=point;
            }
        }
        inDL(m,n,A);
        return A;
    }
    public static void inDL(int m,int n,Point[][] A){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(A[i][j].toString()+"  ");
            }
            System.out.println();
        }
    }

    public static float[][] xuly(int m,int n,int k,Point[][]A,Point[][]B){
        float[][] C=new float[m][k];
        for(int i=0;i<m;i++){
            for(int j=0;j<k;j++){
                double sum=0;
                for(int l=0;l<n;l++){
                   sum+=tinhTheoCT(A[i][l],B[l][j]);
                }
                C[i][j]=(float)2/n*(float)sum;
            }
        }
        inDLfloat(m,k,C);
         return C;
    }

    public static double tinhTheoCT(Point x,Point y){
        float xA=x.getX();
        float xB=y.getX();
        float yA=x.getY();
        float yB=y.getY();
        double valueX=Math.sin(Math.PI*Math.abs(xA-xB)/6);
        double valueY=Math.sin(Math.PI*Math.abs(yA-yB)/6);
        return (valueX+valueY)/(1+valueX+valueY);
    }

    public static void inDLfloat(int m,int n,float[][] A){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(A[i][j]+"  ");
            }
            System.out.println();
        }
    }
    public static void ketLuan(int m,int k,float [][] A){
        for(int i=0;i<m;i++){
            float min=A[i][0];
            int index=0;
            for(int j=1;j<k;j++){
                if(A[i][j]<min) {
                    min=A[i][j];
                    index=j;
                }
            }
            System.out.println("Bệnh nhân thứ "+(i+1)+" được chẩn đoán mắc bệnh thứ: "+(index+1));
        }
    }

}
