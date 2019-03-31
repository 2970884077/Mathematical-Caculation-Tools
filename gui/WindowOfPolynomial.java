/**  
 * All rights Reserved, Designed By CyborgKuroChan
 * @Title:  WindowOfPolynomial.java   
 * @Package gui   
 * @Description: ����ʽ����ͼ���� 
 * @author: JinZhiyun    
 * @date:   2019��3��16�� ����12:41:45   
 * @version V1.0 
 * @Copyright: 2019 CyborgKuroChan All rights reserved. 
 * ע�⣺�������ɳ������ֽ�����(wechat:Jzy_bb_1998)
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import someTest.Test;
import xxaqsxjc.method1.PolyDivideException;
import xxaqsxjc.method1.Polynomial;
import xxaqsxjc.method1.PolynomialBezoutEquationSolution;
import xxaqsxjc.method1.PolynomialCaculation;

/**   
 * @ClassName:  WindowOfPolynomial   
 * @Description: ����ʽ����ͼ����   
 * @author: JinZhiyun
 * @date:   2019��3��16�� ����12:41:45   
 *     
 * @Copyright: 2019 CyborgKuroChan All rights reserved. 
 * ע�⣺�������ɳ������ֽ�����(wechat:Jzy_bb_1998)
 */
public class WindowOfPolynomial {
	/**   
	 * @Fields p1, p2 : �Ѷ���ʽ����ɳ�Ա�������ڼ����¼����޸ķ��� 
	 */   
	private static Polynomial p1 = new Polynomial();
	private static Polynomial p2 = new Polynomial();

	/**   
	 * @Title: resetP1   
	 * @Description: �ö���ʽp1Ϊ0  
	 * @param:       
	 * @return: void      
	 * @throws   
	 */
	private static void resetP1() {
		p1 = new Polynomial();
	}

	/**   
	 * @Title: resetP2   
	 * @Description: �ö���ʽp1Ϊ0   
	 * @param:       
	 * @return: void      
	 * @throws   
	 */
	private static void resetP2() {
		p2 = new Polynomial();
	}

