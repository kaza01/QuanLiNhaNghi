package kaza.com.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;


public class NhaNghiUI extends JFrame {
	JTextArea txtMsg;
	JTextField txtGio,txtSlMi,txtSlBia,txtPhuTro,txtTong;
	JButton btnThanhTien,btnThoat,btnThongTin;
	public NhaNghiUI(String title)
	{
		this.setTitle(title);
		addcontrols();
		addEvents();
	}
	public void addcontrols()
	{
		Container con=getContentPane();
		JPanel pnMain=new JPanel(); con.add(pnMain);
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		
		JPanel pnTitle=new JPanel(); pnMain.add(pnTitle);
		pnTitle.setLayout(new FlowLayout());
		JLabel lblTitle=new JLabel("Nhà nghỉ Sông Châu"); pnTitle.add(lblTitle);
		lblTitle.setForeground(Color.BLUE);
		Font fontTitle=new Font("arial", Font.BOLD, 30);
		lblTitle.setFont(fontTitle);
		
		JPanel pnThongTin=new JPanel(); pnMain.add(pnThongTin);
		pnThongTin.setLayout(new GridLayout(1, 2));
		
		JPanel pnMsg=new JPanel(); pnThongTin.add(pnMsg);
		pnMsg.setLayout(new BorderLayout());//------------------------
		txtMsg=new JTextArea(13, 25);
		txtMsg.setWrapStyleWord(true);
		txtMsg.setLineWrap(true);
		JScrollPane scMsg=new JScrollPane(txtMsg, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnMsg.add(scMsg);
		Border borderMsg=BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder borderTitleMsg=BorderFactory.createTitledBorder(borderMsg, 
				"Thông tin để lại");
		borderTitleMsg.setTitleJustification(TitledBorder.CENTER);
		borderTitleMsg.setTitleColor(Color.RED);
		pnMsg.setBorder(borderTitleMsg);
		
		JPanel pnTinh=new JPanel(); pnThongTin.add(pnTinh);
		pnTinh.setLayout(new BoxLayout(pnTinh, BoxLayout.Y_AXIS));
		
		JPanel pnGio=new JPanel(); pnTinh.add(pnGio);
		pnGio.setLayout(new FlowLayout());
		JLabel lblGio=new JLabel("Số lượng giờ"); pnGio.add(lblGio);
		txtGio=new JTextField(15); pnGio.add(txtGio);
		
		JPanel pnMi=new JPanel(); pnTinh.add(pnMi);
		pnMi.setLayout(new FlowLayout());
		JLabel lblMi=new JLabel("Số lượng Mì"); pnMi.add(lblMi);
		txtSlMi=new JTextField(15); pnMi.add(txtSlMi);
		
		JPanel pnBia=new JPanel(); pnTinh.add(pnBia);
		pnBia.setLayout(new FlowLayout());
		JLabel lblBia=new JLabel("Số lượng Bia"); pnBia.add(lblBia);
		txtSlBia=new JTextField(15); pnBia.add(txtSlBia);
		
		JPanel pnPhuTro=new JPanel(); pnTinh.add(pnPhuTro);
		pnPhuTro.setLayout(new FlowLayout());
		JLabel lblPhuTro=new JLabel("Tiền Phụ Trợ"); pnPhuTro.add(lblPhuTro);
		txtPhuTro=new JTextField(15); pnPhuTro.add(txtPhuTro);
		
		lblGio.setPreferredSize(lblPhuTro.getPreferredSize());
		lblMi.setPreferredSize(lblPhuTro.getPreferredSize());
		
		Border borderTinh=BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder borderTitleTinh=BorderFactory.createTitledBorder(borderMsg, 
				"Tính tiền");
		borderTitleTinh.setTitleJustification(TitledBorder.CENTER);
		borderTitleTinh.setTitleColor(Color.RED);
		pnTinh.setBorder(borderTitleTinh);
		
		
		JPanel pnButton=new JPanel(); pnMain.add(pnButton);
		pnButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
		btnThanhTien=new JButton("Thành tiền"); pnButton.add(btnThanhTien);
		btnThongTin=new JButton("Thông tin"); pnButton.add(btnThongTin);
		btnThoat=new JButton("Thoát"); pnButton.add(btnThoat);
		
		JPanel pnTong=new JPanel(); pnMain.add(pnTong);
		pnTong.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblTong=new JLabel("Tổng tiền"); pnTong.add(lblTong);
		txtTong=new JTextField(20); pnTong.add(txtTong);
	}
	public void addEvents()
	{
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnThongTin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg=txtMsg.getText();
				JOptionPane.showMessageDialog(null, msg);
			}
		});
		btnThanhTien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xuLiThanhTien();
			}
		});
	}
	protected void xuLiThanhTien() {
		
		String slGio=txtGio.getText(); double soGio=Double.parseDouble(slGio);
		String slMi=txtSlMi.getText(); double soMi=Double.parseDouble(slMi);
		String slBia=txtSlBia.getText(); double soBia=Double.parseDouble(slBia);
		String tienPhuTro=txtPhuTro.getText(); 
		double soPhuTro=Double.parseDouble(tienPhuTro);
		double tong= 70000+(soGio-1)*10000 + 20000*soMi + 20000*soBia + soPhuTro;
		txtTong.setText(""+tong);
	}
	public void showWindow()
	{
		this.setSize(650, 430);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}

















