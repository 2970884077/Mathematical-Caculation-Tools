/**  
 * All rights Reserved, Designed By CyborgKuroChan
 * @Title:  WindowOfLegendreAndJacobi.java   
 * @Package gui   
 * @Description:  ���õ÷��ź��ſɱȷ��ż���ͼ���� 
 * @author: JinZhiyun    
 * @date:   2019��3��16�� ����12:27:22   
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

import xxaqsxjc.method0.Jacobi;
import xxaqsxjc.method0.Legendre;
import someTest.Test;

/**   
 * @ClassName:  WindowOfLegendreAndJacobi   
 * @Description: ���õ÷��ź��ſɱȷ��ż���ͼ����  
 * @author: JinZhiyun
 * @date:   2019��3��16�� ����12:27:22   
 *     
 * @Copyright: 2019 CyborgKuroChan All rights reserved. 
 * ע�⣺�������ɳ������ֽ�����(wechat:Jzy_bb_1998)
 */
public class WindowOfLegendreAndJacobi {


	
	/**   
	 * @Title: GUILegendreAndJacobi   
	 * @Description: ���õ÷��ź��ſɱȷ��ż���ģ�� 
	 * @param: @param frm      
	 * @return: void      
	 * @throws   
	 */ 
	public static void GUILegendreAndJacobi(JFrame frm) {
		JLabel j11 = new JLabel("5�����õ÷��ź��ſɱȷ��ż��㣺����q,p������Legendre(q/p)��Jacobi(q/p)");
		j11.setBounds(50, 180, GUIWindow.FrameWidth, 25);
		frm.add(j11);

		JButton btn = new JButton("����");
		btn.setBounds(500, 180, 80, 25);
		frm.add(btn);

		btn.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frmHidden = new JFrame();
				frmHidden.setBounds(2 * GUIWindow.FrameStartX, 2 * GUIWindow.FrameStartY, 700, 150); // ���ô��ڳ�ʼλ�úʹ�С
				frmHidden.setTitle("���õ÷��ź��ſɱȷ��ż��㣺����q,p������Legendre(q/p)��Jacobi(q/p)"); // ���ñ���
				frmHidden.setLayout(null); // ���������ΪnullĬ�ϣ���ť������������ݿ򣬵�ס������ɫ

				GUILegendreAndJacobiHidden(frmHidden);

				frmHidden.setVisible(true); // ��ʾ����
			}
		});
	}

	/**   
	 * @Title: GUILegendreAndJacobiHidden   
	 * @Description: ������������õ÷��ź��ſɱȷ��ż���ģ��   
	 * @param: @param frm      
	 * @return: void      
	 * @throws   
	 */ 
	public static void GUILegendreAndJacobiHidden(JFrame frm) {
		JLabel j12 = new JLabel("q=");
		j12.setBounds(50, 30, 20, 25);
		frm.add(j12);
		JTextField jtf1 = new JTextField();// �����ı������
		jtf1.setBounds(70, 30, 200, 25); // ��߾࣬�ϱ߾࣬������
		frm.add(jtf1);

		JLabel j13 = new JLabel("p=");
		j13.setBounds(300, 30, 20, 25);
		frm.add(j13);
		JTextField jtf2 = new JTextField(); // �����ı������
		jtf2.setBounds(320, 30, 200, 25); // ��߾࣬�ϱ߾࣬������
		frm.add(jtf2);

		JButton btn = new JButton("����");
		btn.setBounds(550, 30, 80, 25);
		frm.add(btn);

		JLabel j14 = new JLabel("Legendre(q/p)=");
		j14.setBounds(50, 60, 100, 25);
		frm.add(j14);
		JTextField jtf3 = new JTextField(); // �����ı������
		jtf3.setBounds(140, 60, 200, 25); // ��߾࣬�ϱ߾࣬������
		jtf3.setEditable(false);
		frm.add(jtf3);

		JLabel j15 = new JLabel("Jacobi(q/p)=");
		j15.setBounds(360, 60, 100, 25);
		frm.add(j15);
		JTextField jtf4 = new JTextField(); // �����ı������
		jtf4.setBounds(440, 60, 200, 25); // ��߾࣬�ϱ߾࣬������
		jtf4.setEditable(false);
		frm.add(jtf4);

		btn.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Test.isLegalInteger(jtf1.getText()) && Test.isLegalInteger(jtf2.getText())) {
					BigInteger q = new BigInteger(jtf1.getText());
					BigInteger p = new BigInteger(jtf2.getText());
					int legendreqp = Legendre.Cacul_Legendre(q, p);
					int jacobiqp = Jacobi.Cacul_Jacobi(q, p);
					jtf3.setText(Integer.toString(legendreqp));
					jtf4.setText(Integer.toString(jacobiqp));
				}
			}
		});
	}
}
