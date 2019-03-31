/**  
 * All rights Reserved, Designed By CyborgKuroChan
 * @Title:  BezoutEquationSolution.java   
 * @Package xxaqsxjc.method0   
 * @Description:  �����ʽ��⣺s*x+t*y=(x,y)�����s,t 
 * @author: JinZhiyun    
 * @date:   2019��3��14�� ����4:35:05   
 * @version V1.0 
 * @Copyright: 2019 CyborgKuroChan All rights reserved. 
 * ע�⣺�������ɳ������ֽ�����(wechat:Jzy_bb_1998)
 */ 
package xxaqsxjc.method0;

import java.math.BigInteger;
import java.util.Scanner;

/**   
 * @ClassName:  BezoutEquationSolution   
 * @Description:  �����ʽ��⣺s*x+t*y=(x,y)�����s,t
 * @author: JinZhiyun
 * @date:   2019��3��14�� ����3:26:01   
 *     
 * @Copyright: 2019 CyborgKuroChan Inc. All rights reserved. 
 * ע�⣺�������ɳ������ֽ�����(wechat:Jzy_bb_1998)
 */ 
public class BezoutEquationSolution {
	private final int Bezout_solve_qr_size = 1000000;
	private boolean flag;
	public int j;
	
	/**   
	 * @Fields s,t,q,r : ��������   
	 */   
	public BigInteger[] s;
	public BigInteger[] t;
	public BigInteger[] q;
	public BigInteger[] r;
	
	/**   
	 * @Fields result_index : ���ֵ������s,t�е�����ֵ
	 */   
	public int result_index = 0;
	
	/**   
	 * @Fields result_s : �����ϵ��s 
	 */   
	public BigInteger result_s = new BigInteger("0");
	
	/**   
	 * @Fields result_st : �����ϵ��s��t  
	 */   
	public BigInteger[] result_st = new BigInteger[2];

	/**   
	 * @Title:  BezoutEquationSolution   
	 * @Description: �๹�캯�������Գ�ʼ��
	 * @param:    
	 * @throws   
	 */  
	public BezoutEquationSolution() {
		s = new BigInteger[Bezout_solve_qr_size];
		t = new BigInteger[Bezout_solve_qr_size];
		q = new BigInteger[Bezout_solve_qr_size];
		r = new BigInteger[Bezout_solve_qr_size];
		j = 0;
		flag = true;
	}

	/**   
	 * @Title: Bezout_solve_qr_index   
	 * @Description: ����� result_index�����ֵ������s,t�е�����ֵ��
	 * @param: @param x
	 * @param: @param y
	 * @param: @return      
	 * @return: int      
	 * @throws   
	 */ 
	public int Bezout_solve_qr_index(BigInteger x, BigInteger y) {
		if (flag == false) {
			j = 0;
			flag = true;
		}
		s[1] = new BigInteger("1");
		s[2] = new BigInteger("0");
		t[1] = new BigInteger("0");
		t[2] = new BigInteger("1");
		r[j] = x;
		r[j + 1] = y;
		q[j + 2] = r[j].divide(r[j + 1]);
		r[j + 2] = r[j].mod(r[j + 1]);

		s[j + 3] = s[j + 1].subtract(q[j + 2].multiply(s[j + 2]));
		t[j + 3] = t[j + 1].subtract(q[j + 2].multiply(t[j + 2]));
		x = r[j + 1];
		y = r[j + 2];

		if (y.toString() == "0") {
			flag = false;
			result_index = j + 2;
			return result_index;
		} else {
			j += 1;
			Bezout_solve_qr_index(x, y);
		}
		return result_index;
	}

	/**   
	 * @Title: Bezout_solve_qr_s_11   
	 * @Description: �����ϵ��s��x����Ԫ��ֻΪ����
	 * @param: @param x
	 * @param: @param y
	 * @param: @return      
	 * @return: BigInteger      
	 * @throws   
	 */ 
	public BigInteger Bezout_solve_qr_s_11(BigInteger x, BigInteger y) {
		if (flag == false) {
			j = 0;
			flag = true;
		}
		s[1] = new BigInteger("1");
		s[2] = new BigInteger("0");
		t[1] = new BigInteger("0");
		t[2] = new BigInteger("1");
		r[j] = x;
		r[j + 1] = y;
		q[j + 2] = r[j].divide(r[j + 1]);
		r[j + 2] = r[j].mod(r[j + 1]);

		s[j + 3] = s[j + 1].subtract(q[j + 2].multiply(s[j + 2]));
		t[j + 3] = t[j + 1].subtract(q[j + 2].multiply(t[j + 2]));
		x = r[j + 1];
		y = r[j + 2];

		if (y.toString() == "0") {
			flag = false;
			BigInteger tmp = new BigInteger("0");
			if (s[j + 2].compareTo(tmp) >= 0) {
				result_s = s[j + 2];
				return result_s;
			} else {
				result_s = s[j + 2].add(r[1]);
				return result_s;
			}

		} else {
			j += 1;
			Bezout_solve_qr_s_11(x, y);
		}
		return result_s;
	}

