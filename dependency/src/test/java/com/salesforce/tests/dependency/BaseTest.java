  package com.salesforce.tests.dependency;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

/**
 * Unit Test runner: capture stdin/stdout for testing
 */
public class BaseTest {

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().muteForSuccessfulTests().enableLog();

    private Main main;

    @Before
    public void setUp() {
        main = new Main();
    }

    protected void runTest(String expectedOutput, String... input) {
        systemInMock.provideLines(input);
        Main.main(new String[0]);
        Assert.assertEquals(expectedOutput, systemOutRule.getLogWithNormalizedLineSeparator());
    }
}
