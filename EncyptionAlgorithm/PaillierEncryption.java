/**  
 * All rights Reserved, Designed By CyborgKuroChan
 * @Title:  PaillierEncryption.java   
 * @Package EncyptionAlgorithm   
 * @Description:    TODO(��һ�仰�������ļ���ʲô)   
 * @author: JinZhiyun    
 * @date:   2019��3��15�� ����6:57:00   
 * @version V1.0 
 * @Copyright: 2019 CyborgKuroChan All rights reserved. 
 * ע�⣺�������ɳ������ֽ�����(wechat:Jzy_bb_1998)
 */
package EncyptionAlgorithm;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

import xxaqsxjc.method0.BezoutEquationSolution;
import xxaqsxjc.method0.CaculMod;
import xxaqsxjc.method0.PrimeTest;

/**   
 * @ClassName:  PaillierEncryption   
 * @Description: Paillier�����㷨
 * @author: JinZhiyun
 * @date:   2019��3��15�� ����6:55:37   
 *     
 * @Copyright: 2019 CyborgKuroChan All rights reserved. 
 * ע�⣺�������ɳ������ֽ�����(wechat:Jzy_bb_1998)
 */ 
public class PaillierEncryption {
	private int security_para_k = 20;
	private BigInteger p;// 1024λ������
	private BigInteger q;// 1024λ������
	private BigInteger Euler_n;// ˽Կ
	private BigInteger L_1;// ˽Կ
	private Vector<BigInteger> math_pt = new Vector<BigInteger>();// �洢���ĵ����ֻ���Ϣ
	private Vector<BigInteger> math_ct = new Vector<BigInteger>();// �洢���ĵ����ֻ���Ϣ
	private String ct; // ����
	private String d_pt;// ���ܺ������

	public BigInteger n;// ��Կn
	public BigInteger g;// ��Կ��n^2�ļ�ʣ�࣬n+1
	public BigInteger r;// �����r
	public String pt;// ����

	/**  
	 * @Title:  getP <BR>  
	 * @Description: please write your description <BR>  
	 * @return: BigInteger <BR>  
	 */
	public BigInteger getP() {
		return p;
	}

	/**  
	 * @Title:  setP <BR>  
	 * @Description: please write your description <BR>  
	 * @return: BigInteger <BR>  
	 */
	public void setP(BigInteger p) {
		this.p = p;
	}

	/**  
	 * @Title:  getQ <BR>  
	 * @Description: please write your description <BR>  
	 * @return: BigInteger <BR>  
	 */
	public BigInteger getQ() {
		return q;
	}

	/**  
	 * @Title:  setQ <BR>  
	 * @Description: please write your description <BR>  
	 * @return: BigInteger <BR>  
	 */
	public void setQ(BigInteger q) {
		this.q = q;
	}

	/**  
	 * @Title:  getEuler_n <BR>  
	 * @Description: please write your description <BR>  
	 * @return: BigInteger <BR>  
	 */
	public BigInteger getEuler_n() {
		return Euler_n;
	}

	/**  
	 * @Title:  setEuler_n <BR>  
	 * @Description: please write your description <BR>  
	 * @return: BigInteger <BR>  
	 */
	public void setEuler_n(BigInteger euler_n) {
		Euler_n = euler_n;
	}

	/**  
	 * @Title:  getL_1 <BR>  
	 * @Description: please write your description <BR>  
	 * @return: BigInteger <BR>  
	 */
	public BigInteger getL_1() {
		return L_1;
	}

	/**  
	 * @Title:  setL_1 <BR>  
	 * @Description: please write your description <BR>  
	 * @return: BigInteger <BR>  
	 */
	public void setL_1(BigInteger l_1) {
		L_1 = l_1;
	}

	/**  
	 * @Title:  getN <BR>  
	 * @Description: please write your description <BR>  
	 * @return: BigInteger <BR>  
	 */
	public BigInteger getN() {
		return n;
	}

	/**  
	 * @Title:  setN <BR>  
	 * @Description: please write your description <BR>  
	 * @return: BigInteger <BR>  
	 */
	public void setN(BigInteger n) {
		this.n = n;
	}

	/**  
	 * @Title:  getG <BR>  
	 * @Description: please write your description <BR>  
	 * @return: BigInteger <BR>  
	 */
	public BigInteger getG() {
		return g;
	}

	/**  
	 * @Title:  setG <BR>  
	 * @Description: please write your description <BR>  
	 * @return: BigInteger <BR>  
	 */
	public void setG(BigInteger g) {
		this.g = g;
	}

