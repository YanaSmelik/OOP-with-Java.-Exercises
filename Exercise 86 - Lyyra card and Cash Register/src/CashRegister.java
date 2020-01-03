public class CashRegister {
    private double cashInRegister;
    private int economicalSold;
    private int gourmentSold;

    public CashRegister() {
        this.cashInRegister = 1000;
    }

    public double payEconomical(double cashGiven) {
        if (cashGiven >= 2.50) {
            cashInRegister += 2.50;
            economicalSold++;
            return cashGiven - 2.50;
        } else {
            return cashGiven;
        }
    }

    public double payGourment(double cashGiven) {
        if (cashGiven >= 4) {
            cashInRegister += 4;
            gourmentSold++;
            return cashGiven - 4;
        } else {
            return cashGiven;
        }
    }

    public String toString() {
        return "money in register " + cashInRegister + " economical lunches sold: " + economicalSold + " " +
                "gourment lunches sold: " + gourmentSold;
    }

    public boolean payEconomical(LyyraCard card) {
        if (card.balance() >= 2.50) {
            economicalSold++;
            card.pay(2.50);
            return true;
        } else {
            return false;
        }
    }

    public boolean payGourment(LyyraCard card) {
        if (card.balance() >= 4) {
            gourmentSold++;
            card.pay(4);
            return true;
        } else {
            return false;
        }
    }

    public void loadMoneyToCard(LyyraCard card, double sum) {
        if (sum >= 0) {
            card.loadMoney(sum);
            cashInRegister += sum;
        }
    }
}
