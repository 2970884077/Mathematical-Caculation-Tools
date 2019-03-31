/**  
 * All rights Reserved, Designed By CyborgKuroChan
 * @Title:  WindowOfEllipticCurveCaculationOfFp.java   
 * @Package gui   
 * @Description: Fp�ϵ���Բ����y^2=x^3+a4*x+a6�ĵ�ļ���ͼ����   
 * @author: JinZhiyun    
 * @date:   2019��3��16�� ����4:01:43   
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
import xxaqsxjc.method1.EllipticCurveCaculationOfFp;

/**   
 * @ClassName:  WindowOfEllipticCurveCaculationOfFp   
 * @Description: Fp�ϵ���Բ����y^2=x^3+a4*x+a6�ĵ�ļ���ͼ����   
 * @author: JinZhiyun
 * @date:   2019��3��16�� ����4:01:43   
 *     
 * @Copyright: 2019 CyborgKuroChan All rights reserved. 
 * ע�⣺�������ɳ������ֽ�����(wechat:Jzy_bb_1998)
 */
public class WindowOfEllipticCurveCaculationOfFp {
	/**   
	 * @Title: GUIEllipticCurveCaculationOfFp   
	 * @Description: ����Fp�ϵ���Բ���߼���ͼ��ģ��   
	 * @param: @param frm      
	 * @return: void      
	 * @throws   
	 */
	public static void GUIEllipticCurveCaculationOfFp(JFrame frm) {
		JLabel j11 = new JLabel("13��Fp�ϵ���Բ����y^2=x^3+a4*x+a6�ϵ�ļ���");
		j11.setBounds(50, 420, GUIWindow.FrameWidth, 25);
		frm.add(j11);

		JButton btn = new JButton("����");
		btn.setBounds(350, 420, 80, 25);
		frm.add(btn);

		btn.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frmHidden = new JFrame();
				frmHidden.setBounds(2 * GUIWindow.FrameStartX, 2 * GUIWindow.FrameStartY, 800, 350); // ���ô��ڳ�ʼλ�úʹ�С
				frmHidden.setTitle("Fp�ϵ���Բ����y^2=x^3+a4*x+a6�ϵ�ļ���"); // ���ñ���
				frmHidden.setLayout(null); // ���������ΪnullĬ�ϣ���ť������������ݿ򣬵�ס������ɫ

				GUIEllipticCurveCaculationOfFpHidden(frmHidden);

				frmHidden.setVisible(true); // ��ʾ����
			}
		});
	}
	
	/**   
	 * @Title: GUIEllipticCurveCaculationOfFpHidden   
	 * @Description: ���������Fp�ϵ���Բ���߼���ͼ��ģ��  
	 * @param: @param frm      
	 * @return: void      
	 * @throws   
	 */
	public static void GUIEllipticCurveCaculationOfFpHidden(JFrame frm) {
		JLabel j11 = new JLabel("��������p��ϵ��a4��a6:");
		j11.setBounds(50, 30, 200, 25);
		frm.add(j11);

		JLabel j12 = new JLabel("p=");
		j12.setBounds(50, 60, 50, 25);
		frm.add(j12);
		JTextField jtf1 = new JTextField();// �����ı������
		jtf1.setBounds(70, 60, 200, 25); // ��߾࣬�ϱ߾࣬������
		frm.add(jtf1);

		JLabel j13 = new JLabel("a4=");
		j13.setBounds(295, 60, 50, 25);
		frm.add(j13);
		JTextField jtf2 = new JTextField(); // �����ı������
		jtf2.setBounds(320, 60, 150, 25); // ��߾࣬�ϱ߾࣬������
		frm.add(jtf2);

		JLabel j14 = new JLabel("a6=");
		j14.setBounds(490, 60, 50, 25);
		frm.add(j14);
		JTextField jtf3 = new JTextField();// �����ı������
		jtf3.setBounds(515, 60, 150, 25); // ��߾࣬�ϱ߾࣬������
		frm.add(jtf3);

		JLabel j15 = new JLabel("��P1(P1x,P1y):    P1x=");
		j15.setBounds(50, 90, 150, 25);
		frm.add(j15);
		JTextField jtf4 = new JTextField(); // �����ı������
		jtf4.setBounds(180, 90, 200, 25); // ��߾࣬�ϱ߾࣬������
		frm.add(jtf4);

		JLabel j16 = new JLabel("P1y=");
		j16.setBounds(400, 90, 50, 25);
		frm.add(j16);
		JTextField jtf5 = new JTextField(); // �����ı������
		jtf5.setBounds(435, 90, 200, 25); // ��߾࣬�ϱ߾࣬������
		frm.add(jtf5);

		JLabel j17 = new JLabel("��P2(P2x,P2y):    P2x=");
		j17.setBounds(50, 120, 150, 25);
		frm.add(j17);
		JTextField jtf6 = new JTextField(); // �����ı������
		jtf6.setBounds(180, 120, 200, 25); // ��߾࣬�ϱ߾࣬������
		frm.add(jtf6);

		JLabel j18 = new JLabel("P2y=");
		j18.setBounds(400, 120, 50, 25);
		frm.add(j18);
		JTextField jtf7 = new JTextField(); // �����ı������
		jtf7.setBounds(435, 120, 200, 25); // ��߾࣬�ϱ߾࣬������
		frm.add(jtf7);

		JLabel j19 = new JLabel("���㣺");
		j19.setBounds(50, 150, 50, 25);
		frm.add(j19);

		JLabel j110 = new JLabel("����Բ���ߵĽ�=");
		j110.setBounds(50, 180, 150, 25);
		frm.add(j110);
		JTextField jtf8 = new JTextField(); // �����ı������
		jtf8.setBounds(155, 180, 200, 25); // ��߾࣬�ϱ߾࣬������
		jtf8.setEditable(false);
		frm.add(jtf8);
		JButton btnp1 = new JButton("����");
		btnp1.setBounds(380, 180, 80, 25);
		frm.add(btnp1);

		JLabel j111 = new JLabel("P1+P2=");
		j111.setBounds(50, 210, 150, 25);
		frm.add(j111);
		JTextField jtf9 = new JTextField(); // �����ı������
		jtf9.setBounds(100, 210, 200, 25); // ��߾࣬�ϱ߾࣬������
		jtf9.setEditable(false);
		frm.add(jtf9);
		JButton btnp2 = new JButton("����");
		btnp2.setBounds(320, 210, 80, 25);
		frm.add(btnp2);

		JLabel j112 = new JLabel("k��P1�ļ��㣺        k=");
		j112.setBounds(50, 240, 200, 25);
		frm.add(j112);
		JTextField jtf10 = new JTextField(); // �����ı������
		jtf10.setBounds(180, 240, 100, 25); // ��߾࣬�ϱ߾࣬������
		frm.add(jtf10);
		JLabel j113 = new JLabel("k��P1=");
		j113.setBounds(300, 240, 100, 25);
		frm.add(j113);
		JTextField jtf11 = new JTextField(); // �����ı������
		jtf11.setBounds(345, 240, 150, 25); // ��߾࣬�ϱ߾࣬������
		jtf11.setEditable(false);
		frm.add(jtf11);
		JButton btnp3 = new JButton("����");
		btnp3.setBounds(520, 240, 80, 25);
		frm.add(btnp3);

		btnp1.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Test.isLegalInteger(jtf1.getText()) && Test.isLegalInteger(jtf2.getText())
						&& Test.isLegalInteger(jtf3.getText())) {
					BigInteger p = new BigInteger(jtf1.getText());
					BigInteger a4 = new BigInteger(jtf2.getText());
					BigInteger a6 = new BigInteger(jtf3.getText());
					EllipticCurveCaculationOfFp ellipticCurveCaculationOfFp = new EllipticCurveCaculationOfFp(p, a4,
							a6);
					jtf8.setText(ellipticCurveCaculationOfFp.ordFp().toString());
				}
			}
		});

		btnp2.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Test.isLegalInteger(jtf1.getText()) && Test.isLegalInteger(jtf2.getText())
						&& Test.isLegalInteger(jtf3.getText()) && Test.isLegalInteger(jtf4.getText())
						&& Test.isLegalInteger(jtf5.getText()) && Test.isLegalInteger(jtf6.getText())
						&& Test.isLegalInteger(jtf7.getText())) {
					BigInteger p = new BigInteger(jtf1.getText());
					BigInteger a4 = new BigInteger(jtf2.getText());
					BigInteger a6 = new BigInteger(jtf3.getText());
					EllipticCurveCaculationOfFp ellipticCurveCaculationOfFp = new EllipticCurveCaculationOfFp(p, a4,
							a6);
					BigInteger[] p1 = { new BigInteger(jtf4.getText()), new BigInteger(jtf5.getText()) };
					BigInteger[] p2 = { new BigInteger(jtf6.getText()), new BigInteger(jtf7.getText()) };
					BigInteger[] result = ellipticCurveCaculationOfFp.pointAdd(p1, p2);
					jtf9.setText("(" + result[0].toString() + "," + result[1].toString() + ")");
				}
			}
		});

		btnp3.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Test.isLegalInteger(jtf1.getText()) && Test.isLegalInteger(jtf2.getText())
						&& Test.isLegalInteger(jtf3.getText()) && Test.isLegalInteger(jtf4.getText())
						&& Test.isLegalInteger(jtf5.getText()) && Test.isLegalInteger(jtf10.getText())) {
					if (new BigInteger(jtf10.getText()).compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) == 1) {
						JOptionPane.showMessageDialog(null, "k��Ӧ�ô���65535��");
					} else {
						BigInteger p = new BigInteger(jtf1.getText());
						BigInteger a4 = new BigInteger(jtf2.getText());
						BigInteger a6 = new BigInteger(jtf3.getText());
						EllipticCurveCaculationOfFp ellipticCurveCaculationOfFp = new EllipticCurveCaculationOfFp(p, a4,
								a6);
						BigInteger[] p1 = { new BigInteger(jtf4.getText()), new BigInteger(jtf5.getText()) };
						int k = Integer.parseInt(jtf10.getText());
						BigInteger[] result = ellipticCurveCaculationOfFp.kPointCacul(p1, k);
						jtf11.setText("(" + result[0].toString() + "," + result[1].toString() + ")");
					}

				}
			}
		});
	}
}
