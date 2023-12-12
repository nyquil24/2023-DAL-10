
// external javascript file

class User{
    constructor(name, dob){
        this.name = name; 
        this.dob = dob; 
    }
}


function validateEmail(){
        let emailID = document.myForm.Email.value; 
        atpos = emailID.indexOf("@"); 
        dotpos = emailID.lastIndexOf("."); 
        if(atpos < 1 || (dotpos - atpos < 2)){
            alert("Please enter correct email"); 
            document.myForm.Email.focus(); 
            return false; 
        }else{
            return true;
        }
    }

    function validate(){
        if(document.myForm.Name.value == ""){
            alert("please provide your name"); 
            document.myForm.Name.focus();
            return false; 
        }else{
            let NAME = document.myForm.Name.value
        }
        if(document.myForm.Email.value == ""){
            alert("Please provide your Eamil!"); 
            document.myForm.Email.focus(); 
            return false; 
        }
        return true; 
    }

    // function mydropdown(){
    //     var wlist = document.getElementById("myList"); 
    //     wlist.options[MediaQueryList.selectedIndex].text; 
    // }

    document.querySelector('form[name="myForm"]').addEventListener('change', function(){
        
        var selectedValue = document.element["weedType"].value; 
        
        if(selectedOption === "home_grown"){    
            window.location.href = "/home_grown.html"; 
        } else if(selectedOption === "wild") {
            window.location.href = "/wild.html";
        }

        let name = document.querySelector('input[name="Name"]').value; 
        let dob = document.querySelector('input[type="date"]').value; 
        let user = new User(name, dob); 

        for(let userKey in user){
            console.log(userKey + ": " + user[userKey]);
        }

        for(let i = 0; i < pages.length; i++){
            if(window.location.pathname === pages[i]){
                alert(`Welcome ${user.name}. It's good thing that your date of birth: ${user.dob} is over the limit.`);
            }
        }


    });



