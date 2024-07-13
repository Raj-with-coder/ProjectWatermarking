function validateLogin()
{
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
	
	else
		return true;
}
