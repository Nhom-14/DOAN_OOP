package DOANHTHU;

import KHACHHANG.*;
import NHANVIEN.*;
import SANPHAM.*;
import java.util.Arrays;

import BASE.date;

public class HoaDon extends Phieu {
   
    private KhachHang kh;

    public HoaDon() {
        id = null;
        n = 0;
        Date = new date();
        sp = new SanPham[n];
        soLuong = new int[n];
    }

    public HoaDon(String mhd) {
        id = mhd;
        n = 0;
        Date = new date();
        sp = new SanPham[n];
        soLuong = new int[n];
    }

    public void copyHD(HoaDon orther) {
        setId(orther.id);
        setNv(orther.nv);
        setKh(orther.kh);
        setDate(orther.Date);
        for(int i=0;i<orther.n;i++) {
            addSP(orther.sp[i], orther.soLuong[i]);
        }
    }

    public void setKh(KhachHang kh) {
        this.kh = kh;
    }

    public KhachHang getKh() {
        return kh;
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
        if (b != null) {
            kh = new KhachHang(b);
        } else {
            kh = null;
        }
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
            price = price + sp[i].getGiaBan() * soLuong[i];
        }
        if (kh == null) {
            return price;
        } else {
            if (kh.getDtinhluy() < 20) {
                return price;
            } else {
                return price - price * 0.2;
            }
        }
    }

    @Override
    public void inPhieu() {
        System.out.println("+-------------------------------------------------------------------------+");
        System.out.println("|                                 HOA DON                                 |");
        System.out.println("+-------------------------------------------------------------------------+");
        System.out.print("|");
        System.out.printf("%-73s", "Ngay: " + Date.toString());
        System.out.println("|");
        System.out.print("|");
        System.out.printf("%-73s", "Ma phieu: " + id);
        System.out.println("|");
        System.out.println("|Thong tin nhan vien thuc hien:                                           |");
        if(nv == null) {
            System.out.print("|");
            System.out.printf("%-73s", "Ma nhan vien: ");
            System.out.println("|");
            System.out.print("|");
            System.out.printf("%-73s", "Ten nhan vien: ");
            System.out.println("|");
        } else {
            System.out.print("|");
            System.out.printf("%-73s", "Ma nhan vien: " + nv.getMaNV());
            System.out.println("|");
            System.out.print("|");
            System.out.printf("%-73s", "Ten nhan vien: " + nv.getTen());
            System.out.println("|");
        }
        if (kh != null) {
            System.out.println("+-------------------------------------------------------------------------+");
            System.out.println("|Thong tin khach hang:                                                    |");
            System.out.print("|");
            System.out.printf("%-73s", "Ma khach hang: " + kh.getMaKH());
            System.out.println("|");
            System.out.print("|");
            System.out.printf("%-73s", "Ten khach hang: " + kh.getTen());
            System.out.println("|");
            System.out.print("|");
            System.out.printf("%-73s", "So dien thoai: " + kh.getSDT());
            System.out.println("|");
            System.out.print("|");
            System.out.printf("%-73s", "Diem tich luy: " + kh.getDtinhluy());
            System.out.println("|");
        }
        System.out.println("+-------------------------------------------------------------------------+");
        System.out.println("|Chi tiet hoa don:                                                        |");
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
                System.out.printf("%-10s", sp[i].getMaSP());
                System.out.print("|");
                System.out.printf("%-30s", sp[i].getTenSP());
                System.out.print("|");
                System.out.printf("%-10s", soLuong[i]);
                System.out.print("|");
                System.out.printf("%-20.2f", sp[i].getGiaBan() * soLuong[i]);
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
                System.out.printf("%-20s", sp[i].getGiaBan() * soLuong[i]);
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
    public void TachTT(String hd, DanhSachNhanVien a, DanhSachSanPham b, DanhSachKhachHang c) {
        String[] word = hd.split(",");
        Date.Tachtt(word[0]);
        setId(word[1]);
        if(a.SearchNVbyMaNV(word[2]) != null) {
            if (word[2].indexOf("NVM") == 0) {
                nv = new Manager((Manager) a.SearchNVbyMaNV(word[2]));
            } else if (word[2].indexOf("NVF") == 0) {
                nv = new FullTime((FullTime) a.SearchNVbyMaNV(word[2]));
            } else if (word[2].indexOf("NVP") == 0) {
                nv = new PartTime((PartTime) a.SearchNVbyMaNV(word[2]));
            }
        } else {
            nv = null;
        }
        if (c.SearchKH(word[3])== null) {
            kh = null;
        } else {
            kh = new KhachHang(c.SearchKH(word[3]));
        }
        setN(word.length - 4);
        sp = new SanPham[n];
        soLuong = new int[n];
        int j = 4;
        int i = 0;
        while (j < word.length) {
            String[] k = word[j].split("#");
            if(b.SearchByMaSP(k[0])!=null) {
                if (k[0].charAt(0) == 'F') {
                    sp[i] = new Food((Food) b.SearchByMaSP(k[0]));
                } else if (k[0].charAt(0) == 'D') {
                    sp[i] = new Drink((Drink) b.SearchByMaSP(k[0]));
                } else if (k[0].charAt(0) == 'C') {
                    sp[i] = new Combo((Combo) b.SearchByMaSP(k[0]));
                }
                soLuong[i] = Integer.parseInt(k[1]);
                i++;
            } 
            j++;
        }
        setN(i);
    }

    @Override
    public String toString() {
        String s;
        if(nv != null) {
            s = Date.toString() + "," + id + "," + nv.getMaNV();
        } else {
            s = Date.toString() + "," + id + "," + "null";
        }
        if (kh != null) {
            s = s + "," + kh.getMaKH();
        } else {
            s = s + "," + "null";
        }
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
        if(nv == null) {
            System.out.printf("%-15s", "null");
        } else {
            System.out.printf("%-15s", nv.getMaNV());
        }
        System.out.print("|");
        if (kh == null) {
            System.out.printf("%-15s", "null");
            System.out.print("|");
        } else {
            System.out.printf("%-15s", kh.getMaKH());
            System.out.print("|");
        }
        System.out.printf("%-20.2f", price());
        System.out.println("|");
    }
}
