package NHANVIEN;

import BASE.*;

public class PartTime extends NhanVien {
    private int GioLam;
    private static int LuongCoBanTheoGio;

    public PartTime() {
        super();
        GioLam = 0;
        loaiNV = "PartTime";
        LuongCoBanTheoGio = 24000;
    }

    public PartTime(String t, date ns, boolean gt, String dc, String sdt, String MaNV, int SoNgayNghi, int GioLam,
            int LuongCoBanTheoGio) {
        super(t, ns, gt, dc, sdt, MaNV, SoNgayNghi);
        this.GioLam = GioLam;
    }

    public PartTime (PartTime orther) {
        super(orther.Ten, orther.NgaySinh, orther.GioiTinh, orther.DiaChi, orther.SDT, orther.MaNV, orther.SoNgayNghi);
        this.GioLam = orther.GioLam;
    }

    public int getLuongCoBanTheoGio() {
        return LuongCoBanTheoGio;
    }

    public void setLuongCoBanTheoGio(int luongCoBanTheoGio) {
        LuongCoBanTheoGio = luongCoBanTheoGio;
    }

    public void setLuongCoBanTheoGio() {
        System.out.print("Nhap luong co ban theo gio: ");
        setLuongCoBanTheoGio(Integer.parseInt(input.nextLine()));
    }

    public int getGioLam() {
        return GioLam;
    }

    public void setGioLam(int gioLam) {
        this.GioLam = gioLam;
    }

    public void setGioLam() {
        System.out.print("Nhap gio lam: ");
        setGioLam(Integer.parseInt(input.nextLine()));
    }

    @Override
    public void setMaNV(String Manv) {
        String ddf = "^P\\d{5}$";
        boolean Inputtrue = false;
        do {
            if (super.checkMaNV(ddf, Manv) == true) {
                Inputtrue = true;
                super.setMaNV(Manv);
            } else {
                System.out.println("Nhap sai moi nhap lai! ");
                System.out.print("Nhap ma nhan vien PartTime(P_____): ");
                Manv = input.nextLine();
            }
        } while (Inputtrue == false);
    }

    @Override
    public void nhapNV() {
        System.out.print("Nhap ma nhan vien PartTime(P_____): ");
        setMaNV(input.nextLine());
        setTen();
        setNgaySinh();
        setGioiTinh();
        setDiaChi();
        setGioLam();
        getTk().setUserName(getMaNV());
        getTk().setPassword();
    }

    public double TinhLuong() {
        return GioLam * LuongCoBanTheoGio - SoNgayNghi;
    }

    @Override
    public String toString() {
        return super.toString() + "," + GioLam + "," + LuongCoBanTheoGio;
    }

    @Override
    public void TachTT(String[] word) {
        setMaNV(word[0]);
        setLoaiNV("FullTime");
        setTen(word[1]);
        date b = new date();
        b.Tachtt(word[2]);
        setNgaySinh(b);
        setGioiTinh(Integer.parseInt(word[3]));
        setDiaChi(word[4]);
        setSDT(word[5]);
        setSoNgayNghi(Integer.parseInt(word[6]));
        setGioLam(Integer.parseInt(word[7]));
        tk.setUserName(word[0]);
        tk.setPassword(word[8]);

    }

}
