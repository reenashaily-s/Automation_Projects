
//import playwright library
import {test,expect} from "@playwright/test"

test("Test for Navigation commands",async({page})=>
{
    //open google application
    await page.goto("https://www.google.com");
    await page.waitForTimeout(1500);
    await page.screenshot({path:"tests/Screennshots/Google.png"});

    //open facebook application
    await page.goto("https://www.facebook.com");
    await page.screenshot({path:"tests/Screennshots/Facebook.png"});

    //Navigate back
    await page.goBack();

    //Navigate forward
    await page.goForward();

    //wait
    await page.waitForTimeout(1500);

    //refresh
    await page.reload();
    await page.waitForTimeout(2000);
})