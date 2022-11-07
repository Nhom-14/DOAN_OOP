<<<<<<< HEAD
package DOAN_OOP.SANPHAM;
=======
package SANPHAM;
>>>>>>> d1a60c510ca9fe8cb6a9c063323a9f7664cb019f

public class Food extends SanPham {
    public Food(){
        super();
    }
    public Food(String MaSP,String TenSP,int GiaBan,int GiaNhap,int SoLuong){
        super(MaSP, TenSP, GiaBan, GiaNhap, SoLuong);
    }
    public void nhapSP(){
        super.nhapSP();
    }
    public void xuatSP(){
        super.xuatSP();
    }
    public String toString(){
       return this.MaSP+","+TenSP+","+GiaBan+","+GiaNhap+","+SoLuong+",Food";
    }
}
