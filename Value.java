
public class Value {
	private double dval; // variable to hold a double
	private String sval, tag; // variables to hold an sval and a tag
	// value constructor takes no arguments
	public Value() {
		this.dval = 0; // initialize dval with 0
		this.sval = null; // initialize sval with null
		this.tag = "STRING"; // initialize tag with STRING
	}
	// getter for double
	public double getDval() {
		return dval;
	}
	// setter for double
	public void setDval(double dval) {
		this.dval = dval;
	}
	// getter for string
	public String getSval() {
		return sval;
	}
	// setter for string
	public void setSval(String sval) {
		this.sval = sval;
	}
	// getter for tag
	public String getTag() {
		return tag;
	}
	// setter for tag
	public void setTag(String tag) {
		this.tag = tag;
	}
	// addition method takes a value as an argument and returns a new value
	public Value plus(Value value) {
		Value result = new Value(); // create a return value
		if (this.tag.equals("DBL") && value.tag.equals("DBL")) { // check if both tags are doubles
			result.dval = this.dval + value.dval; // perform addition on the doubles
			result.tag = "DBL"; // set return value tag to DBL
		}
		else {
			result.tag = "INVALID"; // set return value tag to INVALID
		}
		return result;
	}
	// subtraction method takes a value as an argument and returns a new value
	public Value minus(Value value) {
		Value result = new Value();
		if (this.tag.equals("DBL") && value.tag.equals("DBL")) { // check if both tags are doubles
			result.dval = this.dval - value.dval; // perform subtraction on the doubles
			result.tag = "DBL"; // set return value tag to DBL
		}
		else {
			result.tag = "INVALID"; // set return value tag to INVALID
		}
		return result;
	}
	// multiplication method takes a value as an argument and returns a new value
	public Value star(Value value) {
		Value result = new Value();
		if (this.tag.equals("DBL") && value.tag.equals("DBL")) { // check if both tags are doubles
			result.dval = this.dval * value.dval; // perform multiplication on the doubles
			result.tag = "DBL"; // set return value tag to DBL
		}
		else {
			result.tag = "INVALID"; // set return value tag to INVALID
		}
		return result;
	}
	// division method takes a value as an argument and returns a new value
	public Value slash(Value value) {
		Value result = new Value();
		if (this.tag.equals("DBL") && value.tag.equals("DBL")) { // check if both tags are doubles
			if (value.dval == 0) { // check for zero divisor
				System.out.println("Zero divisor(s), division(s) not performed.");
				result.tag = "INVALID"; // set return value tag to INVALID
			}
			else {
				result.dval = this.dval / value.dval; // perform division on the doubles
				result.tag = "DBL"; // set return value tag to DBL
			}
		}
		else {
			result.tag = "INVALID"; // set return value tag to INVALID
		}
		return result;
	}
	// toString method for value takes no arguments and returns a string
	@Override
	public String toString() {
		if (this.tag.equals("DBL")) { // check if the tag is DBL
			if (dval % 1 == 0) { /// print the integer value if possible
				return String.valueOf((int) dval);
			}
			else {
				if (String.valueOf(dval).substring(String.valueOf(dval).indexOf('.')).length() > 6 ) { // limit to 5 decimal places
					return String.valueOf(String.format("%.5f", dval));
				}
				else {
					return String.valueOf(dval);
				}
			}
		}
		else if (this.tag.equals("STRING")) { // check if the tag is STRING
			if (sval == null) {
				return "";
			}
			return sval;
		}
		return tag;
	}
}