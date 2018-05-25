describe("describe is just a function", () => {
    let a = true;
    let b = new Object();
    b.name = 'Jasmine';
    b.type = "testing framework";

    let c = new Object();
    c.name = "Jasmine";
    c.type = 'testing framework';
    describe("suites can be nested", () => {
        it("should be true", () => {
            expect(a).toBe(true);
        });

        it("evaluates a deep equals on objects", () => {
            expect(b).toEqual(c);
        });
    });
});