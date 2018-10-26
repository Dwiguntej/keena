var urls = {
    availableSeatsLocation: "http://localhost:5000/"
};

var getAvailableSeats = function () {
    var index = 0;
    $.ajax({
        url: urls.availableSeatsLocation + "seats?location=Hyderabad&floor=12",
        method: "GET",
        success: function (data) {
            var tableBody = "";
            data.forEach(function (element) {
                tableBody = tableBody + "<tr>";
                tableBody = tableBody + "<td>" + element.seatId + "</td>";
                tableBody = tableBody + "<td>" + element.managerName + "</td>";
                tableBody = tableBody + "<td><a id=\"" + index + "\" class=\"ui-btn ui-corner-all\" onclick=reserveSeat(\"" + element.seatId + "\",36,\"" + index + "\")>Reserve</a></td>";
                tableBody = tableBody + "</tr>";
                index = index + 1;
            });
            $("#table-custom-2").append(tableBody);
            console.log(data);
        },
        error: function (e) {
            console.log(e);
        }
    });
};

var reserveSeat = function (seatId, empId, index) {
    if (document.getElementById(index).text == "Reserve") {
        $.ajax({
            url: urls.availableSeatsLocation + "reserveSeat?empId=" + empId + "&seatId=" + seatId,
            method: "POST",
            success: function (data) {
                document.getElementById(index).text = "Un-Reserve";
                document.getElementById(index).style.color = 'red';
            },
            error: function (e) {
                console.log(e);
            }
        });
    }
    else {

        $.ajax({
            url: urls.availableSeatsLocation + "unReserveSeat?empId=" + empId + "&seatId=" + seatId,
            method: "PUT",
            success: function (data) {
                document.getElementById(index).text = "Reserve";
                document.getElementById(index).style.color = '';
            },
            error: function (e) {
                console.log(e);
            }
        });
    }

}

$(document).ready(function () {
    getAvailableSeats();

});