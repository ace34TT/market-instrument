package entity;

public class SellsPerMonth {
    int month;
    float amount;

    public SellsPerMonth(int month, float amount) {
        this.month = month;
        this.amount = amount;
    }

    public int getMonth() {
        return this.month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public float getAmount() {
        return this.amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

}
