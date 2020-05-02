package com.github.m0levich.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DepositInfoPage extends BasePage{

    public static String checkHeader(){
        return $(By.xpath("//div[@class='kit-row'][1]/descendant::h2")).innerText();
    }
}
