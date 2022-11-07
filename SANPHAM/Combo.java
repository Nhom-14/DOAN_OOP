package DOAN_OOP.SANPHAM;

import java.util.Scanner;

public class Combo extends SanPham{
    SanPham [] arrSP;
    private int n;
    public Combo(){
        this.arrSP=null;
        this.n=0;
    }
    public Combo(SanPham arrSP[],int n){
        this.arrSP=arrSP;
        this.n=n;
    }
    public int getN(){
        return n;
    }
    public void setN(int n){
        this.n=n;
    }
    public SanPham[] getarrSP(){
        return arrSP;
    }
    public void nhapSP(){
        Scanner input=new Scanner(System.in);
        System.out.print("Nhap so luong san pham trong combo: ");
        setN(input.nextInt());
        arrSP=new SanPham[n];
        for(int i=0;i<n;i++){
            SanPham sp=new SanPham();
            sp.nhapSP();
            arrSP[i]=sp;
        }
    }
    public void xuatSP(){
        for(SanPham sp:arrSP){
            sp.xuatSP();
        }
    }
}
