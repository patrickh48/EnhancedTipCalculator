package application;

public class CommissionEmployee extends Employee{


    private double commission;
    private double commissionCap;
    
    
    CommissionEmployee(String name, int id, String insurance, double commission, double commissionCap) throws Exception{
        super(name,id,insurance);
        this.commission = commission;
        this.commissionCap = commissionCap;
        totalSalary = commission;
    }

    
    public double getCommission() {
        return commission;
    }

    public double getCommissionCap() {
        return commissionCap;
    }

    public void setCommissionCap(double commissionCap) {
        this.commissionCap = commissionCap;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }
    
}
