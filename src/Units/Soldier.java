package Units;

import Actions.Action;
import States.State;

public class Soldier extends Unit {
    public Soldier(String name, int hp, int damage) {
        super(name);
        this.state = new State("Soldier", hp, damage);
        this.action = new Action();
    }

    public Soldier(String name) {
        this(name, 100, 30);
    }
}
