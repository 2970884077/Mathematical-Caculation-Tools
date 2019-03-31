/**  
 * All rights Reserved, Designed By CyborgKuroChan
 * @Title:  WindowOfPrimitiveRoot.java   
 * @Package gui   
 * @Description: ������Сԭ��ͼ����  
 * @author: JinZhiyun    
 * @date:   2019��3��16�� ����12:29:17   
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

import xxaqsxjc.method0.PrimitiveRoot;
import someTest.Test;
import xxaqsxjc.method0.PrimeTest;

/**   
 * @ClassName:  WindowOfPrimitiveRoot   
 * @Description: ������Сԭ��ͼ����  
 * @author: JinZhiyun
 * @date:   2019��3��16�� ����12:29:17   
 *     
 * @Copyright: 2019 CyborgKuroChan All rights reserved. 
 * ע�⣺�������ɳ������ֽ�����(wechat:Jzy_bb_1998)
 */
public class WindowOfPrimitiveRoot {
	/**   
	 * @Title: GUIPrimitiveRoot   
	 * @Description: ���ü�����Сԭ��ģ��
	 * @param: @param frm      
	 * @return: void      
	 * @throws   
	 */
	public static void GUIPrimitiveRoot(JFrame frm) {
		JLabel j11 = new JLabel("6��ģpԭ���ļ��㣺����p������p����Сԭ��");
		j11.setBounds(50, 210, GUIWindow.FrameWidth, 25);
		frm.add(j11);

		JButton btn = new JButton("����");
		btn.setBounds(320, 210, 80, 25);
		frm.add(btn);

		btn.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frmHidden = new JFrame();
				frmHidden.setBounds(2 * GUIWindow.FrameStartX, 2 * GUIWindow.FrameStartY, 500, 150); // ���ô��ڳ�ʼλ�úʹ�С
				frmHidden.setTitle("ģpԭ���ļ��㣺����p������p����Сԭ��"); // ���ñ���
				frmHidden.setLayout(null); // ���������ΪnullĬ�ϣ���ť������������ݿ򣬵�ס������ɫ

				GUIPrimitiveRootHidden(frmHidden);

				frmHidden.setVisible(true); // ��ʾ����
			}
		});
	}
	
	/**   
	 * @Title: GUIPrimitiveRootHidden   
	 * @Description: ��������ļ�����Сԭ��ģ��
	 * @param:       
	 * @return: void      
	 * @throws   
	 */
	public static void GUIPrimitiveRootHidden(JFrame frm) {
		JLabel j12 = new JLabel("p=");
		j12.setBounds(50, 30, 20, 25);
		frm.add(j12);
		JTextField jtf1 = new JTextField();// �����ı������
		jtf1.setBounds(70, 30, 250, 25); // ��߾࣬�ϱ߾࣬������
		frm.add(jtf1);

		JButton btn = new JButton("����");
		btn.setBounds(340, 30, 80, 25);
		frm.add(btn);

		JLabel j14 = new JLabel("p����Сԭ��=");
		j14.setBounds(50, 60, 80, 25);
		frm.add(j14);
		JTextField jtf3 = new JTextField(); // �����ı������
		jtf3.setBounds(135, 60, 250, 25); // ��߾࣬�ϱ߾࣬������
		jtf3.setEditable(false);
		frm.add(jtf3);

		btn.addActionListener(new ActionListener() { // ��ť��Ӧ�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Test.isLegalInteger(jtf1.getText())) {
					BigInteger p = new BigInteger(jtf1.getText());
					if (PrimeTest.SolovayStassen(p, 15) == 0) {
						JOptionPane.showMessageDialog(null, "p��������������");
					} else {
						BigInteger re = PrimitiveRoot.min_prim_root(p);
						jtf3.setText(re.toString());
					}
				}
			}

		});
	}
}
