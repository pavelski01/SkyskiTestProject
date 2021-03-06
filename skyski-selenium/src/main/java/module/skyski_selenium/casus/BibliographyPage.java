package module.skyski_selenium.casus;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import module.skyski_selenium.fixture.TestCaseFixture;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public final class BibliographyPage extends TestCaseFixture
{
	@Test
    public void bibliographyPageShouldLoadAndU_ValidUrl_Success() 
    {
		super.resetScreen();
		super.adjustScreen();
		super.findAndClickElementByCss("#bibliography");
		super.titleNotAssertion("SKYski Project", "Unload home page");
		super.titleAssertion("SKYski Bibliography", "Load bibliography page");
		super.findAndClickElementByCss("form tfoot > tr > td > a");
		super.titleNotAssertion("SKYski Bibliography", "Unload bibliography page");
		super.titleAssertion("SKYski Project", "Load home page");
    }
	
	@Test
    public void bibliographyPageShouldChangeLanguage_PolishRussianEnglish_Success() 
    {
		super.resetScreen();
		super.adjustScreen();
		super.findAndClickElementByCss("#bibliography");
		super.titleNotAssertion("SKYski Project", "Unload home page");
		super.titleAssertion("SKYski Bibliography", "Load bibliography page");
		super.resetScreen();
		super.adjustScreen();
		super.findAndClickElementByCss("form > a:nth-of-type(2)");
		super.titleNotAssertion("SKYski Bibliography", "Unload bibliography page");
		super.titleAssertion("Bibliografia SKYski", "Load home bibliography in polish");
		super.findAndClickElementByCss("form > a:last-of-type");
		super.titleNotAssertion("Bibliografia SKYski", "Unload home bibliography in polish");
		super.titleAssertion("Библиография SKYski", "Load home bibliography in russian");
		super.findAndClickElementByCss("form > a:first-of-type");
		super.titleNotAssertion("Библиография SKYski", "Unload home bibliography in russian");
		super.titleAssertion("SKYski Bibliography", "Load home bibliography in english");
    }
	
	@Test
    public void bibliographyPageShouldSortByAuthors_AuthorsEnglishPolishRussian_Success() 
    {
		super.resetScreen();
		super.adjustScreen();
		super.findAndClickElementByCss("#bibliography");
		super.titleNotAssertion("SKYski Project", "Unload home page");
		super.titleAssertion("SKYski Bibliography", "Load bibliography page");
		super.resetScreen();
		super.adjustScreen();
		super.sortAssertion(
			"form table > thead > tr > td:nth-of-type(2) > a",
			"form table > tbody > tr:first-of-type > td:nth-of-type(2)",
			"form table > tbody > tr:last-of-type > td:nth-of-type(2)",
			false
		);		
		super.findAndClickElementByCss("form > a:nth-of-type(2)");
		super.titleNotAssertion("SKYski Bibliography", "Unload bibliography page");
		super.titleAssertion("Bibliografia SKYski", "Load home bibliography in polish");
		super.sortAssertion(
			"form table > thead > tr > td:nth-of-type(2) > a",
			"form table > tbody > tr:first-of-type > td:nth-of-type(2)",
			"form table > tbody > tr:last-of-type > td:nth-of-type(2)",
			false
		);
		super.findAndClickElementByCss("form > a:last-of-type");
		super.titleNotAssertion("Bibliografia SKYski", "Unload home bibliography in polish");
		super.titleAssertion("Библиография SKYski", "Load home bibliography in russian");
		super.sortAssertion(
			"form table > thead > tr > td:nth-of-type(2) > a",
			"form table > tbody > tr:first-of-type > td:nth-of-type(2)",
			"form table > tbody > tr:last-of-type > td:nth-of-type(2)",
			false
		);
    }
	
	@Test
    public void bibliographyPageShouldSortByTitles_TitlesEnglishPolishRussian_Success() 
    {
		super.resetScreen();
		super.adjustScreen();
		super.findAndClickElementByCss("#bibliography");
		super.titleNotAssertion("SKYski Project", "Unload home page");
		super.titleAssertion("SKYski Bibliography", "Load bibliography page");
		super.resetScreen();
		super.adjustScreen();
		super.sortAssertion(
			"form table > thead > tr > td:nth-of-type(3) > a",
			"form table > tbody > tr:first-of-type > td:nth-of-type(3)",
			"form table > tbody > tr:last-of-type > td:nth-of-type(3)",
			false
		);		
		super.findAndClickElementByCss("form > a:nth-of-type(2)");
		super.titleNotAssertion("SKYski Bibliography", "Unload bibliography page");
		super.titleAssertion("Bibliografia SKYski", "Load home bibliography in polish");
		super.sortAssertion(
			"form table > thead > tr > td:nth-of-type(3) > a",
			"form table > tbody > tr:first-of-type > td:nth-of-type(3)",
			"form table > tbody > tr:last-of-type > td:nth-of-type(3)",
			false
		);
		super.findAndClickElementByCss("form > a:last-of-type");
		super.titleNotAssertion("Bibliografia SKYski", "Unload home bibliography in polish");
		super.titleAssertion("Библиография SKYski", "Load home bibliography in russian");
		super.sortAssertion(
			"form table > thead > tr > td:nth-of-type(3) > a",
			"form table > tbody > tr:first-of-type > td:nth-of-type(3)",
			"form table > tbody > tr:last-of-type > td:nth-of-type(3)",
			false
		);
    }
	
	@Test
    public void bibliographyPageShouldSortByPlaceAndYearOfPublication_PlaceAndYearOfPublicationEnglishPolishRussian_Success() 
    {
		super.resetScreen();
		super.adjustScreen();
		super.findAndClickElementByCss("#bibliography");
		super.titleNotAssertion("SKYski Project", "Unload home page");
		super.titleAssertion("SKYski Bibliography", "Load bibliography page");
		super.resetScreen();
		super.adjustScreen();
		super.sortAssertion(
			"form table > thead > tr > td:nth-of-type(4) > a",
			"form table > tbody > tr:first-of-type > td:nth-of-type(4)",
			"form table > tbody > tr:last-of-type > td:nth-of-type(4)",
			false
		);		
		super.findAndClickElementByCss("form > a:nth-of-type(2)");
		super.titleNotAssertion("SKYski Bibliography", "Unload bibliography page");
		super.titleAssertion("Bibliografia SKYski", "Load home bibliography in polish");
		super.sortAssertion(
			"form table > thead > tr > td:nth-of-type(4) > a",
			"form table > tbody > tr:first-of-type > td:nth-of-type(4)",
			"form table > tbody > tr:last-of-type > td:nth-of-type(4)",
			false
		);
		super.findAndClickElementByCss("form > a:last-of-type");
		super.titleNotAssertion("Bibliografia SKYski", "Unload home bibliography in polish");
		super.titleAssertion("Библиография SKYski", "Load home bibliography in russian");
		super.sortAssertion(
			"form table > thead > tr > td:nth-of-type(4) > a",
			"form table > tbody > tr:first-of-type > td:nth-of-type(4)",
			"form table > tbody > tr:last-of-type > td:nth-of-type(4)",
			false
		);
    }
}
