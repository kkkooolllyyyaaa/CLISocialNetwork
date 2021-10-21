$('.terminal').terminal({

    echo: function (string) {
        this.echo(string)
    },

    // show your contacts:

    contacts: function () {
        contacts_command = new Command("contactsCommand", "")
        sendData(contacts_command).then(response => console.log(response))
    },

    // send message to another user
    send: function (reciever, message) {
        send_command = new Command("sendCommand", reciever + " " + message)
        sendData(send_command).then(response => console.log(response))
    },

    profile: function () {
        const res = $(".visual")
        //profile_command = new Ommand("profileCommand", "")
        //sendData(profile_command).then(response => console.log(response))

        let div1 = $("<div><div>")
        let img = $("<img class='profile-img' src='imgs/4082.jpg'>")
        let info = $("<p class='user-name'><strong>USERNAME:</strong>  @lsdkgjsdg <br><br> <strong>BIO:</strong> At vero eos et accusamus et iusto odio dignissimos At vero eos et accusamus et iusto odio dignissimos At vero eos et accusamus et iusto odio dignissimos<p>")
        let mobile = $("<p class='user-name'><strong>MOBILE: </strong>+44 535 323 5326<p>")

        div1.append(img)
        div1.append(info)
        div1.append(mobile)
        res.append(div1)
    },

    logout: function () {
        document.cookie = "command=logout"
        document.cookie = "option="


        console.log(document.cookie)
        sendData("").then(response => console.log(response));

    }

})