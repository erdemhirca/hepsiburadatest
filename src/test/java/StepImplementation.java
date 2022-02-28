

import com.thoughtworks.gauge.Step;

public class StepImplementation {

    public Methods methods;

    public StepImplementation(){
        methods = new Methods();
    }

    @Step("<key> elementine <By> degeri ile tikla")
    public void clickButton(String key,String by) {
        methods.clickElement(key,by);
    }

    @Step("<key> elementine <By> degeri ile <text>'ni yaz")
    public void sendKeys(String key,String by,String text) {
        methods.sendkeysElement(key,by,text);
    }

    @Step("<key> elementine <By> degeri ile listeden <index> indeksine tikla")
    public void clickListButton(String key,String by,int index) {
        methods.clickElements(key,by,index);
    }

    @Step("<key> elementinin <By> degerinde ki text <text> degerine esit mi?")
    public void assertTextEquals(String key,String by,String text) {
        methods.assertControl(key,by,text);
    }

    @Step("<saniye> saniye bekle")
    public void waitElement(int key) throws InterruptedException {
        Thread.sleep(key*1000);
        System.out.println(key+" saniye beklendi");
    }

    @Step("<number> sekmesine gecis yap")
    public void newTab(int number){
        methods.newTab(number);
    }

    @Step("Scroll yap")
    public void newTab(){
        methods.newScroll();
    }
}