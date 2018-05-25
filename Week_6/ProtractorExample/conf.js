exports.config = {
    // This is the default address for WenDriver-Manager
    seleniumAddress: "http://localhost:4444/wd/hub",

    // specs thakes an array of where your tests are located
    specs: ['./spec/julie.spec.js'],

    // Specifies the different browser capabilities
    // capabilities: {
    //     browserName: 'firefox'
    // }

    // Use the multiCapabilities property to specify capabilities for multiple browsers
    // multiCapabilities: [
    //     {
    //         browserName: 'chrome'
    //     },{
    //         browserName: 'firefox'
    //     }
    // ]

}