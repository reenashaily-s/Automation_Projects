
describe("Test for Checkboxes and RadioButton",()=>
{
    it("Test for Current status of Checkbox",()=>
    {
        cy.visit("https://the-internet.herokuapp.com/checkboxes");

        //first()-first element match  ::last()-last element match:: eq(index)
        //first checkbox should be unchecked
        cy.get("input[type='checkbox']").first().should("not.be.checked");

        //second checkbox should be checked
        cy.get("input[type='checkbox']").last().should("be.checked");
    })


    it.only("Test for Radio button and checkbox",()=>
    {
        cy.visit("https://formy-project.herokuapp.com/form");

        //first button clicked
        cy.get("input[type='radio']").first().click();

        //second
        cy.get("input[type='radio']").eq(1).click();

        //last
        cy.get("input[type='radio']").last().click();

        cy.get("input[type='checkbox']").first().check();
        cy.get("input[type='checkbox']").last().check();
        cy.get("input[type='checkbox']").eq(1).check();

    })
})