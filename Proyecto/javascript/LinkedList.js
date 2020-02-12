/*

Listas enlazadas 
------------------
Estructuras de datos compuestas por nodos, donde cada nod esta enlazado con otro. 
A diferencia de otras estructuras de datos, las listas enlazadas se conectan secuencialmente.

Las listas enlazadas pueden ser de tipo:
   Pilas (Stack):
     El ultimo elemento en apilarse es el primero que va salir,
     el promer elemento en apilarse sera el ultimo en salir.
     
   Cola(Queue):
     El primer elemento en encolarse es el primero en salir,
     mientras que el ultimo en encolarse es el ultio en salir.

Las listas enlazadas se consideran un tipo de dato abstracto (TDA), porque podemos 
representar muchos escnarios usando listas, colasm o pilas.

TDA
----

Asi como existen tipos de datos nativos (e.g: int, doble, gloat, string, char, entre otros),
existen caracteristicas abstractas que se desean implementar mediante lenguajes de programacion. los tipos de datos abstractos
representan esa abstraccion de la realidad, donde el programador plasma mediante lengiaje de programacion , 
las caracteristicas y acciones (metodos) de un objero en programacion.

La forma de materializar un TDA es mediante las clases. 
Cada instancia de una clase es un ejemplar de la clase. La calse piede se vista como un molde
donde cada ejemplar compartirar las mismas caracteristicas que el molde.


todas las clases van la primera letra mayuscula (letra capital), y singular.
aqui se ocupa main para instanciar.
class Human(){

    private String name;
    private int age;
    private doble height;
    public Human(String name,int age,doble height){

        this.name=name;
        this.age=age;
        this.height;
    }
}
  Human person= new Human("maria lopez",20,115);

*/ 


//aqui no se ocupa main, porque ya esta <<implicito>>

function Human(name,age,height){
    this.name="maria Lopez";
    this.age=0;
    this.height=0;
    
}

person= new Human("maria lopez",20,115);

