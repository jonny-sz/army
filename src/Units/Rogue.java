package Units;

import Actions.RogueAction;
import States.State;

public class Rogue extends Unit {
    public Rogue(String name, int hp, int damage) {
        super(name);
        this.state = new State("Rogue", hp, damage);
        this.action = new RogueAction();
    }

    public Rogue(String name) {
        this(name, 90, 25);
    }
}
