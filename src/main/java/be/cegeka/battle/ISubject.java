package be.cegeka.battle;

import be.cegeka.battle.observer.IObserver;

public interface ISubject {

    void subscribe(IObserver observer);

}
