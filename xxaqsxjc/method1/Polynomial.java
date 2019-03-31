/**  
 * All rights Reserved, Designed By CyborgKuroChan
 * @Title:  Polynomial.java   
 * @Package xxaqsxjc.method1   
 * @Description: �����˶���ʽ�����ݽṹ������  
 * @author: JinZhiyun    
 * @date:   2019��3��14�� ����11:12:44   
 * @version V1.0 
 * @Copyright: 2019 CyborgKuroChan All rights reserved. 
 * ע�⣺�������ɳ������ֽ�����(wechat:Jzy_bb_1998)
 */
package xxaqsxjc.method1;

/**   
 * @ClassName:  Polynomial   
 * @Description: ��������ʽ���ݽṹ��
 * @author: JinZhiyun
 * @date:   2019��3��14�� ����11:12:01   
 *     
 * @Copyright: 2019 CyborgKuroChan All rights reserved. 
 * ע�⣺�������ɳ������ֽ�����(wechat:Jzy_bb_1998)
 */ 
public class Polynomial implements Cloneable {
	/**   
	 * @Fields maxDeg : ������߶���ʽ����  
	 */   
	public static final int Max_Deg = 65535; 
	
	/**   
	 * @Fields p : �������
	 */   
	private final int p = 2;
	
	/**   
	 * @Fields effectiveMaxDeg : ����ʽ����Ч����ߴ��� ����0*x^3+x^2+x���� effectiveMaxDeg=2
	 */   
	public int effectiveMaxDeg;
	
	/**   
	 * @Fields polyArray : ��������ʽ��ϵ�����ʹ���ǰ����0*x^4+0*x^3+x^2+x����polyArray={0,1,1,0,0}��Ҳ��Ч��polyArray={0,1,1}��
	 */   
	public int[] polyArray;

