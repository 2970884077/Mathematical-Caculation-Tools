/**  
 * All rights Reserved, Designed By CyborgKuroChan
 * @Title:  CommonFactorMultiple.java   
 * @Package xxaqsxjc.method0   
 * @Description:   �����������С�������ļ��� 
 * @author: JinZhiyun    
 * @date:   2019��3��14�� ����9:56:56   
 * @version V1.0 
 * @Copyright: 2019 CyborgKuroChan All rights reserved. 
 * ע�⣺�������ɳ������ֽ�����(wechat:Jzy_bb_1998)
 */ 
package xxaqsxjc.method0;

import java.math.BigInteger;
import java.util.Scanner;

/**   
 * @ClassName:  CommonFactorMultiple   
 * @Description: �����������С�������ļ��� 
 * @author: JinZhiyun
 * @date:   2019��3��14�� ����9:57:13   
 *     
 * @Copyright: 2019 CyborgKuroChan All rights reserved. 
 * ע�⣺�������ɳ������ֽ�����(wechat:Jzy_bb_1998)
 */ 
public class CommonFactorMultiple {

	/**   
	 * @Fields result : ������  
	 */   
	public static BigInteger result;

	/**   
	 * @Title:  CommonFactorMultiple   
	 * @Description:  ���캯����ʼ��result  
	 * @param:    
	 * @throws   
	 */  
	public CommonFactorMultiple() {
		result = new BigInteger("0");
	}

	/**   
	 * @Title: max_common_factor_xy   
	 * @Description: ���������������  
	 * @param: @param x
	 * @param: @param y
	 * @param: @return      
	 * @return: BigInteger      
	 * @throws   
	 */ 
	public static BigInteger max_common_factor_xy(BigInteger x, BigInteger y) {
		if (x.compareTo(y) == -1) {
			BigInteger tmp = y;
			y = x;
			x = tmp;
		}
		BigInteger r;
		r = x.mod(y);
		if (r.toString() != "0") {

			x = y;
			y = r;
			max_common_factor_xy(x, y);
		} else {
			result = y;
		}
		return result;
	}

	/**   
	 * @Title: max_common_factor_all   
	 * @Description: ��������������  
	 * @param: @param a
	 * @param: @param size
	 * @param: @param index
	 * @param: @return      
	 * @return: BigInteger      
	 * @throws   
	 */ 
	public static BigInteger max_common_factor_all(BigInteger[] a, int size, int index) {// size<=1000
		BigInteger tmp;
		tmp = max_common_factor_xy(a[index], a[index + 1]);
		a[index + 1] = tmp;
		if (index + 1 == size - 1) {
			result = tmp;
			return result;
		} else {
			max_common_factor_all(a, size, index + 1);
		}
		return result;
	}

	/**   
	 * @Title: min_common_multiple_xy   
	 * @Description: ����������С������  
	 * @param: @param x
	 * @param: @param y
	 * @param: @return      
	 * @return: BigInteger      
	 * @throws   
	 */ 
	public static BigInteger min_common_multiple_xy(BigInteger x, BigInteger y) {
		return (x.multiply(y)).divide(max_common_factor_xy(x, y));
	}

	/**   
	 * @Title: min_common_multiple_all   
	 * @Description: ���������С������   
	 * @param: @param a
	 * @param: @param size
	 * @param: @param index
	 * @param: @return      
	 * @return: BigInteger      
	 * @throws   
	 */ 
	public static BigInteger min_common_multiple_all(BigInteger[] a, int size, int index) {// size<=1000
		BigInteger tmp;
		tmp = min_common_multiple_xy(a[index], a[index + 1]);
		a[index + 1] = tmp;
		if (index + 1 == size - 1) {
			result = tmp;
			return result;
		} else {
			min_common_multiple_all(a, size, index + 1);
		}
		return result;
	}

	public static void main(String[] args) {
		BigInteger x;
		BigInteger[] s1 = new BigInteger[1000];
		BigInteger[] s2 = new BigInteger[1000];
		int size = 0;
		Scanner scan = new Scanner(System.in);

		System.out.print("����������x��0Ϊ��ֹ����");
		if (scan.hasNextBigInteger()) {
			x = scan.nextBigInteger();
		} else {
			System.out.println("��������");
			scan.close();
			return;
		}
		if (x.toString() == "0") {
			scan.close();
			return;
		}
		while (x.toString() != "0") {
			s1[size] = x;
			s2[size] = x;
			size++;
			System.out.print("����������x(x=0��ֹ����):");
			if (scan.hasNextBigInteger()) {
				x = scan.nextBigInteger();
			} else {
				System.out.println("��������");
				scan.close();
				return;
			}
			if (x.toString() == "0" && size == 1) {
				System.out.println("��������������");
				System.out.print("����������x(x=0��ֹ����):");
				x = scan.nextBigInteger();
			}
		}
		scan.close();

		for (int i = 0; i < size; i++) {
			System.out.print(s1[i]);
			if (i == size - 1)
				break;
			System.out.print(",");
		}
		System.out.println("����������ǣ�" + CommonFactorMultiple.max_common_factor_all(s1, size, 0));

		for (int i = 0; i < size; i++) {
			System.out.print(s2[i]);
			if (i == size - 1)
				break;
			System.out.print(",");
		}
		System.out.println("����С�������ǣ�" + CommonFactorMultiple.min_common_multiple_all(s2, size, 0));
		
	}

}
