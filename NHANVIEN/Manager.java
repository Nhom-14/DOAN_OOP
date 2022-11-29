package NHANVIEN;

import BASE.*;
import java.util.Scanner;

public class Manager extends NhanVien {
    Scanner scn = new Scanner(System.in);
    private int CapBac;
    private static double LuongCoBan = 0;
    private static double LuongCoBandp = 6000000;

    public Manager() {
        super();
        CapBac = 1;
        loaiNV = "Manager";
    }

    public Manager(String t, date ns, boolean gt, String dc, String sdt, String MaNV, int SoNgayNghi, int CapBac) {
        super(t, ns, gt, dc, sdt, MaNV, SoNgayNghi);
        this.CapBac = CapBac;
    }

    public Manager(Manager orther) {
        super(orther.Ten, orther.NgaySinh, orther.GioiTinh, orther.DiaChi, orther.SDT, orther.MaNV, orther.SoNgayNghi);
        this.CapBac = orther.CapBac;
    }

    public int getCapBac() {
        return CapBac;
    }

    public void setCapBac(int capBac) {
        this.CapBac = capBac;
    }

    public void setCapBac() {
        while (true) {
            System.out.print("Nhap cap bac: ");
            CapBac = error.inputIntNumberError(input.nextLine());
            if (CapBac < 0 || CapBac > 3) {
                System.out.println("Khong hop le, moi nhap lai.");
            } else {
                break;
            }
        }
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
            System.out.print("Luong co ban(Manager): ");
            LuongCoBan = error.inputDoubleNumberError(input.nextLine());
            if (LuongCoBan < 0) {
                System.out.println("Khong hop le, moi nhap lai.");
            } else {
                break;
            }
        }
    }

    @Override
    public double TinhLuong() {
        if (getCapBac() == 1) {
            return getLuongCoBan() + 2000000 - SoNgayNghi * LuongCoBan * 0.05;
        } else if (getCapBac() == 2) {
            return getLuongCoBan() + 3000000 - SoNgayNghi * LuongCoBan * 0.05;
        } else {
            return getLuongCoBan() + 4000000 - SoNgayNghi * LuongCoBan * 0.05;
        } 
    }

    @Override
    public String toString() {
        return super.toString() + "," + CapBac + "," + getTk().getPassword();
    }

    @Override
    public void TachTT(String[] word) {
        setMaNV(word[0]);
        setLoaiNV("Manager");
        setTen(word[1]);
        date b = new date();
        b.Tachtt(word[2]);
        setNgaySinh(b);
        setGioiTinh(Integer.parseInt(word[3]));
        setDiaChi(word[4]);
        setSDT(word[5]);
        setSoNgayNghi(Integer.parseInt(word[6]));
        setCapBac(Integer.parseInt(word[7]));
        tk.setUserName(word[0]);
        tk.setPassword(word[8]);
    }

    @Override
    public void setWord() {
        setCapBac();
    }
}