	/**   
	 * @Title: GUIPolynomial   
	 * @Description: ���ö���ʽ����ͼ��ģ��
	 * @param: @param frm      
	 * @return: void      
	 * @throws   
	 */
	public static void GUIPolynomial(JFrame frm) {
		JLabel j11 = new JLabel("12������ʽ�����ȫ");
		j11.setBounds(50, 390, GUIWindow.FrameWidth, 25);
		frm.add(j11);

		JButton btn = new JButton("����");
		btn.setBounds(180, 390, 80, 25);
		frm.add(btn);

		btn.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frmHidden = new JFrame();
				frmHidden.setBounds(2 * GUIWindow.FrameStartX, 2 * GUIWindow.FrameStartY, 1150, 600); // ���ô��ڳ�ʼλ�úʹ�С
				frmHidden.setTitle("����ʽ�����ȫ"); // ���ñ���
				frmHidden.setLayout(null); // ���������ΪnullĬ�ϣ���ť������������ݿ򣬵�ס������ɫ

				GUIPolynomialHidden(frmHidden);

				frmHidden.setVisible(true); // ��ʾ����
			}
		});
	}

	/**   
	 * @Title: GUIPolynomialHidden   
	 * @Description: ��������Ķ���ʽ����ͼ��ģ��  
	 * @param: @param frm      
	 * @return: void      
	 * @throws   
	 */
	public static void GUIPolynomialHidden(JFrame frm) {
		JLabel j11 = new JLabel("������������ʽp1,p2:");
		j11.setBounds(50, 30, 200, 25);
		frm.add(j11);

		JLabel j12 = new JLabel("p1=");
		j12.setBounds(50, 60, 50, 25);
		frm.add(j12);
		JTextField jtf1 = new JTextField();// �����ı������
		jtf1.setBounds(80, 60, 600, 25); // ��߾࣬�ϱ߾࣬������
		jtf1.setEditable(false);
		jtf1.setText(p1.toString());
		frm.add(jtf1);

		JLabel j13 = new JLabel("��p1����x��?�η�");
		j13.setBounds(700, 60, 200, 25);
		frm.add(j13);
		JTextField jtf2 = new JTextField(); // �����ı������
		jtf2.setBounds(810, 60, 70, 25); // ��߾࣬�ϱ߾࣬������
		frm.add(jtf2);

		JButton btnp1 = new JButton("���");
		btnp1.setBounds(890, 60, 80, 25);
		frm.add(btnp1);

		JButton btnp2 = new JButton("p1����");
		btnp2.setBounds(980, 60, 80, 25);
		frm.add(btnp2);

		JLabel j14 = new JLabel("p2=");
		j14.setBounds(50, 90, 50, 25);
		frm.add(j14);
		JTextField jtf3 = new JTextField();// �����ı������
		jtf3.setBounds(80, 90, 600, 25); // ��߾࣬�ϱ߾࣬������
		jtf3.setEditable(false);
		jtf3.setText(p1.toString());
		frm.add(jtf3);

		JLabel j15 = new JLabel("��p2����x��?�η�");
		j15.setBounds(700, 90, 200, 25);
		frm.add(j15);
		JTextField jtf4 = new JTextField(); // �����ı������
		jtf4.setBounds(810, 90, 70, 25); // ��߾࣬�ϱ߾࣬������
		frm.add(jtf4);

		JButton btnp3 = new JButton("���");
		btnp3.setBounds(890, 90, 80, 25);
		frm.add(btnp3);

		JButton btnp4 = new JButton("p2����");
		btnp4.setBounds(980, 90, 80, 25);
		frm.add(btnp4);

		JLabel j16 = new JLabel("p1+p2=");
		j16.setBounds(50, 120, 50, 25);
		frm.add(j16);
		JTextField jtf5 = new JTextField(); // �����ı������
		jtf5.setBounds(100, 120, 700, 25); // ��߾࣬�ϱ߾࣬������
		jtf5.setEditable(false);
		frm.add(jtf5);
		JButton btnp5 = new JButton("����");
		btnp5.setBounds(820, 120, 80, 25);
		frm.add(btnp5);

		JLabel j17 = new JLabel("p1-p2=");
		j17.setBounds(50, 150, 50, 25);
		frm.add(j17);
		JTextField jtf6 = new JTextField(); // �����ı������
		jtf6.setBounds(100, 150, 700, 25); // ��߾࣬�ϱ߾࣬������
		jtf6.setEditable(false);
		frm.add(jtf6);
		JButton btnp6 = new JButton("����");
		btnp6.setBounds(820, 150, 80, 25);
		frm.add(btnp6);

		JLabel j18 = new JLabel("p1*p2=");
		j18.setBounds(50, 180, 50, 25);
		frm.add(j18);
		JTextField jtf7 = new JTextField(); // �����ı������
		jtf7.setBounds(100, 180, 700, 25); // ��߾࣬�ϱ߾࣬������
		jtf7.setEditable(false);
		frm.add(jtf7);
		JButton btnp7 = new JButton("����");
		btnp7.setBounds(820, 180, 80, 25);
		frm.add(btnp7);

		JLabel j19 = new JLabel("p1/p2=");
		j19.setBounds(50, 210, 50, 25);
		frm.add(j19);
		JTextField jtf8 = new JTextField(); // �����ı������
		jtf8.setBounds(100, 210, 700, 25); // ��߾࣬�ϱ߾࣬������
		jtf8.setEditable(false);
		frm.add(jtf8);
		JButton btnp8 = new JButton("����");
		btnp8.setBounds(820, 210, 80, 25);
		frm.add(btnp8);

		JLabel j110 = new JLabel("p1 mod p2=");
		j110.setBounds(50, 240, 150, 25);
		frm.add(j110);
		JTextField jtf9 = new JTextField(); // �����ı������
		jtf9.setBounds(120, 240, 700, 25); // ��߾࣬�ϱ߾࣬������
		jtf9.setEditable(false);
		frm.add(jtf9);
		JButton btnp9 = new JButton("����");
		btnp9.setBounds(840, 240, 80, 25);
		frm.add(btnp9);

		JLabel j111 = new JLabel("p1���ݣ�p1^");
		j111.setBounds(50, 270, 150, 25);
		frm.add(j111);
		JTextField jtf90 = new JTextField(); // �����ı������
		jtf90.setBounds(130, 270, 80, 25); // ��߾࣬�ϱ߾࣬������
		frm.add(jtf90);
		JLabel j1110 = new JLabel("=");
		j1110.setBounds(215, 270, 50, 25);
		frm.add(j1110);
		JTextField jtf10 = new JTextField(); // �����ı������
		jtf10.setBounds(225, 270, 700, 25); // ��߾࣬�ϱ߾࣬������
		jtf10.setEditable(false);
		frm.add(jtf10);
		JButton btnp10 = new JButton("����");
		btnp10.setBounds(945, 270, 80, 25);
		frm.add(btnp10);

		JLabel j112 = new JLabel("(p1,p2)=");
		j112.setBounds(50, 300, 150, 25);
		frm.add(j112);
		JTextField jtf11 = new JTextField(); // �����ı������
		jtf11.setBounds(105, 300, 700, 25); // ��߾࣬�ϱ߾࣬������
		jtf11.setEditable(false);
		frm.add(jtf11);
		JButton btnp11 = new JButton("����");
		btnp11.setBounds(825, 300, 80, 25);
		frm.add(btnp11);

		JLabel j113 = new JLabel("[p1,p2]=");
		j113.setBounds(50, 330, 150, 25);
		frm.add(j113);
		JTextField jtf12 = new JTextField(); // �����ı������
		jtf12.setBounds(105, 330, 700, 25); // ��߾࣬�ϱ߾࣬������
		jtf12.setEditable(false);
		frm.add(jtf12);
		JButton btnp12 = new JButton("����");
		btnp12.setBounds(825, 330, 80, 25);
		frm.add(btnp12);

		JLabel j114 = new JLabel("p1�Ƿ�Ϊ����Լ����ʽ(1�ǣ�0����):");
		j114.setBounds(50, 360, 250, 25);
		frm.add(j114);
		JTextField jtf13 = new JTextField(); // �����ı������
		jtf13.setBounds(265, 360, 100, 25); // ��߾࣬�ϱ߾࣬������
		jtf13.setEditable(false);
		frm.add(jtf13);

		JLabel j115 = new JLabel("p1�Ƿ�Ϊ��ԭ����ʽ(1�ǣ�0����):");
		j115.setBounds(390, 360, 250, 25);
		frm.add(j115);
		JTextField jtf14 = new JTextField(); // �����ı������
		jtf14.setBounds(590, 360, 100, 25); // ��߾࣬�ϱ߾࣬������
		jtf14.setEditable(false);
		frm.add(jtf14);

		JButton btnp13 = new JButton("����");
		btnp13.setBounds(710, 360, 80, 25);
		frm.add(btnp13);

		JLabel j1160 = new JLabel("����ʽ�����ʽϵ�����(s(x)*p1(x)+t(x)p2(x)=( p1(x),p2(x) )");
		j1160.setBounds(50, 390, 500, 25);
		frm.add(j1160);

		JButton btnp15 = new JButton("����");
		btnp15.setBounds(400, 390, 80, 25);
		frm.add(btnp15);

		JLabel j116 = new JLabel("s(x)=");
		j116.setBounds(50, 420, 150, 25);
		frm.add(j116);
		JTextField jtf15 = new JTextField(); // �����ı������
		jtf15.setBounds(85, 420, 700, 25); // ��߾࣬�ϱ߾࣬������
		jtf15.setEditable(false);
		frm.add(jtf15);

		JLabel j117 = new JLabel("t(x)=");
		j117.setBounds(50, 450, 150, 25);
		frm.add(j117);
		JTextField jtf16 = new JTextField(); // �����ı������
		jtf16.setBounds(85, 450, 700, 25); // ��߾࣬�ϱ߾࣬������
		jtf16.setEditable(false);
		frm.add(jtf16);

		JButton btnp16 = new JButton("һ������");
		btnp16.setBounds(500, 480, 100, 25);
		frm.add(btnp16);

		btnp1.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Test.isLegalInteger(jtf2.getText())) {
					if (new BigInteger(jtf2.getText()).compareTo(BigInteger.valueOf(Polynomial.Max_Deg)) == 1) {
						JOptionPane.showMessageDialog(null, "����ʽ����ߴ�����Ӧ�ô���65535��");
					} else {
						int deg = Integer.parseInt(jtf2.getText());
						p1 = p1.add(new Polynomial(deg));
						jtf1.setText(p1.toString());
					}
				}
			}
		});

		btnp2.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				resetP1();
				jtf1.setText(p1.toString());
			}
		});

		btnp3.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Test.isLegalInteger(jtf4.getText())) {
					if (new BigInteger(jtf4.getText()).compareTo(BigInteger.valueOf(Polynomial.Max_Deg)) == 1) {
						JOptionPane.showMessageDialog(null, "����ʽ����ߴ�����Ӧ�ô���65535��");
					} else {
						int deg = Integer.parseInt(jtf4.getText());
						p2 = p2.add(new Polynomial(deg));
						jtf3.setText(p2.toString());
					}
				}
			}
		});

		btnp4.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				resetP2();
				jtf3.setText(p2.toString());
			}
		});

		btnp5.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				Polynomial polynomial = p1.add(p2);
				jtf5.setText(polynomial.toString());
			}
		});

		btnp6.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				Polynomial polynomial = p1.sub(p2);
				jtf6.setText(polynomial.toString());
			}
		});

		btnp7.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				Polynomial polynomial = p1.multiply(p2);
				jtf7.setText(polynomial.toString());
			}
		});

		btnp8.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				Polynomial polynomial;
				if (p2.equals(new Polynomial())) {
					JOptionPane.showMessageDialog(null, "��ʽ����Ϊ0");
				} else {
					try {
						polynomial = p1.divide(p2);
						jtf8.setText(polynomial.toString());
					} catch (PolyDivideException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		btnp9.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				Polynomial polynomial;
				if (p2.equals(new Polynomial())) {
					JOptionPane.showMessageDialog(null, "��ʽ����Ϊ0");
				} else {
					try {
						polynomial = p1.mod(p2);
						jtf9.setText(polynomial.toString());
					} catch (PolyDivideException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		btnp10.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Test.isLegalInteger(jtf90.getText())) {
					if (Integer.parseInt(jtf90.getText()) > Polynomial.Max_Deg || Polynomial.pow(p1,
							Integer.parseInt(jtf90.getText())).effectiveMaxDeg > Polynomial.Max_Deg) {
						JOptionPane.showMessageDialog(null, "�������СЩ���ݴ�");
					} else {
						Polynomial polynomial = Polynomial.pow(p1, Integer.parseInt(jtf90.getText()));
						jtf10.setText(polynomial.toString());
					}
				}
			}
		});

		btnp11.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				Polynomial polynomial;
				if (p1.equals(new Polynomial()) || p2.equals(new Polynomial())) {
					JOptionPane.showMessageDialog(null, "p1��p2����Ϊ0");
				} else {
					try {
						polynomial = PolynomialCaculation.maxPolyCommonFactor(p1, p2);
						jtf11.setText(polynomial.toString());
					} catch (PolyDivideException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		btnp12.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				Polynomial polynomial;
				if (p1.equals(new Polynomial()) || p2.equals(new Polynomial())) {
					JOptionPane.showMessageDialog(null, "p1��p2����Ϊ0");
				} else {
					try {
						polynomial = PolynomialCaculation.minPolyCommonMultiple(p1, p2);
						jtf12.setText(polynomial.toString());
					} catch (PolyDivideException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		btnp13.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				int r1, r2;
				if (p1.equals(new Polynomial())) {
					JOptionPane.showMessageDialog(null, "p1����Ϊ0");
				} else {
					try {
						r1 = PolynomialCaculation.ifPrimPolynomial(p1);
						r2 = PolynomialCaculation.ifReduciblePolynomial(p1);
						jtf13.setText(Integer.toString(r1));
						jtf14.setText(Integer.toString(r2));
					} catch (PolyDivideException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		btnp15.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				Polynomial[] polynomial;
				if (p1.equals(new Polynomial()) || p2.equals(new Polynomial())) {
					JOptionPane.showMessageDialog(null, "p1��p2����Ϊ0");
				} else {
					try {
						PolynomialBezoutEquationSolution polynomialBezoutEquationSolution = new PolynomialBezoutEquationSolution();
						polynomial = polynomialBezoutEquationSolution.PolynomialBezout_solve_qr_st(p1, p2);
						jtf15.setText(polynomial[0].toString());
						jtf16.setText(polynomial[1].toString());
					} catch (PolyDivideException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		btnp16.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				resetP1();
				resetP2();

				jtf1.setText(p1.toString());
				jtf3.setText(p2.toString());
				jtf2.setText("");
				jtf4.setText("");
				jtf5.setText("");
				jtf6.setText("");
				jtf7.setText("");
				jtf8.setText("");
				jtf9.setText("");
				jtf90.setText("");
				jtf10.setText("");
				jtf11.setText("");
				jtf12.setText("");
				jtf13.setText("");
				jtf14.setText("");
				jtf15.setText("");
				jtf16.setText("");
			}
		});
	}
}
