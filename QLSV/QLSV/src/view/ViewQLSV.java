package view;

import java.awt.EventQueue;
import model.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.TextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.QLSVControl;

import javax.swing.JRadioButton;

public class ViewQLSV extends JFrame {

	public static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public QLSVModel modelQLSV;
	public JTextField tf_maTSTim;
	public JTable _table;
	public JTextField tf_id;
	public JTextField tf_ten;
	public JTextField tf_ns;
	public JTextField tf_Khoa;
	public JTextField tf_nganh;
	public JTextField tf_k;
	public JComboBox cbb_queQuan;
	public ButtonGroup gr_Gender;
	public JComboBox cbb_queQuan2;
	public JRadioButton rbt_Nam;
	public JRadioButton rbt_Nu;

	public ViewQLSV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 907, 649);

		QLSVControl control = new QLSVControl(this);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mn_File = new JMenu("File");
		menuBar.add(mn_File);
		mn_File.addActionListener(control);

		JMenuItem file_Open = new JMenuItem("Open");
		mn_File.add(file_Open);
		file_Open.addActionListener(control);
		file_Open.addActionListener(control);

		JMenuItem file_Save = new JMenuItem("Save");
		mn_File.add(file_Save);

		JSeparator separator = new JSeparator();
		mn_File.add(separator);

		JMenuItem file_Exit = new JMenuItem("Exit");
		mn_File.add(file_Exit);

		JMenu mn_About = new JMenu("About");
		menuBar.add(mn_About);

		JMenuItem about_AboutMe = new JMenuItem("About me");
		mn_About.add(about_AboutMe);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lb_queQuan = new JLabel("Quê quán");
		lb_queQuan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_queQuan.setBounds(43, 30, 72, 34);
		contentPane.add(lb_queQuan);

		JLabel lb_maThiSinh = new JLabel("Mã Sinh Viên");
		lb_maThiSinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_maThiSinh.setBounds(352, 30, 89, 34);
		contentPane.add(lb_maThiSinh);

		tf_maTSTim = new JTextField();
		tf_maTSTim.setBounds(451, 39, 132, 20);
		contentPane.add(tf_maTSTim);
		tf_maTSTim.setColumns(10);

		JButton bt_Tim = new JButton("Tìm");
		bt_Tim.setFont(new Font("Tahoma", Font.PLAIN, 19));
		bt_Tim.addActionListener(control);
		bt_Tim.setBounds(637, 34, 89, 23);
		contentPane.add(bt_Tim);

		cbb_queQuan = new JComboBox();
		cbb_queQuan2 = new JComboBox();
		cbb_queQuan.addItem("");
		cbb_queQuan2.addItem("");
		cbb_queQuan.setBounds(139, 38, 157, 22);
		ArrayList<Tinh> listTinh = Tinh.getDSTinh();
		for (Tinh x : listTinh) {
			cbb_queQuan.addItem(x.getTenTinh());
			cbb_queQuan2.addItem(x.getTenTinh());
		}

		contentPane.add(cbb_queQuan);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(-49, 82, 1121, 20);
		contentPane.add(separator_1);

		JLabel lb_dsts = new JLabel("Danh sách thí sinh");
		lb_dsts.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_dsts.setBounds(31, 94, 125, 34);
		contentPane.add(lb_dsts);

		_table = new JTable();
		_table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 Th\u00ED Sinh", "H\u1ECD T\u00EAn", "Qu\u00EA Qu\u00E1n", "Gi\u1EDBi T\u00EDnh",
						"Ng\u00E0y Sinh", "Khoa", "Ngành", "Khóa" }));
		_table.setBounds(31, 139, 823, 287);

		JScrollPane scrollPane = new JScrollPane(_table);
		scrollPane.setBounds(31, 138, 837, 221);
		contentPane.add(scrollPane);

		JLabel lb_dsts_1 = new JLabel("Thông Tin Sinh Viên");
		lb_dsts_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_dsts_1.setBounds(31, 370, 172, 34);
		contentPane.add(lb_dsts_1);

		JLabel lb_id = new JLabel("Mã Sinh Viên");
		lb_id.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_id.setBounds(31, 399, 89, 34);
		contentPane.add(lb_id);

		tf_id = new JTextField();
		tf_id.setColumns(10);
		tf_id.setBounds(133, 408, 119, 20);
		contentPane.add(tf_id);

		JLabel lb_ten = new JLabel("Họ và Tên");
		lb_ten.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_ten.setBounds(31, 430, 89, 34);
		contentPane.add(lb_ten);

		tf_ten = new JTextField();
		tf_ten.setColumns(10);
		tf_ten.setBounds(133, 439, 119, 20);
		contentPane.add(tf_ten);

		JLabel lb_queQuan_1 = new JLabel("Quê quán");
		lb_queQuan_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_queQuan_1.setBounds(31, 460, 72, 34);
		contentPane.add(lb_queQuan_1);

		cbb_queQuan2.setBounds(133, 470, 119, 22);
		contentPane.add(cbb_queQuan2);

		JLabel lb_ns = new JLabel("Ngày Sinh");
		lb_ns.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_ns.setBounds(31, 489, 89, 34);
		contentPane.add(lb_ns);

		tf_ns = new JTextField();
		tf_ns.setColumns(10);
		tf_ns.setBounds(133, 498, 119, 20);
		contentPane.add(tf_ns);

		JLabel lb_gt = new JLabel("Giới Tính");
		lb_gt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_gt.setBounds(332, 399, 89, 34);
		contentPane.add(lb_gt);

		rbt_Nam = new JRadioButton("Nam");
		rbt_Nam.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rbt_Nam.setBounds(413, 407, 72, 23);
		contentPane.add(rbt_Nam);

		rbt_Nu = new JRadioButton("Nữ");
		rbt_Nu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rbt_Nu.setBounds(496, 405, 72, 23);
		contentPane.add(rbt_Nu);

		gr_Gender = new ButtonGroup();
		gr_Gender.add(rbt_Nam);
		gr_Gender.add(rbt_Nu);

		JLabel lb_khoa = new JLabel("Khoa");
		lb_khoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_khoa.setBounds(331, 430, 110, 34);
		contentPane.add(lb_khoa);

		tf_Khoa = new JTextField();
		tf_Khoa.setColumns(10);
		tf_Khoa.setBounds(433, 439, 119, 20);
		contentPane.add(tf_Khoa);

		JLabel lb_nganh = new JLabel("Ngành");
		lb_nganh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_nganh.setBounds(332, 460, 89, 34);
		contentPane.add(lb_nganh);

		tf_nganh = new JTextField();
		tf_nganh.setColumns(10);
		tf_nganh.setBounds(434, 469, 119, 20);
		contentPane.add(tf_nganh);

		JLabel lb_k = new JLabel("Khóa");
		lb_k.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_k.setBounds(331, 489, 89, 34);
		contentPane.add(lb_k);

		tf_k = new JTextField();
		tf_k.setColumns(10);
		tf_k.setBounds(433, 498, 119, 20);
		contentPane.add(tf_k);

		JButton bt_Them = new JButton("Thêm");
		bt_Them.setFont(new Font("Tahoma", Font.PLAIN, 19));
		bt_Them.setBounds(114, 538, 89, 23);
		contentPane.add(bt_Them);

		JButton bt_Xoa = new JButton("Xóa");
		bt_Xoa.addActionListener(control);
		bt_Xoa.setFont(new Font("Tahoma", Font.PLAIN, 19));
		bt_Xoa.setBounds(254, 538, 89, 23);
		contentPane.add(bt_Xoa);

		JButton bt_Update = new JButton("Sửa");
		bt_Update.setFont(new Font("Tahoma", Font.PLAIN, 19));
		bt_Update.setBounds(397, 538, 89, 23);
		contentPane.add(bt_Update);

		JButton bt_luu = new JButton("Lưu");
		bt_luu.setFont(new Font("Tahoma", Font.PLAIN, 19));
		bt_luu.setBounds(548, 538, 89, 23);
		contentPane.add(bt_luu);

		JButton bt_Huy = new JButton("Hủy");
		bt_Huy.setFont(new Font("Tahoma", Font.PLAIN, 19));
		bt_Huy.setBounds(698, 538, 89, 23);
		contentPane.add(bt_Huy);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(-292, 370, 1427, 20);
		contentPane.add(separator_1_1);

		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(-28, 529, 1121, 20);
		contentPane.add(separator_1_2);

		JButton bt_huyTim = new JButton("Hủy tìm");
		bt_huyTim.addActionListener(control);
		bt_huyTim.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bt_huyTim.setBounds(749, 35, 103, 23);
		contentPane.add(bt_huyTim);

		bt_Them.addActionListener(control);
		bt_Tim.addActionListener(control);
		bt_Xoa.addActionListener(control);
		bt_Update.addActionListener(control);
		bt_Huy.addActionListener(control);
		bt_luu.addActionListener(control);
		
		file_Open.addActionListener(control);
		file_Exit.addActionListener(control);
		file_Save.addActionListener(control);
		
		about_AboutMe.addActionListener(control);
		mn_About.addActionListener(control);

		this.init();
	}

	public void init() {
		this.modelQLSV = new QLSVModel();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void xoaForm() {
		tf_id.setText("");
		tf_ten.setText("");
		tf_ns.setText("");
		tf_Khoa.setText("");
		tf_nganh.setText("");
		tf_k.setText("");
		cbb_queQuan2.setSelectedIndex(-1);
		gr_Gender.clearSelection();
	}

	public void themThiSinhVaoTable(ThiSinh ts) {
		DefaultTableModel model_table = (DefaultTableModel) _table.getModel();
		model_table.addRow(new Object[] { ts.getMaThiSinh() + "", ts.getTenThiSinh(), ts.getQueQuan().getTenTinh(),
				(ts.isGioiTinh() ? "Nam" : "Nữ"),
				ts.getNgaySinh().getDate() + "/" + (ts.getNgaySinh().getMonth() + 1) + "/"
						+ (ts.getNgaySinh().getYear() + 1900),
				ts.getDiemMon1() + "", ts.getDiemMon2() + "", ts.getDiemMon3() + "" });
	}

	public void themHoacCapNhatThiSinh(ThiSinh ts) {
		DefaultTableModel model_table = (DefaultTableModel) _table.getModel();
		if (!this.modelQLSV.kiemTraTonTai(ts)) {
			this.modelQLSV.insertTS(ts);
			this.themThiSinhVaoTable(ts);
		} else {
			this.modelQLSV.updateTS(ts);
			int soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				if (id.equals(ts.getMaThiSinh() + "")) {
					model_table.setValueAt(ts.getMaThiSinh() + "", i, 0);
					model_table.setValueAt(ts.getTenThiSinh(), i, 1);
					model_table.setValueAt(ts.getQueQuan().getTenTinh(), i, 2);
					model_table.setValueAt((ts.isGioiTinh() ? "Nam" : "Nữ"), i, 3);
					model_table.setValueAt(ts.getNgaySinh().getDate() + "/" + (ts.getNgaySinh().getMonth() + 1) + "/"
							+ (ts.getNgaySinh().getYear() + 1900), i, 4);
					model_table.setValueAt(ts.getDiemMon1(), i, 5);
					model_table.setValueAt(ts.getDiemMon2() + "", i, 6);
					model_table.setValueAt(ts.getDiemMon3() + "", i, 7);
				}
			}
		}
	}

	public ThiSinh getThiSinhDangChon() {
		DefaultTableModel model_table = (DefaultTableModel) _table.getModel();
		int i_row = _table.getSelectedRow();
		if (i_row == -1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn một thí sinh!");
			return null;
		}
		int maThiSinh = Integer.valueOf(model_table.getValueAt(i_row, 0) + "");
		String tenThiSinh = model_table.getValueAt(i_row, 1) + "";
		Tinh tinh = Tinh.getTinhByTen(model_table.getValueAt(i_row, 2) + "");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date ngaySinh = null;
		try {
			ngaySinh = dateFormat.parse(model_table.getValueAt(i_row, 4) + "");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		String textGioiTinh = model_table.getValueAt(i_row, 4) + "";
		boolean gioiTinh = textGioiTinh.equals("Nam");
		String diemMon1 = model_table.getValueAt(i_row, 5) + "";
		String diemMon2 = model_table.getValueAt(i_row, 6) + "";
		String diemMon3 = model_table.getValueAt(i_row, 7) + "";
		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
		return ts;
	}

	public void hienThiThiSinhDaChon() {
		ThiSinh ts = getThiSinhDangChon();
		if (ts == null) {
			return;
		}
		this.tf_id.setText(ts.getMaThiSinh() + "");
		this.tf_ten.setText(ts.getTenThiSinh());
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date ngaySinh = null;
		try {
			ngaySinh = dateFormat.parse(ts.getNgaySinh() + "");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.tf_ns.setText(ngaySinh + "");
		this.cbb_queQuan2.setSelectedItem(ts.getQueQuan().getTenTinh());
		if (ts.isGioiTinh()) {
			this.rbt_Nam.setSelected(true);
		} else {
			this.rbt_Nu.setSelected(true);
		}
		this.tf_Khoa.setText(ts.getDiemMon1() + "");
		this.tf_nganh.setText(ts.getDiemMon2() + "");
		this.tf_k.setText(ts.getDiemMon3() + "");
	}

	public void thucHienXoa() {
		DefaultTableModel model_table = (DefaultTableModel) _table.getModel();
		int i_row = _table.getSelectedRow();
		ThiSinh ts = getThiSinhDangChon();
		if (ts == null) {
			return;
		}
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa dong đã chọn ?");
		if (luaChon == JOptionPane.YES_OPTION) {
			this.modelQLSV.removeTS(ts);
			model_table.removeRow(i_row);
		}
	}

	public void thucHienThemThiSinh() {
		try {
			int maThiSinh = Integer.parseInt(this.tf_id.getText());
			String tenThiSinh = this.tf_ten.getText();
			int queQuan = this.cbb_queQuan2.getSelectedIndex() - 1;
			Tinh tinh = Tinh.getTinhByID(queQuan);
			String ns = this.tf_ns.getText() + "";
			Date ngaySinh;
			try {
				String[] parts = ns.split("/");
				int ngay = Integer.parseInt(parts[0]);
				int thang = Integer.parseInt(parts[1]) - 1;
				int nam = Integer.parseInt(parts[2]) - 1900;
				ngaySinh = new Date(nam, thang, ngay);
			} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng ngày sinh (dd/MM/yyyy).", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			boolean gioiTinh = this.rbt_Nam.isSelected();
			String diemMon1 = this.tf_Khoa.getText();
			String diemMon2 = this.tf_nganh.getText();
			String diemMon3 = this.tf_k.getText();

			ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
			this.themHoacCapNhatThiSinh(ts);

			JOptionPane.showMessageDialog(this, "Thêm thí sinh thành công!");
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng số cho mã thí sinh và điểm các môn.",
					"Lỗi", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void thucHienTim() {
		this.thucHienHuyTim();
		int queQuan = this.cbb_queQuan.getSelectedIndex() - 1;
		String tenTS = this.tf_maTSTim.getText();
		DefaultTableModel model_table = (DefaultTableModel) _table.getModel();
		int soLuongDong = model_table.getRowCount();
		Set<Integer> cacIDTSCanXoa = new TreeSet<Integer>();
		if (queQuan >= 0) {
			Tinh tinhDaChon = Tinh.getTinhByID(queQuan);
			for (int i = 0; i < soLuongDong; i++) {
				String tenTinh = model_table.getValueAt(i, 2) + "";
				String id = model_table.getValueAt(i, 0) + "";
				if (!tenTinh.equals(tinhDaChon.getTenTinh())) {
					cacIDTSCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		if (tenTS.length() > 0) {
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				if (!id.equals(tenTS)) {
					cacIDTSCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		for (Integer x : cacIDTSCanXoa) {
			soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String idTrongTable = model_table.getValueAt(i, 0) + "";
				if (idTrongTable.equals(x.toString())) {
					try {
						model_table.removeRow(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
	}

	public void thucHienHuyTim() {
		while (true) {
			DefaultTableModel model_table = (DefaultTableModel) _table.getModel();
			int soLuongDong = model_table.getRowCount();
			if (soLuongDong == 0)
				break;
			else
				model_table.removeRow(0);
		}
		for (ThiSinh ts : this.modelQLSV.getDsThiSinh()) {
			this.themThiSinhVaoTable(ts);
		}
	}

	public void hienThiAbout() {
		JOptionPane.showMessageDialog(this, "Phần mềm quản lý sinh viên !");
	}

	public void thoatChuongTrinh() {
		int lc = JOptionPane.showConfirmDialog(this,
				"Muốn thoát khỏi chương trình ?", "Exit",
				JOptionPane.YES_NO_OPTION);
		if(lc==JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	public void saveFile(String path) {
		try {
			this.modelQLSV.setTenFile(path);
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for(ThiSinh ts : this.modelQLSV.getDsThiSinh()) {
				oos.writeObject(ts);
			}
			oos.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void thucHienSaveFile() {
		if(this.modelQLSV.getTenFile().length()>0) {
			saveFile(this.modelQLSV.getTenFile());
		}
		else {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if(returnVal==JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			}
		}
	}

	public void openFile(File file) {
		ArrayList<ThiSinh>ds = new ArrayList<ThiSinh>();
		try {
			this.modelQLSV.setTenFile(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ThiSinh ts = null;
			while((ts =(ThiSinh) ois.readObject())!=null) {
				ds.add(ts);
			}
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.modelQLSV.setDsThiSinh(ds);
	}
	
	public void thucHienOpenFile() throws ClassNotFoundException, IOException {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if(returnVal==JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file);
			thucHienHuyTim();
		}
	}
}




