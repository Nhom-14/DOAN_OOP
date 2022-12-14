package KHACHHANG;

import java.io.BufferedReader;
import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import BASE.*;

public class DanhSachKhachHang implements DocGhiFile {
    ArrayList<KhachHang> KHlist;
    static Scanner input = new Scanner(System.in);
    private String tenFILE = "KHACHHANG/DSKH.txt";
    String[] khdp = { "KH002,Nguyen Ngoc Sang,21/8/2003,66 An Duong Vuong P16 Q8 TpHCM,0916921132,10",
            "KH003,Nguyen Ngoc Sang1,21/8/2003,66 An Duong Vuong P16 Q8 TpHCM,0916921132,10",
            "KH005,Nguyen Ngoc Sang2,21/8/2003,66 An Duong Vuong P16 Q8 TpHCM,0916921132,10",
            "KH022,Nguyen Ngoc Sang3,21/8/2003,66 An Duong Vuong P16 Q8 TpHCM,0916921132,10",
            "KH066,Nguyen Ngoc Sang4,21/8/2003,66 An Duong Vuong P16 Q8 TpHCM,0916921132,10",
            "KH134,Nguyen Ngoc Sang5,21/8/2003,66 An Duong Vuong P16 Q8 TpHCM,0916921132,10",
            "KH980,Nguyen Ngoc Sang6,21/8/2003,66 An Duong Vuong P16 Q8 TpHCM,0916921132,10",
            "KH3362,Nguyen Ngoc Son1,20/5/2003,Hooc Mon,0898504720,0",
            "KH3363,Nguyen Ngoc Son2,20/5/2003,Hooc Mon,0898504720,0",
            "KH3364,Nguyen Ngoc Son3,20/5/2003,Hooc Mon,0898504720,0", };

    public DanhSachKhachHang() {
        KHlist = new ArrayList<KhachHang>();
    }

    public DanhSachKhachHang(ArrayList<KhachHang> a) {
        this.KHlist = a;
    }

    public DanhSachKhachHang(DanhSachKhachHang orther) {
        this.KHlist = orther.KHlist;
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
            layTTduphong();
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

    public void layTTduphong() {
        for (String k : khdp) {
            String word[] = k.split(",");
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

    public void xuatKH() {
        if (KHlist.size() == 0) {
            System.out.println("Danh sach trong!");
        } else {
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
    }

    public void ThemKhachhang() {
        do {
            KhachHang kh = new KhachHang();
            kh.Nhap(taoMaKH());
            KHlist.add(kh);
            GhiFile();
            System.out.println("Them thanh cong.");
            System.out.print("Nhan phim bat ki de nhap tiep, nhan 't' de thoat: ");
        } while (error.continueString(input.nextLine()) != 't');
    }

    public String taoMaKH() {
        Random rd = new Random();
        String mkh;
        while (true) {
            mkh = "KH" + rd.nextInt(10000);
            if (checkmaKH(mkh)) {
                break;
            }
        }
        return mkh;
    }

    public boolean checkmaKH(String mkh) {
        boolean diff = true;
        for (KhachHang a : KHlist) {
            if (a.getMaKH().equalsIgnoreCase(mkh)) {
                diff = true;
                break;
            }
        }
        return diff;
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
            System.out.println("Xoa thanh cong, nhan bat ki de tiep tuc.");
            input.nextLine();
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
                choice = error.inputIntNumberError(input.nextLine());
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
