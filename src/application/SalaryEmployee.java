package application;

public class SalaryEmployee extends Employee{
	
	private double yearlyIncome;
	
	SalaryEmployee(String name,int id,String insurance, double yearlyIncome) throws Exception{
		super(name,id,insurance);
		this.yearlyIncome = yearlyIncome;
		totalSalary = yearlyIncome;
	}
	
	public double getYearlyIncome() {
		return yearlyIncome;
	}
	public void setYearlyIncome(double yearlyIncome) {
		this.yearlyIncome = yearlyIncome;
	}
}
