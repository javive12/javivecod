//contenedor global de la cola
function Queue(){

    this.first= null;
    this.push = QueuePush;
    this.print = QueuePrint;

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
      current=this.first;
      while(current){
          result+=`${current.value}=>`;
          current=current.next;

      }
      result+="null";
      return result; 

   }

// La cola se compone de los elementos internos llamados NODOS
function Node(value){

    this.value= value;
    this.next= null;
}