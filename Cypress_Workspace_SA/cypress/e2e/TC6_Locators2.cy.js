describe("Test for Locators",()=>{


    it("Test For Orangehrm login",()=>{
        //open application
        cy.visit("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //username:CssSelector with attribute
        cy.get("input[name='username']").type("Admin");

        //password: cssSelector with atribute
        cy.get("input[placeholder='Password']").type("admin123");

        //login Button
        cy.get("button[type='submit']").click();

        //assertion
        cy.url().should("include","dashboard");

        //logout - classname
        cy.get("i.oxd-userdropdown-icon").click();

        //options
        //cy.contains("Logout").click();

        //parent with child
        cy.get("ul[role='menu']>li:nth-child(4)>a").click();


    })




})