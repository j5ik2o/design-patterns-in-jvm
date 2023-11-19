package j.chain_of_resposibility.like.functions;

public final class NoSupport {

  public static Support create(String name) {
    return ControlBreak::of;
  }
}
