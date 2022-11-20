package NHANVIEN;

import BASE.*;
import java.util.Scanner;

public class Manager extends NhanVien {
    Scanner scn = new Scanner(System.in);
    private int CapBac;
    private static int LuongCoBan;

    public Manager() {
        super();
        CapBac = 0;
        LuongCoBan = 60000;
    }

    public Manager(String t, date ns, boolean gt, String dc, String sdt, String MaNV, int SoNgayNghi, int CapBac,
            int LuongCoBan) {
        super(t, ns, gt, dc, sdt, MaNV, SoNgayNghi);
        this.CapBac = CapBac;
    }

    public Manager (Manager orther) {
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
        System.out.print("Nhap cap bac: ");
        setCapBac(Integer.parseInt(input.nextLine()));
    }

    public int getLuongCoBan() {
        return LuongCoBan;
    }

    public void setLuongCoBan(int luongCoBan) {
        LuongCoBan = luongCoBan;
    }

    public void setLuongCoBan() {
        System.out.print("Luong co ban: ");
        setLuongCoBan(Integer.parseInt(input.nextLine()));
    }

    @Override
    public void setMaNV(String Manv) {
        String ddf = "^M\\d{5}$";
        boolean Inputtrue = false;
        do {
            if (super.checkMaNV(ddf, Manv) == true) {
                Inputtrue = true;
                super.setMaNV(Manv);
            } else {
                System.out.println("Nhap sai moi nhap lai! ");
                System.out.print("Nhap ma Manager(M_____): ");
                Manv = input.nextLine();
            }
        } while (Inputtrue == false);
    }

    @Override
    public void nhapNV() {
        System.out.print("Nhap ma Manager(M_____): ");
        setMaNV(input.nextLine());
        setTen();
        setNgaySinh();
        setGioiTinh();
        setDiaChi();
        setCapBac(CapBac);
        getTk().setUserName(getMaNV());
        getTk().setPassword();
    }

    // @Override
    // public void xuatNV() {
    //     super.xuatNV();
    //     System.out.println("\tCapBac: " + getCapBac() + "\tLuong co ban: " + getLuongCoBan());
    // }

    @Override
    public double TinhLuong() {
        if (getCapBac() == 1) {
            return getLuongCoBan() * 1.5 - SoNgayNghi;
        } else if (getCapBac() == 2) {
            return getLuongCoBan() * 2 - SoNgayNghi;
        } else if (getCapBac() == 3) {
            return getLuongCoBan() * 3 - SoNgayNghi;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return super.toString() + ";" + CapBac + "," + LuongCoBan;
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
}
