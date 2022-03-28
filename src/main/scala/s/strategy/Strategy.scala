/* (C) 2022 */
package s.strategy

trait Strategy {
  def nextHand: (Strategy, Hand)
  def study(win: Boolean): Strategy
}
