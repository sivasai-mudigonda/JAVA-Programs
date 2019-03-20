package javapractice;

/**
 * Given two rectangles, find if the given two rectangles overlap or not?
 * Refer https://www.geeksforgeeks.org/find-two-rectangles-overlap/
 * AND
 * https://www.youtube.com/watch?v=wx0nyomRS_U
 */
public class CheckRectangleOverlap {

	public static void main(String[] args) {
		// First rectangle's diagonal points
		Point p1= new Point(0,10);
		Point r1= new Point(10,0);
		
		// Second rectangle's diagonal points
		Point p2= new Point(5,5);
		Point r2= new Point(15,0);
		
		System.out.println(isRectangleOverlaping(p1,r1,p2,r2));
	}
	
	private static boolean isRectangleOverlaping(Point p1,Point r1, Point p2,Point r2) {
		// If one rectangle is on left side of other
		if(p1.x>r2.x || p2.x>r1.x) {
			return false;
		}
		
		// If one rectangle is above other
		if(p1.y<r2.y || p2.y<r1.y) {
			return false;
		}
		return true;
	}
	
	private static  class Point{
		int x=0;
		int y=0;
		public Point(int x,int y) {
			this.x=x;
			this.y=y;
		}
	}

}
