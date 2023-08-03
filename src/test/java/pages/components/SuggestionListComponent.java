package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SuggestionListComponent {
    private final SelenideElement
            suggestionListElement = $x("//ul[@class='suggestion__list']"),
            freeCategoryElement = $x("//a[@href='/movies/all?paid_type=avod']");

    public void setCategory(String category){
        $x("//span[contains(text(), '" + category + "')]").click();

    }
    public void setCategoryFree(){
        freeCategoryElement.click();
    }

    public SelenideElement getSuggestionListElement() {
        return suggestionListElement;
    }
}
