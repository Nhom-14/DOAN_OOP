package SANPHAM;

import java.io.BufferedReader;
import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import BASE.*;
import DOANHTHU.DanhSachHoaDon;
import DOANHTHU.DanhSachPhieuNhap;
import DOANHTHU.DoanhThu;
import DOANHTHU.DoanhThuThang;
import KHACHHANG.DanhSachKhachHang;
import NHANVIEN.NhanVien;

public class DanhSachSanPham implements DocGhiFile {
    private ArrayList<SanPham> sp;
    static Scanner input = new Scanner(System.in);
    private String tenFILE = "SANPHAM/DSSP.txt";
    String spdp[] = { "F001,Ga ran,50000,35000,30",
            "F002,Burger bo,48000,33000,30",
            "F003,Burger ga,45000,30000,30",
            "F007,Pizza xuc xich,140000,70000,30",
            "F008,Com ga,35000,20000,30",
            "D002,Fanta,12000,5000,30",
            "D007,Pepsi,15000,7000,30",
            "D001,Coca Cola,12000,5000,30",
            "F005,Salad tron,20000,10000,30",
            "C221,Combo 2 nguoi bao gom: #Ga ran#Khoai tay chien#Coca Cola,53900,47000,30" };

    public DanhSachSanPham() {
        sp = new ArrayList<SanPham>();
    }

    public DanhSachSanPham(ArrayList<SanPham> sp) {
        this.sp = sp;
    }

