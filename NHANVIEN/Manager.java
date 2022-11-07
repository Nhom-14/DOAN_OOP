import java.util.Scanner;

public class Manager extends NhanVien{
    Scanner scn = new Scanner(System.in);
    private int CapBac;
    private int LuongCoBan;
    public Manager()
    {
        super();
        CapBac = 0;
        LuongCoBan = 0;
    }
    public Manager(String t, date ns, boolean gt, Address dc, String sdt,String MaNV, int SoNgayNghi,int CapBac,int LuongCoBan)
    {
        super(t, ns, gt, dc, sdt, MaNV, SoNgayNghi);
        this.CapBac = CapBac;
        this.LuongCoBan = LuongCoBan;
    }
    public int getCapBac() {
        return CapBac;
    }
    public void setCapBac(int capBac) {
        System.out.println("Nhap cap bac: ");
        CapBac = scn.nextInt();
        this.CapBac = capBac;
    }
    public int getLuongCoBan() {
        return LuongCoBan;
    }
    public void setLuongCoBan(int luongCoBan) {
        System.out.println("Nhap luong co ban: ");
        LuongCoBan = scn.nextInt();
        this.LuongCoBan = luongCoBan;
    }
    @Override
    public void nhapNV()
    {
        super.nhapNV();
        setCapBac(CapBac);
        setLuongCoBan(LuongCoBan);
    }
    @Override
    public void xuatNV()
    {
        super.xuatNV();
        System.out.println("\tCapBac: "+getCapBac()+"\tLuong co ban: "+getLuongCoBan());
    }
    @Override
    public double TinhLuong()
    {
        if (getCapBac() == 1)
            return getLuongCoBan()*1.5;
        if (getCapBac() == 2)
            return getLuongCoBan()*2;
        if (getCapBac() == 3)
            return getLuongCoBan()*3;
        else return -1;
    }
    @Override
    public String toString() {
        return super.toString() + ";" + getCapBac() + "," +getLuongCoBan();
    }
}
