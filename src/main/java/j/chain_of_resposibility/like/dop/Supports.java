package j.chain_of_resposibility.like.dop;

public class Supports {

  public record NoSupport(String name, Support next) implements Support {}

  public record OddSupport(String name, Support next) implements Support {}

  public record LimitSupport(String name, int limit, Support next) implements Support {}

  public record SpecialSupport(String name, int number, Support next) implements Support {}
}
