import {test,expect} from "@playwright/test"

test("Test for Redbus dropdown",async({page})=>
{
    await page.goto("https://www.redbus.in/");

    //from dropdown
    await page.locator("#srcinput").fill('Hyderabad');
    await page .waitForTimeout(1000);

    let allOptions=await page.locator("(//div[contains(@class,'searchCa')])[1]//div[contains(@class,'listItem')]//div[contains(@class,'listHeader')]").all();
    console.log("Total options are : "+allOptions.length);

    for(let ele of allOptions)
    {
        console.log(await ele.innerText());
        if((await ele.innerText()).includes("Hinje Wadi, Pune"))
        {
            await ele.click();
            break;
        }     
    }
    await page.waitForTimeout(2000);
})