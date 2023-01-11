package unit_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PriorityTest extends BaseTest {

    @Test(priority = 2, groups = "group1")
    public void checkCreate() {
        final int count = 5;
        boolean expectedResult = true;
        boolean actualResult = present.PresentHandler.createPresentBox1(count);

        Assert.assertEquals(actualResult, expectedResult, "The result is not correct");
    }

    @Test(priority = 1, groups = "group1")
    public void checkNotCreate() {
        final int count = -5;
        boolean expectedResult = false;
        boolean actualResult = present.PresentHandler.createPresentBox1(count);

        Assert.assertEquals(actualResult, expectedResult, "The result is not correct");
    }


    @Test(priority = 4, groups = "group2")
    public void checkNotCreateFail() {
        final int count = -5;
        boolean expectedResult = true;
        boolean actualResult = present.PresentHandler.createPresentBox1(count);

        Assert.assertEquals(actualResult, expectedResult, "The result is not correct");
    }

}
