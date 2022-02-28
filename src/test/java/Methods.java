
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;


public class Methods {

    static WebDriver driver;
    public JavascriptExecutor js;

    public Methods(){

        driver= TestRunner.driver;
        js = (JavascriptExecutor) driver;
    }

    public WebElement findElement(String key,String value){

        return driver.findElement(getElementInfoToBy(key,value));
    }

    public WebElement findElements(String key,String value,int index){

        return driver.findElements(getElementInfoToBy(key,value)).get(index);
    }

    public static By getElementInfoToBy(String key,String value) {

        By by = null;
        if (value.equals("css")) {
            by = By.cssSelector(key);
        } else if (value.equals("id")) {
            by = By.id(key);
        }else if (value.equals("xpath")) {
            by = By.xpath(key);
        }
        return by;
    }

    public void clickElement(String key,String value){

        findElement(key,value).click();
        System.out.println("============ Elemente Tıklandı ============");
    }

    public void clickElements(String key,String value,int index){

        findElements(key,value,index).click();
        System.out.println("============ Elementlerinden -"+ index+"- Değerindekine Tıklandı ============");
    }

    public  void sendkeysElement(String key,String value,String text){

        findElement(key,value).sendKeys(text);
        System.out.println("============ Elementine -"+text+"- Değeri Yazıldı ============");
    }

    public void assertControl(String key,String value, String expectedName){

        String assertName = findElement(key,value).getText();
        System.out.println(" ============ Alınan Değer :"+assertName+" ============");
        System.out.println(" ============ Beklenen Değer : "+expectedName+" ============");
        Assert.assertEquals("Elementin text degeri esit degil",assertName,expectedName);
    }

    public void newTab(int tabNumber){

        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabNumber));
        System.out.println("============ Seklemelerden "+tabNumber+" Indeksinde ki Sekmeye Geçiş Yapıldı ============");
    }

    public void newScroll(){

        js.executeScript("window.scrollBy(0,1000)");
        System.out.println("============ Scroll Yapıldı ============");
    }



}