package AppCalcutator;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class tinhtoan extends Frame{
	TextField txtA, txtB, txtKQ;
	Label lbA, lbB, lbKQ;
	Button btnCong, btnTru, btnNhan, btnChia;
	//Hàm tạo
	public tinhtoan() {
		setLayout(null);
		setBounds(0,0,325,250);
		setTitle("Tính tổng 2 số ");
		setVisible(true);
		//đưa các điều khiển vào frame
		lbA = new Label("A = ");
		lbB = new Label("B = ");
		lbKQ = new Label("Kết quả: ");
		txtA = new TextField();	
		txtB = new TextField();
		txtKQ = new TextField();
		btnCong = new Button("+");
		btnTru = new Button("-");
		btnNhan = new Button("*");
		btnChia = new Button("/");
		//add
		add(lbA);	add(txtA);
		add(lbB);	add(txtB);
		add(btnCong);add(btnTru);add(btnNhan);add(btnChia);
		add(lbKQ);	add(txtKQ);
		
		//Chỉnh vị trí
		lbA.setBounds(30,30,20,50);
		txtA.setBounds(55,45,90,20);
		lbB.setBounds(170,30,20,50);
		txtB.setBounds(195,45,90,20);
		btnCong.setBounds(30,90,60,35);
		btnTru.setBounds(95,90,60,35);
		btnNhan.setBounds(160,90,60,35);
		btnChia.setBounds(225,90,60,35);
		lbKQ.setBounds(30,132,50,50);
		txtKQ.setBounds(80,145,200,25);
		
		//xử lí các nút tính toán
		btnCong.addActionListener(new bolangnghe_XL_Pheptinh());
		btnTru.addActionListener(new bolangnghe_XL_Pheptinh());
		btnNhan.addActionListener(new bolangnghe_XL_Pheptinh());
		btnChia.addActionListener(new bolangnghe_XL_Pheptinh());
		
		// xử lí đóng giao diện
		addWindowListener(new bolangnghe_XL_cuaso());
	}
	//Sự kiện tính 2 số
	class bolangnghe_XL_Pheptinh implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String strA = txtA.getText();
			String strB = txtB.getText();
			//đổi sang double
			double A = Double.parseDouble(strA);
			double B = Double.parseDouble(strB);
			double result = 0;
			//Kiểm tra phép tính là gì
			if (e.getActionCommand() == "+") {
				result  = Cong(A, B);
				txtKQ.setText(String.valueOf(result));
			}
			if (e.getActionCommand() == "-") {
				result  = Tru(A, B);
				txtKQ.setText(String.valueOf(result));
			}
			if (e.getActionCommand() == "*") {
				result  = Nhan(A, B);
				txtKQ.setText(String.valueOf(result));
			}
			if (e.getActionCommand() == "/") {
				if (B == 0) {
					txtKQ.setText("Không chia được cho số 0!");
				} else {
					result  = Chia(A, B);
					txtKQ.setText(String.valueOf(result));
				}
			}
		}
	}
	//Các hàm tính toán
	public double Cong(double a, double b) {
		return a + b;
	}	
	public double Tru(double a, double b) {
		return a - b;
	}
	public double Nhan(double a, double b) {
		return a * b;
	}
	public double Chia(double a, double b) {
		return a / b;
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
