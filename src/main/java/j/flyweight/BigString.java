/* (C)2022 */
package j.flyweight;

public class BigString {
    private BigChar[] bigchars;

    public BigString(String string) {
        BigCharFactory factory = BigCharFactory.getInstance();
        bigchars = new BigChar[string.length()];
        for (int i = 0; i < bigchars.length; i++) {
            bigchars[i] = factory.getBigChar(string.charAt(i));
        }
    }

    public void print() {
        for (BigChar bc : bigchars) {
            bc.print();
        }
    }
}
