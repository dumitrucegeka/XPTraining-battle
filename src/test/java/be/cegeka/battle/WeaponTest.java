package be.cegeka.battle;


import be.cegeka.battle.weapons.Weapon;
import be.cegeka.battle.weapons.impl.regular.Axe;
import be.cegeka.battle.weapons.impl.regular.BareFists;
import be.cegeka.battle.weapons.impl.regular.Spear;
import be.cegeka.battle.weapons.impl.regular.Sword;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WeaponTest {

    @Test
    public void givenSwordDamageIsCorrect() {
        Weapon weapon = new Sword();
        assertThat(weapon.getDamage()).isEqualTo(2);
    }
    @Test
    public void givenAxeDamageIsCorrect() {
        Weapon weapon = new Axe();
        assertThat(weapon.getDamage()).isEqualTo(3);
    }
    @Test
    public void givenSpearDamageIsCorrect() {
        Weapon weapon = new Spear();
        assertThat(weapon.getDamage()).isEqualTo(2);
    }
    @Test
    public void givenBareFistsDamageIsCorrect() {
        Weapon weapon = new BareFists();
        assertThat(weapon.getDamage()).isEqualTo(1);
    }
}
