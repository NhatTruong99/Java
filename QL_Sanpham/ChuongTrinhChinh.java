package QL_Sanpham;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;


import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ChuongTrinhChinh {

	private JFrame frame;

	ArrayList<SanPham> dsSanPham; //Khai báo danh sách sản phẩm
	
	private JTextField txtMaSP;
	private JTextField txtTenSP;
	private JTextField txtDongia;
	private JLabel lbTenSP;
	private JLabel lbDonGia;
	private JLabel lbTrangThai;
	private JTextArea textAreaDS;
	private JButton btnHienthiDS;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChuongTrinhChinh window = new ChuongTrinhChinh();
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
	public ChuongTrinhChinh() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 591, 529);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "S\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(49, 27, 468, 196);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		txtMaSP = new JTextField();
		txtMaSP.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				lbTrangThai.setText("Đang nhập...");
			}
		});
		txtMaSP.setBounds(128, 48, 186, 25);
		panel.add(txtMaSP);
		txtMaSP.setColumns(10);
		
		txtTenSP = new JTextField();
		txtTenSP.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				lbTrangThai.setText("Đang nhập...");
			}
		});
		txtTenSP.setColumns(10);
		txtTenSP.setBounds(128, 88, 186, 25);
		panel.add(txtTenSP);
		
		txtDongia = new JTextField();
		txtDongia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				lbTrangThai.setText("Đang nhập...");
			}
		});
		txtDongia.setColumns(10);
		txtDongia.setBounds(128, 130, 186, 25);
		panel.add(txtDongia);
		
		dsSanPham = new ArrayList<SanPham>();
		
		JButton btnThemSP = new JButton("Thêm mới");

		btnThemSP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnThemSP.setBounds(342, 23, 98, 31);
		panel.add(btnThemSP);
		
		JLabel lbMaSP = new JLabel("Mã sản phẩm:");
		lbMaSP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbMaSP.setBounds(24, 47, 94, 25);
		panel.add(lbMaSP);
		
		lbTenSP = new JLabel("Tên sản phẩm:");
		lbTenSP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbTenSP.setBounds(24, 88, 94, 25);
		panel.add(lbTenSP);
		
		lbDonGia = new JLabel("Đơn giá:");
		lbDonGia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbDonGia.setBounds(24, 129, 94, 25);
		panel.add(lbDonGia);
		
		JButton btnTimkiem = new JButton("Tìm kiếm");

		btnTimkiem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnTimkiem.setBounds(342, 62, 98, 31);
		panel.add(btnTimkiem);
		
		JButton btnSua = new JButton("Sửa");

		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSua.setBounds(342, 145, 98, 32);
		panel.add(btnSua);
		
		JButton btnXoa = new JButton("Xóa");

		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnXoa.setBounds(342, 104, 98, 31);
		panel.add(btnXoa);
		
		textAreaDS = new JTextArea();
		textAreaDS.setBounds(49, 288, 475, 159);
		frame.getContentPane().add(textAreaDS);
		
		JLabel lbDanhSach = new JLabel("Danh sách sản phẩm");
		lbDanhSach.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbDanhSach.setBounds(49, 255, 145, 23);
		frame.getContentPane().add(lbDanhSach);
		
		lbTrangThai = new JLabel("Đang đợi nhập xong...");
		lbTrangThai.setHorizontalAlignment(SwingConstants.RIGHT);
		lbTrangThai.setForeground(Color.BLUE);
		lbTrangThai.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbTrangThai.setBounds(277, 233, 242, 13);
		frame.getContentPane().add(lbTrangThai);
		
		btnHienthiDS = new JButton("Hiển thị danh sách");
		btnHienthiDS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HienThiSP(dsSanPham);
			}
		});
		btnHienthiDS.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnHienthiDS.setBounds(380, 454, 145, 23);
		frame.getContentPane().add(btnHienthiDS);
		
		//Sự kiện button xóa sp
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XoaSP(dsSanPham);
				HienThiSP(dsSanPham);
			}
		});
		
		//Sự kiện button sửa sp
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SuaSP(dsSanPham);
				HienThiSP(dsSanPham);
			}
		});
		
		//Sự kiện button tìm sp
		btnTimkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimkiemSP(dsSanPham);
			}
		});
		
		//Sự kiện button thêm sp
		btnThemSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemSP(dsSanPham);
				HienThiSP(dsSanPham);
			}
		});
	}
	//Hàm thêm sản phẩm
	private void ThemSP(ArrayList<SanPham> dsSanPham) {
		// TODO Auto-generated method stub
		String maSP = txtMaSP.getText();
		String tenSP = txtTenSP.getText();
		String donGiaString = txtDongia.getText();
		Boolean ktTrungLap = false;
		//Kiểm tra đã nhập đủ hay chưa
		if (maSP.isEmpty() || tenSP.isEmpty() || donGiaString.isEmpty() ) {
			lbTrangThai.setText("Dữ liệu nhập chưa đầy đủ!");
		} else {
			//Kiểm tra mã có tồn tại trước khi nhập
			for(int i=0; i<dsSanPham.size(); i++) {
				if (maSP.equals(dsSanPham.get(i).getMaSP())){
					ktTrungLap = true;
				}
			}
			if (ktTrungLap) {
				lbTrangThai.setText("Mã sản phẩm đã tồn tại!");
			} else {			
				//Thêm vào list sp
				Double donGia = Double.parseDouble(donGiaString);
				SanPham sp = new SanPham();
				sp.setTenSP(tenSP);
				sp.setMaSP(maSP);
				sp.setDonGia(donGia);
				dsSanPham.add(sp);
				lbTrangThai.setText("Đã thêm vào danh sách!");
				txtMaSP.setText("");
				txtTenSP.setText("");
				txtDongia.setText("");
			}
		}
	}
	//Hàm hiển thị toàn bộ danh sách sản phẩm
	private void HienThiSP(ArrayList<SanPham> dsSanPham) {
		// TODO Auto-generated method stub
		textAreaDS.setText("");
		for(int i=0; i< dsSanPham.size(); i++) {
			textAreaDS.append("  " + dsSanPham.get(i).getMaSP() + " --- " + dsSanPham.get(i).getTenSP() + " --- "
								+ dsSanPham.get(i).getDonGia() + "\n");
		}
	}
	//Hàm tìm kiếm + hiển thị sản phẩm
	private void TimkiemSP(ArrayList<SanPham> dsSanPham) {
		// TODO Auto-generated method stub
		String maSP = txtMaSP.getText();
		Boolean isTimkiem = false;
		int vitri = 0;
		for(int i=0; i< dsSanPham.size(); i++) {
			if (maSP.equals(dsSanPham.get(i).getMaSP())) {
				isTimkiem = true;
				vitri = i;
				break;
			}
		}
		//Danh sách chỉ hiển thị sản phẩm tìm được
		if (isTimkiem) {
			lbTrangThai.setText("Sản phẩm có trong danh sách!");
			textAreaDS.setText("");
			textAreaDS.append("  " + dsSanPham.get(vitri).getMaSP() + " --- " + dsSanPham.get(vitri).getTenSP() + " --- "
					+ dsSanPham.get(vitri).getDonGia() + "\n");
		} else {
			lbTrangThai.setText("Sản phẩm không có trong danh sách!");
		}
	}		
	//Hàm sửa sản phẩm
	private void SuaSP(ArrayList<SanPham> dsSanPham) {
		// TODO Auto-generated method stub
		String maSP = txtMaSP.getText();
		for(int i=0; i< dsSanPham.size(); i++) {
			if (maSP.equals(dsSanPham.get(i).getMaSP())) {
				//Nếu có dữ liệu nhập vào thì mới sửa thông tin
				String tenSP = txtTenSP.getText();
				if (!tenSP.isEmpty()) {
					dsSanPham.get(i).setTenSP(tenSP);
					lbTrangThai.setText("Đã sửa thành công!");
				}
				String donGiaString =txtDongia.getText();
				if (!donGiaString.isEmpty()) {
					Double donGia = Double.parseDouble(donGiaString);
					dsSanPham.get(i).setDonGia(donGia);
					lbTrangThai.setText("Đã sửa thành công!");
				}
				break;
			}
		}
	}
	//Hàm xóa sản phẩm
	private void XoaSP(ArrayList<SanPham> dsSanPham) {
		// TODO Auto-generated method stub
		String maSP = txtMaSP.getText();
		for(int i=0; i< dsSanPham.size(); i++) {
			if(maSP.equals(dsSanPham.get(i).getMaSP())) {
				dsSanPham.remove(i);
				lbTrangThai.setText("Đã xóa thành công!");
				break;
			}
		}
	}
}
