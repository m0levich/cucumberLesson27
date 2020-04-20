package com.github.m0levich.cucumber.stepdefinitions;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.m0levich.pages.BasePage;
import com.github.m0levich.pages.DepositInfoPage;
import com.github.m0levich.pages.DepositsPage;
import com.github.m0levich.pages.MainPage;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;

public class Sberbank {

    @BeforeMethod
    public void initDriver() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        Configuration.startMaximized = true;
    }

    @Когда("перейти на {string}")
    public void goToPage(String string) {
        open(string);
    }

    @Тогда("название страницы {string}")
    public void namePageCheck(String string) {
        title().contains(string);
    }

    @Когда("Перейти через верхнее меню во {string}")
    public void goToPageDeposit(String string) {
        BasePage basePage = new MainPage();
        basePage.getNavigationMenu().selectMenu(string);
        basePage.getNavigationMenu().selectSubMenu(string);
    }

    @Тогда("название новой страницы {string}")
    public void newNamePageCheck(String string) {
        title().contains(string);
    }

    @Тогда("Перейти на вкладку {string}")
    public void goToTab(String string) {
        DepositsPage depositPage = new DepositsPage();
        depositPage.selectTab(string);
    }

    @Тогда("Установлен чекбокс «Онлайн». Отображаются 4 чек-бокса")
    public void checkTabSelectionDeposit(List<String> list) {
        DepositsPage.TabSelectDeposit tab = new DepositsPage.TabSelectDeposit();
        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(list, tab.selectCheckBoxes());
        }
        Assert.assertTrue(tab.checkDefaultInput());
    }

    @Тогда("Отображается 3 вклада")
    public void checkDefaultResult(List<String> list) {
        DepositsPage.TabSelectDeposit tab = new DepositsPage.TabSelectDeposit();
        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(tab.getResult(), list);
        }
    }

    @Тогда("Выбрать чек-боксы Хочу снимать и Хочу пополнять")
    public void choiceInput() {
        DepositsPage.TabSelectDeposit tab = new DepositsPage.TabSelectDeposit();
        tab.clickInput(1);
        tab.clickInput(2);
    }

    @Тогда("Остался только 1 вклад")
    public void checkResult(List<String> list) {
        DepositsPage.TabSelectDeposit tab = new DepositsPage.TabSelectDeposit();
        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(tab.getResult(), list);
        }
    }

    @Тогда("Нажать на кнопку Подробнее вклада {string}")
    public void transitionsOnMoreDetails(String nameDeposit) {
        DepositsPage.TabSelectDeposit.transitionsToMoreDetails(nameDeposit);
    }

    @Тогда("В новом окне открылось окно с названием {string}")
    public void checkNewTitle(String string) {
        title().contains(string);
    }

    @Тогда("На странице отображается надпись {string}")
    public void checkHeader(String string) {
        Assert.assertEquals(DepositInfoPage.checkHeader(), string);
    }
}
