package javapractice;

import java.util.Arrays;

public class MergeTwoSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a1= {1,3,5,7,9};
		int[] a2= {2,4,6,8,10};
		mergeTwoSortedArrays(a1,a2);
		
		String A[] = {"good", "person"};
		String B[] = { "boy","he", "is"};
		mergeStringArrays(A,B);
	}
	
	// For Numbers
	private static void mergeTwoSortedArrays(int[] a1, int[] a2) {
		int[] a3 = new int[a1.length+a2.length];
		int i=0,j=0,k=0;
		while(i<a1.length && j<a2.length) {
				if(a1[i]==a2[j]) {
					a3[k++]=a1[i++];
					j++;
					continue;
				}
				
				if(a1[i]<a2[j]) {
					a3[k]=a1[i];
					i++;
				} else {
					a3[k]=a2[j];
					j++;
				}
				k++;
		}
			
			
			while(i<a1.length) {
				a3[k++]=a1[i++];
			}
			
			while(j<a2.length) {
				a3[k++]=a2[j++];
			}
		System.out.println(Arrays.toString(a3));
	}
	
	// For Words-Ascending order
	private static void mergeStringArrays(String[] a1, String[] a2) {
		String resArr[]= new String[a1.length+a2.length];
		int i=0,j=0,k=0;
		while(i<a1.length && j<a2.length) {
			int res=a1[i].compareTo(a2[j]);
			if(res==0){
				resArr[k]=a1[i];
				i++;
				j++;
			} else if(res<0) {
				resArr[k]=a1[i];
				i++;
			} else {
				resArr[k]=a2[j];
				j++;
			}
			k++;
		}
		
		while(i<a1.length) {
			resArr[k]=a1[i];
			i++;
			k++;
		}
		
		while(j<a2.length) {
			resArr[k]=a1[j];
			j++;
			k++;
		}
		System.out.println(Arrays.toString(resArr));
	}
}
