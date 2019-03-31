/**  
 * All rights Reserved, Designed By CyborgKuroChan
 * @Title:  GoldwasserMicaliBinaryEncryption.java   
 * @Package EncyptionAlgorithm   
 * @Description: GoldwasserMicali�����㷨���Զ����Ƽ��ܣ�
 * @author: JinZhiyun    
 * @date:   2019��3��15�� ����7:05:51   
 * @version V1.0 
 * @Copyright: 2019 CyborgKuroChan All rights reserved. 
 * ע�⣺�������ɳ������ֽ�����(wechat:Jzy_bb_1998)
 */
package EncyptionAlgorithm;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

import xxaqsxjc.method0.CommonFactorMultiple;
import xxaqsxjc.method0.Legendre;
import xxaqsxjc.method0.PrimeTest;

/**   
 * @ClassName:  GoldwasserMicaliBinaryEncryption   
 * @Description: GoldwasserMicali�����㷨���Զ����Ƽ��ܣ�  
 * @author: JinZhiyun
 * @date:   2019��3��15�� ����7:01:50   
 *     
 * @Copyright: 2019 CyborgKuroChan All rights reserved. 
 * ע�⣺�������ɳ������ֽ�����(wechat:Jzy_bb_1998)
 */ 
public class GoldwasserMicaliBinaryEncryption {
	private int security_para_k = 20;
	private BigInteger p;// ˽Կp(1024λ��
	private BigInteger q;// ˽Կq(1024λ��
	private BigInteger y;// ����
	private Vector<BigInteger> ct = new Vector<BigInteger>();// �洢����
	String d_pt;// ���ܺ������

	public BigInteger n;// ��Կn(2048λ)
	public BigInteger x;// ��Կx(512λ)
	String pt;// ����

	
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
	 * @Title:  getX <BR>  
	 * @Description: please write your description <BR>  
	 * @return: BigInteger <BR>  
	 */
	public BigInteger getX() {
		return x;
	}

	/**  
	 * @Title:  setX <BR>  
	 * @Description: please write your description <BR>  
	 * @return: BigInteger <BR>  
	 */
	public void setX(BigInteger x) {
		this.x = x;
	}

	/**   
	 * @Title:  GoldwasserMicaliBinaryEncryption   
	 * @Description:  ���������������ɹ�Կ��˽Կ�ȳ�ʼ������       
	 * @param:  @param pt  
	 * @throws   
	 */  
	public GoldwasserMicaliBinaryEncryption(String pt) {
		// ����pt
		this.pt = pt;
		// �������1024λ������p
		do {
			p = new BigInteger(1024, security_para_k, new Random());
		} while (PrimeTest.MillerRabin(p, security_para_k) != 1);

		// ������ɲ�����p��1024λ������q
		do {
			q = new BigInteger(1024, security_para_k, new Random());
		} while (PrimeTest.MillerRabin(q, security_para_k) != 1 || p.compareTo(q) == 0);

		// ��Կn
		n = p.multiply(q);

		// ��Կx
		do {
			x = new BigInteger(512, new Random());
		} while (Legendre.Cacul_Legendre(x, p) != -1 || Legendre.Cacul_Legendre(x, q) != -1);

		d_pt = "";
	}

	/**   
	 * @Title: GoldwasserMicali_encrypt   
	 * @Description: ���ܷ������� ����ÿ��0��1���ܳ�һ��������
	 * @param: @return      
	 * @return: Vector<BigInteger>      
	 * @throws   
	 */
	public Vector<BigInteger> GoldwasserMicali_encrypt() {
		BigInteger tmp1, tmp2, tmp3;
		for (int i = 0; i < pt.length(); i++) {
			do {
				y = new BigInteger(n.bitLength(), new Random());
				y = y.mod(n);
			} while (CommonFactorMultiple.max_common_factor_xy(y, n).compareTo(new BigInteger("1")) != 0);
			tmp1 = y.mod(n);
			if (pt.charAt(i) == '0') {
				ct.addElement(tmp1.multiply(tmp1).mod(n));
			} else {
				tmp2 = x.mod(n);
				tmp3 = tmp1.multiply(tmp1).mod(n);
				ct.addElement(tmp2.multiply(tmp3).mod(n));
			}
		}
		return ct;
	}

	/**   
	 * @Title: GoldwasserMicali_decrypt   
	 * @Description: ���ؽ������ĺ�õ������ģ������ȵ��� GoldwasserMicali_encrypt()�����ܺ��ڵ��ôη���     
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */
	public String GoldwasserMicali_decrypt() {
		for (int i = 0; i < pt.length(); i++) {
			if (Legendre.Cacul_Legendre(ct.get(i), p) == 1) {
				d_pt = d_pt + "0";
			} else if (Legendre.Cacul_Legendre(ct.get(i), p) == -1) {
				d_pt = d_pt + "1";
			} else {
				System.out.println("Error!");
				d_pt = d_pt + "#";
			}
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
		System.out.println("�������1024λ������p��˽Կ��=" + p);
		System.out.println("�������1024λ������q��˽Կ��=" + q);
		System.out.println("2048λ��Կn=p*q=" + n);
		System.out.println("������ɹ�Կx=" + x);
		GoldwasserMicali_encrypt();
		System.out.println("���ܵõ�����:");
		GoldwasserMicali_encrypt();
		System.out.println(toStringShowCt());
		System.out.println("�������ĵõ������ģ�" + GoldwasserMicali_decrypt());
	}

	/**   
	 * @Title: toStringShowCt   
	 * @Description: �������������ʽ   
	 * @param: @param ct
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */
	public String toStringShowCt() {
		String re = "";
		for (int i = 0; i < ct.size(); i++) {
			re += "C" + i + "=" + ct.get(i);
			if (i != ct.size() - 1) {
				re += '\n';
			}
		}
		return re;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		boolean flag;
		String str1;
		do {
			flag = false;
			System.out.print("������������Ϣ��");
			if (scan.hasNextLine()) {
				str1 = scan.nextLine();
			} else {
				System.out.println("��������");
				scan.close();
				return;
			}
			for (int i = 0; i < str1.length(); i++) {
				if (str1.charAt(i) != '0' && str1.charAt(i) != '1') {
					System.out.println("�������뺬0��1���ַ�����");
					flag = true;
					break;
				}
			}
		} while (flag);
		scan.close();

		GoldwasserMicaliBinaryEncryption gmbe1 = new GoldwasserMicaliBinaryEncryption(str1);
		gmbe1.show();
		
		

	}

}
