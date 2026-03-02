/*
Assertion
===============
Using assertion we can validate current status of application
In Playwright assertions we can add with the help of expect()

Types
===========
1.Hard Assertion
-----------------------
If assertion will fail then it will stop execution on that line
expect()

2.Soft Assertion
-------------------
If assertion will fail then it will continue execution and show error on fail assertion
expect.soft()

*/

import {test,expect} from "@playwright/test"

test("Test for Hard assertion",async({page})=>
{
    await page.goto("https://tutorialsninja.com/demo/index.php?route=account/login");

    //variable based
    let appTitle=await page.title();
    console.log("Application title is: "+appTitle);
    expect(appTitle).toEqual("Account Login");
    expect(appTitle).toContain("Login");

    let appUrl=page.url(); 
    console.log("Application url: "+appUrl);
    expect(appUrl).toEqual("https://tutorialsninja.com/demo/index.php?route=account/login");
    expect(appUrl).toContain("demo");       

    //page level: title/url
    await expect(page).toHaveTitle("Account Login");
    await expect(page).toHaveTitle(/Login/);
    
    await expect(page).toHaveURL("https://tutorialsninja.com/demo/index.php?route=account/login");
    await expect(page).toHaveURL(/demo/);

    //element level
    let emailId=page.locator("#input-email");

    //element visibility
    await expect(emailId).toBeVisible();

    //element is enabled?
    await expect(emailId).toBeEnabled();

    //element editability
    await expect(emailId).toBeEditable();

    //fill
    await emailId.fill("test@gmail.com");
    await expect(emailId).toHaveValue("test@gmail.com");

    //header for text
    let header=page.getByText("Returning Customer",{exact:true});
    await expect(header).toHaveText("Returning Customer");
    console.log("Header is: "+await header.innerText());

    //count
    let totalLinks=await page.locator("//footer//a").all();//16
    expect(totalLinks).toHaveLength(16);
    console.log("Total Count is: "+totalLinks.length);

    await page.waitForTimeout(2000);
})


test("Test for Soft assertion",async({page})=>
{
    await page.goto("https://tutorialsninja.com/demo/index.php?route=account/login");
    //variable based
    let appTitle=await page.title();
    console.log("Application title is: "+appTitle);
    expect.soft(appTitle).toEqual("Account Login");
    expect.soft(appTitle).toContain("Login");
    let appUrl=page.url(); 
    console.log("Application url: "+appUrl);
    expect.soft(appUrl).toEqual("https://tutorialsninja.com/demo/index.php?route=account/login");
    expect.soft(appUrl).toContain("demo");       

    //page level: title/url
    await expect.soft(page).toHaveTitle("Account Login");
    await expect.soft(page).toHaveTitle(/Login123/);
    await expect.soft(page).toHaveURL("https://tutorialsninja.com/demo/index.php?route=account/login");
    await expect.soft(page).toHaveURL(/demo/);

    //element level
    let emailId=page.locator("#input-email");

    //element visibility
    await expect.soft(emailId).toBeVisible();

    //element is enabled?
    await expect.soft(emailId).toBeEnabled();

    //element editability
    await expect.soft(emailId).toBeEditable();

    //fill
    await emailId.fill("test@gmail.com");
    await expect.soft(emailId).toHaveValue("test@gmail.com");

    //header for text
    let header=page.getByText("Returning Customer",{exact:true});
    await expect.soft(header).toHaveText("Returning Customer");
    console.log("Header is: "+await header.innerText());

    //count
    let totalLinks=await page.locator("//footer//a").all();//16
    expect.soft(totalLinks).toHaveLength(16);
    console.log("Total Count is: "+totalLinks.length);

    await page.waitForTimeout(2000);
})


test.only("Test for Checkbox assertion",async({page})=>
{
    await page.goto("https://the-internet.herokuapp.com/checkboxes");

    //checkbox 1 should be unchecked
    let checkbox1=page.locator("//input[@type='checkbox']").first();
    await expect(checkbox1).not.toBeChecked();

    //checkbox 2 should be checked
    let checkbox2=page.locator("//input[@type='checkbox']").last();
    await expect(checkbox2).toBeChecked();     
})