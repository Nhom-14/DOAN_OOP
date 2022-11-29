package KHACHHANG;

import BASE.date;
import BASE.error;
import BASE.ConNguoi;

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

    public void Nhap(String mkh) {
        System.out.println("Nhap thong tin khach hang: ");
        setMaKH(mkh);
        super.Nhap();
        Dtinhluy = 0;
    }

    public void setMaKH(String maKH) {
        this.MaKH = maKH;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setDtinhluy(int dtinhluy) {
        Dtinhluy = dtinhluy;
    }

    public void setDtinhluy() {
        while (true) {
            System.out.print("Nhap diem tich luy: ");
            Dtinhluy = error.inputIntNumberError(input.nextLine());
            if(Dtinhluy < 0) {
                System.out.println("Khong hop le, moi nhap lai.");
            } else {
                break;
            }
        }
    }

    public int getDtinhluy() {
        return Dtinhluy;
    }

    public void congDtichluy() {
        Dtinhluy++;
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
