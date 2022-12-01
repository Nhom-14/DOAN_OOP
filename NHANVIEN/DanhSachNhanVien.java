package NHANVIEN;

import java.util.Scanner;
import BASE.error;

import java.io.BufferedReader;
import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Random;

public class DanhSachNhanVien {
    private ArrayList<NhanVien> NVList;
    Scanner scn = new Scanner(System.in);
    private String tenFILE = "NHANVIEN/DSNV.txt";
    private String tenFILE2 = "NHANVIEN/LCB.txt";
    String nvdp[] = { "NVF002,Nguyen Ngoc Sang0,21/8/2003,0,66 An Duong Vuong P16 Q8,0916921132,0,26,sangf123456789",
            "NVM002,Nguyen Ngoc Sang1,21/8/2003,0,66 An Duong Vuong P16 Q8,0916921132,0,3,sangm123456789",
            "NVP322,Nguyen Ngoc Sang2,21/8/2003,0,66 An Duong Vuong P16 Q8,0916921132,0,5,sangp123456789",
            "NVF432,Nguyen Ngoc Sang3,21/8/2003,0,66 An Duong Vuong P16 Q8,0916921132,0,26,sangf123456789",
            "NVP211,Nguyen Ngoc Sang4,21/8/2003,0,66 An Duong Vuong P16 Q8,0916921132,0,5,sangp123456789",
            "NVF022,Nguyen Ngoc Sang5,21/8/2003,0,66 An Duong Vuong P16 Q8,0916921132,0,26,sangf123456789",
            "NVP278,Nguyen Ngoc Sang6,21/8/2003,0,66 An Duong Vuong P16 Q8,0916921132,0,5,sangp123456789",
            "NVF987,Nguyen Ngoc Sang7,21/8/2003,0,66 An Duong Vuong P16 Q8,0916921132,0,26,sangf123456789",
            "NVP111,Nguyen Ngoc Sang8,21/8/2003,0,66 An Duong Vuong P16 Q8,0916921132,0,5,sangp123456789",
            "NVF222,Nguyen Ngoc Sang9,21/8/2003,0,66 An Duong Vuong P16 Q8,0916921132,0,26,sangf123456789", };

    public DanhSachNhanVien() {
        NVList = new ArrayList<NhanVien>();
    }

    public DanhSachNhanVien(ArrayList<NhanVien> NvList) {
        this.NVList = NvList;
    }

    public DanhSachNhanVien(DanhSachNhanVien orther) {
        this.NVList = orther.NVList;
    }

    public ArrayList<NhanVien> getNVList() {
        return NVList;
    }

    public void setNVList(ArrayList<NhanVien> nVList) {
        NVList = nVList;
    }

    public void DocFile() {
        File fnv = new File(tenFILE);
        try {
            BufferedReader brnv = Files.newBufferedReader(fnv.toPath());
            String s = null;
            while (true) {
                s = brnv.readLine();
                if (s == null) {
                    break;
                } else {
                    String[] word = s.split(",");
                    phanTich(word);
                }
            }
            brnv.close();
        } catch (Exception e) {
            System.out.println("Loi doc file nhan vien");
            System.out.println(e.toString());
            layTTduphong();
        }

        File fl = new File(tenFILE2);
        try {
            BufferedReader brl = Files.newBufferedReader(fl.toPath());
            String s = brl.readLine();
            String w[] = s.split(",");
            Manager.setLuongCoBan(Double.parseDouble(w[0]));
            FullTime.setLuongCoBan(Double.parseDouble(w[1]));
            PartTime.setLuongCoBanTheoGio(Double.parseDouble(w[2]));
        } catch (Exception e) {
            Manager.setLuongCoBan(Manager.getLuongCoBandp());
            FullTime.setLuongCoBan(FullTime.getLuongCoBandp());
            PartTime.setLuongCoBanTheoGio(PartTime.getLuongCoBanTheoGiodp());
        }

    }

    public void GhiFile() {
        try {
            PrintWriter pw = new PrintWriter(tenFILE);
            for (NhanVien a : NVList) {
                pw.println(a.toString());
            }
            pw.flush();
            pw.close();
        } catch (Exception e) {
            System.out.println("Loi ghi file nhan vien");
            System.out.println(e.toString());
        }

        try {
            PrintWriter pw2 = new PrintWriter(tenFILE2);
            pw2.println(Manager.getLuongCoBan() + "," + FullTime.getLuongCoBan() + "," + PartTime.getLuongCoBanTheoGio());
            pw2.flush();
            pw2.close();
        } catch (Exception e) {
        }
    }

    public void layTTduphong() {
        for (String k : nvdp) {
            String[] word = k.split(",");
            phanTich(word);
        }
    }

