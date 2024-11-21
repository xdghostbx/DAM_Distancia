
package edu.cdm.tarea02.model;

/**
 *
 * @author maria
 */
public class Departamento {

    int deptno;
    String deptName;
    String loc;

    public Departamento(int deptno, String deptName, String loc) {
        this.deptno = deptno;
        this.deptName = deptName;
        this.loc = loc;
    }

    public Departamento() {
      
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "Departamento{" + "deptno=" + deptno + ", deptName=" + deptName + ", loc=" + loc + '}';
    }

    
    
}
