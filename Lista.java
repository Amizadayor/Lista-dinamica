import java.util.Scanner; // Importamos la libreria java.util.Scanner para facilitar la lectura de nuestros datos. //
import javax.swing.JOptionPane; // Importamos la librería javax.swing.JOptionPane que nos permitira facilitar la aparición de un cuadro de diálogo estándar que solicitara a los usuarios un valor o les informa algo. //

class Lista{ // Creamos la clase Lista //
  private Nodo Primero, Final;
  private int pos;
  private Scanner t = new Scanner (System.in); // Declaramos la variable t como el capturador de entrada de datos. //

    public Lista (){
      Primero = null; // Creamos la funcion Primero apuntando a null. //
      Final = null;  // Creamos la funcion Final apuntando a null. //
      setPos(0);
    }
    public int getPos() {
        return pos;
    }
	  public void setPos(int pos) {
	  this.pos = pos;
	  }
	  private Boolean esVacia(){
      return this.Primero == null;
    }
    private void mensaje (String cad){
      System.out.println(cad);
    }
    private int LeerDato(){
      mensaje ("-----------------------------------------------");
      mensaje ("                INGRESE EL DATO :              ");  // Mostramos un mensaje para pedir los datos a agregar. //
      mensaje ("-----------------------------------------------");
      return t.nextInt();
    }
    private void InsertaPrimero (int dato){
      Nodo nuevo = new Nodo (dato);
      Primero=nuevo;
      Final=nuevo;
      setPos(getPos() + 1);
    }
    private void InsertarInicio(){ // En esta sección se realizara las funciones para insertar los datos ingresados al inicio de la lista. //
      int v; // v: validacion.
      int dato;
        do{
            try{ // Aqui va la validacion en la que solo se admitira numeros enteros y en caso de no ser así, se lanzara un mensaje de error.//
              v=0;
              dato = LeerDato ();
              if (esVacia()) // Hacemos la comparación, si es vacia, insertamos al dato al inicio. //
              InsertaPrimero (dato);
                else{
                  Primero = new Nodo (dato, Primero);
                  setPos(getPos() + 1);
                }
              JOptionPane.showMessageDialog(null," DATO INSERTADO AL INICIO DE LA LISTA "); // Mostramos un mensaje cuando el dato se haya insertado correctamente al inicio de la lista. //
            }catch(Exception e){
              JOptionPane.showMessageDialog(null," INGRESE SOLO NUMEROS ENTEROS "," ERROR ",JOptionPane.ERROR_MESSAGE); // Mostramos un mensaje de error cuando el usuario ingrese caracteres no validos //
              v=1;
              t.nextLine();
              setPos(getPos() - 1);
            }
        }while(v != 0); // Final de la validación. //
    }
    private void InsertarFinal (){ // En esta sección se realizara las funciones para insertar los datos ingresados al final de la lista. //
      int v; // v: validacion.
      int dato;
        do{
            try{ // Inicio de la validacion en la que solo se admitira numeros enteros y en caso de no ser así, se lanzara un mensaje de error.//
              v=0;
              dato = LeerDato();
              if (esVacia()) // Hacemos la comparación, si es vacia, insertamos al dato al inicio. //
              InsertaPrimero (dato);
                else{
                  Nodo nuevo = new Nodo (dato);
                  Final.setEnlace (nuevo);
                  Final = nuevo;
                  setPos(getPos() + 1);
                }
              JOptionPane.showMessageDialog(null," DATO INSERTADO AL FINAL DE LA LISTA ");  // Mostramos un mensaje cuando el dato se haya insertado correctamente al final de la lista. //
            }catch(Exception e){
              JOptionPane.showMessageDialog(null," INGRESE SOLO NUMEROS ENTEROS "," ERROR ",JOptionPane.ERROR_MESSAGE); // Mostramos un mensaje de error cuando el usuario ingrese caracteres no validos //
              v=1;
              t.nextLine();
              setPos(getPos() - 1);
            }
        }while (v !=0); // Final de la validación //
    }

    private void InsertarEN(){ // Tarea: Insertar un elemento entre dos nodos
    JOptionPane.showMessageDialog(null," NO PUDE HACER ESTA OPCION PROFE :( ");
    }

