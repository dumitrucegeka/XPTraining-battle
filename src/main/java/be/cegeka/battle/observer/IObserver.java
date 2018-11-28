package be.cegeka.battle.observer;

import be.cegeka.battle.headquarters.IHeadQuarter;

import java.util.function.Consumer;

public interface IObserver {

    void update(Consumer<IHeadQuarter> headQuarterConsumer);

}
