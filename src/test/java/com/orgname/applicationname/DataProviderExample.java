package com.orgname.applicationname;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.orgname.base.BaseTest;
import com.orgname.utilities.CommonUtil;

public class DataProviderExample extends BaseTest {

	@Test(dataProviderClass = CommonUtil.class, dataProvider = "dataProvider")
	public void AddCust(String firstname, String lastname, String accountnumber, String flag) {

		System.out.println(firstname);
		System.out.println(lastname);
		System.out.println(accountnumber);
		System.out.println(flag);

	}

	@Test(dataProviderClass = CommonUtil.class, dataProvider = "dataProviderHashtable")
	public void AddCust_Hashtable(Hashtable<String, String> data) {

		System.out.println(data.get("firstname"));
		System.out.println(data.get("lastname"));
		System.out.println(data.get("accountnumber"));
		System.out.println(data.get("flag"));

	}

}
