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
import javax.swing.ButtonGroup;

public class BMI_Main_Swing {

	private JFrame frame;
	private JTextField txtChieucao;
	private JTextField txtCannang;
	private JTextField txtBMI;
	private JLabel lbDanhgia;
	private JTextField txtDanhgia;
	private final ButtonGroup buttonGroup = new ButtonGroup();

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
		
		JLabel lbChieucao = new JLabel("Chiều cao (m)");
		lbChieucao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbChieucao.setBounds(31, 89, 100, 27);
		frame.getContentPane().add(lbChieucao);
		
		txtChieucao = new JTextField();
		txtChieucao.setBounds(141, 91, 168, 27);
		frame.getContentPane().add(txtChieucao);
		txtChieucao.setColumns(10);
		
		JLabel lbCannang = new JLabel("Cân nặng (kg)");
		lbCannang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbCannang.setBounds(31, 138, 100, 27);
		frame.getContentPane().add(lbCannang);
		
		txtCannang = new JTextField();
		txtCannang.setBounds(141, 140, 168, 27);
		frame.getContentPane().add(txtCannang);
		txtCannang.setColumns(10);
		
		JPanel pannelRegion = new JPanel();
		pannelRegion.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Region", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 0, 51)));
		pannelRegion.setBounds(319, 65, 214, 123);
		frame.getContentPane().add(pannelRegion);
		pannelRegion.setLayout(null);
		
		JRadioButton radAsian = new JRadioButton("Asian");
		buttonGroup.add(radAsian);
		radAsian.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radAsian.setBounds(24, 36, 103, 21);
		pannelRegion.add(radAsian);
		radAsian.setSelected(true);
		
		JRadioButton radNonAsian = new JRadioButton("Non Asian");
		buttonGroup.add(radNonAsian);
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
			    //kiểm tra radio asian vs nonAsian
			    if (radAsian.isSelected()) { // trường hợp asian 
			    	if (BMIValue < 18.5) {
						result = "Bạn là người gầy";
				    } else if (BMIValue < 23) { //(18.5 - 22.9)
				    	result = "Bạn là người bình thường";
					    } else if (BMIValue < 25 ) { //23 - 24.9
					    	result = "Bạn bị thừa cân";
						    } 
					    	else if (BMIValue < 30) {  //(25.0 - 29.9)
					    		result = "Bạn bị béo phì";
							    } 
					    		else if (BMIValue <= 40) { //(30.0 - 40)
					    			result = "Bạn bị béo phì độ I";
								    }
					    			else if (BMIValue < 50) { //(40.1 - 50)
					    				result = "Bạn bị béo phì độ II";
									    } 
					    				else { //(>50)
					    					result = "Bạn bị béo phì độ II (quá mức)";
									    }
				    	
			    }
			    if (radNonAsian.isSelected()) { // trường hợp non asian 
			    	if (BMIValue < 18.5) {
						result = "Bạn là người gầy";
				    } else if (BMIValue < 25) { //(18.5 - 24.9)
				    	result = "Bạn là người bình thường";
					    } else if (BMIValue < 30 ) { //(25 - 29.9)
					    	result = "Bạn bị thừa cân";
						    } 
				    		else if (BMIValue <= 40) { //(30.0 - 40)
				    			result = "Bạn bị béo phì độ I";
							    }
				    			else if (BMIValue < 50) { //(40.1 - 50)
				    				result = "Bạn bị béo phì độ II";
								    } 
				    				else { //(>50)
				    					result = "Bạn bị béo phì độ II (quá mức)";
								    }
				    	
			    }
				txtBMI.setText(String.valueOf(BMIValue));
				txtDanhgia.setText(String.valueOf(result));

			}
		});
		
		JLabel lbBMI = new JLabel("Chỉ số BMI");
		lbBMI.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbBMI.setBounds(31, 247, 87, 22);
		frame.getContentPane().add(lbBMI);
		
		txtBMI = new JTextField();
		txtBMI.setBounds(141, 241, 406, 27);
		frame.getContentPane().add(txtBMI);
		txtBMI.setColumns(10);
		
		lbDanhgia = new JLabel("Đánh giá");
		lbDanhgia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbDanhgia.setBounds(31, 290, 87, 27);
		frame.getContentPane().add(lbDanhgia);
		
		txtDanhgia = new JTextField();
		txtDanhgia.setBounds(141, 292, 406, 27);
		frame.getContentPane().add(txtDanhgia);
		txtDanhgia.setColumns(10);
	}

}
