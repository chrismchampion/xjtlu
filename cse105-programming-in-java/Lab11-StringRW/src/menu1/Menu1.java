package menu1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author christopher
 */
public class Menu1 {
    
    
    public static void main(String[] args) {
        
        /*String coolString = "This is a cool string.";
        StringWriter.writeSingleString(coolString);*/
        
        String[] names = {"Bob", "Diane", "Dale", "Cooper"};
        //String[] animals = {"lions", "tigers", "bears"};
        StringWriter.writeStringArray(names);
        //StringWriter.writeStringArray(animals);
        
        StringReader.readTextFile("StringArrayFile.txt");
    }
}
