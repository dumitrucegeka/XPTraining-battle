package be.cegeka.battle;

import be.cegeka.battle.soldier.NormalSoldier;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class ArmyTest {

    private Army army;

    @Before
    public void enrollSoldier() {
        NormalSoldier soldier = new NormalSoldier("Ion");
        army = new Army();
        army.enroll(soldier);

    }

    @Test
    public void givenSOldierAddToArmy() {
        assertThat(army.getSoldiers().size()).isEqualTo(1);
    }

    @Test
    public void givenDeadSoldierClearArmy() {
        NormalSoldier soldier = army.removeDeadSoldier();
        assertThat(army.getSoldiers().size()).isEqualTo(0);
        assertThat(soldier.getName()).isEqualTo("Ion");
    }
}
