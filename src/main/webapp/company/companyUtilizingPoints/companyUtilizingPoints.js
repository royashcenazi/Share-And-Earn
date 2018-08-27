var inputID = document.getElementById("customer-id");
var inputPoints = document.getElementById("points");
var submitButton = document.getElementById("btnSubmit");

submitButton.addEventListener("click", function(){
	    if(inputID.value == '' || inputPoints.value == '')
	    {
	    	alert('Please fill up all fields.')
	    }

	    else
	    {
	    	//UPDATE DETAILS ON SERVER
	    }

});
