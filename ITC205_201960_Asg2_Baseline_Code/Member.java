import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public class Member implements Serializable {//member should be as Member

	private String lastName;//LN should be as lastName
	private String firstName;//FN should be as firstName
	private String email;//EM should be as email
	private int phoneNo;//PN should be as phoneNo
	private int id;//ID should be as id
	private double fines;//FINES should be as fines
	
	private Map<Integer, loan> loanMap;//LNS should be as loanMap

	
	public Member(String lastName, String firstName, String email, int phoneNo, int id) {//member should be as Member
		this.lastName = lastName;//LN should be as lastName
		this.firstName = firstName;//FN should be as firstName
		this.email = email;//EM should be as email
		this.phoneNo = phoneNo;//PN should be as phoneNo
		this.id = id;//ID should be as id
		
		this.loanMap = new HashMap<>();//LNS should be as loanMap
	}

	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Member:  ").append(id).append("\n")//ID should be as id
		  .append("  Name:  ").append(lastName).append(", ").append(firstName).append("\n")//LN should be as lastName and FN should be as firstName
		  .append("  Email: ").append(email).append("\n")//EM should be as email
		  .append("  Phone: ").append(phoneNo)//PN should be as phoneNo
		  .append("\n")
		  .append(String.format("  Fines Owed :  $%.2f", fines))//FINES should be as fines
		  .append("\n");
		
		for (Loan loan : loanMap.values()) {//loan loan should be as Loan loan and LNS should be as loanMap
			sb.append(loan).append("\n");//LoAn should be as loan
		}		  
		return sb.toString();
	}

	
	public int getId() {//GeT_ID should be as getId
		return id;//ID should be as id
	}

	
	public List<loan> getLoans() {//GeT_LoAnS should be as getLoans
		return new ArrayList<loan>(loanMap.values());//LNS should be as loanMap
	}

	
	public int numberOfCurrentLoans() {//Number_Of_Current_Loans should be as numberOfCurrentLoans
		return loanMap.size();//LNS should be as loanMap
	}

	
	public double finesOwed() {//Fines_OwEd should be as finesOwed
		return fines;//FINES should be as fines
	}

	
	public void takeOutLoan(Loan loan) {//Take_Out_Loan should be as takeOutLoan and //loan loan should be as Loan loan
		if (!loanMap.containsKey(loan.id())) {//ID should be as id and LNS should be as loanMap
			loanMap.put(loan.id(), loan);//ID should be as id and LNS should be as loanMap
		}
		else {
			throw new RuntimeException("Duplicate loan added to member");
		}		
	}

	
	public String getLastName() {//Get_LastName should be as getLastName
		return lastName;//LN should be as lastName
	}

	
	public String getFirstName() {//Get_FirstName should be as getFirstName
		return firstName;//FN should be as firstName
	}


	public void addFine(double fine) {//Add_Fine should be as addFine
		fines += fine;//FINES should be as fines
	}
	
	public double payFine(double amount) {//Pay_Fine should be as payFine and AmOuNt should be as amount
		if (amount < 0) {//AmOuNt should be as amount
			throw new RuntimeException("Member.payFine: amount must be positive");
		}
		double change = 0;
		if (amount > fines) {//FINES should be as fines and AmOuNt should be as amount
			change = amount - fines;//FINES should be as fines and AmOuNt should be as amount
			fines = 0;//FINES should be as fines
		}
		else {
			fines -= amount;//FINES should be as fines and AmOuNt should be as amount
		}
		return change;
	}


	public void dischargeLoan(Loan loan) {//LoAn should be as loan and dIsChArGeLoAn should be as dischargeLoan and loan loan should be as Loan loan
		if (loanMap.containsKey(loan.id())) {//ID should be as id and LoAn should be as loan and LNS should be as loanMap
			loanMap.remove(loan.id());//ID should be as id and LoAn should be as loan and LNS should be as loanMap
		}
		else {
			throw new RuntimeException("No such loan held by member");
		}		
	}

}