	/**   
	 * @Title:  PaillierEncryption   
	 * @Description:    ���������������ɹ�Կ��˽Կ�ȳ�ʼ������    
	 * @param:  @param pt  
	 * @throws   
	 */  
	public PaillierEncryption(String pt) {
		// ����
		this.pt = pt;

		// ���1024λ������p
		do {
			p = new BigInteger(1024, security_para_k, new Random());
		} while (PrimeTest.MillerRabin(p, security_para_k) != 1);

		// ������ɲ�����p��1024λ������q
		do {
			q = new BigInteger(1024, security_para_k, new Random());
		} while (PrimeTest.MillerRabin(q, security_para_k) != 1 || p.compareTo(q) == 0);

		// ��Կn2048λ
		n = p.multiply(q);
		// ��Կg��n^2�ļ�ʣ�࣬n+1
		g = n.add(new BigInteger("1"));
		// ˽Կ��
		Euler_n = (p.subtract(new BigInteger("1")).multiply(q.subtract(new BigInteger("1"))));
		// ˽Կ��
		BezoutEquationSolution bes1 = new BezoutEquationSolution();
		L_1 = bes1.Bezout_solve_qr_s_11(Euler_n, n);

		ct = "";
		d_pt = "";
	}

	/**   
	 * @Title: Paillier_encrypt   
	 * @Description: ���ܷ�������  
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */
	public String Paillier_encrypt() {
		BigInteger tmp1, tmp2, tmp3;
		for (int i = 0; i < pt.length(); i++) {
			math_pt.addElement(BigInteger.valueOf((long) pt.charAt(i)));
			tmp1 = CaculMod.cacul_repet_mod(g, math_pt.get(i), n.multiply(n));
			do {
				r = new BigInteger(n.bitLength(), new Random());
				r = r.mod(n);
			} while (r.compareTo(new BigInteger("0")) == 0);
			tmp2 = CaculMod.cacul_repet_mod(r, n, n.multiply(n));
			math_ct.addElement(tmp1.multiply(tmp2).mod(n.multiply(n)));

			tmp3 = math_ct.get(i).mod(new BigInteger("95"));
			ct = ct + (char) (tmp3.intValue() + 32);
		}
		return ct;
	}

	/**   
	 * @Title: Paillier_decrypt   
	 * @Description: ���ؽ������ĺ�õ������ģ������ȵ��� Paillier_encrypt()�����ܺ��ڵ��ôη���  
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */
	public String Paillier_decrypt() {
		BigInteger tmp1, tmp2, tmp3;
		for (int i = 0; i < pt.length(); i++) {
			tmp1 = CaculMod.cacul_repet_mod(math_ct.get(i), Euler_n, n.multiply(n));
			tmp2 = tmp1.subtract(new BigInteger("1")).divide(n);
			tmp3 = tmp2.multiply(L_1).mod(n);
			d_pt = d_pt + (char) (tmp3.intValue());
		}
		return d_pt;
	}

	/**   
	 * @Title: show   
	 * @Description: ��ʾ����������  
	 * @param:       
	 * @return: void      
	 * @throws   
	 */
	public void show() {
		System.out.println("�������1024λ������p=" + p);
		System.out.println("�������1024λ������q=" + q);
		System.out.println("2048λ��Կn=p*q=" + n);
		System.out.println("�������ɹ�Կg=" + g);
		System.out.println("��������˽Կ��=" + Euler_n);
		System.out.println("��������˽Կ��=" + L_1);
		// ���ַ�����
		System.out.println("���ܵõ����ģ�" + Paillier_encrypt());
		System.out.println("�������ĵõ������ģ�" + Paillier_decrypt());
	}

	/**   
	 * @Title: Paillier_get_math_pt   
	 * @Description: �������ֻ�������   
	 * @param: @return      
	 * @return: Vector<BigInteger>      
	 * @throws   
	 */
	public Vector<BigInteger> Paillier_get_math_pt() {
		return math_pt;
	}

	/**   
	 * @Title: Paillier_get_math_ct   
	 * @Description: �������ֻ�������  
	 * @param: @return      
	 * @return: Vector<BigInteger>      
	 * @throws   
	 */
	public Vector<BigInteger> Paillier_get_math_ct() {
		return math_ct;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("������������Ϣ��");
		String str1;
		if (scan.hasNextLine()) {
			str1 = scan.nextLine();
		} else {
			System.out.println("��������");
			scan.close();
			return;
		}
		scan.close();

		PaillierEncryption pe1 = new PaillierEncryption(str1);
		pe1.show();
	}

}
