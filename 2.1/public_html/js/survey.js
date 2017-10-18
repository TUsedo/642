function computation() {
    var data = document.getElementById("data").value;
    var valueArray = data.split(",");
    if (valueArray.length > 10 && findMax(valueArray)) {
        calculateAverage(valueArray);
        $('#data').popover('hide');
    } else {
        document.getElementById("data").focus();
        $('#data').popover('show');
    }
}

function calculateAverage(valueArray) {
    var total = 0;
    var arrayLength = valueArray.length;
    for (i = 0; i < arrayLength; i++) {
        total += parseInt(valueArray[i]);
    }
    let average = total / arrayLength;
    document.getElementById("average").value = average.toFixed(2);
}

function findMax(valueArray) {
    valueArray.sort(function (a, b) {
        return a - b
    });
    var maxValue = valueArray[(valueArray.length) - 1];
    var minValue = valueArray[0];
    if (maxValue > 100 || minValue < 0 || isNaN(maxValue)) {
        return false;
    }
    document.getElementById("maximum").value = maxValue;
    return true;
}

/********************Average and Maximum***********************/

/*********************Input Validation************************/

$(document).ready(function () {
    $('#submit').click(validate);
});

function validate() {
    
    var state_flag;
    var chkbox_flag;
    var radiobtn_flag;
   
    state_flag = validate_state();
    chkbox_flag = validate_checkboxes();
    radiobtn_flag = validate_radiobtn();
    if (state_flag && chkbox_flag && radiobtn_flag) {
        $("#submit_btn").popover('hide');    
        return true;
    }
    $("#submit_btn").popover('show');
    return false;
}

function check_state(state) {
    return document.getElementById("state").value == state
}

function validate_state() {
    var states = ["Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"];
    document.getElementById("state").style.textTransform = "capitalize";
    var status = document.getElementById("state").value == states.find(check_state);
    if (!status)
        $('#state').popover('show');
    else
        $('#state').popover('hide');
        return status;
}

function validate_checkboxes(){
    var chkbx_check = document.survey_form.chkbx;
    var count =0;
    
    for( i =0;i<chkbx_check.length;i++) {
        if(chkbx_check[i].checked)
            count++
    }
    if(count < 2) {
        $('#chk_error').popover('show');
        return false;
    }
    else {
        $('chk_error').popover('hide');
        return true;
    }
        
}

function validate_radiobtn() {
    var radio_check = document.survey_form.rdbtn;
    var rd_flag = false;
      
    for (i = 0; i < radio_check.length; i++)
    {
        if (radio_check[i].checked)
        {
            rd_flag = true;
        }
    }
    if(!rd_flag){
        $(rd_error).popover('show');
        return false;
    }
    else{
        $(rd_error).popover('hide');
        return true;
    }
}





