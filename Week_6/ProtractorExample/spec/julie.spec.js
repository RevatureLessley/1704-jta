describe("Page Object Models can also be leveraged in Protractor", () => {

    let julie = require("../src/JuliePage.js");

    beforeAll(() => {
        julie.navigateToPage();
    });

    describe("This spec is much cleaner than helloWorld.spec.js", () => {
        it("should navigate properly", () => {
            expect(julie.getPageTitle()).toBe("Super Calculator");
        });

        it("should say Super Calculator", () => {
            expect(julie.getHeader().getText()).toBe('Super Calculator')
        });

        // it("should fail", () => {
        //     expect(false).toBeTruthy();
        // });
    });

    describe("Super Calculator performs addition well", () => {
        it("should add 10 and 20 properly", () => {
            julie.getFirstOperand().sendKeys(10);
            julie.getSecondOperand().sendKeys(20);
            julie.getGoButton().click();
            expect(julie.getResult().getText()).toBe('30');
        })
    });

    describe("Super Calculator performs addition well", () => {
        it("should add 4 and 6 properly", () => {
            julie.getFirstOperand().sendKeys(4);
            julie.getSecondOperand().sendKeys(6);
            julie.getAddition().click();
            julie.getGoButton().click();
            expect(julie.getResult().getText()).toBe('10');
        });
    });

    describe("Who even understands modulus???", () => {
        it("should return 1", () => {
            julie.modulus(10,3);
            expect(julie.getResult().getText()).toBe('1');
        });
    });

})