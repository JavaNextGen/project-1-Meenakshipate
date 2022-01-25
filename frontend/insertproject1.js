const url = "http://localhost:3000/" //putting our base URL in a variable for cleaner code below
//eventually, we'll use this in our fetch requests and make calls to our server by appending endpoints

//add eventListeners to our buttons to give them functionality
//document.getElementById("getEmployeeButton").addEventListener("click", getEmployees);
document.getElementById("insertEmployeesButton").addEventListener("click", insertFunction);

//<label id="lbltipAddedComment"></label>


//this function will send the user-inputted login credentials to our server
async function insertFunction() {

    //gather the user inputs from the login inputs
    let ers_username = document.getElementById("ers_username").value;
    let ers_password = document.getElementById("ers_password").value;
    let user_first_name = document.getElementById("user_first_name").value;
    let user_last_name = document.getElementById("user_last_name").value;
    let user_email = document.getElementById("user_email").value;

    //we want to send the user/pass as JSON, so we need a JS object to send
    let reimbobj = {
        username: ers_username,
        password: ers_password,
        firstname: user_first_name,
        lastname: user_last_name,
        email: user_email,
        role_id: 11145,
         
    }

    console.log(reimbobj);
    //This object will reflect our DTO in Java... This is the data we want to transfer!

    //console.log(user)

    //fetch request to the server
    //remember the second parameter fetch can take? It's essentially for configuring our fetch request
    //fetch sends a GET by default, but this seconds parameter can change that and more!
    let response = await fetch (url + "employee", {

        method: "POST", //send a POST request (would be a GET if we didn't do this...)
        body: JSON.stringify(reimbobj), //turn our user object into JSON
        credentials: "include"
        //this last line will ensure that the cookie is captured (so that we can have a user session)
        //future fetches will also require this "include" value to send the cookie back
    });

    console.log(response); //userful for debug :)

    //control flow based on successful/unsuccessful login
    if(response.status === 201) {
        //wipe our login row and welcome the user 
        document.getElementById("formReq").innerText="successfully";
         //window.location.href= "mainproject1.html";   
    } else {
        document.getElementById("formReq").innerText="failed! Refresh the page";
    }


}