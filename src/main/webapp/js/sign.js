function connect() {
    let login = document.querySelector("#login-form").value
    let password = document.querySelector("#password").value

    const reqBody = new RequestBody({

        login: login,
        password: password,
        option: "sign_in"
    })

    sendData(reqBody).then(data => console.log(data))
}


