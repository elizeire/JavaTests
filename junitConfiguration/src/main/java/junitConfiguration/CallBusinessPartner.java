package junitConfiguration;

public class CallBusinessPartner {

	
	public static void main(String[] args) {
		BusinessPartnerServiceImpl businessPartnerServiceImpl = new BusinessPartnerServiceImpl();
		
		businessPartnerServiceImpl.getSignOfLife();
	}
}
