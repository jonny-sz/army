package Mages;

import Exceptions.ArmyExceptions;
import MageActions.WarlockAction;
import Spells.FireBall;
import Spells.Heal;
import States.MageState;
import Units.Daemon;

public class Warlock extends Mage {
    public Warlock(String name, int hp, int mana, int damage) throws ArmyExceptions {
        super(name);
        this.state = new MageState("Warlock", hp, mana, damage);
        this.action = new WarlockAction();
        this.mageType = "BattleMage";
        this.getSpellbook().put("Heal", new Heal(this));
        this.getSpellbook().put("FireBall", new FireBall(this));
    }

    public Warlock(String name) throws ArmyExceptions {
        this(name, 60, 100, 10);
    }

    public Daemon daemon() throws ArmyExceptions {
        this.ensureIsAlive();

        return this.action.daemon();
    }

    public void summon(String name) throws ArmyExceptions {
        this.ensureIsAlive();

        this.action.summon(this, name);
    }
}
