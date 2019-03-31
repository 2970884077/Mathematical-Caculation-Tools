/**  
 * All rights Reserved, Designed By CyborgKuroChan
 * @Title:  PrimeTest.java   
 * @Package xxaqsxjc.method0   
 * @Description:    TODO(��һ�仰�������ļ���ʲô)   
 * @author: JinZhiyun    
 * @date:   2019��3��31�� ����10:41:04   
 * @version V1.0 
 * @Copyright: 2019 CyborgKuroChan All rights reserved. 
 * ע�⣺�������ɳ������ֽ�����(wechat:Jzy_bb_1998)
 */ 
package xxaqsxjc.method0;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

/**   
 * @ClassName:  PrimeTest   
 * @Description: ���Լ������
 * @author: JinZhiyun
 * @date:   2019��3��31�� ����10:41:04   
 *     
 * @Copyright: 2019 CyborgKuroChan All rights reserved. 
 * ע�⣺�������ɳ������ֽ�����(wechat:Jzy_bb_1998)
 */
public class PrimeTest {
	/**   
	 * @Fields a1,a2,a3 : ���������������ں�ߴ������
	 */   
	private static final BigInteger a1 = new BigInteger("0");
	private static final BigInteger a2 = new BigInteger("1");
	private static final BigInteger a3 = new BigInteger("2");
	
	/**   
	 * @Title: Fermat   
	 * @Description: �������Լ��� ������1��ʾ��������0��֮   
	 * @param: @param n
	 * @param: @param t ��ȫ������ֵԽ�����׼ȷ��Խ�ߵ���ʱԽ��
	 * @param: @return      
	 * @return: int      
	 * @throws   
	 */ 
	public static int Fermat(BigInteger n, int t) {
		if (n.compareTo(new BigInteger("1")) == 0) {
			return 0;
		}
		if ((n.mod(new BigInteger("2"))).compareTo(new BigInteger("0")) == 0) {
			return 0;
		}
		BigInteger b;
		for (int i = 0; i < t; i++) {
			do {
				b = new BigInteger(n.bitLength(), new Random());
				b = b.mod(n);
			} while (b.compareTo(new BigInteger("2")) < 0 || b.compareTo(n.subtract(new BigInteger("2"))) > 0);

			if (CommonFactorMultiple.max_common_factor_xy(b, n).compareTo(new BigInteger("1")) > 0) {
				return 0;
			} else {
				if (CaculMod.cacul_repet_mod(b, n.subtract(new BigInteger("1")), n)
						.compareTo(new BigInteger("1")) == 0) {
					continue;
				} else {
					return 0;
				}
			}
		}
		return 1;
	}
	

	/**   
	 * @Title: MillerRabin   
	 * @Description:  MillerRabin���Լ��飬����1��ʾ��������0��֮   
	 * @param: @param n
	 * @param: @param k ��ȫ������ֵԽ�����׼ȷ��Խ�ߵ���ʱԽ�� 
	 * @param: @return      
	 * @return: int      
	 * @throws   
	 */ 
	public static int MillerRabin(BigInteger n, int k) {
		if (n.compareTo(new BigInteger("1")) == 0) {
			return 0;
		}
		if ((n.mod(new BigInteger("2"))).compareTo(new BigInteger("0")) == 0) {
			return 0;
		}
		BigInteger b, t, tempp = n.subtract(a2);
		long s = 0;
		while (tempp.mod(a3).compareTo(a1) == 0) {
			s++;
			tempp = tempp.divide(a3);
		}
		t = tempp;

		BigInteger r;
		for (int i = 0; i < k; i++) {
			do {
				b = new BigInteger(n.bitLength(), new Random());
				b = b.mod(n);
			} while (b.compareTo(a3) < 0 || b.compareTo(n.subtract(a3)) > 0);
			r = CaculMod.cacul_repet_mod(b, t, n);
			if (s == 1 && r.compareTo(a2) != 0 && r.compareTo(n.subtract(a2)) != 0) {
				return 0;
			} else {
				if (r.compareTo(a2) == 0 || r.compareTo(n.subtract(a2)) == 0) {
					continue;
				} else {
					for (long j = 1; j < s; j++) {
						r = (r.multiply(r)).mod(n);
						if (r.compareTo(n.subtract(a2)) == 0) {
							break;
						}
						if (j == s - 1 && r.compareTo(n.subtract(a2)) != 0) {
							return 0;
						}
					}
				}

			}
		}
		return 1;
	}
	
