
		function validatesub(){
			 var z = document.forms["subjects"]["sid"].value;

			if(!/^[0-9]+$/.test(z)){
				alert("Invalid student id");
				//document.subjects.sid.focus();
			}
			 var chkd = document.subjects.sub1.checked || document.subjects.sub2.checked||document.subjects.sub3.checked;

			if (!chkd){
				alert("Please check atleast one checkbox");
				
					}
		}
		
		
		function validate(){
			var name=document.enrollmentform.name.value;
		 if (!/^[a-zA-Z]*$/g.test(name)||name.length<2) {
				alert("Invalid student name");
				document.students.name.focus();
				return false;
				}
		
		var x=document.enrollmentform.email.value;  
		var atposition=x.indexOf("@");  
		var dotposition=x.lastIndexOf(".");  
		if (atposition<1 || dotposition<atposition+2 || dotposition+2>=x.length){  
			alert("Please enter a valid e-mail address");  
			return false; 
		}
		 var dob = document.forms["enrollmentform"]["dob"].value;
		 var pattern = /^((0[1-9]|[12][0-9]|3[01])(\/)(0[13578]|1[02]))|((0[1-9]|[12][0-9])(\/)(02))|((0[1-9]|[12][0-9]|3[0])(\/)(0[469]|11))(\/)\d{4}$/;
		if (dob == null || dob == "" || !pattern.test(dob)) {
        alert("Invalid date of birth");
        return false;
    }
   
}
