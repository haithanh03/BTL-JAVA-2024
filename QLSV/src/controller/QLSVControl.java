package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
				int maThiSinh = Integer.valueOf(this.view.tf_id.getText());
				String tenThiSinh= this.view.tf_ten.getText();
				int queQuan=this.view.cbb_queQuan2.getSelectedIndex();
				Tinh tinh = Tinh.getTinhByID(queQuan);
				Date ngaySinh = new Date(this.view.tf_ns.getText());
				boolean gioiTinh = true;
				String chonGioiTinh = this.view.gr_Gender.getSelection()+"";
				if(chonGioiTinh.equals("Nam")) {
					gioiTinh=true;
				}
				else {
					gioiTinh=false;
				}
				float diemMon1 = Float.valueOf(this.view.tf_diem1.getText());
				float diemMon2 = Float.valueOf(this.view.tf_diem2.getText());
				float diemMon3 = Float.valueOf(this.view.tf_diem3.getText());
				
				ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
				if(this.view.modelQLSV.getLuaChon().equals("Thêm")||this.view.modelQLSV.getLuaChon().equals("")) {
					this.view.themThiSinh(ts);
				}
				else if(this.view.modelQLSV.getLuaChon().equals("Cập nhật")) {
					this.view.capNhatThiSinh(ts);
				}
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			}
		}
		else if(nutNhan.equals("Cập nhật")) {
			this.view.hienThiThiSinhDaChon();
		}
	}

}
