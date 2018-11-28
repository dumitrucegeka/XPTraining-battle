package be.cegeka.battle.weapons.impl.specialized;

import be.cegeka.battle.weapons.Weapon;
import be.cegeka.battle.weapons.impl.regular.Axe;

public class BroadAxe implements Weapon {

    private Axe axe;

    public BroadAxe(){
        this.axe = new Axe();
    }

    @Override
    public int getDamage() {

        return this.axe
                .getDamage() + 2;
    }
}
