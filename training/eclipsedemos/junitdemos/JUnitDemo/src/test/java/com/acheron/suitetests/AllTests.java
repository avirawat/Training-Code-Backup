package com.acheron.suitetests;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludePackages;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@SelectPackages(value= {"com.acheron.newtests"})
//@IncludePackages(value= {"com.acheron.newtests.check"})
@ExcludePackages(value= {"com.acheron.newtests.check"})
@RunWith(JUnitPlatform.class)
class AllTests {


}