    public void phanTich(String[] word) {
        if (word[0].indexOf("NVM") == 0) {
            NhanVien a = new Manager();
            a.TachTT(word);
            NVList.add(a);
        } else if (word[0].indexOf("NVF") == 0) {
            NhanVien a = new FullTime();
            a.TachTT(word);
            NVList.add(a);
        } else if (word[0].indexOf("NVP") == 0) {
            NhanVien a = new PartTime();
            a.TachTT(word);
            NVList.add(a);
        }
    }

    public void ThemNV() {
        Random rd = new Random();
        int choose;
        do {
            System.out.println("+-----------------MENU--------------------+");
            System.out.println("|1.Them vao nhan vien Parttime            |");
            System.out.println("|2.Them vao nhan vien Fulltime            |");
            System.out.println("|3.Them vao Manager                       |");
            System.out.println("|0.Thoat                                  |");
            System.out.println("+-----------------------------------------+");
            do {
                System.out.print("Nhap lua chon: ");
                choose = error.inputIntNumberError(scn.nextLine());
                if (choose < 0 || choose > 3) {
                    System.out.println("Nhap sai thong tin moi nhap lai!");
                }
            } while (choose < 0 || choose > 3);
            String mnv;
            switch (choose) {
                case 1: {
                    NhanVien nvPT = new PartTime();
                    while (true) {
                        mnv = "NVP" + rd.nextInt(1000);
                        if (checkMaNV(mnv)) {
                            nvPT.nhapNV(mnv);
                            break;
                        }
                    }
                    NVList.add(nvPT);
                    GhiFile();
                    break;
                }
                case 2: {
                    NhanVien nvFT = new FullTime();
                    while (true) {
                        mnv = "NVF" + rd.nextInt(1000);
                        if (checkMaNV(mnv)) {
                            nvFT.nhapNV(mnv);
                            break;
                        }
                    }
                    NVList.add(nvFT);
                    GhiFile();
                    break;
                }
                case 3: {
                    NhanVien mng = new Manager();
                    while (true) {
                        mnv = "NVM" + rd.nextInt(1000);
                        if (checkMaNV(mnv)) {
                            mng.nhapNV(mnv);
                            break;
                        }
                    }
                    NVList.add(mng);
                    GhiFile();
                    break;
                }
                case 0: {
                    break;
                }
            }
            System.out.print("Nhan phim bat ki de them tiep, 't' de thoat: ");
        } while (error.continueString(scn.nextLine()) != 't');
    }

    public boolean checkMaNV(String mnv) {
        boolean diff = true;
        for (NhanVien a : NVList) {
            if (a.getMaNV().equalsIgnoreCase(mnv)) {
                diff = false;
                break;
            }
        }
        return diff;
    }

    public void XuatNV() {
        if (NVList.size() == 0) {
            System.out.println("Khong co nhan vien trong danh sach!");
            return;
        } else {
            System.out.println("");
            System.out.println(
                    "+-----------------------------------------------------------------------------------------------------------------------+");
            System.out.println(
                    "|                                               DANH SACH NHAN VIEN                                                     |");
            NhanVien.Title();
            for (NhanVien a : NVList) {
                if (a.getMaNV().indexOf("NVM") == 0) {
                    a.xuatNV();
                }
            }
            for (NhanVien a : NVList) {
                if (a.getMaNV().indexOf("NVF") == 0) {
                    a.xuatNV();
                }
            }
            for (NhanVien a : NVList) {
                if (a.getMaNV().indexOf("NVP") == 0) {
                    a.xuatNV();
                }
            }
        }

    }

