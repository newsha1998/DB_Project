package logic.object;

public class Wallet {
    int UserId;
    double BlockedCredit, AvailableCredit;

    public Wallet() {
    }

    public Wallet(int userId) {
        this.UserId = userId;
    }

    public void setAvailableCredit(double availableCredit) {
        AvailableCredit = availableCredit;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public void setBlockedCredit(double blockedCredit) {
        BlockedCredit = blockedCredit;
    }

    public int getUserId() {
        return UserId;
    }

    public double getAvailableCredit() {
        return AvailableCredit;
    }

    public double getBlockedCredit() {
        return BlockedCredit;
    }

}
