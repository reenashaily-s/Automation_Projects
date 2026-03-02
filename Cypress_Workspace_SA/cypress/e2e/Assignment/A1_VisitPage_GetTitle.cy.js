//Write a test to visit a webpage and verify its title.

describe('Assignment 1: Navigation', () => 
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
    })