/* (C)2022 */
package j.flyweight;

public class BigString {
    private BigChar[] bigChars;

    public BigString(String string) {
        BigCharFactory factory = BigCharFactory.getInstance();
        bigChars = new BigChar[string.length()];
        for (int i = 0; i < bigChars.length; i++) {
            bigChars[i] = factory.getBigChar(string.charAt(i));
        }
    }

    public void print() {
        for (BigChar bc : bigChars) {
            bc.print();
        }
    }
}
