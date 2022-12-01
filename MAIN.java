import java.util.Scanner;

import BASE.error;
import DOANHTHU.DanhSachHoaDon;
import DOANHTHU.DanhSachPhieuNhap;
import DOANHTHU.DoanhThu;
import DOANHTHU.DoanhThuThang;
import KHACHHANG.DanhSachKhachHang;
import NHANVIEN.DanhSachNhanVien;
import NHANVIEN.NhanVien;
import SANPHAM.DanhSachSanPham;

public class MAIN {
    private static Scanner input = new Scanner(System.in);
    private static DanhSachSanPham DSSP;
    private static DanhSachKhachHang DSKH;
    private static DanhSachNhanVien DSNV;
    private static DanhSachPhieuNhap DSPN;
    private static DanhSachHoaDon DSHD;
    private static DoanhThuThang DTT;
    private static DoanhThu DT;

    public static void main(String[] args) {

        DSSP = new DanhSachSanPham();
        DSSP.DocFile();

        DSKH = new DanhSachKhachHang();
        DSKH.DocFile();

        DSNV = new DanhSachNhanVien();
        DSNV.DocFile();

        DSPN = new DanhSachPhieuNhap(DSSP, DSNV);
        DSPN.DocFile();

        DSHD = new DanhSachHoaDon(DSKH, DSSP, DSNV);
        DSHD.DocFile();

        DTT = new DoanhThuThang();
        DTT.DocFile();

        DT = new DoanhThu();
        DTT.addDT(DT);

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
            System.out.println("|5. Quan ly nhap, ban.                  |");
            System.out.println("|0. Thoat chuong trinh.                 |");
            System.out.println("+---------------------------------------+");
            do {
                System.out.print("Moi nhap lua chon: ");
                opt = error.inputIntNumberError(input.nextLine());
                if (opt > 5 || opt < 0) {
                    System.out.println("Khong hop le, moi nhap lai");
                }
            } while (opt > 5 || opt < 0);

            switch (opt) {
                case 1: {
                    System.out.println("Dang nhap tai khoan nhan vien: ");
                    System.out.print("ID nhan vien: ");
                    String id = input.nextLine();
                    System.out.print("Password: ");
                    String pass = input.nextLine();
                    if (DSNV.dangNhap(id, pass) != null) {
                        QuanLySP(DSNV.dangNhap(id, pass));
                    } else {
                        System.out.println("Khong tim thay tai khoan.");
                        System.out.print("Nhan phim bat ki de quay lai.");
                        input.nextLine();
                    }
                    break;
                }

                case 2: {
                    System.out.println("Dang nhap tai khoan nhan vien: ");
                    System.out.print("ID nhan vien: ");
                    String id = input.nextLine();
                    System.out.print("Password: ");
                    String pass = input.nextLine();
                    if (DSNV.dangNhap(id, pass) != null) {
                        if (id.indexOf("NVM") == 0) {
                            QuanLyNV(DSNV.dangNhap(id, pass));
                        } else {
                            System.out.println("Khong du quyen de su dung chuc nang nay.");
                        }
                    } else {
                        System.out.println("Khong tim thay tai khoan.");
                        System.out.print("Nhan phim bat ki de tiep tuc.");
                        input.nextLine();
                    }
                    break;
                }

                case 3: {
                    System.out.println("Dang nhap tai khoan nhan vien: ");
                    System.out.print("ID nhan vien: ");
                    String id = input.nextLine();
                    System.out.print("Password: ");
                    String pass = input.nextLine();
                    if (DSNV.dangNhap(id, pass) != null) {
                        int k;
                        while (true) {
                            System.out.print("Co muon ghi thong tin khach hang?(0;1): ");
                            k = error.inputIntNumberError(input.nextLine());
                            if (k <= 0 && k >= 1) {
                                System.out.println("Khong hop le, moi nhap lai.");
                            } else {
                                break;
                            }
                        }
                        if (k == 0) {
                            DSSP.BanHang(DSNV.dangNhap(id, pass), DSKH, null, DSHD, DSSP, DT);
                            DTT.updateDT(DT);
                        } else {
                            String mkh;
                            boolean again = false;
                            do {
                                System.out.print("Nhap ma khach hang: ");
                                mkh = input.nextLine();
                                if (DSKH.SearchKH(mkh) == null) {
                                    int opt2;
                                    while (true) {
                                        System.out.println("Khong tim thay khach hang.");
                                        System.out.print("1(Nhap lai);0(Bo qua): ");
                                        opt2 = error.inputIntNumberError(input.nextLine());
                                        if (opt2 < 0 || opt2 > 1) {
                                            System.out.println("Khong hop le, moi nhap lai.");
                                        } else {
                                            break;
                                        }
                                    }
                                    if (opt2 == 1) {
                                        again = true;
                                    } else {
                                        again = false;
                                        DSSP.BanHang(DSNV.dangNhap(id, pass), DSKH, null, DSHD, DSSP, DT);
                                        DTT.updateDT(DT);
                                    }
                                } else {
                                    again = false;
                                    DSSP.BanHang(DSNV.dangNhap(id, pass), DSKH, mkh, DSHD, DSSP, DT);
                                    if (DSKH.SearchKH(mkh).getDtinhluy() >= 21) {
                                        DSKH.SearchKH(mkh).setDtinhluy(0);
                                    }
                                    DTT.updateDT(DT);
                                }
                            } while (again == true);

                        }
                    } else {
                        System.out.println("Khong tim thay tai khoan.");
                    }
                    break;
                }

                case 4: {
                    QuanLyTKTT();
                    break;
                }

                case 5: {
                    System.out.println("Dang nhap tai khoan nhan vien: ");
                    System.out.print("ID nhan vien: ");
                    String id = input.nextLine();
                    System.out.print("Password: ");
                    String pass = input.nextLine();
                    if (DSNV.dangNhap(id, pass) != null) {
                        if (id.indexOf("NVM") == 0) {
                            QuanLyDT();
                        } else {
                            System.out.println("Khong du quyen de su dung chuc nang nay.");
                        }
                    } else {
                        System.out.println("Khong tim thay tai khoan.");
                        System.out.print("Nhan phim bat ki de tiep tuc.");
                        input.nextLine();
                    }
                    break;
                }

                case 0: {
                    break;
                }

            }

        } while (opt != 0);

