function validateSignUp()
{
	//alert("empty");
	var MyForm=document.forms[0];
	
	
	var loginid=MyForm.id;
	if(loginid.value.length==0 || loginid=="" || loginid==null)
	{
		alert("Please enter the loginid");
		loginid.focus();
		return false;
	}
	
	
	var pwd=MyForm.pass; 
	var passw=  /^[A-Za-z]\w{7,14}$/;  
	if(!(pwd.value.match(passw)))   
	{   
		alert('Please entered correct password...!')  
		return false;  
	}  
	
	
	
	var pwd=MyForm.pass;
	if(pwd.value.length==0 || pwd=="" || pwd==null)
	{
		alert("Please enter the password");
		pwd.focus();
		return false;
	}
	
	var name=MyForm.name;
	if(name.value.length==0 || name=="" || name==null)
	{
		alert("Please enter the name");
		name.focus();
		return false;
	}

	var address=MyForm.address;
	if(address.value.length==0 || address=="" || address==null)
	{
		alert("Please enter the address");
		address.focus();
		return false;
	}
	
	var city=MyForm.city;
	if(city.value.length==0 || city=="" || city==null)
	{
		alert("Please enter the city");
		city.focus();
		return false;
	}
	
	var pin=MyForm.pin;
	if(pin.value.length==0 || pin=="" || pin==null)
	{
		alert("Please enter the pin");
		pin.focus();
		return false;
	}
	
	var pinnum=/[0-9]/;
	if(!pin.value.match(pinnum))
	{
		alert("Please enter only numbers");
		pin.focus();
		return false;
	}
	
	
	var email=MyForm.email;
	if(email.value.length==0 || email=="" || email==null)
	{
		alert("Please enter the email");
		email.focus();
		return false;
	}
	
	var emailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;  
	if(!email.value.match(emailformat))  
	{  
		alert("You have entered an invalid email address!");  
		email.focus();  
		return false;  
	}  
		
	var pno=MyForm.cno;
	if(pno.value.length==0 || pno=="" || pno==null)
	{
		alert("Please enter the phone number");
		pno.focus();
		return false;
	}
	
	var pnonum=/[0-9]/;
	if(!cno.value.match(pnonum))
	{
		alert("Please enter only numbers");
		pno.focus();
		return false;
	}
		
	else
		return true;
  }


