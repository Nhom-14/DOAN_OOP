package NHANVIEN;

import BASE.*;

public class PartTime extends NhanVien {
    private int GioLam;
    private static double luongCoBanTheoGio = 0;
    private static double luongCoBanTheoGiodp = 24000;

    public PartTime() {
        super();
        GioLam = 5;
        loaiNV = "PartTime";
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

    public static double getLuongCoBanTheoGio() {
        return luongCoBanTheoGio;
    }

    public static void setLuongCoBanTheoGio(double luongCoBanTheoGio1) {
        luongCoBanTheoGio = luongCoBanTheoGio1;
    }

    public static double getLuongCoBanTheoGiodp() {
        return luongCoBanTheoGiodp;
    }

    public static void setLuongCoBanTheoGio() {
        while (true) {
            System.out.print("Nhap luong co ban theo gio: ");
            luongCoBanTheoGio = error.inputDoubleNumberError(input.nextLine());
            if(luongCoBanTheoGio<0) {
                System.out.println("Khong hop le, moi nhap lai");
            } else {
                break;
            }
            
        }
    }

    public int getGioLam() {
        return GioLam;
    }

    public void setGioLam(int gioLam) {
        this.GioLam = gioLam;
    }

    public void setGioLam() {
        while(true) {
            System.out.print("Nhap gio lam: ");
            GioLam = error.inputIntNumberError(input.nextLine());
            if(GioLam < 4 || GioLam > 6) {
                System.out.println("Khong hop le, moi nhap lai.");
            } else {
                break;
            }
        }
    }

    @Override
    public double TinhLuong() {
        return GioLam * luongCoBanTheoGio * 20 - SoNgayNghi * 96000;
    }

    @Override
    public String toString() {
        return super.toString() + "," + GioLam + "," + tk.getPassword();
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
        setGioLam(Integer.parseInt(word[7]));
        tk.setUserName(word[0]);
        tk.setPassword(word[8]);
    }

    @Override
    public void setWord() {
        setGioLam();
    }

}