        DSSP.GhiFile();
        DSNV.GhiFile();
        DSKH.GhiFile();
        DSPN.GhiFile();
        DSHD.GhiFile();
        DTT.GhiFile();
    }

    public static void QuanLySP(NhanVien a) {
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
                choice = error.inputIntNumberError(input.nextLine());
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
                    DSSP.NhapHang(a, DSPN, DSSP, DT, DTT); // a là 1 nhân viên
                    break;
                }

                case 0: {
                    break;
                }

            }

        } while (choice != 0);
    }

    public static void QuanLyNV(NhanVien a) {
        int choice;
        do {
            System.out.println("");
            System.out.println("+---------------------------------------+");
            System.out.println("|           QUAN LY NHAN VIEN           |");
            System.out.println("+---------------------------------------+");
            System.out.println("|1. Xuat danh sach nhan vien.           |");
            System.out.println("|2. Them nhan vien.                     |");
            System.out.println("|3. Sua thong tin nhan vien.            |");
            System.out.println("|4. Xoa nhan vien.                      |");
            System.out.println("|5. Tim kiem nhan vien.                 |");
            System.out.println("|6. Cham cong nhan vien                 |");
            System.out.println("|7. Sua thong tin luong                 |");
            System.out.println("|0. Tro ve menu chinh.                  |");
            System.out.println("+---------------------------------------+");
            do {
                System.out.print("Moi nhap lua chon: ");
                choice = error.inputIntNumberError(input.nextLine());
                if (choice < 0 || choice > 7) {
                    System.out.println("Lua chon khong hop le, moi nhap lai!");
                }
            } while (choice > 7 || choice < 0);

            switch (choice) {
                case 1: {
                    DSNV.XuatNV();
                    System.out.print("Nhan phim bat ki de tiep tuc.");
                    input.nextLine();
                    break;
                }

                case 2: {
                    DSNV.ThemNV();
                    break;
                }

                case 3: {
                    DSNV.SuaNV();
                    break;
                }

                case 4: {
                    DSNV.XoaNV();
                    break;
                }

                case 5: {
                    DSNV.LocNV();
                    break;
                }

                case 6: {
                    DSNV.BangLuong();
                    System.out.print("Nhan phim bat ki de tiep tuc.");
                    input.nextLine();
                    break;
                }

                case 7: {
                    DSNV.suaLuongCoBan();
                    break;
                }

                case 0: {
                    break;
                }
            }
        } while (choice != 0);
    }

    public static void QuanLyTKTT() {
        int choice;
        do {
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
                choice = error.inputIntNumberError(input.nextLine());
                if (choice < 0 || choice > 5) {
                    System.out.println("Lua chon khong hop le, moi nhap lai!");
                }
            } while (choice > 5 || choice < 0);

            switch (choice) {
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
                    System.out.println("");
                    break;
                }

                case 0: {
                    break;
                }
            }
        } while (choice != 0);
    }

    public static void QuanLyDT() {
        int choice;
        do {
            System.out.println("");
            System.out.println("+---------------------------------------+");
            System.out.println("|            QUAN LY DOANH THU          |");
            System.out.println("+---------------------------------------+");
            System.out.println("|1. Lich su phieu nhap                  |");
            System.out.println("|2. Lich su hoa don                     |");
            System.out.println("|3. Thong ke doanh thu                  |");
            System.out.println("|0. Tro ve menu chinh.                  |");
            System.out.println("+---------------------------------------+");
            do {
                System.out.print("Moi nhap lua chon: ");
                choice = error.inputIntNumberError(input.nextLine());
                if (choice < 0 || choice > 3) {
                    System.out.println("Lua chon khong hop le, moi nhap lai!");
                }
            } while (choice > 3 || choice < 0);

            switch (choice) {
                case 1: {
                    DSPN.xemPhieuNhap();
                    break;
                }

                case 2: {
                    DSHD.xemHoaDon();
                    break;
                }

                case 3: {
                    DTT.thongKe();
                    System.out.print("Nhan phim bat ki de tiep tuc.");
                    input.nextLine();
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
// them bieu thuc chinh quy class date