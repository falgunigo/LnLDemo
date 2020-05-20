package smooth.number;

import java.util.ArrayList;
import java.util.Collections;

public class SmoothNumber {

  private int numberInput;
  private ArrayList<Integer> primeFactors = new ArrayList<>();

  public SmoothNumber(int testForSmoothness) {
    this.numberInput = testForSmoothness;
  }


  public ArrayList<Integer> primeFactors() {
    numberInput = checkEvenReduceToOddRemainder(numberInput);
    numberInput = checkOddReturnNumber(numberInput);

    // This condition is to handle the case when
    // numberInput is a prime number greater than 2
    if (numberInput > 2) {
      primeFactors.add(numberInput);
    }

    return primeFactors;
  }

  int checkOddReturnNumber(int numberInput) {
    // numberInput must be odd at this point.  So we can
    // skip one element (Note i = i +2)
    for (int i = 3; i <= Math.sqrt(numberInput); i += 2) {
      // While i divides numberInput, print i and divide numberInput
      while (numberInput % i == 0) {
        primeFactors.add(i);
        numberInput /= i;
      }
    }
    return numberInput;
  }

  int checkEvenReduceToOddRemainder(int number) {
    // Print the number of 2s that divide n
    while (number % 2 == 0) {
      primeFactors.add(2);
      number /= 2;
    }
    return number;
  }


   int getLargestPrimeFactor() {
    return Collections.max(primeFactors);
  }


  public Smoothness howSmooth() {
    this.primeFactors();
    return Smoothness.tagOfValue(getLargestPrimeFactor());
  }
}
