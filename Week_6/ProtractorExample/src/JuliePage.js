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
    this.getMultiplication = function() {
        return element(by.xpath('/html/body/div/div/form/select/option[4]'));
    }
    this.getSubtraction = function() {
        return element(by.xpath('/html/body/div/div/form/select/option[5]'));
    }

    this.multiply = function(x, y) {
        this.getFirstOperand().sendKeys(x);
        this.getSecondOperand().sendKeys(y);
        this.getMultiplication().click();
        this.getGoButton().click();
    }

    this.division = function(x, y) {
        this.getFirstOperand().sendKeys(x);
        this.getSecondOperand().sendKeys(y);
        this.getDivision().click();
        this.getGoButton().click();
    }

    this.subtract = function(x, y) {
        this.getFirstOperand().sendKeys(x);
        this.getSecondOperand().sendKeys(y);
        this.getSubtraction().click();
        this.getGoButton().click();
    }

    this.modulus = function(x, y) {
        this.getFirstOperand().sendKeys(x);
        this.getSecondOperand().sendKeys(y);
        this.getModulo().click();
        this.getGoButton().click();
    }
}
module.exports = new JuliePage();