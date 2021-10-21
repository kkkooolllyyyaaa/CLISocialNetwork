async function sendData(data) {
    return await fetch("http://localhost:8080/CLISocialNetwork-1.0-SNAPSHOT/controller", {
        method: "POST",
        headers: {
            "Content-Type": "Application/json"
        },
        body: JSON.stringify(data)
    });
}