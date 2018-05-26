let JuliePage = function() {

    this.navigateToPage = function() {
        browser.get("http://juliemr.github.io/protractor-demo/");
        browser.manage().window().maximize();
    }

    this.getPageTitle = function() {
        return browser.getTitle();
    }

    this.getHeader = function() {
        return element(by.tagName('h3'));
    }

    this.getFirstOperand = function() {
        return element(by.model('first'));
    }

    this.getSecondOperand = function() {
        return element(by.model('second'));
    }

    this.getGoButton = function() {
        return element(by.id('gobutton'));
    }

    this.getResult = function() {
        return element(by.className('ng-binding'));
    }

    this.getAddition = function() {
        return element(by.xpath('/html/body/div/div/form/select/option[1]'));
    }

    this.getDivision = function() {
        return element(by.xpath('/html/body/div/div/form/select/option[2]'));
    }

    this.getModulo = function() {
        return element(by.xpath('/html/body/div/div/form/select/option[3]'));
    }

    this.getMultiply = function() {
        return element(by.xpath('/html/body/div/div/form/select/option[4]'));
    }

    this.getSubtract = function() {
        return element(by.xpath('/html/body/div/div/form/select/option[5]'));
    }

    this.multiply = function(a, b) {
        this.getFirstOperand().sendKeys(a);
        this.getSecondOperand().sendKeys(b);
        this.getMultiply().click();
        this.getGoButton().click();
    }

    this.divide = function(a, b) {
        this.getFirstOperand().sendKeys(a);
        this.getSecondOperand().sendKeys(b);
        this.getDivision().click();
        this.getGoButton().click();
    }

    this.subtract = function(a, b) {
        this.getFirstOperand().sendKeys(a);
        this.getSecondOperand().sendKeys(b);
        this.getSubtract().click();
        this.getGoButton().click();
    }

    this.modulo = function(a, b) {
        this.getFirstOperand().sendKeys(a);
        this.getSecondOperand().sendKeys(b);
        this.getModulo().click();
        this.getGoButton().click();
    }

    this.results = function() {
        return element.all(by.repeater("result in memory"));
    }
}
module.exports = new JuliePage();