package Interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/*
 *  Given a run-length encoded input, decode it into an Iterable. The RLE input is a List of Integer objects, with even elements representing the run lengths and odd elements representing the encoded token.

For example:
[2, 6, 3, 5] -> [6, 6, 5, 5, 5]
[1, 4, 2, 3] -> [4, 3, 3]

 */
public class RLE_Decode_Google {

	public static void main(String[] args) {
		Iterable<Integer> res=decodeRLE(Arrays.asList(2,4,5,7,8,9));
		Iterator<Integer> it = res.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	private static Iterable<Integer> decodeRLE(List<Integer> li){
		List<Integer> resLi = new ArrayList<>();
		int key = 0;
		for(int i=0;i<li.size();i=i+2) {
			key=li.get(i);
			while(key>0) {
				resLi.add(li.get(i+1));
				key--;
			}
		}		
		Iterable<Integer> result = resLi;
		return result;
	}

}
