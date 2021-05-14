package com.qa.mma.selenium.homepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

	public final static String URL = "http://localhost:";
	
	private WebDriver driver;
	
	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="addFighterButton")
	private WebElement addButton;
	
	@FindBy(id="searchFighterButton")
	private WebElement searchButton;
	
	@FindBy(className="del")
	private WebElement deleteButton;
	
	@FindBy(className="edit")
	private WebElement updateButton;
	
	@FindBy(css="body>p:nth-child(1)")
	private WebElement topFighter;
	
	@FindBy(id="searchName")
	private WebElement searchName;
	
	@FindBy(id="confirmSearch")
	private WebElement confirmSearchButton;
	
	@FindBy(id="name")
	private WebElement addName;
	
	@FindBy(id="age")
	private WebElement addAge;
	
	@FindBy(id="wins")
	private WebElement addWins;
	
	@FindBy(id="losses")
	private WebElement addLosses;
	
	@FindBy(id="draws")
	private WebElement addDraws;
	
	@FindBy(id="no-contests")
	private WebElement addNCs;
	
	@FindBy(id="confirmAdd")
	private WebElement confirmAddButton;
	
	@FindBy(id="update-name")
	private WebElement updateName;
	
	@FindBy(id="update-age")
	private WebElement updateAge;
	
	@FindBy(id="update-wins")
	private WebElement updateWins;
	
	@FindBy(id="update-losses")
	private WebElement updateLosses;
	
	@FindBy(id="update-draws")
	private WebElement updateDraws;
	
	@FindBy(id="update-no-contests")
	private WebElement updateNCs;
	
	@FindBy(id="confirmUpdate")
	private WebElement confirmUpdateButton;

	public WebElement getAddButton() {
		return addButton;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getDeleteButton() {
		return deleteButton;
	}

	public WebElement getUpdateButton() {
		return updateButton;
	}

	public WebElement getTopFighter() {
		return topFighter;
	}

	public WebElement getSearchName() {
		return searchName;
	}

	public WebElement getConfirmSearchButton() {
		return confirmSearchButton;
	}

	public WebElement getAddName() {
		return addName;
	}

	public WebElement getAddAge() {
		return addAge;
	}

	public WebElement getAddWins() {
		return addWins;
	}

	public WebElement getAddLosses() {
		return addLosses;
	}

	public WebElement getAddDraws() {
		return addDraws;
	}

	public WebElement getAddNCs() {
		return addNCs;
	}

	public WebElement getConfirmAddButton() {
		return confirmAddButton;
	}

	public WebElement getUpdateName() {
		return updateName;
	}

	public WebElement getUpdateAge() {
		return updateAge;
	}

	public WebElement getUpdateWins() {
		return updateWins;
	}

	public WebElement getUpdateLosses() {
		return updateLosses;
	}

	public WebElement getUpdateDraws() {
		return updateDraws;
	}

	public WebElement getUpdateNCs() {
		return updateNCs;
	}

	public WebElement getConfirmUpdateButton() {
		return confirmUpdateButton;
	}
	
	public void search(String name) {
		searchButton.click();
		searchName.sendKeys(name);
		confirmSearchButton.click();
	}
	
	public void add(String name, int age, int wins, int losses, int draws, int NCs) {
		addButton.click();
		addName.sendKeys(name);
		addAge.sendKeys(String.valueOf(age));
		addWins.sendKeys(String.valueOf(wins));
		addLosses.sendKeys(String.valueOf(losses));
		addDraws.sendKeys(String.valueOf(draws));
		addNCs.sendKeys(String.valueOf(NCs));
		confirmAddButton.click();
	}
	
	public void update(String name, int age, int wins, int losses, int draws, int NCs) {
		updateButton.click();
		updateName.sendKeys(name);
		updateAge.sendKeys(String.valueOf(age));
		updateWins.sendKeys(String.valueOf(wins));
		updateLosses.sendKeys(String.valueOf(losses));
		updateDraws.sendKeys(String.valueOf(draws));
		updateNCs.sendKeys(String.valueOf(NCs));
		confirmUpdateButton.click();
	}
	
}
