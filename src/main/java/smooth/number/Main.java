package smooth.number;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    SmoothNumber smoothNumber = new SmoothNumber(35);
    List<Integer> result = smoothNumber.primeFactors();
    System.out.println(result);

    System.out.println(smoothNumber.howSmooth());
  }

}
