package States;

import Exceptions.ArmyExceptions;
import Exceptions.UnitIsNotMageException;
import Spells.Spell;

import java.util.HashMap;

public class State {
    protected String title;
    protected int hp;
    protected int maxHp;
    protected int damage;

    public State(String title, int hp, int damage) {
        this.title = title;
        this.hp = hp;
        this.maxHp = hp;
        this.damage = damage;
    }

    public String getTitle() {
        return this.title;
    }

    public int getHp() {
        return this.hp;
    }

    public int getMaxHp() {
        return this.maxHp;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getMana() throws ArmyExceptions {
        throw new UnitIsNotMageException();
    }

    public int getMaxMana() throws ArmyExceptions {
        throw new UnitIsNotMageException();
    }

    public HashMap<String, Spell> getSpellbook() throws ArmyExceptions {
        throw new UnitIsNotMageException();
    }


    public void addHp(int hp) {
        this.hp += hp;

        if ( this.hp > this.maxHp ) {
            this.hp = this.maxHp;
        }
    }

    public void spendHp(int hp) {
        this.hp -= hp;

        if ( this.hp < 0 ) {
            this.hp = 0;
        }
    }

    public void setHp(int newHp) {
        this.hp = newHp;
    }

    public void addMana(int mana) throws ArmyExceptions {
        throw new UnitIsNotMageException();
    }

    public void spendMana(int mana) throws ArmyExceptions {
        throw new UnitIsNotMageException();
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();

        out.append("(").append(this.title).append(")").append(": ");
        out.append("hp").append("[").append(this.hp).append("/").append(this.maxHp).append("]");
        out.append(" dmg:").append(this.damage);

        return out.toString();
    }
}
