
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
		
//		Matrix AB = new Matrix(a).multiply(new Matrix(b));
//		AB.print();

		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 
	}

}
