package com.revature.models;

import java.util.Date;
import java.util.Objects;

import com.util.controller.ConstantVariable;

/**
 * This AbstractReimbursement class defines a minimum functionality for
 * interacting with reimbursements in the ERS application.
 *
 * All reimbursements in this application must at least have:
 * <ul>
 *     <li>ID</li>
 *     <li>Status</li>
 *     <li>Author</li>
 *     <li>Resolver</li>
 *     <li>Amount</li>
 * </ul>
 *
 * Additional fields can be added to the concrete {@link com.revature.models.Reimbursement} class.
 *
 * @author Center of Excellence
 */
public class AbstractReimbursement {

  

	private int id;
    private Status status;
  //private User author;
 // private User resolver;
  //private double amount;
    private int amount;
    private Date submitted;
	private Date resolved;
	private String description;
	private int receipt;
	private int statusid;
	private int typeid;
	private int author;
	private int resolver;
    public AbstractReimbursement() {
        super();
    }

   public AbstractReimbursement(int id, Status status, int author, int resolver, int amount) {
        super();
        this.id = id;
        this.status = status;
        this.author = author;
        this.resolver = resolver;
        this.amount = amount;
    }
    //meena
    public AbstractReimbursement( int id, int amount, Date submitted, int receipt,int resolver) {
    	super();
        this.id = id;
        this.amount = amount;
        this.submitted = submitted;
        this.receipt = receipt;
        this.resolver = resolver;
        
    }
//meena
   /* public AbstractReimbursement(int id2, int amount2, int submitted2, int resolved, String description, int receipt,
			int receipt2, int author2, int resolver2, int statusid, int typeid) {
		// TODO Auto-generated constructor stub
	}*/

	public AbstractReimbursement(int id, int amount, Date submitted, Date resolved, String description, int receipt,
			int author, int resolver, int statusid, int typeid) {
		super();
		this.id = id;
        this.amount = amount;
        this.submitted = submitted;
        this.resolved = resolved;
        this.description = description;
        this.receipt = receipt;
        this.author = author;
        this.resolver = resolver;
        this.statusid = statusid;
        this.typeid = typeid;
		
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getamount() {
        return amount;
    }

    public void setamount(int amount) {
        this.amount = amount;
    }
    public Date getsubmitted() {
		return submitted;
	}

	public void setsubmitted(Date submitted) {
		this.submitted = submitted;
	}

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public int getResolver() {
        return resolver;
    }

    public void setResolver(int resolver) {
        this.resolver = resolver;
    }

   
    public int getreceipt() {
  		return receipt;
  	}

  	public void setRecepit(int receipt) {
  		this.receipt = receipt;
  	}

  	public Date getresolved() {
  		return resolved;
  	}

  	public void setResolved(Date resolved) {
  		this.resolved = resolved;
  	}

  	public String getDescription() {
  		return description;
  	}

  	public void setDescription(String description) {
  		this.description = description;
  	}

  	public int getstatusid() {
  		return statusid;
  	}

  	public void setstatusid(int statusid) {
  		this.statusid = statusid;
  	}
  	public int getTypeid() {
  		return typeid;
  	}

  	public void setTypeid(int typeid) {
  		this.typeid = typeid;
  	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractReimbursement that = (AbstractReimbursement) o;
        return id == that.id && Double.compare(that.amount, amount) == 0 && status == that.status && Objects.equals(author, that.author) && Objects.equals(resolver, that.resolver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, author, resolver, amount);
    }

    @Override
    public String toString() {
        return "AbstractReimbursement{" +
                "id=" + id +
                ", status=" + ConstantVariable.statusFinder(statusid) +
                ", author=" + author +
                ", resolver=" + resolver +
                ", amount=" + amount +
                '}';
    }
}
