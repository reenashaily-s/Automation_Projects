describe('Assignment 3: Authentication', () => 
{
  it('should log in with valid credentials', () => 
  {
    cy.visit('https://opensource-demo.orangehrmlive.com/web/index.php/auth/login')
    cy.get('input[name="username"]').type('Admin')
    cy.get('input[name="password"]').type('admin123')
    cy.get('button[type="submit"]').click()
    cy.url().should('include', '/dashboard/index')
    cy.get('.oxd-topbar-header-title').should('contain', 'Dashboard')
  })
})