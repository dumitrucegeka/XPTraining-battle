package be.cegeka.battle.soldier;

import be.cegeka.battle.weapons.SpecializedWeapon;

/**
 * Created by dumitruc on 28.11.2018.
 */
public class HighlyTrainedSoldier implements Soldier {

    private final SpecializedWeapon weapon;

    private final boolean hasMagicPotion;

    public HighlyTrainedSoldier(SpecializedWeapon weapon, boolean hasMagicPotion) {
        this.weapon = weapon;
        this.hasMagicPotion = hasMagicPotion;
    }

    @Override
    public boolean attack(Soldier soldier) {
        int enemyDamage = soldier.attackPower(weapon.getDamage());
        int myDamage = attackPower(enemyDamage);
        return myDamage >= enemyDamage;
    }

    @Override
    public int attackPower(Integer ... params) {
        if(params.length == 0) {
            return weapon.getDamage();
        }
        Integer enemyAttackPower = params[0];
        boolean hasPotionEfect = hasMagicPotion && (enemyAttackPower +1)%2 == 1;
        return attackPower() + (hasPotionEfect ? 10 : 0);
    }

}