	/**   
	 * @Title: SolovayStassen   
	 * @Description: SolovayStassenPrimeTest���Լ��� ������1��ʾ��������0��֮   
	 * @param: @param n
	 * @param: @param t ��ȫ������ֵԽ�����׼ȷ��Խ�ߵ���ʱԽ��
	 * @param: @return      
	 * @return: int      
	 * @throws   
	 */ 
	public static int SolovayStassen(BigInteger n, int t) {
		if (n.compareTo(new BigInteger("1")) == 0) {
			return 0;
		}
		if ((n.mod(new BigInteger("2"))).compareTo(new BigInteger("0")) == 0) {
			return 0;
		}
		BigInteger b;
		for (int i = 0; i < t; i++) {
			do {
				b = new BigInteger(n.bitLength(), new Random());
				b = b.mod(n);
			} while (b.compareTo(new BigInteger("2")) < 0 || b.compareTo(n.subtract(new BigInteger("2"))) > 0);

			BigInteger r = CaculMod.cacul_repet_mod(b, n.subtract(new BigInteger("1")).divide(new BigInteger("2")), n);
			if (r.compareTo(new BigInteger("1")) != 0 && r.compareTo(n.subtract(new BigInteger("1"))) != 0) {
				return 0;
			} else {
				int s = Jacobi.Cacul_Jacobi(b, n);
				if (r.compareTo(n.subtract(new BigInteger("1"))) == 0) {
					r = r.subtract(n);
				}
				if (r.compareTo(BigInteger.valueOf((long) s)) != 0) {
					return 0;
				}
			}

		}
		return 1;
	}

	/**   
	 * @Title: Violent_ifprime   
	 * @Description: ���������Լ��飬����1��ʾ��������0��֮ 
	 * @param: @param n
	 * @param: @return      
	 * @return: int      
	 * @throws   
	 */ 
	public static int Violent_ifprime(BigInteger n) {
		if (n.compareTo(new BigInteger("1")) == 0) {
			return 0;
		} else if (n.compareTo(new BigInteger("2")) == 0 || n.compareTo(new BigInteger("3")) == 0) {
			return 1;
		} else if (n.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) > 0) {
			System.out.println("n����long�����ֵ�����Ƽ��ñ��������ж���");
			return 2;
		} else {
			long n0 = n.longValue();
			long p = (long) Math.sqrt(n0);
			for (long i = 2; i <= p; i++) {
				if (n0 % i == 0) {
					return 0;
				}
			}
			return 1;
		}
	}

	/**   
	 * @Title: prime_factor   
	 * @Description: ������е�������
	 * @param: @param x
	 * @param: @return      
	 * @return: ArrayList<BigInteger>      
	 * @throws   
	 */ 
	public static ArrayList<BigInteger> prime_factor(BigInteger x) {
		ArrayList<BigInteger> prime_factor_x = new ArrayList<BigInteger>();
		int r = Violent_ifprime(x);
		if (r != 2) {
			if (r == 1) {
				prime_factor_x.add(x);
			} else {
				BigInteger tmpx = x;
				BigInteger i = new BigInteger("2");
				while (tmpx.compareTo(new BigInteger("1")) != 0) {
					if (tmpx.mod(i).compareTo(new BigInteger("0")) == 0) {
						prime_factor_x.add(i);
						while (tmpx.mod(i).compareTo(new BigInteger("0")) == 0) {
							tmpx = tmpx.divide(i);
						}
					}
					i = i.add(new BigInteger("1"));
					while (Violent_ifprime(i) == 0) {
						i = i.add(new BigInteger("1"));
					}
				}
			}
		}
		return prime_factor_x;
	}

}
