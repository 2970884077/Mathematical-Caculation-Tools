/**  
 * All rights Reserved, Designed By CyborgKuroChan
 * @Title:  WindowOfPrimeTest.java   
 * @Package gui   
 * @Description: ���Լ���ͼ���� 
 * @author: JinZhiyun    
 * @date:   2019��3��16�� ����12:31:31   
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
import xxaqsxjc.method0.PrimeTest;

/**   
 * @ClassName:  WindowOfPrimeTest   
 * @Description: ���Լ���ͼ���� 
 * @author: JinZhiyun
 * @date:   2019��3��16�� ����12:31:31   
 *     
 * @Copyright: 2019 CyborgKuroChan All rights reserved. 
 * ע�⣺�������ɳ������ֽ�����(wechat:Jzy_bb_1998)
 */
public class WindowOfPrimeTest {
	/**   
	 * @Title: GUIPrimeTest   
	 * @Description: �������Լ���ģ�� 
	 * @param: @param frm      
	 * @return: void      
	 * @throws   
	 */
	public static void GUIPrimeTest(JFrame frm) {
		JLabel j11 = new JLabel("7�����Լ��飺���������p�Ͱ�ȫ����k���ֱ�����������Լ�����������1��ʾ��������0��֮");
		j11.setBounds(50, 240, GUIWindow.FrameWidth, 25);
		frm.add(j11);
		
		JButton btn = new JButton("����");
		btn.setBounds(620, 240, 80, 25);
		frm.add(btn);
		

		btn.addActionListener(new ActionListener() { //��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frmHidden = new JFrame();
				frmHidden.setBounds(2*GUIWindow.FrameStartX,2* GUIWindow.FrameStartY, 850, 150); // ���ô��ڳ�ʼλ�úʹ�С
				frmHidden.setTitle("���Լ��飺���������p�Ͱ�ȫ����k���ֱ�����������Լ�����������1��ʾ��������0��֮"); // ���ñ���
				frmHidden.setLayout(null); // ���������ΪnullĬ�ϣ���ť������������ݿ򣬵�ס������ɫ
				
				
				GUIPrimeTestHidden(frmHidden);
				
				frmHidden.setVisible(true); // ��ʾ����
			}
		});

		
	}
	
	/**   
	 * @Title: GUIPrimeTestHidden   
	 * @Description: ����������������Լ���ģ�� 
	 * @param: @param frm      
	 * @return: void      
	 * @throws   
	 */
	public static void GUIPrimeTestHidden(JFrame frm) {
		JLabel j12 = new JLabel("p=");
		j12.setBounds(50, 30, 20, 25);
		frm.add(j12);
		JTextField jtf1 = new JTextField();// �����ı������
		jtf1.setBounds(70, 30, 200, 25); // ��߾࣬�ϱ߾࣬������
		frm.add(jtf1);

		JLabel j13 = new JLabel("k=");
		j13.setBounds(300, 30, 20, 25);
		frm.add(j13);
		JTextField jtf2 = new JTextField(); // �����ı������
		jtf2.setBounds(320, 30, 200, 25); // ��߾࣬�ϱ߾࣬������
		frm.add(jtf2);

		JButton btn = new JButton("����");
		btn.setBounds(550, 30, 80, 25);
		frm.add(btn);

		JLabel j14 = new JLabel("Fermat:");
		j14.setBounds(50, 60, 50, 25);
		frm.add(j14);
		JTextField jtf3 = new JTextField(); // �����ı������
		jtf3.setBounds(100, 60, 150, 25); // ��߾࣬�ϱ߾࣬������
		jtf3.setEditable(false);
		frm.add(jtf3);

		JLabel j15 = new JLabel("MillerRabin:");
		j15.setBounds(270, 60, 100, 25);
		frm.add(j15);
		JTextField jtf4 = new JTextField(); // �����ı������
		jtf4.setBounds(340, 60, 150, 25); // ��߾࣬�ϱ߾࣬������
		jtf4.setEditable(false);
		frm.add(jtf4);

		JLabel j16 = new JLabel("SolovayStassen:");
		j16.setBounds(500, 60, 150, 25);
		frm.add(j16);
		JTextField jtf5 = new JTextField(); // �����ı������
		jtf5.setBounds(600, 60, 150, 25); // ��߾࣬�ϱ߾࣬������
		jtf5.setEditable(false);
		frm.add(jtf5);

		btn.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {

				if (Test.isLegalInteger(jtf1.getText()) && Test.isLegalInteger(jtf2.getText())) {
					BigInteger n = new BigInteger(jtf1.getText());
					if (new BigInteger(jtf2.getText()).compareTo(BigInteger.valueOf(10000)) == 1) {
						JOptionPane.showMessageDialog(null, "��ȫ����k����С��" + 10000);
					} else {
						int k = Integer.parseInt(jtf2.getText());
						int f = PrimeTest.Fermat(n, k);
						int m = PrimeTest.MillerRabin(n, k);
						int s = PrimeTest.SolovayStassen(n, k);
						jtf3.setText(Integer.toString(f));
						jtf4.setText(Integer.toString(m));
						jtf5.setText(Integer.toString(s));
					}
				}
			}
		});
	
	}
}
