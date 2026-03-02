package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.markuputils.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTest 
{
    protected WebDriver driver;
    public static ExtentSparkReporter htmlReport;
    public static ExtentReports report;
    public static ExtentTest test;

    @BeforeSuite(alwaysRun = true)
    public void setupReport() 
    {
        // 1. Create the timestamp for the file name
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));        
        // 2. Set destination to exactly: /test-output/ExtentReports/
        String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReports/Extent_" + timestamp + ".html";        
        htmlReport = new ExtentSparkReporter(reportPath);
        report = new ExtentReports();
        report.attachReporter(htmlReport);        
        // 3. Set specific Date Format for the UI
        htmlReport.config().setTimeStampFormat("EEEE MMMM dd yyyy, hh:mm a '('zzz')'");
        htmlReport.config().setReportName("bstackdemo Website_Automation EndToEnd Test Report");
        htmlReport.config().setTheme(Theme.STANDARD);
        // 4. Set System Info
        report.setSystemInfo("User", "Reena Shaily");
        report.setSystemInfo("Browser", "Google Chrome");
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp(ITestResult result) 
    {
        test = report.createTest(result.getMethod().getMethodName());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://bstackdemo.com/");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) 
    {
        // logs the pass/fail status
        if(result.getStatus() == ITestResult.SUCCESS) 
        {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - Passed", ExtentColor.GREEN));
        }
        else if(result.getStatus() == ITestResult.FAILURE) 
        {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Failed", ExtentColor.RED));
            test.fail(result.getThrowable());
        }

        if (driver != null) 
        {
            driver.quit();
        }
    }

    @AfterSuite(alwaysRun = true)
    public void finishReport() 
    {
        // Finalizes the single report file
        if (report != null) 
        {
            report.flush();
        }
    }
}