describe("Test for Navigation in Cypress",()=>
{
    it("Test for Amazon navigation",()=>
    {
        cy.visit("https://www.amazon.in/");

        //variable
        cy.title().then((appTitle)=>
        {
            cy.log(appTitle);
        })

        cy.contains("Mobiles").click();

        cy.title().then((appTitle)=>
        {
            cy.log(appTitle);
        })

        //back
        cy.go("back");
        cy.title().should("include","Online");
        cy.wait(2000);

        //forward
        cy.go("forward");
        cy.title().should("include","Phone");
        cy.wait(2000);

        //refresh: reload()
        cy.reload();
    })
})
