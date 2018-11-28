package be.cegeka.battle.soldier;

import be.cegeka.battle.weapons.Weapon;
import be.cegeka.battle.weapons.impl.regular.BareFists;
import org.apache.commons.lang3.Validate;

import java.util.concurrent.atomic.AtomicInteger;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class NormalSoldier {

    private static AtomicInteger idCounter = new AtomicInteger(1);
    private int id;
    private final String name;
    private Weapon weapon;

    public NormalSoldier(String name) {
        Validate.isTrue(isNotBlank(name));
        id = idCounter.getAndIncrement();
        this.name =  name;
        this.weapon = new BareFists();
    }

    public NormalSoldier(String name, Weapon weapon) {
        this.name = name;
        this.weapon = weapon;
    }

    public int attackPower() {
        return weapon.getDamage();
    }

    public boolean attack(NormalSoldier soldier) {
        return attackPower() >= soldier.attackPower();
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return id;
    }
}
