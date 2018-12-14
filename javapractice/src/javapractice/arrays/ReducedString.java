package javapractice.arrays;

import java.io.IOException;
import java.util.Scanner;

public class ReducedString {
	
	/* Sample Inputs
	 * aaabccddd
	 * aa
	 * baab
	 * 
	 * Outputs for the above inputs
	 * abd
	 * Empty String
	 * Empty String
	 *  
	 */
	
	

    // Complete the super_reduced_string function below.
    static String super_reduced_string(String s) {
        char[] ch= s.toCharArray();
        StringBuilder sb= new StringBuilder();
        int j=0;
        sb.insert(j,ch[0]);
        for(int i=1;i<ch.length;i++){
            if(sb.length()==0 || ch[i]!=sb.charAt(j)){
                j++;
                sb.insert(j,ch[i]);
             } else if(sb.length()!=0 ){
                    sb.deleteCharAt(j);
                    j--;
              }
                //System.out.println(sb.toString());
        }
        if(sb.length()==0 ){
            return "Empty String";
        }
       return sb.toString();

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
    	
    	System.out.println("Enter String Input");
        String s = scanner.nextLine();

        String result = super_reduced_string(s);
        System.out.println("Reduced String= " +result);

        //bufferedWriter.write(result);
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}

