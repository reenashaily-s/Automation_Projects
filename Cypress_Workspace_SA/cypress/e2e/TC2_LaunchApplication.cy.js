describe("Launch of Application", ()=>
{
    it("This is google launch", ()=>
        {
            //open application --> cy.visit("url")
            cy.visit("https://www.google.com/");

            //to get current url
        })

    it("this is Amazon Launch", ()=>
        {
            cy.visit("https://www.amazon.in/");
        })
})