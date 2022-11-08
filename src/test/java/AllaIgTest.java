import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AllaIgTest {

    //    TC_1_1  - Тест кейс:
    //    //1. Открыть страницу https://openweathermap.org/
    //    //2. Набрать в строке поиска город Paris
    //    //3. Нажать пункт меню Search
    //    //4. Из выпадающего списка выбрать Paris, FR
    //    //5. Подтвердить, что заголовок изменился на "Paris, FR"
    @Test
    public void testH2TagText_WhenSearchingCityCountry() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/C:\\Users\\alla\\Downloads\\chromedriver_win32" +
                "\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String cityName = "Paris";
        String expectedResult = "Paris, FR";

        driver.get(url);

        Thread.sleep(5000);

        WebElement searchCityField = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//input[@placeholder = 'Search city']")
        );

        searchCityField.click();
        searchCityField.sendKeys(cityName);

        WebElement searchButton = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//button[@type = 'submit']")
        );
        searchButton.click();
        Thread.sleep(1000);
        WebElement parisFRChoiceInDropdownMenu = driver.findElement(
                By.xpath("//ul[@class = 'search-dropdown-menu']/li/span[text() = 'Paris, FR ']")
        );
        parisFRChoiceInDropdownMenu.click();

        WebElement h2CityCountryHeader = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//h2")
        );
        Thread.sleep(2000);
        String actualResult = h2CityCountryHeader.getText();

        Assert.assertEquals(actualResult, expectedResult);

//        Thread.sleep(5000);

        driver.quit();
    }




    //TC_11_01
//        1.  Открыть базовую ссылку
//        2.  Нажать на пункт меню Guide
//        3.  Подтвердить, что вы перешли на страницу со ссылкой https://openweathermap.org/guide и что title этой
//        страницы OpenWeatherMap API guide - OpenWeatherMap
    @Test
    public void testGuideOpeningFromMenu() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/C:\\Users\\alla\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";

        String expectedResult = "OpenWeatherMap API guide - OpenWeatherMap";

        driver.get(url);

        Thread.sleep(5000);

        WebElement guideButton = driver.findElement(
                By.xpath("//div[@id = 'desktop-menu']/ul/li/a[@href = '/guide']")
        );
        guideButton.click();

        String actualResult = driver.getTitle();

        Assert.assertEquals(actualResult, expectedResult);

        String expectedCurrentUrl = "https://openweathermap.org/guide";

        String actualCurrentUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();
    }
//   TC_11_02
//1.  Открыть базовую ссылку
//2.  Нажать на единицы измерения Imperial: °F, mph
//3.  Подтвердить, что температура для города показана в Фарингейтах

    @Test
    public void testTempInImperialFisOnThePage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/C:\\Users\\alla\\Downloads\\" +
                "chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";

        driver.get(url);

        Thread.sleep(5000);

        WebElement searchImperialFButton = driver.findElement(
                By.xpath("//div[@id='weather-widget']/div/div/div/div/div/div[3]")
        );

        searchImperialFButton.click();

        Thread.sleep(3000);

        String temp = "°F";
        WebElement searchImperialF = driver.findElement(
                By.xpath("//div[@class='section-content']/div/div/div/div/span")
        );
        boolean actualResult = searchImperialF.getText().contains(temp);
        boolean expectedResult = true;
        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    //    TC_11_03
//1.  Открыть базовую ссылку
//2. Подтвердить, что внизу страницы есть панель с текстом “We use cookies which are essential for the site to work.
//    We also use non-essential cookies to help us improve our services. Any data collected is anonymised. You can allow
//    all cookies or manage them individually.”
    @Test
    public void testCookiesPanelOpens() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/C:\\Users\\alla\\Downloads" +
                "\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";

        driver.get(url);

        Thread.sleep(5000);

        WebElement cookiesPanel = driver.findElement(
                By.xpath("//div[@id = 'stick-footer-panel']/div/div/div/div/p")
        );
        String actualResult = cookiesPanel.getText();
        String expectedResult = ("We use cookies which are essential for the site to work. We also use non-essential" +
                " cookies" +
                " to help us improve our services. Any data collected is anonymised. You can allow all cookies or " +
                "manage them individually.");
        Assert.assertEquals(actualResult, expectedResult);

        WebElement cookiesButtonsAll = driver.findElement(
                By.xpath("//*[@id= 'stick-footer-panel']/div/div/div/div/div/button")
        );
        String actualNameButton = cookiesButtonsAll.getText();
        String expectedNameButton = ("Allow all");
        Assert.assertEquals(actualNameButton, expectedNameButton);

        WebElement cookiesButtonsManage = driver.findElement(
                By.xpath("//*[@id='stick-footer-panel']/div/div/div/div/div/a")
        );

        String actualNameButton1 = cookiesButtonsManage.getText();
        String expectedNameButton1 = ("Manage cookies");
        Assert.assertEquals(actualNameButton1, expectedNameButton1);


        driver.quit();
    }

    //    TC_11_04
