package leetcode;


// Refer https://www.geeksforgeeks.org/array-rotation/

public class RotateArray {

	public static void main(String[] args) {
		RotateArray rotate = new RotateArray();
        int arr[] = {1, 2, 3, 4, 5, 6, 7,8,9,10,11,12};
        rotate.leftRotate(arr, 5, 12);
        rotate.printArray(arr, 12);
	}
	
	
	/*
	 * GCD{arr.length,d}={12,3}=3. So, 3 sets
	 * Sets: {1,4,7,10}
	 *       {2,5,8,11}
	 *       {3,6,9,12}
	 */
	
	void leftRotate(int arr[], int d, int n) 
    {
        int i, j, k, temp;
        for (i = 0; i < gcd(d, n); i++)  // To Divide in to gcd number of sets.
        {
            /* move i-th values of blocks */
            temp = arr[i];
            j = i;
            while (1 != 0)  // Internal set element rotation by d locations.
            {
                k = j + d;
                if (k >= n) 
                    k = k - n;
                if (k == i) 
                    break;
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp; // replace first element of set back in the set in the last loc.
        }
    }
	
	/*Fuction to get gcd of a and b*/
	/*
	 * 12 is divided by 1,3,4,6,12
	 * 3 is divided by 1,3
	 * 
	 * Greatest common divisor is 3
	 */
	
    int gcd(int a, int b) 
    {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
    
    /* function to print an array */
    void printArray(int arr[], int size) 
    {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
    }

}
