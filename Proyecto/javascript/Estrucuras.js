//contenedor global de la cola
function Queue(){

    this.first =null;
    this.push =QueuePush;
    this.print= QueuePrint;
}


function QueuePush(value){

    if (!this.first){ 
    
        this.first= new Node(value);
    }else {

    current=this.first;
     while(current.next){

        current=current.next;

     }
    current.next= new Node(value);
   }
}
    
    function QueuePrint(){
    
        result="";
        while(current){

            //gaurdar valor
            //result=result + current.value + "=>";
            result+=`${current.value}=>`;
            current=current.next;
        }
        result+=`null`;
        return result;    
    }
   


 //la cola se compone de los elementos internos llamados NODOS 
 
 function Node(){

    this.value= value;
    this.next= null;
}

