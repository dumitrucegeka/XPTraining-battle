package be.cegeka.battle;

import be.cegeka.battle.headquarters.IHeadQuarter;
import be.cegeka.battle.observer.IObserver;

import java.util.function.Consumer;

public class HeadQuarterImplStub implements IHeadQuarter, IObserver {

    public HeadQuarterImplStub(ISubject subject) {
        subject.subscribe(this);
    }

    @Override
    public void reportEnlistment(String soldierName) {
        System.out.println(String.format("NormalSoldier enlisted: %s", soldierName));
    }

    @Override
    public void reportCasualty(int soldierId) {
        System.out.println(String.format("NormalSoldier died: %d", soldierId));
    }

    @Override
    public void reportVictory(int remainingNumberOfSoldiers) {
        System.out.println(String.format("NormalSoldier remained alive: %d", remainingNumberOfSoldiers));
    }

    @Override
    public void update(Consumer<IHeadQuarter> headQuarterConsumer) {
        headQuarterConsumer.accept(this);
    }

}
