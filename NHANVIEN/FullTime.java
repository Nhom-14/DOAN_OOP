package NHANVIEN;

import BASE.*;

public class FullTime extends NhanVien {
    private int NgayCong;
    private static double LuongCoBan = 0;
    private static double LuongCoBandp = 6000000;

    public FullTime() {
        super();
        NgayCong = 27;
    }

    public FullTime(String t, date ns, boolean gt, String dc, String sdt, String MaNV, int SoNgayNghi, int NgayCong) {
        super(t, ns, gt, dc, sdt, MaNV, SoNgayNghi);
        this.NgayCong = NgayCong;
    }

    public FullTime (FullTime orther) {
        super(orther.Ten, orther.NgaySinh, orther.GioiTinh, orther.DiaChi, orther.SDT, orther.MaNV, orther.SoNgayNghi);
        this.NgayCong= orther.NgayCong;
    }

    public static double getLuongCoBan() {
        return LuongCoBan;
    }

    public static void setLuongCoBan(double luongCoBan) {
        LuongCoBan = luongCoBan;
    }

    public static double getLuongCoBandp() {
        return LuongCoBandp;
    }

    public static void setLuongCoBan() {
        while (true) {
            System.out.println("Nhap luong co ban: ");
            LuongCoBan = error.inputDoubleNumberError(input.nextLine());
            if(LuongCoBan < 0) {
                System.out.println("Khong hop le, moi nhap lai.");
            } else {
                break;
            }
        }
    }

    public int getNgayCong() {
        return NgayCong;
    }

    public void setNgayCong(int ngayCong) {
        this.NgayCong = ngayCong;
    }

    public void setNgayCong() {
        while (true) {
            System.out.print("Nhap ngay cong: ");
            NgayCong = error.inputIntNumberError(input.nextLine());
            if(NgayCong < 20 || NgayCong > 30){
                System.out.println("Khong hop le, moi nhap lai");
            } else {
                break;
            }   
        }
    }

    @Override
    public double TinhLuong() {
        return LuongCoBan * (NgayCong - SoNgayNghi)/27;
        // Lương phải trả = Mức lương tháng : Số ngày phải đi làm quy định x số ngày đi
        // làm thực tế
    }

    @Override
    public String toString() {
        return super.toString() + "," + NgayCong + "," + getTk().getPassword();
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
        setNgayCong(Integer.parseInt(word[7]));
        tk.setUserName(word[0]);
        tk.setPassword(word[8]);
    }

    @Override
    public void setWord() {
        setNgayCong();
    }
}
