package com.revature.models;

/**
 * This concrete User class can include additional fields that can be used for
 * extended functionality of the ERS application.
 *
 * Example fields:
 * <ul>
 *     <li>First Name</li>
 *     <li>Last Name</li>
 *     <li>Email</li>
 *     <li>Phone Number</li>
 *     <li>Address</li>
 * </ul>
 *
 */
public class User extends AbstractUser {

    public User() {
        super();
    }

    /**
     * This includes the minimum parameters needed for the {@link com.revature.models.AbstractUser} class.
     * If other fields are needed, please create additional constructors.
     */
    //meena
    public User(String username, String password,String firstname,String lastname, String email,int role_id ) {
        super( username, password,firstname, lastname,  email, role_id);
        
    }
    
    public User(int id, String username, String password,String firstname,String lastname,String email, int role_id) {
        super(id, username, password, firstname,lastname,email,role_id);
    }
   /* public User(String username, String password, String email,int role_id ) {
        super( username, password , email,role_id);
    } */
}
