package DOANHTHU;

import NHANVIEN.*;
import SANPHAM.*;
import java.util.Arrays;

import BASE.date;

public class PhieuNhap {
    private String id;
    private date Date;
    private NhanVien nv;
    private int n;
    private SanPham[] sp;
    private int[] soLuong;

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

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public void setNv(NhanVien nv) {
        this.nv = nv;
    }

    public NhanVien getNv() {
        return nv;
    }

    public void setSp(SanPham[] sp) {
        this.sp = sp;
    }

    public SanPham[] getSp() {
        return sp;
    }

    public void setSoLuong(int[] soLuong) {
        this.soLuong = soLuong;
    }

    public int[] getSoLuong() {
        return soLuong;
    }

    public void setDate(date date) {
        Date = date;
    }

    public date getDate() {
        return Date;
    }

    public void TaoPhieuNhap(NhanVien a) {
        if (a instanceof Manager) {
            nv = new Manager((Manager) a);
        } else if (a instanceof FullTime) {
            nv = new FullTime((FullTime) a);
        } else if (a instanceof PartTime) {
            nv = new PartTime((PartTime) a);
        }
        Date.Today();

    }

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

    public double price() {
        double price = 0;
        for (int i = 0; i < n; i++) {
            price = price + sp[i].getGiaNhap() * soLuong[i];
        }
        return price;
    }

    public void inPhieuNhap() {
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
        System.out.println("+----------+------------------------------+----------+--------------------+");
        System.out.print("|");
        System.out.printf("%-52s", "Tong tien");
        System.out.print("|");
        System.out.printf("%-20s", price());
        System.out.println("|");
        System.out.println("+----------------------------------------------------+--------------------+");
        
    }

    public void TachTT(String pn, DanhSachNhanVien a, DanhSachSanPham b) {
        String[] word = pn.split(",");
        Date.Tachtt(word[0]);
        setId(word[1]);
        if (word[2].charAt(0) == 'M') {
            nv = new Manager((Manager) a.SearchNVbyMaNV(word[2]));
        } else if (word[2].charAt(0) == 'T') {
            nv = new FullTime((FullTime) a.SearchNVbyMaNV(word[2]));
        } else if (word[2].charAt(0) == 'P') {
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

    public String toString() {
        String s = Date.toString() + "," + id + "," + nv.getMaNV();
        for (int i = 0; i < n; i++) {
            s = s + "," + sp[i].getMaSP() + "#" + soLuong[i];
        }
        return s;
    }

}
