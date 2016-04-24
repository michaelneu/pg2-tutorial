package com.mathlabs;

/**
 * The class Matrix represents a two-dimensional double matrix, providing basic arithmetic functions. 
 * 
 * @author michaelneu
 */
public class Matrix {
	double[][] values;
	private int m, n;
	
	/**
	 * Creates a new matrix with m rows and n columns. 
	 * 
	 * @param m Rows
	 * @param n Columns
	 */
	public Matrix(int m, int n) {
		this.m = m;
		this.n = n;
		
		this.values = new double[m][n];
	}
	
	/**
	 * Returns the number of rows. 
	 * 
	 * @return
	 */
	public int getM() {
		return this.m;
	}
	
	/**
	 * Returns the number of columns. 
	 * 
	 * @return
	 */
	public int getN() {
		return this.n;
	}
	
	/**
	 * Gets the value of the matrix at (x; y). 
	 * 
	 * @param x Column
	 * @param y Row
	 * @return
	 */
	public double getValue(int x, int y) {
		return this.values[y][x];
	}
	
	/**
	 * Sets the value of the matrix at (x; y). 
	 * 
	 * @param x Column
	 * @param y Row
	 * @param value
	 */
	public void setValue(int x, int y, double value) {
		this.values[y][x] = value;
	}
	
	/**
	 * Transposes the matrix. 
	 * 
	 * @return A new matrix containing the transposed values. 
	 */
	public Matrix transpose() {
		Matrix transposed = new Matrix(this.n, this.m);
		
		for (int i = 0; i < this.n; i++) {
			for (int j = 0; j < this.m; j++) {
				transposed.values[i][j] = this.values[j][i];
			}
		}
		
		return transposed;
	}
	
	/**
	 * Adds another matrix to this matrix. 
	 * 
	 * @param matrix
	 * @return A new matrix containing the sum of both matrices. 
	 */
	public Matrix add(Matrix matrix) {
		if (this.m == matrix.getM() && this.n == matrix.getN()) {
			Matrix result = new Matrix(this.m, this.n);
			
			for (int i = 0; i < this.m; i++) {
				for (int j = 0; j < this.n; j++) {
					result.values[i][j] = this.values[i][j] + matrix.values[i][j];
				}
			}
			
			return result;
		} else {
			return null;
		}
	}
	
	/**
	 * Subtracts another matrix from this matrix. 
	 * 
	 * @param matrix
	 * @return A new matrix containing the difference between both matrices. 
	 */
	public Matrix subtract(Matrix matrix) {
		return matrix.multiply(-1)
					 .add(this);
	}
	
	/**
	 * Multiplies the matrix with a double number. 
	 * 
	 * @param value
	 * @return A new matrix containing the scaled matrix. 
	 */
	public Matrix multiply(double value) {
		Matrix matrix = new Matrix(this.m, this.n);
		
		for (int i = 0; i < this.m; i++) {
			for (int j = 0; j < this.n; j++) {
				matrix.values[i][j] = this.values[i][j] * value;
			}
		}
		
		return matrix;
	}
	
	/**
	 * Multiplies the matrix with another matrix. If there's a dimension mismatch, null will be returned. 
	 * 
	 * @param matrix
	 * @return A new matrix containing the product of both matrices. 
	 */
	public Matrix multiply(Matrix matrix) {
		if (this.n != matrix.getM()) {
			return null;
		} else {
			Matrix result = new Matrix(this.m, matrix.getN());
			
			for (int i = 0; i < result.getM(); i++) {
				for (int j = 0; j < result.getN(); j++) {
					for (int k = 0; k < this.getN(); k++) {
						result.values[i][j] += this.values[i][k] * matrix.values[k][j];
					}
				}
			}
			
			return result;
		}
	}
	
	@Override
	public String toString() {
		String output = "";
		
		for (int i = 0; i < this.m; i++) {
			for (int j = 0; j < this.n; j++) {
				output += String.format("%f\t", this.values[i][j]);
			}
			
			output += "\n";
		}
		
		return output;
	}
}
