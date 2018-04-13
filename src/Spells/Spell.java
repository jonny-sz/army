package Spells;

import Exceptions.ArmyExceptions;
import Mages.Mage;
import Units.Unit;

public abstract class Spell implements Cloneable {
    protected String title;
    protected int power;
    protected int cost;
    protected Mage owner;

    public Spell(Mage owner, String title, int cost) {
        this.owner = owner;
        this.title = title;
        this.cost = cost;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    public String getTitle() {
        return this.title;
    }

    public int getPower() {
        return this.power;
    }

    public int getCost() {
        return this.cost;
    }


    public void setPower(int newPower) {
        this.power = newPower;
    }


    public abstract void cast(Unit target) throws ArmyExceptions;

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder(this.title);

        out.append("(").append(this.power).append("/").append(this.cost).append(")");

        return out.toString();
    }
}
