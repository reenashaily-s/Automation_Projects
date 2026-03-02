import {test, expect} from "@playwright/test"
import { log } from "console";

test("test for title and url validation", async({page})=>
{
    //open application
    await page.goto("https://tutorialsninja.com/demo/index.php?route=account/register");

    //to get title
    let appTitle = await page.title();
    console.log("Application Titile is: "+appTitle);
    
    //to get url
    let appUrl = page.url();
    console.log("Application Url is: "+appUrl);

    //validation : page level assertions

    //---current title assertion - full match
    await expect(page).toHaveTitle("Register Account");
    //current url assertion - full match
    await expect(page).toHaveURL("https://tutorialsninja.com/demo/index.php?route=account/register")

    //---partial match - regular expression
    await expect(page).toHaveTitle(/Account/);
    await expect(page).toHaveURL(/https/);

    await page.waitForTimeout(2000);

    //Validation : variable
    
    expect(appTitle).toEqual("Register Account");
    //partial match
    expect(appTitle).toContain("Account");
        
})
