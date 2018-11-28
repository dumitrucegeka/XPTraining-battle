package be.cegeka.battle.soldier;

import be.cegeka.battle.soldier.NormalSoldier;
import be.cegeka.battle.weapons.impl.regular.Axe;
import be.cegeka.battle.weapons.impl.regular.BareFists;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NormalSoldierTest {

    @Test
    public void construction_ASoldierMustHaveAName() {
        NormalSoldier soldier = new NormalSoldier("name");

        assertThat(soldier.getName()).isEqualTo("name");
    }

    @Test(expected = IllegalArgumentException.class)
    public void construction_ASoldierMustHaveAName_CannotBeNull() {
        new NormalSoldier(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void construction_ASoldierMustHaveAName_CannotBeEmpty() {
        new NormalSoldier("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void construction_ASoldierMustHaveAName_CannotBeBlank() {
        new NormalSoldier("   ");
    }

    @Test
    public void givenTwoSoldier_whenAttackingEachOther_ThenCheckTheBiggerWeaponWins() {
        NormalSoldier soldier1 = new NormalSoldier("soldier1", new Axe());
        NormalSoldier soldier2 = new NormalSoldier("soldier2", new BareFists());

        assertThat(soldier1.attack(soldier2)).isTrue();
    }

    @Test
    public void givenSoldier_whenNoSpecificWeapon_ThenCheckIfHasBareFists() {
        NormalSoldier soldier = new NormalSoldier("soldier");

        assertThat(soldier.attackPower()).isEqualTo(new BareFists().getDamage());
    }

}