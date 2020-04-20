package com.github.m0levich.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DepositInfoPage extends BasePage{

    public static String checkHeader(){
        String s = $(By.xpath("//h2[@class='kit-heading kit-heading_l product-teaser-full-width__header'][1]")).innerText();
        return s;
    }
}
