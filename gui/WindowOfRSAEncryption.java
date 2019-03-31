/**  
 * All rights Reserved, Designed By CyborgKuroChan
 * @Title:  WindowOfRSAEncryption.java   
 * @Package gui   
 * @Description: RSA�����㷨 ͼ����    
 * @author: JinZhiyun    
 * @date:   2019��3��16�� ����12:33:39   
 * @version V1.0 
 * @Copyright: 2019 CyborgKuroChan All rights reserved. 
 * ע�⣺�������ɳ������ֽ�����(wechat:Jzy_bb_1998)
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import EncyptionAlgorithm.RSAEncryption;

/**   
 * @ClassName:  WindowOfRSAEncryption   
 * @Description: RSA�����㷨 ͼ����  
 * @author: JinZhiyun
 * @date:   2019��3��16�� ����12:33:39   
 *     
 * @Copyright: 2019 CyborgKuroChan All rights reserved. 
 * ע�⣺�������ɳ������ֽ�����(wechat:Jzy_bb_1998)
 */
public class WindowOfRSAEncryption {
	
	/**   
	 * @Title: GUIRSAEncryption   
	 * @Description: ����RSA�����㷨 ͼ��ģ��   
	 * @param: @param frm      
	 * @return: void      
	 * @throws   
	 */
	public static void GUIRSAEncryption(JFrame frm) {
		JLabel j11 = new JLabel("8��RSA�����㷨����������pt�����������ɵĹ�˽Կ�����ģ��Լ��������ĺ�õ�������");
		j11.setBounds(50, 270, GUIWindow.FrameWidth, 25);
		frm.add(j11);

		JButton btn = new JButton("����");
		btn.setBounds(590, 270, 80, 25);
		frm.add(btn);

		btn.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frmHidden = new JFrame();
				frmHidden.setBounds(2 * GUIWindow.FrameStartX, 2 * GUIWindow.FrameStartY, 1000, 280); // ���ô��ڳ�ʼλ�úʹ�С
				frmHidden.setTitle("RSA�����㷨����������pt�����������ɵĹ�˽Կ�����ģ��Լ��������ĺ�õ�������"); // ���ñ���
				frmHidden.setLayout(null); // ���������ΪnullĬ�ϣ���ť������������ݿ򣬵�ס������ɫ

				GUIRSAEncryptionHidden(frmHidden);

				frmHidden.setVisible(true); // ��ʾ����
			}
		});
	}

	/**   
	 * @Title: GUIRSAEncryptionHidden   
	 * @Description: ���������RSA�����㷨 ͼ��ģ��    
	 * @param: @param frm      
	 * @return: void      
	 * @throws   
	 */
	public static void GUIRSAEncryptionHidden(JFrame frm) {
		JLabel j12 = new JLabel("����pt=");
		j12.setBounds(50, 30, 50, 25);
		frm.add(j12);
		JTextField jtf1 = new JTextField();// �����ı������
		jtf1.setBounds(100, 30, 700, 25); // ��߾࣬�ϱ߾࣬������
		frm.add(jtf1);

		JButton btn = new JButton("����");
		btn.setBounds(810, 30, 80, 25);
		frm.add(btn);

		JLabel j14 = new JLabel("˽Կd=");
		j14.setBounds(50, 60, 80, 25);
		frm.add(j14);
		JTextField jtf3 = new JTextField(); // �����ı������
		jtf3.setBounds(100, 60, 850, 25); // ��߾࣬�ϱ߾࣬������
		jtf3.setEditable(false);
		frm.add(jtf3);

		JLabel j15 = new JLabel("��Կn=");
		j15.setBounds(50, 90, 80, 25);
		frm.add(j15);
		JTextField jtf4 = new JTextField(); // �����ı������
		jtf4.setBounds(100, 90, 850, 25); // ��߾࣬�ϱ߾࣬������
		jtf4.setEditable(false);
		frm.add(jtf4);

		JLabel j16 = new JLabel("��Կe=");
		j16.setBounds(50, 120, 80, 25);
		frm.add(j16);
		JTextField jtf5 = new JTextField(); // �����ı������
		jtf5.setBounds(100, 120, 850, 25); // ��߾࣬�ϱ߾࣬������
		jtf5.setEditable(false);
		frm.add(jtf5);

		JLabel j17 = new JLabel("����ct=");
		j17.setBounds(50, 150, 80, 25);
		frm.add(j17);
		JTextField jtf6 = new JTextField(); // �����ı������
		jtf6.setBounds(105, 150, 845, 25); // ��߾࣬�ϱ߾࣬������
		jtf6.setEditable(false);
		frm.add(jtf6);

		JLabel j18 = new JLabel("���ܺ������d_pt=");
		j18.setBounds(50, 180, 150, 25);
		frm.add(j18);
		JTextField jtf7 = new JTextField(); // �����ı������
		jtf7.setBounds(170, 180, 780, 25); // ��߾࣬�ϱ߾࣬������
		jtf7.setEditable(false);
		frm.add(jtf7);

		btn.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				RSAEncryption rsaEncryption = new RSAEncryption(jtf1.getText());
				jtf3.setText(rsaEncryption.getD().toString());
				jtf4.setText(rsaEncryption.getN().toString());
				jtf5.setText(rsaEncryption.getE().toString());
				jtf6.setText(rsaEncryption.RSA_encrypt());
				jtf7.setText(rsaEncryption.RSA_decrypt());
			}

		});
	}
}
