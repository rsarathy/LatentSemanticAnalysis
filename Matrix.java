public class Matrix
{
	private double[][] mat;

	public Matrix(double[][] newA)
	{
		mat = new double[newA.length][newA[0].length];
		for (int i = 0; i < mat.length; i++)
			for (int j = 0; j < mat[0].length; j++)
				mat[i][j] = newA[i][j];
	}

	public Matrix transpose()
	{
		double[][] transposeM = new double[mat[0].length][mat.length];
		// a11 a12 a13 a14
		// a21 a22 a23 a24
		// a31 a32 a33 a34

		for (int i = 0; i < mat[0].length; i++)
			for (int j = 0; j < mat.length; j++)
				transposeM[i][j] = mat[j][i];

		// a11 a21 a13
		// a12 a22 a23
		// a13 a23 a33
		// a14 a24 a34
		return new Matrix(transposeM);
	}

	/**
	 * Inplace addition of two matricies.
	 * 
	 * @param other
	 *            - the other matrix that adds upon our given matrix
	 */
	public void add(Matrix other)
	{
		if (mat.length != other.mat.length || mat[0].length != other.mat.length)
		{
			System.out.println("The matrix product cannot be"
					+ " computed due to mismatched matrix dimensions.");
			return;
		}
		for (int i = 0; i < mat.length; i++)
			for (int j = 0; j < mat[0].length; j++)
				mat[i][j] += other.mat[i][j];
	}
	
	/**
	 * Inplace scalar multiplication of a matrix.
	 * 
	 * @param c - scalar constant
	 */
	public void scalar(double c)
	{
		for ( int i = 0; i < mat.length; i++ )
			for ( int j = 0; j < mat[0].length; j++ )
				mat[i][j] *= c;
	}

	/**
	 * Multiplies this matrix with another matrix. A slow O(n^3) implementation.
	 * 
	 * @param other - the other matrix to multiply this matrix with.
	 * @return A new matrix object. Given an initial matrix A and a matrix B
	 *         passed through the parameter, a new matrix AB is returned.
	 */
	public Matrix multiply(Matrix other)
	{
		if (mat.length != other.mat[0].length)
		{
			throw new IllegalArgumentException("The matrix product cannot be"
					+ " computed due to mismatched matrix dimensions.");
		}

		int m = mat.length;
		int n = mat[0].length;
		int p = other.mat[0].length;

		double[][] AB = new double[m][p]; // m x n * n x p = m x p

		for (int i = 0; i < m; i++)
			for (int j = 0; j < p; j++)
				for (int k = 0; k < n; k++)
					AB[i][j] += mat[i][k] * other.mat[k][j];

		return new Matrix(AB);
	}

	public void print()
	{
		for (double[] row : mat)
			printRow(row);
	}

	private static void printRow(double[] row)
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
