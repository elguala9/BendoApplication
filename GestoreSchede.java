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
 * classe che serve a creare l'oggetto contenente le varie schede {@link Schede}
 * @author elguala9
 */
public abstract class GestoreSchede {
        private static String json;
        
    
     private static void readFileJson(String path) throws FileNotFoundException, IOException {

        BufferedReader reader = new BufferedReader(new FileReader(path));
        json=new String();
        String line = reader.readLine();
        
        while(line!=null) {
            json=json + line;
            line = reader.readLine();
            
            
        }
        
        
    }
    /**
     * crea una classe {@link Schede} da un file json
     * @param path_file_json
     * @return un oggetto Schede con i dati contenuti nel file json
     * @throws FileNotFoundException
     * @throws IOException
     * @throws NotFoundException 
     */
    public static Schede createScheda(String path_file_json)throws FileNotFoundException, IOException, NotFoundException{
        
        readFileJson(path_file_json);
        
        GsonBuilder builder = new GsonBuilder();
                
        Gson gson = builder.create();
        
        JsonParser parser = new JsonParser();
        JsonElement element=parser.parse(json);
        
        Schede schede=gson.fromJson(element,Schede.class);
        
        return schede;
    }

    
    
    
}
