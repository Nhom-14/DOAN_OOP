package KHACHHANG;

import BASE.date;
import BASE.ConNguoi;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KhachHang extends ConNguoi {
    private String MaKH;
    private int Dtinhluy;

    public KhachHang() {
        super();
        MaKH = null;
        Dtinhluy = 0;
    }

    public KhachHang(KhachHang orther) {
        this.Ten = orther.Ten;
        this.NgaySinh = new date(orther.NgaySinh);
        this.GioiTinh = orther.GioiTinh;
        this.SDT = orther.SDT;
        this.MaKH = orther.MaKH;
        this.Dtinhluy = orther.Dtinhluy;
    }

    public void Nhap() {
        setMaKH();
        super.Nhap();
        Dtinhluy = 0;
    }

    public void setMaKH(String maKH) {
        this.MaKH = maKH;
    }
    public void setMaKH() {
        String ddmkh = "^\\d{3}$";
        boolean check = false;
        do {
            System.out.print("Nhap ma khach hang(3 chu so): ");
            String mkh = input.nextLine();
            Pattern pattern = Pattern.compile(ddmkh);
            Matcher matcher;
            matcher = pattern.matcher(mkh);
            if (matcher.find()) {
                check = true;
                setMaKH(mkh);
            } else {
                System.out.println("Khong hop le, hay nhap lai.");
            }
        } while (check == false);
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setDtinhluy(int dtinhluy) {
        Dtinhluy = dtinhluy;
    }
    public void setDtinhluy() {
        System.out.print("Nhap diem tich luy: ");
        setDtinhluy(Integer.parseInt(input.nextLine()));
    }

    public int getDtinhluy() {
        return Dtinhluy;
    }

    public void congDtichluy() {
        Dtinhluy++;
    }

    public double GiamGia() {
        if (Dtinhluy < 20) {
            return 0;
        } else {
            if (Dtinhluy > 50) {
                return 0.5;
            } else {
                float a = Dtinhluy;
                return a / 100;
            }
        }
    }

    public static void Titile() {
        System.out.println(
                "+----------+------------------------------+------------+----------------------------------------+------------+---------------+");
        System.out.print("|");
        System.out.printf("%-10s", "Ma TV");
        System.out.print("|");
        System.out.printf("%-30s", "Ten thanh vien");
        System.out.print("|");
        System.out.printf("%-12s", "Ngay sinh");
        System.out.print("|");
        System.out.printf("%-40s", "Dia chi");
        System.out.print("|");
        System.out.printf("%-12s", "SDT");
        System.out.print("|");
        System.out.printf("%-15s", "Diem tich luy");
        System.out.println("|");
        System.out.println(
                "+----------+------------------------------+------------+----------------------------------------+------------+---------------+");

    }

    public void xuatKH() {
        System.out.print("|");
        System.out.printf("%-10s", MaKH);
        System.out.print("|");
        System.out.printf("%-30s", Ten);
        System.out.print("|");
        System.out.printf("%-12s", getNgaySinh().toString());
        System.out.print("|");
        System.out.printf("%-40s", DiaChi);
        System.out.print("|");
        System.out.printf("%-12s", SDT);
        System.out.print("|");
        System.out.printf("%-15s", Dtinhluy);
        System.out.println("|");
    }

    public void ToTable() {
        Titile();
        xuatKH();
        System.out.println(
                "+----------+------------------------------+------------+----------------------------------------+------------+---------------+");
    }

    public String toString() {
        return MaKH + "," + getTen() + "," + getNgaySinh().toString() + "," + getDiaChi() + "," + getSDT() + ","
                + Dtinhluy;
    }

}
