/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usac.gob.gt.py1_202000510.Estructuras;

/**
 *
 * @author javie
 */
public class HOJA_AFN {
    public String dato;
    public String identificador;
    public String tipo;
    public HOJA_AFN fin;
    public boolean terminal;
    public HOJA_AFN[] hijos;
    public HOJA_AFN(String dato, String[] alfabeto, HOJA_AFN izquierda, HOJA_AFN derecha, String tipo){
        this.dato = dato;
        this.identificador = "S";
        this.tipo = tipo;
        CREAR_HIJOS(tipo, izquierda, derecha, alfabeto);
    }
    public void CREAR_HIJOS(String tipo, HOJA_AFN izquierda, HOJA_AFN derecha, String[] alfabeto){
        switch(tipo){
            case ".":
                hijos = new HOJA_AFN[3];
                break;
            case "*":
                if(izquierda!=null){hijos = new HOJA_AFN[3];}
                else{hijos = new HOJA_AFN[4];}
                break;
            case "|":
                if (izquierda!=null && derecha!=null) {
                    hijos = new HOJA_AFN[4];
                    
                }else if(izquierda!=null || derecha!=null){
                    hijos = new HOJA_AFN[5];
                }else{
                    hijos = new HOJA_AFN[6];
                }
                break;
            case "+":
                if(izquierda!=null){hijos = new HOJA_AFN[3];}
                else{hijos = new HOJA_AFN[4];}
                break;
            case "?":
                if(izquierda!=null){hijos = new HOJA_AFN[3];}
                else{hijos = new HOJA_AFN[4];}
                break;
            default:
                break;
        }
        if(!tipo.equals("hoja")){
            for (int y=0;y<hijos.length;y++) {
                hijos[y] = new HOJA_AFN("ε",null, null, null, "hoja");
                hijos[y].identificador = "S";
            }
            if(izquierda!=null && derecha!=null){
                if(tipo.equals(".")){
                    hijos[0] = izquierda;
                    hijos[1] = derecha;
                }else{
                    hijos[1] = izquierda;
                    hijos[3] = derecha;
                }
            }else if(izquierda!=null || derecha!=null){
                if(tipo.equals("+") || tipo.equals("*") || tipo.equals("?")){
                    hijos[1] = izquierda;
                }else{
                    if (izquierda!=null) {
                        if(tipo.equals(".")){
                            hijos[0] = izquierda;
                            hijos[1].dato = alfabeto[0];
                        }else{
                            hijos[1] = izquierda;
                            hijos[3].dato =alfabeto[0];
                        }
                    }else{
                        if(tipo.equals(".")){
                            hijos[0].dato = alfabeto[0];
                            hijos[1] = derecha;
                        }else{
                            hijos[1].dato = alfabeto[0];
                            hijos[4] = derecha;
                        }
                    }
                }
                
            }else{
               if(tipo.equals("+") || tipo.equals("*") || tipo.equals("?")){
                    hijos[1].dato = alfabeto[0];
                }else{
                   if(tipo.equals(".")){
                        hijos[0].dato = alfabeto[0];
                        hijos[1].dato = alfabeto[1];
                    }else{
                        hijos[1].dato = alfabeto[0];
                        hijos[4].dato = alfabeto[1];
                    }
                } 
            }
        }
    }
}

