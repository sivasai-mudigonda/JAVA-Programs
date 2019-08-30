/**
 * 
 */
package practice;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author SIVA SAI
 *
 */
public class StringSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str="hello";
		Character[] chArr= new Character[str.length()];
		int i=0;
		for(char c:str.toCharArray()) {
			chArr[i]=c;
			i++;
		}
		Arrays.sort(chArr, new Comparator<Character>(){
			public int compare(Character c1, Character c2) {
				return c1.compareTo(c2);
			}
		});
		StringBuilder sb = new StringBuilder();
		for(Character c:chArr) {
			 sb.append(c);
		}
		System.out.println(sb.toString());	
	}
}
