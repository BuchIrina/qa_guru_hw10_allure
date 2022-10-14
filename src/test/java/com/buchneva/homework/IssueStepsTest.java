package com.buchneva.homework;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class IssueStepsTest {

    public static final String REPOSITORY = "BuchIrina/qa_guru_hw10_allure";
    public static final String ISSUES = "Issues";

    @Feature("Issue in repository")
    @Story("Issue exists")
    @Owner("BuchIrina")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Check to Issue tab exists for authorized user")
    @Test
    public void issueExistsInRepositoryLambdaTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open mind page", () -> {
            open("https://github.com/");
        });
        step("Search repository " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Click on the link of repository " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Check to " + ISSUES + " tab exists", () -> {
            $(".UnderlineNav-body.list-style-none").shouldHave(text(ISSUES));
        });
    }


    @Feature("Issue in repository")
    @Story("Issue exists")
    @Owner("BuchIrina")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Check to Issue tab exists for authorized user")
    @Test
    public void issueExistsInRepositoryAnnotatedTest() {
        IssueWebSteps steps = new IssueWebSteps();
        SelenideLogger.addListener("allure", new AllureSelenide());

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.checkToIssueExists(ISSUES);
    }
}
