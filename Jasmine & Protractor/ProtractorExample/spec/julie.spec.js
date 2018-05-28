describe("Page Object Models can also be leveraged in Protractor", () => {
    let julie = require("../src/JuliePage.js");
    let num = 0;
    beforeAll(() => {
        julie.navigateToPage();
    });
    describe("This spec is much cleaner than helloWorld.spec.js", () => {
        it("should navigate properly", () => {
            expect(julie.getPageTitle()).toBe("Super Calculator");
        });

        it("should say Super Calculator", () => {
            expect(julie.getHeader().getText()).toBe('Super Calculator');
        });
    });

    describe("this is a lazy suite", () => {
        afterEach(() => {
            num++;
        });
        describe("Super Calculator performs addition well", () => {
            it("should add 10 and 20 properly", () => {
                julie.getFirstOperand().sendKeys(10);
                julie.getSecondOperand().sendKeys(20);
                julie.getAddition().click();
                julie.getGoButton().click();
                expect(julie.getResult().getText()).toBe("30");
            });
        });

        describe("Super Calculator should perform division properly", () => {
            it("should divide 15 into 3", () => {
                julie.getFirstOperand().sendKeys(15);
                julie.getSecondOperand().sendKeys(3);
                julie.getDivision().click();
                julie.getGoButton().click();
                expect(julie.getResult().getText()).toBe('5');
            });
        });

        describe('Super Calculator ROCKS at multiplication', () => {
            it("should find the product of 10 and 20", () => {
                julie.multiply(10, 20);
                expect(julie.getResult().getText()).toBe('200');
            });
        });

        describe('Who even understand modulus???', () => {
            it("should return 1", () => {
                julie.modulo(10, 3);
                expect(julie.getResult().getText()).toBe('1');
            });
        });

        describe('Subtraction!!!! :D', () => {
            it("should be less than zero", () => {
                julie.subtract(9, 10);
                expect(julie.getResult().getText()).toBeLessThan(0);
            });
        });
    });
    describe('Our results should be properly stored', () => {
        it("should equal our num variable", () => {
            expect(julie.results().count()).toBe(num);
        });
    });
});