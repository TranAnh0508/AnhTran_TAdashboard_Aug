## TA-DASHBOARD AUTOMATION REPOSITORY

## Summary
This repository is used to test the [Dashboard](http://localhost:54000/TADashboard/login.jsp) website

## Prerequisites

### Application
IntelliJ IDEA Community Edition (download here: https://www.jetbrains.com/idea/download/?section=windows)
+ Should be used because this is the application that wrote this repository
+ Other IDEAs can be used, but installation and usage will be slightly different

### Environments
+ Java 17 (download here: https://www.java.com/download/ie_manual.jsp)
+ Maven (visit here: https://mvnrepository.com/)
+ TestNG (visit here: https://mvnrepository.com/artifact/org.testng/testng)
+ Selenide (download here: https://selenide.org/2024/09/15/selenide-7.5.0/)

### How to run the code
1. Download source code (location, unzip,...)
2. Open IntelliJ IDEA. ```File``` -> ```Open``` -> ```Select file``` -> ```New Window``` or ```This Window```
3. Wait for dependencies to be installed (reimport if needed)
4. Make sure that at least the following plugins are imported: ```testNG```, ```lombok```
5. Make sure the browser is on the correct version (updated if the version is too old)
6. Run tests by commandline or using UI

### How to get the results
1. Run tests by commandline or using UI
2. Enter '''allure serve allure-results''' into the Terminal and then press Enter
3. You should see the results like this:
![allure_results_samp![](C:\Users\OS\OneDrive - Danang University of Technology\Pictures\Screenshots\Screenshot 2024-10-01 225405.png)le.png](img.png)
4. You can visit this website to get more information

### The features are applied
+ Github: Gitflow
+ Configuration: pom.xml: Dependencies, Commandline
+ Code: Name convention, OOP, Json, Data driven
+ Report: Allure report
+ Parallel / Grid

## Learn more about Selenium:
Visit here: https://anhtester.com/blog/selenium-java?fbclid=IwAR2jNVW-mHyz9zxivz72ELF3TLrgJgO0ePR7jnKwVbqoD_65h3PJI7Ef8M8



