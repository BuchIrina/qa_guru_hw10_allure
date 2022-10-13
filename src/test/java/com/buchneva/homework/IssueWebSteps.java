package com.buchneva.homework;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class IssueWebSteps {

    @Test
    public void openMainPage(){
        open("https://github.com/");
    }

    @Test
    public void searchForRepository(String repo) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();
    }

    @Test
    public void clickOnRepositoryLink(String repo) {
        $(linkText(repo)).click();
    }

    @Test
    public void checkToIssueExists(String issue) {
        $(".UnderlineNav-body.list-style-none").shouldHave(text(issue));
    }
}
