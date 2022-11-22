package SANPHAM;

public class Food extends SanPham {
    public Food() {
        super();
        TheLoai = "Food";
    }

    public Food(String MaSP, String TenSP, String TheLoai, int GiaBan, int GiaNhap,int SoLuong) {
        super(MaSP, TenSP, TheLoai, GiaBan, GiaNhap, SoLuong);
    }

    public Food(Food orther) {
        this.MaSP = orther.MaSP;
        this.TenSP = orther.TenSP;
        this.TheLoai = orther.TheLoai;
        this.GiaBan = orther.GiaBan;
        this.GiaNhap = orther.GiaNhap;
        this.SoLuong = orther.SoLuong;
    }

    @Override
    public void nhapSP() {
        System.out.print("Nhap ma mon an(F___): ");
        setMaSP(input.nextLine());
        setTenSP();
        setGiaBan();
        setGiaNhap();
    }

    @Override
    public void setMaSP(String Masp) {
        String ddf = "^F\\d{3}$";
        boolean Inputtrue = false;
        do {
            if (super.checkMasp(ddf, Masp) == true) {
                Inputtrue = true;
                super.setMaSP(Masp);
            } else {
                System.out.println("Nhap sai moi nhap lai! ");
                System.out.print("Nhap ma san pham(Food:F___,Drink:D___,Combo:C___): ");
                Masp = input.nextLine();
            }
        } while (Inputtrue == false);
    }

    @Override
    public String toString() {
        return MaSP + "," + TenSP + "," + GiaBan + "," + GiaNhap + "," + SoLuong;
    }

    @Override
    public void TachTT(String[] word) {
        setMaSP(word[0]);
        setTheLoai("Food");
        setTenSP(word[1]);
        setGiaBan(Double.parseDouble(word[2]));
        setGiaNhap(Double.parseDouble(word[3]));
        setSoLuong(Integer.parseInt(word[4]));
    }

}
