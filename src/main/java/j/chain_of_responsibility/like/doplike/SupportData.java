package j.chain_of_responsibility.like.doplike;

public sealed interface SupportData
    permits SupportData.NoSupportData,
        SupportData.OddSupportData,
        SupportData.LimitSupportData,
        SupportData.SpecialSupportData {
  String name();

  SupportData next();

  record NoSupportData(String name, SupportData next) implements SupportData {}

  record OddSupportData(String name, SupportData next) implements SupportData {}

  record LimitSupportData(String name, int limit, SupportData next) implements SupportData {}

  record SpecialSupportData(String name, int number, SupportData next) implements SupportData {}
}
