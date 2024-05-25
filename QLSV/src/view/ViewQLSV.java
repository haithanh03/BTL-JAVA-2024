package view;

import java.awt.EventQueue;
import model.*;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
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
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.QLSVControl;

import javax.swing.JRadioButton;

public class ViewQLSV extends JFrame {

	public static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public QLSVModel modelQLSV;
	public JTextField textField;
	public JTable table;
	public JTextField tf_id;
	public JTextField tf_ten;
	public JTextField tf_ns;
	public JTextField tf_diem1;
	public JTextField tf_diem2;
	public JTextField tf_diem3;
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
		
		JMenuItem file_Open = new JMenuItem("Open");
		mn_File.add(file_Open);
		
		JMenuItem file_Close = new JMenuItem("Close");
		mn_File.add(file_Close);
		
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
		
		JLabel lb_maThiSinh = new JLabel("Mã Thí Sinh");
		lb_maThiSinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_maThiSinh.setBounds(397, 30, 89, 34);
		contentPane.add(lb_maThiSinh);
		
		textField = new JTextField();
		textField.setBounds(496, 39, 176, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton bt_Tim = new JButton("Tìm");
		bt_Tim.setFont(new Font("Tahoma", Font.PLAIN, 19));
		bt_Tim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bt_Tim.setBounds(740, 34, 89, 23);
		contentPane.add(bt_Tim);
		
		cbb_queQuan = new JComboBox();
		cbb_queQuan2 = new JComboBox();
		cbb_queQuan.addItem("");
		cbb_queQuan2.addItem("");
		cbb_queQuan.setBounds(139, 38, 204, 22);
		ArrayList<Tinh> listTinh= Tinh.getDSTinh();
		for(Tinh x : listTinh) {
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
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 Th\u00ED Sinh", "H\u1ECD T\u00EAn", "Qu\u00EA Qu\u00E1n", "Gi\u1EDBi T\u00EDnh", "Ng\u00E0y Sinh", "\u0110i\u1EC3m 1", "\u0110i\u1EC3m 2", "\u0110i\u1EC3m 3"
			}
		));
		table.setBounds(31, 139, 823, 287);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(31, 138, 837, 221);
		contentPane.add(scrollPane);
		
		JLabel lb_dsts_1 = new JLabel("Thông Tin Thí Sinh");
		lb_dsts_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_dsts_1.setBounds(31, 370, 132, 34);
		contentPane.add(lb_dsts_1);
		
		JLabel lb_id = new JLabel("Mã Thí Sinh");
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
		
		JLabel lb_diem1 = new JLabel("Điểm môn 1");
		lb_diem1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_diem1.setBounds(331, 430, 89, 34);
		contentPane.add(lb_diem1);
		
		tf_diem1 = new JTextField();
		tf_diem1.setColumns(10);
		tf_diem1.setBounds(433, 439, 119, 20);
		contentPane.add(tf_diem1);
		
		JLabel lb_diem2 = new JLabel("Điểm môn 2");
		lb_diem2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_diem2.setBounds(332, 460, 89, 34);
		contentPane.add(lb_diem2);
		
		tf_diem2 = new JTextField();
		tf_diem2.setColumns(10);
		tf_diem2.setBounds(434, 469, 119, 20);
		contentPane.add(tf_diem2);
		
		JLabel lb_diem3 = new JLabel("Điểm môn 3");
		lb_diem3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_diem3.setBounds(331, 489, 89, 34);
		contentPane.add(lb_diem3);
		
		tf_diem3 = new JTextField();
		tf_diem3.setColumns(10);
		tf_diem3.setBounds(433, 498, 119, 20);
		contentPane.add(tf_diem3);
		
		JButton bt_Them = new JButton("Thêm");
		bt_Them.setFont(new Font("Tahoma", Font.PLAIN, 19));
		bt_Them.setBounds(114, 538, 89, 23);
		contentPane.add(bt_Them);
		
		JButton bt_Xoa = new JButton("Xóa");
		bt_Xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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
		
		bt_Them.addActionListener(control);
		bt_Tim.addActionListener(control);
		bt_Xoa.addActionListener(control);
		bt_Update.addActionListener(control);
		bt_Huy.addActionListener(control);
		bt_luu.addActionListener(control);
		
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
		tf_diem1.setText("");
		tf_diem2.setText("");
		tf_diem3.setText("");
		cbb_queQuan2.setSelectedIndex(-1);
		gr_Gender.clearSelection();
	}
	public void themThiSinh(ThiSinh ts) {
		this.modelQLSV.insertTS(ts);
		DefaultTableModel model_table =(DefaultTableModel)table.getModel();
		model_table.addRow(new Object[] {
				ts.getMaThiSinh()+"",
				ts.getTenThiSinh(),
				ts.getQueQuan().getTenTinh(),
				(ts.isGioiTinh()?"Nam":"Nữ"),
				ts.getNgaySinh().getDate()+"/"+(ts.getNgaySinh().getMonth()+1)+"/"+(ts.getNgaySinh().getYear()+1900),
				ts.getDiemMon1()+"",
				ts.getDiemMon2()+"",
				ts.getDiemMon3()+""});
	}
	public void capNhatThiSinh(ThiSinh ts) {
		// TODO Auto-generated method stub
		
	}
	public void hienThiThiSinhDaChon() {
		DefaultTableModel model_table =(DefaultTableModel)table.getModel();
		int i_row = table.getSelectedRow();
		//int maThiSinh = Integer.valueOf(model_table.getValueAt(i_row, 0));
	}
}



