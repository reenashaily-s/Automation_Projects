import { test } from '@playwright/test';

test('Count hyperlinks on page', async ({ page }) => {
  await page.goto('https://testautomationpractice.blogspot.com/');

  const links = page.locator('a');
  const count = await links.count();
  
  console.log(`Total links found: ${count}`);
});