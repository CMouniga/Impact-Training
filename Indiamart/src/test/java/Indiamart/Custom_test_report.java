package Indiamart;
 
import org.testng.*;
import org.testng.annotations.Test;
import org.testng.xml.XmlSuite;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;
import java.lang.reflect.Method;
 
public class Custom_test_report implements IReporter {
 
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
 
    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        StringBuilder reportContent = new StringBuilder();
 
        
        reportContent.append("<html><head><title>TestNG Report</title>")
                .append("<style>body {font-family: Arial, sans-serif; font-size: 16px; color: #333;} ")
                .append("table {width: 100%; border-collapse: collapse; margin-bottom: 20px;} ")
                .append("th, td {border: 1px solid #ddd; padding: 12px; text-align: center; font-size: 14px;} ")
                .append("th {background-color: #f4f4f4; color: #333;} ")
                .append("td.passed {color: green; font-weight: bold;} ")
                .append("td.failed {color: red; font-weight: bold;} ")
                .append("td.skipped {color: orange; font-weight: bold;} ")
                .append("td.message {text-align: left; vertical-align: top;} ")
                .append("td.screenshot {text-align: left;} ")
                .append("td.log {text-align: left; font-size: 13px; white-space: pre-wrap; background-color: #f9f9f9;}") // Log Styling
                .append("</style>")
                .append("</head><body>");
 
        reportContent.append("<h2>TestNG Execution Report</h2>");
 
        // Table 1: Test Execution Summary
        
        
        reportContent.append("<h3>Test Execution Summary</h3>");
        reportContent.append("<table><tr><th>Test Name</th><th>Passed</th><th>Skipped</th><th>Failed</th><th>Start Time</th><th>End Time</th><th>Time Taken (s)</th><th>Date</th></tr>");
 
        for (ISuite suite : suites) {
            for (ISuiteResult suiteResult : suite.getResults().values()) {
                ITestContext context = suiteResult.getTestContext();
 
                int passed = context.getPassedTests().size();
                int skipped = context.getSkippedTests().size();
                int failed = context.getFailedTests().size();
                long startTime = context.getStartDate().getTime();
                long endTime = context.getEndDate().getTime();
                long timeTaken = (endTime - startTime) / 1000;
                String date = new SimpleDateFormat("dd-MM-yyyy").format(startTime);
 
                String formattedStartTime = timeFormat.format(startTime);
                String formattedEndTime = timeFormat.format(endTime);
 
                reportContent.append("<tr><td>").append(context.getName()).append("</td>")
                        .append("<td class=\"passed\">").append(passed).append("</td>")
                        .append("<td class=\"skipped\">").append(skipped).append("</td>")
                        .append("<td class=\"failed\">").append(failed).append("</td>")
                        .append("<td>").append(formattedStartTime).append("</td>")
                        .append("<td>").append(formattedEndTime).append("</td>")
                        .append("<td>").append(timeTaken).append("</td>")
                        .append("<td>").append(date).append("</td></tr>");
            }
        }
 
        reportContent.append("</table>");
 
        // Table 2: Test Case Details
        reportContent.append("<h3>Test Case Details</h3>");
        reportContent.append("<table><tr><th>Test Case</th><th>Status</th><th>Start Time</th><th>End Time</th><th>Execution Time (s)</th><th>Description</th><th>Screenshot</th></tr>");
 
        for (ISuite suite : suites) {
            for (ISuiteResult suiteResult : suite.getResults().values()) {
                ITestContext context = suiteResult.getTestContext();
                processTestResults(context.getPassedTests().getAllResults(), "Passed", reportContent);
                processTestResults(context.getFailedTests().getAllResults(), "Failed", reportContent);
                processTestResults(context.getSkippedTests().getAllResults(), "Skipped", reportContent);
            }
        }
 
        reportContent.append("</table>");
 
        // Table 3: Test Case Logs (Logs displayed directly under the test case)
        reportContent.append("<h3>Test Case Logs</h3>");
        reportContent.append("<table><tr><th>Test Case</th><th>Log Message</th></tr>");
 
        for (ISuite suite : suites) {
            for (ISuiteResult suiteResult : suite.getResults().values()) {
                ITestContext context = suiteResult.getTestContext();
                collectLogMessages(context.getPassedTests().getAllResults(), reportContent);
                collectLogMessages(context.getFailedTests().getAllResults(), reportContent);
                collectLogMessages(context.getSkippedTests().getAllResults(), reportContent);
            }
        }
 
        reportContent.append("</table></body></html>");
 
        
        try {
            SimpleDateFormat timestampFormat = new SimpleDateFormat("HH.mm.ss(dd)");
            String timestamp = timestampFormat.format(System.currentTimeMillis());
            String reportFileName = outputDirectory + "/custom_test_report_" + timestamp + ".html";
            File reportDir = new File(outputDirectory);
            if (!reportDir.exists()) {
                reportDir.mkdirs();  
            }
 
            File reportFile = new File(reportFileName);
            FileWriter writer = new FileWriter(reportFile);
            writer.write(reportContent.toString());
            writer.close();
            System.out.println("TestNG Report generated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    private void processTestResults(Set<ITestResult> results, String status, StringBuilder reportContent) {
        for (ITestResult result : results) {
            double executionTime = (result.getEndMillis() - result.getStartMillis()) / 1000.0;
            String formattedStartTime = timeFormat.format(result.getStartMillis());
            String formattedEndTime = timeFormat.format(result.getEndMillis());
 
            String description = getTestDescription(result.getMethod());
 
            reportContent.append("<tr><td>").append(result.getMethod().getMethodName()).append("</td><td>")
                    .append(status).append("</td><td>").append(formattedStartTime).append("</td><td>")
                    .append(formattedEndTime).append("</td><td>").append(executionTime).append("</td><td>")
                    .append(description).append("</td><td>");
 
            StringBuilder screenshotLinks = new StringBuilder();
            for (String message : Reporter.getOutput(result)) {
                if (message.contains("<a href=")) {
                    screenshotLinks.append(message).append("<br>");
                }
            }
            reportContent.append(screenshotLinks).append("</td></tr>");
        }
    }
 
    private void collectLogMessages(Set<ITestResult> results, StringBuilder reportContent) {
        for (ITestResult result : results) {
            StringBuilder logMessages = new StringBuilder();
 
            for (String message : Reporter.getOutput(result)) {
                if (!message.contains("<a href=")) {
                    logMessages.append(message).append("<br>");
                }
            }
 
            if (logMessages.length() > 0) {
                reportContent.append("<tr><td>").append(result.getMethod().getMethodName()).append("</td><td class='log'>")
                        .append(logMessages.toString()).append("</td></tr>");
            } else {
                reportContent.append("<tr><td>").append(result.getMethod().getMethodName()).append("</td><td class='log'>")
                        .append("No log messages").append("</td></tr>");
            }
        }
    }
 
    private String getTestDescription(ITestNGMethod method) {
        try {
            Method m = method.getRealClass().getMethod(method.getMethodName());
 
            if (m.isAnnotationPresent(Test.class)) {
                Test testAnnotation = m.getAnnotation(Test.class);
                return testAnnotation.description();  
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
 
        return "No Description Available";
    }
}