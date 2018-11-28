package be.cegeka.battle;

import be.cegeka.battle.observer.IObserver;

import java.util.ArrayList;
import java.util.List;

public class Battle implements ISubject {

    private List<IObserver> observerList = new ArrayList<>();

    private final Army attackingArmy;
    private final Army defendingArmy;

    public Battle(Army attackingArmy, Army defendingArmy) {
        this.attackingArmy = attackingArmy;
        this.defendingArmy = defendingArmy;
    }

    public Army startFight() {
        attackingArmy.getSoldiers().forEach(atck -> {
            defendingArmy.getSoldiers().forEach(def -> {
                boolean fightResult = atck.attack(def);
                if (fightResult) {
                    defendingArmy.removeDeadSoldier();
                } else {
                    attackingArmy.removeDeadSoldier();
                }
            });
        });

        Army winningArmy = (attackingArmy.armySize() >= defendingArmy.armySize()) ? attackingArmy : defendingArmy;
        notifyObserverOfWinningArmy(winningArmy);
        return winningArmy;
    }

    private void notifyObserverOfWinningArmy(Army army) {
        int remainingNumberOfSoldiers = army.armySize();
        observerList
                .forEach(observer -> {
                    observer.update(headQuarter -> headQuarter.reportVictory(remainingNumberOfSoldiers));
                });
    }

    @Override
    public void subscribe(IObserver observer) {
        observerList.add(observer);
    }
}
