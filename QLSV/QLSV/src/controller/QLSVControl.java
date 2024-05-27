package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Date;

import javax.swing.JOptionPane;

import model.ThiSinh;
import model.Tinh;
import view.ViewQLSV;

public class QLSVControl implements ActionListener {
	private ViewQLSV view;
	
	public QLSVControl(ViewQLSV view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String nutNhan = e.getActionCommand();
		//JOptionPane.showMessageDialog(this.view, "Bạn vừa nhấn nút : "+nutNhan);
		if(nutNhan.equals("Thêm")) {
			this.view.xoaForm();
			this.view.modelQLSV.setLuaChon("Thêm");
		}
		else if(nutNhan.equals("Lưu")) {
			try {
				this.view.thucHienThemThiSinh();
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			}
		}
		else if(nutNhan.equals("Sửa")) {
			this.view.hienThiThiSinhDaChon();
		}
		else if(nutNhan.equals("Xóa")) {
			this.view.thucHienXoa();
		}
		else if(nutNhan.equals("Hủy bỏ")) {
			this.view.xoaForm();
		}
		else if(nutNhan.equals("Tìm")) {
			this.view.thucHienTim();
		}
		else if(nutNhan.equals("Hủy tìm")) {
			this.view.thucHienHuyTim();
		}
		else if(nutNhan.equals("About me")) {
			this.view.hienThiAbout();
		}
		else if(nutNhan.equals("Exit")) {
			this.view.thoatChuongTrinh();
		}
		else if(nutNhan.equals("Save")) {
			this.view.thucHienSaveFile();
		}
		else if(nutNhan.equals("Open")) {
			try {
				this.view.thucHienOpenFile();
			} catch (ClassNotFoundException | IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
