import java.util.Scanner;

public abstract class NhanVien extends ConNguoi {
    Scanner scn = new Scanner(System.in);
    protected String MaNV;
    protected int SoNgayNghi;
    private Account tk;
    public NhanVien()
    {
        super();
        MaNV = null;
        SoNgayNghi = 0;
        tk = new Account();
    }
    public NhanVien(String t, date ns, boolean gt, Address dc, String sdt,String MaNV, int SoNgayNghi)
    {
        super(t, ns, gt, dc, sdt);
        this.MaNV = MaNV;
        this.SoNgayNghi = SoNgayNghi;
    }
    public String getMaNV() {
        return MaNV;
    }
    public void setMaNV(String maNV) {
        System.out.println("Nhap ma nhan vien: ");
        maNV=scn.nextLine();
        this.MaNV = maNV;
    }
    public int getSoNgayNghi() {
        return SoNgayNghi;
    }
    public void setSoNgayNghi(int SoNgayNghi) {
        System.out.println("Nhap so ngay nghi: ");
        SoNgayNghi=scn.nextInt();
        this.SoNgayNghi = SoNgayNghi;
    }
    public void DangNhap()
    {
        tk.NhapTK();
        /*int choose;
        System.out.println("Nhap quyen cua ban: ");
        System.out.println("1. Admin");
        System.out.println("2. PartTime");
        System.out.println("3. FullTime");
        System.out.println("4. Manager");
        choose = scn.nextInt()*/
    }
    public void nhapNV()
    {
        super.nhap();
        setMaNV(MaNV);
        setSoNgayNghi(SoNgayNghi);
    }
    @Override
    public String toString() {
        return super.toString() + "," + getMaNV();
    }
    public abstract double TinhLuong();

    public void xuatNV()
    {
        System.out.print("Ma nhan vien: "+getMaNV() + "\tHo ten : " + getTen() + "\tNam sinh: "+getNgaySinh()+"\tSo dien thoai: "+getSDT() + "\tSo ngay nghi: " + getSoNgayNghi());
    }
}