    public void SuaNV() {
        System.out.print("Nhap ma nhan vien cua nhan vien can sua: ");
        String manv = scn.nextLine();
        int index = -1;
        for (int i = 0; i < NVList.size(); i++)
            if (NVList.get(i).getMaNV().equalsIgnoreCase(manv)) {
                index = i;
                break;
            }
        if (index == -1) {
            System.out.println("Khong tim thay nhan vien!!");
        } else {
            int choice;
            System.out.println("");
            System.out.println("Chon thong tin de sua: ");
            System.out.println("+-------------MENU--------------+");
            System.out.println("|1.Dia chi                      |");
            System.out.println("|2.So dien thoai                |");
            System.out.println("|3.So ngay nghi                 |");
            System.out.println("|4.Chuc vu                      |");
            System.out.println("|5.Cap bac quan ly (Manager)    |");
            System.out.println("|6.Ngay cong (FullTime)         |");
            System.out.println("|7.Gio lam (PartTime)           |");
            System.out.println("|0.Thoat                        |");
            System.out.println("+-------------------------------+");
            do {
                System.out.print("Nhap lua chon: ");
                choice = error.inputIntNumberError(scn.nextLine());
                if (choice < 0 || choice > 7) {
                    System.out.println("Nhap sai, hay nhap lai!");
                }
            } while (choice < 0 || choice > 7);

            switch (choice) {
                case 1: {
                    NVList.get(index).setDiaChi();
                    System.out.print("Da chinh sua.");
                    break;
                }

                case 2: {
                    NVList.get(index).setSDT();
                    System.out.print("Da chinh sua.");
                    break;
                }

                case 3: {
                    NVList.get(index).setSoNgayNghi();
                    System.out.print("Da chinh sua.");
                    break;
                }

                case 4: {
                    System.out.println("Nhap lai thong tin de thay doi chuc vu.");
                    NVList.remove(index);
                    ThemNV();
                    System.out.print("Da chinh sua.");
                    break;
                }

                case 5: {
                    if (NVList.get(index) instanceof Manager) {
                        NVList.get(index).setWord();
                        System.out.print("Da chinh sua.");
                    } else {
                        System.out.println("Chuc nang chi danh cho nhan vien quan ly.");
                    }
                    break;
                }

                case 6: {
                    if (NVList.get(index) instanceof FullTime) {
                        NVList.get(index).setWord();
                        System.out.print("Da chinh sua.");
                    } else {
                        System.out.println("Chuc nang chi danh cho nhan vien fulltime.");
                    }
                    break;
                }

                case 7: {
                    if (NVList.get(index) instanceof PartTime) {
                        NVList.get(index).setWord();
                        System.out.print("Da chinh sua.");
                    } else {
                        System.out.println("Chuc nang chi danh cho nhan vien parttime.");
                    }
                    break;
                }

                case 0: {
                    break;
                }
            }
            System.out.print("Nhan phim bat ki de tiep tuc.");
            scn.nextLine();
        }
    }

    public void XoaNV() {
        System.out.println("Nhap ma nhan vien cua nhan vien can xoa: ");
        String manv = scn.nextLine();
        int index = -1;
        for (int i = 0; i < NVList.size(); i++)
            if (NVList.get(i).getMaNV().equals(manv)) {
                index = i;
                break;
            }
        if (index == -1) {
            System.out.print("Khong tim thay nhan vien, nhan bat ki de tiep tuc.");
        } else {
            NVList.remove(index);
            System.out.print("Xoa thanh cong, nhan bat ki de tiep tuc.");
        }
        scn.nextLine();
    }

    public void LocNV() {
        int choose;
        do {
            System.out.println("");
            System.out.println("+-------------MENU--------------+");
            System.out.println("|1.Tim kiem theo ma nhan vien   |");
            System.out.println("|2.Loc theo chuc vu             |");
            System.out.println("|0.Thoat                        |");
            System.out.println("+-------------------------------+");
            do {
                System.out.print("Nhap lua chon: ");
                choose = error.inputIntNumberError(scn.nextLine());
                if (choose < 0 || choose > 2) {
                    System.out.println("Nhap sai, moi nhap lai!");
                }
            } while (choose < 0 || choose > 2);
            switch (choose) {
                case 1: {
                    TimKiemNV();
                    break;
                }

                case 2: {
                    TimKiemNV2();
                    break;
                }

                case 0: {
                    break;
                }

            }

        } while (choose != 0);
    }

    public void TimKiemNV() {
        System.out.print("Nhap ma nhan vien cua nhan vien can tim kiem: ");
        String manv = scn.nextLine();
        if (SearchNVbyMaNV(manv) == null) {
            System.out.println("Khong tim thay nhan vien, nhan phim bat ki de tiep tuc.");
        } else {
            System.out.println("Ket qua trung khop");
            SearchNVbyMaNV(manv).toTable();
            System.out.print("Nhan phim bat ki de tiep tuc.");
        }
        scn.nextLine();
    }

    public NhanVien SearchNVbyMaNV(String m) {
        int index = -1;
        for (int i = 0; i < NVList.size(); i++)
            if (NVList.get(i).getMaNV().equals(m)) {
                index = i;
                break;
            }
        if (index == -1) {
            return null;
        } else {
            return NVList.get(index);
        }
    }