    public DanhSachSanPham(DanhSachSanPham orther) {
        this.sp = orther.sp;
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
            layTTduphong();
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

    public void layTTduphong() {
        for (String k : spdp) {
            String[] word = k.split(",");
            SanPham a;
            if (word[0].charAt(0) == 'F') {
                a = new Food();
                a.TachTT(word);
                sp.add(a);
            } else if (word[0].charAt(0) == 'D') {
                a = new Drink();
                a.TachTT(word);
                sp.add(a);
            } else if (word[0].charAt(0) == 'C') {
                a = new Combo();
                a.TachTT(word);
                sp.add(a);
            }
        }
    }

    public void XuatSP() {
        if (sp.size() == 0) {
            System.out.println("Danh sach trong!");
        } else {
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

    }

    public void ThemSP() {
        Random rd = new Random();
        do {
            int choice;
            System.out.println("+-------MENU-------+");
            System.out.println("|1.Food.           |");
            System.out.println("|2.Drink.          |");
            System.out.println("|3.Combo.          |");
            System.out.println("|0.Thoat.          |");
            System.out.println("+------------------+");
            do {
                System.out.print("Nhap lua chon: ");
                choice = error.inputIntNumberError(input.nextLine());
                if (choice < 0 || choice > 3) {
                    System.out.println("Khong hop le, moi nhap lai");
                }
            } while (choice < 0 || choice > 3);

            switch (choice) {
                case 1: {
                    SanPham a = new Food();
                    String msp;
                    while (true) {
                        msp = "F" + rd.nextInt(1000);
                        if (check(msp)) {
                            a.nhapSP(msp);
                            break;
                        }
                    }
                    sp.add(a);
                    GhiFile();
                    System.out.println("Them thanh cong.");
                    break;
                }
                case 2: {
                    SanPham a = new Drink();
                    String msp;
                    while (true) {
                        msp = "D" + rd.nextInt(1000);
                        if (check(msp)) {
                            a.nhapSP(msp);
                            break;
                        }
                    }
                    sp.add(a);
                    GhiFile();
                    System.out.println("Them thanh cong.");
                    break;
                }
                case 3: {
                    Combo a = new Combo();
                    String msp;
                    while (true) {
                        msp = "C" + rd.nextInt(1000);
                        if (check(msp)) {
                            a.nhapSP(msp);
                            break;
                        }
                    }
                    sp.add(a);
                    GhiFile();
                    System.out.println("Them thanh cong.");
                    break;
                }

                case 0: {
                    break;
                }
            }
            System.out.print("Nhan phim bat ki de them tiep, nhan 't' de thoat: ");
        } while (error.continueString(input.nextLine()) != 't');
    }

    public boolean check(String msp) {
        boolean diff = true;
        for (SanPham a : sp) {
            if (a.getMaSP().equalsIgnoreCase(msp)) {
                diff = false;
                break;
            }
        }
        return diff;
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
        int choice;
        do {
            System.out.print("Loai san pham muon tim(1:Food,2:Drink,3:Combo,0:Thoat): ");
            choice = error.inputIntNumberError(input.nextLine());
            if (choice < 0 || choice > 3) {
                System.out.println("Khong hop le, moi nhap lai.");
            }
        } while (choice < 0 || choice > 3);

        DanhSachSanPham a = new DanhSachSanPham();
        switch (choice) {
            case 1: {
                for (int i = 0; i < sp.size(); i++) {
                    if (sp.get(i) instanceof Food) {
                        a.sp.add(this.sp.get(i));
                    }
                }
                break;
            }
            case 2: {
                for (int i = 0; i < sp.size(); i++) {
                    if (sp.get(i) instanceof Drink) {
                        a.sp.add(this.sp.get(i));
                    }
                }
                break;
            }
            case 3: {
                for (int i = 0; i < sp.size(); i++) {
                    if (sp.get(i) instanceof Combo) {
                        Combo b = (Combo) sp.get(i);
                        a.sp.add(b);
                    }
                }
                break;
            }
            case 0: {
                break;
            }
        }
        if (a.sp.size() == 0) {
            System.out.println("Khong tim thay ket qua.");
        } else {
            System.out.println("Ket qua trung khop: ");
            a.XuatSP();
        }
        System.out.print("Nhan phim bat ki de tiep tuc.");
        input.nextLine();
    }

    public void TimKiemSPbyTenSP() {
        System.out.print("Nhap ten san pham muon tim: ");
        String tsp = input.nextLine();
        DanhSachSanPham a = new DanhSachSanPham();
        for (int i = 0; i < sp.size(); i++) {
            if (sp.get(i).getTenSP().contains(tsp)) {
                a.sp.add(this.sp.get(i));
            }
        }
        if (a.sp.size() == 0) {
            System.out.println("Khong tim thay ket qua.");
        } else {
            System.out.println("Ket qua trung khop: ");
            a.XuatSP();
        }
        System.out.print("Nhan phim bat ki de tiep tuc.");
        input.nextLine();
    }

    public void TimKiembyGiaBan() {
        System.out.println("Nhap khoang gia muon tim: ");
        System.out.print("Tu: ");
        double start = error.inputDoubleNumberError(input.nextLine());
        System.out.print("Den: ");
        double end = error.inputDoubleNumberError(input.nextLine());
        DanhSachSanPham a = new DanhSachSanPham();
        for (int i = 0; i < sp.size(); i++) {
            if (sp.get(i).getGiaBan() >= start && sp.get(i).getGiaBan() <= end) {
                a.sp.add(this.sp.get(i));
            }
        }
        if (a.sp.size() == 0) {
            System.out.println("Khong tim thay ket qua.");
        } else {
            System.out.println("Ket qua trung khop: ");
            a.XuatSP();
        }
        System.out.print("Nhan phim bat ki de tiep tuc.");
        input.nextLine();
    }

    public void TimKiembyGiaNhap() {
        System.out.println("Nhap khoang gia muon tim: ");
        System.out.print("Tu: ");
        double start = error.inputDoubleNumberError(input.nextLine());
        System.out.print("Den: ");
        double end = error.inputDoubleNumberError(input.nextLine());
        DanhSachSanPham a = new DanhSachSanPham();
        for (int i = 0; i < sp.size(); i++) {
            if (sp.get(i).getGiaNhap() >= start && sp.get(i).getGiaNhap() <= end) {
                a.sp.add(this.sp.get(i));
            }
        }
        if (a.sp.size() == 0) {
            System.out.println("Khong tim thay ket qua.");
        } else {
            System.out.println("Ket qua trung khop: ");
            a.XuatSP();
        }
        System.out.print("Nhan phim bat ki de tiep tuc.");
        input.nextLine();

    }

    public void LocSP() {
        int choice;
        do {
            System.out.println("");
            System.out.println("Chon tieu chi de loc: ");
            System.out.println("+-------MENU-------+");
            System.out.println("|1.Ma san pham     |");
            System.out.println("|2.The loai        |");
            System.out.println("|3.Ten san pham    |");
            System.out.println("|4.Gia ban         |");
            System.out.println("|5.Gia nhap        |");
            System.out.println("|0.Thoat.          |");
            System.out.println("+------------------+");
            do {
                System.out.print("Nhap lua chon: ");
                choice = error.inputIntNumberError(input.nextLine());
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
                choice = error.inputIntNumberError(input.nextLine());
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
            input.nextLine();
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
            if (a instanceof Food) {
                a.xuatMenu();
            }
        }
        System.out.println("|Thuc uong                                                 |");
        System.out.println("+----------------------------------------------------------+");
        titleMenu();
        for (SanPham a : sp) {
            if (a instanceof Drink) {
                a.xuatMenu();
            }
        }
        System.out.println("|Com bo                                                    |");
        System.out.println("+----------------------------------------------------------+");
        titleMenu();
        for (SanPham a : sp) {
            if (a instanceof Combo) {
                Combo b = new Combo();
                b = (Combo) a;
                b.xuatMenu();
            }
        }

    }

    public void NhapHang(NhanVien a, DanhSachPhieuNhap b, DanhSachSanPham dssp_Main, DoanhThu DT, DoanhThuThang DTT_main) {
        int choice;
        do{
            System.out.println("+-----------MENU-----------+");
            System.out.println("|1.Nhap toan bo            |");
            System.out.println("|2.Chon san pham de nhap   |");
            System.out.println("|0.Thoat                   |");
            System.out.println("+--------------------------+");
            do{
                System.out.print("Nhap lua chon: ");
                choice = error.inputIntNumberError(input.nextLine());
                if(choice > 2 || choice <0) {
                    System.out.println("Khong hop le, moi nhap lai.");
                }
            } while(choice > 2 || choice <0);

            switch(choice) {
                case 1 :{
                    b.NhapToanBo(a, dssp_Main, DT);
                    DTT_main.updateDT(DT);
                    break;
                }

                case 2 :{
                    b.nhapHang(a, dssp_Main, DT);
                    DTT_main.updateDT(DT);
                    break;
                }

                case 0: {
                    break;
                }
            }

        } while(choice !=0);
    }

    public void BanHang(NhanVien a, DanhSachKhachHang dskh_Main, String mkh, DanhSachHoaDon b, DanhSachSanPham dssp_Main, DoanhThu DT) {
        menu();
        b.themHoaDon(a, dskh_Main, mkh, dssp_Main, DT);
    }

}
