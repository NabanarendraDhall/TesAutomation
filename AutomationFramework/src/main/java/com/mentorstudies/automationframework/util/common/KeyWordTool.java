package com.mentorstudies.automationframework.util.common;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.mentorstudies.automationframework.TestRunner;
import com.mentorstudies.automationframework.exception.AutomationFrameworkException;
import com.mentorstudies.automationframework.exception.KeywordNotFoundException;

public class KeyWordTool {

	public static By getLocator(String testCaseName, String locatorName) throws AutomationFrameworkException {

		Map<String, String> keywordMap = TestRunner.keywordDetails.get(testCaseName);
		String keyWordValue = keywordMap.get(locatorName);
		if (keyWordValue == null) {
			throw new KeywordNotFoundException(locatorName);
		}
		if (keyWordValue.startsWith("id")) {
			return By.id(keyWordValue.substring(keyWordValue.indexOf(':') + 1));
			
		}

		if (keyWordValue.startsWith("className")) {
			 return By.className(keyWordValue.substring(keyWordValue.indexOf(':') + 1));
		}
		if (keyWordValue.startsWith("xpath")) {
			return By.xpath(keyWordValue.substring(keyWordValue.indexOf(':') + 1));
		}
		if (keyWordValue.startsWith("name")) {
			return By.name(keyWordValue.substring(keyWordValue.indexOf(':') + 1));
		}
		if (keyWordValue.startsWith("linkText")) {
			return By.linkText(keyWordValue.substring(keyWordValue.indexOf(':') + 1));
		}
		if (keyWordValue.startsWith("partialLinkText")) {
			return By.partialLinkText(keyWordValue.substring(keyWordValue.indexOf(':') + 1));
		}
		if (keyWordValue.startsWith("cssSelector")) {
			return By.cssSelector(keyWordValue.substring(keyWordValue.indexOf(':') + 1));
		}
		if (keyWordValue.startsWith("tagName")) {
			 return By.tagName(keyWordValue.substring(keyWordValue.indexOf(':') + 1));
		}

		throw new AutomationFrameworkException("Keyword Type Unknown [" + keyWordValue + "]");
	}

}
