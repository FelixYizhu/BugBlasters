import java.util.Scanner;


public class ReturnBookUi { //ReturnBookUI is changed to ReturnBookUi

	public static enum UiState { INITIALISED, READY, INSPECTING, COMPLETED }; //UI_STATE is changed to UiState

	private ReturnBookControl control; //CoNtRoL is changed to control
	private Scanner input;
	private UiState state; //UI_STATE is changed to UiState and StATe is changed to state

	
	public returnBookUi(ReturnBookControl control) { //ReturnBookUi is changed to returnBookUi
		this.control = control; //CoNtRoL is changed to control and control is changed to control
		input = new Scanner(System.in);
		State = UiState.INITIALISED;//StATe is changed to state and UI_STATE is changed to UiState
		control.setUi(this);//Set_UI is changed to setUi
	}


	public void run() { //RuN is changed to run		
		output("Return Book Use Case UI\n");
		
		while (true) {
			
			switch (state) { //StATe is changed to state
			
			case INITIALISED:
				break;
				
			case READY:
				String bookStr = input("Scan Book (<enter> completes): "); //Book_STR is changed to bookStr
				if (bookStr.length() == 0) { //Book_STR is changed to bookStr
					control.scanningComplete(); //CoNtRoL.Scanning_Complete is changed to control.scanningComplete
				}
				else {
					try {
						int bookId = Integer.valueOf(bookStr).intValue(); //Book_Id is changed to bookId and Book_STR is changed to bookStr
						control.bookScanned(bookId);//CoNtRoL.Book_scanned(Book_Id) is changed to control.bookScanned(bookId)
					}
					catch (NumberFormatException e) {
						output("Invalid bookId");
					}					
				}
				break;				
				
			case INSPECTING:
				String answer = input("Is book damaged? (Y/N): ");//ans is changed to answer
				boolean isDamaged = false; //Is_Damaged is changed to isDamaged
				if (answer.toUpperCase().equals("Y")) { //ans.toUpperCase is changed to answer.toUpperCase()					
					isDamaged = true;//Is_Damaged is changed to isDamaged
				}
                                control.dischargeLoan(isDamaged); //CoNtRoL.Discharge_loan(Is_Damaged) is changed to control.dischargeLoan(isDamaged)
			
			case COMPLETED:
				output("Return processing complete");
				return;
			
			default:
				output("Unhandled state");
				throw new RuntimeException("ReturnBookUI : unhandled state :" + state);	//StATe is changed to state		
			}
		}
	}

	
	private String input(String prompt) {
		System.out.print(prompt);
		return input.nextLine();
	}	
		
		
	private void output(Object object) {
		System.out.println(object);
	}
	
			
	public void display(Object object) {
		output(object);
	}
	
	public void setState(UiState state) { //Set_State is changed to setState,UI_STATE is changed to UiState
		this.state = state; //this.StATe = state is changed to this.state = state 
	}

	
}
