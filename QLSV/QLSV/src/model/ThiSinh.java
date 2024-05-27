package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class ThiSinh implements Serializable{
	private int maThiSinh;
	private String tenThiSinh;
	private Tinh queQuan;
	private Date ngaySinh;
	private boolean gioiTinh;
	private String diemMon1, diemMon2, diemMon3;
	public ThiSinh() {}
	public int getMaThiSinh() {
		return maThiSinh;
	}
	public void setMaThiSinh(int maThiSinh) {
		this.maThiSinh = maThiSinh;
	}
	public String getTenThiSinh() {
		return tenThiSinh;
	}
	public void setTenThiSinh(String tenThiSinh) {
		this.tenThiSinh = tenThiSinh;
	}
	public Tinh getQueQuan() {
		return queQuan;
	}
	public void setQueQuan(Tinh queQuan) {
		this.queQuan = queQuan;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getDiemMon1() {
		return diemMon1;
	}
	public void setDiemMon1(String diemMon1) {
		this.diemMon1 = diemMon1;
	}
	public String getDiemMon2() {
		return diemMon2;
	}
	public void setDiemMon2(String diemMon2) {
		this.diemMon2 = diemMon2;
	}
	public String getDiemMon3() {
		return diemMon3;
	}
	public void setDiemMon3(String diemMon3) {
		this.diemMon3 = diemMon3;
	}
	@Override
	public int hashCode() {
		return Objects.hash(diemMon1, diemMon2, diemMon3, gioiTinh, maThiSinh, ngaySinh, queQuan, tenThiSinh);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ThiSinh other = (ThiSinh) obj;
		return Objects.equals(diemMon1, other.diemMon1) && Objects.equals(diemMon2, other.diemMon2)
				&& Objects.equals(diemMon3, other.diemMon3) && gioiTinh == other.gioiTinh
				&& maThiSinh == other.maThiSinh && Objects.equals(ngaySinh, other.ngaySinh)
				&& Objects.equals(queQuan, other.queQuan) && Objects.equals(tenThiSinh, other.tenThiSinh);
	}
	public ThiSinh(int maThiSinh, String tenThiSinh, Tinh queQuan, Date ngaySinh, boolean gioiTinh, String diemMon1,
			String diemMon2, String diemMon3) {
		super();
		this.maThiSinh = maThiSinh;
		this.tenThiSinh = tenThiSinh;
		this.queQuan = queQuan;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.diemMon1 = diemMon1;
		this.diemMon2 = diemMon2;
		this.diemMon3 = diemMon3;
	};
	
}
