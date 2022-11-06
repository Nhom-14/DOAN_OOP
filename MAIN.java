import java.util.Scanner;

import SANPHAM.DanhSachSanPham;

public class MAIN {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        DanhSachSanPham DSSP = new DanhSachSanPham();
        int opt;
        do {
            System.out.println("+---------------------------------------+");
            System.out.println("|               MAIN MENU               |");
            System.out.println("+---------------------------------------+");
            System.out.println("|1. Quan ly san pham.                   |");
            System.out.println("|2. Quan ly nhan vien.                  |");
            System.out.println("|3. Ban hang.                           |");
            System.out.println("|4. Quan ly tai khoan thanh vien.       |");
            System.out.println("|5. Quan ly doanh thu.                  |");
            System.out.println("|6. Thoat chuong trinh.                 |");
            System.out.println("+---------------------------------------+");
            do {
                System.out.print("Moi nhap lua chon: ");
                opt = Integer.parseInt(input.nextLine());
                if (opt > 6 || opt < 1) {
                    System.out.println("Lua chon khong hop le, moi nhap lai!");
                }
            } while (opt > 6 || opt < 1);

            switch (opt) {
                case 1: {
                    DSSP.Menu();
                }

                case 2: {
                    System.out.println("Quan ly nhan vien");
                }

                case 3: {
                    System.out.println("Ban hang");
                }

                case 4: {
                    System.out.println("Quan ly tai khoan thanh vien");
                }

                case 5: {
                    System.out.println("Thoat chuong trinh");
                }

            }
        } while (opt != 6);

    }
}