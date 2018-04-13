package Mages;

import Exceptions.ArmyExceptions;
import MageActions.MageAction;
import Spells.FireBall;
import Spells.Heal;
import States.MageState;

public class Wizard extends Mage {
    public Wizard(String name, int hp, int mana, int damage) throws ArmyExceptions {
        super(name);
        this.state = new MageState("Wizard", hp, mana, damage);
        this.action = new MageAction();
        this.mageType = "BattleMage";
        this.getSpellbook().put("Heal", new Heal(this));
        this.getSpellbook().put("FireBall", new FireBall(this));
    }

    public Wizard(String name) throws ArmyExceptions {
        this(name, 60, 100, 10);
    }
}
