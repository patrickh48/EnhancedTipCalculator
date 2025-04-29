package application;

public class Employee {
	//Context into Employee > Commission & Base
	// Commission vs Base salary is the same in a Company's eyes, its still money they have to pay, if given more time we could've created something more in depth into commission capping
	// and product selling tracking but with the lack of time it was hard to impossible to implement that.
    private String name;
    private int id;
    private String insurance;
    private double taxHoldings;
    protected double totalSalary;


    Employee(String name, int id, String insurance) throws Exception{
        this.name = name;
        this.id = id;
        if(insurance == null) {
        	this.insurance = "PPO"; 
        }//PPO is automatic selection
        else {
        	this.insurance = insurance;
        }
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setTotalSalary(double totalSalary) {
    	this.totalSalary = totalSalary;
    }
    public double getTaxHoldings() {
    	return(getFICASocial() + getSUTA() + getFICAMedicare() + getFederalIncomeTax() + getMedicalInsurance());
    }
    public void setId(int id){
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

	public double getTotalSalary() {
		// Overwrite with subclasses
		return totalSalary;
	}
	public double getFICASocial() {
		//6.2% of first 1320000
		if(totalSalary < 1320000) {
			return(totalSalary * .062);
		}
		else {
			return(132000 * .062);
		}
	}
	public double getSUTA() {
		//4.8% of salary up to $7,000
		if(totalSalary < 28000) {
			return(totalSalary * .01);
		}
		else {
			return(280000 * .01);
		}
	}
	public String getHealthInsurance() {
		//Employer covers 78% 
		return insurance;
		
	}
	public double getFICAMedicare() {
		//1.45% of all dollars earned
		return totalSalary * .0145;
	}
	public double getFederalIncomeTax() {
		//0.6%
		if(totalSalary < 28000) {
			return(totalSalary * .006);
		}
		else {
			return(280000 * .006);
		}
	}
	
	public double getMedicalInsurance() {
		//Monthly cost of an average HSA plan
		if(insurance == "HSA") {
			return 400;
		}
		//Monthly cost of an average HMO plan
		else if(insurance == "HMO") {
			return 427;
		}
		//Monthly cost of an average PPO plan
		else {
			return 517;
		
		}
	}
	
    
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", insurance='" + insurance + '\'' +
                ", taxHoldings=" + getTaxHoldings() +
                '}';
    }
}