	/**   
	 * @Title: Bezout_solve_qr_s_1   
	 * @Description: �����ϵ��s��x����Ԫ�����Ը���  
	 * @param: @param x
	 * @param: @param y
	 * @param: @return      
	 * @return: BigInteger      
	 * @throws   
	 */ 
	public BigInteger Bezout_solve_qr_s_1(BigInteger x, BigInteger y) { // x����Ԫ�����Ը�
		if (flag == false) {
			j = 0;
			flag = true;
		}
		s[1] = new BigInteger("1");
		s[2] = new BigInteger("0");
		t[1] = new BigInteger("0");
		t[2] = new BigInteger("1");
		r[j] = x;
		r[j + 1] = y;
		q[j + 2] = r[j].divide(r[j + 1]);
		r[j + 2] = r[j].mod(r[j + 1]);

		s[j + 3] = s[j + 1].subtract(q[j + 2].multiply(s[j + 2]));
		t[j + 3] = t[j + 1].subtract(q[j + 2].multiply(t[j + 2]));
		x = r[j + 1];
		y = r[j + 2];

		if (y.toString() == "0") {
			flag = false;
			result_s = s[j + 2];
			return result_s;
		} else {
			j += 1;
			Bezout_solve_qr_s_1(x, y);
		}
		return result_s;
	}

	/**   
	 * @Title: Bezout_solve_qr_st   
	 * @Description: �����ϵ��s,t   
	 * @param: @param x
	 * @param: @param y
	 * @param: @return      
	 * @return: BigInteger[]      
	 * @throws   
	 */ 
	public BigInteger[] Bezout_solve_qr_st(BigInteger x, BigInteger y) { 
		if (flag == false) {
			j = 0;
			flag = true;
		}
		s[1] = new BigInteger("1");
		s[2] = new BigInteger("0");
		t[1] = new BigInteger("0");
		t[2] = new BigInteger("1");
		r[j] = x;
		r[j + 1] = y;
		q[j + 2] = r[j].divide(r[j + 1]);
		r[j + 2] = r[j].mod(r[j + 1]);

		s[j + 3] = s[j + 1].subtract(q[j + 2].multiply(s[j + 2]));
		t[j + 3] = t[j + 1].subtract(q[j + 2].multiply(t[j + 2]));
		x = r[j + 1];
		y = r[j + 2];

		if (y.toString() == "0") {
			flag = false;
			result_st[0] = s[j + 2];
			result_st[1] = t[j + 2];
			return result_st;
		} else {
			j += 1;
			Bezout_solve_qr_st(x, y);
		}
		return result_st;
	}

	/**   
	 * @Title: main   
	 * @Description: TODO(������һ�仰�����������������)   
	 * @param: @param args      
	 * @return: void      
	 * @throws   
	 */ 
	public static void main(String[] args) {
		BigInteger x, y;
		Scanner scan = new Scanner(System.in);
		System.out.print("������������x��");
		if (scan.hasNextBigInteger()) {
			x = scan.nextBigInteger();
		} else {
			System.out.println("��������");
			scan.close();
			return;
		}
		System.out.print("������������y��");
		if (scan.hasNextBigInteger()) {
			y = scan.nextBigInteger();
		} else {
			System.out.println("��������");
			scan.close();
			return;
		}
		scan.close();

		System.out.println("�������Ϊ��" + CommonFactorMultiple.max_common_factor_xy(x, y));
		BezoutEquationSolution bes = new BezoutEquationSolution();
		BigInteger[] tmp1 = bes.Bezout_solve_qr_st(x, y);
		System.out.println("s=" + tmp1[0] + ",t=" + tmp1[1]);
		System.out.println("����s=" + bes.Bezout_solve_qr_s_11(x, y));
		System.out.println(x+" "+y);
	}

}
