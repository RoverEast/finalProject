function toMain() {
    location.href = "/login";
}

function toRegistration() {
    location.href = "/registration";
}

function toStaffPage() {
    location.href = "/account";
}

function loadXMLDoc() {
    var xmlhttp ;
    if (window.XMLHttpRequest)
        xmlhttp= new XMLHttpRequest();
    else
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == 4) {
            if (xmlhttp.status == 200) {
                document.getElementById('message').innerHTML =xmlhttp.responseText;
                document.getElementById('dischargeButton').disabled = true;
            } else {
                alert('error ' + xmlhttp.status);
            }
        }
    };

    xmlhttp.open("POST", "discharge");
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlhttp.send();
}
