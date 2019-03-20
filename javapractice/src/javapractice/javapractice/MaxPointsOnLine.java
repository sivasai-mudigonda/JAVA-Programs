/**
 * 
 */
package javapractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author SIVA SAI
 *
 *
 *Given n points on a 2D plane, find the maximum number of points that lie on the same straight line?
 *
 *Refer https://github.com/awangdev/LintCode/blob/master/Java/Max%20Points%20on%20a%20Line.java
 *
 *Time Complexity =O(N)
 */
public class MaxPointsOnLine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Point> li= new ArrayList<>();
		Point p1=new Point(1,1);
		Point p2=new Point(3,2);
		Point p3=new Point(5,3);
		Point p4=new Point(4,1);
		Point p5=new Point(2,3);
		Point p6=new Point(1,4);
		li.add(p1);
		li.add(p2);
		li.add(p3);
		li.add(p4);
		li.add(p5);
		li.add(p6);
		maxPointsOnLine(li); // Expected Output=4
	}
	
	/*
	 * Slope = (y2-y1) / (x2-x1)
	 * If slopes are same, that means they are on same line.
	 * 
	 * As Division might cause precision problem, We calculate GCD and store it.
	 */
	
	private static void maxPointsOnLine(List<Point> pts){
		if(pts==null || pts.size()==0) {
			return;
		}
		
		int result=0;
		Map<String,Integer> map= new HashMap<>();
		for(int i=0;i<pts.size();i++) {
			int overlap=0;
			int max=0;
			for(int j=i+1;j<pts.size();j++) {
				int x=pts.get(j).getX()-pts.get(i).getX();
				int y=pts.get(j).getY()-pts.get(i).getY();
				if(x==0 && y==0) {
					overlap++;
					continue;
				}
				int gcd= gcd(x,y);
				if(gcd!=0) {
					x/=gcd;
					y/=gcd;
				}
				String key=x+"#"+y;
				if(map.containsKey(key) ){
					map.put(key, map.get(key)+1);
				} else {
					map.put(key, 1);
				}
				max= Math.max(max,map.get(key));
			}
			result=Math.max(result,max+overlap+1); // Add one for the current point
			map.clear();
		}
		System.out.println("Max Points On Line = "+result);
	}
	
	private static int gcd(int x, int y) {
		if(y==0) {
			return x;
		}
		return gcd(y,x%y);
	}
	
	private static class Point{
		private int x;
		private int y;
		
		Point(int x, int y){
			this.setX(x);
			this.setY(y);
		}

		/**
		 * @return the x
		 */
		public int getX() {
			return x;
		}

		/**
		 * @param x the x to set
		 */
		public void setX(int x) {
			this.x = x;
		}

		/**
		 * @return the y
		 */
		public int getY() {
			return y;
		}

		/**
		 * @param y the y to set
		 */
		public void setY(int y) {
			this.y = y;
		}
		
		
	}

}
