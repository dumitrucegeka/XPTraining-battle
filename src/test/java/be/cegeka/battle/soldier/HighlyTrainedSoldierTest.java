package be.cegeka.battle.soldier;

import be.cegeka.battle.weapons.impl.specialized.BroadAxe;
import be.cegeka.battle.weapons.impl.specialized.Trident;
import be.cegeka.battle.weapons.impl.specialized.TwoHandedSword;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by dumitruc on 28.11.2018.
 */
public class HighlyTrainedSoldierTest {

    @Test
    public void givenAttackerWithPotionAndEnemyWithNoPation_whenAttacking_thenCheckPotionEffect() {
        Soldier soldier1 = new HighlyTrainedSoldier(new TwoHandedSword(), true);
        Soldier soldier2 = new HighlyTrainedSoldier(new Trident(), false);

        assertThat(soldier1.attack(soldier2)).isTrue();
    }

    @Test
    public void givenAttackerWithNoPotionAndEnemyWithPation_whenAttacking_thenCheckPotionEffect() {
        Soldier soldier1 = new HighlyTrainedSoldier(new TwoHandedSword(), false);
        Soldier soldier2 = new HighlyTrainedSoldier(new BroadAxe(), true);

        assertThat(soldier1.attack(soldier2)).isTrue();
    }

    @Test
    public void givenBothSoldierWithPotions_whenAttacking_thenCheckPotionEffect() {
        Soldier soldier1 = new HighlyTrainedSoldier(new TwoHandedSword(), true);
        Soldier soldier2 = new HighlyTrainedSoldier(new Trident(), true);

        assertThat(soldier1.attack(soldier2)).isTrue();
    }

    @Test
    public void givenBothSoldierWithNoPotions_whenAttacking_thenCheckNoPotionEffect() {
        Soldier soldier1 = new HighlyTrainedSoldier(new TwoHandedSword(), false);
        Soldier soldier2 = new HighlyTrainedSoldier(new Trident(), false);

        assertThat(soldier1.attack(soldier2)).isFalse();
    }
}
