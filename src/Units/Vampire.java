package Units;

import Actions.VampireAction;
import States.State;

public class Vampire extends Unit {
    public Vampire(String name, int hp, int damage) {
        super(name);
        this.state = new State("Vampire", hp, damage);
        this.action = new VampireAction();
        this.unitType = "Undead";
    }

    public Vampire(String name) {
        this(name, 120, 40);
    }
}
