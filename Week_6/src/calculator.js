var Calculator = function () {

    this.add = function (a, b) {
        return a + b;
    }

    this.subtract = function (a, b) {
        return a - b;
    }

    this.multiply = function (a, b) {
        return a * b;
    }

    this.divide = function (a, b) {
        return a / b;
    }

    this.factorial = function (a) {
        if (a < 0) {
            throw new Error("Cannot compute a negative factorial")
        }
        if (a === 1 || a === 0) {
            return 1;
        }
        return a * this.factorial(a - 1);
    }
}