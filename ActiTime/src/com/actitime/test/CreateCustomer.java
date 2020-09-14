package com.actitime.test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.actitime.generics.BaseClass;
import com.actitime.pom.HomePage;
import com.actitime.pom.TaskListPage;

public class CreateCustomer extends BaseClass {
@Test
public void testCreateCustomer() throws InterruptedException, EncryptedDocumentException, IOException {
	String customername = f.getExcelValue("CreateCustomer", 1, 0);
	String customerDescp = f.getExcelValue("CreateCustomer", 1, 1);
	HomePage h=new HomePage(driver);
	h.clickTaskTab();
	TaskListPage t=new TaskListPage(driver);
	t.getAddNewBtn().click();
	t.getNewCustomerMenu().click();
	t.getEnterCustomertbx().sendKeys(customername);
    t.getEnterCustomerdescriptionTbx().sendKeys(customerDescp);
    t.getProjectDropDown().click();
    t.getOurCompanyMenu().click();
    t.getCreateCustomerBtn().click();
    Thread.sleep(7000);
   String ActualText = t.getActualCustomerCreated().getText();
   Assert.assertEquals(ActualText,customername);
}
}
