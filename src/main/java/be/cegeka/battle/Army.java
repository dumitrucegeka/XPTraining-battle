package be.cegeka.battle;

import be.cegeka.battle.observer.IObserver;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Army implements ISubject{

    private List<IObserver> observers = new ArrayList<>();
    private Queue<Soldier> soldiers;

    public Army() {
        soldiers = new ArrayDeque<>();
    }

    public boolean enroll(Soldier soldier) {
        notifyObserversOfEnrolledSoldier(soldier);
        return this.soldiers.add(soldier);
    }

    public Queue<Soldier> getSoldiers(){
        return this.soldiers;
    }

    public Soldier removeDeadSoldier() {
        Soldier deadSoldier = this.soldiers.remove();
        notifyObserversOfCasualty(deadSoldier);
        return deadSoldier;
    }

    private void notifyObserversOfEnrolledSoldier(Soldier soldier) {
        observers.forEach(observer -> observer.update(headQuarter -> headQuarter.reportEnlistment(soldier.getName())));
    }

    private void notifyObserversOfCasualty(Soldier soldier) {
        observers.forEach(observer -> observer.update(headQuarter -> headQuarter.reportCasualty(soldier.getId())));
    }

    @Override
    public void subscribe(IObserver observer) {
        observers.add(observer);
    }
}
