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


var changeAvailability = function (emailId) {
    getEmployeeDetails(emailId);
};
var getEmployeeDetails = function (emailId) {
    $.ajax({
        url: urls.availableSeatsLocation + "getEmployeeDetails?emailId=" + emailId,
        method: "GET",
        success: function (data) {

            console.log(data);
            getTeamMembers(data.manager.id)
        },
        error: function (e) {
            console.log(e);
        }
    });
};

var getTeamMembers = function (managerId) {
    $.ajax({
        url: urls.availableSeatsLocation + "getTeamMembers?managerId=" + managerId,
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