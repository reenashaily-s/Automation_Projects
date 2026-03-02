import { test, expect } from '@playwright/test';

test('test', async ({ page }) => 
{
  await page.goto('https://automationplayground.com/crm/');
  await page.getByRole('link', { name: 'Sign In' }).click();
  await page.getByRole('textbox', { name: 'Enter email' }).click();
  await page.getByRole('textbox', { name: 'Enter email' }).fill('test@gmial.com');
  await page.getByRole('form').locator('div').filter({ hasText: 'Password' }).click();
  await page.getByRole('textbox', { name: 'Password' }).fill('test123');
  await page.getByRole('checkbox', { name: 'Remember me' }).check();
  await page.getByRole('button', { name: 'Submit' }).click();
  await page.getByRole('link', { name: 'Sign Out' }).click();
});