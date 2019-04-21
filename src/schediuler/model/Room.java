/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schediuler.model;

/**
 *
 * @author kamal
 */
public class Room {
    private int rid,candl;

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getCandl() {
        return candl;
    }

    public void setCandl(int candl) {
        this.candl = candl;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }
    private String rname; 
    
}
