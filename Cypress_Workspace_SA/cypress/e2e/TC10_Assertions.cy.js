describe("Test for Assertions",()=>
{
    it("Test for Inbuilt Assertion",()=>
    {
        cy.visit("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //url validation-->full match
        cy.url().should("eq","https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //url partial match
        cy.url().should("include","orangehrmlive");
        //title: exact match
        cy.title().should("eq","OrangeHRM");
        //title : partial match
        cy.title().should("include","HRM");
        //assert Webelement enable,visible,editable
        //element should be enabled
        cy.get("input[name='username']").should("be.enabled");
        //element should be visible
        cy.get("input[name='username']").should("be.visible");
        //enter user name and then test that data
        cy.get("input[name='username']").type("Priyanka");
        //validate entered valid value 
        cy.get("input[name='username']").should("have.value","Priyanka");

        //validate entered invalid value 
        //cy.get("input[name='username']").should("have.value","Jay");:assertion error
        
        /*
        and(): applicable for multiple assertions

        */
        cy.get("input[name='username']").should("be.enabled").and("be.visible").clear().type("Jay").should("have.value","Jay");
    })

    //explicit assertion

    it.only("Test for Explicit assertion",()=>
    {
        cy.visit("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        cy.get("input[name='username']").type("Amit");
        cy.get("input[name='username']").then(($username)=>
        {
            //get the current value of username:val()
            let value=$username.val();

            //TDD:assert()
            assert.equal(value,"Amit");

            //BDD:expect()
            expect(value).eq("Amit");


        })

    })

})