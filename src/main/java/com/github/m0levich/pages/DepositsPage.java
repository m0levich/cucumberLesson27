package com.github.m0levich.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class DepositsPage extends BasePage {

    public void selectTab(String tabName) {
        String selector = String.format("//a[.='%s']", tabName);
        $(By.xpath(selector)).click();
    }
}
