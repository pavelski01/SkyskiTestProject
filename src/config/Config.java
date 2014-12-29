package config;

import org.openqa.selenium.WebDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Properties;
import java.util.StringTokenizer;

public class Config
{
    public Config()
    {
        final String DELIMITER = "|";
        final String STAGE_KEY = "stage";
        final String DEV_STAGE = "dev", PROD_STAGE = "prod", TEST_STAGE = "test";
        final char D_CASE = 'd', P_CASE = 'p', T_CASE = 't';
        Properties properties = this.getProperties();
        this.stage = properties.getProperty(STAGE_KEY);
        if (this.stage == null) this.stage = VAIN;
        StringTokenizer stringTokenizer = new StringTokenizer(this.getStage(), DELIMITER);
        String token;
        while (stringTokenizer.hasMoreTokens())
        {
            token = stringTokenizer.nextToken().toLowerCase();
            switch (token.charAt(0))
            {
                case D_CASE:
                    this.initializeStage(DEV_STAGE, properties);
                    break;
                case P_CASE:
                    this.initializeStage(PROD_STAGE, properties);
                    break;
                case T_CASE:
                    this.initializeStage(TEST_STAGE, properties);
                    break;
            }
        }
    }

    public static Config getConfigSingleton()
    {
        if (configSingleton == null) configSingleton = new Config();
        return configSingleton;
    }

    private void initializeStage(String _stagePrefix, Properties _properties)
    {
        final String[] realFake = { "Real", "Fake" };
        String temporaryKey, temporaryValue;
        for (int counter = 0; counter < realFake.length; counter++)
            for (String record : this.data)
            {
                temporaryKey = _stagePrefix + realFake[counter] + record;
                temporaryValue = _properties.getProperty(temporaryKey);
                if (temporaryValue == null) temporaryValue = VAIN;
                try { this.getFiled(temporaryKey).set(this, temporaryValue); }
                catch (IllegalAccessException iaEx)
                {
                    final String ILLEGAL = "Illegal access:";
                    System.out.println(ILLEGAL + GAP + iaEx.toString());
                }
            }
    }

    private Field getFiled(String _name)
    {
        try { return this.getClass().getDeclaredField(_name); }
        catch (NoSuchFieldException nsfEx)
        {
            final String NO_FIELD = "Field not exist:";
            System.out.print(NO_FIELD + GAP + nsfEx.toString());
            return null;
        }
    }

    private Properties getProperties()
    {
        final String
            PROPERTIES_NAME = "config.properties",
            PROPERTIES_PATH = "src/config/";
        Properties properties = new Properties();
        InputStream inputStream = null;
        try
        {
            inputStream = new FileInputStream(PROPERTIES_PATH + PROPERTIES_NAME);
            properties.load(inputStream);
        }
        catch (IOException ioEX)
        {
            final String
                PROPERTIES_ERROR_MSG1 = "Problem with load",
                PROPERTIES_ERROR_MSG2 = "configuration file:";
            System.out.println(
                PROPERTIES_ERROR_MSG1 + GAP + PROPERTIES_NAME + GAP +
                    PROPERTIES_ERROR_MSG2 + GAP + ioEX.toString()
            );
            if (inputStream != null)
            {
                try { inputStream.close(); }
                catch (IOException io2EX)
                {
                    final String STREAM_ERROR_MSG = "Problem with close input stream:";
                    System.out.println(STREAM_ERROR_MSG + GAP + io2EX.toString());
                }
            }
        }
        return properties;
    }

