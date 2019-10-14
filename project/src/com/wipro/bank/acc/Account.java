package com.wipro.bank.acc;

public abstract class Account {
	int tenure;
	float principal;
	float rateOfInterest;
	public void setInterest(int age, String gender) {
		if(age<60 && gender.equalsIgnoreCase("male")) {
			rateOfInterest = 9.8f;
		}
		else if(age>=60 && gender.equalsIgnoreCase("male")) {
			rateOfInterest = 10.5f;
		}
		else if(age<58 && gender.equalsIgnoreCase("female")) {
			rateOfInterest = 10.2f;
		}
		else if(age>=58 && gender.equalsIgnoreCase("female")) {
			rateOfInterest = 10.8f;
		}
		
		
	}
public float calculateMaturityAmount(float totalPrincipleDeposited,float maturityInterest) {
	return maturityInterest+totalPrincipleDeposited;
}
public abstract float calculateInterest();
public abstract float calculateAmountDeposited();

public class RDAccount extends Account{

	public RDAccount(int tenure, float principal) {  
		
	}
	public float calculateInterest() {
		
		return principal*tenure*12;
	}

	public float calculateAmountDeposited() {
		float r=rateOfInterest/100;
		int n=4;
		float p = 0.0f;
		int tn = tenure*12;
		for(int i=0;i<tn;i++){
			p += principal* (float)(Math.pow(1+(r/n),n*((tn-i)/12.0))-1);
		}
		return p;
	}
	
}

}
