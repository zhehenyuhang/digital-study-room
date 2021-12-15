function next(i){
    if(i==1){
        $("#step-01").css("display","none");
        $("#step-02").css("display","block");
        $("#step-01-line").css("backgroundColor","#0C75BB");
        $("#step-2").css("backgroundColor","#0C75BB");
        $("#step-2-text").css("color","#0C75BB");
    }else if(i==2){
        $("#step-02").css("display","none");
        $("#step-03").css("display","block");
        $("#step-3").css("backgroundColor","#0C75BB");
        $("#step-02-line").css("backgroundColor","#0C75BB");
        $("#step-3-text").css("color","#0C75BB");
    }else if(i==3){
        $("#step-03").css("display","none");
        $("#step-04").css("display","block");
        $("#step-4").css("backgroundColor","#0C75BB");
        $("#step-03-line").css("backgroundColor","#0C75BB");
        $("#step-4-text").css("color","#0C75BB");
        console.log($("#userobjectform").serialize());
        console.log($("#userinfoform").serialize());
        console.log($("#passwordform").serialize());
        //serializeObject()
    }else{
        console.log(225)
    }
}

function previous(i){
    if(i==2){
        $("#step-01").css("display","block");
        $("#step-02").css("display","none");
        $("#step-01-line").css("backgroundColor","#cccccc");
        $("#step-2").css("backgroundColor","#cccccc");
        $("#step-2-text").css("color","#cccccc");
    }else if(i==3){
        $("#step-02").css("display","block");
        $("#step-03").css("display","none");
        $("#step-02-line").css("backgroundColor","#cccccc");
        $("#step-3").css("backgroundColor","#cccccc");
        $("#step-3-text").css("color","#cccccc");
    }
}

