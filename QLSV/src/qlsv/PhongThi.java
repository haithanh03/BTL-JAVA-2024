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
public class PhongThi {
    private String maPhongThi;
    private String diaDiem;
    private int soLuongSinhVien;
    private ArrayList<SinhVien> danhSachSinhVien;

    public PhongThi(String maPhongThi, String diaDiem, int soLuongSinhVien) {
        this.maPhongThi = maPhongThi;
        this.diaDiem = diaDiem;
        this.soLuongSinhVien = soLuongSinhVien;
        this.danhSachSinhVien = new ArrayList<>();
    }

    public String getMaPhongThi() {
        return maPhongThi;
    }

    public void setMaPhongThi(String maPhongThi) {
        this.maPhongThi = maPhongThi;
    }

    public String getDiaDiem() {
        return diaDiem;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
    }

    public int getSoLuongSinhVien() {
        return soLuongSinhVien;
    }

    public void setSoLuongSinhVien(int soLuongSinhVien) {
        this.soLuongSinhVien = soLuongSinhVien;
    }

    public ArrayList<SinhVien> getDanhSachSinhVien() {
        return danhSachSinhVien;
    }

    public void setDanhSachSinhVien(ArrayList<SinhVien> danhSachSinhVien) {
        this.danhSachSinhVien = danhSachSinhVien;
    }

    // Thêm một sinh viên vào danh sách sinh viên của phòng thi
    public void themSinhVien(SinhVien sinhVien) {
        boolean trungSBD = false;
        for (SinhVien sv : danhSachSinhVien) {
            if (sv.getSbd().equals(sinhVien.getSbd())) {
                trungSBD = true;
                break;
            }
        }
        if (!trungSBD) {
            if (danhSachSinhVien.size() < soLuongSinhVien) {
                danhSachSinhVien.add(sinhVien);
                System.out.println("Thêm sinh viên thành công vào phòng " + maPhongThi);
            } else {
                System.out.println("Phòng " + maPhongThi + " đã đầy, không thể thêm sinh viên mới.");
            }
        } else {
            System.out.println("Sinh viên có SBD " + sinhVien.getSbd() + " đã tồn tại trong danh sách.");
        }
    }

    // Hiển thị thông tin của phòng thi
    public void hienThiThongTin() {
        System.out.println("Mã phòng thi: " + maPhongThi);
        System.out.println("Địa điểm: " + diaDiem);
        System.out.println("Số lượng sinh viên: " + soLuongSinhVien);
        System.out.println("Danh sách sinh viên:");
        for (SinhVien sv : danhSachSinhVien) {
            System.out.println("SBD: " + sv.getSbd() + ", Tên: " + sv.getName());
        }
    }
}
