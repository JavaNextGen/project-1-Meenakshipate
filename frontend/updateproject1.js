const url = "http://localhost:3000/" //putting our base URL in a variable for cleaner code below
//eventually, we'll use this in our fetch requests and make calls to our server by appending endpoints

//add eventListeners to our buttons to give them functionality
document.getElementById("getallEmployeeButton").addEventListener("click", getEmployees);
document.getElementById("getEmployeeButton").addEventListener("click",getupdateEmployees);
document.getElementById("getdenyButton").addEventListener("click", getdenyEmployees);


async function getEmployees() {
let e_stp = document.getElementById("ers_reimbursement").value;
    //we will send a fetch request to get our employee data
    //by default, fetch requests send GET requests
    let  uresponse = await fetch(url + "status/" + e_stp,{credentials:"include"});

    //logging the response in the console just to see the response object
    console.log(uresponse);

    //control flow for is the request is successful
    if(uresponse.status === 201){

        let datap = await uresponse.json(); //parse the JSON data from the response into a JS object

        //logging the actual employee data that has been parsed from JSON -> JS
        console.log(datap);

        //For every Employee object we got back (stored in the data variable), put it in the table
        for(let employee of datap){

            //create a table row
            let row = document.createElement("tr");

            //create a data cell for each employee field
            let cell = document.createElement("td");
            //fill the cell with the appropriate employee data
            cell.innerHTML = employee.id;
            //add the td element (data cell) to the tr element (table row)
            row.appendChild(cell);

            //we'll do this^ for every column in employees

          let cell2 = document.createElement("td");
            cell2.innerHTML = employee.amount;
            row.appendChild(cell2);

            let cell3 = document.createElement("td");
            cell3.innerHTML = employee.submitted;
            row.appendChild(cell3);

            let cell4 = document.createElement("td");
            cell4.innerHTML = employee.receipt;
            row.appendChild(cell4);

            let cell5 = document.createElement("td");
            cell5.innerHTML = employee.statusid;
            row.appendChild(cell5);

            let cell6 = document.createElement("td");
            cell6.innerHTML = employee.typeid;
            row.appendChild(cell6);

            //append the tr called row that we created in the for loop to the table body
            //a new row will be appended for every employee object that comes in
            document.getElementById("ReimbursementBody").appendChild(row);
        }
    }
}
//remember, async returns a promise (which fetch request return)
    async function getupdateEmployees() {
    let ids = document.getElementById("reimb_id").value;
   // let reimb_description = document.getElementById("reimb_description").value;
   // let reimb_author = document.getElementById("reimb_author").value;
    //let reimb_status_id = document.getElementById("reimb_status_id").value;
  //  let reimb_type_id = document.getElementById("reimb_type_id").value;

    //we want to send the user/pass as JSON, so we need a JS object to send
    let reimbobj = {
        id: ids,
        amount: 0,
        description:"1",
        author: 5,
        statusid: 1,
        typeid: 1145,
         
    }

   // console.log(reimbobj);

    //we will send a fetch request to get our employee data
    //by default, fetch requests send GET requests
    let reimb_id = document.getElementById("reimb_id").value;
    let response = await fetch(url + "allemployee/" + reimb_id,{
    method: "PUT", 
    body: JSON.stringify(reimbobj), 
    credentials: "include"
     } );
    //logging the response in the console just to see the response object
    console.log(response);

    //control flow for is the request is successful
    if(response.status === 201){
      document.getElementById("formReq").innerText="Successfully";
    }else{
        document.getElementById("formReq").innerText= "failed! Refresh the page";
    }
  }

    async function getdenyEmployees() {

      let idt = document.getElementById("denyreimb_id").value;
     
      let reimbobj = {
          id: idt,
          amount: 0,
          description:"1",
          author: 5,
          statusid: 2,
          typeid: 1145,
           
      }
  
     // console.log(reimbobj);
  
      //we will send a fetch request to get our employee data
      //by default, fetch requests send GET requests
      let reimb_id = document.getElementById("denyreimb_id").value;
      let response = await fetch(url + "allemployee/" + reimb_id,{
      method: "PUT", 
      body: JSON.stringify(reimbobj), 
      credentials: "include"
       } );
      //logging the response in the console just to see the response object
      console.log(response);
  
      //control flow for is the request is successful
      if(response.status === 201){
        document.getElementById("formReq").innerText="Successfully";
      }else{
          document.getElementById("formReq").innerText= "failed! Refresh the page";
      }
        }
    
      

    
