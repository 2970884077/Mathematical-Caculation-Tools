/**  
 * All rights Reserved, Designed By CyborgKuroChan
 * @Title:  WindowOfZgsydl.java   
 * @Package gui   
 * @Description: �й�ʣ�ඨ�����ͼ����  
 * @author: JinZhiyun    
 * @date:   2019��3��16�� ����12:40:12   
 * @version V1.0 
 * @Copyright: 2019 CyborgKuroChan All rights reserved. 
 * ע�⣺�������ɳ������ֽ�����(wechat:Jzy_bb_1998)
 */
package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import someTest.Test;
import xxaqsxjc.method0.Zgsydl;

/**   
 * @ClassName:  WindowOfZgsydl   
 * @Description: �й�ʣ�ඨ�����ͼ���� 
 * @author: JinZhiyun
 * @date:   2019��3��16�� ����12:40:12   
 *     
 * @Copyright: 2019 CyborgKuroChan All rights reserved. 
 * ע�⣺�������ɳ������ֽ�����(wechat:Jzy_bb_1998)
 */
public class WindowOfZgsydl {
	/**   
	 * @Title: GUIZgsydl   
	 * @Description: �����й�ʣ�ඨ�����ͼ��ģ��  
	 * @param: @param frm      
	 * @return: void      
	 * @throws   
	 */
	public static void GUIZgsydl(JFrame frm) {
		JLabel j11 = new JLabel("11���й�ʣ�ඨ����⣬�����飺xͬ��b ģ m�����뷽�̸���n���Լ�ÿ�����̵�ϵ�������ؽ�x=?+?*q(qΪ����)");
		j11.setBounds(50, 360, GUIWindow.FrameWidth, 25);
		frm.add(j11);

		JButton btn = new JButton("����");
		btn.setBounds(710, 360, 80, 25);
		frm.add(btn);

		btn.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frmHidden = new JFrame();
				frmHidden.setBounds(2 * GUIWindow.FrameStartX, 2 * GUIWindow.FrameStartY, 800, 150); // ���ô��ڳ�ʼλ�úʹ�С
				frmHidden.setTitle("�й�ʣ�ඨ����⣬�����飺xͬ��b ģ m�����뷽�̸���n���Լ�ÿ�����̵�ϵ�������ؽ�x=?+?*q(qΪ����)"); // ���ñ���
				frmHidden.setLayout(null); // ���������ΪnullĬ�ϣ���ť������������ݿ򣬵�ס������ɫ

				GUIZgsydlHidden(frmHidden);

				frmHidden.setVisible(true); // ��ʾ����
			}
		});

	}
	
	/**   
	 * @Title: GUIZgsydlHidden   
	 * @Description: ����������й�ʣ�ඨ�����ͼ��ģ��   
	 * @param: @param frm      
	 * @return: void      
	 * @throws   
	 */
	public static void GUIZgsydlHidden(JFrame frm) {
		JLabel j12 = new JLabel("�������뷽�̸���n��");
		j12.setBounds(50, 30, 150, 25);
		frm.add(j12);
		JTextField jtf1 = new JTextField();// �����ı������
		jtf1.setBounds(180, 30, 200, 25); // ��߾࣬�ϱ߾࣬������
		frm.add(jtf1);

		JButton btn = new JButton("ȷ��");
		btn.setBounds(390, 30, 80, 25);
		frm.add(btn);

		btn.addActionListener(new ActionListener() { // ��ȷ������ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Test.isLegalInteger(jtf1.getText())) { // ���̸����ĺϷ��Լ���
					if (new BigInteger(jtf1.getText()).compareTo(BigInteger.valueOf(25)) == -1) { // �޶����̸���С�ڵ���25
						int num = Integer.parseInt(jtf1.getText());

						frm.setBounds(2 * GUIWindow.FrameStartX, 2 * GUIWindow.FrameStartY, 800, 60 + num * 30 + 150);

						JLabel j13 = new JLabel("�����뷽��xͬ��b[i] ģ m[i]��ϵ��");
						j13.setBounds(50, 60, 200, 25);
						frm.add(j13);

						int yBase = 90; // ��ֱ����ĳ�ʼλ��ֵ

						JLabel[] j14 = new JLabel[num]; // bϵ����
						JTextField[] jtf3 = new JTextField[num];

						JLabel[] j15 = new JLabel[num]; // mϵ����
						JTextField[] jtf4 = new JTextField[num];

						for (int i = 0; i < num; i++) {
							j14[i] = new JLabel("��" + (i + 1) + "������ϵ���� b[" + i + "]=");
							j14[i].setBounds(50, yBase + i * 30, 150, 25);
							frm.add(j14[i]);

							jtf3[i] = new JTextField();
							jtf3[i].setBounds(200, yBase + i * 30, 150, 25);
							frm.add(jtf3[i]);

							j15[i] = new JLabel("m[" + i + "]=");
							j15[i].setBounds(380, yBase + i * 30, 150, 25);
							frm.add(j15[i]);

							jtf4[i] = new JTextField();
							jtf4[i].setBounds(430, yBase + i * 30, 150, 25);
							frm.add(jtf4[i]);

						}

						JButton btnCacul = new JButton("����");
						btnCacul.setBounds(50, yBase + num * 30, 80, 25);
						frm.add(btnCacul);

						JLabel j16 = new JLabel("��ͬ�෽����Ľ�Ϊ��x=");
						j16.setBounds(150, yBase + num * 30, 150, 25);
						frm.add(j16);
						JTextField jtf5 = new JTextField(); // �����ı������
						jtf5.setBounds(300, yBase + num * 30, 450, 25); // ��߾࣬�ϱ߾࣬������
						jtf5.setEditable(false);
						frm.add(jtf5);

						JLabel j17 = new JLabel("��Ҫ�ı䷽�̸��������˳������½��룡");
						j17.setBounds(50, yBase + num * 30 + 30, 250, 25);
						j17.setForeground(Color.red);
						frm.add(j17);

						btnCacul.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
							@Override
							public void actionPerformed(ActionEvent e) {
								BigInteger[] b = new BigInteger[num];
								BigInteger[] m = new BigInteger[num];
								for (int i = 0; i < num; i++) {
									b[i] = new BigInteger(jtf3[i].getText());
									m[i] = new BigInteger(jtf4[i].getText());
								}

								Zgsydl zgsydl = new Zgsydl();
								BigInteger[] x = zgsydl.zgsydl_solve(b, m);

								jtf5.setText(x[0] + "+" + x[1] + "*q(qΪ����)");

							}
						});
					} else {
						JOptionPane.showMessageDialog(null, "���̸���ӦС�ڵ���25��");
					}
				}
			}
		});

	}
}
