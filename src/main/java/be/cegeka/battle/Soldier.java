package be.cegeka.battle;

import be.cegeka.battle.weapons.Weapon;
import be.cegeka.battle.weapons.impl.BareFists;
import org.apache.commons.lang3.Validate;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class Soldier {

    private final String name;
    private Weapon weapon;

    public Soldier(String name) {
        Validate.isTrue(isNotBlank(name));
        this.name =  name;
        this.weapon = new BareFists();
    }

    public Soldier(String name, Weapon weapon) {
        this.name = name;
        this.weapon = weapon;
    }

    public int attackPower() {
        return weapon.getDamage();
    }

    public boolean attack(Soldier soldier) {
        return attackPower() >= soldier.attackPower();
    }

    String getName() {
        return this.name;
    }
}
