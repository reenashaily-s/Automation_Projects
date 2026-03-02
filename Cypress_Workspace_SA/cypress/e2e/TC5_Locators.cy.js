describe("This is for Locator test",()=>
{
    it("Test for CRM Login and Logout",()=>
    {
        cy.visit("https://automationplayground.com/crm/");

        // 1. by visible text ---> contains()
        cy.contains("Sign In").click();   
        // #Assert
        // After click App navigate to login
        cy.url().should("include","login");

        //2. by CssSelector ---> id
        cy.get("#email-id").type("test@gmail.com");

        //3. by CssSelector with attribute
        cy.get("input[placeholder='Password']").type("test123");

        //checkbox: check() and uncheck()
        //by Css - id
        cy.get("#remember").check(); 

        //button:CssSelector with classnames
        cy.get("button.btn.btn-default.btn-primary").click();

        //assertion for navigation
        cy.url().should("include","customers");

        //logout
        cy.contains("Sign Out").click();

        //get the text
        //cy.get("//p").text(); its wrong technique

        // cy.xpath("//p[contains(text(),'CRM')]").then(($ele)=>
        // {
        //     cy.log("Result Text: "+$ele.text());
        // })

        cy.get("div.header-section>p").then(($ele)=>
        {
            cy.log("Result Text: "+$ele.text());
        })
    })
})