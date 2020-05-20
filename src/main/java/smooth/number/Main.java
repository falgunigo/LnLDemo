package smooth.number;

import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Map;

public class Main {

  public static void main(String[] args) {
    SmoothNumber smoothNumber = new SmoothNumber(35);
    List<Integer> result = smoothNumber.primeFactors();
    System.out.println(result);

    System.out.println(smoothNumber.howSmooth());

    readBuildGeneratedJson();
  }

  private static void readBuildGeneratedJson() {
    Gson gson = new Gson();
    try {
      Map<String, String> result = gson.fromJson(new FileReader("wordCount.json"), Map.class);
      System.out.println("~~~~~~~~~~~~~~~~~~ Got result from JSON ~~~~~~~~~~~~~~~~~~" + result.entrySet());
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

}
