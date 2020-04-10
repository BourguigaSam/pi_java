/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Core;

import com.esprit.models.Personne;
import com.esprit.services.IService;
import com.esprit.services.ServicePersonne;
import java.security.Provider.Service;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author LENOVO
 */
public class Controller {


 public static AnchorPane holderPane;
    private static int userId;
    public static void setUserId(int id)
    {
        if(id == 0) return ;
        Controller.userId = id ;
    }
    public static int getUserId()
    {
        return Controller.userId;
    }
    
    
    
}
