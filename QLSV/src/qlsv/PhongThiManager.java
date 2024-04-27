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
public class PhongThiManager {
    private ArrayList<PhongThi> danhSachPhongThi;

    public PhongThiManager() {
        danhSachPhongThi = new ArrayList<>();
    }
    
    public void nhapDanhSachPhongThi(Scanner scanner) {
        System.out.print("Nhập số lượng phòng thi: ");
        int soLuong = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng trống
        for (int i = 0; i < soLuong; i++) {
            System.out.println("Nhập thông tin phòng thi thứ " + (i + 1) + ":");
            System.out.print("Nhập mã phòng thi: ");
            String maPhongThi = scanner.nextLine();
            System.out.print("Nhập địa điểm: ");
            String diaDiem = scanner.nextLine();
            System.out.print("Nhập số lượng sinh viên: ");
            int soLuongSinhVien = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng trống
            PhongThi phongThi = new PhongThi(maPhongThi, diaDiem, soLuongSinhVien);
            danhSachPhongThi.add(phongThi);

            // Nhập danh sách sinh viên cho phòng thi
            for (int j = 0; j < soLuongSinhVien; j++) {
                System.out.println("Nhập thông tin sinh viên thứ " + (j + 1) + " cho phòng thi " + maPhongThi + ":");
                SinhVien sinhVien = SinhVien.nhapSinhVien();
                phongThi.themSinhVien(sinhVien);
            }
        }
    }

    // In danh sách phòng thi và thí sinh
    public void inDanhSachPhongThi() {
        System.out.println("===== DANH SÁCH PHÒNG THI =====");
        for (PhongThi phongThi : danhSachPhongThi) {
            phongThi.hienThiThongTin();
        }
    }

    // Xóa thí sinh theo SBD
    public void xoaThiSinhTheoSBD(Scanner scanner) {
        System.out.print("Nhập SBD của thí sinh cần xóa: ");
        String sbd = scanner.nextLine();
        boolean found = false;
        for (PhongThi phongThi : danhSachPhongThi) {
            for (SinhVien sv : phongThi.getDanhSachSinhVien()) {
                if (sv.getSbd().equals(sbd)) {
                    phongThi.getDanhSachSinhVien().remove(sv);
                    System.out.println("Đã xóa thành công thí sinh có SBD " + sbd);
                    found = true;
                    break;
                }
            }
            if (found) break;
        }
        if (!found) {
            System.out.println("Không tìm thấy thí sinh có SBD " + sbd + " để xóa.");
        }
    }

    // Sửa thông tin thí sinh theo SBD
    public void suaThongTinThiSinhTheoSBD(Scanner scanner) {
        System.out.print("Nhập SBD của thí sinh cần sửa thông tin: ");
        String sbd = scanner.nextLine();
        boolean found = false;
        for (PhongThi phongThi : danhSachPhongThi) {
            for (SinhVien sv : phongThi.getDanhSachSinhVien()) {
                if (sv.getSbd().equals(sbd)) {
                    System.out.println("Nhập thông tin mới cho thí sinh có SBD " + sbd + ":");
                    SinhVien newSV = SinhVien.nhapSinhVien();
                    phongThi.getDanhSachSinhVien().remove(sv);
                    phongThi.themSinhVien(newSV);
                    System.out.println("Đã sửa thông tin thành công cho thí sinh có SBD " + sbd);
                    found = true;
                    break;
                }
            }
            if (found) break;
        }
        if (!found) {
            System.out.println("Không tìm thấy thí sinh có SBD " + sbd + " để sửa thông tin.");
        }
    }

    // Tìm kiếm và hiển thị thông tin thí sinh
    public void timKiemVaHienThiThongTinThiSinh(Scanner scanner) {
        System.out.println("Nhập thông tin thí sinh cần tìm kiếm:");
        SinhVien searchSV = SinhVien.nhapSinhVien();
        boolean found = false;
        for (PhongThi phongThi : danhSachPhongThi) {
            for (SinhVien sv : phongThi.getDanhSachSinhVien()) {
                if (sv.getSbd().equals(searchSV.getSbd())) {
                    System.out.println("Thông tin của thí sinh có SBD " + searchSV.getSbd() + ":");
                    sv.xuatSinhVien();
                    found = true;
                    break;
                }
            }
            if (found) break;
        }
        if (!found) {
            System.out.println("Không tìm thấy thông tin thí sinh.");
        }
    }

    // Sắp xếp danh sách thí sinh
    public void sapXepDanhSachThiSinh() {
        for (PhongThi phongThi : danhSachPhongThi) {
            Collections.sort(phongThi.getDanhSachSinhVien(), new Comparator<SinhVien>() {
                @Override
                public int compare(SinhVien sv1, SinhVien sv2) {
                    // So sánh theo tên
                    int result = sv1.getName().compareTo(sv2.getName());
                    if (result == 0) {
                        // Nếu tên giống nhau, so sánh theo SBD
                        return sv1.getSbd().compareTo(sv2.getSbd());
                    }
                    return result;
                }
            });
        }
        System.out.println("Đã sắp xếp danh sách thí sinh thành công.");
    }

    // Thí sinh có tổng điểm thi cao nhất
    public void hienThiThongTinThiSinhToanDiemCaoNhat() {
        SinhVien highestSV = null;
        double highestTotal = Double.MIN_VALUE;
        for (PhongThi phongThi : danhSachPhongThi) {
            for (SinhVien sv : phongThi.getDanhSachSinhVien()) {
                double total = sv.getToan() + sv.getLy() + sv.getHoa();
                if (total > highestTotal) {
                    highestTotal = total;
                    highestSV = sv;
                }
            }
        }
        if (highestSV != null) {
            System.out.println("Thông tin của thí sinh có tổng điểm cao nhất:");
            highestSV.xuatSinhVien();
        } else {
            System.out.println("Không có thí sinh nào trong danh sách.");
        }
    }

    // Thí sinh có tổng điểm thi thấp nhất
    public void hienThiThongTinThiSinhToanDiemThapNhat() {
        SinhVien lowestSV = null;
        double lowestTotal = Double.MAX_VALUE;
        for (PhongThi phongThi : danhSachPhongThi) {
            for (SinhVien sv : phongThi.getDanhSachSinhVien()) {
                double total = sv.getToan() + sv.getLy() + sv.getHoa();
                if (total < lowestTotal) {
                    lowestTotal = total;
                    lowestSV = sv;
                }
            }
        }
        if (lowestSV != null) {
            System.out.println("Thông tin của thí sinh có tổng điểm thấp nhất:");
            lowestSV.xuatSinhVien();
        } else {
            System.out.println("Không có thí sinh nào trong danh sách.");
        }
    }
}
