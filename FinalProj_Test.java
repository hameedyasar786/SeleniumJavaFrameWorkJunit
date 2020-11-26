package finalProjectPkg;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.Assert;

public class FinalProj_Test {
	
	FinalProj_Page FP=new FinalProj_Page();
	FinalProj_Data FD=new FinalProj_Data();
     
	@DisplayName("Opened The Browser")
	@BeforeEach
    public void openBrowser() {
		FP.openFinalProjApplication(FD.driverPath,FD.URL,FD.waitTime);	
	}

	@DisplayName("Web Application Under Test")
	@Test
	public void applicationUnderTest() {
		FP.orderingAnItem(FD.itemName, FD.lowestPrice, FD.timeOutValue,FD.printTotalValue);
		Assert.assertEquals(FD.expectedTitle,FP.verifyLandingPageTitle());
	}
	
	@DisplayName("Closed The Browser")
	@AfterEach
	public void closeBrowser() {
		FP.closeFinalProjApplication();
	}
}
