public class Matrix
{
	private int[][] A;
	
	public Matrix(int[][] newA)
	{
		this.A = new int[newA.length][newA[0].length];
		for ( int i = 0; i < this.A.length; i++ )
			for ( int j = 0; j < this.A[0].length; j++ )
				this.A[i][j] = newA[i][j];
	}
	
	public Matrix transpose()
	{
		int[][] transposeM = new int[this.A[0].length][this.A.length];
		//a11 a12 a13 a14
		//a21 a22 a23 a24
		//a31 a32 a33 a34
		
		for ( int i = 0; i < this.A[0].length; i++ )
			for ( int j = 0; j < this.A.length; j++ )
				transposeM[i][j] = this.A[j][i];
		
		
		//a11 a21 a13
		//a12 a22 a23
		//a13 a23 a33
		//a14 a24 a34
		return new Matrix(transposeM);
	}
	
	public Matrix multiply(Matrix other)
	{
		if (A.length != other.A[0].length)
		{
			System.out.println("The matrix product cannot be"
					+ " computed due to mismatched matrix dimensions.");
			return null;
		}
		
		int[][] AB = new int[this.A[0].length][other.A.length];
		
		for ( int i = 0; i < this.A.length; i++ )
			for ( int j = 0; j < other.A.length; j++ )
			{
				for ( int x = 0; x < this.A[i].length; x++ )
					for ( int y = 0; y < other.A.length; y++ )
						AB[i][j] += this.A[i][x] * other.A[y][j];
			}
		
		return new Matrix(AB);
	}
	
	public void print()
	{
		for (int[] row : this.A)
			printRow(row);
	}
	
	public static void printRow(int[] row)
	{
		System.out.print("[");
		for (int i = 0; i < row.length - 1; i++)
		{
			System.out.print(row[i]);
			System.out.print("\t");
		}
		System.out.println(row[row.length - 1] + "]");
	}
}
