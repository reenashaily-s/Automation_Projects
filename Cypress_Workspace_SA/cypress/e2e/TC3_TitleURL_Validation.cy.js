describe("This is for basic title and url assertion",()=>
    {
        it("Validate Google title and url for valid data ",()=>
            {
                cy.visit("https://www.google.com/");
                cy.title().should("eq","Google");//exact match

                //get the current url and do assert it
                cy.url().should("eq","https://www.google.com/");//exact match

                //partial match
                cy.url().should("include","google.com");    
            })

        it("Validate Google title and url for invalid data",()=>
            {
                cy.visit("https://www.google.com/");
                cy.url().should("include","www.google.com/");//pass
                cy.title().should("eq","Google");
            })
    })