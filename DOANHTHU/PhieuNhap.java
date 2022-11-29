package DOANHTHU;

import NHANVIEN.*;
import SANPHAM.*;
import java.util.Arrays;

import BASE.date;
import KHACHHANG.DanhSachKhachHang;
import KHACHHANG.KhachHang;

public class PhieuNhap extends Phieu {
    
    public PhieuNhap() {
        id = null;
        n = 0;
        Date = new date();
        sp = new SanPham[n];
        soLuong = new int[n];
    }

    public PhieuNhap(String mpn) {
        id = mpn;
        n = 0;
        Date = new date();
        sp = new SanPham[n];
        soLuong = new int[n];
    }

    public void copyPN(PhieuNhap orther) {
        setId(orther.id);
        setNv(orther.nv);
        setDate(orther.Date);
        for (int i = 0; i < orther.n; i++) {
            addSP(orther.sp[i], orther.soLuong[i]);
        }
    }


    @Override
    public void taoPhieu(NhanVien a, KhachHang b) {
        if (a instanceof Manager) {
            nv = new Manager((Manager) a);
        } else if (a instanceof FullTime) {
            nv = new FullTime((FullTime) a);
        } else if (a instanceof PartTime) {
            nv = new PartTime((PartTime) a);
        }
        Date.Today();

    }

    @Override
    public void addSP(SanPham a, int sl) {
        sp = Arrays.copyOf(sp, n + 1);
        soLuong = Arrays.copyOf(soLuong, n + 1);
        setN(n + 1);
        if (a instanceof Food) {
            sp[n - 1] = new Food((Food) a);
        } else if (a instanceof Drink) {
            sp[n - 1] = new Drink((Drink) a);
        } else if (a instanceof Combo) {
            sp[n - 1] = new Combo((Combo) a);
        }
        soLuong[n - 1] = sl;
    }

    @Override
    public double price() {
        double price = 0;
        for (int i = 0; i < n; i++) {
            price = price + sp[i].getGiaNhap() * soLuong[i];
        }
        return price;
    }

    @Override
    public void inPhieu() {
        System.out.println("+-------------------------------------------------------------------------+");
        System.out.println("|                             PHIEU NHAP HANG                             |");
        System.out.println("+-------------------------------------------------------------------------+");
        System.out.print("|");
        System.out.printf("%-73s", "Ngay: " + Date.toString());
        System.out.println("|");
        System.out.print("|");
        System.out.printf("%-73s", "Ma phieu: " + id);
        System.out.println("|");
        System.out.println("|Thong tin nhan vien thuc hien:                                           |");
        System.out.print("|");
        System.out.printf("%-73s", "Ma nhan vien: " + nv.getMaNV());
        System.out.println("|");
        System.out.print("|");
        System.out.printf("%-73s", "Ten nhan vien: " + nv.getTen());
        System.out.println("|");
        System.out.println("+-------------------------------------------------------------------------+");
        System.out.println("|Chi tiet phieu nhap:                                                     |");
        System.out.println("+----------+------------------------------+----------+--------------------+");
        System.out.print("|");
        System.out.printf("%-10s", "Ma SP");
        System.out.print("|");
        System.out.printf("%-30s", "Ten san pham");
        System.out.print("|");
        System.out.printf("%-10s", "So luong");
        System.out.print("|");
        System.out.printf("%-20s", "Gia tien");
        System.out.println("|");
        for (int i = 0; i < n; i++) {
            if (sp[i] instanceof Combo) {
                Combo a = new Combo((Combo) sp[i]);
                System.out.print("|");
                System.out.printf("%-10s", a.getMaSP());
                System.out.print("|");
                System.out.printf("%-30s", a.getTenSP());
                System.out.print("|");
                System.out.printf("%-10s", soLuong[i]);
                System.out.print("|");
                System.out.printf("%-20s", a.getGiaNhap() * soLuong[i]);
                System.out.println("|");
                for (int j = 0; j < a.getArrSP().length; j++) {
                    System.out.print("|");
                    System.out.printf("%-10s", "");
                    System.out.print("|");
                    System.out.printf("%-30s", a.getArrSP()[j]);
                    System.out.print("|");
                    System.out.printf("%-10s", "");
                    System.out.print("|");
                    System.out.printf("%-20s", "");
                    System.out.println("|");
                }
            } else {
                System.out.print("|");
                System.out.printf("%-10s", sp[i].getMaSP());
                System.out.print("|");
                System.out.printf("%-30s", sp[i].getTenSP());
                System.out.print("|");
                System.out.printf("%-10s", soLuong[i]);
                System.out.print("|");
                System.out.printf("%-20s", sp[i].getGiaNhap() * soLuong[i]);
                System.out.println("|");
            }
        }
        System.out.println("+----------+------------------------------+----------+--------------------+");
        System.out.print("|");
        System.out.printf("%-52s", "Tong tien");
        System.out.print("|");
        System.out.printf("%-20.2f", price());
        System.out.println("|");
        System.out.println("+----------------------------------------------------+--------------------+");

    }

    @Override
    public void TachTT(String pn, DanhSachNhanVien a, DanhSachSanPham b, DanhSachKhachHang c) {
        String[] word = pn.split(",");
        Date.Tachtt(word[0]);
        setId(word[1]);
        if (word[2].indexOf("NVM") == 0) {
            nv = new Manager((Manager) a.SearchNVbyMaNV(word[2]));
        } else if (word[2].indexOf("NVF") == 0) {
            nv = new FullTime((FullTime) a.SearchNVbyMaNV(word[2]));
        } else if (word[2].indexOf("NVP") == 0) {
            nv = new PartTime((PartTime) a.SearchNVbyMaNV(word[2]));
        }
        setN(word.length - 3);
        sp = new SanPham[n];
        soLuong = new int[n];
        for (int i = 3; i < word.length; i++) {
            String[] k = word[i].split("#");
            if (k[0].charAt(0) == 'F') {
                sp[i - 3] = new Food((Food) b.SearchByMaSP(k[0]));
            } else if (k[0].charAt(0) == 'D') {
                sp[i - 3] = new Drink((Drink) b.SearchByMaSP(k[0]));
            } else if (k[0].charAt(0) == 'C') {
                sp[i - 3] = new Combo((Combo) b.SearchByMaSP(k[0]));
            }
            soLuong[i - 3] = Integer.parseInt(k[1]);
        }

    }

    @Override
    public String toString() {
        String s = Date.toString() + "," + id + "," + nv.getMaNV();
        for (int i = 0; i < n; i++) {
            s = s + "," + sp[i].getMaSP() + "#" + soLuong[i];
        }
        return s;
    }

    @Override
    public void xuat() {
        System.out.print("|");
        System.out.printf("%-12s", Date.toString());
        System.out.print("|");
        System.out.printf("%-12s", id);
        System.out.print("|");
        System.out.printf("%-25s", nv.getMaNV());
        System.out.print("|");
        System.out.printf("%-20.2f", price());
        System.out.println("|");
    }

}
