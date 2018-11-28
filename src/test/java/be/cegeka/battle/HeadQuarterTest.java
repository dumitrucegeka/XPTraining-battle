package be.cegeka.battle;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class HeadQuarterTest {

    private HeadQuarterImplStub headQuarterImplStub;
    private Army army;
    private ByteArrayOutputStream out;
    private String soldierName;

    @Before
    public void setup() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        army = new Army();
        headQuarterImplStub = new HeadQuarterImplStub(Collections.singletonList(army));

        soldierName = "Mitica";
        Soldier soldier = new Soldier(soldierName);
        army.enroll(soldier);
    }

    @Test
    public void givenEnrolledSoldier_ThenPrintSoldierName() {
        assertThat(out.toString()).contains(String.format("Soldier enlisted: %s%n", soldierName));
    }

    @Test
    public void givenCasualtySoldier_ThenPrintSoldierId() {
        Soldier casualty = army.removeDeadSoldier();
        assertThat(out.toString()).contains(String.format("Soldier died: %d", casualty.getId()));
    }

    @Test
    public void givenHQVictory_ThenPrintNumberOfSoldiers() {
        int remainingNumberOfSoldiers = 5;
        headQuarterImplStub.reportVictory(remainingNumberOfSoldiers);
        assertThat(out.toString()).contains(String.format("Soldiers remained alive: %d", remainingNumberOfSoldiers));
    }
}
