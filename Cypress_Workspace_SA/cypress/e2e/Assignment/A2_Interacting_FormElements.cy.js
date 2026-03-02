//Interacting with Form Elements

describe('Assignment 2: Rediff Registration', () => 
    {
    it('should fill and submit', () => 
        {
            cy.visit('https://register.rediff.com/register/register.php?FormName=user_details');
            cy.get('input[name^="name"]').type('John Doe');
            cy.get('#Register').click();
            cy.on('window:alert', (str) => 
            {
                expect(str).to.equal('Your login ID cannot be blank');
        });
    });
});