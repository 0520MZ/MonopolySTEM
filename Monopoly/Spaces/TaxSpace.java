package Monopoly.Spaces;

import Monopoly.Main.*;

public class TaxSpace extends Space {
    private int taxAmount;

    public TaxSpace(String name, int taxAmount) {
        super(name);
        this.taxAmount = taxAmount;
    }

    @Override
    public void landOn(Player player) {
        player.decreaseMoney(taxAmount);
    }

    // Getter and Setter
    public int getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(int taxAmount) {
        this.taxAmount = taxAmount;
    }
}