# HelloFresh-Task-1

# Project Summary:

This framework uses Selenium WebDriver-Cucumber-Junit-Maven with Page Object Model.

•	For logging framework used com.cucumber.listener.Reporter and addStepLog(“”) method.

•	For reporting extent report, which can be obtained “\target\cucumber-reports”.

•	Src/main/java- contain all framework related file such as Page action, WebDriver factory, PageObjectLibrary, FileReaderLibrary, ConfigFileReader, Cucumber context.

•	Src/test/java- contain framework runner class and step definition files.

•	CucumberFeatureFile folder contain feature file, which is used to write business scenarios.

•	Config folder contain properties file, properties file has all fixed value like URL name.


### Feature File:
•	Cucumber feature file “HelloFreshUITask.feature” has all three business scenarios.

•	Scenarios are dependant as per the design and it will run sequentially.


# How to Execute Test:

### Option#1:
•	Clone the project from GitHub: https://github.com/rajesha2016/HelloFresh-Task-1.git to your IDE( I have used Eclipse) 

•	Go to \src\test\java\Runner package

•	Right click on TestRunner.java file and run as junit

•	Task will execute in chrome browser as mentioned in Configuration.properties file


### Option#2:
•	Open command prompt

•	Go to project directory

•	Type mvn install, once completed type mvn test

•	Task will execute in chrome browser as mentioned in Configuration.properties file


# Parallel Execution:

### Option#1:

•	Cucumber plugin- replace the maven-surefire plugin with below and it will run parallelly. 

<plugin>
  
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>2.19</version>
    <configuration>
        <forkCount>10</forkCount>
        <reuseForks>true</reuseForks>
        <includes>
            <include>**/TestRunner.java</include>
        </includes>
    </configuration>
</plugin>


### Option#2:

•	Using Selenium Grid: in the framework we have EnvironmentType.java enum where environment type is mentioned. For remote the method is not implemented in the framework.

### Report:

•	Framework uses the benefits of Extent report and generate a very good human readable html report.

•	For failed scenario inside Hooks.java class, if the scenario gets failed then it will capture the screenshot and will attach to the corresponding scenario step.

•	Report generate inside “\target\cucumber-reports”.


