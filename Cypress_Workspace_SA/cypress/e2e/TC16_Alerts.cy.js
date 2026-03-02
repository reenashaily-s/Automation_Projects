describe("Automate Alerts",()=>
{
    /*
    Cypress automatically handle any simple type of alert
    */

    it("Automate simple alert direct by cypress",()=>
    {
        cy.visit("https://the-internet.herokuapp.com/javascript_alerts");

        //to open simple alert click on button
        cy.get("li>button").first().click();

        //alert will open and handled
        //assertion
        cy.get("#result").should("have.text","You successfully clicked an alert");
    })


    it("Automate simple alert by cypress event",()=>
    {
        cy.visit("https://the-internet.herokuapp.com/javascript_alerts");

        //to open simple alert click on button
        cy.get("li>button").first().click();

        //alert  event
        cy.on("window:alert",(alert1)=>
        {
            //alert message you can confirm
            expect(alert1).to.equal("I am a JS Alert");
        })

        //assertion
        cy.get("#result").should("have.text","You successfully clicked an alert");

    })


    it("Automate Confirmation alert cancel button by cypress event",()=>
    {
        cy.visit("https://the-internet.herokuapp.com/javascript_alerts");

        //to open simple alert click on button
        cy.get("li>button").eq(1).click();

        //alert  event for cancel button click
        cy.on("window:confirm",()=>false);
    
        //assertion
        cy.get("#result").should("have.text","You clicked: Cancel");

    })

    it.only("Automate Prompt alert by cypress stubbing process",()=>
    {
        cy.visit("https://the-internet.herokuapp.com/javascript_alerts");

        //before openining alert take control of prompt window
        cy.window().then((win)=>
        {
            //win is variable
            cy.stub(win,"prompt").returns("Hello All");

        })

        //to open simple alert click on button
        cy.get("li>button").last().click();

        //alert will open and handle

        //assert
        cy.get("#result").should("have.text","You entered: Hello All");

    })
})