package com.github.m0levich.blocks;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class NavigationMenu {

    public void selectMenu(String menuName) {
        String selector = String.format("//span[.='%s']", menuName);
        ($(By.xpath(selector))).hover();
    }

    public void selectSubMenu(String subMenuName) {
        String selector = String.format("//li[@class='lg-menu__sub-item']/a[.='%s']", subMenuName);
        $(By.xpath(selector)).click();
    }
}
