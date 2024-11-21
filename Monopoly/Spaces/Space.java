package Monopoly.Spaces;

import Monopoly.Main.*;

public abstract class Space {
    protected String name;

    public Space(String name) {
        this.name = name;
    }

    public abstract void landOn(Player player);

    // Getter
    public String getName() {
        return name;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }
}