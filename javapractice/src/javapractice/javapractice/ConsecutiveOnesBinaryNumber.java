package javapractice;

public class ConsecutiveOnesBinaryNumber {

	public static void main(String[] args) {
		countConsecutiveOnes(221);
	}
	
	private static void countConsecutiveOnes(int num) {
		if(num<0) {
			return;
		}
		int cnt=0;
		while(num>0 ) {
			num&=(num<<1);
			cnt++;
		}
		System.out.println("Consecutive Ones Count = "+cnt);
	}

}
