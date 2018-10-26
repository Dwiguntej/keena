var urls = {
    availableSeatsLocation: "http://localhost:5000/",
    serverLocation: "http://localhost:5000/"
};

var userDetails = {};


$(document).ready(function () {
    getEmployeeDetails();
    $(".se-pre-con").fadeOut("slow");

});

var getAvailableSeats = function () {
    var index = 0;
    $.ajax({
        url: urls.availableSeatsLocation + "seats?location=Hyderabad&floor=12",
        method: "GET",
        success: function (data) {
            if(data && data !=null) {
                var tableBody = "";
                data.forEach(function (element) {
                    tableBody = tableBody + "<tr>";
                    tableBody = tableBody + "<td>" + element.managerName + "</td>";
                    tableBody = tableBody + "<td>" + element.seatId + "</td>";
                    tableBody = tableBody + "<td><a id=\"" + index + "\" class=\"ui-btn ui-corner-all\" onclick=reserveSeat(\"" + element.seatId + "\",\"" + userDetails.employeeId + "\",\"" + index + "\")>Reserve</a></td>";
                    tableBody = tableBody + "</tr>";
                    index = index + 1;
                });
                $("#table-custom-2").append(tableBody);
            }
            console.log(data);
        },
        error: function (e) {
            console.log(e);
        }
    });
};

var reserveSeat = function (seatId, empId, index) {
    $(".se-pre-con").show('fast');
    var rowCount = $("#table-custom-2").length + 1;
    if (index) {
        $.ajax({
            url: urls.availableSeatsLocation + "reserveSeat?empId=" + empId + "&seatId=" + seatId,
            method: "POST",
            success: function (data) {
                $("#table-booked-seat-body").empty();
                $("#table-custom-2-body").empty();
                getAvailableSeats();
                getBookedSeatForMe();
                $('#booked-seat').show('slow');
                $(".se-pre-con").hide('fast');

            },
            error: function (e) {
                console.log(e);
                $(".se-pre-con").hide('fast');
            }
        });
    }
    else {

        $.ajax({
            url: urls.availableSeatsLocation + "unReserveSeat?empId=" + empId + "&seatId=" + seatId,
            method: "PUT",
            success: function (data) {
                $("#table-booked-seat-body").empty();
                $("#table-custom-2-body").empty();
                getAvailableSeats();
                getBookedSeatForMe();
                $('#dashboard').show('slow');
                $('#booked-seat').hide('slow');
                $(".se-pre-con").hide('fast');
            },
            error: function (e) {
                console.log(e);
                $(".se-pre-con").hide('fast');
            }
        });
    }

}

var getEmployeeDetails = function () {
    $.ajax({
        url: urls.serverLocation + "getEmployeeDetails",
        method: "GET",
        success: function (data) {
            userDetails = data;
            console.log(data);
            $("#welcome_message").html('Welcome ' + data.firstname + ' ' + data.lastname);

            getAvailableSeats();
            getBookedSeatForMe();
        },
        error: function (e) {
            console.log(e);
        }
    });
};

var getTeamMembers = function () {
    $.ajax({
        url: urls.serverLocation + "getTeamMembers?managerId=" + userDetails.managerId,
        method: "GET",
        success: function (data) {
            var divBody = "";
            data.forEach(function (element) {
                divBody = divBody + "<div class=\"ui-radio ui-mini\">"
                divBody = divBody + "<input type= \"radio\" name=\"radio-choice-v-" + element.id + "\" id=\"team-member-" + element.id + "\" value=\"" + element.id + "\">";
                divBody = divBody + "<label for=\"team-member-" + element.id + "\" class=\"ui-btn ui-corner-all ui-btn-inherit ui-btn-icon-left ui-radio-off ui-last-child\">" + element.firstname + " " + element.lastname + "</label>";
                divBody = divBody + "</input>";
                divBody = divBody + "</div>";
            });
            $("#team-member").append(divBody);
        },
        error: function (e) {
            console.log(e);
        }
    });
};

var getBookedSeatForMe = function () {
    $.ajax({
        url: urls.serverLocation + "reservedSeat?empId=" + userDetails.employeeId,
        method: "GET",
        success: function (data) {

            if(data && data !=null) {
                var tableBody = "";
                tableBody = tableBody + "<tr>";
                tableBody = tableBody + "<td>" + data.seat.employee.firstname + " " + data.seat.employee.lastname + "</td>";
                tableBody = tableBody + "<td>" + data.seat.id + "</td>";
                tableBody = tableBody + "<td><a class=\"ui-btn ui-corner-all\" onclick=reserveSeat(\"" + data.seat.id + "\",\"" + userDetails.employeeId + "\")>Unreserve</a></td>";
                tableBody = tableBody + "</tr>";
                $("#table-booked-seat").append(tableBody);
            }
            if(data && data !=null){
                $('#booked-seat').show('slow');
            } else{
                $('#booked-seat').hide('slow');
            }
        },
        error: function (e) {
            console.log(e);
        }
    });
}