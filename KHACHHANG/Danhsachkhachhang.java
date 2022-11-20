package KHACHHANG;

import java.io.BufferedReader;
import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

import BASE.*;

public class DanhSachKhachHang implements DocGhiFile {
    ArrayList<KhachHang> KHlist;
    static Scanner input = new Scanner(System.in);
    private String tenFILE = "KHACHHANG/DSKH.txt";

    public DanhSachKhachHang() {
        KHlist = new ArrayList<KhachHang>();
    }

    public DanhSachKhachHang(ArrayList<KhachHang> a) {
        this.KHlist = a;
    }

    public ArrayList<KhachHang> getKHlist() {
        return KHlist;
    }

    @Override
    public void DocFile() {
        File fkh = new File(tenFILE);
        try {
            BufferedReader brkh = Files.newBufferedReader(fkh.toPath());
            String s = null;
            while (true) {
                s = brkh.readLine();
                if (s == null) {
                    break;
                } else {
                    String word[] = s.split(",");
                    KhachHang a = new KhachHang();
                    a.setMaKH(word[0]);
                    a.setTen(word[1]);
                    date b = new date();
                    b.Tachtt(word[2]);
                    a.setNgaySinh(b);
                    a.setDiaChi(word[3]);
                    a.setSDT(word[4]);
                    a.setDtinhluy(Integer.parseInt(word[5]));
                    KHlist.add(a);
                }
            }
            brkh.close();
        } catch (Exception e) {
            System.out.println("Loi doc File danh sach Khach hang: ");
            System.out.println(e.toString());
        }

    }

    @Override
    public void GhiFile() {
        try {
            PrintWriter pw = new PrintWriter(tenFILE);
            for (KhachHang a : KHlist) {
                pw.println(a.toString());
            }
            pw.flush();
            pw.close();
        } catch (Exception e) {
            System.out.println("Loi ghi File danh sach khach hang!");
            e.printStackTrace();
        }
    }

    public void xuatKH() {
        System.out.println(
                "+----------------------------------------------------------------------------------------------------------------------------+");
        System.out.println(
                "|                                             DANH SACH KHACH HANG THANH VIEN                                                |");
        KhachHang.Titile();
        for (KhachHang a : KHlist) {
            a.xuatKH();
        }
        System.out.println(
                "+----------+------------------------------+------------+----------------------------------------+------------+---------------+");
    }

    public void ThemKhachhang() {
        do {
            KhachHang kh = new KhachHang();
            System.out.println("Nhap thong tin khach hang: ");
            kh.Nhap();
            if (checkmaKH(kh.getMaKH())) {
                System.out.println("Du lieu bi trung lap, hay thuc hien lai.");
            } else {
                KHlist.add(kh);
                GhiFile();
                System.out.println("Them thanh cong.");
            }
            System.out.print("Nhan phim bat ki de nhap tiep, nhan 't' de thoat: ");
        } while (input.nextLine().charAt(0) != 't');
    }

    public boolean checkmaKH(String mkh) {
        boolean same = false;
        for (KhachHang a : KHlist) {
            if (a.getMaKH().equalsIgnoreCase(mkh)) {
                same = true;
                break;
            }
        }
        return same;
    }

    public KhachHang SearchKH(String mkh) {
        int k = -1;
        for (int i = 0; i < KHlist.size(); i++) {
            if (KHlist.get(i).getMaKH().equalsIgnoreCase(mkh)) {
                k = i;
            }
        }
        if (k == -1) {
            return null;
        } else {
            return KHlist.get(k);
        }
    }

    public void TimKhachhang() {
        System.out.print("Nhap ma khach hang can tim: ");
        String id = input.nextLine();
        if (SearchKH(id) == null) {
            System.out.println("Khong tim thay ket qua phu hop!");
        } else {
            System.out.println("Ket qua: ");
            SearchKH(id).ToTable();
        }
    }

    public void XoaKhachhang() {
        int index = -1;
        System.out.print("Nhap ma khach hang can xoa: ");
        String id = input.nextLine();
        for (int j = 0; j < KHlist.size(); j++) {
            if (KHlist.get(j).getMaKH().equalsIgnoreCase(id)) {
                index = j;
            }
        }
        if (index == -1)
            System.out.println("Khong tim thay khach hang");
        else {
            KHlist.remove(index);
            System.out.println("Xoa thanh cong.");
        }

    }

    public void SuaKhachhang() {
        System.out.print("Nhap ma khach hang can sua: ");
        String id = input.nextLine();
        int index = -1;
        for (int i = 0; i < KHlist.size(); i++) {
            if (KHlist.get(i).getMaKH().equalsIgnoreCase(id)) {
                index = i;
            }
        }
        if (index == -1) {
            System.out.println("Khong tim thay khach hang.");
        } else {
            System.out.println("Ket qua: ");
            KHlist.get(index).ToTable();
            System.out.println("Chon thong tin de sua: \n" +
                    "1. Dia chi \n" +
                    "2. So dien thoai \n" +
                    "3. Diem tich luy \n" +
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
                    KHlist.get(index).setDiaChi();
                    System.out.print("Da chinh sua, nhan phim bat ki de tiep tuc.");
                    input.nextLine();
                    break;
                }

                case 2: {
                    KHlist.get(index).setSDT();
                    System.out.print("Da chinh sua, nhan phim bat ki de tiep tuc.");
                    input.nextLine();
                    break;
                }

                case 3: {
                    KHlist.get(index).setDtinhluy();
                    System.out.print("Da chinh sua, nhan phim bat ki de tiep tuc.");
                    input.nextLine();
                    break;
                }
            }
        }
    }

}
