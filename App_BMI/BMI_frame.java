package App_BMI;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class BMI_frame extends Frame {
	Label lbChieucao, lbCannang, lbBMI, lbDanhgia,lbThaydoi;
	TextField txtChieucao, txtCannang, txtBMI, txtDanhgia,txtThaydoi;
	Button btnTinh;
	
	//Hàm tạo
	public BMI_frame() {
		setLayout(null);
		setBounds(0,0,350,400);
		setTitle("Kiểm tra chỉ số BMI");
		setVisible(true);
		//đưa các điều khiển vào frame
		lbChieucao = new Label("Chiều cao (cm) ");
		lbCannang = new Label("Cân nặng (kg) ");
		lbBMI = new Label("Chỉ số BMI: ");
		lbDanhgia = new Label("Đánh giá: ");
		lbThaydoi = new Label("Cân nặng cần thay đổi");
		txtChieucao = new TextField();
		txtCannang = new TextField();
		txtBMI = new TextField();
		txtDanhgia = new TextField();
		txtThaydoi = new TextField();
		btnTinh = new Button("TÍNH CHỈ SỐ BMI");
		
		//add
		add(lbChieucao);add(txtChieucao);
		add(lbCannang);add(txtCannang);
		add(btnTinh);
		add(lbBMI);add(txtBMI);
		add(lbDanhgia);add(txtDanhgia);
		add(lbThaydoi);add(txtThaydoi);
		txtDanhgia.setEditable(false);
		txtBMI.setEditable(false);
		txtThaydoi.setEditable(false);
		
		//Chỉnh vị trí
		lbChieucao.setBounds(30,30,100,50);
		txtChieucao.setBounds(130,40,170,25);
		lbCannang.setBounds(30,80,100,50);
		txtCannang.setBounds(130,90,170,25);
		btnTinh.setBounds(50,140,230,40);
		lbBMI.setBounds(30,190,100,50);
		txtBMI.setBounds(130,200,170,30);
		lbDanhgia.setBounds(30,240,100,50);
		txtDanhgia.setBounds(130,250,170,30);
		lbThaydoi.setBounds(30,290,130,50);
		txtThaydoi.setBounds(160,300,140,30);
		//xử lí nút tính toán
		btnTinh.addActionListener(new bolangnghe_XL_BMI());
		
		// xử lí đóng giao diện
		addWindowListener(new bolangnghe_XL_cuaso());
	}
	//Sự kiện tính BMI
	class bolangnghe_XL_BMI implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String strChieucao = txtChieucao.getText();
			String strCannang = txtCannang.getText();
			double chieucao = Double.parseDouble(strChieucao);
			double cannang = Double.parseDouble(strCannang);
			//tính chỉ số BMI
			double chiSoBMI = cannang / (chieucao * chieucao);
		    String ketQua;
		    double cannangThaydoi = 0;
		    // phân loại dựa vào chỉ số BMI
		    if (chiSoBMI < 18.5) {
		        ketQua = "Bạn là người gầy";
		        cannangThaydoi = 18.5 * (chieucao * chieucao) - cannang;
				txtThaydoi.setText("Tăng thêm " + String.valueOf(cannangThaydoi) + "kg");
		    } else if (chiSoBMI < 25) { //(18.5 - 24.9)
		        ketQua = "Bạn là người bình thường";
			    } 
		    	else if (chiSoBMI < 30) {  //(25.0 - 29.9)
			        ketQua = "Bạn bị thừa cân";
			        cannangThaydoi = cannang - 24.9 * (chieucao * chieucao) ;
			        txtThaydoi.setText("Giảm bớt " + String.valueOf(cannangThaydoi) + "kg");
				    } 
		    		else if (chiSoBMI < 35) { //(30.0 - 34.9)
				        ketQua = "Bạn bị béo phì độ I";
				        cannangThaydoi = cannang - 24.9 * (chieucao * chieucao) ;
				        txtThaydoi.setText("Giảm bớt " + String.valueOf(cannangThaydoi) + "kg");
					    }
		    			else if (chiSoBMI < 40) { //(35.0 - 39.9)
					        ketQua = "Bạn bị béo phì độ II";
					        cannangThaydoi = cannang - 24.9 * (chieucao * chieucao) ;
					        txtThaydoi.setText("Giảm bớt " + String.valueOf(cannangThaydoi) + "kg");
						    } 
		    				else { //(>40)
						    	ketQua = "Bạn bị béo phì độ III";
						        cannangThaydoi = cannang - 24.9 * (chieucao * chieucao) ;
						        txtThaydoi.setText("Giảm bớt " + String.valueOf(cannangThaydoi) + "kg");
						    }
			txtBMI.setText(String.valueOf(chiSoBMI));
			txtDanhgia.setText(String.valueOf(ketQua));

		}
	}
	
	//Thiết lập đóng giao diện
	class bolangnghe_XL_cuaso implements WindowListener{
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
		}
		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
		}
		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub	
		}
		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub	
		}
		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub	
		}
		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub	
		}
	}
}
