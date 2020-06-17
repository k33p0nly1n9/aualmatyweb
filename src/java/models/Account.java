
package models;

import com.mysql.jdbc.log.*;
import javax.servlet.http.*;

public class Account {

    public static Person getCurrentPerson(HttpServletRequest request){


    HttpSession session = request.getSession();
       int id = -1;

      try{
          id = (int)session.getAttribute("personIdSession");
      }catch(Exception ex){
         ex.printStackTrace();
      }

      DbHelper db = new DbHelper();

        Person person = db.getPerson(id);
        return person;
    }
    
   
    public static void setCurrentPerson(HttpServletRequest request, int id) {

        HttpSession session = request.getSession();

        try {
            session.setAttribute("personIdSession", id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    

}
