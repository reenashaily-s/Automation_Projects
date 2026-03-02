import { test } from '@playwright/test';

test('Handle JS Alerts', async ({ page }) => {
  await page.goto('https://rahulshettyacademy.com/AutomationPractice/');

  // Listener for dialogs
  page.on('dialog', async dialog => {
    console.log(`Message: ${dialog.message()}`);
    await dialog.accept();
  });

  await page.fill('#name', 'Reena');
  await page.click('#alertbtn');
});