    public void TimKiemNV2() {
        int choose;
        do {
            System.out.println("");
            System.out.println("Chon nhan vien muon loc:");
            System.out.println("+-------------MENU--------------+");
            System.out.println("|1.Manager                      |");
            System.out.println("|2.FullTime                     |");
            System.out.println("|3.PartTime                     |");
            System.out.println("|0.Thoat                        |");
            System.out.println("+-------------------------------+");
            do {
                System.out.print("Nhap lua chon: ");
                choose = error.inputIntNumberError(scn.nextLine());
                if (choose < 0 || choose > 3) {
                    System.out.println("Nhap sai, moi nhap lai.");
                }
            } while (choose < 0 || choose > 3);
            DanhSachNhanVien a = new DanhSachNhanVien();
            switch (choose) {
                case 1: {
                    for (int i = 0; i < NVList.size(); i++) {
                        if (NVList.get(i) instanceof Manager) {
                            a.NVList.add(this.NVList.get(i));
                        }
                    }

                    break;
                }
                case 2: {
                    for (int i = 0; i < NVList.size(); i++) {
                        if (NVList.get(i) instanceof FullTime) {
                            a.NVList.add(this.NVList.get(i));
                        }
                    }
                    break;
                }
                case 3: {
                    for (int i = 0; i < NVList.size(); i++) {
                        if (NVList.get(i) instanceof PartTime) {
                            a.NVList.add(this.NVList.get(i));
                        }
                    }
                    break;
                }
            }
            if (a.NVList.size() == 0) {
                System.out.println("Khong tim thay ket qua.");
            } else {
                System.out.println("Ket qua trung khop: ");
                a.XuatNV();
            }
            System.out.print("Nhan phim bat ki de tiep tuc.");
            scn.nextLine();
        } while (choose != 0);
    }

    public NhanVien dangNhap(String user, String pass) {
        int index = -1;
        for (int i = 0; i < NVList.size(); i++) {
            if (NVList.get(i).getTk().getUserName().equals(user)) {
                if (NVList.get(i).getTk().getPassword().equals(pass)) {
                    index = i;
                }
            }
        }
        if (index != -1) {
            return NVList.get(index);
        } else {
            return null;
        }
    }

    public void BangLuong() {
        System.out.println("+--------------------------------------------------------------------------------------------+");
        System.out.println("|                                    BANG LUONG NHAN VIEN                                    |");
        System.out.println("+--------+---------------+-----------------------------------+----------+--------------------+");
        System.out.print("|");
        System.out.printf("%-8s", "Ma NV");
        System.out.print("|");
        System.out.printf("%-15s", "Chuc vu");
        System.out.print("|");
        System.out.printf("%-35s", "Ho va ten");
        System.out.print("|");
        System.out.printf("%-10s", "SNN");
        System.out.print("|");
        System.out.printf("%20s", "Luong thang");
        System.out.println("|");
        System.out.println("+--------+---------------+-----------------------------------+----------+--------------------+");
        for (NhanVien a : NVList) {
            if (a.getMaNV().indexOf("NVM") == 0) {
                a.xuatLuong();
            }
        }
        for (NhanVien a : NVList) {
            if (a.getMaNV().indexOf("NVF") == 0) {
                a.xuatLuong();
            }
        }
        for (NhanVien a : NVList) {
            if (a.getMaNV().indexOf("NVP") == 0) {
                a.xuatLuong();
            }
        }
        System.out.println("+--------+---------------+-----------------------------------+----------+--------------------+");
    }

    

    public void suaLuongCoBan() {
        int choose;
        do{
            System.out.println("");
            System.out.println("+--------------MENU----------------+");
            System.out.println("|1.Luong co ban (Manager)          |");
            System.out.println("|2.Luong co ban (FullTime)         |");
            System.out.println("|3.Luong co ban theo gio (PartTime)|");
            System.out.println("|0.Thoat                           |");
            System.out.println("+----------------------------------+");
            do{
                System.out.print("Nhap lua chon: ");
                choose = error.inputIntNumberError(scn.nextLine());
                if(choose < 0 || choose > 3) {
                    System.out.println("Khong hop le, moi nhap lai.");
                }
            } while (choose < 0 || choose > 3);

            switch (choose) {
                case 1: {
                    System.out.println("Luong co ban(Manager) hien tai: " + Manager.getLuongCoBan());
                    System.out.println("Sua luong co ban: ");
                    Manager.setLuongCoBan();
                    System.out.println("Da chinh sua, nhan bat ki de tiep tuc.");
                    scn.nextLine();
                    break;
                }

                case 2: {
                    System.out.println("Luong co ban(FullTime) hien tai: " + FullTime.getLuongCoBan());
                    System.out.println("Sua luong co ban: ");
                    FullTime.setLuongCoBan();
                    System.out.println("Da chinh sua, nhan bat ki de tiep tuc.");
                    scn.nextLine();
                    break;
                }

                case 3: {
                    System.out.println("Luong co ban theo gio(PartTime) hien tai: " + PartTime.getLuongCoBanTheoGio());
                    System.out.println("Sua luong co ban: ");
                    PartTime.setLuongCoBanTheoGio();
                    System.out.println("Da chinh sua, nhan bat ki de tiep tuc.");
                    scn.nextLine();
                    break;
                }

                case 0: {
                    break;
                }
            }
        } while(choose != 0);
    }

}
