package Interviews;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;



class Result {

    /*
     * Complete the 'getMaxElementIndexes' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY rotate
     */
	
	// Optimized Way
	// Using Juggling Algorithm for rotation
		/**
		 * Juggling Algorithm:
		 * Let arr[] be {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12} and d = 3
					a) Elements are first moved in first set – 
					         arr[] after this step --> {4 2 3 7 5 6 10 8 9 1 11 12}
					b)    Then in second set.
					          arr[] after this step --> {4 5 3 7 8 6 10 11 9 1 2 12}
					c)    Finally in third set.
					          arr[] after this step --> {4 5 6 7 8 9 10 11 12 1 2 3} 
		 */
	
	// Refer Video in "https://www.geeksforgeeks.org/array-rotation/" for Juggling Algo explanation
	public static List<Integer> getMaxElementIndexesOptimised(List<Integer> a, List<Integer> rotate) {
		 List<Integer> resultLst=new ArrayList<Integer>();
		for(int rot:rotate) {
			List<Integer> rotatedList= a;
			if(rot>0) {
				for(int i=0; i<gcd(rot,a.size());i++ ){
					int temp= a.get(i);
					int j=i,k=0;
					while(true) {
						k=j+rot; // Keep moving k, rot number of times
						if(k>=a.size()) {
							k=k-a.size();
						}
						if(i==k) {
							break; // Came to start point, so break;
						}
						rotatedList.set(j,a.get(k));
						j=k; // move j to k place.
					}
					rotatedList.set(j,temp);
				}
			}
			int maxIndex=getMaxIndex(rotatedList);
            resultLst.add(maxIndex);			
		}
		return resultLst;
	}
	
	// calculating GCD using euclidean Algorithm
	// Refer "https://www.youtube.com/watch?v=JUzYl1TYMcU" to understand euclidean Algorithm
	// GCD gives us number of sets in the array that need to be rotated
	private static int gcd(int a,int b) {
		if(b==0) {
			return a;
		} else {
			return gcd(b,a%b);
		}
	}

    public static List<Integer> getMaxElementIndexes(List<Integer> a, List<Integer> rotate) {
    // Write your code here
      List<Integer> resultLst=new ArrayList<Integer>();
      for(int rot: rotate){
    	  List<Integer> tempArr=a;
         if(rot>0){
        	 tempArr= rotateArr(a,rot);
         }
         int maxIndex=getMaxIndex(tempArr);
            resultLst.add(maxIndex);
      }
      return resultLst;
    }


    private static List<Integer> rotateArr(List<Integer> a,int rotationCnt){
        if(rotationCnt==0){
            return a;
        }
        List<Integer> resultList=new ArrayList<>();
        int temp=a.get(0);
        for(int i=1;i<a.size();i++){
            resultList.add(a.get(i));
        }
        resultList.add(temp);
        rotationCnt--;
        resultList=rotateArr(resultList,rotationCnt);
        return resultList;
    }

      private static int getMaxIndex(List<Integer> a){
          int max=-1;
          int index=-1;
          for(int i=0;i<a.size();i++){
              if(a.get(i)>max){
                  max= a.get(i);
                  index=i;
              }
          }
          return index;
      }

}

public class GetMaxEleIndex {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int rotateCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> rotate = IntStream.range(0, rotateCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.getMaxElementIndexesOptimised(a, rotate);
        System.out.println(result.toString());

        /*bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );*/

        bufferedReader.close();
        //bufferedWriter.close();
    }
}
