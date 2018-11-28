package be.cegeka.battle.observer;

import be.cegeka.battle.Soldier;
import be.cegeka.battle.headquarters.IHeadQuarter;

import java.util.function.Consumer;
import java.util.function.Function;

public interface IObserver {

    void update(Consumer<IHeadQuarter> headQuarterConsumer);

}
