package Units;

import Actions.WolfAction;
import States.State;
import Actions.WerewolfAction;

public class Werewolf extends Unit {
    public Werewolf(String name, int hp, int damage) {
        super(name);
        this.state = new State("Werewolf", hp, damage);
        this.altState = new State("Wolf", 180, 50);
        this.action = new WerewolfAction();
        this.altAction = new WolfAction();
        this.unitType = "Turnskin";
    }

    public Werewolf(String name) {
        this(name, 90, 25);
    }
}
