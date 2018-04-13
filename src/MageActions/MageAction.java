package MageActions;

import Actions.Action;
import Exceptions.ArmyExceptions;
import Exceptions.IncorrectSpellNameException;
import Mages.Mage;
import Spells.Spell;
import Units.Unit;

public class MageAction extends Action {
    @Override
    public void cast(Mage owner, String spellName, Unit target) throws ArmyExceptions, CloneNotSupportedException {
        if ( !owner.getSpellbook().containsKey(spellName) ) {
            throw new IncorrectSpellNameException();
        }

        Spell spell = owner.getSpellbook().get(spellName);

        System.out.print(owner.getTitle() + " " + owner.getName() + " cast a " + spell.getTitle() + " spell ");
        System.out.println(target.getTitle() + " " + target.getName());

        spell.cast(target);
    }

    @Override
    public void addSpell(Mage owner, String spellTitle, Spell spell) throws ArmyExceptions {
        owner.getSpellbook().put(spellTitle, spell);
    }
}
