package devoxx.math.syntax

import scala.BigDecimal
import spire.math.Complex

final class DoubleSyntax(val value : Double) {
	/**
	 * Constuct a BigDecimal with the given scale from a double literal
	 * 
	 * for instance 2.5 scaled 2 => BigDecimal(2.50)
	 */
	def scaled(scale : Int) = BigDecimal(value).setScale(scale)
	/**
	 * Construct a Complex number with imaginary part equal to double value
	 * 
	 * This allows the syntax 1.0 + 1.0.i to construct a complex number
	 */
	def i = Complex(0.0, value)	
}

object DoubleSyntax {
  implicit def doubleToDoubleSyntax(value : Double) = new DoubleSyntax(value)
}


