package be.cegeka.battle;

import be.cegeka.battle.weapons.impl.Axe;
import be.cegeka.battle.weapons.impl.BareFists;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SoldierTest {

    @Test
    public void construction_ASoldierMustHaveAName() {
        Soldier soldier = new Soldier("name");

        assertThat(soldier.getName()).isEqualTo("name");
    }

    @Test(expected = IllegalArgumentException.class)
    public void construction_ASoldierMustHaveAName_CannotBeNull() {
        new Soldier(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void construction_ASoldierMustHaveAName_CannotBeEmpty() {
        new Soldier("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void construction_ASoldierMustHaveAName_CannotBeBlank() {
        new Soldier("   ");
    }

    @Test
    public void givenTwoSoldier_whenAttackingEachOther_ThenCheckTheBiggerWeaponWins() {
        Soldier soldier1 = new Soldier("soldier1", new Axe());
        Soldier soldier2 = new Soldier("soldier2", new BareFists());

        assertThat(soldier1.attack(soldier2)).isTrue();
    }

}