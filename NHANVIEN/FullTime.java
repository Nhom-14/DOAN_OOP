package NHANVIEN;

import BASE.*;

public class FullTime extends NhanVien {
    private int NgayCong;
    private static int LuongCoBan;

    public FullTime() {
        super();
        NgayCong = 0;
        LuongCoBan = 30000;
    }

    public FullTime(String t, date ns, boolean gt, String dc, String sdt, String MaNV, int SoNgayNghi, int NgayCong) {
        super(t, ns, gt, dc, sdt, MaNV, SoNgayNghi);
        this.NgayCong = NgayCong;
    }

    public FullTime (FullTime orther) {
        super(orther.Ten, orther.NgaySinh, orther.GioiTinh, orther.DiaChi, orther.SDT, orther.MaNV, orther.SoNgayNghi);
        this.NgayCong= orther.NgayCong;
    }

    public int getLuongCoBan() {
        return LuongCoBan;
    }

    public void setLuongCoBan(int luongCoBan) {
        LuongCoBan = luongCoBan;
    }
    public void setLuongCoBan() {
        System.out.println("Nhap luong theo gio: ");
        LuongCoBan = Integer.parseInt(input.nextLine());
    }

    public int getNgayCong() {
        return NgayCong;
    }

    public void setNgayCong(int ngayCong) {
        this.NgayCong = ngayCong;
    }

    public void setNgayCong() {
        System.out.print("Nhap ngay cong: ");
        setNgayCong(Integer.parseInt(input.nextLine()));
    }

    @Override
    public void setMaNV(String Manv) {
        String ddf = "^T\\d{5}$";
        boolean Inputtrue = false;
        do {
            if (super.checkMaNV(ddf, Manv) == true) {
                Inputtrue = true;
                super.setMaNV(Manv);
            } else {
                System.out.println("Nhap sai moi nhap lai! ");
                System.out.print("Nhap ma nhan vien FullTime(T_____): ");
                Manv = input.nextLine();
            }
        } while (Inputtrue == false);
    }

    @Override
    public void nhapNV() {
        System.out.print("Nhap ma nhan vien FullTime(T_____): ");
        setMaNV(input.nextLine());
        setTen();
        setNgaySinh();
        setGioiTinh();
        setDiaChi();
        setNgayCong(NgayCong);
        setLuongCoBan(LuongCoBan);
        getTk().setUserName(getMaNV());
        getTk().getPassword();
    }

    // @Override
    // public void xuatNV() {
    //     super.xuatNV();
    //     System.out.println("\tNgay Cong: " + getNgayCong() + "\tLuong co ban: " + getLuongCoBan());
    // }

    @Override
    public double TinhLuong() {
        return LuongCoBan / 27 * (NgayCong) - SoNgayNghi;
        // Lương phải trả = Mức lương tháng : Số ngày phải đi làm quy định x số ngày đi
        // làm thực tế
    }

    @Override
    public String toString() {
        return super.toString() + ";" + NgayCong + "," + LuongCoBan;
    }

    @Override
    public void TachTT(String[] word) {
        setMaNV(word[0]);
        setLoaiNV("PartTime");
        setTen(word[1]);
        date b = new date();
        b.Tachtt(word[2]);
        setNgaySinh(b);
        setGioiTinh(Integer.parseInt(word[3]));
        setDiaChi(word[4]);
        setSDT(word[5]);
        setSoNgayNghi(Integer.parseInt(word[6]));
        setNgayCong(Integer.parseInt(word[7]));
        tk.setUserName(word[0]);
        tk.setPassword(word[8]);
    }
}
