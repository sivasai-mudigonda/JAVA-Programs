/**
 * 
 */
package javapractice;

import java.util.Stack;

/**
 * @author SIVA SAI
 *
 */
public class FirstOneBinaryRepresentation {

	/**
	 * @param args
	 */
	
	/**
	 * Write a one line function to return position of first 1 from right to left, 
	 * in binary representation of an Integer?
	 * 
	 * eg:
			I/P    18,   Binary Representation 010010
			O/P   2
			I/P    19,   Binary Representation 010011
			O/P   1
	 *  
	 *  Refer https://beginnersbook.com/2014/07/java-program-to-convert-decimal-to-binary/
	 */
	static Stack<Integer> st= new Stack<>();
	public static void main(String[] args) {
		util(18);
		util(12);
		util(19);
	}
	private static void util(int num) {
		st= binaryRepresentation(num);
		int index=indexOneRtoL();
		System.out.println("First one in binary representation from right to left for num = "+num+" is "+index);
	}
	
	private static Stack<Integer> binaryRepresentation(int num) {
		if(num==0) {
			st.push(0);
			return st;
		}
		
		st.push(num%2);
		if(num/2==1) {
			st.push(1);
			return st;
		}		
		binaryRepresentation(num/2);
		return st;
	}
	
	private static int indexOneRtoL() {
		String binRep=convertIntToString();
		int indexRtoL=0;
		for(int i=binRep.length()-1;i>=0;i--) {
			indexRtoL++;
			if(binRep.charAt(i)=='1' ) {
				break;
			}
		}
		return indexRtoL;
	}
	
	private static String convertIntToString() {
		StringBuilder sb= new StringBuilder();
		while(!st.isEmpty()) {
			//System.out.print(st.peek());
			sb.append(st.pop());			
		}
		//System.out.println();
		return sb!=null?sb.toString():"";
	}
	
}
