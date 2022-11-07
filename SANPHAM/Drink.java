package DOAN_OOP.SANPHAM;

public class Drink extends SanPham{
    public Drink(){
        super();
    }
    public Drink(String MaSP,String TenSP,int GiaBan,int GiaNhap,int SoLuong){
        super(MaSP, TenSP, GiaBan, GiaNhap, SoLuong);
    }
    public void nhapSP(){
        super.nhapSP();
    }
    public void xuatSP(){
        super.xuatSP();
    }
    public String toString(){
       return this.MaSP+","+TenSP+","+GiaBan+","+GiaNhap+","+SoLuong+",Drink";
    }
}
