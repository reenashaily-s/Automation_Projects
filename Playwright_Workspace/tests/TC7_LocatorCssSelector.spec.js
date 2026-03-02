/*
How to automate any webelement
====================================
We use locator to identify and perform actions on that element

What is Locator?
=====================
Locator is address of webelement from that webpage

Playwright support 3 locators strategy
--------------------------------------
1.BuiltIn locator
2.CssSelector
3.xpath

2.CssSelector(default)
=========================
-CssSelector it is locator to identify element based on 
element css property
-CssSelector are faster than xpath
as csssElector travel in one directon (parent--->child)

    i)   tagname with id
    ii)  tagname with attribute
    iii) tagname with class

    tagname with id
    --------------------
    Syntax:
    =========
    tagname#id

    example:
    <input id="test">
    input#test
    or
    #test

    2.tagname with attribute
    ------------------------
    syntax:
    ===========
    tagname[attribute='value']
    example
    ---------------
    input[placeholder='Search']

    3.tagname with classname
    -----------------------------
    Syntax:
    =========
    tagname.classname

    example
    --------------
    button.oxd-button

*,^,$
==============
id="twotabsearchtextbox"

1.partial match *
--------------------
Syntax:
========
tagname[attribute*='partial value']

input[id*='searchtext']

2. Starts-with(^):prefix value
--------------------
Syntax:
============
tagname[attribute^='prefix value']

input[id^='two']

3.EndsWith($):suffix value
------------------------------
Syntax:
============
tagname[attribute$='suffix value']

input[id$='box']

parent to child 
-------------------
space
------------
parenttag chiltag : direct +indirect child
aside a------13 elements
>
-------
parenttag>childtag : direct child
div.list-group>a ------13 elements

how to use indexing in css selector
-------------------------------------
Parent>child:nth-child(index of dom)

div.list-group>a:nth-child(7)----1 of 1


*/

import {test,expect} from "@playwright/test"

test("test App with CssSelector locator",async({page})=>
{
    await page.goto("https://tutorialsninja.com/demo/index.php?route=account/login");

    //email: tagname with id
    await page.locator("input#input-email").fill("test2525@gmail.com");

    //password: tagname with attribute
    await page.locator("input[type='password']").fill("test123");

    //login button: tagname with classname
    await page.locator("input.btn.btn-primary").click();


    // get the text into console: textContent()/ innerText()
    // let text=await page.getByText("My Account",{exact:true}).innerText();
    let text=await page.locator("//h2[text()='My Account']").innerText();
    console.log("Text Is: "+text);
    await page.waitForTimeout(2000);
})