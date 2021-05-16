package may2String;

public class LongPressedName {

	public static void main(String[] args) {

		String name = "alexd";
		String typed = "alleeeex";

		System.out.println(isLongPressedName(name, typed));
	}

  private static boolean isLongPressedName(String name, String typed) {
		if (name.length() > typed.length() || name.length() == 0) {
			return false;
		}
		int index = 0; // pointer to name character index
		
		for (int i = 0; i < typed.length();) {
			char n = name.charAt(index); // n== name character
			char t = typed.charAt(i);// t== typed charcter character
			if (n == t) {
				if (index < name.length() - 1 && i < typed.length() - 1)
					index++;
				i++;
			} else {
				if (index == 0 || (i == typed.length() - 1 && index == name.length() - 1))
					return false;
				char prevn = name.charAt(index - 1);
				if (t == prevn) {
					i++;
				} else {
					return false;
				}
			}
		}
		if (index < name.length() - 1) {
			return false;
		}
		return true;
	}



}
