/**  
 * All rights Reserved, Designed By CyborgKuroChan
 * @Title:  EulerFuction.java   
 * @Package xxaqsxjc.method0   
 * @Description:    TODO(��һ�仰�������ļ���ʲô)   
 * @author: JinZhiyun    
 * @date:   2019��3��14�� ����10:41:49   
 * @version V1.0 
 * @Copyright: 2019 CyborgKuroChan All rights reserved. 
 * ע�⣺�������ɳ������ֽ�����(wechat:Jzy_bb_1998)
 */ 
package xxaqsxjc.method0;

import java.math.BigInteger;
import java.util.Scanner;

/**   
 * @ClassName:  EulerFuction   
 * @Description: ŷ�������ļ���  
 * @author: JinZhiyun
 * @date:   2019��3��14�� ����10:40:30   
 *     
 * @Copyright: 2019 CyborgKuroChan All rights reserved. 
 * ע�⣺�������ɳ������ֽ�����(wechat:Jzy_bb_1998)
 */ 
public class EulerFuction {
	/**   
	 * @Title: Euler   
	 * @Description: ŷ������ֵ�ļ���     
	 * @param: @param n
	 * @param: @return      
	 * @return: BigInteger      
	 * @throws   
	 */ 
	public static BigInteger Euler(BigInteger n) {
		BigInteger size = new BigInteger("0");
		BigInteger i = new BigInteger("1");
		while (i.compareTo(n) <= 0) {
			if (CommonFactorMultiple.max_common_factor_xy(i, n).compareTo(new BigInteger("1")) == 0) {
				size = size.add(new BigInteger("1"));
			}
			i = i.add(new BigInteger("1"));
		}
		return size;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger n;
		Scanner scan = new Scanner(System.in);
		System.out.print("������������n��");
		if (scan.hasNextBigInteger()) {
			n = scan.nextBigInteger();
		} else {
			System.out.println("��������");
			scan.close();
			return;
		}
		scan.close();
		System.out.println("n��ŷ������ֵΪ��" + EulerFuction.Euler(n));
	}

}
