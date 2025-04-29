package application;


public class BaseComissionEmployee extends Employee{
	private double baseSalary;
	private double commission;
	
    BaseComissionEmployee(String name, int id, String insurance, double commission, double baseSalary) throws Exception{
        super(name,id,insurance);
        this.commission = commission;
        this.baseSalary =  baseSalary;
        totalSalary = commission + baseSalary;
       
    }
    public double getBaseSalary() {
    	return baseSalary;
    }
    public double getCommission() {
    	return commission;
    }
    public void setBaseSalary(double baseSalary) {
    	this.baseSalary = baseSalary;
    }
    public void setCommission(double commission) {
    	this.commission = commission;
    }
    
}
