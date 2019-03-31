/**  
 * All rights Reserved, Designed By CyborgKuroChan
 * @Title:  GUIWindow.java   
 * @Package gui 
 * @Description:  ʵ��ͼ�ν������ 
 * @author: JinZhiyun    
 * @date:   2019��3��14�� ����3:03:12   
 * @version V1.0 
 * @Copyright: 2019 CyborgKuroChan All rights reserved. 
 * ע�⣺�������ɳ������ֽ�����(wechat:Jzy_bb_1998)
 */
package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @ClassName: GUIWindow
 * @Description: ʵ��ͼ�ν������
 * @author: JinZhiyun
 * @date: 2019��3��14�� ����3:03:12
 * 
 * @Copyright: 2019 CyborgKuroChan All rights reserved.
 *             ע�⣺�������ɳ������ֽ�����(wechat:Jzy_bb_1998)
 */
public class GUIWindow {
	/**
	 * @Fields FrameStartX,FrameStartY,FrameWidth,FrameHeight: Frame��λ�ô�С����
	 */
	public static int FrameStartX;
	public static int FrameStartY;
	public static int FrameWidth;
	public static int FrameHeight;

	/**
	 * @Title: GUIWindow
	 * @Description: ���캯����ʼ�� Frame��λ�ô�С����
	 * @param: @throws
	 */
	public GUIWindow() {
		FrameStartX = 100;
		FrameStartY = 100;
		FrameWidth = 1000;
		FrameHeight = 800;
	}

	/**   
	 * @Title: setFrame   
	 * @Description: ��������ͼ�ν��沼�� 
	 * @param:       
	 * @return: void      
	 * @throws   
	 */ 
	public void setFrame() {
		JFrame frm = new JFrame();

		frm.setBounds(FrameStartX, FrameStartY, FrameWidth, FrameHeight); // ���ô��ڳ�ʼλ�úʹ�С
		frm.setTitle("�Ű���������v1.0"); // ���ñ���
		frm.setLayout(null); // ���������ΪnullĬ�ϣ���ť������������ݿ򣬵�ס������ɫ

		JLabel j0 = new JLabel("��ѡ���Ӧ��ģ����м��㣡");
		j0.setBounds(50, 30, FrameWidth, 25);
		frm.add(j0);

		WindowOfBezoutEquationSolution.GUIBezoutEquationSolution(frm); // ���ñ����ʽ���ͼ��ģ��

		WindowOfCaculMod.GUICaculMod(frm); // ������С�Ǹ������;���ֵ��С��������ģ��

		WindowOfCommonFactorMultiple.GUICommonFactorMultiple(frm); // ���������������С�������ļ���ģ��

		WindowOfEulerFuction.GUIEulerFuction(frm); // ����ŷ������ֵ�ļ���ģ��

		WindowOfLegendreAndJacobi.GUILegendreAndJacobi(frm); // �������õ÷��ź��ſɱȷ��ż���ģ��

		WindowOfPrimitiveRoot.GUIPrimitiveRoot(frm); // ���ü�����Сԭ��ģ��

		WindowOfPrimeTest.GUIPrimeTest(frm); // �������Լ���ģ��

		WindowOfRSAEncryption.GUIRSAEncryption(frm); // ����RSA�����㷨ģ��

		WindowOfPaillierEncryption.GUIPaillierEncryption(frm); // ����Paillier�����㷨ģ��

		WindowOfGoldwasserMicaliBinaryEncryption.GUIGoldwasserMicaliBinaryEncryption(frm); // ����GoldwasserMicali�����㷨���Զ����Ƽ��ܣ�
																							// ģ��
		WindowOfZgsydl.GUIZgsydl(frm); // �����й�ʣ�ඨ�����ģ��

		WindowOfPolynomial.GUIPolynomial(frm); // ���ö���ʽ����ģ��

		WindowOfEllipticCurveCaculationOfFp.GUIEllipticCurveCaculationOfFp(frm); // ����Fp�ϵ���Բ�����ϵĵ�ļ���ģ��

		WindowOfEllipticCurveCaculationOfF2n.GUIEllipticCurveCaculationOfF2n(frm); // F2n�ϵ���Բ����y^2+xy=x^3+a2*x^2+a6�ĵ�ļ���
	
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �ر�
		frm.setVisible(true); // ��ʾ����
	}

}
