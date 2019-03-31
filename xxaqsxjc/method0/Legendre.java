/**  
 * All rights Reserved, Designed By CyborgKuroChan
 * @Title:  Legendre.java   
 * @Package xxaqsxjc.method0   
 * @Description: ���õ÷��ż���   
 * @author: JinZhiyun    
 * @date:   2019��3��14�� ����10:46:05   
 * @version V1.0 
 * @Copyright: 2019 CyborgKuroChan All rights reserved. 
 * ע�⣺�������ɳ������ֽ�����(wechat:Jzy_bb_1998)
 */ 
package xxaqsxjc.method0;

import java.math.BigInteger;
import java.util.Scanner;



/**   
 * @ClassName:  Legendre   
 * @Description: ���õ÷��ż���   
 * @author: JinZhiyun
 * @date:   2019��3��14�� ����10:45:56   
 *     
 * @Copyright: 2019 CyborgKuroChan All rights reserved. 
 * ע�⣺�������ɳ������ֽ�����(wechat:Jzy_bb_1998)
 */ 
public class Legendre {
	/**   
	 * @Fields a,b,c,d: ���������������ں�ߴ������
	 */   
	private static final BigInteger a = new BigInteger("0");
	private static final BigInteger b = new BigInteger("1");
	private static final BigInteger c = new BigInteger("-1");
	private static final BigInteger d = new BigInteger("2");

	/**   
	 * @Title: Cacul_Legendre   
	 * @Description: ���õ÷��ż��� Legendre(q/p)������1��0��-1   
	 * @param: @param q
	 * @param: @param p
	 * @param: @return      
	 * @return: int      
	 * @throws   
	 */ 
	public static int Cacul_Legendre(BigInteger q, BigInteger p) {
		if ((q.mod(p)).compareTo(a) == 0) {
			return 0;
		}
		if (q.compareTo(b) == 0) {
			return 1;
		}
		if (q.compareTo(c) == 0) {
			if (((p.subtract(b)).mod(d)).compareTo(a) == 0) {
				return 1;
			} else {
				return -1;
			}
		}
		if ((q.mod(d)).compareTo(a) != 0) {
			if (((((p.subtract(b)).divide(d)).multiply((q.subtract(b)).divide(d))).mod(d)).compareTo(a) == 0) {
				return Cacul_Legendre(p.mod(q), q);
			} else {
				return (-1) * (Cacul_Legendre(p.mod(q), q));
			}
		} else {
			BigInteger k = new BigInteger("0");
			while ((q.mod(d)).compareTo(a) == 0) {
				k = k.add(b);
				q = q.divide(d);
			}
			if ((k.mod(d)).compareTo(a) == 0) {
				return Cacul_Legendre(q, p);
			} else {
				if (((((p.multiply(p)).subtract(b)).divide(new BigInteger("8"))).mod(d)).compareTo(a) == 0) {
					return Cacul_Legendre(q, p);
				} else {
					return (-1) * (Cacul_Legendre(q, p));
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger q, p;
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.print("������������q��");
			if (scan.hasNextBigInteger()) {
				q = scan.nextBigInteger();
			} else {
				System.out.println("��������");
				scan.close();
				return;
			}

			System.out.print("������������p��");
			if (scan.hasNextBigInteger()) {
				p = scan.nextBigInteger();
			} else {
				System.out.println("��������");
				scan.close();
				return;
			}
			while (PrimeTest.MillerRabin(p, 20) != 1 || p.compareTo(new BigInteger("2")) == 0) {
				System.out.println("p��Ϊ��������");
				System.out.print("������������p��");
				if (scan.hasNextBigInteger()) {
					p = scan.nextBigInteger();
				} else {
					System.out.println("��������");
					scan.close();
					return;
				}
			}

			System.out.println("Legendre(q/p)=" + Legendre.Cacul_Legendre(q, p));
		}

	}

}
