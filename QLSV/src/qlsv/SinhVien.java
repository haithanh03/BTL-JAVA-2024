/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlsv;

import java.util.*;

/**
 *
 * @author ADMIN
 */
public class SinhVien {
    private String Sbd;
    private String Name;
    private double Toan;
    private double Ly;
    private double Hoa;

    public String getSbd() {
        return Sbd;
    }

    public void setSbd(String Sbd) {
        this.Sbd = Sbd;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public double getToan() {
        return Toan;
    }

    public void setToan(double Toan) {
        this.Toan = Toan;
    }

    public double getLy() {
        return Ly;
    }

    public void setLy(double Ly) {
        this.Ly = Ly;
    }

    public double getHoa() {
        return Hoa;
    }

    public void setHoa(double Hoa) {
        this.Hoa = Hoa;
    }

    public SinhVien(String Sbd, String Name, double Toan, double Ly, double Hoa) {
        this.Sbd = Sbd;
        this.Name = Name;
        this.Toan = Toan;
        this.Ly = Ly;
        this.Hoa = Hoa;
    }

    public SinhVien() {
    }
    
    public static SinhVien nhapSinhVien() {
        Scanner scanner = new Scanner(System.in);
        SinhVien sinhVien = new SinhVien();

        // Nhập mã sinh viên
        while (true) {
            System.out.print("Nhập số báo danh: ");
            String sbd = scanner.nextLine().trim();
            if (!sbd.isEmpty()) {
                sinhVien.setSbd(sbd);
                break;
            } else {
                System.out.println("Mã sinh viên không được để trống.");
            }
        }

        // Nhập tên sinh viên
        while (true) {
            System.out.print("Nhập họ và tên: ");
            String name = scanner.nextLine().trim();
            if (!name.isEmpty()) {
                sinhVien.setName(name);
                break;
            } else {
                System.out.println("Tên sinh viên không được để trống.");
            }
        }

        // Nhập điểm Toán
        double toan;
        do {
            System.out.print("Nhập điểm Toán (từ 0 đến 10): ");
            toan = scanner.nextDouble();
            scanner.nextLine(); // Đọc bỏ dòng trống sau khi nhập số
        } while (toan < 0 || toan > 10);
        sinhVien.setToan(toan);

        // Nhập điểm Lý
        double ly;
        do {
            System.out.print("Nhập điểm Lý (từ 0 đến 10): ");
            ly = scanner.nextDouble();
            scanner.nextLine(); // Đọc bỏ dòng trống sau khi nhập số
        } while (ly < 0 || ly > 10);
        sinhVien.setLy(ly);

        // Nhập điểm Hóa
        double hoa;
        do {
            System.out.print("Nhập điểm Hóa (từ 0 đến 10): ");
            hoa = scanner.nextDouble();
            scanner.nextLine(); // Đọc bỏ dòng trống sau khi nhập số
        } while (hoa < 0 || hoa > 10);
        sinhVien.setHoa(hoa);

        return sinhVien;
    }
    
    public void xuatSinhVien() {
        System.out.printf("%-15s%-30s%-10.2f%-10.2f%-10.2f\n", Sbd, Name, Toan, Ly, Hoa);
    }
    
}
