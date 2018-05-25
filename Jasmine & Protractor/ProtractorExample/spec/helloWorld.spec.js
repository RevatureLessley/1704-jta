describe("Protractor uses the Jasmine syntax by default", () => {
    describe("browser is a global variable used for browser level operations", () => {
        beforeAll(() => {
            // browser.get() makes a GET request to the supplied URL
            browser.get("http://juliemr.github.io/protractor-demo/");

            // Maximizes the browser window
            browser.manage().window().maximize();
        });

        let header = element(by.tagName('h3'));


        it("should navigate to the correct page", () => {
            expect(browser.getTitle()).toBe('Super Calculator');
        });

        it("should have the correct header", () => {
            expect(header.getText()).toBe('Super Calculator');
        });
    });
});