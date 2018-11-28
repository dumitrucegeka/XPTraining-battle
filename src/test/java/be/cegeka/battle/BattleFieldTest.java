package be.cegeka.battle;


import be.cegeka.battle.weapons.impl.Axe;
import be.cegeka.battle.weapons.impl.Spear;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BattleFieldTest {

    @Test
    public void givenTwoArmies_whenBattleStarts_thenCheckOpponents() {
        Soldier soldier1 = new Soldier("redSoldier1", new Axe());
        Soldier soldier2 = new Soldier("redSoldier2", new Spear());
        Soldier soldier3 = new Soldier("redSoldier3", new Axe());
        Soldier soldier4 = new Soldier("redSoldier4", new Spear());
        Army redArmy = new Army();
        redArmy.enroll(soldier1);
        redArmy.enroll(soldier2);
        Army blueArmy = new Army();
        blueArmy.enroll(soldier3);
        blueArmy.enroll(soldier4);
        Battle battle = new Battle(redArmy, blueArmy);

        assertThat(battle.startFight()).isEqualTo(redArmy);
    }



}
