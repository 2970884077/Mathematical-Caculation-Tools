package xxaqsxjc.method0;

import java.math.BigInteger;
import java.util.Scanner;

public class InputBigInteger {
	public static BigInteger inputBigInteger() {
		BigInteger n = new BigInteger("0");
		Scanner scan = new Scanner(System.in);
		System.out.print("������������n��");
		if (scan.hasNextBigInteger()) {
			n = scan.nextBigInteger();
		} else {
			System.out.println("��������");
		}
		scan.close();
		return n;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger b = InputBigInteger.inputBigInteger();
		System.out.println(b);
	}

}
