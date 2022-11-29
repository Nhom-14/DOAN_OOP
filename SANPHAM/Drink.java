package SANPHAM;

public class Drink extends SanPham {
    public Drink() {
        super();
        TheLoai = "Drink";
    }

    public Drink(String MaSP, String TenSP, String TheLoai, int GiaBan, int GiaNhap) {
        super(MaSP, TenSP, TheLoai, GiaBan, GiaNhap);
    }

    public Drink(Drink orther) {
        this.MaSP = orther.MaSP;
        this.TenSP = orther.TenSP;
        this.TheLoai = orther.TheLoai;
        this.GiaBan = orther.GiaBan;
        this.GiaNhap = orther.GiaNhap;
    }

    @Override
    public String toString() {
        return MaSP + "," + TenSP + "," + GiaBan + "," + GiaNhap + "," + SoLuong;
    }

    @Override
    public void TachTT(String[] word) {
        setMaSP(word[0]);
        setTheLoai("Drink");
        setTenSP(word[1]);
        setGiaBan(Double.parseDouble(word[2]));
        setGiaNhap(Double.parseDouble(word[3]));
        setSoLuong(Integer.parseInt(word[4]));
    }
}
