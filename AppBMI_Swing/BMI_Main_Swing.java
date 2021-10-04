package AppBMI_Swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.TitledBorder;

import javax.swing.border.EtchedBorder;
import javax.swing.JRadioButton;

public class BMI_Main_Swing {

	private JFrame frame;
	private JTextField txtChieucao;
	private JTextField txtCannang;
	private JTextField txtBMI;
	private JLabel lbDanhgia;
	private JTextField txtDanhgia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BMI_Main_Swing window = new BMI_Main_Swing();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BMI_Main_Swing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Kiểm tra chỉ số BMI");
		frame.setBounds(0,0, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbTitle = new JLabel("CHƯƠNG TRÌNH KIỂM TRA CHỈ SỐ BMI");
		lbTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbTitle.setBounds(132, 10, 306, 57);
		frame.getContentPane().add(lbTitle);
		
		JLabel lbChieucao = new JLabel("Chiều cao");
		lbChieucao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbChieucao.setBounds(40, 89, 77, 27);
		frame.getContentPane().add(lbChieucao);
		
		txtChieucao = new JTextField();
		txtChieucao.setBounds(127, 91, 168, 27);
		frame.getContentPane().add(txtChieucao);
		txtChieucao.setColumns(10);
		
		JLabel lbCannang = new JLabel("Cân nặng");
		lbCannang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbCannang.setBounds(40, 138, 77, 27);
		frame.getContentPane().add(lbCannang);
		
		txtCannang = new JTextField();
		txtCannang.setBounds(127, 140, 168, 27);
		frame.getContentPane().add(txtCannang);
		txtCannang.setColumns(10);
		
		JPanel pannelRegion = new JPanel();
		pannelRegion.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Region", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 0, 51)));
		pannelRegion.setBounds(319, 65, 214, 123);
		frame.getContentPane().add(pannelRegion);
		pannelRegion.setLayout(null);
		
		JRadioButton radAsian = new JRadioButton("Asian");
		radAsian.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radAsian.setBounds(24, 36, 103, 21);
		pannelRegion.add(radAsian);
		
		JRadioButton radNonAsian = new JRadioButton("Non Asian");
		radNonAsian.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radNonAsian.setBounds(24, 72, 103, 21);
		pannelRegion.add(radNonAsian);
		
		JButton btnBMI = new JButton("Tính chỉ số BMI");
		btnBMI.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBMI.setBounds(139, 198, 299, 33);
		frame.getContentPane().add(btnBMI);
		//

		//Sự kiện nút tính BMI

		btnBMI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strHeight = txtChieucao.getText();
				String strWeight = txtCannang.getText();
				double height = Double.parseDouble(strHeight);
				double weight = Double.parseDouble(strWeight);
				double BMIValue = weight / (height * height);
			    String result = "";
			    //kiểm tra radio asian
				boolean isAsian = false;
				if (radAsian.isSelected()) {
					isAsian = true;
					radNonAsian.setEnabled(true);
				} else {
					isAsian = false;
					radNonAsian.setEnabled(true);
				}
				if (BMIValue < 18.5) {
					result = "Bạn là người gầy";
			    } else if (BMIValue < 25) { //(18.5 - 24.9)
			    	result = "Bạn là người bình thường";
				    } 
			    	else if (BMIValue < 30) {  //(25.0 - 29.9)
			    		result = "Bạn bị thừa cân";
					    } 
			    		else if (BMIValue < 35) { //(30.0 - 34.9)
			    			result = "Bạn bị béo phì độ I";
						    }
			    			else if (BMIValue < 40) { //(35.0 - 39.9)
			    				result = "Bạn bị béo phì độ II";
							    } 
			    				else { //(>40)
			    					result = "Bạn bị béo phì độ III";
							    }
				txtBMI.setText(String.valueOf(BMIValue));
				if (isAsian) {
					txtDanhgia.setText(String.valueOf(result) + "Asian");
				} else {
					txtDanhgia.setText(String.valueOf(result) + "NonAsian");
				}

			}
		});
		
		JLabel lbBMI = new JLabel("Chỉ số BMI");
		lbBMI.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbBMI.setBounds(41, 252, 87, 22);
		frame.getContentPane().add(lbBMI);
		
		txtBMI = new JTextField();
		txtBMI.setBounds(127, 247, 406, 27);
		frame.getContentPane().add(txtBMI);
		txtBMI.setColumns(10);
		
		lbDanhgia = new JLabel("Đánh giá");
		lbDanhgia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbDanhgia.setBounds(40, 290, 87, 27);
		frame.getContentPane().add(lbDanhgia);
		
		txtDanhgia = new JTextField();
		txtDanhgia.setBounds(127, 292, 406, 27);
		frame.getContentPane().add(txtDanhgia);
		txtDanhgia.setColumns(10);
	}

}
