
describe("Test for select based Dropdown",()=>
{
    it("This is for Amazon Dropdown",()=>
    {
        cy.visit("https://www.amazon.in/");

        //select by visible text
        cy.get("#searchDropdownBox").select("Apps & Games",{force: true});
        cy.wait(2500);

        //select by indexing
        cy.get("#searchDropdownBox").select(3,{force:true});
        cy.wait(2500);

        //select by value
        cy.get("#searchDropdownBox").select("search-alias=digital-text",{force:true});
    })
})