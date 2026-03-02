describe("Test for Hooks",()=>
{

    before(()=>
    {
        cy.log("Before() executes only one time before all test cases")
        cy.visit("https://automationplayground.com/crm/");
    })


    beforeEach(()=>
    {
        cy.log("BeforeEach() executes before every test case");
        cy.url().then((appUrl)=>
        {
            cy.log(appUrl);
        })

        //signIn
        cy.get("#SignIn").click();
    })

    afterEach(()=>
    {
        cy.log("AfterEach() executes after every test case");
        cy.title().then((appTitle)=>
        {
            cy.log("Application title is: "+appTitle);
        })
    })

    it("Login with Valid credentials",()=>
    {
        //email 
        cy.get("#email-id").type("test@gmail.com");
        //password
        cy.get("#password").type("test123");
        //click
        cy.get("#submit-id").click();
    })
})