package com.mathlabs;

/**
 * Provides mathematical methods powering the MathLabs software collection. 
 * 
 * @author michaelneu
 */
public final class MathLabs {
	/**
	 * Returns the absolute value of a double number. 
	 * 
	 * @param number
	 * @return
	 */
	public static double abs(double number) {
		if (number < 0) {
			return -number;
		} else {
			return number;
		}
	}
	
	/**
	 * Returns the square root of a non negative double number. In case of a negative number, 0 will be returned. 
	 * 
	 * @param number
	 * @return
	 */
	public static double sqrt(double number) {
		final double precision = 0.00000000001;
		
		if (number <= 0) {
			throw new NegativeRadicandError(number);
		} else {
			double x_n = number;
			
			do {
				x_n = (x_n + (number / x_n)) / 2;
			} while (abs(x_n * x_n - number) > precision);
			
			return x_n;
		}
	}
	
	/**
	 * Returns the n-th power of a given double number. 
	 * 
	 * @param number
	 * @param n
	 * @return
	 */
	public static double pow(double number, int n) {
		double result = 1;
		
		if (n > 0) {
			for (int i = 0; i < n; i++) {
				result *= number;
			}
		} else {
			n = (int)abs(n);
			
			for (int i = 0; i < n; i++) {
				result /= number;
			}
		}
		
		return result;
	}
	
	/**
	 * Returns the factorial of a double number. 
	 * 
	 * @param number
	 * @return
	 */
	public static long factorial(long number) {
		if (number < 2) {
			return 1;
		} else {
			return factorial(number - 1) * number;
		}
	}
	
	/**
	 * Returns the greatest common divisor of both a and b. 
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return gcd(b, a % b);
		}
	}

    /**
     * Returns the arithmetic middle of all given values.
     *
     * @param values
     * @return
     */
    public static double arithmeticMiddle(double... values) {
        double sum = 0;

        for (double value : values) {
            sum += value;
        }

        return sum / values.length;
    }
}
