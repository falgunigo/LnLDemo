package smooth.number;

public enum Smoothness {
  POWER2(2),
  SMOOTH3(3),
  HAMMING(5),
  HUMBLE(7),
  NONSMOOTH(11);

  public final Integer prime;

  private Smoothness(Integer prime){
    this.prime = prime;
  }

  public static  Smoothness tagOfValue(Integer primeValue){
    for (Smoothness sm : values()){
      if (sm.prime.equals(primeValue)){
        return sm;
      }
    }
    return NONSMOOTH;
  }
}
