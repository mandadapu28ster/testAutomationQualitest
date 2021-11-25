 #web automation sample
 
 Before following below steps make sure mentioned points
 1. In case of latest chrome browser and MAC all below steps work.
 2. In case of Windows laptop, please dowload and update chromedriver.exe in drivers folder, update path accordingly in BrowserFacade.java file (line 20)
 3. Same point 2 applies incase of any other OS 
 
 To execute web automation script run below command at source folder
 
 _./gradlew clean build runAll_
 
 Jenkins/HTML Reports will be available in folder --> build/target/reports/cucumber-html-reports/overview-features.html
 These reports can be opened any browser and check detailed step/scenari/feature wise category
  
 Alternatively We can excute as below methods also (assuming all required softwares/plugins installed)
 1. navigating to build.gradle and running runAll
 2. Navigating to testScriptDemo and right click Run 'Scenario: ..'
 3. Navigating to FunctionalTestSuite and run _public class FunctionalTestSuite_
 
 ***
 Improvements:
 1. This can be improved further to support multiple browser
 2. Can be enhanced to work in multi OS/browser combination, instead of manul browser driver update.(run time detect OS and use driver/browsers)
 3. Can be updated for Mobile browser
 4. Can be extended to support multi thread/Fork for parallel execution.
 5. Can be extended to support cloud platforms like Browser stack, SauceLabs
 6. Extended to support more in BrowserFacade to support wait/JS/href kind of useful methods
 7. Can be added with additional UI test capabilities for accesability and page wise performance (HAR)
 
# `~~**Happy Testing**~~`
