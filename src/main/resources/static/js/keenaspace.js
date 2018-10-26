var urls = {
    availableSeatsLocation: "http://localhost:5000/seats"
};

var getAvailableSeats = function () {
    $.ajax({
        url: urls.availableSeatsLocation + "?location=Hyderabad&floor=12",
        method: "GET",
        success: function (data) {
            var tableBody = "";
            data.forEach(function (element) {
                tableBody = tableBody + "<tr>";
                tableBody = tableBody + "<td>" + element.seatId + "</td>";
                tableBody = tableBody + "<td>" + element.managerName + "</td>";
                tableBody = tableBody + "<td><a class=\"ui-btn ui-corner-all\">Reserve</a></td>";
                tableBody = tableBody + "</tr>";
            });
            $("#table-custom-2").append(tableBody);
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