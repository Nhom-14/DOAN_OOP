package SANPHAM;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class SanPham {
    protected String MaSP;
    protected String TenSP;
    protected String TheLoai;
    protected double GiaBan;
    protected double GiaNhap;
    protected int SoLuong;
    static Scanner input = new Scanner(System.in);

    public SanPham() {
        this.MaSP = "";
        this.TenSP = "";
        this.TheLoai = "";
        this.GiaBan = 0;
        this.GiaNhap = 0;
        this.SoLuong = 50;
    }

    public SanPham(String MaSP, String TenSP, String TheLoai, double GiaBan, double GiaNhap) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.TheLoai = TheLoai;
        this.GiaBan = GiaBan;
        this.GiaNhap = GiaNhap;
        this.SoLuong = 50;
    }

    public SanPham(SanPham orther) {
        this.MaSP = orther.MaSP;
        this.TenSP = orther.TenSP;
        this.TheLoai = orther.TheLoai;
        this.GiaBan = orther.GiaBan;
        this.GiaNhap = orther.GiaNhap;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String Masp) {
        this.MaSP = Masp;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String Tensp) {
        this.TenSP = Tensp;
    }

    public void setTenSP() {
        System.out.print("Nhap ten san pham: ");
        TenSP = input.nextLine();
    }

    public void setTheLoai(String theLoai) {
        TheLoai = theLoai;
    }

    public String getTheLoai() {
        return TheLoai;
    }

    public double getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(double Giaban) {
        this.GiaBan = Giaban;
    }

    public void setGiaBan() {
        System.out.print("Nhap gia ban: ");
        GiaBan = Double.parseDouble(input.nextLine());
    }

    public double getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(double Gianhap) {
        this.GiaNhap = Gianhap;
    }

    public void setGiaNhap() {
        System.out.print("Nhap gia nhap: ");
        GiaNhap = Double.parseDouble(input.nextLine());
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int Soluong) {
        this.SoLuong = Soluong;
    }

    public abstract void nhapSP();

    public boolean checkMasp(String format, String dt) {
        Pattern pattern = Pattern.compile(format);
        Matcher matcher;
        matcher = pattern.matcher(dt);
        if (matcher.find()) {
            return true;
        } else {
            return false;
        }
    }

    public abstract void TachTT(String[] word);

    public void xuatSP() {
        System.out.print("|");
        System.out.printf("%-8s", MaSP);
        System.out.print("|");
        System.out.printf("%-10s", TheLoai);
        System.out.print("|");
        System.out.printf("%-30s", TenSP);
        System.out.print("|");
        System.out.printf("%-10s", GiaBan);
        System.out.print("|");
        System.out.printf("%-10s", GiaNhap);
        System.out.print("|");
        System.out.printf("%-10s", SoLuong);
        System.out.print("|\n");
    }

    public static void Title() {
        System.out.println("+--------+----------+------------------------------+----------+----------+----------+");
        System.out.print("|");
        System.out.printf("%-8s", "Ma SP");
        System.out.print("|");
        System.out.printf("%-10s", "The loai");
        System.out.print("|");
        System.out.printf("%-30s", "Ten SP");
        System.out.print("|");
        System.out.printf("%-10s", "Gia ban");
        System.out.print("|");
        System.out.printf("%-10s", "Gia nhap");
        System.out.print("|");
        System.out.printf("%-10s", "So luong");
        System.out.print("|\n");
        System.out.println("+--------+----------+------------------------------+----------+----------+----------+");
    }

    public void xuatMenu() {
        System.out.print("|");
        System.out.printf("%-8s", MaSP);
        System.out.printf("%-30s", TenSP);
        System.out.printf("%10s", GiaBan);
        System.out.printf("%10s", SoLuong);
        System.out.println("|");
        System.out.println("+----------------------------------------------------------+");
    }


    public void toTable() {
        Title();
        xuatSP();
        System.out.println("+--------+----------+------------------------------+----------+----------+----------+");
    }

    public String toString() {
        return MaSP + "[" + TenSP + "," + TheLoai + "," + GiaBan + "," + GiaNhap + "," + SoLuong + "]";
    }
}