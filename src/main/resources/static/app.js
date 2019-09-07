var ws;
var socket;

function connect() {
    socket = new SockJS('http://localhost:8080/greeting');
    ws = Stomp.over(socket);

    ws.connect({}, function (frame) {
        $('#disconnect').attr('disabled', false);
        ws.subscribe("/user/queue/errors", function (message) {
            alert("Error " + message.body);
        });

        ws.subscribe("/user/queue/messages", function (message) {
            showGreeting(message.body);
            console.log("server server yolladıı")
        });
    }, function (error) {
        alert("STOMP error " + error);
    });
}

function disconnect() {
    if (ws != null) {
        ws.disconnect(function () {
            $('#disconnect').attr('disabled', true);
        });
    }
}

function sendName() {
    if (!(ws.readyState === WebSocket.CLOSED))
        ws.send("/app/greeting", {}, $("#name").val());
    // ws.send($("#name").val());
}

function showGreeting(message) {
    $("#greetings").append(" " + message + "");
}