/**
 * 
 */
package practice;

/**
 * @author SIVA SAI
 *
 */
public class ArmstrongNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String str="120";
			isArmstrong(str);
			str="153";
			isArmstrong(str);		
		}catch(NumberFormatException e) {
			System.out.println("Incorrect input");
		}
	}
	
	
	private static void isArmstrong(String str) {
		char[] ch=str.toCharArray();
		int i=0;
		int sum=0;
		while(i<ch.length) {
			int j=Character.getNumericValue(ch[i]); // Integer.parseInt(String.valueOf(ch[i]));			
			sum+=Math.pow(j, str.length());
			i++;
		}
		if(sum==Integer.parseInt(str) ){
			System.out.println(str+" is an Armstrong number");
		} else {
			System.out.println(str+" is not an Armstrong number");
		}
	}
}
