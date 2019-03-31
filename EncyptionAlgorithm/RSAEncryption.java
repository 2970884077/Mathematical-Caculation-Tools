/**  
 * All rights Reserved, Designed By CyborgKuroChan
 * @Title:  RSAEncryption.java   
 * @Package EncyptionAlgorithm   
 * @Description: ʵ��RSA�����㷨  
 * @author: JinZhiyun    
 * @date:   2019��3��15�� ����6:46:27   
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
import xxaqsxjc.method0.CommonFactorMultiple;
import xxaqsxjc.method0.PrimeTest;

/**   
 * @ClassName:  RSAEncryption   
 * @Description: ʵ��RSA�����㷨  
 * @author: JinZhiyun
 * @date:   2019��3��15�� ����6:45:59   
 *     
 * @Copyright: 2019 CyborgKuroChan All rights reserved. 
 * ע�⣺�������ɳ������ֽ�����(wechat:Jzy_bb_1998)
 */ 
public class RSAEncryption {
	private int security_para_k = 20;
	private BigInteger d; // ˽Կd
	private BigInteger p, q;// 1024λ

	private BigInteger Euler_n;// ��Կn��ŷ������ֵ
	private Vector<BigInteger> math_pt = new Vector<BigInteger>();// �洢���ĵ����ֻ���Ϣ
	private Vector<BigInteger> math_ct = new Vector<BigInteger>();// �洢���ĵ����ֻ���Ϣ
	private String ct; // ����
	private String d_pt;// ���ܺ������

	public BigInteger n; // ��Կn��2048λ
	public BigInteger e;// ��Կe
	public String pt;// ����

	/**  
	 * @Title:  getD <BR>  
	 * @Description: please write your description <BR>  
	 * @return: BigInteger <BR>  
	 */
	public BigInteger getD() {
		return d;
	}

	/**  
	 * @Title:  setD <BR>  
	 * @Description: please write your description <BR>  
	 * @return: BigInteger <BR>  
	 */
	public void setD(BigInteger d) {
		this.d = d;
	}

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
	 * @Title:  getE <BR>  
	 * @Description: please write your description <BR>  
	 * @return: BigInteger <BR>  
	 */
	public BigInteger getE() {
		return e;
	}

	/**  
	 * @Title:  setE <BR>  
	 * @Description: please write your description <BR>  
	 * @return: BigInteger <BR>  
	 */
	public void setE(BigInteger e) {
		this.e = e;
	}
	
	/**   
	 * @Title:  RSAEncryption   
	 * @Description:  ���������������ɹ�Կ��˽Կ�ȳ�ʼ������ 
	 * @param:  @param pt  ���������Ϊ����pt
	 * @throws   
	 */  
	public RSAEncryption(String pt) {
		// �����������p
		do {
			p = new BigInteger(1024, security_para_k, new Random());
		} while (PrimeTest.MillerRabin(p, security_para_k) != 1);

		// ������ɲ�����p������q
		do {
			q = new BigInteger(1024, security_para_k, new Random());
		} while (PrimeTest.MillerRabin(q, security_para_k) != 1 || p.compareTo(q) == 0);

		// ��Կn
		n = p.multiply(q);
		Euler_n = (p.subtract(new BigInteger("1")).multiply(q.subtract(new BigInteger("1"))));

		// ��Կe
		do {
			e = new BigInteger(Euler_n.bitLength(), new Random());
			e = e.mod(Euler_n);
		} while (CommonFactorMultiple.max_common_factor_xy(e, Euler_n).compareTo(new BigInteger("1")) != 0
				|| e.compareTo(new BigInteger("1")) <= 0);

		// ˽Կd
		BezoutEquationSolution bes1 = new BezoutEquationSolution();
		d = bes1.Bezout_solve_qr_s_11(e, Euler_n);

		// ����
		this.pt = pt;

		ct = "";
		d_pt = "";
	}

	/**   
	 * @Title: RSA_encrypt   
	 * @Description: ���ܷ�������   
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */
	public String RSA_encrypt() {
		BigInteger tmp1;
		for (int i = 0; i < pt.length(); i++) {
			math_pt.addElement(BigInteger.valueOf((long) pt.charAt(i)));
			math_ct.addElement(CaculMod.cacul_repet_mod(math_pt.get(i), e, n));
			tmp1 = math_ct.get(i).mod(new BigInteger("95"));
			ct = ct + (char) (tmp1.intValue() + 32);
		}
		return ct;
	}

	/**   
	 * @Title: RSA_decrypt   
	 * @Description: ���ؽ������ĺ�õ������ģ������ȵ��� RSA_encrypt()�����ܺ��ڵ��ôη���
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */
	public String RSA_decrypt() {
		BigInteger tmp2;
		if (ct != "") {
			for (int i = 0; i < pt.length(); i++) {
				tmp2 = CaculMod.cacul_repet_mod(math_ct.get(i), d, n);
				d_pt = d_pt + (char) (tmp2.intValue());
			}
		} else {
			System.out.println("���ȼ��ܣ�");
		}
		return d_pt;
	}

	/**   
	 * @Title: RSA_get_math_pt   
	 * @Description: �������ֻ�������  
	 * @param: @return      
	 * @return: Vector<BigInteger>      
	 * @throws   
	 */
	public Vector<BigInteger> RSA_get_math_pt() {
		return math_pt;
	}

	/**   
	 * @Title: RSA_get_math_ct   
	 * @Description: �������ֻ�������  
	 * @param: @return      
	 * @return: Vector<BigInteger>      
	 * @throws   
	 */
	public Vector<BigInteger> RSA_get_math_ct() {
		return math_ct;
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
		System.out.println("������ɹ�Կe=" + e);
		System.out.println("��������˽Կd=" + d);
		// ���ַ�����
		System.out.println("���ܵõ����ģ�" + RSA_encrypt());
		System.out.println("�������ĵõ������ģ�" + RSA_decrypt());
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

		RSAEncryption rsa1 = new RSAEncryption(str1);
		rsa1.show();
	}

}
