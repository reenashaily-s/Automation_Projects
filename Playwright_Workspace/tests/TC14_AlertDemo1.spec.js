import {test,expect} from "@playwright/test"

test("Alert autodimissed by playwright test",async({page})=>
{
    await page.goto("https://mail.rediff.com/cgi-bin/login.cgi");

    //click on button
    await page.getByRole("button",{name:"Log In"}).click();

    //alert will open and  automatically handle by playwright
    //enter email
    await page.locator("#login1").fill("test1234");
    await page.waitForTimeout(2000);
})

/*
Playwright autodismiss alerts
We can test/trigger it by listener Page.on()
It provides 4 methods
-------------------------
1.OK--->To simulate action of ok ==>accept()
2.Cancel--->To simulate action of cancel ==>dismiss()
3.To get alert text: message()
4.To get the type of alert : type()
5.prompt alert automate using accept("prompt")
*/

test.only("Alert handling through listener",async({page})=>
{
    page.on("dialog",async(alertBox)=>
    {
        console.log("Alert text is: "+alertBox.message());
        console.log("Type of alert : "+alertBox.type());

        //ok
        await alertBox.accept();
        
     })
    await page.goto("https://mail.rediff.com/cgi-bin/login.cgi");

    //click on button
    await page.getByRole("button",{name:"Log In"}).click();

    //alert will open
    //enter email
    await page.locator("#login1").fill("test1234");
    await page.waitForTimeout(2000);
})