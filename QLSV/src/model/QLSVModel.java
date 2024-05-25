package model;

import java.util.ArrayList;

public class QLSVModel {
	private ArrayList<ThiSinh> dsThiSinh;
	private String luaChon;

	public QLSVModel() {
		dsThiSinh = new ArrayList<ThiSinh>();
		this.luaChon="";
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
}





