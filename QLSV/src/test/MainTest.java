package test;

import javax.swing.UIManager;

import view.ViewQLSV;

public class MainTest {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new ViewQLSV();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
