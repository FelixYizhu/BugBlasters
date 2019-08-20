import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
//testing commit
@SuppressWarnings("serial")
public class Loan implements Serializable {//loan should be as Loan 
	
	public static enum LoanState { current, overDue, DISCHARGED };
	//LOAN_STATE should be LoanState and CURRENT should be current and OVER_DUE should be as overDue
	
	private int id;//ID should be as id
	private Book book;//book b should be as Book book
	private Member member;//member m should be as Member member
	private Date date;//D should be as date
	private LoanState state;//LOAN_STATE should be LoanState

	
	public Loan(int loanId, book book, member member, Date dueDate) {
		this.id = loanId;//ID should be as id
		this.book = book;//B should be as book
		this.member = member;//M should be as member
		this.date = dueDate;//D should be as date
		this.state = LoanState.current;//LOAN_STATE should be LoanState and CURRENT should be current
	}

	
	public void checkOverDue() {
		if (state == LoanState.current &&//LOAN_STATE should be LoanState and CURRENT should be current
			Calendar.getInstance().getDate().after(date)) {//D should be as date and INSTANCE should be as getInstance and Date() should be as getDate()
			this.state = LoanState.overDue;//LOAN_STATE should be LoanState and OVER_DUE should be as overDue			
		}
	}

	
	public boolean overDue() {//OVer_Due should be overDue
		return state == LoanState.overDue;//LOAN_STATE should be LoanState and OVER_DUE should be as overDue
	}

	
	public Integer id() {//ID should be as id
		return id;//ID should be as id
	}


	public Date getDueDate() {//Get_Due_Date should be as getDueDate
		return date;//D should be as date
	}
	
	
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		StringBuilder sb = new StringBuilder();
		sb.append("Loan:  ").append(id).append("\n")//ID should be as id
		  .append("  Borrower ").append(member.getId()).append(" : ")//M should be as member and GeT_ID should be as getId
		  .append(member.getLastName()).append(", ").append(m.getFirstName()).append("\n")
			//M should be as member and Get_LastName should be as getLastName and Get_FirstName should be as getFirstName
		  .append("  Book ").append(b.id()).append(" : " )//ID should be as id and B should be as b
		  .append(book.title()).append("\n")//B should be as book and TITLE should be as title
		  .append("  DueDate: ").append(sdf.format(date)).append("\n")//D should be as date
		  .append("  State: ").append(state);		
		return sb.toString();
	}


	public member getMember() {//Member should be as getMember
		return member;//M should be as member
	}


	public book getBook() {//Book should be as getBook
		return book;//B should be as book
	}


	public void discharge() {//DiScHaRgE should be as discharge
		state = LoanState.DISCHARGED;//LOAN_STATE should be LoanState		
	}

}
