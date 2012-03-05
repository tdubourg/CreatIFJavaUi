/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package creawin;

import creatifb3121.MainCrea;
/**
 *
 * @author Administrateur
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
	
	MainCrea.creationDb();
	
        Menu a = new Menu();
        a.show();
    }

}
