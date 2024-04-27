/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package qlsv;
import java.util.*;

/**
 *
 * @author ADMIN
 */
public class QLSV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhongThiManager phongThiManager = new PhongThiManager();

        boolean exit = false;
        while (!exit) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Nhập danh sách phòng thi và thí sinh");
            System.out.println("2. In danh sách phòng thi và thí sinh");
            System.out.println("3. Xóa thí sinh theo SBD");
            System.out.println("4. Sửa thông tin thí sinh theo SBD");
            System.out.println("5. Tìm kiếm và hiển thị thông tin thí sinh");
            System.out.println("6. Sắp xếp danh sách thí sinh");
            System.out.println("7. Thí sinh có tổng điểm thi cao nhất");
            System.out.println("8. Thí sinh có tổng điểm thi thấp nhất");
            System.out.println("9. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng trống

            try {
                switch (choice) {
                    case 1:
                        phongThiManager.nhapDanhSachPhongThi(scanner);
                        break;
                    case 2:
                        phongThiManager.inDanhSachPhongThi();
                        break;
                    case 3:
                        phongThiManager.xoaThiSinhTheoSBD(scanner);
                        break;
                    case 4:
                        phongThiManager.suaThongTinThiSinhTheoSBD(scanner);
                        break;
                    case 5:
                        phongThiManager.timKiemVaHienThiThongTinThiSinh(scanner);
                        break;
                    case 6:
                        phongThiManager.sapXepDanhSachThiSinh();
                        break;
                    case 7:
                        phongThiManager.hienThiThongTinThiSinhToanDiemCaoNhat();
                        break;
                    case 8:
                        phongThiManager.hienThiThongTinThiSinhToanDiemThapNhat();
                        break;
                    case 9:
                        exit = true;
                        System.out.println("Đã thoát chương trình.");
                        break;
                    default:
                        System.out.println("Vui lòng chọn một số từ 1 đến 9.");
                }
            } catch (Exception e) {
                System.out.println("Đã xảy ra lỗi: " + e.getMessage());
            }
        }
        scanner.close();
    }
    
}
