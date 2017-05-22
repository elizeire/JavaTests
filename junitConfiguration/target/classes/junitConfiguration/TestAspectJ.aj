package junitConfiguration;

import junitConfiguration.BusinessPartnerServiceImpl;
public aspect TestAspectJ {

    pointcut getSignOfLife() : 
      call(void BusinessPartnerServiceImpl.getSignOfLife());

    before() : getSignOfLife() {
        System.err.println("ADKL TEST ASPECT");
    }

}