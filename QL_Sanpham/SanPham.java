package QL_Sanpham;

public class SanPham {
	private String maSP;
	private String tenSP;
	private double donGia;
	
	public SanPham() {
		super();
	}

	public SanPham(String maSP, String tenSP, double donGia) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.donGia = donGia;
	}

	public String getMaSP() {
		return maSP;
	}

	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	
	
}
