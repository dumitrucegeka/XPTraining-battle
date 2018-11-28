package be.cegeka.battle;


import be.cegeka.battle.weapons.impl.regular.Axe;
import be.cegeka.battle.weapons.impl.regular.Spear;
import org.junit.Before;
import be.cegeka.battle.soldier.NormalSoldier;
import be.cegeka.battle.weapons.impl.regular.Axe;
import be.cegeka.battle.weapons.impl.regular.Spear;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class BattleFieldTest {

    private ByteArrayOutputStream out;
    private Battle battle;
    private Army winningArmy;
    private HeadQuarterImplStub headQuarterImplStub;

    @Before
    public void setup() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        NormalSoldier soldier1 = new NormalSoldier("redSoldier1", new Axe());
        NormalSoldier soldier2 = new NormalSoldier("redSoldier2", new Spear());
        NormalSoldier soldier3 = new NormalSoldier("redSoldier3", new Axe());
        NormalSoldier soldier4 = new NormalSoldier("redSoldier4", new Spear());
        winningArmy = new Army();
        winningArmy.enroll(soldier1);
        winningArmy.enroll(soldier2);
        Army blueArmy = new Army();
        blueArmy.enroll(soldier3);
        blueArmy.enroll(soldier4);

        battle = new Battle(winningArmy, blueArmy);
        headQuarterImplStub = new HeadQuarterImplStub(Collections.singletonList(battle));
    }

    @Test
    public void givenTwoArmies_whenBattleStarts_thenCheckOpponents() {
        assertThat(battle.startFight()).isEqualTo(winningArmy);
    }

    @Test
    public void givenWinningArmy_thenPrintNumberOfRemainingSoldiers() {
        Army winningArmy = battle.startFight();
        int remainingSoldiers = winningArmy.armySize();
        assertThat(out.toString()).contains(String.format("Soldiers remained alive: %d", remainingSoldiers));
    }

}
