/*
 * Copyright (C) 2017 elguala9
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ParseSchede;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * classe contenente tutti i dati su una scheda
 * @author elguala9
 */
public class Scheda {
    
    protected String info_scheda;
    protected String nome_scheda;
    protected String psw;
    protected Gioco[] giochi;
    
    public Scheda() {
        
    }
    
    public void letturaMobili(){
        
    }

    public String getInfo_scheda() {
        return info_scheda;
    }

    public String getNome_scheda() {
        return nome_scheda;
    }



    public String getPsw() {
        return psw;
    }
    /**
     * cerca un gioco nella scheda
     * @param nome_gioco
     * @return un oggetto {@link Gioco} se viene trovato, altrimenti {@code null}
     */
    public Gioco searchGioco(String nome_gioco){
        if(giochi==null) return null;
        
        int i=giochi.length;
        
        for(int n=0;n<i;n++){
            if(giochi[n].getNome_gioco().compareToIgnoreCase(nome_gioco)==0){
                return giochi[n];
            }
        }
        
        return null;
    }
    
    private String readFileJson(String path) throws FileNotFoundException, IOException {
        
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String text=new String();
        String line = reader.readLine();
        
        while(line!=null) {
           
            text=text + line;
            line = reader.readLine();
            
            
        
        }
        
        return text;
    }
    
    /**
     * ritorna i nomi dei vari giochi supportati dalla scheda
     * @return array dei nomi dei giochi
     */
    public String[] getNomiGiochi(){
        if(giochi==null) return null;
        
        int i=giochi.length;
        String[] nomi=new String[i];
        for(int n=0;n<i;n++){
            nomi[n]=new String(giochi[n].getNome_gioco());
        }
        
        return nomi;
    }
    /**
     * usa i metodi Gson per inizializzare una classe Mobili
     * @param path
     * @return una classe {@link #Mobili} creata in base al file json
     * @throws IOException 
     */
    public Mobili createMobili(String path) throws IOException{
        String json=this.readFileJson(path);
        
        GsonBuilder builder = new GsonBuilder();
                
        Gson gson = builder.create();
        
        JsonParser parser = new JsonParser();
        JsonElement element=parser.parse(json);
        
        Mobili mobili=gson.fromJson(element,Mobili.class);
        
        return mobili;
    }
    
    
}
