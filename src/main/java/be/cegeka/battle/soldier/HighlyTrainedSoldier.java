package be.cegeka.battle.soldier;

import be.cegeka.battle.weapons.SpecializedWeapon;

/**
 * Created by dumitruc on 28.11.2018.
 */
public class HighlyTrainedSoldier implements Soldier {

    private SpecializedWeapon weapon;

    @Override
    public boolean attack(Soldier soldier) {
        return false;
    }
}
