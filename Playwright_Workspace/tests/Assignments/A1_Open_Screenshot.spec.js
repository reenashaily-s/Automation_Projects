import { test } from '@playwright/test';

test('Launch and Take Screenshot', async ({ page }) => {
  await page.goto('https://rahulshettyacademy.com/AutomationPractice/');
  await page.screenshot({ path: 'screenshot.png' });
});