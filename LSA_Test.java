
public class LSA_Test
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		
		int[][] arr = {{3,-1,2,0},
						{5,-3,4,-6},
						{10,8,-7,9}};
		
		int[][] a = {{1,2,3}};
		int[][] b = {{1},
				{2},
				{3}
		};
		
		Matrix mn = new Matrix(arr);
		mn.print();
		System.out.println();
		mn.transpose().print();
		System.out.println();
		
		Matrix A = new Matrix(a);
		A.print(); 
		System.out.println();
		
		Matrix B = new Matrix(b);
		B.print(); 
		System.out.println();
		
		Matrix AB = A.multiply(B);
		AB.print();
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 
	}

}