//1.  Открыть базовую ссылку
//2.  Подтвердить, что в меню Support есть 3 подменю с названиями “FAQ”, “How to start” и “Ask a question”
    @Test
    public void testCheckingSubButtonsInMenuSupport() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/C:\\Users\\alla\\Downloads" +
                "\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";

        driver.get(url);

        Thread.sleep(5000);
        WebElement supportButton = driver.findElement(
                By.xpath("//div[@id = 'support-dropdown']")
        );
        supportButton.click();
        Thread.sleep(1000);

        WebElement subMenuFAQ = driver.findElement(
                By.xpath("//div[@id = 'desktop-menu']//li/ul/li/a")
        );
        String actualNameButton1 = subMenuFAQ.getText();
        String expectedNameButton1 = ("FAQ");
        Assert.assertEquals(actualNameButton1, expectedNameButton1);

        WebElement howToStartButton = driver.findElement(
                By.xpath("//div[@id = 'desktop-menu']//ul/li/a[@href ='/appid' = 'How to start']")
        );
        String actualNameButton = howToStartButton.getText();
        String expectedNameButton = ("How to start");
        Assert.assertEquals(actualNameButton, expectedNameButton);

        WebElement askAQuestionButton = driver.findElement(
                By.xpath("//div[@id = 'desktop-menu']//ul/li[12]//ul/li[3]/a")
        );
        String actualNameButton3 = askAQuestionButton.getText();
        String expectedNameButton3 = ("Ask a question");
        Assert.assertEquals(actualNameButton, expectedNameButton);
    }

    //    TC_11_05
//1. Открыть базовую ссылку
//2. Нажать пункт меню Support → Ask a question
//3. Заполнить поля Email, Subject, Message
//4. Не подтвердив CAPTCHA, нажать кнопку Submit
//5. Подтвердить, что пользователю будет показана ошибка “reCAPTCHA verification failed, please try again.”
    @Test
    public void testCaptchaMassageErrorInSupportMenuAskAQues() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/C:\\Users\\alla\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String url1 = "https://home.openweathermap.org/questions";
        String email = "alla@mail.com";
        String message = "Hi there";
        driver.get(url);

        Thread.sleep(5000);

        WebElement supportButton = driver.findElement(
                By.xpath("//div[@id = 'support-dropdown']")
        );
        supportButton.click();
        Thread.sleep(3000);

        WebElement askAQuestionButton = driver.findElement(
                By.xpath("//div[@id = 'desktop-menu']//ul/li[12]//ul/li[3]/a")
        );
        askAQuestionButton.click();

        Thread.sleep(5000);

        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        WebElement findEmailField = driver.findElement(
                By.xpath("//*[@id='question_form_email']")
        );
        Thread.sleep(5000);

        findEmailField.sendKeys("alla@.com");

        WebElement findSubjectField = driver.findElement(
                By.xpath("//*[@id='question_form_subject']")
        );
        findSubjectField.click();

        WebElement fRChoiceInDropdownMenu = driver.findElement(
                By.xpath("//*[@id='question_form_subject']/option[2]")
        );
        fRChoiceInDropdownMenu.click();

        WebElement findMessageField = driver.findElement(
                By.xpath("//*[@id='question_form_message']")
        );
        findMessageField.sendKeys(message);

        WebElement findSubmitButton = driver.findElement(
                By.xpath("//*[@id='new_question_form']/div[9]/input")
        );
        findSubmitButton.click();

        String window2 = driver.getWindowHandle();

        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='reCAPTCHA']")));

        WebElement enterCaptcha = driver.findElement(By.xpath(
                "//span[@class='recaptcha-checkbox goog-inline-block recaptcha-checkbox-unchecked "
                        + "rc-anchor-checkbox']"));
        enterCaptcha.click();

        Thread.sleep(10000);

        driver.switchTo().window(window2);
        Thread.sleep(2000);
        WebElement capchaErrorWords = driver.findElement(
                By.xpath("//*[@id='new_question_form']/div[9]/div[1]/div")
        );
        Thread.sleep(2000);
        String actualResult = capchaErrorWords.getText();
        String expectedResult = "reCAPTCHA verification failed, please try again.";
        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    //    TC_11_07
