public class Matrix
{
	private double[][] mat;

	public Matrix(double[][] newA)
	{
		mat = newA;
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
	 * @param other - the other matrix that adds upon our given matrix
	 */
	public void add(Matrix other)
	{
		if (mat.length != other.mat.length || mat[0].length != other.mat.length)
		{
			throw new IllegalArgumentException("The matrix sum cannot be"
					+ " computed due to mismatched matrix dimensions.");
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
	
	public double determinant()
	{
		if ( mat.length != mat[0].length ) //must be square
			throw new IllegalArgumentException("The matrix determinant cannot be"
					+ " computed for non-square matricies.");
		return determinant(mat, mat.length);
	}
	
	private double determinant(double b[][], int m)
	{
		double c[][] = new double[m][m];

		int i, j, k;
		double sum = 0;
		if (m == 1)
			sum = b[0][0]; 
		else if (m == 2)
			sum = ((b[0][0] * b[1][1]) - (b[0][1] * b[1][0])); 
		else
		{
			for (int p = 0; p < m; p++)
			{
				int h = 0;
				k = 0;
				for (i = 1; i < m; i++)
					for (j = 0; j < m; j++)
					{
						if (j == p)
							continue;
						c[h][k] = b[i][j];
						k++;
						if (k == m - 1)
						{
							h++;
							k = 0;
						}
					}
				sum = sum + b[0][p] * Math.pow((-1), p) * determinant(c, m - 1);
			}
		}
		return sum;
	}
	
	public void toRREF()
	{
		int lead = 0;
		int row = mat[0].length;
		int col = mat.length;
		
		for ( int r = 0; r < row; r++ )
		{
			if ( col <= lead )
				break;
			int i = r;
			while(mat[i][lead] == 0)
			{
				i++;
				if ( i == row )
				{
					i = r;
					lead++;
					if ( col == lead )
					{
						lead--;
						break;
					}
				}
				for ( int c = 0; c < col; c++ )
				{
					double temp = mat[r][c];
					mat[r][c] = mat[i][c];
					mat[i][c] = temp;
				}
				double div = mat[r][lead];
				if ( div != 0 )
					for ( int j = 0; j < col; j++ )
						mat[r][j] /= div;
				for ( int j = 0; j < row; j++ )
					if ( j != r )
					{
						double sub = mat[j][lead];
						for ( int k = 0; k < col; k++ )
							mat[j][k] -= (sub * mat[r][k]);
					}
				lead++;
			}
		}
	}
	
	public void getEigenvectors()
	{
		System.out.println("Enter eigenvalues of the matrix: ");
		String eiVals = TextIO.getln();
	}
	
	public void SingularValueDecomposition()
	{
		double[][] U, V;
		double[] S;
		
		int m = mat[0].length;
		int n = mat.length;
		
		S = new double[Math.min(m+1, n)];
		U = new double[m][n];
		V = new double[n][n];
		
		double[] e = new double[n];
		double[] work = new double[m];
		
		
		
		if ( m < n )
			throw new IllegalArgumentException("SVD cannot be calculated for m < n.");
		
		
	}
	
	
	/**
	 * Useful for creating document-document and term-term symmetrical n x n matricies.
	 * @return A*A^T
	 */
	public Matrix createSymmetric()
	{
		Matrix A_T = transpose();
		return multiply(A_T);
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
