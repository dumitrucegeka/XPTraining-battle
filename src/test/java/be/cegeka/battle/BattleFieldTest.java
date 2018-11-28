package be.cegeka.battle;


import be.cegeka.battle.soldier.NormalSoldier;
import be.cegeka.battle.weapons.impl.Axe;
import be.cegeka.battle.weapons.impl.Spear;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BattleFieldTest {

    @Test
    public void givenTwoArmies_whenBattleStarts_thenCheckOpponents() {
        NormalSoldier soldier1 = new NormalSoldier("redSoldier1", new Axe());
        NormalSoldier soldier2 = new NormalSoldier("redSoldier2", new Spear());
        NormalSoldier soldier3 = new NormalSoldier("redSoldier3", new Axe());
        NormalSoldier soldier4 = new NormalSoldier("redSoldier4", new Spear());
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
