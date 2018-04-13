package Units;

import States.State;
import Actions.BerserkerAction;

public class Berserker extends  Unit {
    public Berserker(String name, int hp, int damage) {
        super(name);
        this.state = new State("Berserker", hp, damage);
        this.action = new BerserkerAction();
    }

    public Berserker(String name) {
        this(name, 90, 25);
    }
}
