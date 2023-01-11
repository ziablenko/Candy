package unit_tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    @BeforeTest
    public void BeforeTest(){
        System.out.println("BeforeTest started");
    }

    @AfterTest
    public void AfterTest(){
        System.out.println("AfterTest started");
    }
}
