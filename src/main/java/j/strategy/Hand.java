package j.strategy;

public enum Hand {
  ROCK("グー", 0),
  SCISSORS("チョキ", 1),
  PAPER("パー", 2);

  private String name;
  private int handvalue;

  private static Hand[] hands = {ROCK, SCISSORS, PAPER};

  private Hand(String name, int handvalue) {
    this.name = name;
    this.handvalue = handvalue;
  }

  public static Hand getHand(int handvalue) {
    return hands[handvalue];
  }

  public boolean isStrongerThan(Hand h) {
    return fight(h) == 1;
  }

  public boolean isWeakerThan(Hand h) {
    return fight(h) == -1;
  }

  private int fight(Hand h) {
    if (this == h) {
      return 0;
    } else if ((this.handvalue + 1) % 3 == h.handvalue) {
      return 1;
    } else {
      return -1;
    }
  }

  @Override
  public String toString() {
    return name;
  }
}
