package be.cegeka.battle;

public class Battle {

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
                    defendingArmy.removeDeadSOldier();
                } else {
                    attackingArmy.removeDeadSOldier();
                    return;
                }
            });
        });

        return (attackingArmy.armySize() >= defendingArmy.armySize()) ? attackingArmy : defendingArmy;
    }
}
