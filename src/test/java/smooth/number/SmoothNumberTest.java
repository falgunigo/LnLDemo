package smooth.number;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SmoothNumberTest {

  SmoothNumber smoothNumberCheck;


  @Test
  void givenOdd_checkForAllOdd() {
    //Arrange
    Integer number = 57;
    smoothNumberCheck = new SmoothNumber(number);
    //Act
    int result = smoothNumberCheck.checkOddReturnNumber(number);

    //Assert
    assertThat(result).isEqualTo(19);
  }

  @Test
  void givenOdd_checkIfNumberIsNotEven_returnNumber() {
    //Arrange
    Integer number = 15;
    smoothNumberCheck = new SmoothNumber(number);
    //Act
    int result = smoothNumberCheck.checkEvenReduceToOddRemainder(number);

    //Assert
    assertThat(result).isEqualTo(number);
  }

  @Test
  void givenEven_numberIsEven_thenReturnRemaining() {
    //Given
    Integer number = 16;
    smoothNumberCheck = new SmoothNumber(number);
    //Act
    int result = smoothNumberCheck.checkEvenReduceToOddRemainder(number);

    //Assert
    assertThat(result).isEqualTo(1);

  }

  @Test
  void givenListOfPrimeFactors_returnLargestPrimeFactor() {
    //Given
    Integer number = 35;
    smoothNumberCheck = new SmoothNumber(number);
    //Act
    smoothNumberCheck.primeFactors();
    int result = smoothNumberCheck.getLargestPrimeFactor();

    //Assert
    assertThat(result).isEqualTo(7);
  }

  @Test
  void givenNumber_testSmoothness_returnsIsSmooth() {
    //Given
    Integer number = 35;
    smoothNumberCheck = new SmoothNumber(number);
    //Act
    Smoothness result = smoothNumberCheck.howSmooth();

    //Assert
    assertThat(result).isEqualTo(Smoothness.HUMBLE);
  }
}