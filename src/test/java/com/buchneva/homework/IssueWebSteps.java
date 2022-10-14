package com.buchneva.homework;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class IssueWebSteps {

    @Step("Open mind page")
    public void openMainPage(){
        open("https://github.com/");
    }

    @Step("Search repository {repo}")
    public void searchForRepository(String repo) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();
    }

    @Step("Click on the link of repository {repo}")
    public void clickOnRepositoryLink(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Check to {issue} tab exists")
    public void checkToIssueExists(String issue) {
        $(".UnderlineNav-body.list-style-none").shouldHave(text(issue));
    }
}
