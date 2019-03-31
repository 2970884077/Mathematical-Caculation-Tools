/**  
 * All rights Reserved, Designed By CyborgKuroChan
 * @Title:  Test.java   
 * @Package xxaqsxjc.method0   
 * @Description:    �ṩһЩ��֤�����ʽ�ķ���  
 * @author: JinZhiyun    
 * @date:   2019��3��16�� ����8:31:26   
 * @version V1.0 
 * @Copyright: 2019 CyborgKuroChan All rights reserved. 
 * ע�⣺�������ɳ������ֽ�����(wechat:Jzy_bb_1998)
 */
package someTest;

import java.util.regex.Pattern;

/**   
 * @ClassName:  Test   
 * @Description: �ṩһЩ��֤�����ʽ�ķ���   
 * @author: JinZhiyun
 * @date:   2019��3��16�� ����8:30:54   
 *     
 * @Copyright: 2019 CyborgKuroChan All rights reserved. 
 * ע�⣺�������ɳ������ֽ�����(wechat:Jzy_bb_1998)
 */ 
public class Test {
	/**   
	 * @Title: isOnlyContain01   
	 * @Description: ��GoldwasserMicali�����㷨���Զ����Ƽ��ܣ��������Ӵ��Ƿ�ֻ��0��1���ж�    
	 * @param: @param str
	 * @param: @return      
	 * @return: boolean      
	 * @throws   
	 */
	public static boolean isOnlyContain01(String str) {
	    Pattern pattern = Pattern.compile("[0-1]*");
	    return pattern.matcher(str).matches(); 
	}
	
	/**   
	 * @Title: isLegalInteger   
	 * @Description: �ж������Ƿ�Ϸ������ǿ���������   
	 * @param: @param str
	 * @param: @return      
	 * @return: boolean      
	 * @throws   
	 */ 
	public static boolean isLegalInteger(String str) {
		return (isInteger(str) && !str.equals(""))? true:false;
	}
	
	/**   
	 * @Title: isInteger   
	 * @Description: �ж������Ƿ�ȫΪ����
	 * @param: @param str
	 * @param: @return      
	 * @return: boolean      
	 * @throws   
	 */ 
	public static boolean isInteger(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(str).matches();
	}
	
}
