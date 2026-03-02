/*
spec --- suite --- describe --- it
*/



describe ("this is suite1", ()=>
{
    it("tc1", ()=>
        {
            cy.log("this is tc1");
            cy.visit("https://www.google.com/");            
        })

    it("tc2", ()=> 
        {
            cy.log("This is tc2");
            cy.visit("https://www.amazon.in/");           
        })

})
 