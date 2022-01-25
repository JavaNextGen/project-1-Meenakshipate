const url = "http://localhost:3000/" //putting our base URL in a variable for cleaner code below
//eventually, we'll use this in our fetch requests and make calls to our server by appending endpoints

//add eventListeners to our buttons to give them functionality
//document.getElementById("getEmployeeButton").addEventListener("click", getEmployees);
document.getElementById("insertEmployeesButton").addEventListener("click", insertrmFunction);

//<label id="lbltipAddedComment"></label>


//this function will send the user-inputted login credentials to our server
async function insertrmFunction() {

    //gather the user inputs from the login inputs
    let reimb_amout = document.getElementById("reimb_amout").value;
    let reimb_description = document.getElementById("reimb_description").value;
    let reimb_author = document.getElementById("reimb_author").value;
   // let reimb_status_id = document.getElementById("reimb_status_id").value;
    let reimb_type_id = document.getElementById("reimb_type_id").value;

    //we want to send the user/pass as JSON, so we need a JS object to send
    let reimbobj = {
        amount: reimb_amout,
        description: reimb_description,
        author: reimb_author,
        statusid: 0,
        typeid: reimb_type_id,
         
    }

    console.log(reimbobj);
    //This object will reflect our DTO in Java... This is the data we want to transfer!

    //console.log(user)

    //fetch request to the server
    //remember the second parameter fetch can take? It's essentially for configuring our fetch request
    //fetch sends a GET by default, but this seconds parameter can change that and more!
    let response = await fetch (url + "allemployee", {

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