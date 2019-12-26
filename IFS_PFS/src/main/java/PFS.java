import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PFS {
    private static int m;
    private static int n;
    private static int k;
    public static void main(String[] args) {
        System.out.println("Nhập số bệnh nhân, triệu chứng và bênh");
        Scanner scanner=new Scanner(System.in);
        m=scanner.nextInt();
        n=scanner.nextInt();
        k=scanner.nextInt();
        PicturePoint[][] A=NhapDL(m,n,"bệnh nhân","triệu chứng");
        PicturePoint[][] B=NhapDL(n,k,"triệu chứng","bệnh");
        PicturePoint[][] C=xuly(m,n,k,A,B);
        inDL(m,k,C);
        inDLfloat(m,k,changeValue(m,k,C));
    }
    public static PicturePoint[][] NhapDL(int m,int n, String s1, String s2){
        Scanner scanner=new Scanner(System.in);
        PicturePoint[][] A=new PicturePoint[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.println("Nhập giá trị cho "+s1+" thứ "+(i+1)+
                        s2+" thứ "+(j+1));
                PicturePoint picturePoint=new PicturePoint();
                picturePoint.setX(scanner.nextFloat());
                picturePoint.setY(scanner.nextFloat());
                picturePoint.setZ(scanner.nextFloat());
                A[i][j]=picturePoint;
            }
        }
        inDL(m,n,A);
        return A;
    }
    public static void inDL(int m,int n,PicturePoint[][] A){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(A[i][j].toString()+"  ");
            }
            System.out.println();
        }
    }
    public static PicturePoint[][] xuly(int m,int n,int k,PicturePoint[][]A,PicturePoint[][]B){
        PicturePoint[][] C=new PicturePoint[m][k];
        for(int i=0;i<m;i++){
            for(int j=0;j<k;j++){
                List<Float> listX=new ArrayList<Float>();
                List<Float> listY=new ArrayList<Float>();
                List<Float> listZ=new ArrayList<Float>();
                for(int l=0;l<n;l++){
                    listX.add(Math.min(A[i][l].getX(),B[l][j].getX()));
                    listY.add(Math.min(A[i][l].getY(),B[l][j].getY()));
                    listZ.add(Math.max(A[i][l].getZ(),B[l][j].getZ()));
                }
                C[i][j]=new PicturePoint(findMax(listX),findMin(listY),findMin(listZ));
            }
        }
        System.out.println("in dữ liệu cho BẢNG SAU KHI XỬ LÝ");
        inDL(m,k,C);
        return C;
    }
    public static float[][] changeValue(int m,int k,PicturePoint[][] A){
        float[][] result=new float[m][k];
        for(int i=0;i<m;i++){
            for(int j=0;j<k;j++){
                PicturePoint picturePoint=A[i][j];
                float pi=1-picturePoint.getZ()-picturePoint.getX()-picturePoint.getY();
                result[i][j]=picturePoint.getX()-pi*picturePoint.getZ();
            }
        }
        return result;
    }
    public static void inDLfloat(int m,int n,float[][] A){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(A[i][j]+"  ");
            }
            System.out.println();
        }
    }
    public static float findMax(List<Float> floatList){
        float max=floatList.get(0);
        for (Float x:floatList
             ) {
            if(x>max) max=x;
        }
        return max;
    }
    public static float findMin(List<Float> floatList){
        float min=floatList.get(0);
        for (Float x:floatList
        ) {
            if(x<min) min=x;
        }
        return min;
    }
    public static void ketLuan(int m,int k,float[][] A){
        for(int i=0;i<m;i++){
            List<Integer> list=new ArrayList<Integer>();
            for(int j=0;j<k;j++){
                if(A[i][j]>0.5){
                    list.add(j);
                }
            }
            if(list.size()==0){
                System.out.println("bệnh nhân thứ "+(i+1)+ " không mắc bệnh gì");
            }
            else{
                System.out.println("Bệnh nhân thứ "+(i+1)+" có thể mắc các bệnh thứ: ");
                for (Integer x:list
                     ) {
                    System.out.println((x+1)+", ");
                }
            }
        }
    }

}
