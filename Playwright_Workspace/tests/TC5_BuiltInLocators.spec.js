/*
These are the recommended built-in locators.

page.getByRole() to locate by explicit and implicit accessibility attributes.
page.getByText() to locate by text content.
page.getByLabel() to locate a form control by associated label's text.
page.getByPlaceholder() to locate an input by placeholder.

page.getByAltText() to locate an element, usually image, by its text alternative.
page.getByTitle() to locate an element by its title attribute.
page.getByTestId() to locate an element based on its data-testid attribute (other attributes can be configured).
*/

//import playwright library
import {test,expect} from "@playwright/test"

test("Test for Built In Locators for Playwright",async({page})=>
{
    //open application
    await page.goto("https://automationplayground.com/crm/");

    //getByRole()
    //await page.getByRole('link',{name:"Sign In"}).click();

    //getByText()
    await page.getByText("Sign In").click();

    //email: getByPlaceholder()
    await page.getByPlaceholder("Enter email").fill("test@gmail.com");

    //password: getByPlaceholder()
    await page.getByPlaceholder("Password").fill("test123");

    //checkbox: getByLabel()
    
    await page.getByLabel("Remember me").click();

    //submit button: getByrole()
    await page.getByRole('button',{name:"Submit"}).click();

    //validation for next page navigation

    await expect(page).toHaveURL(/customers/);
    await page.waitForTimeout(2000);

})

test.only("Test for getByAltText() & getByTestId() & getByTitle() locators",async({page})=>
{
    //open application
    await page.goto("https://www.facebook.com/");

    //highlight logo of facebook page alt="Facebook" getByAltText() applicable for alt attribute
    await page.getByAltText("Facebook").highlight();

    //email: getByTestId: data-testid="royal-email"
    await page.getByTestId("royal-email").fill("test@gmail.com");

    await page.waitForTimeout(1500);

    //scoll down
    // await page.evaluate(()=>{
    //     window.scrollTo(0,4000);
    // })

    await page.evaluate(()=>
    {
        window.scrollTo(0,document.body.scrollHeight);
    })

    await page.waitForTimeout(1000);
    
     //getByTitle(): title="Marathi" only for title attribute
    await page.getByTitle("Marathi").click();
    await page.waitForTimeout(2000);
})