    private void EliminarInicio(){  // En esta sección se realizara las funciones para eliminar el dato del inicio de la lista. //
      if (esVacia())
      JOptionPane.showMessageDialog(null," LISTA VACIA "," ERROR ",JOptionPane.ERROR_MESSAGE); // Mostramos un mensaje de error cuando la lista este vacia. //
        else{
          Primero = Primero.getEnlace();
          setPos(getPos() - 1);
          JOptionPane.showMessageDialog(null," DATO ELIMINADO "); // Mostramos un mensaje cunado el dato se haya eliminado correctamente. //
        }
    }
    private void EliminarFinal(){  // En esta sección se realizara las funciones para eliminar el dato del final de la lista. //
      if (esVacia())
      JOptionPane.showMessageDialog(null," LISTA VACIA "," ERROR ",JOptionPane.ERROR_MESSAGE); // Mostramos un mensaje de error cuando la lista este vacia. //
        else{
          Nodo n;
          n=Primero;
            while (n!=null){
                if (n.getEnlace()==Final){
                  Final = n;
                  n.setEnlace(null);
                  setPos(getPos() - 1);
                  JOptionPane.showMessageDialog(null," DATO ELIMINADO "); // Mostramos un mensaje cunado el dato se haya eliminado correctamente. //
                  return;
                }
              n = n.getEnlace();
            }
        }
    }
    private void EliminarEN(){ // En esta sección se realizara las funciones para eliminar el dato de una posición en especifica. //
      int v; // v: validacion.
      int b;
      Nodo p = Primero;
      Nodo q = null;
        do{
            try{  // Inicio de la validacion en la que solo se admitira numeros enteros y en caso de no ser así, se lanzara un mensaje de error.//
              v=0;
              if(esVacia())
              JOptionPane.showMessageDialog(null," LISTA VACIA "," ERROR",JOptionPane.ERROR_MESSAGE); // Mostramos un mensaje de error cuando la lista este vacia. //
                else{
                  mensaje ("-----------------------------------------------");
                  mensaje ("            INGRESE DATO A ELIMINAR            "); // Mostramos un mensaje para pedir al usuario el dato de la lista a eliminar. //
                  mensaje ("-----------------------------------------------");
                  b = t.nextInt();
                    while(p != null && p.getInfo()!=b){
                      q = p;
                      p = p.getEnlace();
                    }
                    if(p != null){
                        if(p == Primero){
                          Primero = p.getEnlace();
                        }else{
                          q.setEnlace(p.getEnlace());
                          if(p == Final)
                          Final = q;
                        }
                      JOptionPane.showMessageDialog(null," DATO ELIMINADO "); // Mostramos un mensaje cunado el dato se haya eliminado correctamente. //
                    }else{
                      JOptionPane.showMessageDialog(null," DATO NO ENCONTRADO "," ERROR ",JOptionPane.ERROR_MESSAGE); // Mostramos un mensaje de error cunado no se haya encontrado el dato a eliminar dentro de la lista. //
                    }
                }
            }catch(Exception e){
              JOptionPane.showMessageDialog(null," INGRESE SOLO NUMEROS ENTEROS "," ERROR ",JOptionPane.ERROR_MESSAGE); // Mostramos un mensaje de error cuando el usuario ingrese caracteres no validos //
              v=1;
              t.nextLine();
              setPos(getPos() - 1);
            }
        }while (v !=0); // Final de la validación. //
    }
    private void Editar(){  // En esta sección se realizara las funciones para poder editar algun dato dentro de la lista. //
      int v; // v: validacion.
      int p,c,d;
        do{
            try{   // Inicio de la validacion en la que solo se admitira numeros enteros y en caso de no ser así, se lanzara un mensaje de error.//
              v=0;
              if (esVacia())
              JOptionPane.showMessageDialog(null," LISTA VACIA "," ERROR ",JOptionPane.ERROR_MESSAGE); // Mostramos un mensaje de error cuando la lista este vacia. //
                  else{
                    Listado();
                    mensaje ("-----------------------------------------------");
                    mensaje ("     INGRESE LA POSICION EL DATO A EDITAR :    "); // Mostramos un mensaje para pedir la posición del dato que vaya a modificar. //
                    mensaje ("-----------------------------------------------");
                    p = t.nextInt();
                    mensaje ("-----------------------------------------------");
                    mensaje ("            INGRESE EL NUEVO VALOR :           "); // Mostramos un mensaje para pedir el nuevo valor del dato que se va a modificar. //
                    mensaje ("-----------------------------------------------");
                    d = t.nextInt();
                    Nodo n;
                    n=Primero;
                    c=1;
                      while (n!=null){
                          if (c==p){
                            n.setInfo(d);
                            JOptionPane.showMessageDialog(null," DATO MODIFICADO "); // Mostramos un mensaje cuando el dato se haya modficado correctamente. //
                            return;
                          }
                        n=n.getEnlace();
                        c++;
                      }
                  }
            }catch(Exception e){
              JOptionPane.showMessageDialog(null," INGRESE SOLO NUMEROS ENTEROS "," ERROR ",JOptionPane.ERROR_MESSAGE); // Mostramos un mensaje de error cuando el usuario ingrese caracteres no validos //
              v=1;
              t.nextLine();
              setPos(getPos() - 1);
            }
        }while (v != 0); // Final de la validación. //
    }
    private void Listado(){  // En esta sección se realizara la funcion para poder listar todos los datos disponibles que se encuentren agregados dentro de nuestra lista. //
      int v;
        do{
            try{  // Inicio de la validacion en la que solo se admitira numeros enteros y en caso de no ser así, se lanzara un mensaje de error.//
              v=0;
              if (esVacia ())
              JOptionPane.showMessageDialog(null," LISTA VACIA "," ERROR ",JOptionPane.ERROR_MESSAGE); // Mostramos un mensaje de error cuando la lista este vacia. //
                  else{
                    Nodo n;
                    n = Primero;
                    int c=1;
                      while (n!=null){
                        mensaje ("-----------------------------------------------");
                        mensaje ("POSICION =[" + c + "], VALOR = " + n.getInfo() + ", DIRECCION = " + n.getEnlace()); // Mostramos en pantalla la posicion de los datos, el valor y la direccion en la que se encuntra. //
                        mensaje ("-----------------------------------------------");
                        n=n.getEnlace();
                        c++;
                      }
                    mensaje ("                                               ");
                    mensaje ("************** LISTADO TERMINADO **************"); // Mostramos un mensaje cuando el listado de los datos se haya terminado. //
                  }
            }catch(Exception e){
              JOptionPane.showMessageDialog(null," INGRESE SOLO NUMEROS ENTEROS "," ERROR ",JOptionPane.ERROR_MESSAGE);  // Mostramos un mensaje de error cuando el usuario ingrese caracteres no validos //
              v=1;
              t.nextLine();
              setPos(getPos() - 1);
            }
        }while (v != 0); // Final de la validación. //
    } 
    public void menu(){ // En esta seccion se realizara el Menu de opciones y las funciones que realizara. //
      int v; // V: validacion. //
      int op;
        do{
            try{ // Inicio de la validacion en la que solo se admitira numeros enteros y en caso de no ser así, se lanzara un mensaje de error.//
              v=0;
                do{
                  mensaje (" _____________________________________________ ");  // Mostramos el menu cuando el programa se haya ejecutado. //
                  mensaje ("|                                             |");
                  mensaje ("|              MENU DE OPCIONES               |");
                  mensaje ("|                                             |");
                  mensaje ("|   1. -----> INSERTAR AL INICIO DE LA LISTA  |");
                  mensaje ("|   2. -----> INSERTAR AL FINAL DE LA LISTA   |");
                  mensaje ("|   3. -----> INSERTAR ENTRE NODOS            |");
                  mensaje ("|   4. -----> ELIMINAR EL INICIO DE LA LISTA  |");
                  mensaje ("|   5. -----> ELIMINAR EL FINAL DE LA LISTA   |");
                  mensaje ("|   6. -----> ELIMINAR ENTRE NODOS            |");
                  mensaje ("|   7. -----> EDITAR                          |");
                  mensaje ("|   8. -----> LISTAR ELEMENTOS                |");
                  mensaje ("|   9. -----> SALIR                           |");
                  mensaje ("|_____________________________________________|");
                  mensaje ("|                                             |");
                  mensaje ("|              INGRESE SU OPCION :            |");   // Mostramos un mensaje para pedir la opción a realizar. //
                  mensaje ("|_____________________________________________|");
                  op = t.nextInt ();
                    switch (op){  //A quí creamos un switch para especificar las funciones de cada opción. //
                        case 1: InsertarInicio();
                        break;
                        case 2: InsertarFinal();
                        break;
                        case 3: InsertarEN();
                        break;
                        case 4: EliminarInicio();
                        break;
                        case 5: EliminarFinal();
                        break;
                        case 6: EliminarEN();
                        break;
                        case 7: Editar();
                        break;
                        case 8: Listado();
                        break;
                        case 9:
                        break;
                        default: JOptionPane.showMessageDialog(null," NO EXISTE ESA OPCION "," ERROR ",JOptionPane.ERROR_MESSAGE); // Mostramos un mensaje de error cuando la opcion que haya insertado el usuario no exista en el menu de opciones . //
                        break;  // insertamos un break para finalizar una secuencia de la instrucción de cada opción. //
                    }
                }while (op!=9);
            }catch(Exception e){
              JOptionPane.showMessageDialog(null," INGRESE SOLO NUMEROS ENTEROS ", " ERROR ",JOptionPane.ERROR_MESSAGE); // Mostramos un mensaje de error cuando el usuario no haya ingresado caracteres validos //
              v=1;
              t.nextLine();
            }
        }while(v != 0); // Final de la validación. //
    }
    public static void main (String a[]){
      Lista l = new Lista();
      l.menu();
    }
}

// OJEDA ROSALES JUAN AMIZADAY //