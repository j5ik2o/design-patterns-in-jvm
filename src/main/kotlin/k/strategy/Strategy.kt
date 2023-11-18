/* (C)2022 */
package k.strategy

interface Strategy {
  fun nextHand(): Pair<Strategy, Hand>

  fun study(win: Boolean): Strategy
}
