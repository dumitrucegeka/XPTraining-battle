package be.cegeka.battle;

import be.cegeka.battle.observer.IObserver;
import be.cegeka.battle.soldier.NormalSoldier;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Army implements ISubject{

    private List<IObserver> observers = new ArrayList<>();
    private Queue<NormalSoldier> soldiers;

    public Army() {
        soldiers = new ArrayDeque<>();
    }

    public boolean enroll(NormalSoldier soldier) {
        notifyObserversOfEnrolledSoldier(soldier);
        return this.soldiers.add(soldier);
    }

    public Queue<NormalSoldier> getSoldiers(){
        return this.soldiers;
    }

    public NormalSoldier removeDeadSoldier() {
        NormalSoldier deadSoldier = this.soldiers.remove();
        notifyObserversOfCasualty(deadSoldier);
        return deadSoldier;
    }

    private void notifyObserversOfEnrolledSoldier(NormalSoldier soldier) {
        observers.forEach(observer -> observer.update(headQuarter -> headQuarter.reportEnlistment(soldier.getName())));
    }

    private void notifyObserversOfCasualty(NormalSoldier soldier) {
        observers.forEach(observer -> observer.update(headQuarter -> headQuarter.reportCasualty(soldier.getId())));
    }

    @Override
    public void subscribe(IObserver observer) {
        observers.add(observer);
    }

    public int armySize() {
        return soldiers.size();
    }
}
