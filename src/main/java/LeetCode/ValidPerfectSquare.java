package LeetCode;

public class ValidPerfectSquare {
	
	static boolean bst(long l,long r, int num){
        long mid = (l+r)/2;
        long sq = mid*mid;
        if(l>r){
            return false;
        }

        if(sq==num){
            return true;
        }

        if(sq>num){
            return bst(l,mid-1,num);
        }
        return    bst(mid+1,r,num);


    }

	public static void isPerfectSquare(int num) {
//        long[] nos = new long[num/16];

        
        
        System.out.println(bst( 1, num, num));

    }
	
	public static void main(String[] args) {
		int no=2147483647;
		System.out.println(no);
		isPerfectSquare(no);
	}
}
