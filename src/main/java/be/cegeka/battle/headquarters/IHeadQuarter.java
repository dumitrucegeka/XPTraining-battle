package be.cegeka.battle.headquarters;

public interface IHeadQuarter {

    void reportEnlistment(String soldierName);

    void reportCasualty(int soldierId);

    void reportVictory(int remainingNumberOfSoldiers);

}
