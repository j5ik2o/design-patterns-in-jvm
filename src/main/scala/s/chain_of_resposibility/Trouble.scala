package s.chain_of_resposibility

final case class Trouble(number: Int) {
  // トラブルの文字列表現
  override def toString: String = "[Trouble " + number + "]"
}
