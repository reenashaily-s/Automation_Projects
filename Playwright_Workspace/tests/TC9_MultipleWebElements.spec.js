import {test,expect} from "@playwright/test"
test("automate google search scenario",async({page})=>
{
    await page.goto("https://www.google.com/");

    //search for keyword
    //await page.locator("#APjFqb").fill("jenkins");
    await page.getByTitle("Search").fill("Jenkins");
    
    //wait
    await page.waitForTimeout(1000);

    let allOptions=await page.locator("(//ul[@role='listbox'])[1]//li").all();
    for(let ele of allOptions)
    {
        console.log(await ele.innerText());        
    }
    await page.waitForTimeout(2000);
})


test.only("Test for footers link",async({page})=>
{
    await page.goto("https://tutorialsninja.com/demo/index.php?route=account/login");

        //footer
        let allLinks=await page.locator("//footer//a").all();
        //let allLinks=await page.$$("//footer//a");
        console.log("Total Links are: "+allLinks.length);//16

        for(let ele of allLinks)
        {
            console.log(await ele.innerText());
            if((await ele.innerText()).includes("Privacy Policy"))
            {
                await ele.click();
                break;
            }     
        }   
        await page.waitForTimeout(2000);
})