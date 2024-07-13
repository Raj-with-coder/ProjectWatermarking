function validateCredit()
{

	var MyForm=document.forms[0];
	
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
	if (/[0-9]{3}+/.test(cvvnum))
	{
			alert("Please enter the cvv number");
			cvvnum.focus();
			return false;
		
	}
	
	var cvvnum=MyForm.cvvnum;
	if ((parseint(cvvnum) >= 100) || (parseInt(cvvnum) <= 9999))
	{
		alert("Please enter the cvv number");
		cvvnum.focus();
		return false;
	
    }
	
	var cvvnum=MyForm.cvvnum;
	if(cvvnum.value>=5)
	{
			alert("Please enter the cvv number");
			cvvnum.focus();
			return false;
		
	}
	
	var cvvnum=MyForm.cvvnum;
	if(cvvnum.value.length==0 || cvvnum=="" || cvvnum==null)
	{
		alert("Please enter the cvv number");
		cvvnum.focus();
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
	
	
	var pnonum=/[0-9]/;
	if(!pno.value.match(pnonum))
	{
		alert("Please enter only numbers");
		pno.focus();
		return false;
	}
	
	else
		return true;
  }


