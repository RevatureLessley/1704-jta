describe("a five function calculator should do five things well", () => {

    let calc;

    beforeEach(function () {
        calc = new Calculator();
    });

    describe("addition functionality is hard to break", () => {
        let a = 10;
        let b = 12.5;
        let c = 3;
        it("should add 10 and 3 properly", () => {
            expect(calc.add(a, c)).toBe(13);
        });
        it("should add 12.5 and 10 properly", () => {
            expect(calc.add(a, b)).toBeCloseTo(22.4, 0);
        });
    });

    describe("division can lead to some....... interesting...... conclusions", () => {
        let a = 0;
        let b = -0;
        let c = 15;
        let d = 3;
        it("should divide 3 into 15 properly", () => {
            expect(calc.divide(c, d)).toBe(5);
        });
        it("should evaluate to Positive Infinity", () => {
            expect(calc.divide(c, a)).toBePositiveInfinity();
        });
        it("should evaluate to Negative Infinity", () => {
            expect(calc.divide(d, b)).toBeNegativeInfinity();
        });
    });

    describe("factorials have an incredible growth rate", () => {
        it("a factorial of 1 should be 1", () => {
            expect(calc.factorial(1)).toBe(1);
        }); 
        it("a factorial of 0 should be 1", () => {
            expect(calc.factorial(0)).toBe(1);
        });
        it("a factorial of 5 should be 120", () => {
            expect(calc.factorial(5)).toBe(120);
        });
        it("should fail when given a negative factorial", () => {
            expect(calc.factorial(-15)).toThrow(new Error("cannot compute a negative factorial"));
        });
    });

});