//1.  Открыть базовую ссылку
//2.  Нажать на единицы измерения Imperial: °F, mph
//3.  Нажать на единицы измерения Metric: °C, m/s
//4.  Подтвердить, что в результате этих действий, единицы измерения температуры изменились с F на С
    @Test
    public void testTempMeasureChange_WhenClickFtempCtempButtons() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/C:\\Users\\alla\\Downloads" +
                "\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";

        driver.get(url);

        Thread.sleep(5000);

        WebElement searchImperialF = driver.findElement(
                By.xpath("//div[@id='weather-widget']/div/div/div/div/div/div[3]")
        );

        searchImperialF.click();

        Thread.sleep(5000);
        WebElement searchImperialFOnTheScreen = driver.findElement(
                By.xpath("//div[@class='section-content']/div/div/div/div/span")
        );
        boolean actualResult = searchImperialFOnTheScreen.getText().contains("°F");
        boolean expectedResult = true;
        Assert.assertEquals(actualResult, expectedResult);
        Thread.sleep(3000);
        WebElement metricCtemp = driver.findElement(
                By.xpath("//div[@id= 'weather-widget']/div/div/div/div/div/div[2]")
        );
        metricCtemp.click();
        Thread.sleep(3000);
        WebElement searchMetricOnTheScreen = driver.findElement(
                By.xpath("//div[@class='section-content']/div/div/div/div/span")
        );
        boolean actualResult1 = searchImperialFOnTheScreen.getText().contains("°C");
        boolean expectedResult1 = true;
        Assert.assertEquals(actualResult1, expectedResult1);

        driver.quit();
    }

    //    TC_11_08
//1.  Открыть базовую ссылку
//2.  Нажать на лого компании
//3.  Дождаться, когда произойдет перезагрузка сайта, и подтвердить, что текущая ссылка не изменилась
    @Test
    public void testRefreshingUrl_WhenPressOnLogo() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/C:\\Users\\alla\\Downloads" +
                "\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";

        driver.get(url);

        Thread.sleep(5000);

        WebElement findLogoRoof = driver.findElement(
                By.xpath("//nav/ul/li[@class = 'logo']")
        );

        findLogoRoof.click();
        Thread.sleep(5000);

        String actualUrl = "https://openweathermap.org/";
        String expectedUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl);


        driver.quit();
    }

    //TC_11_09
//        1.  Открыть базовую ссылку
//        2.  В строке поиска в навигационной панели набрать “Rome”
//
//        3.  Нажать клавишу Enter
//        4.  Подтвердить, что вы перешли на страницу в ссылке которой содержатся слова “find” и “Rome”
//        5. Подтвердить, что в строке поиска на новой странице вписано слово “Rome”
    @Test
    public void testConfirmAppearingWordRome_AfterInsertRomeInSearch() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/C:\\Users\\alla\\Downloads" +
                "\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url1 = "https://openweathermap.org/find?q=Rome";
        String url = "https://openweathermap.org/";

        driver.get(url);

        Thread.sleep(5000);

        WebElement searchPanel = driver.findElement(
                By.xpath("//nav[@id = 'nav-website']/ul/div/form/input[1]")
        );
        searchPanel.sendKeys("Rome");
        WebElement searchSymbol = driver.findElement(
                By.xpath("//*[@id='desktop-menu']/form")
        );
        searchSymbol.click();
        Thread.sleep(5000);

        driver.get(url1);
        Thread.sleep(3000);
        boolean actualResult = driver.getCurrentUrl().contains("Rome");
        boolean expectedResult = true;
        Assert.assertEquals(actualResult, expectedResult);

        WebElement nameRomeInSearchWindow = driver.findElement(
                By.xpath("//*[@id='search_str']")
        );
        String actualNameInSW = "Rome";
        String expectedNameInSW = nameRomeInSearchWindow.getAttribute("value");
        Assert.assertEquals(actualNameInSW, expectedNameInSW);

        driver.quit();
    }

    //    TC_11_10
//1.  Открыть базовую ссылку
//2.  Нажать на пункт меню API
//3.  Подтвердить, что на открывшейся странице пользователь видит 30 оранжевых кнопок
    @Test
    public void test30OrangeButtons_onPage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/C:\\Users\\alla\\Downloads" +
                "\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";

        driver.get(url);

        Thread.sleep(5000);
        driver.manage().window().maximize();
        WebElement apiButton = driver.findElement(
                By.xpath("//*[@id='desktop-menu']/ul/li[2]/a")
        );
        apiButton.click();
        Thread.sleep(3000);

        int countButton = driver.findElements(
                By.xpath("//a[contains(@class, 'btn_block orange round') " +
                        "or contains(@class, 'ow-btn round btn-orange') ]")).size();

        int actualResult = countButton;
        int expectedResult = 30;
        Assert.assertEquals(actualResult, expectedResult);

    }
}