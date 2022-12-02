package BASE;

import java.util.Calendar;
import java.util.Scanner;

public class date {
    private int ngay;
    private int thang;
    private int nam;
    static Scanner input = new Scanner(System.in);

    public date() {
        ngay = 0;
        thang = 0;
        nam = 0;
    }

    public date(date orther) {
        this.ngay = orther.ngay;
        this.thang = orther.thang;
        this.nam = orther.nam;
    }

    public date(int d, int m, int y) {
        this.ngay = d;
        this.thang = m;
        this.nam = y;
    }

    public void Today() {
        Calendar t = Calendar.getInstance();
        nam = t.get(Calendar.YEAR);
        thang = t.get(Calendar.MONTH) + 1;
        ngay = t.get(Calendar.DAY_OF_MONTH);
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public void setNgay(int ngay) {
        this.ngay = ngay;
    }

    public int getNam() {
        return nam;
    }

    public int getNgay() {
        return ngay;
    }

    public int getThang() {
        return thang;
    }

    public void NhapDate() {
        boolean check = true;
        do {
            String s;
            while (true) {
                System.out.print("Nhap ngay thang nam (dd/mm/yy): ");
                s = input.nextLine();
                if(error.checkNgay(s)) {
                    break;
                } else {
                    System.out.println("Khong hop le, moi nhap lai.");
                }
            }
            String a[] = s.split("/");
            setNam(Integer.parseInt(a[2]));
            if (checkMonth(Integer.parseInt(a[1]))) {
                check = true;
                setThang(Integer.parseInt(a[1]));
                if (checkDay(Integer.parseInt(a[0]))) {
                    check = true;
                    setNgay(Integer.parseInt(a[0]));
                } else {
                    check = false;
                    System.out.println("Nhap sai thong tin, moi nhap lai!");
                }
            } else {
                check = false;
                System.out.println("Nhap sai thong tin, moi nhap lai!");
            }
        } while (check == false);
    }

    public String toString() {
        String s;
        if(ngay < 10) {
            s =  "0" + ngay + "/";
        } else {
            s = ngay + "/";
        }
        if(thang < 10) {
            s = s + "0" + thang + "/" + nam;
        } else {
            s = s + thang + "/" + nam;
        }
        return s;
    }

    public void Tachtt(String d) {
        String a[] = d.split("/");
        setNam(Integer.parseInt(a[2]));
        setThang(Integer.parseInt(a[1]));
        setNgay(Integer.parseInt(a[0]));
    }

    public boolean checkYear(int year) {
        return (((year % 4 == 0) && (year % 100 != 0)) ||
                (year % 400 == 0));
    }

    public boolean checkMonth(int month) {
        if (month > 12 || month < 1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkDay(int d) {
        boolean day = true;
        int DayinT2;
        if (checkYear(nam)) {
            DayinT2 = 29;
        } else {
            DayinT2 = 28;
        }
        switch (thang) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12: {
                if (d > 30 || d < 1) {
                    day = false;
                }
                break;
            }
            case 4:
            case 6:
            case 9:
            case 11: {

                if (d > 31 || d < 1) {
                    day = false;
                }
                break;
            }
            case 2: {
                if (d > DayinT2 || d < 1) {
                    day = false;
                }
            }
        }
        return day;
    }

    public Boolean equals(date b) {
        if(this.ngay == b.ngay && this.thang == b.thang && this.nam == b.nam) {
            return true;
        } else {
            return false;
        }
    }
}