import (nightmare);

$(document).ready(function(){
    init();
});
function init(){
    enable();
}
function enable(){


    $("#searchbtn").on("click", function(event){
        event.preventDefault();


        var searchText = $("#searchForItem").val();
        var searchCity = $("#searchByCity").val();


        var Nightmare = require('nightmare');
        var nightmare = Nightmare({show: true});

        nightmare
            .goto('https://offerup.com/#offers')
            .wait('input.ss-search opa-less[name=\'q\']')
            .type('input[name=\'q\']', searchText)
            .wait(1000)
            .wait('input.left#ou-location')
            .type('input.left#ou-location', searchCity)
            .wait(2000)
            .click('a#search-submit-button')
            .wait(3000)
            .evaluate(function (response, done) {
                var deliveryError = document.querySelector('.errorText')
                if (deliveryError) {
                    return deliveryError.innerHTML;
                } else {
                    return 'Here are your search results!!'
                }
            })
            .end()
            .then(function (response) {
                console.log(response);
                renderSearchResults(response.data)
            })
            .catch(function (error) {
                console.error('Search failed:', error);
        });
        $("#searchForItem").val("");
        $("#searchByCity").val("");
    });

}

function renderSearchResults(dataArray){
    $(".container").empty();

    for(var i = 0 ; i < dataArray.length; i++){
        $(".container").append("<h1>Results</h1>" +
            "<url src='" + dataArray[i].data + "'/>");
    }
}

function goHowItWorksPage(){
    window.location.href = "/howitworks"
}
function goValidationPage(){
    window.location.href = "/validation"
}
function goAlertsPage(){
    window.location.href = "/alerts"
}
function goRegisterPage(){
    window.location.href = "/register"
}
function goSearchPage(){
    window.location.href = "/search"
}
function goResultsPage() {
    window.location.href = "/results"
}
function goAboutPage(){
    window.location.href = "/about"
}
function goHomePage(){
    window.location.href = "/"
}