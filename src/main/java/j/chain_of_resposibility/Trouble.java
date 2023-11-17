package j.chain_of_resposibility;

public class Trouble {
    private int number; // トラブル番号

    // トラブルの生成
    public Trouble(int number) {
        this.number = number;
    }

    // トラブル番号を得る
    public int getNumber() {
        return number;
    }

    // トラブルの文字列表現
    @Override
    public String toString() {
        return "[Trouble " + number + "]";
    }
}
