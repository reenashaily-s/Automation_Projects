import { test, expect } from '@playwright/test';

test('Verify Login Dashboard with oxd-text class', async ({ page }) => {
  await page.goto('https://opensource-demo.orangehrmlive.com/web/index.php/auth/login');

  // Login steps
  await page.getByPlaceholder('Username').fill('Admin');
  await page.getByPlaceholder('Password').fill('admin123');
  await page.click('button[type="submit"]');

  const dashboardHeader = page.locator('.oxd-text', { hasText: 'Dashboard' }).first();
  
  // Verify it is visible
  await expect(dashboardHeader).toBeVisible();

  console.log("Dashboard verified using oxd-text class!");
});