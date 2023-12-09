package j.observer.inheritance;

import java.util.ArrayList;
import java.util.List;

public abstract class NumberGenerator {
  // 保持しているObserverたち
  private List<Observer> observers = new ArrayList<>();

  // Observerを追加する
  public void addObserver(Observer observer) {
    observers.add(observer);
  }

  // Observerを削除する
  public void deleteObserver(Observer observer) {
    observers.remove(observer);
  }

  // Observerへ通知する
  public void notifyObservers() {
    for (Observer o : observers) {
      o.update(this);
    }
  }

  // 数を取得する
  public abstract int getNumber();

  // 数を生成する
  public abstract void execute();
}
