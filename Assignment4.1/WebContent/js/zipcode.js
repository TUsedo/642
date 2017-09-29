function fetchData(){   
    asyncObject = new XMLHttpRequest();
    asyncObject.onreadystatechange = fetchZipcodes;
    asyncObject.open('GET','ziplist.json',true);
    asyncObject.send(null);   
}

function fetchZipcodes() {    
    if(asyncObject.readyState === 4 && asyncObject.status === 200) {
        var data = asyncObject.responseText;
        var zipCodes = JSON.parse(data);
        validateZipcodes(zipCodes);
    }
    else if (asyncObject.readyState === 0 || asyncObject.readyState === 1 || asyncObject.readyState === 2 || asyncObject.readyState === 3) {
        $('#zipRow').popover('show');
    }        
}

function validateZipcodes(zipCodes) {
    var validZip = false;
    for(i=0;i<zipCodes.zipcodes.length;i++) {
        zipcode = zipCodes.zipcodes[i].zip;
        if(zipcode === document.getElementById("zip_Ajax").value) {
            document.getElementById("city_ajax").value = zipCodes.zipcodes[i].city;
            document.getElementById("state_ajax").value = zipCodes.zipcodes[i].state;
            $("#zip_Ajax").popover('hide');
            $('#zipRow').popover('hide');
            validZip=true;
        }
    }
    if(!validZip){
        $('#zipRow').popover('hide');
        $("#zip_Ajax").popover('show');
    }
}


