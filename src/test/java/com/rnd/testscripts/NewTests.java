package com.rnd.testscripts;

import static com.learning.constants.FrameworkConstants.ASSERTION_FOR;

import org.testng.annotations.Test;

import com.learning.annotations.FrameworkAnnotation;
import com.learning.enums.AuthorType;
import com.learning.enums.CategoryType;
import com.learning.pages.LoginPage;
import com.learning.testdata.TestData;
import com.learning.utils.DataProviderUtils;
import com.learning.utils.VerificationUtils;

public class NewTests extends BaseTest {
    @FrameworkAnnotation(author = {AuthorType.RAJAT, AuthorType.NISHANT},
            category = {CategoryType.BVT, CategoryType.REGRESSION})
    @Test(groups = {"BVT","REGRESSION"},description = "To check whether the User can not login with Invalid Credentials",
            dataProvider = "getTestData", dataProviderClass = DataProviderUtils.class)
    public void errorInvalidCredentials(TestData testData) {

        LoginPage loginPage = new LoginPage();
        loginPage.loginToApplication(testData.getUsername(), testData.getPassword());
        String errorInvalidCreds =  loginPage.getErrorMessage();

//        Assert.assertEquals(errorInvalidCreds, testData.getExpectedError(),
//                "Assertion for Invalid credentials Error message");

        VerificationUtils.validateResponse(errorInvalidCreds,testData.getExpectedError(),
                ASSERTION_FOR +" -  <b> <u> Invalid credentials Error message </b> </u>");

    }


}
