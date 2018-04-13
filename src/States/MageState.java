package States;

import Spells.Spell;

import java.util.HashMap;

public class MageState extends State {
    private int mana;
    private int maxMana;
    private HashMap<String, Spell> spellbook;

    public MageState(String title, int hp, int mana, int damage) {
        super(title, hp, damage);
        this.mana = mana;
        this.maxMana = mana;
        this.spellbook = new HashMap<>();
    }

    @Override
    public int getMana() {
        return this.mana;
    }

    @Override
    public int getMaxMana() {
        return this.maxMana;
    }

    @Override
    public HashMap<String, Spell> getSpellbook() {
        return this.spellbook;
    }

    @Override
    public void addMana(int mana) {
        this.mana += mana;

        if ( this.mana > this.maxMana ) {
            this.mana = this.maxMana;
        }
    }

    @Override
    public void spendMana(int mana) {
        this.mana -= mana;

        if ( this.mana < 0 ) {
            this.mana = 0;
        }
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder(super.toString());

        out.append(" ").append(" mana(").append(this.mana).append("/").append(this.maxMana).append(")");
        out.append(" spellbook[ ");

        for ( Spell spell: spellbook.values() ) {
            out.append(spell).append(" ");
        }

        out.append("]");

        return out.toString();
    }
}
