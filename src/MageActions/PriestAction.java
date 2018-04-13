package MageActions;

import Exceptions.ArmyExceptions;
import Exceptions.IncorrectSpellNameException;
import Mages.Mage;
import Spells.BattleSpell;
import Spells.Spell;
import Units.Unit;

public class PriestAction extends MageAction {
    @Override
    public void cast(Mage owner, String spellName, Unit target) throws ArmyExceptions, CloneNotSupportedException {
        if ( !owner.getSpellbook().containsKey(spellName) ) {
            throw new IncorrectSpellNameException();
        }

        Spell spell = (Spell) (owner.getSpellbook().get(spellName)).clone();

        if ( target.getUnitType().equals("Undead") ) {
            if ( spell instanceof BattleSpell ) {
                spell.setPower(spell.getPower() * 2);
            }
        }

        spell.cast(target);

        System.out.print(owner.getTitle() + " " + owner.getName() + " cast a " + spell.getTitle() + " spell ");
        System.out.println(target.getTitle() + " " + target.getName());
    }

    @Override
    public void attack(Unit owner, Unit target) throws ArmyExceptions {
        int damage = owner.getDamage();

        if ( target.getUnitType().equals("Undead") ) {
            damage *= 2;
        }
        target.takeDamage(damage);

        System.out.print(owner.getTitle() + " " + owner.getName() + " attack ");
        System.out.println(target.getTitle() + " " + target.getName());

        target.counterAttack(owner);
    }

    @Override
    public void counterAttack(Unit owner, Unit target) throws ArmyExceptions {
        if ( owner.getHp() > 0 ) {
            int damage = owner.getDamage();

            if ( !target.getUnitType().equals("Undead") ) {
                damage /= 2;
            }
            target.takeDamage(damage);

            System.out.print(owner.getTitle() + " " + owner.getName() + " counterAttack ");
            System.out.println(target.getTitle() + " " + target.getName());
        }
    }
}
