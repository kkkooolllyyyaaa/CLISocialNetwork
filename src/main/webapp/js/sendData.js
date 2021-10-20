async function sendData(data) {
    return await fetch("http://localhost:8080/fork-2.0-SNAPSHOT/ServletController", {
        method: "POST",
        headers: {
            "Content-Type": "Application/json"
        },
        body: JSON.stringify(data)
    });
}