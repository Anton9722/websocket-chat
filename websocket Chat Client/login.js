let goToRegBtn = document.getElementById("goToRegBtn")
let loginBtn = document.getElementById("loginBtn")
let logUsername = document.getElementById("logUsername")
let logPassword = document.getElementById("logPassword")


goToRegBtn.addEventListener("click", () => {
    window.location.href ="registration.html"
})

loginBtn.addEventListener("click", (event) => {
    event.preventDefault()
    fetch("http://localhost:8080/user/login", {
        method: "POST",
        headers: {
            'Content-Type': 'application/json',
        },
    
        body: JSON.stringify( {
            username: logUsername.value,
            password: logPassword.value
        })
    })
    .then(res => res.json())
    .then(data => {
        console.log(data);
        
    })
})