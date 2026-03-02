//import playwright library
import {test} from "@playwright/test"
import { log } from "console";

//TC
test("This is test1", async({page})=>
{
    //open application
    await page.goto("https://www.google.com");
    console.log("this is google page");

    //get the title
    let appTitile = await page.title();
    console.log("Application Titile is: "+appTitile);    
})