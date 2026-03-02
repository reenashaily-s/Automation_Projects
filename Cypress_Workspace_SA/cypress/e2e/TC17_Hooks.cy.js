
describe("Test for Hooks",()=>
{

    before(()=>
    {
        cy.log("Before() executes only one time before all test cases")
    })

    after(()=>
    {
        cy.log("after() executes only once after all the test cases");
    })

    beforeEach(()=>
    {
        cy.log("BeforeEach() executes before every test case");
        cy.url().then((appUrl)=>
        {
            cy.log(appUrl);
        })
    })

    afterEach(()=>
    {
        cy.log("AfterEach() executes after every test case");
        cy.title().then((appTitle)=>{
            cy.log("Application title is: "+appTitle);
        })
    })


    it("This is my test case1",()=>
    {
        cy.visit("https://www.google.com");
        cy.log("This is test1")
    })


    it("This is my test case2",()=>
    {
        cy.visit("https://www.amazon.in");
        cy.log("This is test2")
    })

    it("This is my test case3",()=>
        {
            cy.visit("https://the-internet.herokuapp.com/upload");
        cy.log("This is test3");
    })
})