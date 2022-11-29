package DOANHTHU;

import BASE.*;

public class DoanhThu {
    private date ngay;
    private double out;
    private double in;

    public DoanhThu() {
        ngay = new date();
        ngay.Today();
        out = 0;
        in = 0;
    }

    public DoanhThu(date d, double o, double i) {
        this.ngay = new date(d);
        this.out = o;
        this.in = i;
    }

    public DoanhThu(DoanhThu orther) {
        this.ngay = new date(orther.ngay);
        this.in = orther.in;
        this.out = orther.out;   
    }

    public void copyDT(DoanhThu orther) {
        ngay.setNgay(orther.ngay.getNgay());
        ngay.setThang(orther.ngay.getThang());
        ngay.setNam(orther.ngay.getNam());
        this.in = orther.in;
        this.out = orther.out;
    }

    public void setNgay(date ngay) {
        this.ngay = ngay;
    }

    public date getNgay() {
        return ngay;
    }

    public void setIn(double in) {
        this.in = in;
    }

    public double getIn() {
        return in;
    }

    public void setOut(double out) {
        this.out = out;
    }

    public double getOut() {
        return out;
    }

    public String toString() {
        return ngay.toString() + "," + out + "," + in;
    }

    public void tachTT(String[] word) {
        ngay.Tachtt(word[0]);
        setOut(Double.parseDouble(word[1]));
        setIn(Double.parseDouble(word[2]));
    }

    public void moreIN(double in1) { //Cong them vao tien ban hang
        in = in + in1;
    }

    public void moreOut(double out1) { //Cong them vao tien nhap hang
        out = out + out1;
    }

    public void xuatDT() {
        System.out.print("|");
        System.out.printf("%-12s", ngay.toString());
        System.out.print("|");
        System.out.printf("%-20.2f", out);
        System.out.print("|");
        System.out.printf("%-20.2f", in);
        System.out.print("|");
        System.out.printf("%-20.2f", in-out);
        System.out.println("|");
    }
}
