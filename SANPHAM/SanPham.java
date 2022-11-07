package DOAN_OOP.SANPHAM;

import java.util.Scanner;

class SanPham{
    protected String MaSP;
    protected String TenSP;
    protected int GiaBan;
    protected int GiaNhap;
    protected int SoLuong;
    static Scanner input = new Scanner(System.in);
    public SanPham(){
        this.MaSP="";
        this.TenSP="";
        this.GiaBan=0;
        this.GiaNhap=0;
        this.SoLuong=0;
    }
    public SanPham(String MaSP,String TenSP,int GiaBan,int GiaNhap,int SoLuong){
        this.MaSP=MaSP;
        this.TenSP=TenSP;
        this.GiaBan=GiaBan;
        this.GiaNhap=GiaNhap;
        this.SoLuong=SoLuong;
    }
    public String getMaSP(){
        return MaSP;
    }
    /*
    public void setMaSP(String Masp){
        this.MaSP=Masp;
    }
    */
    public String getTenSP(){
        return TenSP;
    }
    public void setTenSP(String Tensp){
        this.TenSP=Tensp;
    }
    public int getGiaBan(){
        return GiaBan;
    }
    public void setGiaBan(int Giaban){
        this.GiaBan=Giaban;
    }
    public int getGiaNhap(){
        return GiaNhap;
    }
    public void setGiaNhap(int Gianhap){
        this.GiaNhap=Gianhap;
    }
    public int getSoLuong(){
        return SoLuong;
    }
    public void setSoLuong(int Soluong){
        this.SoLuong=Soluong;
    }
    public void nhapSP(){
        System.out.print("Nhap ten san pham: ");
        setTenSP(input.nextLine());
        System.out.print("Nhap gia ban: ");
        setGiaBan(input.nextInt());
        System.out.print("Nhap gia nhap: ");
        setGiaNhap(input.nextInt());
        System.out.print("Nhap so luong: ");
        setSoLuong(input.nextInt());
    }
    public void xuatSP(){
        System.out.print("Ma san pham: "+getMaSP()+" Ten san pham:" +getTenSP()+" Gia ban:"+getGiaBan()+" Gia nhap: "+getGiaNhap()+" So luong: "+getSoLuong()+"\n");
    }
    public String toString(){
        return MaSP+","+TenSP+","+GiaBan+","+GiaNhap+","+SoLuong;
    }
}