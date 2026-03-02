describe("Test for Cypress Variables",()=>
{
    it("Test for Title and url with variable",()=>
    {
        cy.visit("https://www.google.com/");
        cy.screenshot("GooglePage.png");

        //get the title and store it into variable
        cy.title().then((appTitle)=>
        {  //here appTitle is my variable name
            cy.log("Application title is: "+appTitle);
        })

        //get the url and store it into variable and print 
        cy.url().then((appUrl)=>
        {  //here appUrl is variable name
            cy.log("Application url is: "+appUrl)

        })

        //for google search: store this element into variable and then type()
        //cy.get("#APjFqb").type("Jenkins");

        cy.get("#APjFqb").then(($searchEle)=>
        {  //here $searchEle is varibale name
            cy.wrap($searchEle).type("Jenkins");
        })   
    })
    
    it.only("Test for single element",()=>
    {
        cy.visit("https://tutorialsninja.com/demo/index.php?route=account/register");
        //cy.get("#input-firstname").type("Jay");
        //variable
        cy.get("#input-firstname").then(($fname)=>
        {
        //click
            cy.wrap($fname).click().type("Jay");
        })
    })
})