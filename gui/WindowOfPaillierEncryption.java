/**  
 * All rights Reserved, Designed By CyborgKuroChan
 * @Title:  WindowOfPaillierEncryption.java   
 * @Package gui   
 * @Description: Paillier�����㷨��
 * @author: JinZhiyun    
 * @date:   2019��3��16�� ����12:35:37   
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

import EncyptionAlgorithm.PaillierEncryption;

/**   
 * @ClassName:  WindowOfPaillierEncryption   
 * @Description: Paillier�����㷨��   
 * @author: JinZhiyun
 * @date:   2019��3��16�� ����12:35:37   
 *     
 * @Copyright: 2019 CyborgKuroChan All rights reserved. 
 * ע�⣺�������ɳ������ֽ�����(wechat:Jzy_bb_1998)
 */
public class WindowOfPaillierEncryption {

	/**   
	 * @Title: GUIPaillierEncryption   
	 * @Description: ����Paillier�����㷨ģ��  
	 * @param: @param frm      
	 * @return: void      
	 * @throws   
	 */
	public static void GUIPaillierEncryption(JFrame frm) {
		JLabel j11 = new JLabel("9��Paillier�����㷨����������pt�����������ɵĹ�˽Կ�����ģ��Լ��������ĺ�õ�������");
		j11.setBounds(50, 300, GUIWindow.FrameWidth, 25);
		frm.add(j11);

		JButton btn = new JButton("����");
		btn.setBounds(610, 300, 80, 25);
		frm.add(btn);

		btn.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frmHidden = new JFrame();
				frmHidden.setBounds(2 * GUIWindow.FrameStartX, 2 * GUIWindow.FrameStartY, 1000, 300); // ���ô��ڳ�ʼλ�úʹ�С
				frmHidden.setTitle("Paillier�����㷨����������pt�����������ɵĹ�˽Կ�����ģ��Լ��������ĺ�õ�������"); // ���ñ���
				frmHidden.setLayout(null); // ���������ΪnullĬ�ϣ���ť������������ݿ򣬵�ס������ɫ

				GUIPaillierEncryptionHidden(frmHidden);

				frmHidden.setVisible(true); // ��ʾ����
			}
		});
	}
	
	/**   
	 * @Title: GUIPaillierEncryptionHidden   
	 * @Description: ���������Paillier�����㷨ģ��  
	 * @param: @param frm      
	 * @return: void      
	 * @throws   
	 */
	public static void GUIPaillierEncryptionHidden(JFrame frm) {
		JLabel j12 = new JLabel("����pt=");
		j12.setBounds(50, 30, 50, 25);
		frm.add(j12);
		JTextField jtf1 = new JTextField();// �����ı������
		jtf1.setBounds(100, 30, 700, 25); // ��߾࣬�ϱ߾࣬������
		frm.add(jtf1);

		JButton btn = new JButton("����");
		btn.setBounds(810, 30, 80, 25);
		frm.add(btn);

		JLabel j14 = new JLabel("˽Կ��=");
		j14.setBounds(50, 60, 80, 25);
		frm.add(j14);
		JTextField jtf3 = new JTextField(); // �����ı������
		jtf3.setBounds(100, 60, 850, 25); // ��߾࣬�ϱ߾࣬������
		jtf3.setEditable(false);
		frm.add(jtf3);

		JLabel j15 = new JLabel("˽Կ��=");
		j15.setBounds(50, 90, 80, 25);
		frm.add(j15);
		JTextField jtf4 = new JTextField(); // �����ı������
		jtf4.setBounds(100, 90, 850, 25); // ��߾࣬�ϱ߾࣬������
		jtf4.setEditable(false);
		frm.add(jtf4);

		JLabel j16 = new JLabel("��Կn=");
		j16.setBounds(50, 120, 80, 25);
		frm.add(j16);
		JTextField jtf5 = new JTextField(); // �����ı������
		jtf5.setBounds(100, 120, 850, 25); // ��߾࣬�ϱ߾࣬������
		jtf5.setEditable(false);
		frm.add(jtf5);

		JLabel j17 = new JLabel("��Կg=");
		j17.setBounds(50, 150, 80, 25);
		frm.add(j17);
		JTextField jtf6 = new JTextField(); // �����ı������
		jtf6.setBounds(100, 150, 850, 25); // ��߾࣬�ϱ߾࣬������
		jtf6.setEditable(false);
		frm.add(jtf6);
		
		JLabel j18 = new JLabel("����ct=");
		j18.setBounds(50, 180, 80, 25);
		frm.add(j18);
		JTextField jtf7 = new JTextField(); // �����ı������
		jtf7.setBounds(105, 180, 845, 25); // ��߾࣬�ϱ߾࣬������
		jtf7.setEditable(false);
		frm.add(jtf7);

		JLabel j19 = new JLabel("���ܺ������d_pt=");
		j19.setBounds(50, 210, 150, 25);
		frm.add(j19);
		JTextField jtf8 = new JTextField(); // �����ı������
		jtf8.setBounds(170, 210, 780, 25); // ��߾࣬�ϱ߾࣬������
		jtf8.setEditable(false);
		frm.add(jtf8);

		btn.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				PaillierEncryption paillierEncryption=new PaillierEncryption(jtf1.getText());
				jtf3.setText(paillierEncryption.getEuler_n().toString());
				jtf4.setText(paillierEncryption.getL_1().toString());
				jtf5.setText(paillierEncryption.getN().toString());
				jtf6.setText(paillierEncryption.getG().toString());
				jtf7.setText(paillierEncryption.Paillier_encrypt());
				jtf8.setText(paillierEncryption.Paillier_decrypt());
			}

		});
	}
}
