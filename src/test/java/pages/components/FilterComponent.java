package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class FilterComponent {
    private final SelenideElement
            genresDropDownMenuElement = $(".filtersDesktop__plank-item_count_5:first-child"),
            ratingDropDownMenuElement = $(".filtersDesktop__plank-item_count_5:last-child"),
            resetFiltersButtonElement = $(".filtersDesktop__button");

    public void openGenresDropDownMenu(){
        genresDropDownMenuElement.click();
    }
    public void setRating(String rating){
        ratingDropDownMenuElement.click();
        $x("//ul[@class='filterDropdown__list']//div[contains(text(), '" +
                rating + "')]").click();


    }

    public void setGenreByCarousel(String genre) {
        $x("//div[@class='filterDropdown__carousel-item']//div[text()='" +
                genre + "']").click();  //After selecting becomes Xpath class='filterDropdown__carousel-item checked']

    }

    public void setGenreByList(String genre) {

        $x("//div[@class='filterDropdown__input-text'][contains(text(), '" +
                genre + "')]").click();
    }

    public void setSausageListOption(String option){
        $x("//div[@class='sausage__title'][contains(text(), '" +
                option + "')]").click();
    }



    public void resetFilters(){
        resetFiltersButtonElement.click();
    }


}
