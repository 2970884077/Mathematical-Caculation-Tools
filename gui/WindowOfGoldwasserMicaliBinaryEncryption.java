/**  
 * All rights Reserved, Designed By CyborgKuroChan
 * @Title:  WindowOfGoldwasserMicaliBinaryEncryption.java   
 * @Package gui   
 * @Description: GoldwasserMicali�����㷨���Զ����Ƽ��ܣ�ͼ����  
 * @author: JinZhiyun    
 * @date:   2019��3��16�� ����12:38:14   
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import EncyptionAlgorithm.GoldwasserMicaliBinaryEncryption;
import someTest.Test;

/**   
 * @ClassName:  WindowOfGoldwasserMicaliBinaryEncryption   
 * @Description: GoldwasserMicali�����㷨���Զ����Ƽ��ܣ�ͼ����  
 * @author: JinZhiyun
 * @date:   2019��3��16�� ����12:38:14   
 *     
 * @Copyright: 2019 CyborgKuroChan All rights reserved. 
 * ע�⣺�������ɳ������ֽ�����(wechat:Jzy_bb_1998)
 */
public class WindowOfGoldwasserMicaliBinaryEncryption {
	/**   
	 * @Title: GUIGoldwasserMicaliBinaryEncryption   
	 * @Description: ����GoldwasserMicali�����㷨���Զ����Ƽ��ܣ� ͼ��ģ��  
	 * @param: @param frm      
	 * @return: void      
	 * @throws   
	 */
	public static void GUIGoldwasserMicaliBinaryEncryption(JFrame frm) {
		JLabel j11 = new JLabel("10��GoldwasserMicali�����㷨������ֻ����0��1�Ķ����ƴ�����pt�����������ɵĹ�˽Կ�����ģ��Լ��������ĺ�õ�������");
		j11.setBounds(50, 330, GUIWindow.FrameWidth, 25);
		frm.add(j11);

		JButton btn = new JButton("����");
		btn.setBounds(800, 330, 80, 25);
		frm.add(btn);

		btn.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frmHidden = new JFrame();
				frmHidden.setBounds(2 * GUIWindow.FrameStartX, 2 * GUIWindow.FrameStartY, 1000, 600); // ���ô��ڳ�ʼλ�úʹ�С
				frmHidden.setTitle("GoldwasserMicali�����㷨������ֻ����0��1�Ķ����ƴ�����pt�����������ɵĹ�˽Կ�����ģ��Լ��������ĺ�õ�������"); // ���ñ���
				frmHidden.setLayout(null); // ���������ΪnullĬ�ϣ���ť������������ݿ򣬵�ס������ɫ

				GUIGoldwasserMicaliBinaryEncryptionHidden(frmHidden);

				frmHidden.setVisible(true); // ��ʾ����
			}
		});
	}
	
	/**   
	 * @Title: GUIGoldwasserMicaliBinaryEncryptionHidden   
	 * @Description: ���������GoldwasserMicali�����㷨���Զ����Ƽ��ܣ� ͼ��ģ��     
	 * @param: @param frm      
	 * @return: void      
	 * @throws   
	 */
	public static void GUIGoldwasserMicaliBinaryEncryptionHidden(JFrame frm) {
		JLabel j12 = new JLabel("����pt=");
		j12.setBounds(50, 30, 50, 25);
		frm.add(j12);
		JTextField jtf1 = new JTextField();// �����ı������
		jtf1.setBounds(100, 30, 700, 25); // ��߾࣬�ϱ߾࣬������
		frm.add(jtf1);

		JButton btn = new JButton("����");
		btn.setBounds(810, 30, 80, 25);
		frm.add(btn);

		JLabel j14 = new JLabel("˽Կp=");
		j14.setBounds(50, 60, 80, 25);
		frm.add(j14);
		JTextField jtf3 = new JTextField(); // �����ı������
		jtf3.setBounds(100, 60, 850, 25); // ��߾࣬�ϱ߾࣬������
		jtf3.setEditable(false);
		frm.add(jtf3);

		JLabel j15 = new JLabel("˽Կq=");
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

		JLabel j17 = new JLabel("��Կx=");
		j17.setBounds(50, 150, 80, 25);
		frm.add(j17);
		JTextField jtf6 = new JTextField(); // �����ı������
		jtf6.setBounds(100, 150, 850, 25); // ��߾࣬�ϱ߾࣬������
		jtf6.setEditable(false);
		frm.add(jtf6);
		
		JLabel j18 = new JLabel("����ct=");
		j18.setBounds(50, 180, 80, 25);
		frm.add(j18);
		JTextArea jta1=new JTextArea();
		jta1.setEditable(false);
		JScrollPane jsp1=new JScrollPane(jta1);
		jsp1.setBounds(105, 180, 845, 300);
		frm.add(jsp1);

		JLabel j19 = new JLabel("���ܺ������d_pt=");
		j19.setBounds(50, 490, 150, 25);
		frm.add(j19);
		JTextField jtf7 = new JTextField(); // �����ı������
		jtf7.setBounds(170, 490, 780, 25); // ��߾࣬�ϱ߾࣬������
		jtf7.setEditable(false);
		frm.add(jtf7);


		btn.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!Test.isOnlyContain01(jtf1.getText())) {
					JOptionPane.showMessageDialog(null, "�������뺬0��1���ַ�����");
				}
				else {
					GoldwasserMicaliBinaryEncryption goldwasserMicaliBinaryEncryption=new GoldwasserMicaliBinaryEncryption(jtf1.getText());
					BigInteger p = goldwasserMicaliBinaryEncryption.getP();
					BigInteger q = goldwasserMicaliBinaryEncryption.getQ();
					BigInteger n = goldwasserMicaliBinaryEncryption.getN();
					BigInteger x = goldwasserMicaliBinaryEncryption.getX();
					jtf3.setText(p.toString());
					jtf4.setText(q.toString());
					jtf5.setText(n.toString());
					jtf6.setText(x.toString());
					goldwasserMicaliBinaryEncryption.GoldwasserMicali_encrypt();
					jta1.setText(goldwasserMicaliBinaryEncryption.toStringShowCt());
					jtf7.setText(goldwasserMicaliBinaryEncryption.GoldwasserMicali_decrypt());
				}
			}

		});
	}
}
