package org.singleDesignPattern.abstractComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

//contains abstract and non-abstract methods
//contains re-usable methods, can be used in all other classes
public abstract class AbstractComponent
{
    WebElement sectionElement;

    public AbstractComponent(WebDriver driver, By flights)
    {
        this.sectionElement=driver.findElement(flights);
    }

    public WebElement findElement(By findElement)
    {
        return sectionElement.findElement(findElement);
    }

    public List<WebElement> findElements(By findElements)
    {
        return sectionElement.findElements(findElements);
    }
}
