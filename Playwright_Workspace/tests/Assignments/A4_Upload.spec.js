import { test, expect } from '@playwright/test';
import path from 'path';

test('Assignment 4: Upload a File', async ({ page }) => {
  // 1. Navigate to the site
  await page.goto('https://testautomationpractice.blogspot.com/');

  // 2. Define the file path (relative to your root folder)
  const filePath = path.resolve('tests/testfile.txt');

  // 3. Locate the element
  const uploadInput = page.locator('#singleFileInput');
  
  // 4. Scroll to it and upload
  await uploadInput.scrollIntoViewIfNeeded();
  await uploadInput.setInputFiles(filePath);

  // 5. Verify the file name is present in the input field
  await expect(uploadInput).toHaveValue(/testfile.txt/);

  console.log("Success: File attached to #singleFileInput");
});