package com.company;

import excepciones.FueraDeRango;
import excepciones.ListaVacia;
import excepciones.NombreNulo;
import principal.CompresorDeTexto;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws FueraDeRango, ListaVacia, NombreNulo, IOException, ClassNotFoundException {
        // write your code here
        Scanner sc=new Scanner(System.in);
        CompresorDeTexto compresorDeTexto = new CompresorDeTexto();
        //MENU
        Menu menuu = new Menu();
        int opcion = 0;
        //ESTRUCTURAS DEL MENU
        while (opcion != 6) {
            opcion = menuu.menu();
            switch (opcion) {
                case 1:
                    UbicacionArchivos to=new UbicacionArchivos();
                    String texto=to.leerTxt("C:\\Users\\crml\\Desktop\\carlos\\proyecto\\Estructura de Datos\\x.txt");
                    if(texto.length()==0){
                        System.out.println(" No hay datos ");
                        throw new NombreNulo();
                    }
                    String[]cadenas= compresorDeTexto.Comprimir(texto);
                    System.out.println("Direcciones: "+cadenas[0]+"\nCaracteres: "+cadenas[1]);
                    break;
                case 2:
                    System.out.println("INTRODUZCA EL TEXTO  ");
                    String textso=sc.nextLine();
                    if(textso.length()==0){
                        System.out.println(" No hay datos ");
                        throw new NombreNulo();
                    }
                    String[]cadenass= compresorDeTexto.Comprimir(textso);
                    System.out.println("Direcciones: "+cadenass[0]+"\nCaracteres: "+cadenass[1]);
                    break;
                case 3:
                    System.out.println(compresorDeTexto.Descomprimir());
                    break;

                case 4:
                    String path = "";
                    String files;
                    File folder = new File(path);
                    File[] listOfFiles = folder.listFiles();
                    System.out.println("====================================================================");
                    System.out.println("=======================ARCHIVOS DISPONIBLES=========================");
                    for (int i = 0; i < (listOfFiles != null ? listOfFiles.length : 0); i++)
                    {
                        if (listOfFiles[i].isFile())
                        {
                            files = listOfFiles[i].getName();
                            if (files.endsWith(".txt") || files.endsWith(".TXT"))
                            {
                                System.out.println(files);
                            }
                        }
                    }
                    System.out.println("====================================================================");
                    break;
                case 6:
                default:
                    System.out.println("Saliendo...");
                    break;
            }



        }

    }




}
