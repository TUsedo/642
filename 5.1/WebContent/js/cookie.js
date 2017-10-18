function chkCookie() {
	if (document.cookie) {
		var cookieArray = document.cookie.split(";");
		for (i = 0; i < cookieArray.length; i++) {
			cookieArrayElements = cookieArray[i].split("=");
			if (cookieArrayElements[0] == "name")
				var name = cookieArrayElements[1];
		}
		greetingMessage(name);
	} else {
		setCookie();
	}
}

function greetingMessage(name) {
	if (name != "null" && name != "") {
		var now = new Date();
		var hrs = now.getHours();
		if (hrs > 6 && hrs < 12) {
			var welcome = "Good Morning ";
		} else if (hrs>12 && hrs<17) {
			welcome = "Good Afternoon ";
		} else if (hrs>17 && hrs < 20) {
			welcome = "Good Evening "
		} else
			welcome = "Good Night!!! Sleeping Time.....Bye ";
		document.getElementById("welcome_msg").innerHTML = welcome + unescape(name) + " Welcome to our Website for Assignment #4. If you are not " + unescape(name) + " <a onclick = \"wrongPerson()\"> Click Here</a>";
	}
	else
		setCookie();	
}

function setCookie() {
	var cookieValues = getCookieValues();
	var today = new Date();
	today.setDate(today.getDate() + 365);
	var expires = "expires=" + today.toUTCString();
	document.cookie = "name=" + escape(cookieValues[0]) + ";" + expires + ";path=/";
	document.cookie = "gender=" + escape(cookieValues[1]) + ";" + expires + ";path=/";
	document.cookie = "age=" + escape(cookieValues[2]) + ";" + expires + ";path=/";
	location.reload();
}

function getCookieValues() {
	window.alert("We make use of cookies to improve our user's experience. By your continued use of this site you accept such use");
	var name = window.prompt("Name", "");
	var gender = window.prompt("Gender", "");
	var age = window.prompt("Age", "");
	var values = [name, gender, age];
	return values;
}

function wrongPerson() {
	var expires = "Thu, 1-Jan-1970 00:00:01 GMT";
	document.cookie = "name=null;" + expires + ";path=/";
	document.cookie = "gender=null;" + expires + ";path=/";
	document.cookie = "age=null;" + expires + ";path=/";
	location.reload();
}