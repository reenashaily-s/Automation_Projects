import {test,expect} from "@playwright/test"

test("Test for select tag based dropdown",async({page})=>
{
    await page.goto("https://www.amazon.in/");
    await page.screenshot({path:"tests/Screennshots/Amazon.png"});
    await page.screenshot({path:"tests/Screennshots/FullPage.png",fullPage: true});

    //select dropdown locator:Visible text
    await page.locator("#searchDropdownBox").selectOption("Books");
    
    await page.waitForTimeout(1000);

    //select by label
    await page.locator("#searchDropdownBox").selectOption({label:"Computers & Accessories"});
    await page.waitForTimeout(1000);

    //select by value
    await page.locator("#searchDropdownBox").selectOption({value:"search-alias=digital-music"});
    await page.waitForTimeout(1000);

    //select by index
    await page.locator("#searchDropdownBox").selectOption({index:4});

    await page.waitForTimeout(2000);
})