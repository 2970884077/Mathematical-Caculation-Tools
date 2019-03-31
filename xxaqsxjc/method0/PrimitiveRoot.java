/**  
 * All rights Reserved, Designed By CyborgKuroChan
 * @Title:  PrimitiveRoot.java   
 * @Package xxaqsxjc.method0   
 * @Description: ԭ������
 * @author: JinZhiyun    
 * @date:   2019��3��14�� ����10:48:02   
 * @version V1.0 
 * @Copyright: 2019 CyborgKuroChan All rights reserved. 
 * ע�⣺�������ɳ������ֽ�����(wechat:Jzy_bb_1998)
 */
package xxaqsxjc.method0;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**   
 * @ClassName:  PrimitiveRoot   
 * @Description: ԭ������
 * @author: JinZhiyun
 * @date:   2019��3��14�� ����10:47:43   
 *     
 * @Copyright: 2019 CyborgKuroChan All rights reserved. 
 * ע�⣺�������ɳ������ֽ�����(wechat:Jzy_bb_1998)
 */ 
public class PrimitiveRoot {
	/**   
	 * @Title: min_prim_root   
	 * @Description: �����Сԭ��  
	 * @param: @param p
	 * @param: @return      
	 * @return: BigInteger      
	 * @throws   
	 */ 
	public static BigInteger min_prim_root(BigInteger p) {// pС�����long
		BigInteger g = new BigInteger("1");
		ArrayList<BigInteger> q =PrimeTest.prime_factor(p.subtract(new BigInteger("1")));
		BigInteger[] p_q = new BigInteger[q.size()];
		for (int i = 0; i < q.size(); i++) {
			p_q[i] = (p.subtract(new BigInteger("1"))).divide(q.get(i));
		}
		int flag = 0;
		while (flag != q.size()) {
			g = g.add(new BigInteger("1"));
			flag = 0;
			for (int i = 0; i < q.size(); i++) {
				if (CaculMod.cacul_repet_mod(g, p_q[i], p).compareTo(new BigInteger("1")) != 0) {
					flag++;
				}
			}
		}
		return g;
	}

	/**   
	 * @Title: prim_root   
	 * @Description: ����ԭ���ļ��㣬����ArrayList<BigInteger>
	 * @param: @param p
	 * @param: @return      
	 * @return: ArrayList<BigInteger>      
	 * @throws   
	 */ 
	public static ArrayList<BigInteger> prim_root(BigInteger p) {
		ArrayList<BigInteger> prim_root_p = new ArrayList<BigInteger>();
		ArrayList<BigInteger> simple_p = new ArrayList<BigInteger>();
		BigInteger g = min_prim_root(p);
		for (BigInteger i = new BigInteger("1"); i.compareTo(p.subtract(new BigInteger("1"))) < 0; i = i
				.add(new BigInteger("1"))) {
			if (CommonFactorMultiple.max_common_factor_xy(i, p.subtract(new BigInteger("1")))
					.equals(new BigInteger("1"))) {
				simple_p.add(i);
			}
		}
		for (int i = 0; i < simple_p.size(); i++) {
			prim_root_p.add(CaculMod.cacul_repet_mod(g, simple_p.get(i), p));
		}
		Collections.sort(prim_root_p);
		return prim_root_p;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger p;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.print("������������p��");
			if (scan.hasNextBigInteger()) {
				p = scan.nextBigInteger();
			} else {
				System.out.println("��������");
				scan.close();
				return;
			}
			while (PrimeTest.Violent_ifprime(p) == 0) {
				System.out.println("p����������!");
				System.out.print("������������p��");
				if (scan.hasNextBigInteger()) {
					p = scan.nextBigInteger();
				} else {
					System.out.println("��������");
					scan.close();
					return;
				}
			}
		} while (PrimeTest.Violent_ifprime(p) == 2);
		scan.close();

		System.out.println("p����Сԭ���ǣ�" + PrimitiveRoot.min_prim_root(p));
		System.out.println("p������ԭ���ǣ�" + PrimitiveRoot.prim_root(p));
	}

}
