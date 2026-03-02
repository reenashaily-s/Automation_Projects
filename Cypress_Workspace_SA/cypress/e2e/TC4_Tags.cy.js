//suite 1
describe("This is suite1",()=>
    {
        it("Launch for crm application",()=>
            {
                cy.visit("https://automationplayground.com/crm/");
                cy.title().should("include","Service");
            })

        it.skip("Launch for opencart application",()=>
            {
                cy.visit("https://tutorialsninja.com/demo/index.php?route=account/register");
                cy.title().should("include","Account");
            })

        it("Launch for Orangehrm application",()=>
            {
                cy.visit("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
                cy.title().should("eq","OrangeHRM");

            })

    })

//suite 2
describe.only("This is suite2",()=>
{
    it('Test for google application',()=>
        {
            cy.visit("https://www.google.com");
            cy.title().should("eq","Google");
        })
})