    public boolean isDebug() { return this.debug; }
    public Webdriver getFirefoxWebdriver() { return this.firefoxWebdriver; }
    public Webdriver getChromeWebdriver() { return this.chromeWebdriver; }
    public Webdriver getOperaWebdriver() { return this.operaWebdriver; }
    public int getTimeout() { return this.timeout; }
    public String getStage() { return this.stage; }
    public String getDevBaseURL() { return this.devBaseURL; }
    public String getDevBasePort() { return this.devBasePort; }
    public String getDevRealLogin() { return this.devRealLogin; }
    public String getDevRealPassword() { return this.devRealPassword; }
    public String getDevRealEmail() { return this.devRealEmail; }
    public String getDevRealForename() { return this.devRealForename; }
    public String getDevRealSurname() { return this.devRealSurname; }
    public String getDevRealStreetAddress() { return this.devRealStreetAddress; }
    public String getDevRealPostalCity() { return this.devRealPostalCity; }
    public String getDevRealPostalCode() { return this.devRealPostalCode; }
    public String getDevRealPhone() { return this.devRealPhone; }
    public String getDevFakeLogin() { return this.devFakeLogin; }
    public String getDevFakePassword() { return this.devFakePassword; }
    public String getDevFakeEmail() { return this.devFakeEmail; }
    public String getDevFakeForename() { return this.devFakeForename; }
    public String getDevFakeSurname() { return this.devFakeSurname; }
    public String getDevFakeStreetAddress() { return this.devFakeStreetAddress; }
    public String getDevFakePostalCity() { return this.devFakePostalCity; }
    public String getDevFakePostalCode() { return this.devFakePostalCode; }
    public String getDevFakePhone() { return this.devFakePhone; }
    public String getTestBaseURL() { return this.testBaseURL; }
    public String getTestBasePort() { return this.testBasePort; }
    public String getTestRealLogin() { return this.testRealLogin; }
    public String getTestRealPassword() { return this.testRealPassword; }
    public String getTestRealEmail() { return this.testRealEmail; }
    public String getTestRealForename() { return this.testRealForename; }
    public String getTestRealSurname() { return this.testRealSurname; }
    public String getTestRealStreetAddress() { return this.testRealStreetAddress; }
    public String getTestRealPostalCity() { return this.testRealPostalCity; }
    public String getTestRealPostalCode() { return this.testRealPostalCode; }
    public String getTestRealPhone() { return this.testRealPhone; }
    public String getTestFakeLogin() { return this.testFakeLogin; }
    public String getTestFakePassword() { return this.testFakePassword; }
    public String getTestFakeEmail() { return this.testFakeEmail; }
    public String getTestFakeForename() { return this.testFakeForename; }
    public String getTestFakeSurname() { return this.testFakeSurname; }
    public String getTestFakeStreetAddress() { return this.testFakeStreetAddress; }
    public String getTestFakePostalCity() { return this.testFakePostalCity; }
    public String getTestFakePostalCode() { return this.testFakePostalCode; }
    public String getTestFakePhone() { return this.testFakePhone; }
    public String getProdBaseURL() { return this.prodBaseURL; }
    public String getProdBasePort() { return this.prodBasePort; }
    public String getProdRealLogin() { return this.prodRealLogin; }
    public String getProdRealPassword() { return this.prodRealPassword; }
    public String getProdRealEmail() { return this.prodRealEmail; }
    public String getProdRealForename() { return this.prodRealForename; }
    public String getProdRealSurname() { return this.prodRealSurname; }
    public String getProdRealStreetAddress() { return this.prodRealStreetAddress; }
    public String getProdRealPostalCity() { return this.prodRealPostalCity; }
    public String getProdRealPostalCode() { return this.prodRealPostalCode; }
    public String getProdRealPhone() { return this.prodRealPhone; }
    public String getProdFakeLogin() { return this.prodFakeLogin; }
    public String getProdFakePassword() { return this.prodFakePassword; }
    public String getProdFakeEmail() { return this.prodFakeEmail; }
    public String getProdFakeForename() { return this.prodFakeForename; }
    public String getProdFakeSurname() { return this.prodFakeSurname; }
    public String getProdFakeStreetAddress() { return this.prodFakeStreetAddress; }
    public String getProdFakePostalCity() { return this.prodFakePostalCity; }
    public String getProdFakePostalCode() { return this.prodFakePostalCode; }
    public String getProdFakePhone() { return this.prodFakePhone; }

    private boolean debug;
    private Webdriver chromeWebdriver, firefoxWebdriver, operaWebdriver;
    private int timeout = 20;
    private final String[] data =
    {
        "Login", "Password", "Email", "Forename", "Surname",
        "StreetAddress", "PostalCity", "PostalCode", "Phone"
    };
    private String stage;
    private String devBaseURL, devBasePort;
    private String
        devRealLogin, devRealPassword, devRealEmail, devRealForename, devRealSurname,
        devRealStreetAddress, devRealPostalCity, devRealPostalCode, devRealPhone;
    private String
        devFakeLogin, devFakePassword, devFakeEmail, devFakeForename, devFakeSurname,
        devFakeStreetAddress, devFakePostalCity, devFakePostalCode, devFakePhone;
    private String testBaseURL, testBasePort;
    private String
        testRealLogin, testRealPassword, testRealEmail, testRealForename, testRealSurname,
        testRealStreetAddress, testRealPostalCity, testRealPostalCode, testRealPhone;
    private String
        testFakeLogin, testFakePassword, testFakeEmail, testFakeForename, testFakeSurname,
        testFakeStreetAddress, testFakePostalCity, testFakePostalCode, testFakePhone;
    private String prodBaseURL, prodBasePort;
    private String
        prodRealLogin, prodRealPassword, prodRealEmail, prodRealForename, prodRealSurname,
        prodRealStreetAddress, prodRealPostalCity, prodRealPostalCode, prodRealPhone;
    private String
        prodFakeLogin, prodFakePassword, prodFakeEmail, prodFakeForename, prodFakeSurname,
        prodFakeStreetAddress, prodFakePostalCity, prodFakePostalCode, prodFakePhone;
    private static Config configSingleton;
    private final String GAP = " ", VAIN = "";
}
