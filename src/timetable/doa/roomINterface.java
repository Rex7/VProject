/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable.doa;

import timetable.model.Room;

/**
 *
 * @author kamal
 */
public interface roomINterface {
    public void getAllRecord();
    public boolean save(Room room);
    public int getRoomId( Room room);
    
}
