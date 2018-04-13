package Units;

import Actions.DaemonAction;
import States.State;

public class Daemon extends Unit {
    public Daemon(String name, int hp, int damage) {
        super(name);
        this.state = new State("Daemon", hp, damage);
        this.action = new DaemonAction();
    }

    public Daemon(String name) {
        this(name, 80, 20);
    }
}
