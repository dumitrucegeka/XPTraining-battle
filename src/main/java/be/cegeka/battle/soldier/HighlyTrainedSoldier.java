package be.cegeka.battle.soldier;

import be.cegeka.battle.weapons.SpecializedWeapon;

/**
 * Created by dumitruc on 28.11.2018.
 */
public class HighlyTrainedSoldier implements Soldier {

    private SpecializedWeapon weapon;

    private boolean hasMagicPotion;


    @Override
    public boolean attack(Soldier soldier) {
        int enemyBaseDamage = soldier.attackPower();
        int myDamage = attackPower(enemyBaseDamage);
        return true;
    }

    @Override
    public int attackPower(Integer ... params) {
        Integer enemyAttackPower = params[0];
        boolean hasPotionEfect = hasMagicPotion && (enemyAttackPower +1)%2 == 1;
        return attackPower() + (hasPotionEfect ? 10 : 0);
    }

}
