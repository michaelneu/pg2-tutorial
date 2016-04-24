package com.mathlabs;

/**
 * The class Fraction represents a numerical fraction, containing a numerator and denominator, to support basic arithmetic functions. 
 * 
 * @author michaelneu
 */
public class Fraction {
	private int numerator, denominator;
	
	/**
	 * Creates a new fraction with a given numerator and denominator. 
	 * 
	 * @param num
	 * @param denom
	 */
	public Fraction(int num, int denom) {
		this.numerator = num;
		this.denominator = denom;
	}
	
	/**
	 * Tries to create a new fraction from a double number. 
	 * 
	 * @param value
	 */
	public Fraction(double value) {
		for (int i = 0; i < 9; i++) {
			int distance = (int)MathLabs.pow(10, i);
			double movedComma = value * distance;
			
			if ((int)movedComma == movedComma) {
				this.numerator = (int)movedComma;
				this.denominator = distance;
				
				this.reduce();

				break;
			}
		}
	}
	
	public int getNumerator() {
		return this.numerator;
	}
	
	public int getDenominator() {
		return this.denominator;
	}
	
	/**
	 * Reduces the fraction to the minimal representation of numerator and denominator. 
	 */
	public void reduce() {
		int gcd = MathLabs.gcd(this.numerator, this.denominator);
		
		this.numerator /= gcd;
		this.denominator /= gcd;
	}
	
	/**
	 * Calculates the inverse of the fraction. 
	 * 
	 * @return A new fraction containing the inverse of the original fraction. 
	 */
	public Fraction invert() {
		return new Fraction(this.denominator, this.numerator);
	}
	
	/**
	 * Adds a fraction to this fraction. 
	 * 
	 * @param fract
	 * @return A new fraction containing the sum of both fractions. 
	 */
	public Fraction add(Fraction fract) {
		int num = this.numerator * fract.getDenominator() + this.denominator * fract.getNumerator(),
			denom = this.denominator * fract.getDenominator();
		
		Fraction result = new Fraction(num, denom);
		result.reduce();
		
		return result;
	}
	
	/**
	 * Subtracts a fraction from this fraction. 
	 * 
	 * @param fract
	 * @return A new fraction containing the difference between both fractions.
	 */
	public Fraction subtract(Fraction fract) {
		return fract.multiply(-1)
					.add(this);
	}

	/**
	 * Multiplies a fraction with this fraction. 
	 * 
	 * @param fract
	 * @return A new fraction containing the product of both fractions. 
	 */
	public Fraction multiply(Fraction fract) {
		int num = this.numerator * fract.getNumerator(),
			denom = this.denominator * fract.getDenominator();
		
		return new Fraction(num, denom);
	}
	
	/**
	 * Multiplies the fraction with a double number. 
	 * 
	 * @param number
	 * @return A new fraction multiplied by the given number. 
	 */
	private Fraction multiply(double number) {
		int num = (int)(this.numerator * number);
		
		return new Fraction(num, this.denominator);
	}
	
	/**
	 * Divide this fraction by another fraction.  
	 * 
	 * @param fract
	 * @return A new fraction containing the quotient between both fractions. 
	 */
	public Fraction divide(Fraction fract) {
		return fract.invert()
					.multiply(this);
	}
	
	/**
	 * Convert the fraction to a double representation. 
	 * 
	 * @return
	 */
	public double toDouble() {
		return this.numerator / (double)this.denominator;
	}
	
	@Override
	public String toString() {
		return this.numerator + "/" + this.denominator;
	}
}
