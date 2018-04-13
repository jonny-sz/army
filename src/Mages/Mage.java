package Mages;

import Exceptions.ArmyExceptions;
import Spells.Spell;
import Units.Unit;

import java.util.HashMap;

public abstract class Mage extends Unit {
    protected String mageType;

    public Mage(String name) {
        super(name);
    }

    public int getMana() throws ArmyExceptions {
        return this.state.getMana();
    }

    public int getMaxMana() throws ArmyExceptions {
        return this.state.getMaxMana();
    }

    public String getMageType() {
        return this.mageType;
    }

    public HashMap<String, Spell> getSpellbook() throws ArmyExceptions {
        return this.state.getSpellbook();
    }


    public void addMana(int mana) throws ArmyExceptions {
        this.state.addMana(mana);
    }

    public void spendMana(int mana) throws ArmyExceptions {
        this.state.spendMana(mana);
    }


    public void cast(String spellName, Unit target) throws ArmyExceptions, CloneNotSupportedException {

        this.action.cast(this, spellName, target);

    }

    public void addSpell(String spellTitle, Spell spell) throws ArmyExceptions {
        this.action.addSpell(this, spellTitle, spell);
    }
}
