package DOANHTHU;

import BASE.date;
import KHACHHANG.DanhSachKhachHang;
import KHACHHANG.KhachHang;
import NHANVIEN.DanhSachNhanVien;
import NHANVIEN.NhanVien;
import SANPHAM.DanhSachSanPham;
import SANPHAM.SanPham;

public abstract class Phieu {
    protected String id;
    protected date Date;
    protected NhanVien nv;
    protected int n;
    protected SanPham[] sp;
    protected int[] soLuong;

    public Phieu() {
        id = null;
        Date = new date();
        nv = null;
        n = 0;
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

    public abstract void taoPhieu(NhanVien a, KhachHang b);

    public abstract void addSP(SanPham a, int sl);

    public abstract double price();

    public abstract void inPhieu();

    public abstract void TachTT(String data, DanhSachNhanVien a, DanhSachSanPham b, DanhSachKhachHang c);

    public abstract String toString();

    public abstract void xuat();



}


