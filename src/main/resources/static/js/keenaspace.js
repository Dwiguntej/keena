var urls = {
    availableSeatsLocation: "https://keena-space.herokuapp.com/"
};

var getAvailableSeats = function () {
    $.ajax({
        url: urls.availableSeatsLocation + "?location=Hyderabad&floor=12",
        method: "GET",
        success: function (data) {
            var tableBody = "";
            data.forEach(function (element) {
                tableBody = "<tr>";
                tableBody = "<td>" + element.seatId + "</td>";
                tableBody = "<td>" + element.managerName + "</td>";
                tableBody = "<td><a class=\"ui-btn ui-corner-all\">Reserve</a></td>";
                tableBody = "</tr>";
            });
            $("#table-custom-2").html(tableBody);
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