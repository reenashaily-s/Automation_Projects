describe("Test File upload scenario",()=>
{
    it("Test File Upload",()=>
    {
        cy.visit("https://the-internet.herokuapp.com/upload");

        //select the file
        cy.get("#file-upload").selectFile("C:/Users/piyun/OneDrive/Desktop/Appiumsetup.txt");
        cy.get("#file-submit").click();
        cy.wait(1500);
        cy.get("div.example>h3").should("have.text","File Uploaded!");
    })
})