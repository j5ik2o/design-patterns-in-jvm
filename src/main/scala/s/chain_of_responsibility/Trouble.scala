package s.chain_of_responsibility

final case class Trouble(number: Int) {
  // トラブルの文字列表現
  override def toString: String = "[Trouble " + number + "]"
}
