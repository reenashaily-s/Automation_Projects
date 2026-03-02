describe("This is for Multiple Webelements ",()=>
{
    it.skip("Test for Register page list",()=>
    {
        cy.visit("https://tutorialsninja.com/demo/index.php?route=account/register");

        //list of options
        cy.get("div.list-group>a").each(($ele)=>
        {
            cy.log("Option Name: "+$ele.text()); // prints all the elements in the list

            // present or not? if yes --> click
            if($ele.text().includes("Forgotten Password"))
            {
                //click on link
                cy.wrap($ele).click();
            }
        })
    })

    //test2
    it.skip("Automate Google search scenario",()=>
    {
        cy.visit("https://www.google.com/");
        cy.get("#APjFqb").type("Java");

        //wait for 2sec In Selenium Thread.sleep(2000)
        cy.wait(1500);
        //list
        cy.get("ul[role='listbox']>li div[role='presentation']>span").each(($option)=>
        {     
            cy.log($option.text());   
        })
    })

    //test3
    it.skip("Test for Total Links",()=>
    {
        cy.visit("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        cy.get("a").each(($link)=>
            {
                let linkText=$link.text();
                cy.log("Text is: "+linkText);
                //to get the attribute value attr() in Selenium We have getDomAttribute('attribute name')
                cy.log($link.attr('href'));
            })

    })

/*
Assignment
goto https://www.freshworks.com/ application and capture all footers print it in console
*/
    //test3
    it.only("Test for Total Links", () => 
    {
        cy.visit("https://www.freshworks.com/company/about/");
    
        // Fixed locator: added 'a' to target the links inside the div
        cy.get("#__next > footer > div > div:nth-child(2) a").each(($link) => 
        {
            let linkText = $link.text().trim(); // Added trim() for cleanliness
            cy.log("Text is: " + linkText);
            
            // This will now work because $link is an <a> tag
            cy.log("URL is: " + $link.attr('href'));
        });
});

    // it.only("Test for Total Links in Footer", () => 
    // {
    //     cy.visit("https://www.freshworks.com/company/about/");
    //     // Target the specific footer column and then all anchor tags within it
    //     cy.get("#__next footer div:nth-child(2) a").each(($el) => 
    //     {
    //         const linkText = $el.text().trim();
    //         const href = $el.prop('href'); // .prop('href') gives the full URL; .attr('href') gives the literal string

    //         cy.log(`Text: ${linkText}`);
    //         cy.log(`URL: ${href}`);
    //     });
    // });




})