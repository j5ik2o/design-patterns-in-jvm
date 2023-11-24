package j.observer.inheritance;

import java.util.Random;

public class RandomNumberGenerator extends NumberGenerator {
    private Random random = new Random(); // 乱数生成器
    private int number;                   // 現在の数

    // 数を取得する
    @Override
    public int getNumber() {
        return number;
    }

    // 数を生成する
    @Override
    public void execute() {
        for (int i = 0; i < 20; i++) {
            number = random.nextInt(50);
            notifyObservers();
        }
    }
}
