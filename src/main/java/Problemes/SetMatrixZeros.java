package Problemes;

public class SetMatrixZeros {
	
	public static void setRowColumnZero(int[][] arr,int row,int col) {
		
		int i=0;
		while(i<arr[0].length) {
			if(arr[row][i]!=0) {
				arr[row][i] = -1;
			}
			i++;
			
		}
		i=0;
		
		while(i<arr.length) {
			if(arr[i][col]!=0)
				arr[i][col] = -1;
			i++;
		}
	}
	
	public static void main(String[] args) {
		int[][] arr = {{0,1,1},{1,1,1},{1,1,1}};
//		int[][] arr = {{0,1}};

		int nr = arr.length;
		int nc = arr[0].length;
		
		int rowM[] = new int[nr];
		int colM[] = new int[nc];
	
		
		
//		System.out.println(nr+" "+nc);
		
		
		
		for(int i=0;i<nr;i++) {
			for(int j=0;j<nc;j++) {
				if(arr[i][j]==0) {
//					setRowColumnZero(arr,i,j);
					rowM[i] = 1;
					colM[j] = 1;
				}
			}
		}
		
		for(int i=0;i<rowM.length;i++) {
			for(int j=0;j<nc;j++) {
				if(rowM[i]==1) {
					arr[i][j] = 0;
				}
			}
		}
		for(int i=0;i<colM.length;i++) {
			for(int j=0;j<nr;j++) {
				if(colM[i]==1) {
					arr[j][i] = 0;
				}
			}
		}
		
//		for(int i=0;i<nr;i++) {
//			for(int j=0;j<nc;j++) {
//				if(arr[i][j]==-1) {
//					arr[i][j] = 0;
//				}
//			}
//		}
		
		for(int i=0;i<nr;i++) {
			for(int j=0;j<nc;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
