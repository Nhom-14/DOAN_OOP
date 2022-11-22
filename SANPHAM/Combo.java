package SANPHAM;

public class Combo extends SanPham {
    String[] arrSP;
    private int n;

    public Combo() {
        this.arrSP = new String[n];
        this.n = 0;
        TheLoai = "Combo";
    }

    public Combo(String arrSP[], int n) {
        this.arrSP = arrSP;
        this.n = n;
    }

    public Combo(Combo orther) {
        super(orther.MaSP, orther.TenSP, orther.TheLoai, orther.GiaBan, orther.GiaNhap, orther.SoLuong);
        this.n = orther.n;
        this.arrSP = new String[n];
        for (int i = 0; i < this.n; i++) {
            this.arrSP[i] = orther.arrSP[i];
        }
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public String[] getArrSP() {
        return arrSP;
    }

    public void setMaSP(String Masp) {
        String ddf = "^C\\d{3}$";
        boolean Inputtrue = false;
        do {
            if (super.checkMasp(ddf, Masp) == true) {
                Inputtrue = true;
                super.setMaSP(Masp);
            } else {
                System.out.println("Nhap sai moi nhap lai! ");
                System.out.print("Nhap ma san pham(Food:F___,Drink:D___,Combo:C___): ");
                Masp = input.nextLine();
            }
        } while (Inputtrue == false);
    }

    @Override
    public void nhapSP() {
        System.out.print("Nhap ma Combo(C___): ");
        setMaSP(input.nextLine());
        System.out.print("Nhap ten Combo: ");
        setTenSP(input.nextLine() + " bao gom:");
        System.out.print("Nhap so luong san pham trong combo: ");
        setN(Integer.parseInt(input.nextLine()));
        arrSP = new String[n];
        setGiaBan();
        setGiaNhap();
    }

    public void TachTen(int n, String w[]) {
        this.n = n - 1;
        arrSP = new String[this.n];
        setTenSP(w[0]);
        for (int i = 0; i < this.n; i++) {
            arrSP[i] = w[i + 1];
        }
    }

    @Override
    public void xuatSP() {
        System.out.print("|");
        System.out.printf("%-8s", MaSP);
        System.out.print("|");
        System.out.printf("%-10s", TheLoai);
        System.out.print("|");
        System.out.printf("%-30s", TenSP);
        System.out.print("|");
        System.out.printf("%-10s", GiaBan);
        System.out.print("|");
        System.out.printf("%-10s", GiaNhap);
        System.out.print("|");
        System.out.printf("%-10s", SoLuong);
        System.out.print("|\n");
        for (int i = 0; i < n; i++) {
            System.out.print("|");
            System.out.printf("%-8s", "");
            System.out.print("|");
            System.out.printf("%-10s", "");
            System.out.print("|");
            System.out.printf("%-30s", arrSP[i]);
            System.out.print("|");
            System.out.printf("%-10s", "");
            System.out.print("|");
            System.out.printf("%-10s", "");
            System.out.print("|");
            System.out.printf("%-10s", "");
            System.out.print("|\n");
        }
    }

    @Override
    public void toTable() {
        Title();
        System.out.print("|");
        System.out.printf("%-8s", MaSP);
        System.out.print("|");
        System.out.printf("%-10s", TheLoai);
        System.out.print("|");
        System.out.printf("%-30s", TenSP);
        System.out.print("|");
        System.out.printf("%-10s", GiaBan);
        System.out.print("|");
        System.out.printf("%-10s", GiaNhap);
        System.out.print("|");
        System.out.printf("%-10s", SoLuong);
        System.out.print("|\n");
        for (int i = 0; i < n; i++) {
            System.out.print("|");
            System.out.printf("%-8s", "");
            System.out.print("|");
            System.out.printf("%-10s", "");
            System.out.print("|");
            System.out.printf("%-30s", arrSP[i]);
            System.out.print("|");
            System.out.printf("%-10s", "");
            System.out.print("|");
            System.out.printf("%-10s", "");
            System.out.print("|");
            System.out.printf("%-10s", "");
            System.out.print("|\n");
        }
        System.out.println("+--------+----------+------------------------------+----------+----------+----------+");
    }

    @Override
    public void xuatMenu() {
        System.out.print("|");
        System.out.printf("%-8s", MaSP);
        System.out.printf("%-30s", TenSP);
        System.out.printf("%10s", GiaBan);
        System.out.printf("%10s", SoLuong);
        System.out.println("|");
        for (int i = 0; i < arrSP.length; i++) {
            System.out.print("|");
            System.out.printf("%-8s", "");
            System.out.printf("%-30s", arrSP[i]);
            System.out.printf("%10s", "");
            System.out.printf("%10s", "");
            System.out.println("|");
        }
        System.out.println("+----------------------------------------------------------+");
    }

    @Override
    public String toString() {
        String s = MaSP + "," + TenSP;
        for (int i = 0; i < n; i++) {
            s = s + "#" + arrSP[i];
        }
        s = s + "," + GiaBan + "," + GiaNhap + "," + SoLuong;
        return s;
    }

    @Override
    public void TachTT(String[] word) {
        setMaSP(word[0]);
        setTheLoai("Combo");
        String w[] = word[1].split("#");
        TachTen(w.length, w);
        setGiaBan(Double.parseDouble(word[2]));
        setGiaNhap(Double.parseDouble(word[3]));
        setSoLuong(Integer.parseInt(word[4]));
    }
}
