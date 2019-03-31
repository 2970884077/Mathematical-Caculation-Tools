/**  
 * All rights Reserved, Designed By CyborgKuroChan
 * @Title:  WindowOfEllipticCurveCaculationOfF2n.java   
 * @Package gui   
 * @Description:  F2n�ϵ���Բ����y^2+xy=x^3+a2*x^2+a6�ĵ�ļ���ͼ����
 * @author: JinZhiyun    
 * @date:   2019��3��16�� ����7:04:39   
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
import xxaqsxjc.method1.EllipticCurveCaculationOfF2n;
import xxaqsxjc.method1.PolyDivideException;
import xxaqsxjc.method1.Polynomial;

/**   
 * @ClassName:  WindowOfEllipticCurveCaculationOfF2n   
 * @Description: F2n�ϵ���Բ����y^2+xy=x^3+a2*x^2+a6�ĵ�ļ���ͼ����
 * @author: JinZhiyun
 * @date:   2019��3��16�� ����7:04:39   
 *     
 * @Copyright: 2019 CyborgKuroChan All rights reserved. 
 * ע�⣺�������ɳ������ֽ�����(wechat:Jzy_bb_1998)
 */
public class WindowOfEllipticCurveCaculationOfF2n {
	/**   
	 * @Fields p : ����ʽp  
	 */   
	private static Polynomial p = new Polynomial();

	/**   
	 * @Fields a2 : ϵ��a2   
	 */   
	private static Polynomial a2 = new Polynomial();
	
	/**   
	 * @Fields a6 : ϵ��a6   
	 */   
	private static Polynomial a6 = new Polynomial();
	
	/**   
	 * @Title: resetP   
	 * @Description: �ö���ʽpΪ0  
	 * @param:       
	 * @return: void      
	 * @throws   
	 */
	private static void resetP() {
		p = new Polynomial();
	}
	
	/**   
	 * @Title: resetA2   
	 * @Description: ��ϵ��a2Ϊ0  
	 * @param:       
	 * @return: void      
	 * @throws   
	 */
	private static void resetA2() {
		a2 = new Polynomial();
	}
	
	/**   
	 * @Title: resetA6   
	 * @Description: ��ϵ��a6Ϊ0 
	 * @param:       
	 * @return: void      
	 * @throws   
	 */
	private static void resetA6() {
		a6 = new Polynomial();
	}
	
	/**   
	 * @Fields p1, p2 : �Ѷ���ʽ����ɳ�Ա�������ڼ����¼����޸ķ��� 
	 */   
	private static Polynomial[] p1 = { new Polynomial(), new Polynomial() };
	private static Polynomial[] p2 = { new Polynomial(), new Polynomial() };

	/**   
	 * @Title: resetP1X   
	 * @Description: ��P1xΪ0  
	 * @param:       
	 * @return: void      
	 * @throws   
	 */
	private static void resetP1X() {
		p1[0] = new Polynomial();
	}
	
	/**   
	 * @Title: resetP1Y   
	 * @Description: ��P1yΪ0   
	 * @param:       
	 * @return: void      
	 * @throws   
	 */
	private static void resetP1Y() {
		p1[1] = new Polynomial();
	}
	
	/**   
	 * @Title: resetP2X   
	 * @Description: ��P2xΪ0
	 * @param:       
	 * @return: void      
	 * @throws   
	 */
	private static void resetP2X() {
		p2[0] = new Polynomial();
	}
	
	/**   
	 * @Title: resetP2Y   
	 * @Description: ��P2yΪ0 
	 * @param:       
	 * @return: void      
	 * @throws   
	 */
	private static void resetP2Y() {
		p2[1] = new Polynomial();
	}

