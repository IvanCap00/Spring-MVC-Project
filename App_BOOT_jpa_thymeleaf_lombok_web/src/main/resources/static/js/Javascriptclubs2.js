/**
 * 
 */
/*
window.alert("Benvenuto!Per creare un club o un nevneto è necessaria una registrazione");
console.log("miao")
window.alert (username)
*/
if(username == null){
	    console.log("username è null");
	    const listaBottoni = document.querySelectorAll('[id=bottoneAdmin]');
	    console.log(listaBottoni);
	    for (let bottone of listaBottoni){
			//console.log(bottone)
			bottone.style.visibility = "hidden"
	    }
	    
	} else {
	    console.log("username non è null");
	    console.log(username.username)
	  
	    
	   //window.alert(username.username)
	    if (username.authorities[0] = "ROLE_ADMIN"){
		console.log("admin")
		window.alert("benvenuto " + username.username + "!"+ " hai eseguito il login come ADMIN")
	    }else if(username.authorities[0] = "ROLE_USER") {
		console.log("utente")
		window.alert("benvenuto " + username.username + "!"+ " hai eseguito il login come UTENTE")
	    }
	}