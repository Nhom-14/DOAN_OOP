package DOANHTHU;

import java.io.BufferedReader;
import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import BASE.DocGhiFile;
import NHANVIEN.DanhSachNhanVien;
import NHANVIEN.NhanVien;
import SANPHAM.DanhSachSanPham;

public class DanhSachPhieuNhap implements DocGhiFile {
    private ArrayList<PhieuNhap> PNlist;
    private DanhSachSanPham DSSP;
    private DanhSachNhanVien DSNV;
    static Scanner input = new Scanner(System.in);
    private String tenFile = "DOANHTHU/DSPN.txt";

    public DanhSachPhieuNhap(DanhSachSanPham b, DanhSachNhanVien c) {
        DSSP = new DanhSachSanPham(b.getSp());
        DSNV = new DanhSachNhanVien(c.getNVList());
        PNlist = new ArrayList<PhieuNhap>();
    }

    public void setPNlist(ArrayList<PhieuNhap> pNlist) {
        PNlist = pNlist;
    }

    public ArrayList<PhieuNhap> getPNlist() {
        return PNlist;
    }

    public void DocFile() {
        File fpn = new File(tenFile);
        try {
            BufferedReader brpn = Files.newBufferedReader(fpn.toPath());
            String s = null;
            while (true) {
                s = brpn.readLine();
                if (s == null) {
                    break;
                } else {
                    PhieuNhap a = new PhieuNhap();
                    a.TachTT(s, DSNV, DSSP);
                    PNlist.add(a);
                }
            }
            brpn.close();
        } catch (Exception e) {
            System.out.println("Loi doc file phieu nhap");
            System.out.println(e.toString());
        }
    }

    public void GhiFile() {
        try {
            PrintWriter pw = new PrintWriter(tenFile);
            for (PhieuNhap a : PNlist) {
                pw.println(a.toString());
            }
            pw.flush();
            pw.close();
        } catch (Exception e) {
            System.out.println("Loi ghi file phieu nhap");
            System.out.println(e.toString());
        }
    }

    public void themPhieuNhap(NhanVien a, DanhSachSanPham dssp_Main) {
        PhieuNhap pn = new PhieuNhap();
        Random rd = new Random();
        String mpn;
        while (true) {
            mpn = "PN" + rd.nextInt(10000);
            if (checkMaPN(mpn)) {
                break;
            }
        }
        pn = new PhieuNhap(mpn);
        pn.TaoPhieuNhap(a);
        do {
            System.out.print("Ma san pham muon nhap them: ");
            String m = input.nextLine();
            dssp_Main.SearchByMaSP(m).toTable();
            System.out.print("So luong muon nhap them la: ");
            int sl = Integer.parseInt(input.nextLine());
            dssp_Main.SearchByMaSP(m).setSoLuong(dssp_Main.SearchByMaSP(m).getSoLuong() + sl);
            pn.addSP(DSSP.SearchByMaSP(m), sl);
            System.out.print("Nhan bat ki de tiep tuc, nhan 't' de thoat: ");
        } while (input.nextLine().charAt(0) != 't');
        pn.inPhieuNhap();
        System.out.print("Nhan bat ki de luu, 'h' de huy phieu nhap: ");
        if(input.nextLine().charAt(0) != 'h') {
            PNlist.add(pn);
            GhiFile();
            System.out.println("Da luu");
        }
        System.out.print("Nhan phim bat ki de tiep tuc.");
        input.nextLine();
    }

    public boolean checkMaPN(String m) {
        boolean diff = true;
        for (int i = 0; i < PNlist.size(); i++) {
            if (PNlist.get(i).getId().equalsIgnoreCase(m)) {
                diff = false;
                break;
            }
        }
        return diff;
    }

    public PhieuNhap searchPhieuNhap(String mpn) {
        int index = -1;
        for (int i = 0; i < PNlist.size(); i++) {
            if (PNlist.get(i).getId().equals(mpn)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return null;
        } else {
            return PNlist.get(index);
        }
    }

    public void xuatPN() {
        System.out.println("");
        System.out.println("+------------------------------------------------------+");
        System.out.println("|                   LICH SU NHAP HANG                  |");
        System.out.println("+------------+------------+---------------+------------+");
        System.out.print("|");
        System.out.printf("%-12s", "Ngay thang");
        System.out.print("|");
        System.out.printf("%-12s", "Ma phieu");
        System.out.print("|");
        System.out.printf("%-15s", "Nhan vien thuc hien");
        System.out.print("|");
        System.out.printf("%-12s", "Gia tri");
        System.out.println("|");
        System.out.println("+------------+------------+---------------+------------+");
        for (PhieuNhap a : PNlist) {
            System.out.print("|");
            System.out.printf("%-12s", a.getDate().toString());
            System.out.print("|");
            System.out.printf("%-12s", a.getId());
            System.out.print("|");
            System.out.printf("%-15s", a.getNv().getMaNV());
            System.out.print("|");
            System.out.printf("%-12s", a.price());
            System.out.println("|");
        }
        System.out.println("+------------+------------+---------------+------------+");
    }

    public void xemPhieuNhap() {
        xuatPN();
        String mpn;
        do {
            System.out.print("Nhap ma phieu de xem chi tiet, 't' de thoat: ");
            mpn = input.nextLine();
            if (mpn.charAt(0) != 't') {
                if (searchPhieuNhap(mpn) != null) {
                    System.out.println("Ket qua: ");
                    searchPhieuNhap(mpn).inPhieuNhap();
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
// ngaythang maphieu hotennv tonggia
// 12 12 30 12
