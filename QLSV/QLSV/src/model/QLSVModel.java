package model;

import java.util.ArrayList;

public class QLSVModel {
	private ArrayList<ThiSinh> dsThiSinh;
	private String luaChon;
	String tenFile;

	public QLSVModel() {
		dsThiSinh = new ArrayList<ThiSinh>();
		this.luaChon="";
		this.tenFile="";
	}
	public String getTenFile() {
		return tenFile;
	}
	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}
	public String getLuaChon() {
		return luaChon;
	}
	public void setLuaChon(String luaChon) {
		this.luaChon = luaChon;
	}
	public QLSVModel(ArrayList<ThiSinh> dsThiSinh) {
		this.dsThiSinh=dsThiSinh;
	}
	public ArrayList<ThiSinh> getDsThiSinh() {
		return dsThiSinh;
	}
	public void setDsThiSinh(ArrayList<ThiSinh> dsThiSinh) {
		this.dsThiSinh = dsThiSinh;
	}
	public void insertTS(ThiSinh ts) {
		this.dsThiSinh.add(ts);
	}
	public void removeTS(ThiSinh ts) {
		this.dsThiSinh.remove(ts);
	}
	public void updateTS(ThiSinh ts) {
		this.dsThiSinh.remove(ts);
		this.dsThiSinh.add(ts);
	}
	public boolean kiemTraTonTai(ThiSinh ts) {
		for(ThiSinh x : dsThiSinh) {
			if(x.getMaThiSinh()==ts.getMaThiSinh()) return true;
		}
		return false;
	}
}