	/**   
	 * <p>Title: clone</p>   
	 * <p>Description: ��¡�õ�һ������ĸ��� </p>   
	 * @return   
	 * @see java.lang.Object#clone()   
	 */  
	@Override
	public Object clone() {
		Polynomial copy = null;
		try {
			copy = (Polynomial) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return copy;
	}
	

	/**   
	 * @Title:  Polynomial   
	 * @Description:  Ĭ�Ϲ���������ʼ������ʽ��һЩ����
	 * @param:    
	 * @throws   
	 */  
	public Polynomial() {
		polyArray = new int[1];
		polyArray[0] = 0;
		effectiveMaxDeg = 0;
	}

	/**   
	 * @Title:  Polynomial   
	 * @Description:   �������Ч����Ϊ����Ĺ���������  Polynomial p=new Polynomial(3)�����ö���ʽx^3
	 * @param:  @param deg  
	 * @throws   
	 */  
	public Polynomial(int deg) {
		polyArray = new int[deg + 1];
		polyArray[deg] = 1;
		effectiveMaxDeg = deg;
	}

	/**   
	 * @Title:  Polynomial   
	 * @Description:  ��ϵ��Ϊ����Ĺ���������input={0,1,1}�����ö���ʽx^2+x
	 * @param:  @param input  
	 * @throws   
	 */  
	public Polynomial(int[] input) {
		if (input.length >= 1) {
			polyArray = input;
			for (int i = 0; i < polyArray.length; i++) {
				if (polyArray[i] > 0) {
					polyArray[i] = 1;
				}
				if (polyArray[i] < 0) {
					polyArray[i] = 0;
				}
			}
		} else {
			polyArray = new int[1];
			polyArray[0] = 1;
		}
		this.validize();
	}
	

	/**   
	 * @Title:  Polynomial   
	 * @Description: ������ֱ����ʽ���ַ�������x^4+x^3+x+1������ ��װ
	 * @param:  @param polyStr  
	 * @throws   
	 */  
	public Polynomial(String polyStr) {
//		int i=0;
//		while (i<polyStr.length()) {
//			if (polyStr.charAt(i)=='x') {
//				i++;
//				if (polyStr.charAt(i)=='^') {
//					i++;
//					if (isN)
//					if (i==2) {
//						effectiveMaxDeg=Integer.parseInt(Character.toString(polyStr.charAt(i)));
//						polyArray=new int[effectiveMaxDeg+1];
//
//					}
//					else {
//						
//					}
//				}
//			}
//		}
	}


	/**   
	 * @Title: validize   
	 * @Description: ���û���һЩ��ǡ����������кϷ�������input={0,12,0,0},�����ЧΪinput={0,1}(������ʽΪx)
	 * @param:       
	 * @return: void      
	 * @throws   
	 */ 
	public void validize() {
		int[] newArray = { 0 };
		for (int i = polyArray.length - 1; i >= 0; i--) {
			if (polyArray[i] != 0) {
				newArray = new int[i + 1];
				for (int j = 0; j < i + 1; j++) {
					newArray[j] = polyArray[j];
				}
				polyArray = newArray;
				effectiveMaxDeg = polyArray.length - 1;
				break;
			}
		}
		polyArray = newArray;
		effectiveMaxDeg = polyArray.length - 1;
	}

	/**   
	 * @Title: setPolyArary   
	 * @Description: setter�����������޸Ķ���ʽϵ��  
	 * @param: @param input      
	 * @return: void      
	 * @throws   
	 */ 
	public void setPolyArary(int[] input) {
		polyArray = input;
	}

	/**   
	 * <p>Title: toString</p>   
	 * <p>Description: ��дtoString��ʹ����soutʱ��������ʾx^3+x^2+x����ֱ�۵���ʽ</p>   
	 * @return   
	 * @see java.lang.Object#toString()   
	 */  
	public String toString() {
		String output = "";
		for (int i = polyArray.length - 1; i >= 2; i--) {
			if (polyArray[i] != 0) {
				output += "x^" + i + "+";
			}
		}
		if (polyArray.length >= 2) {
			if (polyArray[1] == 1 && polyArray[0] == 1) {
				output += "x+1";
			} else if (polyArray[1] == 0 && polyArray[0] == 1) {
				output += "1";
			} else if (polyArray[1] == 1 && polyArray[0] == 0) {
				output += "x";
			} else {
				if (!output.equals("")) {
					output = output.substring(0, output.length() - 1);
				} else {
					output = "0";
				}
			}
		} else {
			if (polyArray[0] == 1) {
				output += "1";
			} else {
				output += "0";
			}
		}
		return output;
	}

	/**   
	 * @Title: equals   
	 * @Description: �ж���������ʽ�Ƿ����  
	 * @param: @param p2
	 * @param: @return      
	 * @return: boolean      
	 * @throws   
	 */ 
	public boolean equals(Polynomial p2) {
		if (this.effectiveMaxDeg == p2.effectiveMaxDeg) {
			for (int i = 0; i <= this.effectiveMaxDeg; i++) {
				if (this.polyArray[i] != p2.polyArray[i]) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	/**   
	 * @Title: add   
	 * @Description: ��������ʽ֮��
	 * @param: @param p2
	 * @param: @return      
	 * @return: Polynomial      
	 * @throws   
	 */ 
	public Polynomial add(Polynomial p2) {
		Polynomial p1 = this;
		int maxDeg = Math.max(p1.polyArray.length, p2.polyArray.length);
		int minDeg = Math.min(p1.polyArray.length, p2.polyArray.length);
		int[] pAdd = new int[maxDeg];
		for (int i = 0; i < minDeg; i++) {
			pAdd[i] = (p1.polyArray[i] + p2.polyArray[i]) % p;
		}
		for (int i = minDeg; i < maxDeg; i++) {
			if (p1.polyArray.length > p2.polyArray.length) {
				pAdd[i] = p1.polyArray[i];
			} else {
				pAdd[i] = p2.polyArray[i];
			}
		}
		return new Polynomial(pAdd);
	}

	/**   
	 * @Title: sub   
	 * @Description: ��������ʽ֮��   
	 * @param: @param p2
	 * @param: @return      
	 * @return: Polynomial      
	 * @throws   
	 */ 
	public Polynomial sub(Polynomial p2) {
		return this.add(p2);
	}

	/**   
	 * @Title: multiply   
	 * @Description: ��������ʽ֮�� 
	 * @param: @param p2
	 * @param: @return      
	 * @return: Polynomial      
	 * @throws   
	 */ 
	public Polynomial multiply(Polynomial p2) {
		Polynomial p1 = this;
		int[] result = { 0 };
		Polynomial pResult = new Polynomial(result);
		int[] a;
		for (int i = 0; i < p1.polyArray.length; i++) { // �������
			if (p1.polyArray[i] != 0) {
				a = new int[i + p2.polyArray.length];
				for (int j = 0; j < i; j++) {
					a[j] = 0;
				}
				for (int j = i; j < i + p2.polyArray.length; j++) {
					a[j] = p2.polyArray[j - i];
				}

				pResult = pResult.add(new Polynomial(a));
			}
		}
		return pResult;
	}

	/**   
	 * @Title: divide   
	 * @Description: ��������ʽ֮��  
	 * @param: @param p2
	 * @param: @return
	 * @param: @throws PolyDivideException      
	 * @return: Polynomial      
	 * @throws   
	 */ 
	public Polynomial divide(Polynomial p2) throws PolyDivideException {
		Polynomial p1 = this;
		Polynomial qResult = new Polynomial();
		if (!p2.equals(new Polynomial())) {
			if (p1.effectiveMaxDeg >= p2.effectiveMaxDeg) {
				Polynomial tmpp1 = p1;
				int[] result;
				do {
					result = new int[tmpp1.effectiveMaxDeg - p2.effectiveMaxDeg + 1];
					result[result.length - 1] = 1;
					for (int i = 0; i < result.length - 1; i++) {
						result[i] = 0;
					}
					Polynomial qTmpResult = new Polynomial(result);
					qResult = qResult.add(qTmpResult);
					tmpp1 = tmpp1.sub(qTmpResult.multiply(p2));
					if (tmpp1.effectiveMaxDeg == 0 && p2.effectiveMaxDeg == 0) {
						qResult = qResult.add(tmpp1);
						break;
					}
				} while (tmpp1.effectiveMaxDeg >= p2.effectiveMaxDeg);
			}
		} else {
			throw new PolyDivideException("��������Ϊ��");
		}
		return qResult;
	}

	/**   
	 * @Title: mod   
	 * @Description: ģp2������   
	 * @param: @param p2
	 * @param: @return
	 * @param: @throws PolyDivideException      
	 * @return: Polynomial      
	 * @throws   
	 */ 
	public Polynomial mod(Polynomial p2) throws PolyDivideException {
		Polynomial p1 = this, mResult;
		mResult = p1.sub(p1.divide(p2).multiply(p2));
		return mResult;
	}
	
	/**   
	 * @Title: pow   
	 * @Description: p1��deg�η� 
	 * @param: @param p1
	 * @param: @param deg
	 * @param: @return      
	 * @return: Polynomial      
	 * @throws   
	 */ 
	public static Polynomial pow(Polynomial p1, int deg) {
		Polynomial p2=p1;
		if (deg<0) {
			return new Polynomial();
		}
		if (deg == 0) {
			return new Polynomial(0);
		}
		for (int i = 0; i < deg - 1; i++) {
			p2 = p2.multiply(p1);
		}
		return p2;
	}

	public static void main(String[] args) throws PolyDivideException {
		// TODO Auto-generated method stub
		int[] a = { 1, 1, 1, 0, 1 };
		int[] b = { 1, 0, 1, 1, 1, 0, 0, 0, 1 };
		Polynomial pa = new Polynomial(a);
		Polynomial pb = new Polynomial(b);
//		System.out.println(pa.add(pb));
//		System.out.println(pa.multiply(pb));
		System.out.println(pa.multiply(pa).add(pa));
		System.out.println(pa);
		System.out.println(pb);
		System.out.println(pa.multiply(pa).add(pa).mod(pb));
		System.out.println(pa);
		System.out.println(pb);

	}

}
