function notDot(e){
    var tecla=(window.event)?event.keyCode:e.which;   
    if(tecla==46){
        return false;
    }else{
        return true;
    }
}
function justNumber(e, negative, real){
    var tecla=(window.event)?event.keyCode:e.which;   
    if((tecla>47 && tecla<58)){ 
        return true;
    }
    else if (tecla==8 || tecla==0) {
        return true;
    }
    if((negative) && (tecla==45)){
        // validar se já existe
        return true
    }
    if((real) && (tecla==46)){
        return true;
    }
    return true;
}

function start() { 
    statusDialog.show();  
}  
  
function stop() {  
    statusDialog.hide();  
}  