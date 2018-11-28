package be.cegeka.battle.soldier;

/**
 * Created by dumitruc on 28.11.2018.
 */
public class HighlyTrainedSoldier implements Soldier {

    private HighlySpecializedWeapon weapon;

    @Override
    public boolean attack(Soldier soldier) {
        return false;
    }
}
