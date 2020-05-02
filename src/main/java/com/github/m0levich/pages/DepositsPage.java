package com.github.m0levich.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class DepositsPage extends BasePage {

    public void selectTab(String tabName) {
        String selector = String.format("//a[.='%s']", tabName);
        $(By.xpath(selector)).click();
    }

    public static class TabSelectDeposit {

        public List<String> selectCheckBoxes() {
            switchTo().frame("iFrameResizer0");
            List<String> boxesName = new ArrayList();
            boxesName.addAll($$(By.xpath("//div[@id='depositSelection']/descendant::div[@class='kitt-checkbox__text']")).texts());
            switchTo().defaultContent();
            return boxesName;
        }

        public boolean checkDefaultInput() {
            closeCookieMessage();
            switchTo().frame("iFrameResizer0");
            boolean check = Boolean.parseBoolean($(By.xpath("//div[@id='depositSelection']/descendant::input[@data-test-id='checkbox_checkboxOnline']")).attr("aria-checked"));
            switchTo().defaultContent();
            return check;
        }

        public List<String> getResult() {
            switchTo().frame("iFrameResizer0");
            List<String> result = new ArrayList();
            result.addAll($$(By.xpath("//div[@id='depositSelection']/descendant::h3[@class='offered-products__header']")).texts());
            for (int i = 0; i < result.size(); i++) {
                for (String a : result.get(i).split(" ")) {
                    result.set(i, a);
                }
            }
            switchTo().defaultContent();
            return result;
        }

        public void clickInput(int i) {
            switchTo().frame("iFrameResizer0");
            String selector = String.format("//div[@id='depositSelection']/descendant::div[@class='kitt-checkbox__control'][%s]", i);
            $(By.xpath(selector)).click();
            switchTo().defaultContent();
        }

        public void transitionsToMoreDetails(String name) {
            switchTo().frame("iFrameResizer0");
            String selector = String.format("//h3[.='Вклад %s']/ancestor::div[@id='depositSelection']/descendant::span[.='Подробнее']", name);
            $(By.xpath(selector)).click();
            switchTo().window(1);
        }

        public static void closeCookieMessage(){
            SelenideElement cookieMessage = $(By.xpath("//a[@title='Закрыть предупреждение']"));
            if(cookieMessage.isDisplayed()){
                cookieMessage.click();
            }
        }

    }
}
