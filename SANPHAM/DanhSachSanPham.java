package SANPHAM;

import java.io.BufferedReader;
import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

import BASE.*;
import DOANHTHU.DanhSachHoaDon;
import DOANHTHU.DanhSachPhieuNhap;
import KHACHHANG.KhachHang;
import NHANVIEN.NhanVien;

public class DanhSachSanPham implements DocGhiFile {
    private ArrayList<SanPham> sp;
    static Scanner input = new Scanner(System.in);
    private String tenFILE = "SANPHAM/DSSP.txt";

    public DanhSachSanPham() {
        sp = new ArrayList<SanPham>();
    }

    public DanhSachSanPham(ArrayList<SanPham> sp) {
        this.sp = sp;
    }

    public ArrayList<SanPham> getSp() {
        return sp;
    }

    @Override
    public void DocFile() {
        File fsp = new File(tenFILE);
        try {
            BufferedReader brsp = Files.newBufferedReader(fsp.toPath());
            String s = null;
            while (true) {
                s = brsp.readLine();
                if (s == null) {
                    break;
                } else {
                    String[] word = s.split(",");
                    if (word[0].charAt(0) == 'F') {
                        SanPham a = new Food();
                        a.TachTT(word);
                        sp.add(a);
                    } else if (word[0].charAt(0) == 'D') {
                        SanPham a = new Drink();
                        a.TachTT(word);
                        sp.add(a);
                    } else if (word[0].charAt(0) == 'C') {
                        SanPham a = new Combo();
                        a.TachTT(word);
                        sp.add(a);
                    }
                }
            }
            brsp.close();

        } catch (Exception e) {
            System.out.println("Loi doc File danh sach san pham: ");
            System.out.println(e.toString());
        }

    }

    @Override
    public void GhiFile() {
        try {
            PrintWriter pw = new PrintWriter(tenFILE);
            for (int i = 0; i < sp.size(); i++) {
                pw.println(sp.get(i).toString());
            }
            pw.flush();
            pw.close();
        } catch (Exception e) {
            System.out.println("Loi ghi File danh sach san pham: " + e.toString());
        }
    }

    public void XuatSP() {
        System.out.println("+-----------------------------------------------------------------------------------+");
        System.out.println("|                                 DANH SACH SAN PHAM                                |");
        SanPham.Title();
        for (int i = 0; i < sp.size(); i++) {
            if (sp.get(i).getMaSP().charAt(0) == 'F') {
                sp.get(i).xuatSP();
            }
        }
        for (int i = 0; i < sp.size(); i++) {
            if (sp.get(i).getMaSP().charAt(0) == 'D') {
                sp.get(i).xuatSP();
            }
        }
        for (int i = 0; i < sp.size(); i++) {
            if (sp.get(i).getMaSP().charAt(0) == 'C') {
                Combo a = (Combo) sp.get(i);
                a.xuatSP();
            }
        }
        System.out.println("+--------+----------+------------------------------+----------+----------+----------+");

    }

