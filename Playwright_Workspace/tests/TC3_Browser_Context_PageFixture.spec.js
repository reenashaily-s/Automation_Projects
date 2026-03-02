
/*
Fixture in playwright it is an environment
1.Browser: Main Browser instance(Chromium,webkit,firefox)
2.Context: New Browser Context for Same main instance
3.Page: Within browser or context we are creating new tab
4.request: Its for API testing
*/

import {test,expect, chromium} from "@playwright/test";

//browser-->context--->page--->app
test("Test for browser fixture",async({browser})=>
{

    //Creates a new browser context. It won't share cookies/cache with other browser contexts.
    //from current browser open context
    let context1=await browser.newContext();

    //Creates a new page in the browser context.
    //from newcontxt open new page(tab1)
    let page1=await context1.newPage();

    //open application
    await page1.goto("https://www.google.com");

    //open new tab
    let page2=await context1.newPage();

    //open application
    await page2.goto("https://www.amazon.in");
    await page1.waitForTimeout(2000);
})


//context-->page--->app
test("Test for Context fixture",async({context})=>
{
    //from same context open new tab(page)
    let page1=await context.newPage();

    //create one more tab(page)
    let page2=await context.newPage();

    await page1.goto("https://www.facebook.com");
    await page2.waitForTimeout(1000);
    await page2.goto("https://www.google.com");
    await page2.waitForTimeout(2000);
})

//browser---Page-->app
test("Test browser to page fixture",async({browser})=>
{
    let page1=await browser.newPage();
    await page1.goto("https://www.amazon.in");
    await page1.waitForTimeout(2000);
})

//page
test("Test page fixture",async({page})=>
{
    await page.goto("https://www.google.com");
    await page.waitForTimeout(2000);
})

//launch chrome
test.only("Test for Chrome",async({browser})=>
{
    //returns browser instance
    browser=await chromium.launch({headless:false, channel:"chrome"});
    //new page
    let page=await browser.newPage();

    //open application
    await page.goto("https://www.facebook.com");
    await page.waitForTimeout(2000);
})
