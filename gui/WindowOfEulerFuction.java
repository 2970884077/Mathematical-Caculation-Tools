/**  
 * All rights Reserved, Designed By CyborgKuroChan
 * @Title:  WindowOfEulerFuction.java   
 * @Package gui   
 * @Description:  ŷ������ֵ�ļ���ͼ���� 
 * @author: JinZhiyun    
 * @date:   2019��3��16�� ����12:25:05   
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
import javax.swing.JTextField;

import xxaqsxjc.method0.EulerFuction;
import someTest.Test;

/**   
 * @ClassName:  WindowOfEulerFuction   
 * @Description: ŷ������ֵ�ļ���ͼ���� 
 * @author: JinZhiyun
 * @date:   2019��3��16�� ����12:25:05   
 *     
 * @Copyright: 2019 CyborgKuroChan All rights reserved. 
 * ע�⣺�������ɳ������ֽ�����(wechat:Jzy_bb_1998)
 */
public class WindowOfEulerFuction {

	/**   
	 * @Title: GUIEulerFuction   
	 * @Description: ŷ������ֵ�ļ���ģ��
	 * @param: @param frm      
	 * @return: void      
	 * @throws   
	 */ 
	public static void GUIEulerFuction(JFrame frm) {
		JLabel j11 = new JLabel("4��ŷ������ֵ�ļ��㣺����n������n��ŷ������ֵEuler(n)");
		j11.setBounds(50, 150, GUIWindow.FrameWidth, 25);
		frm.add(j11);

		JButton btn = new JButton("����");
		btn.setBounds(400, 150, 80, 25);
		frm.add(btn);

		btn.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frmHidden = new JFrame();
				frmHidden.setBounds(2 * GUIWindow.FrameStartX, 2 * GUIWindow.FrameStartY, 500, 150); // ���ô��ڳ�ʼλ�úʹ�С
				frmHidden.setTitle("ŷ������ֵ�ļ��㣺����n������n��ŷ������ֵEuler(n)"); // ���ñ���
				frmHidden.setLayout(null); // ���������ΪnullĬ�ϣ���ť������������ݿ򣬵�ס������ɫ

				GUIEulerFuctionHidden(frmHidden);

				frmHidden.setVisible(true); // ��ʾ����
			}
		});
	}
	
	/**   
	 * @Title: GUIEulerFuctionHidden   
	 * @Description: ���������ŷ������ֵ�ļ���ģ��   
	 * @param: @param frm      
	 * @return: void      
	 * @throws   
	 */ 
	public static void GUIEulerFuctionHidden(JFrame frm) {
		JLabel j12 = new JLabel("n=");
		j12.setBounds(50, 30, 20, 25);
		frm.add(j12);
		JTextField jtf1 = new JTextField();// �����ı������
		jtf1.setBounds(70, 30, 250, 25); // ��߾࣬�ϱ߾࣬������
		frm.add(jtf1);

		JButton btn = new JButton("����");
		btn.setBounds(340, 30, 80, 25);
		frm.add(btn);

		JLabel j14 = new JLabel("Euler(n)=");
		j14.setBounds(50, 60, 80, 25);
		frm.add(j14);
		JTextField jtf3 = new JTextField(); // �����ı������
		jtf3.setBounds(110, 60, 250, 25); // ��߾࣬�ϱ߾࣬������
		jtf3.setEditable(false);
		frm.add(jtf3);

		btn.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Test.isLegalInteger(jtf1.getText())) {
					BigInteger n = new BigInteger(jtf1.getText());
					BigInteger Euler_n = EulerFuction.Euler(n);
					jtf3.setText(Euler_n.toString());
				}
			}
		});
	}
}
