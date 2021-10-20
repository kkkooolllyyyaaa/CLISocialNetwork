let ws;

function connect() {

    let username = document.getElementById("username").value;
    let host = document.location.host;
    let pathname = document.location.pathname;

    console.log(host + "     " + pathname)

    ws = new WebSocket("ws://" +host  + pathname + "chat/" + username);

    ws.onmessage = function (event) {
        let log = document.getElementById("log")
        console.log(event.data)
        let message = JSON.parse(event.data)
        log.innerHTML += message.from + " : " + message.content + "\n"
    }
}


function send() {
    let content = document.getElementById("msg").value;
    let json = JSON.stringify({
        "content":content
    });

    ws.send(json);
}