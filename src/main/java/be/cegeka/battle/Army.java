package be.cegeka.battle;

import java.util.ArrayDeque;
import java.util.Queue;

public class Army {

    private Queue<Soldier> soldiers;

    public Army() {
        soldiers = new ArrayDeque<>();
    }

    public boolean enroll(Soldier soldier) {
        return this.soldiers.add(soldier);
    }

    public Queue<Soldier> getSoldiers(){
        return this.soldiers;
    }

    public Soldier removeDeadSOldier() {
        return this.soldiers.remove();
    }
}
