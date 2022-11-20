package NHANVIEN;

import java.util.Scanner;

import java.io.BufferedReader;
import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;

public class DanhSachNhanVien {
    private ArrayList<NhanVien> NVList;
    Scanner scn = new Scanner(System.in);
    private String tenFILE = "NHANVIEN/DSNV.txt";

    public DanhSachNhanVien() {
        NVList = new ArrayList<NhanVien>();
    }

    public DanhSachNhanVien(ArrayList<NhanVien> NvList) {
        this.NVList = NvList;
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
                    NhanVien a;
                    if (word[0].charAt(0) == 'M') {
                        a = new Manager();
                        a.TachTT(word);
                        NVList.add(a);
                    } else if (word[0].charAt(0) == 'T') {
                        a = new FullTime();
                        a.TachTT(word);
                        NVList.add(a);
                    } else if (word[0].charAt(0) == 'P') {
                        a = new PartTime();
                        a.TachTT(word);
                        NVList.add(a);
                    }
                }
            }
            brnv.close();
        } catch (Exception e) {
            System.out.println("Loi doc file nhan vien");
            System.out.println(e.toString());
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
    }

    public void ThemNV() {
        int choose;
        do {
            System.out.println("+-----------------MENU--------------------+");
            System.out.println("|1.Them vao nhan vien Parttime            |");
            System.out.println("|2.Them vao nhan vien Fulltime            |");
            System.out.println("|3.Them vao Manager                       |");
            System.out.println("+-----------------------------------------+");
            do {
                System.out.print("Nhap lua chon: ");
                choose = Integer.parseInt(scn.nextLine());
                if (choose < 0 || choose > 3) {
                    System.out.println("Nhap sai thong tin moi nhap lai!");
                }
            } while (choose < 0 || choose > 3);
            switch (choose) {
                case 1: {
                    NhanVien nvPT = new PartTime();
                    nvPT.nhapNV();
                    NVList.add(nvPT);
                    break;
                }
                case 2: {
                    NhanVien nvFT = new FullTime();
                    nvFT.nhapNV();
                    NVList.add(nvFT);
                    break;
                }
                case 3: {
                    NhanVien mng = new Manager();
                    mng.nhapNV();
                    NVList.add(mng);
                    break;
                }
                case 0: {
                    break;
                }
            }
            GhiFile();
            System.out.print("Nhan phim bat ki de tiep tuc, 't' de thoat");
        } while (scn.nextLine().charAt(0) != 't');
    }

    public void XuatNV() {
        if (NVList.size() == 0) {
            System.out.println("Khong co nhan vien trong danh sach!");
            return;
        } else {
            System.out.println("");
            System.out.println(
                    "+------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println(
                    "|                                                  DANH SACH NHAN VIEN                                                               |");
            NhanVien.Title();
            for (NhanVien a : NVList) {
                a.xuatNV();
            }
            System.out.println("Ghi chu: ");
            System.out.println("Doi voi quan li (manager): tinh luong theo cap bac.");
            System.out.println("Doi voi nhan vien FullTime: luong tinh theo ngay cong.");
            System.out.println("Doi voi nhan vien PartTime: luong tinh theo gio lam");
        }

    }

    public void SuaNV() {
        System.out.println("Nhap ma nhan vien cua nhan vien can sua: ");
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
            System.out.print("Chon thong tin de sua: ");
            System.out.println("+-------------MENU--------------+");
            System.out.println("|1.Dia chi                      |");
            System.out.println("|2.So dien thoai                |");
            System.out.println("|3.So ngay nghi                 |");
            System.out.println("|4.Chuc vu                      |");
            System.out.println("|0.Thoat                        |");
            System.out.println("+-------------------------------+");
            do {
                System.out.print("Nhap lua chon: ");
                choice = Integer.parseInt(scn.nextLine());
                if (choice < 0 || choice > 3) {
                    System.out.println("Nhap sai, hay nhap lai!");
                }
            } while (choice < 0 || choice > 3);

            switch (choice) {
                case 1: {
                    NVList.get(index).setDiaChi();
                    System.out.println("Da chinh sua, nhan bat ki de tiep tuc.");
                    scn.nextLine();
                    break;
                }

                case 2: {
                    NVList.get(index).setSDT();
                    System.out.println("Da chinh sua, nhan bat ki de tiep tuc.");
                    scn.nextLine();
                    break;
                }

                case 3: {
                    NVList.get(index).setSoNgayNghi();
                    System.out.println("Da chinh sua, nhan bat ki de tiep tuc.");
                    scn.nextLine();
                    break;
                }

                case 4: {
                    NVList.remove(index);
                    ThemNV();
                    System.out.println("Da chinh sua, nhan bat ki de tiep tuc.");
                    scn.nextLine();
                    break;
                }

                case 0: {
                    break;
                }
            }

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
            System.out.println("Khong tim thay nhan vien!!");
        } else {
            NVList.remove(index);
            System.out.print("Xoa thanh cong, nhan bat ki de tiep tuc.");
            scn.nextLine();
        }
    }

    public void LocNV() {
        int choose;
        do {
            System.out.println("+-------------MENU--------------+");
            System.out.println("|1.Tim kiem theo ma nhan vien   |");
            System.out.println("|2.Loc theo chuc vu             |");
            System.out.println("|0. Thoat                       |");
            System.out.println("+-------------------------------+");
            do {
                System.out.print("Nhap lua chon: ");
                choose = Integer.parseInt(scn.nextLine());
                if (choose < 0 || choose > 2) {
                    System.out.println("Nhap sai, moi nhap lai!");
                }
            } while (choose < 0 || choose > 1);
            switch (choose) {
                case 1: {
                    TimKiemNV();
                }

                case 2: {
                    TimKiemNV2();
                }
            }

        } while (choose != 0);
    }

    public void TimKiemNV() {
        System.out.println("Nhap ma nhan vien cua nhan vien can tim kiem: ");
        String manv = scn.nextLine();
        if (SearchNVbyMaNV(manv) == null) {
            System.out.println("Khong tim thay nhan vien!");
        } else {
            System.out.println("Ket qua trung khop");
            SearchNVbyMaNV(manv).toTable();
            System.out.println("Nhan phim bat ki de tiep tuc.");
        }
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
            System.out.println("Chon nhan vien muon loc:");
            System.out.println("+-------------MENU--------------+");
            System.out.println("|1.Manager                      |");
            System.out.println("|2.FullTime                     |");
            System.out.println("|3.PartTime                     |");
            System.out.println("|0.Thoat                        |");
            System.out.println("+-------------------------------+");
            do {
                System.out.print("Nhap lua chon: ");
                choose = Integer.parseInt(scn.nextLine());
                if (choose < 0 || choose > 3) {
                    System.out.println("Nhap sai, moi nhap lai.");
                }
            } while (choose < 0 || choose > 3);
            switch (choose) {
                case 1: {
                    System.out.println("Ket qua trung khop: ");
                    SearchSPbyTheLoai(choose).XuatNV();
                    break;
                }
                case 2: {
                    System.out.println("Ket qua trung khop: ");
                    SearchSPbyTheLoai(choose).XuatNV();
                    break;
                }
                case 3: {
                    System.out.println("Ket qua trung khop: ");
                    SearchSPbyTheLoai(choose).XuatNV();
                    break;
                }
            }
            System.out.print("Nhan phim bat ki de tiep tuc.");
            scn.nextLine();
        } while (choose != 0);
    }

    public DanhSachNhanVien SearchSPbyTheLoai(int n) {
        DanhSachNhanVien a = new DanhSachNhanVien();
        if (n == 1) {
            for (int i = 0; i < NVList.size(); i++) {
                if (NVList.get(i) instanceof Manager) {
                    a.NVList.add(this.NVList.get(i));
                }
            }
        } else if (n == 2) {
            for (int i = 0; i < NVList.size(); i++) {
                if (NVList.get(i) instanceof FullTime) {
                    a.NVList.add(this.NVList.get(i));
                }
            }
        } else {
            for (int i = 0; i < NVList.size(); i++) {
                if (NVList.get(i) instanceof PartTime) {
                    a.NVList.add(this.NVList.get(i));
                }
            }
        }
        return a;
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
        System.out.println("+---------------------------------------------------------------------------+");
        System.out.println("|                          BANG LUONG NHAN VIEN                             |");
        System.out.println("+--------+--------------------------------------------------+---------------+");
        System.out.print("|");
        System.out.printf("%-8s", "Ma NV");
        System.out.print("|");
        System.out.printf("%-50s", "Ho va ten");
        System.out.print("|");
        System.out.printf("%-15s", "Luong");
        System.out.println("|");
        System.out.println("+--------+--------------------------------------------------+---------------+");
        for (NhanVien a : NVList) {
            System.out.print("|");
            System.out.printf("%-8s", a.getMaNV());
            System.out.print("|");
            System.out.printf("%-50s", a.getTen());
            System.out.print("|");
            System.out.printf("%-15s", a.TinhLuong());
            System.out.println("|");
        }
        System.out.println("+--------+--------------------------------------------------+---------------+");
    }

}
