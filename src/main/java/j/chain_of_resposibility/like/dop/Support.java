package j.chain_of_resposibility.like.dop;

public sealed interface Support
    permits Supports.NoSupport,
        Supports.OddSupport,
        Supports.LimitSupport,
        Supports.SpecialSupport {
  String name();

  Support next();
}
