/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable.doa;

import timetable.model.User;
import java.util.List;

/**
 *
 * @author Regis charles
 */
public interface doaInterface {
    public boolean save(User user);
    public void delete(String username);
    public List<User>  getAllRecords();
    public boolean getUser(String username, String password);
    
}
