import java.util.ArrayList;

class UserName {
	// The list of possible user names, based on a user’s first and last names and initialized by the constructor.
	private ArrayList<String> possibleNames;

	/** Constructs a UserName object as described in part (a).
	 * Precondition: firstName and lastName have length greater than 0
	 * and contain only uppercase and lowercase letters.
	 */
	public UserName(String firstName, String lastName) {
		// Must initialize possibleNames
		possibleNames = new ArrayList<String>();

		for (int ToIndex = 1; ToIndex <= firstName.length(); ++ToIndex) {
			possibleNames.add(lastName + firstName.substring(0, ToIndex));
		}
	}

	/** Returns true if arr contains name, and false otherwise. */
	// NOT PART OF FRQ -- implementation for testing
	public boolean isUsed(String name, String[] arr) {
		for (String Str : arr) {
			if (Str.equals(name)) {
				return true;
			}
		}
		return false;
	}

	/** Removes strings from possibleNames that are found in usedNames as described in part (b).
	 */
	public void setAvailableUserNames(String[] usedNames) {
		// Go backwards to avoid index clashing after removing items
		for (int Index = possibleNames.size() - 1; Index >= 0; --Index) {
			if (isUsed(possibleNames.get(Index), usedNames)) {
				possibleNames.remove(Index);
			}
		}
	}

	// Testing method
	public void PrintPossibleNames() {
		for (String Name : possibleNames) {
			System.out.println(Name);
		}
	}
}

public class FRQ1 {
	public static void main(String[] args) {
		// Test data
		String[] used = {"harta", "hartm", "harty"};
		UserName person2 = new UserName("mary", "hart");
		person2.PrintPossibleNames();
		System.out.println("------------");
		person2.setAvailableUserNames(used);
		person2.PrintPossibleNames();
	}
}
