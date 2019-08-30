/**
 * 
 */
package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * @author SIVA SAI
 *
 */
public class ListDuplicateCount {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListDuplicateCount p = new ListDuplicateCount();
        
        ArrayList<String> l = new ArrayList<String>();
         
        l.add("cat");
        l.add("dog");
        l.add("cat");
        l.add("dog");
        l.add("cow");
        l.add("dog");
        l.add("duck");
        l.add("duck");
        l.add("goose");
         
        System.out.println("Number of duplicates elements = " + p.getDupCount(l));
	}
	
	
	public int getDupCount(ArrayList<String> l)
    {
        int cnt = 0;
        HashSet<String> h = new HashSet<String>(l);
 
        for (String token : h)
        {
            if (Collections.frequency(l, token) > 1)
                cnt++;
        }
         
        return cnt;
    }

}
