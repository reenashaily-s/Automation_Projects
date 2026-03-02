/*
what is Xpath
==================
path of webelement from html/xml file

Types
===========
1.Absolute Xapth
--------------------
- Identify element from root node
-starts with '/'

/html/body/div[2]/div/div/div/div[2]/div/form/div[1]/input

2.Relative Xpath
----------------
- Identify element by its relative property
- startswith '//'

//*[@id="input-email"]
* any 

Syntax:
==========
//tagname[@attribute='value']

xpath with index
===================
Syntax:
===========
(xpath)[index number]

or
====
(xpath)[position=index]


xpath Methods
===================
1.text():It is applicable for visible text,but it never ignore white space
==============
Syntax:
---------------
//tagname[text()='visibile text']

2.normalize-space():It is applicable for visible text and It ignore white space as well(trim())
-----------------------
Syntax:
---------------
//tagname[normalize-space()='visibile text']

3.contains()
=====================
Syntax:
=========
//tagname[contains(@attribute,'partial value')]

OR

//tagname[contains(text(),'partial text')]



4.starts-with()
=====================
Syntax:
=========
//tagname[starts-with(@attribute,'prefix value')]

OR

//tagname[starts-with(text(),'prefix text')]

*/

import {test,expect} from "@playwright/test"
test("Test for Xpath Locator",async({page})=>
{
    //open application
    await page.goto("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    //username
    await page.locator("//input[@name='username']").fill("Admin");

    //password
    await  page.locator("//input[@type='password']").fill("admin123");

    //click on Button
    await page.locator("//button[@type='submit']").click();

    //assertion(title/url for next page navigation)
    await expect(page).toHaveURL(/dashboard/);

    //wait
    await page.waitForTimeout(2000);
})

test("Test for xpath indexing",async({page})=>
{
    await page.goto("https://tutorialsninja.com/demo/index.php?route=account/register");

    //firstname
    await page.locator("(//input[@class='form-control'])[1]").fill("Kiran");

    //lastname
    await page.locator("(//input[@class='form-control'])[2]").fill("Bhati");

    //dynamic email id
    let time=new Date().getTime();
    let emailId="kiranbhati"+time+"@gmail.com";

    //email
    await page.locator("(//input[@class='form-control'])[3]").fill(emailId);

    //telephone
    await page.locator("(//input[@class='form-control'])[position()=4]").fill("9798676876");

    //password
    await page.locator("(//input[@class='form-control'])[position()=5]").fill("test123");

    //confirmpassword
    await page.locator("(//input[@class='form-control'])[position()=6]").fill("test123");

    //radio
    await page.locator("(//input[@type='radio'])[2]").click();

    //checkbox
    await page.locator("//input[@type='checkbox']").check();

    //continue
    await page.locator("//input[@value='Continue']").click();

    //assertion
    //header should  have value=Your Account Has Been Created!
    let header=page.locator("(//h1)[2]");
    await expect(header).toHaveText("Your Account Has Been Created!");
    console.log("SuccessMessage is: "+await header.innerText());
    
    await page.waitForTimeout(2000);

})


test.only("Test for Xpath Method",async({page})=>
{
    //open application
    await page.goto("https://www.amazon.in/");

    //click on Mobiles link: text()
    await page.locator("//a[text()='Mobiles']").click();

    //click on Cart option:normalize-space()
    await page.locator("(//span[normalize-space()='Cart'])[2]").click();

    //normalize-space()
    let text=await page.locator("//h3[normalize-space()='Your Amazon Cart is empty']").innerText();
    console.log("Cart Message is: "+text);

    //Enter keyword in search :contains()
    let searchBox=page.locator("//input[contains(@id,'searcht')]");
    await searchBox.fill("watch");

    //press enter key
    await searchBox.press('Enter');

    await page.waitForTimeout(1500);

    //starts-with()
    let searchele=page.locator("//input[starts-with(@id,'two')]");

    //clear the text
    await searchele.clear();

    //fill the text
    await searchele.fill("Bag");

    //press
    await searchele.press('Enter');
    await page.waitForTimeout(2000);
}) 