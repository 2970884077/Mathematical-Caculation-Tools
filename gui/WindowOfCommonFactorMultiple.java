/**  
 * All rights Reserved, Designed By CyborgKuroChan
 * @Title:  WindowOfCommonFactorMultiple.java   
 * @Package gui   
 * @Description: �����������С�������ļ���ͼ���� 
 * @author: JinZhiyun    
 * @date:   2019��3��16�� ����12:21:40   
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

import xxaqsxjc.method0.CommonFactorMultiple;
import someTest.Test;

/**   
 * @ClassName:  WindowOfCommonFactorMultiple   
 * @Description: �����������С�������ļ���ͼ����  
 * @author: JinZhiyun
 * @date:   2019��3��16�� ����12:21:40   
 *     
 * @Copyright: 2019 CyborgKuroChan All rights reserved. 
 * ע�⣺�������ɳ������ֽ�����(wechat:Jzy_bb_1998)
 */
public class WindowOfCommonFactorMultiple {

	/**   
	 * @Title: GUICommonFactorMultiple   
	 * @Description: �����������С�������ļ���ģ��   
	 * @param: @param frm      
	 * @return: void      
	 * @throws   
	 */ 
	public static void GUICommonFactorMultiple(JFrame frm) {
		JLabel j11 = new JLabel("3�������������С���������㣺����x,y������(x,y)��[x,y]");
		j11.setBounds(50, 120, GUIWindow.FrameWidth, 25);
		frm.add(j11);

		JButton btn = new JButton("����");
		btn.setBounds(410, 120, 80, 25);
		frm.add(btn);

		btn.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frmHidden = new JFrame();
				frmHidden.setBounds(2 * GUIWindow.FrameStartX, 2 * GUIWindow.FrameStartY, 700, 150); // ���ô��ڳ�ʼλ�úʹ�С
				frmHidden.setTitle("�����������С���������㣺����x,y������(x,y)��[x,y]"); // ���ñ���
				frmHidden.setLayout(null); // ���������ΪnullĬ�ϣ���ť������������ݿ򣬵�ס������ɫ

				GUICommonFactorMultipleHidden(frmHidden);

				frmHidden.setVisible(true); // ��ʾ����
			}
		});
	}
	
	/**   
	 * @Title: GUICommonFactorMultipleHidden   
	 * @Description: ��������������������С�������ļ���ģ��    
	 * @param: @param frm      
	 * @return: void      
	 * @throws   
	 */ 
	public static void GUICommonFactorMultipleHidden(JFrame frm) {
		JLabel j12 = new JLabel("x=");
		j12.setBounds(50, 30, 20, 25);
		frm.add(j12);
		JTextField jtf1 = new JTextField();// �����ı������
		jtf1.setBounds(70, 30, 200, 25); // ��߾࣬�ϱ߾࣬������
		frm.add(jtf1);

		JLabel j13 = new JLabel("y=");
		j13.setBounds(300, 30, 20, 25);
		frm.add(j13);
		JTextField jtf2 = new JTextField(); // �����ı������
		jtf2.setBounds(320, 30, 200, 25); // ��߾࣬�ϱ߾࣬������
		frm.add(jtf2);

		JButton btn = new JButton("����");
		btn.setBounds(550, 30, 80, 25);
		frm.add(btn);

		JLabel j14 = new JLabel("(x,y)=");
		j14.setBounds(50, 60, 50, 25);
		frm.add(j14);
		JTextField jtf3 = new JTextField(); // �����ı������
		jtf3.setBounds(90, 60, 200, 25); // ��߾࣬�ϱ߾࣬������
		jtf3.setEditable(false);
		frm.add(jtf3);

		JLabel j15 = new JLabel("[x,y]=");
		j15.setBounds(300, 60, 50, 25);
		frm.add(j15);
		JTextField jtf4 = new JTextField(); // �����ı������
		jtf4.setBounds(340, 60, 200, 25); // ��߾࣬�ϱ߾࣬������
		jtf4.setEditable(false);
		frm.add(jtf4);

		btn.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Test.isLegalInteger(jtf1.getText()) && Test.isLegalInteger(jtf2.getText())) {
					BigInteger x = new BigInteger(jtf1.getText());
					BigInteger y = new BigInteger(jtf2.getText());
					BigInteger maxCommonFactor = CommonFactorMultiple.max_common_factor_xy(x, y);
					BigInteger minCommonMultiple = CommonFactorMultiple.min_common_multiple_xy(x, y);
					jtf3.setText(maxCommonFactor.toString());
					jtf4.setText(minCommonMultiple.toString());
				}
			}
		});
	}
}
