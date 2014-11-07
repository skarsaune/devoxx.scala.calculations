package devoxx

import org.junit.Test
import org.scalatest.junit.JUnitSuite
import spire.implicits._
import spire.math._
import scala.math.ScalaNumber
import org.junit.Assert._
import devoxx.math.syntax.DoubleSyntax.doubleToDoubleSyntax
import devoxx.math.syntax.DoubleSyntax
import org.scalatest.junit.MustMatchersForJUnit

class DevoxxComputationsTest extends JUnitSuite with MustMatchersForJUnit  {

  /**
   * Verify that Spire Real maintains highest possbile accuracy
   */
  @Test def testReal {

    val numerator: Real = 2 //Real$Exact(2)
    val fraction = numerator / 3 //Real$Exact(2/3)
    val restored = fraction * 3
    val inexact = fraction * Real.pi

    printNumber("2 / 3", fraction)
    assertFalse("2 / 3 is not whole", fraction.isWhole)
    printNumber("(2 / 3) * 3", restored)
    assertTrue("(2 / 3) * 3 is whole", restored.isWhole)
    printNumber(" (2 / 3) * pi", inexact)
    assertFalse(" (2 / 3) * pi" , inexact.isWhole)
    
  }

  def printNumber(title: String, num: ScalaNumber) {
    print(title + " : " + num.getClass() + ":" + num)
    if(num.underlying() != num) {
    	print(" ( " + num.underlying().getClass() + " : " + num.underlying() + ")")
    }   
    println()
  }

  /**
   * Verify that Spire SafeLong does not overflow, and narrows back to smaller number type when possible
   */
  @Test def testOverflow {
    val trillion: SafeLong = 1000000000000l //SafeLongLong
    val product = trillion * trillion //SafeLongBigInt
    product / trillion //SafeLongLong

    assertTrue("Trillion is implemented as long", trillion.isLong)
    assertFalse("Trillion is not implemented as BigInt", trillion.isBigInt)
    printNumber("Trillion", trillion)

    assertFalse("Product is not implemented as long", product.isLong)
    assertTrue("Trillion is implemented as BigInt", product.isBigInt)
    printNumber("Product", product)
  }

  /**
   * Test Scala built in decimal conversions, and our custom decimal syntax
   */
  @Test def testDecimal {
    val dec1 : BigDecimal = 2.50
    val dec = 2.5 scaled 2 //BigDecimal
    printNumber("2.5 scaled 2", dec)
    assertEquals("Scale is 2", 2, dec.scale)
    assertEquals("Decimal equals", BigDecimal("2.50"), dec)
   }

  /**
   * Test our custom syntax for complex numbers
   */
  @Test def testComplex {

    val complex =  -1.0 + 1.0.i //Complex(1.0, 1.0)
    printNumber("1.0.i - 1.0", complex)
    assertEquals("Imaginary part", complex.imag , 1.0, 0.0)
    assertEquals("Imaginary part", complex.real , -1.0, 0.0)
  }

}