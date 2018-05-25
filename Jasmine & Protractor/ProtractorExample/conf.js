exports.config = {
    // This is the default address for WebDriver-Manager
    seleniumAddress: "http://localhost:4444/wd/hub",

    // specs takes an array of where your tests are located
    specs: ['./spec/julie.spec.js'],

    // Specifies the different browser capabilities
    capabilities: {
        browserName: 'chrome'
    }

    // User the multiCapabilities property to specify capabilities for multiple browsers
    // multiCapabilities: [
    //     {
    //         browserName: 'chrome'
    //     },
    //     {
    //         browserName: 'firefox'
    //     }
    // ]
}