package com.buchneva.homework;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideIssueTest {

    @Feature("Issue in repository")
    @Story("Issue exists")
    @Owner("BuchIrina")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Check to Issue tab exists for authorized user")
    @Test
    public void issueExistsInRepositoryTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("BuchIrina/qa_guru_hw10_allure");
        $(".header-search-input").submit();
        $(linkText("BuchIrina/qa_guru_hw10_allure")).click();
        $(".UnderlineNav-body.list-style-none").shouldHave(text("Issues"));
    }
}
