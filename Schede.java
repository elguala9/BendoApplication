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


import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.ArrayUtils;

/**
 * classe da cui si fanno le operazioni sulle schede {@link Scheda}
 * @author elguala9
 */
public class Schede {

    Scheda[] schede;
    
    public Schede() {
        
    }
    /**
     * cerca una scheda a partire dal suo nome
     * @param nome_scheda
     * @return un oggetto {@link Scheda} 
     * @throws NotFoundException 
     */
    public Scheda searchScheda(String nome_scheda) throws NotFoundException{
        int i=schede.length;
        
        for(int n=0;n>i;n++){
            if(schede[n].getNome_scheda().compareToIgnoreCase(nome_scheda)==0){
                return schede[n];
            }
        }
        
        throw new NotFoundException("scheda non trovata");
        
    }
    /**
     * dl nome di un gioco trova la scheda
     * @param nome_gioco
     * @return  un oggetto {@link Scheda} che rappresenta la scheda associata al gioco
     * @throws NotFoundException 
     */
    public Scheda searchSchedafromGioco(String nome_gioco) throws NotFoundException{
        int i=schede.length;
        
        for(int n=0;n<i;n++){
            

            if(schede[n].searchGioco(nome_gioco).getNome_gioco().compareToIgnoreCase(nome_gioco)==0){
                return schede[n];
            }

        }
        
        throw new NotFoundException("scheda non trovata");
        
    }
    
    /**
     * mostra tutti i nomi dei giochi
     * @return i nomi dei giochi
     */
    public String[] getNomiGiochi(){
        int i=schede.length;
        
        String[] nomi=null;
        for(int n=0;n<i;n++){
            nomi = (String[])ArrayUtils.addAll(nomi, schede[n].getNomiGiochi());
        }
        
        return nomi;
        
    }
    
}
