package practise;

import org.testng.annotations.Test;

import com.comCast.crm.BaseClassTest.BaseClass1;
import com.comCast.crm.objectRepository.loginPage;



public class SearchContactTest extends BaseClass1
{@Test
 public void SerachContactTest()
 {
	/*
	 * Scenario:Login()==>navigatecontact===>createcontact()==verify
	 */
	loginPage lp=new loginPage(driver);
	lp.loginToApp(driver, null, null, null);
	 
 }
}
