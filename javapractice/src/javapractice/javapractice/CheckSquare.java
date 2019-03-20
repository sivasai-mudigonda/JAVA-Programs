package javapractice;

// How to check if given four points form a square?
// Refer https://softwareengineering.stackexchange.com/questions/176938/how-to-check-if-4-points-form-a-square
public class CheckSquare {

	public static void main(String[] args) {		
		Point p1=new Point(20,10);
		Point p2=new Point(10,20);
		Point p3=new Point(20,20);
		Point p4=new Point(10,10);
		System.out.println(squareUtil(p1,p2,p3,p4));
	}
	
	/* To check if 4 points form square, following need to match
	 * 1.>Length's of P1=P2, P1=P4. For safe check, P2=P3 and P3=P4 
	 * 2.> Diagonal lengths of P1 to P3 should be equal to P2 to P4.
	*/
	private static boolean squareUtil(Point p1,Point p2,Point p3,Point p4) {
		int l1=findLength(p1,p2); // (P1,P2)
		int l2=findLength(p1,p3); // (P1,P3)
		int l3=findLength(p1,p4); // (P1,P4)
		int l4=0,l5=0;
		int d1=0,d2=0,d3=0;
		boolean areLengthSame=false;
		if(l1==l2 ){
	    	l4=findLength(p2,p4); // (P2,P4)
	    	l5=findLength(p3,p4); // (P3,P4)
	    	if(l4==l5) {
	    		areLengthSame=true;
	    		d1=findDiagLength(l1,l2);
	    		d3=l3;
	    	}
	    	
		} else if(l1==l3  ){
			l4=findLength(p3,p4); // (P3,P4)
			l5=findLength(p3,p2); // (P3,P2)
			if(l4==l5) {
				areLengthSame=true;
	    		d1=findDiagLength(l1,l3);
	    		d3=l2;
	    	}
		} else if(l2==l3){
			l4=findLength(p3,p2); // (P3,P2)
	    	l5=findLength(p4,p2); // (P4,P2)
	    	if(l4==l5 && l4==l2) {
				areLengthSame=true;
	    		d1=findDiagLength(l2,l3);
	    		d3=l1;
	    	}
		}
		if(areLengthSame==true) {
			d2=findDiagLength(l4,l5);
			if(d1==d2 && d1==d3) {
	    		return true;
	    	}
		}
		return false;
	}
	
	// To find length from coordinates --> l = sqrt( (p2.x-p1.x)^2 + (p2.y-p1.y) )
	private static int findLength(Point p1,Point p2) {
		int length=0;
		double lengthUtil= Math.pow((p1.x-p2.x),2)+Math.pow((p1.y-p2.y),2);
		length=(int) Math.sqrt(lengthUtil);
		return length;
	}
	
	// Pythagoras Theorem --> c^2{Hypotenuse} = a^2+b^2
	private static int findDiagLength(double a, double b) {
		int diagLength=0;
		double diagUtil=Math.pow(a, 2)+Math.pow(b, 2);
		diagLength=(int) Math.sqrt(diagUtil);
		return diagLength;
	}
	
	private static class Point{
		int x,y;

		/**
		 * @param x
		 * @param y
		 */
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
}