	/**   
	 * @Title: GUIEllipticCurveCaculationOfF2n   
	 * @Description: ����F2n�ϵ���Բ����y^2+xy=x^3+a2*x^2+a6�ĵ�ļ���ͼ��ģ��  
	 * @param: @param frm      
	 * @return: void      
	 * @throws   
	 */
	public static void GUIEllipticCurveCaculationOfF2n(JFrame frm) {
		JLabel j11 = new JLabel("14��F2n�ϵ���Բ����y^2+xy=x^3+a2*x^2+a6�ϵ�ļ���");
		j11.setBounds(50, 450, GUIWindow.FrameWidth, 25);
		frm.add(j11);

		JButton btn = new JButton("����");
		btn.setBounds(400, 450, 80, 25);
		frm.add(btn);

		btn.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frmHidden = new JFrame();
				frmHidden.setBounds(2 * GUIWindow.FrameStartX, 2 * GUIWindow.FrameStartY, 900, 500); // ���ô��ڳ�ʼλ�úʹ�С
				frmHidden.setTitle("F2n�ϵ���Բ����y^2+xy=x^3+a2*x^2+a6�ϵ�ļ���"); // ���ñ���
				frmHidden.setLayout(null); // ���������ΪnullĬ�ϣ���ť������������ݿ򣬵�ס������ɫ

				GUIEllipticCurveCaculationOfF2nHidden(frmHidden);

				frmHidden.setVisible(true); // ��ʾ����
			}

		});
	}

	/**   
	 * @Title: GUIEllipticCurveCaculationOfF2nHidden   
	 * @Description: ���������F2n�ϵ���Բ����y^2+xy=x^3+a2*x^2+a6�ĵ�ļ���ͼ��ģ��    
	 * @param: @param frm      
	 * @return: void      
	 * @throws   
	 */
	public static void GUIEllipticCurveCaculationOfF2nHidden(JFrame frm) {
		JLabel j11 = new JLabel("�������ʽP(x)��ϵ��a2��a6:");
		j11.setBounds(50, 0, 200, 25);
		frm.add(j11);

		JLabel j12 = new JLabel("P(x)=");
		j12.setBounds(50, 30, 50, 25);
		frm.add(j12);
		JTextField jtf1 = new JTextField();// �����ı������
		jtf1.setBounds(85, 30, 350, 25); // ��߾࣬�ϱ߾࣬������
		jtf1.setEditable(false);
		jtf1.setText(p.toString());
		frm.add(jtf1);

		JLabel j13 = new JLabel("��P(x)����x��?�η�");
		j13.setBounds(470, 30, 200, 25);
		frm.add(j13);
		JTextField jtf2 = new JTextField(); // �����ı������
		jtf2.setBounds(590, 30, 70, 25); // ��߾࣬�ϱ߾࣬������
		frm.add(jtf2);

		JButton btnp1 = new JButton("���");
		btnp1.setBounds(670, 30, 80, 25);
		frm.add(btnp1);

		JButton btnp2 = new JButton("P(X)����");
		btnp2.setBounds(760, 30, 100, 25);
		frm.add(btnp2);

		JLabel j1a2 = new JLabel("a2=");
		j1a2.setBounds(50, 60, 50, 25);
		frm.add(j1a2);
		JTextField jtfa2 = new JTextField();// �����ı������
		jtfa2.setBounds(85, 60, 350, 25); // ��߾࣬�ϱ߾࣬������
		jtfa2.setEditable(false);
		jtfa2.setText(p.toString());
		frm.add(jtfa2);

		JLabel j1a21 = new JLabel("��a2����x��?�η�");
		j1a21.setBounds(470, 60, 200, 25);
		frm.add(j1a21);
		JTextField jtfa21 = new JTextField(); // �����ı������
		jtfa21.setBounds(590, 60, 70, 25); // ��߾࣬�ϱ߾࣬������
		frm.add(jtfa21);

		JButton btnpa2 = new JButton("���");
		btnpa2.setBounds(670, 60, 80, 25);
		frm.add(btnpa2);

		JButton btnpa21 = new JButton("a2����");
		btnpa21.setBounds(760, 60, 100, 25);
		frm.add(btnpa21);

		JLabel j1a6 = new JLabel("a6=");
		j1a6.setBounds(50, 90, 50, 25);
		frm.add(j1a6);
		JTextField jtfa6 = new JTextField();// �����ı������
		jtfa6.setBounds(85, 90, 350, 25); // ��߾࣬�ϱ߾࣬������
		jtfa6.setEditable(false);
		jtfa6.setText(p.toString());
		frm.add(jtfa6);

		JLabel j1a61 = new JLabel("��a6����x��?�η�");
		j1a61.setBounds(470, 90, 200, 25);
		frm.add(j1a61);
		JTextField jtfa61 = new JTextField(); // �����ı������
		jtfa61.setBounds(590, 90, 70, 25); // ��߾࣬�ϱ߾࣬������
		frm.add(jtfa61);

		JButton btnpa6 = new JButton("���");
		btnpa6.setBounds(670, 90, 80, 25);
		frm.add(btnpa6);

		JButton btnpa61 = new JButton("a6����");
		btnpa61.setBounds(760, 90, 100, 25);
		frm.add(btnpa61);

		JLabel j16 = new JLabel("��P1(P1x,P1y):");
		j16.setBounds(50, 120, 150, 25);
		frm.add(j16);

		JLabel j17 = new JLabel("P1x=");
		j17.setBounds(50, 150, 50, 25);
		frm.add(j17);
		JTextField jtf5 = new JTextField();// �����ı������
		jtf5.setBounds(85, 150, 350, 25); // ��߾࣬�ϱ߾࣬������
		jtf5.setEditable(false);
		jtf5.setText(p1[0].toString());
		frm.add(jtf5);

		JLabel j18 = new JLabel("��P1x����x��?�η�");
		j18.setBounds(470, 150, 200, 25);
		frm.add(j18);
		JTextField jtf6 = new JTextField(); // �����ı������
		jtf6.setBounds(590, 150, 70, 25); // ��߾࣬�ϱ߾࣬������
		frm.add(jtf6);

		JButton btnp3 = new JButton("���");
		btnp3.setBounds(670, 150, 80, 25);
		frm.add(btnp3);

		JButton btnp4 = new JButton("P1x����");
		btnp4.setBounds(760, 150, 100, 25);
		frm.add(btnp4);

		JLabel j19 = new JLabel("P1y=");
		j19.setBounds(50, 180, 50, 25);
		frm.add(j19);
		JTextField jtf7 = new JTextField();// �����ı������
		jtf7.setBounds(85, 180, 350, 25); // ��߾࣬�ϱ߾࣬������
		jtf7.setEditable(false);
		jtf7.setText(p1[1].toString());
		frm.add(jtf7);

		JLabel j110 = new JLabel("��P1y����x��?�η�");
		j110.setBounds(470, 180, 200, 25);
		frm.add(j110);
		JTextField jtf8 = new JTextField(); // �����ı������
		jtf8.setBounds(590, 180, 70, 25); // ��߾࣬�ϱ߾࣬������
		frm.add(jtf8);

		JButton btnp5 = new JButton("���");
		btnp5.setBounds(670, 180, 80, 25);
		frm.add(btnp5);

		JButton btnp6 = new JButton("P1y����");
		btnp6.setBounds(760, 180, 100, 25);
		frm.add(btnp6);

		JLabel j111 = new JLabel("��P2(P2x,P2y):");
		j111.setBounds(50, 210, 150, 25);
		frm.add(j111);

		JLabel j112 = new JLabel("P2x=");
		j112.setBounds(50, 240, 50, 25);
		frm.add(j112);
		JTextField jtf9 = new JTextField();// �����ı������
		jtf9.setBounds(85, 240, 350, 25); // ��߾࣬�ϱ߾࣬������
		jtf9.setEditable(false);
		jtf9.setText(p2[0].toString());
		frm.add(jtf9);

		JLabel j113 = new JLabel("��P2x����x��?�η�");
		j113.setBounds(470, 240, 200, 25);
		frm.add(j113);
		JTextField jtf10 = new JTextField(); // �����ı������
		jtf10.setBounds(590, 240, 70, 25); // ��߾࣬�ϱ߾࣬������
		frm.add(jtf10);

		JButton btnp7 = new JButton("���");
		btnp7.setBounds(670, 240, 80, 25);
		frm.add(btnp7);

		JButton btnp8 = new JButton("P2x����");
		btnp8.setBounds(760, 240, 100, 25);
		frm.add(btnp8);

		JLabel j114 = new JLabel("P2y=");
		j114.setBounds(50, 270, 50, 25);
		frm.add(j114);
		JTextField jtf11 = new JTextField();// �����ı������
		jtf11.setBounds(85, 270, 350, 25); // ��߾࣬�ϱ߾࣬������
		jtf11.setEditable(false);
		jtf11.setText(p2[1].toString());
		frm.add(jtf11);

		JLabel j115 = new JLabel("��P2y����x��?�η�");
		j115.setBounds(470, 270, 200, 25);
		frm.add(j115);
		JTextField jtf15 = new JTextField(); // �����ı������
		jtf15.setBounds(590, 270, 70, 25); // ��߾࣬�ϱ߾࣬������
		frm.add(jtf15);

		JButton btnp9 = new JButton("���");
		btnp9.setBounds(670, 270, 80, 25);
		frm.add(btnp9);

		JButton btnp10 = new JButton("P2y����");
		btnp10.setBounds(760, 270, 100, 25);
		frm.add(btnp10);

		JLabel j116 = new JLabel("���㣺");
		j116.setBounds(50, 300, 50, 25);
		frm.add(j116);

		JLabel j117 = new JLabel("P1+P2=");
		j117.setBounds(50, 330, 150, 25);
		frm.add(j117);
		JTextField jtf16 = new JTextField(); // �����ı������
		jtf16.setBounds(100, 330, 500, 25); // ��߾࣬�ϱ߾࣬������
		jtf16.setEditable(false);
		frm.add(jtf16);
		JButton btnp11 = new JButton("����");
		btnp11.setBounds(620, 330, 80, 25);
		frm.add(btnp11);

		JLabel j118 = new JLabel("k��P1�ļ��㣺        k=");
		j118.setBounds(50, 360, 200, 25);
		frm.add(j118);
		JTextField jtf17 = new JTextField(); // �����ı������
		jtf17.setBounds(180, 360, 100, 25); // ��߾࣬�ϱ߾࣬������
		frm.add(jtf17);
		JLabel j119 = new JLabel("k��P1=");
		j119.setBounds(300, 360, 100, 25);
		frm.add(j119);
		JTextField jtf18 = new JTextField(); // �����ı������
		jtf18.setBounds(345, 360, 400, 25); // ��߾࣬�ϱ߾࣬������
		jtf18.setEditable(false);
		frm.add(jtf18);
		JButton btnp12 = new JButton("����");
		btnp12.setBounds(760, 360, 80, 25);
		frm.add(btnp12);

		btnp1.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Test.isLegalInteger(jtf2.getText())) {
					if (new BigInteger(jtf2.getText()).compareTo(BigInteger.valueOf(Polynomial.Max_Deg)) == 1) {
						JOptionPane.showMessageDialog(null, "����ʽ����ߴ�����Ӧ�ô���65535��");
					} else {
						int deg = Integer.parseInt(jtf2.getText());
						p = p.add(new Polynomial(deg));
						jtf1.setText(p.toString());
					}
				}
			}
		});

		btnp2.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				resetP();
				jtf1.setText(p.toString());
			}
		});

		btnpa2.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Test.isLegalInteger(jtfa21.getText())) {
					if (new BigInteger(jtfa21.getText()).compareTo(BigInteger.valueOf(Polynomial.Max_Deg)) == 1) {
						JOptionPane.showMessageDialog(null, "����ʽ����ߴ�����Ӧ�ô���65535��");
					} else {
						int deg = Integer.parseInt(jtfa21.getText());
						a2 = a2.add(new Polynomial(deg));
						jtfa2.setText(a2.toString());
					}
				}
			}
		});

		btnpa21.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				resetA2();
				jtfa2.setText(a2.toString());
			}
		});

		btnpa6.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Test.isLegalInteger(jtfa61.getText())) {
					if (new BigInteger(jtfa61.getText()).compareTo(BigInteger.valueOf(Polynomial.Max_Deg)) == 1) {
						JOptionPane.showMessageDialog(null, "����ʽ����ߴ�����Ӧ�ô���65535��");
					} else {
						int deg = Integer.parseInt(jtfa61.getText());
						a6 = a6.add(new Polynomial(deg));
						jtfa6.setText(a6.toString());
					}
				}
			}
		});

		btnpa61.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				resetA6();
				jtfa6.setText(a6.toString());
			}
		});

		btnp3.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Test.isLegalInteger(jtf6.getText())) {
					if (new BigInteger(jtf6.getText()).compareTo(BigInteger.valueOf(Polynomial.Max_Deg)) == 1) {
						JOptionPane.showMessageDialog(null, "����ʽ����ߴ�����Ӧ�ô���65535��");
					} else {
						int deg = Integer.parseInt(jtf6.getText());
						p1[0] = p1[0].add(new Polynomial(deg));
						jtf5.setText(p1[0].toString());
					}
				}
			}
		});

		btnp4.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				resetP1X();
				jtf5.setText(p1[0].toString());
			}
		});

		btnp5.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Test.isLegalInteger(jtf8.getText())) {
					if (new BigInteger(jtf8.getText()).compareTo(BigInteger.valueOf(Polynomial.Max_Deg)) == 1) {
						JOptionPane.showMessageDialog(null, "����ʽ����ߴ�����Ӧ�ô���65535��");
					} else {
						int deg = Integer.parseInt(jtf8.getText());
						p1[1] = p1[1].add(new Polynomial(deg));
						jtf7.setText(p1[1].toString());
					}
				}
			}
		});

		btnp6.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				resetP1Y();
				jtf7.setText(p1[1].toString());
			}
		});

		btnp7.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Test.isLegalInteger(jtf10.getText())) {
					if (new BigInteger(jtf10.getText()).compareTo(BigInteger.valueOf(Polynomial.Max_Deg)) == 1) {
						JOptionPane.showMessageDialog(null, "����ʽ����ߴ�����Ӧ�ô���65535��");
					} else {
						int deg = Integer.parseInt(jtf10.getText());
						p2[0] = p2[0].add(new Polynomial(deg));
						jtf9.setText(p2[0].toString());
					}
				}
			}
		});

		btnp8.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				resetP2X();
				jtf9.setText(p2[0].toString());
			}
		});

		btnp9.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Test.isLegalInteger(jtf15.getText())) {
					if (new BigInteger(jtf15.getText()).compareTo(BigInteger.valueOf(Polynomial.Max_Deg)) == 1) {
						JOptionPane.showMessageDialog(null, "����ʽ����ߴ�����Ӧ�ô���65535��");
					} else {
						int deg = Integer.parseInt(jtf15.getText());
						p2[1] = p2[1].add(new Polynomial(deg));
						jtf11.setText(p2[1].toString());
					}
				}
			}
		});

		btnp10.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				resetP2Y();
				jtf11.setText(p2[1].toString());
			}
		});

		btnp11.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				EllipticCurveCaculationOfF2n ellipticCurveCaculationOfF2n = new EllipticCurveCaculationOfF2n(p, a2, a6);
				try {
					Polynomial[] re = ellipticCurveCaculationOfF2n.pointAdd(p1, p2);
					jtf16.setText("(" + re[0].toString() + "," + re[1].toString() + ")");
				} catch (PolyDivideException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		btnp12.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				EllipticCurveCaculationOfF2n ellipticCurveCaculationOfF2n = new EllipticCurveCaculationOfF2n(p, a2, a6);
				if (new BigInteger(jtf17.getText()).compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) == 1) {
					JOptionPane.showMessageDialog(null, "k��Ӧ�ô���65535��");
				} else {
					int k = Integer.parseInt(jtf17.getText());
					try {
						Polynomial[] re = ellipticCurveCaculationOfF2n.kPointCacul(p1, k);
						jtf18.setText("(" + re[0].toString() + "," + re[1].toString() + ")");
					} catch (PolyDivideException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}

		});

	}
}
