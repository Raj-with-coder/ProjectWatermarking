function validateSignUp()
{
	//alert("empty");
	var MyForm=document.forms[0];
	
	
	var loginid=MyForm.loginid;
	if(loginid.value.length==0 || loginid=="" || loginid==null)
	{
		alert("Please enter the loginid");
		loginid.focus();
		return false;
	}
	
	
	
	var pwd=MyForm.pwd;
	if(pwd.value.length==0 || pwd=="" || pwd==null)
	{
		alert("Please enter the password");
		pwd.focus();
		return false;
	}
	
	
	var compname=MyForm.compname;
	if(compname.value.length==0 || compname=="" || compname==null)
	{
		alert("Please enter the company name");
		compname.focus();
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
		
	var pno=MyForm.pno;
	if(pno.value.length==0 || pno=="" || pno==null)
	{
		alert("Please enter the phone number");
		pno.focus();
		return false;
	}
	
	var pnonum=/[0-9]/;
	if(!pno.value.match(pnonum))
	{
		alert("Please enter only numbers");
		pno.focus();
		return false;
	}
	
	
	var cardnum=MyForm.cardnum;
	if(cardnum.value.length==0 || cardnum=="" || cardnum==null)
	{
		alert("Please enter the card number");
		cardnum.focus();
		return false;
	}
	
	var name=MyForm.name;
	if(name.value.length==0 || name=="" || name==null)
	{
		alert("Please enter the name");
		name.focus();
		return false;
	}

	var bankname=MyForm.bankname;
	if(bankname.value.length==0 || bankname=="" || bankname==null)
	{
		alert("Please enter the bank name");
		bankname.focus();
		return false;
	}
	
	var cvvnum=MyForm.cvvnum;
	if(cvvnum.value.length==0 || cvvnum=="" || cvvnum==null)
	{
		alert("Please enter the cvv number");
		cvvnum.focus();
		return false;
	}
	
  
	
	
	else
		return true;
  }


