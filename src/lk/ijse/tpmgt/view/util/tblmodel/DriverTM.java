/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.tpmgt.view.util.tblmodel;

/**
 *
 * @author A C E R
 */
public class DriverTM {
    private String nic;
    private String name;
    private String address;
    private String contactNo;
    private String drivingLicenceNo;

    public DriverTM(String nic, String name, String address, String contactNo, String drivingLicenceNo) {
        this.nic = nic;
        this.name = name;
        this.address = address;
        this.contactNo = contactNo;
        this.drivingLicenceNo = drivingLicenceNo;
    }

    public DriverTM() {
    }

    /**
     * @return the nic
     */
    public String getNic() {
        return nic;
    }

    /**
     * @param nic the nic to set
     */
    public void setNic(String nic) {
        this.nic = nic;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the contactNo
     */
    public String getContactNo() {
        return contactNo;
    }

    /**
     * @param contactNo the contactNo to set
     */
    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    /**
     * @return the drivingLicenceNo
     */
    public String getDrivingLicenceNo() {
        return drivingLicenceNo;
    }

    /**
     * @param drivingLicenceNo the drivingLicenceNo to set
     */
    public void setDrivingLicenceNo(String drivingLicenceNo) {
        this.drivingLicenceNo = drivingLicenceNo;
    }

    @Override
    public String toString() {
        return "DriverTM{" + "nic=" + nic + ", name=" + name + ", address=" + address + ", contactNo=" + contactNo + ", drivingLicenceNo=" + drivingLicenceNo + '}';
    }
    
}
