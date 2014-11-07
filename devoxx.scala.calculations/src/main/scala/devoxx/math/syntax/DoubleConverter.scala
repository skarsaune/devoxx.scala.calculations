package devoxx.math.syntax

import scala.BigDecimal
import spire.math.Complex

final class DoubleConverter(val value : Double) {
	def scaled(scale : Int) : BigDecimal = BigDecimal(value).setScale(scale)
	def i : Complex[Double] = Complex(0, value)	
}

object DoubleConverter {
  implicit def doubleToDoubleConverter(value : Double) : DoubleConverter = apply(value)
  def apply(value : Double) : DoubleConverter = new DoubleConverter(value)
}


