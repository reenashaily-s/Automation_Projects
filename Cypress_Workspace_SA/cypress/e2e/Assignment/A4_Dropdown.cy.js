describe('Assignment 4: Testing Dropdown Functionality', () => 
{
  it('should select and verify date of birth dropdowns', () => 
  {
    cy.visit('https://register.rediff.com/register/register.php?FormName=user_details')  
    cy.get('select[name^="DOB_Day"]').select('05')   
    cy.get('select[name^="DOB_Day"]').should('have.value', '05')
    cy.get('select[name^="DOB_Month"]').select('AUG') 
    cy.get('select[name^="DOB_Month"] option:selected').should('have.text', 'AUG')
  })
})