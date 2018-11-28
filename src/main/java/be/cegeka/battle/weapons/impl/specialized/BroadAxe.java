package be.cegeka.battle.weapons.impl.specialized;

import be.cegeka.battle.weapons.SpecializedWeapon;
import be.cegeka.battle.weapons.impl.regular.Axe;

public class BroadAxe implements SpecializedWeapon {

    private Axe axe;

    public BroadAxe() {
        this.axe = new Axe();
    }

    @Override
    public int getDamage() {
        return this.axe.getDamage() + 2;
    }
}
