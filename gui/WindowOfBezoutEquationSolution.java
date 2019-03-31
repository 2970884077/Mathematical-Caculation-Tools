/**  
 * All rights Reserved, Designed By CyborgKuroChan
 * @Title:  WindowOfBezoutEquationSolution.java   
 * @Package gui   
 * @Description:  �����ʽ���ͼ����
 * @author: JinZhiyun    
 * @date:   2019��3��16�� ����12:13:38   
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

import xxaqsxjc.method0.BezoutEquationSolution;
import xxaqsxjc.method0.CommonFactorMultiple;
import someTest.Test;

/**   
 * @ClassName:  WindowOfBezoutEquationSolution   
 * @Description: �����ʽ���ͼ���� 
 * @author: JinZhiyun
 * @date:   2019��3��16�� ����12:13:38   
 *     
 * @Copyright: 2019 CyborgKuroChan All rights reserved. 
 * ע�⣺�������ɳ������ֽ�����(wechat:Jzy_bb_1998)
 */
public class WindowOfBezoutEquationSolution {
	/**   
	 * @Title: GUIBezoutEquationSolution   
	 * @Description: �����ʽ���ͼ��ģ��  
	 * @param: @param frm      
	 * @return: void      
	 * @throws   
	 */ 
	public static void GUIBezoutEquationSolution(JFrame frm) {
		JLabel j11 = new JLabel("1�������ʽ��⣺s*x+t*y=(x,y)��������x,y");
		j11.setBounds(50, 60, GUIWindow.FrameWidth, 25);
		frm.add(j11);
		
		JButton btn = new JButton("����");
		btn.setBounds(320, 60, 80, 25);
		frm.add(btn);
		

		btn.addActionListener(new ActionListener() { //��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frmHidden = new JFrame();
				frmHidden.setBounds(2*GUIWindow.FrameStartX,2* GUIWindow.FrameStartY, 900, 150); // ���ô��ڳ�ʼλ�úʹ�С
				frmHidden.setTitle("�����ʽ��⣺s*x+t*y=(x,y)��������x,y"); // ���ñ���
				frmHidden.setLayout(null); // ���������ΪnullĬ�ϣ���ť������������ݿ򣬵�ס������ɫ
				
				GUIBezoutEquationSolutionHidden(frmHidden);
				
				
				frmHidden.setVisible(true); // ��ʾ����
			}
		});

	}
	
	/**   
	 * @Title: GUIBezoutEquationSolutionHidden   
	 * @Description: ��������ı����ʽ���ͼ��ģ��    
	 * @param: @param frm      
	 * @return: void      
	 * @throws   
	 */ 
	public static void GUIBezoutEquationSolutionHidden(JFrame frm) {
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
		jtf3.setBounds(90, 60, 150, 25); // ��߾࣬�ϱ߾࣬������
		jtf3.setEditable(false);
		frm.add(jtf3);

		JLabel j15 = new JLabel("s=");
		j15.setBounds(250, 60, 20, 25);
		frm.add(j15);
		JTextField jtf4 = new JTextField(); // �����ı������
		jtf4.setBounds(270, 60, 150, 25); // ��߾࣬�ϱ߾࣬������
		jtf4.setEditable(false);
		frm.add(jtf4);

		JLabel j16 = new JLabel("t=");
		j16.setBounds(430, 60, 20, 25);
		frm.add(j16);
		JTextField jtf5 = new JTextField(); // �����ı������
		jtf5.setBounds(450, 60, 150, 25); // ��߾࣬�ϱ߾࣬������
		jtf5.setEditable(false);
		frm.add(jtf5);

		JLabel j17 = new JLabel("��Ϊ����s=");
		j17.setBounds(610, 60, 70, 25);
		frm.add(j17);
		JTextField jtf6 = new JTextField(); // �����ı������
		jtf6.setBounds(680, 60, 150, 25); // ��߾࣬�ϱ߾࣬������
		jtf6.setEditable(false);
		frm.add(jtf6);

		btn.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Test.isLegalInteger(jtf1.getText()) && Test.isLegalInteger(jtf2.getText())) {
					BezoutEquationSolution b1 = new BezoutEquationSolution();
					BigInteger x = new BigInteger(jtf1.getText());
					BigInteger y = new BigInteger(jtf2.getText());
					BigInteger[] st = b1.Bezout_solve_qr_st(x, y);
					BigInteger s = st[0];
					BigInteger t = st[1];
					BigInteger s1 = b1.Bezout_solve_qr_s_11(x, y);
					BigInteger maxCommonFactor = CommonFactorMultiple.max_common_factor_xy(x, y);
					jtf3.setText(maxCommonFactor.toString());
					jtf4.setText(s.toString());
					jtf5.setText(t.toString());
					jtf6.setText(s1.toString());
				}
			}
		});
	}
}
