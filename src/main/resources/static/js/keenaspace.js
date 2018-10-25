var urls = {
    availableSeatsLocation: "https://keena-space.herokuapp.com/"
};

var getAvailableSeats = function () {
    $.ajax({
        url: urls.availableSeatsLocation + "?location=Hyderabad&floor=12",
        method: "GET",
        success: function (data) {
            console.log(data);
        },
        error: function (e) {
            console.log(e);
        }
    });
};

$(document).ready(function () {
    getAvailableSeats();

});