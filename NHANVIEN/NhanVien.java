package NHANVIEN;

import BASE.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class NhanVien extends ConNguoi {
    protected String MaNV;
    protected String loaiNV;
    protected int SoNgayNghi;
    protected Account tk;

    public NhanVien() {
        super();
        MaNV = null;
        loaiNV = null;
        SoNgayNghi = 0;
        tk = new Account();
    }

    public NhanVien(String t, date ns, boolean gt, String dc, String sdt, String MaNV, int SoNgayNghi) {
        super(t, ns, gt, dc, sdt);
        this.MaNV = MaNV;
        this.SoNgayNghi = SoNgayNghi;
    }

    public NhanVien(NhanVien orther) {
        super(orther.Ten, orther.NgaySinh, orther.GioiTinh, orther.DiaChi, orther.SDT);
        this.MaNV = orther.MaNV;
        this.SoNgayNghi = orther.SoNgayNghi;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String maNV) {
        this.MaNV = maNV;
    }

    public void setMaNV() {
        System.out.println("Nhap ma nhan vien: ");
        setMaNV(input.nextLine());
    }

    public void setTk(Account tk) {
        this.tk = tk;
    }

    public Account getTk() {
        return tk;
    }

    public void setLoaiNV(String loaiNV) {
        this.loaiNV = loaiNV;
    }

    public String getLoaiNV() {
        return loaiNV;
    }

    public int getSoNgayNghi() {
        return SoNgayNghi;
    }

    public void setSoNgayNghi(int SoNgayNghi) {
        this.SoNgayNghi = SoNgayNghi;
    }

    public void setSoNgayNghi() {
        while (true) {
            System.out.println("Nhap so ngay nghi: ");
            SoNgayNghi = error.inputIntNumberError(input.nextLine());
            if (SoNgayNghi < 0) {
                System.out.println("Khong hop le, moi nhap lai");
            } else {
                break;
            }
        }
    }

    public boolean checkMaNV(String format, String dt) {
        Pattern pattern = Pattern.compile(format);
        Matcher matcher;
        matcher = pattern.matcher(dt);
        if (matcher.find()) {
            return true;
        } else {
            return false;
        }
    }

    public void xuatNV() {
        System.out.print("|");
        System.out.printf("%-8s", MaNV);
        System.out.print("|");
        System.out.printf("%-12s", loaiNV);
        System.out.print("|");
        System.out.printf("%-30s", Ten);
        System.out.print("|");
        System.out.printf("%-12s", getNgaySinh().toString());
        System.out.print("|");
        System.out.printf("%-40s", DiaChi);
        System.out.print("|");
        System.out.printf("%-12s", SDT);
        System.out.println("|");
        System.out.println(
                "+--------+------------+------------------------------+------------+----------------------------------------+------------+");
    }

    public static void Title() {
        System.out.println(
                "+--------+------------+------------------------------+------------+----------------------------------------+------------+");
        System.out.print("|");
        System.out.printf("%-8s", "Ma NV");
        System.out.print("|");
        System.out.printf("%-12s", "Chuc vu");
        System.out.print("|");
        System.out.printf("%-30s", "Ten nhan vien");
        System.out.print("|");
        System.out.printf("%-12s", "Ngay sinh");
        System.out.print("|");
        System.out.printf("%-40s", "Dia chi");
        System.out.print("|");
        System.out.printf("%-12s", "SDT");
        System.out.println("|");
        System.out.println(
                "+--------+------------+------------------------------+------------+----------------------------------------+------------+");
    }

    public void xuatLuong() {
        System.out.print("|");
        System.out.printf("%-8s", MaNV);
        System.out.print("|");
        System.out.printf("%-15s", loaiNV);
        System.out.print("|");
        System.out.printf("%-35s", Ten);
        System.out.print("|");
        System.out.printf("%-10s", SoNgayNghi);
        System.out.print("|");
        System.out.printf("%20.2f", TinhLuong());
        System.out.println("|");
    }

    public void toTable() {
        Title();
        xuatNV();
    }

    public String toString() {
        String gt;
        if (GioiTinh == true) {
            gt = "1";
        } else {
            gt = "0";
        }
        return MaNV + "," + Ten + "," + NgaySinh + "," + gt + "," + DiaChi + "," + SDT + "," + SoNgayNghi;
    }

    public void nhapNV(String mnv) {
        System.out.println("Nhap thong tin nhan vien: ");
        setMaNV(mnv);
        super.Nhap();
        getTk().setUserName(getMaNV());
        getTk().setPassword();
    }

    public abstract double TinhLuong();

    public abstract void TachTT(String[] word);

    public abstract void setWord();
}
