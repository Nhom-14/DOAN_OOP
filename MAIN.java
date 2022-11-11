import java.util.Scanner;

import KHACHHANG.*;
import SANPHAM.*;

public class MAIN {
    static Scanner input = new Scanner(System.in);
    static DanhSachSanPham DSSP = new DanhSachSanPham();
    static DanhSachKhachHang DSKH = new DanhSachKhachHang();

    public static void main(String[] args) {

        DSSP.DocFile();
        DSKH.DocFile();
        int opt;
        do {
            System.out.println("");
            System.out.println("+---------------------------------------+");
            System.out.println("|               MAIN MENU               |");
            System.out.println("+---------------------------------------+");
            System.out.println("|1. Quan ly san pham.                   |");
            System.out.println("|2. Quan ly nhan vien.                  |");
            System.out.println("|3. Ban hang.                           |");
            System.out.println("|4. Quan ly tai khoan thanh vien.       |");
            System.out.println("|5. Quan ly doanh thu.                  |");
            System.out.println("|0. Thoat chuong trinh.                 |");
            System.out.println("+---------------------------------------+");
            do {
                System.out.print("Moi nhap lua chon: ");
                opt = Integer.parseInt(input.nextLine());
                if (opt > 5 || opt < 0) {
                    System.out.println("Khong hop le, moi nhap lai");
                }
            } while (opt > 5 || opt < 0);

            switch (opt) {
                case 1: {
                    QuanlySP();
                    break;
                }

                case 2: {
                    System.out.println("Quan ly nhan vien");
                    break;
                }

                case 3: {
                    System.out.println("Ban hang");
                    break;
                }

                case 4: {
                    QuanLyTKTT();
                    break;
                }

                case 5: {
                    System.out.println("Quan ly doanh thu");
                    break;
                }

                case 0: {
                    break;
                }

            }

        } while (opt != 0);

    }

    public static void QuanlySP() {
        int choice;
        do {
            System.out.println("");
            System.out.println("+---------------------------------------+");
            System.out.println("|           QUAN LY SAN PHAM            |");
            System.out.println("+---------------------------------------+");
            System.out.println("|1. Xuat san pham trong kho.            |");
            System.out.println("|2. Them san pham.                      |");
            System.out.println("|3. Loc san pham.                       |");
            System.out.println("|4. Sua thong tin san pham.             |");
            System.out.println("|5. Xoa san pham.                       |");
            System.out.println("|6. Nhap hang.                          |");
            System.out.println("|0. Tro ve menu chinh.                  |");
            System.out.println("+---------------------------------------+");
            do {
                System.out.print("Moi nhap lua chon: ");
                choice = Integer.parseInt(input.nextLine());
                if (choice < 0 || choice > 6) {
                    System.out.println("Lua chon khong hop le, moi nhap lai!");
                }
            } while (choice > 6 || choice < 0);

            switch (choice) {
                case 1: {
                    DSSP.XuatSP();
                    System.out.print("Nhan phim bat ki de tiep tuc.");
                    input.nextLine();
                    break;
                }

                case 2: {
                    DSSP.ThemSP();
                    break;
                }
                case 3: {
                    DSSP.LocSP();
                    break;
                }

                case 4: {
                    DSSP.SuaSPbyMaSP();
                    break;
                }

                case 5: {
                    DSSP.XoaSPbyMaSP();
                    break;
                }

                case 6: {
                    DSSP.NhapHang();
                    break;
                }

                case 0: {
                    break;
                }

            }

        } while (choice != 0);
    }

    public static void QuanLyNV() {
        int choice;
        do{
            System.out.println("");
            System.out.println("+---------------------------------------+");
            System.out.println("|           QUAN LY NHAN VIEN           |");
            System.out.println("+---------------------------------------+");
            System.out.println("|1. Xuat danh sach nhan vien.           |");
            System.out.println("|2. Them nhan vien.                     |");
            System.out.println("|3. Tim kiem nhan vien.                 |");
            System.out.println("|4. Sua thong tin nhan vien.            |");
            System.out.println("|5. Xoa nhan vien.                      |");
            System.out.println("|6. Cham cong nhan vien                 |");
            System.out.println("|0. Tro ve menu chinh.                  |");
            System.out.println("+---------------------------------------+");
            do {
                System.out.print("Moi nhap lua chon: ");
                choice = Integer.parseInt(input.nextLine());
                if (choice < 0 || choice > 6) {
                    System.out.println("Lua chon khong hop le, moi nhap lai!");
                }
            } while (choice > 6 || choice < 0);

            switch (choice) {
                case 1: {
                    break;
                }

                case 2: {
                    break;
                }

                case 3: {
                    break;
                }

                case 4: {
                    break;
                }

                case 5: {
                    break;
                }

                case 6: {
                    break;
                }

                case 0: {
                    break;
                }
            }
        }while (choice != 0);
    }

    public static void QuanLyTKTT() {
        int choice;
        do{
            System.out.println("");
            System.out.println("+---------------------------------------+");
            System.out.println("|     QUAN LY TAI KHOAN THANH VIEN      |");
            System.out.println("+---------------------------------------+");
            System.out.println("|1. Xuat danh sach thanh vien.          |");
            System.out.println("|2. Them thanh vien.                    |");
            System.out.println("|3. Tim kiem thanh vien.                |");
            System.out.println("|4. Sua thong tin thanh vien.           |");
            System.out.println("|5. Xoa thanh vien.                     |");
            System.out.println("|0. Tro ve menu chinh.                  |");
            System.out.println("+---------------------------------------+");
            do {
                System.out.print("Moi nhap lua chon: ");
                choice = Integer.parseInt(input.nextLine());
                if (choice < 0 || choice > 5) {
                    System.out.println("Lua chon khong hop le, moi nhap lai!");
                }
            } while (choice > 5 || choice < 0);

            switch(choice) {
                case 1: {
                    DSKH.xuatKH();
                    System.out.print("Nhan phim bat ki de tiep tuc.");
                    input.nextLine();
                    System.out.println("");
                    break;
                }

                case 2: {
                    DSKH.ThemKhachhang();
                    break;
                }

                case 3: {
                    DSKH.TimKhachhang();
                    System.out.print("Nhan phim bat ki de tiep tuc.");
                    input.nextLine();
                    System.out.println("");
                    break;
                }

                case 4: {
                    DSKH.SuaKhachhang();
                    break;
                }

                case 5: {
                    DSKH.XoaKhachhang();
                    System.out.print("Nhan phim bat ki de tiep tuc.");
                    input.nextLine();
                    System.out.println("");
                    break;
                }

                case 0: {
                    break;
                }
            }
        } while (choice != 0);
    }
}
// Phan quyen cac chuc nang
// mang KhachHang
// mang NhanVien
// mang SanPham
// mang HoaDon
// mang PhieuNhap
// class taikhoan
// class phanquyen
// tim hieu tu khoa final