package be.cegeka.battle.weapons.impl;

import be.cegeka.battle.weapons.Weapon;

public class Sword implements Weapon {
    @Override
    public int getDamage() {
        return 2;
    }
}
