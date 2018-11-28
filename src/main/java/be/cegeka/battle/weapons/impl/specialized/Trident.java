package be.cegeka.battle.weapons.impl.specialized;

import be.cegeka.battle.weapons.SpecializedWeapon;
import be.cegeka.battle.weapons.impl.regular.Spear;

public class Trident implements SpecializedWeapon {
    private Spear spear;

    public Trident(){
        this.spear = new Spear();
    }

    @Override
    public int getDamage() {
        return this.spear.getDamage() * 3;
    }
}
