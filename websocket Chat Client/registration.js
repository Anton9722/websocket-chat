let goToLoginBtn = document.getElementById("goToLoginBtn")
let createUser = document.getElementById("createUser")
let = regUsername = document.getElementById("regUsername")
let = regPassword = document.getElementById("regPassword")


goToLoginBtn.addEventListener("click", () => {
    window.location.href ="login.html"
})

createUser.addEventListener("click", (event) => {
    event.preventDefault()

    fetch("http://localhost:8080/user/create", {
        method: "POST",
        headers: {
            'Content-Type': 'application/json',
        },
    
        body: JSON.stringify( {
            username: regUsername.value,
            password: regPassword.value
        })
    })
    .then(res => res.json())
    .then(data => {
        alert("user created")
    })
})
