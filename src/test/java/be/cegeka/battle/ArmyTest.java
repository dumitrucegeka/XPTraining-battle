package be.cegeka.battle;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class ArmyTest {

    private Army army;

    @Before
    public void enrollSoldier() {
        Soldier soldier = new Soldier("Ion");
        army = new Army();
        army.enroll(soldier);

    }

    @Test
    public void givenSOldierAddToArmy() {
        assertThat(army.getSoldiers().size()).isEqualTo(1);
    }

    @Test
    public void givenDeadSoldierClearArmy() {
        Soldier soldier = army.removeDeadSoldier();
        assertThat(army.getSoldiers().size()).isEqualTo(0);
        assertThat(soldier.getName()).isEqualTo("Ion");
    }
}
