import java.util.Scanner;


public class FixBookUI {

	public static enum UiState { INITIALISED, READY, FIXING, COMPLETED };//UI_STATE should be UiState. enum class name not include underscore.

	private FixBookControl control;//CoNtRoL should be as control
	private Scanner input;
	private UiState state;//UI_STATE should be UiState. enum class name not include underscore and StAtE should be as state

	
	public FixBookUI(FixBookControl control) {
		this.control = control;//CoNtRoL should be as control
		input = new Scanner(System.in);
		state = UiState.INITIALISED;//UI_STATE should be UiState. enum class name not include underscore and StAtE should be as state
		control.setUi(this);//Set_Ui should be as setUi
	}


	public void setState(UiState state) {//UI_STATE should be UiState and set_State should be correct as setState
		this.state = state;//StAtE should be as state
	}

	
	public void run() {//RuN should be as run
		output("Fix Book Use Case UI\n");
		
		while (true) {
			
			switch (state) {//StAtE should be as state
			
			case READY:
				String bookStr = input("Scan Book (<enter> completes): ");//Book_STR should be as bookStr
				if (bookStr.length() == 0) {//Book_STR should be as bookStr
					control.scanningComplete();//CoNtRoL should be as control and SCannING_COMplete should be as scanningComplete
				}
				else {
					try {
						int bookId = Integer.valueOf(bookStr).intValue();//Book_STR should be as bookStr and Book_ID should be as bookId
						control.bookScanned(bookId);//CoNtRoL should be as control and Book_ID should be as bookId and Book_scanned should be as bookScanned
					}
					catch (NumberFormatException e) {
						output("Invalid bookId");
					}
				}
				break;	
				
			case FIXING:
				String answer = input("Fix Book? (Y/N) : ");//AnS should be as answer
				boolean fix = false;//Fix should be as fix
				if (answer.toUpperCase().equals("Y")) {//AnS should be as answer
					fix = true;//Fix should be as fix
				}
				control.fixBook(fix);//CoNtRoL should be as control and Fix should be as fix and FIX_Book should be as fixBook
				break;
								
			case COMPLETED:
				output("Fixing process complete");
				return;
			
			default:
				output("Unhandled state");
				throw new RuntimeException("FixBookUI : unhandled state :" + state);//StAtE should be as state			
			
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
	
	
}
