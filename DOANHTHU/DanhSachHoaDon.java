package DOANHTHU;

import java.io.BufferedReader;
import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import BASE.DocGhiFile;
import KHACHHANG.DanhSachKhachHang;
import KHACHHANG.KhachHang;
import NHANVIEN.DanhSachNhanVien;
import NHANVIEN.NhanVien;
import SANPHAM.DanhSachSanPham;

public class DanhSachHoaDon implements DocGhiFile {
    private ArrayList<HoaDon> HDlist;
    private DanhSachSanPham DSSP;
    private DanhSachNhanVien DSNV;
    private DanhSachKhachHang DSKH;
    static Scanner input = new Scanner(System.in);
    private String tenFile = "DOANHTHU/DSHD.txt";

    public DanhSachHoaDon(DanhSachKhachHang a, DanhSachSanPham b, DanhSachNhanVien c) {
        DSKH = new DanhSachKhachHang(a.getKHlist());
        DSSP = new DanhSachSanPham(b.getSp());
        DSNV = new DanhSachNhanVien(c.getNVList());
        HDlist = new ArrayList<HoaDon>();
    }

    public void DocFile() {
        File fhd = new File(tenFile);
        try {
            BufferedReader brhd = Files.newBufferedReader(fhd.toPath());
            String s = null;
            while (true) {
                s = brhd.readLine();
                if (s == null) {
                    break;
                } else {
                    HoaDon a = new HoaDon();
                    a.TachTT(s, DSNV, DSSP, DSKH);
                    HDlist.add(a);
                }
            }
            brhd.close();
        } catch (Exception e) {
            System.out.println("Loi doc file hoa don");
            System.out.println(e.toString());
        }
    }

    public void GhiFile() {
        try {
            PrintWriter pw = new PrintWriter(tenFile);
            for (HoaDon a : HDlist) {
                pw.println(a.toString());
            }
            pw.flush();
            pw.close();
        } catch (Exception e) {
            System.out.println("Loi ghi file hoa don");
            System.out.println(e.toString());
        }
    }

    public void themHoaDon(NhanVien a, KhachHang b, DanhSachSanPham dssp_Main) {
        HoaDon hd = new HoaDon();
        Random rd = new Random();
        String mhd;
        while (true) {
            mhd = "HD" + rd.nextInt(100000);
            if (checkMaHD(mhd)) {
                break;
            }
        }
        hd = new HoaDon(mhd);
        hd.TaoHoaDon(a, b);
        do {
            System.out.print("Ma san pham: ");
            String m = input.nextLine();
            dssp_Main.SearchByMaSP(m).toTable();
            System.out.print("So luong: ");
            int sl = Integer.parseInt(input.nextLine());
            if(sl > dssp_Main.SearchByMaSP(m).getSoLuong()) {
                System.out.println("Khong du so luong, xin thong cam.");
            } else {
                hd.addSP(dssp_Main.SearchByMaSP(m), sl);
                dssp_Main.SearchByMaSP(m).setSoLuong(dssp_Main.SearchByMaSP(m).getSoLuong() - sl);
            }
            System.out.print("Nhan bat ki de tiep tuc, nhan 't' de thoat: ");
        } while (input.nextLine().charAt(0) != 't');
        hd.inHoaDon();
        System.out.print("Nhan bat ki de luu, 'h' de huy hoa don: ");
        if(input.nextLine().charAt(0) != 'h') {
            HDlist.add(hd);
            GhiFile();
            System.out.println("Da luu");
        }
        System.out.print("Nhan phim bat ki de tiep tuc.");
        input.nextLine();
    }

    public boolean checkMaHD(String m) {
        boolean diff = true;
        for (int i = 0; i < HDlist.size(); i++) {
            if (HDlist.get(i).getId().equalsIgnoreCase(m)) {
                diff = false;
                break;
            }
        }
        return diff;
    }

    public void addHoaDon(HoaDon a) {
        HDlist.add(a);
    }

    public HoaDon searchHoaDon(String mpn) {
        int index = -1;
        for (int i = 0; i < HDlist.size(); i++) {
            if (HDlist.get(i).getId().equals(mpn)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return null;
        } else {
            return HDlist.get(index);
        }
    }

    public void xuatHD() {
        System.out.println("");
        System.out.println("+----------------------------------------------------------------------+");
        System.out.println("|                            LICH SU HOA DON                           |");
        System.out.println("+------------+------------+---------------+---------------+------------+");
        System.out.print("|");
        System.out.printf("%-12s", "Ngay thang");
        System.out.print("|");
        System.out.printf("%-12s", "Ma phieu");
        System.out.print("|");
        System.out.printf("%-15s", "Ma nhan vien");
        System.out.print("|");
        System.out.printf("%-15s", "Ma khach hang");
        System.out.print("|");
        System.out.printf("%-12s", "Gia tri");
        System.out.println("|");
        System.out.println("+------------+------------+---------------+---------------+------------+");
        for (HoaDon a : HDlist) {
            System.out.print("|");
            System.out.printf("%-12s", a.getDate().toString());
            System.out.print("|");
            System.out.printf("%-12s", a.getId());
            System.out.print("|");
            if (a.getKh() == null) {
                System.out.printf("%-15s", a.getNv().getMaNV());
                System.out.print("|");
                System.out.printf("%-15s", "null");
                System.out.print("|");
            } else {
                System.out.printf("%-15s", a.getNv().getMaNV());
                System.out.print("|");
                System.out.printf("%-15s", a.getKh().getMaKH());
                System.out.print("|");
            }
            System.out.printf("%-12s", a.priceSale());
            System.out.println("|");
        }
        System.out.println("+------------+------------+---------------+---------------+------------+");
    }

    public void xemHoaDon() {
        xuatHD();
        String mpn;
        do {
            System.out.print("Nhap ma hoa don de xem chi tiet, 't' de thoat: ");
            mpn = input.nextLine();
            if (mpn.charAt(0) != 't') {
                if (searchHoaDon(mpn) != null) {
                    System.out.println("Ket qua: ");
                    searchHoaDon(mpn).inHoaDon();
                    System.out.print("Nhan phim bat ki de tiep tuc, 't' de thoat.");
                    input.nextLine();
                } else {
                    System.out.println("Khong tim thay ket qua.");
                    System.out.print("Nhan phim bat ki de tiep tuc.");
                    input.nextLine();
                }
            }
        } while (mpn.charAt(0) != 't');
    }

}
