package com.github.m0levich.blocks;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class NavigationMenu {

    public void selectMenu(String menuName) {
        String selector = String.format("//span[.='%s']", menuName);
        Actions act = new Actions(getWebDriver());
        act.moveToElement($(By.xpath(selector))).perform();
    }

    public void selectSubMenu(String subMenuName) {
        String selector = String.format("//li[@class='lg-menu__sub-item']/a[.='%s']", subMenuName);
        $(By.xpath(selector)).click();
    }
}
