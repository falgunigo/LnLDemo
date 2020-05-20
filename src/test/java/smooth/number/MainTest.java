package smooth.number;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MainTest {

  private SmoothNumber smoothNumber;

  private static Stream<Arguments> supplyNumbersAndResult() {
    return Stream.of(Arguments.of(12, new ArrayList<Integer>(Arrays.asList(2, 2, 3))),
        Arguments.of(17, new ArrayList<Integer>(Arrays.asList(17))),
        Arguments.of(32, new ArrayList<Integer>(Arrays.asList(2, 2, 2, 2, 2))),
        Arguments.of(35, new ArrayList<Integer>(Arrays.asList(5, 7))),
        Arguments.of(57, new ArrayList<Integer>(Arrays.asList(3, 19))),
        Arguments.of(49, new ArrayList<Integer>(Arrays.asList(7, 7))),
        Arguments.of(66, new ArrayList<Integer>(Arrays.asList(2, 3, 11))));
  }

  private static Stream<Arguments> supplyNumbersAndSmoothness() {
    return Stream.of(Arguments.of(12, Smoothness.SMOOTH3),
        Arguments.of(17, Smoothness.NONSMOOTH),
        Arguments.of(32, Smoothness.POWER2),
        Arguments.of(35, Smoothness.HUMBLE),
        Arguments.of(57, Smoothness.NONSMOOTH),
        Arguments.of(49, Smoothness.HUMBLE),
        Arguments.of(66, Smoothness.NONSMOOTH));
  }

  @ParameterizedTest(name = "{0}")
  @MethodSource("supplyNumbersAndResult")
  void smoothNumber_returnsCorrectResult(int number, List<Integer> expectedPrimeNumbers) {
    smoothNumber = new SmoothNumber(number);
    assertThat(expectedPrimeNumbers).isEqualTo(smoothNumber.primeFactors());
  }


  @ParameterizedTest(name = "{0} {1}")
  @MethodSource("supplyNumbersAndSmoothness")
  void smoothNumber_returnsCorrectSmoothness(int number, Smoothness expectedSmoothness) {
    smoothNumber = new SmoothNumber(number);
    assertThat(expectedSmoothness).isEqualTo(smoothNumber.howSmooth());
  }

}