    public void ThemSP() {
        do {
            System.out.print("Loai san pham(1:Food,2:Drink,3:Combo): ");
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1: {
                    SanPham a = new Food();
                    a.nhapSP();
                    if (check(a.getMaSP())) {
                        System.out.println("Du lieu bi trung lap, hay thuc hien lai.");
                    } else {
                        sp.add(a);
                        GhiFile();
                        System.out.println("Them thanh cong.");
                    }
                    break;
                }
                case 2: {
                    SanPham a = new Drink();
                    a.nhapSP();
                    if (check(a.getMaSP())) {
                        System.out.println("Du lieu bi trung lap, hay thuc hien lai.");
                    } else {
                        sp.add(a);
                        GhiFile();
                        System.out.println("Them thanh cong.");
                    }
                    break;
                }
                case 3: {
                    Combo a = new Combo();
                    a.nhapSP();
                    if (check(a.getMaSP())) {
                        System.out.println("Du lieu bi trung lap, hay thuc hien lai.");
                    } else {
                        sp.add(a);
                        GhiFile();
                        System.out.println("Them thanh cong.");
                    }
                    break;
                }
            }
            System.out.print("nhan phim bat ki de nhap tiep, nhan 't' de thoat: ");
        } while (input.nextLine().charAt(0) != 't');
    }

    public boolean check(String msp) {
        boolean same = false;
        for (SanPham a : sp) {
            if (a.getMaSP().equalsIgnoreCase(msp)) {
                same = true;
                break;
            }
        }
        return same;
    }

    public void TimKiemSPbyMaSP() {
        System.out.print("Nhap ma san pham muon tim: ");
        String m = input.nextLine();
        if (SearchByMaSP(m) == null) {
            System.out.println("Khong tim thay ket qua");
        } else {
            System.out.println("Ket qua: ");
            SearchByMaSP(m).toTable();
        }
        System.out.print("Nhan phim bat ki de tiep tuc.");
        input.nextLine();
    }

    public SanPham SearchByMaSP(String masp) {
        int k = -1;
        for (int i = 0; i < sp.size(); i++) {
            if (sp.get(i).getMaSP().equals(masp)) {
                k = i;
                break;
            }
        }
        if (k == -1) {
            return null;
        } else {
            return sp.get(k);
        }
    }

    public void TimKiemSPbyTheLoai() {
        System.out.print("Loai san pham muon tim(1:Food,2:Drink,3:Combo): ");
        int choice = Integer.parseInt(input.nextLine());
        switch (choice) {
            case 1: {
                System.out.println("Ket qua trung khop: ");
                SearchSPbyTheLoai(choice).XuatSP();
                break;
            }
            case 2: {
                System.out.println("Ket qua trung khop: ");
                SearchSPbyTheLoai(choice).XuatSP();
                break;
            }
            case 3: {
                System.out.println("Ket qua trung khop: ");
                SearchSPbyTheLoai(choice).XuatSP();
                break;
            }
        }
        if (choice < 1 || choice > 3) {
            System.out.println("Khong tim thay ket qua.");
        }
        System.out.print("Nhan phim bat ki de tiep tuc.");
        input.nextLine();
    }

    public DanhSachSanPham SearchSPbyTheLoai(int n) {
        DanhSachSanPham a = new DanhSachSanPham();
        if (n == 1) {
            for (int i = 0; i < sp.size(); i++) {
                if (sp.get(i) instanceof Food) {
                    a.sp.add(this.sp.get(i));
                }
            }
        } else if (n == 2) {
            for (int i = 0; i < sp.size(); i++) {
                if (sp.get(i) instanceof Drink) {
                    a.sp.add(this.sp.get(i));
                }
            }
        } else {
            for (int i = 0; i < sp.size(); i++) {
                if (sp.get(i) instanceof Combo) {
                    Combo b = (Combo) sp.get(i);
                    a.sp.add(b);
                }
            }
        }
        return a;
    }

    public void TimKiemSPbyTenSP() {
        System.out.print("Nhap ten san pham muon tim: ");
        String m = input.nextLine();
        DanhSachSanPham s = new DanhSachSanPham(SearchByTenSP(m).sp);
        if (s.sp.size() == 0) {
            System.out.println("Khong tim thay ket qua.");
        } else {
            System.out.println("Ket qua trung khop: ");
            s.XuatSP();
        }
        System.out.print("Nhan phim bat ki de tiep tuc.");
        input.nextLine();
    }

    public DanhSachSanPham SearchByTenSP(String tsp) {
        DanhSachSanPham a = new DanhSachSanPham();
        for (int i = 0; i < sp.size(); i++) {
            if (sp.get(i).getTenSP().contains(tsp)) {
                a.sp.add(this.sp.get(i));
            }
        }
        return a;
    }

    public void TimKiembyGiaBan() {
        System.out.println("Nhap khoang gia muon tim: ");
        System.out.print("Tu: ");
        double start = Double.parseDouble(input.nextLine());
        System.out.print("Den: ");
        double end = Double.parseDouble(input.nextLine());
        DanhSachSanPham s = new DanhSachSanPham(SearchByGiaBan(start, end).sp);
        if (s.sp.size() == 0) {
            System.out.println("Khong tim thay ket qua.");
        } else {
            System.out.println("Ket qua trung khop: ");
            s.XuatSP();
        }
        System.out.print("Nhan phim bat ki de tiep tuc.");
        input.nextLine();
    }

    public DanhSachSanPham SearchByGiaBan(double start, double end) {
        DanhSachSanPham a = new DanhSachSanPham();
        for (int i = 0; i < sp.size(); i++) {
            if (sp.get(i).getGiaBan() >= start && sp.get(i).getGiaBan() <= end) {
                a.sp.add(this.sp.get(i));
            }
        }
        return a;
    }

    public void TimKiembyGiaNhap() {
        System.out.println("Nhap khoang gia muon tim: ");
        System.out.print("Tu: ");
        double start = Double.parseDouble(input.nextLine());
        System.out.print("Den: ");
        double end = Double.parseDouble(input.nextLine());
        DanhSachSanPham s = new DanhSachSanPham(SearchByGiaNhap(start, end).sp);
        if (s.sp.size() == 0) {
            System.out.println("Khong tim thay ket qua.");
        } else {
            System.out.println("Ket qua trung khop: ");
            s.XuatSP();
        }
        System.out.print("Nhan phim bat ki de tiep tuc.");
        input.nextLine();

    }

    public DanhSachSanPham SearchByGiaNhap(double start, double end) {
        DanhSachSanPham a = new DanhSachSanPham();
        for (int i = 0; i < sp.size(); i++) {
            if (sp.get(i).getGiaNhap() >= start && sp.get(i).getGiaNhap() <= end) {
                a.sp.add(this.sp.get(i));
            }
        }
        return a;
    }

    public void LocSP() {
        int choice;
        do {
            System.out.println("");
            System.out.println("Chon tieu chi de loc: \n" +
                    "1. Ma san pham \n" +
                    "2. The loai \n" +
                    "3. Ten san pham \n" +
                    "4. Gia ban \n" +
                    "5. Gia Nhap \n" +
                    "0. Thoat");
            do {
                System.out.print("Moi nhap lua chon: ");
                choice = Integer.parseInt(input.nextLine());
                if (choice < 0 || choice > 5) {
                    System.out.println("Lua chon khong hop le, moi nhap lai!");
                }
            } while (choice > 5 || choice < 0);
            switch (choice) {
                case 1: {
                    TimKiemSPbyMaSP();
                    break;
                }

                case 2: {
                    TimKiemSPbyTheLoai();
                    break;
                }

                case 3: {
                    TimKiemSPbyTenSP();
                    break;
                }

                case 4: {
                    TimKiembyGiaBan();
                    break;
                }

                case 5: {
                    TimKiembyGiaNhap();
                    break;
                }

                case 0: {
                    break;
                }
            }
        } while (choice != 0);

    }

    public void SuaSPbyMaSP() {
        System.out.print("Nhap ma san pham muon sua: ");
        String m = input.nextLine();
        if (SearchByMaSP(m) == null) {
            System.out.println("Khong tim thay ket qua");
            System.out.println("Nhan phim bat ki de tiep tuc.");
            input.nextLine();
        } else {
            System.out.println("Ket qua: ");
            SearchByMaSP(m).toTable();
            System.out.println("Chon thuoc tinh muon sua: \n" +
                    "1. Ten san pham\n" +
                    "2. Gia ban\n" +
                    "3. Gia nhap\n" +
                    "0. Thoat");
            int choice;
            do {
                System.out.print("Nhap lua chon: ");
                choice = Integer.parseInt(input.nextLine());
                if (choice < 0 || choice > 3) {
                    System.out.println("Lua chon khong hop le, moi nhap lai!");
                }
            } while (choice > 3 || choice < 0);
            switch (choice) {
                case 1: {
                    SearchByMaSP(m).setTenSP();
                    System.out.println("Da chinh sua, nhan phim bat ki de tiep tuc.");
                    input.nextLine();
                    break;
                }

                case 2: {
                    SearchByMaSP(m).setGiaBan();
                    System.out.println("Da chinh sua, nhan phim bat ki de tiep tuc.");
                    input.nextLine();
                    break;
                }

                case 3: {
                    SearchByMaSP(m).setGiaNhap();
                    System.out.println("Da chinh sua, nhan phim bat ki de tiep tuc.");
                    input.nextLine();
                    break;
                }

                case 0: {
                    break;
                }
            }
            GhiFile();
        }

    }

    public void XoaSPbyMaSP() {
        System.out.print("Nhap ma san pham muon sua: ");
        String m = input.nextLine();
        if (SearchByMaSP(m) == null) {
            System.out.println("Khong tim thay ket qua");
            System.out.println("Nhan phim bat ki de tiep tuc.");
        } else {
            System.out.println("Ket qua: ");
            SearchByMaSP(m).toTable();
            String key = SearchByMaSP(m).getMaSP();
            for (int i = 0; i < sp.size(); i++) {
                if (sp.get(i).getMaSP().equalsIgnoreCase(key)) {
                    sp.remove(i);
                    break;
                }
            }
            System.out.println("Da xoa, nhan phim bat ki de tiep tuc.");
        }
    }


    public void titleMenu() {
        System.out.print("|");
        System.out.printf("%-8s", "Ma mon");
        System.out.printf("%-30s", "Ten mon");
        System.out.printf("%10s", "Gia");
        System.out.printf("%10s", "So luong");
        System.out.println("|");
        System.out.println("+----------------------------------------------------------+");
    }

    public void menu() {
        System.out.println("");
        System.out.println("+----------------------------------------------------------+");
        System.out.println("|                          MENU                            |");
        System.out.println("+----------------------------------------------------------+");
        System.out.println("|Mon an                                                    |");
        System.out.println("+----------------------------------------------------------+");
        titleMenu();
        for (SanPham a : sp) {
            if(a instanceof Food) {
                a.xuatMenu();
            }
        }
        System.out.println("|Thuc uong                                                 |");
        System.out.println("+----------------------------------------------------------+");
        titleMenu();
        for (SanPham a : sp) {
            if(a instanceof Drink) {
                a.xuatMenu();
            }
        }
        System.out.println("|Com bo                                                    |");
        System.out.println("+----------------------------------------------------------+");
        titleMenu();
        for (SanPham a : sp) {
            if(a instanceof Combo) {
                Combo b = new Combo();
                b = (Combo) a;
                b.xuatMenu();
            }
        }

    }

    public void NhapHang(NhanVien a, DanhSachPhieuNhap b, DanhSachSanPham dssp_Main) {
        b.themPhieuNhap(a, dssp_Main);
    }

    public void BanHang(NhanVien a, KhachHang c, DanhSachHoaDon b, DanhSachSanPham dssp_Main) {
        menu();
        b.themHoaDon(a, c, dssp_Main);
    }

}
