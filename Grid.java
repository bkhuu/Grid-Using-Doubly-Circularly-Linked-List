
public class Grid {
	private int rows, cols, printwidth;
	private Node head;	
	// getter for rows
	public int getRows() {
		return rows;
	}
	// getter for cols
	public int getCols() {
		return cols;
	}
	// grid constructor takes no arguments
	public Grid() {
		this.rows = 10; // default value of rows is 10
		this.cols = 6; // default value of cols is 6
		this.printwidth = 10; //default value of printwidth is 10
		this.head = new Node(new Value()); // initialize head with a new node
	}
	// create and link the nodes of a default sized grid
	public void buildGrid() {
		// first set of loops to link the first column and all of the rows
		Node currentcol = head, currentrow = head;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (j == (cols - 1)) { // circularly link the last node to the first 
					currentcol.setRight(currentrow);
				}
				else {
					currentcol.setRight(new Node(new Value())); // set currentcol's right pointer to a new node
					currentcol = currentcol.getRight(); // set currentcol to its right pointer
				}
			}
			if (i == (rows - 1)) { // circularly link the last node to the head
				currentrow.setDown(head);
			}
			else {
				currentrow.setDown(new Node(new Value())); // set currentrow's down pointer to a new node
				currentrow = currentrow.getDown(); // set currentrow to its down pointer
			}
			currentcol = currentrow; // set currentcol to currentrow
		}
		// second set of loops to link the rest of the columns
		Node current = head;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				current.getRight().setDown(current.getDown().getRight()); // set current's right pointer's down pointer to current's down pointer's right pointer
				current = current.getRight(); // set current to its right pointer
			}
			current = current.getDown(); // set current to its down pointer
		}
	}
	// return a node
	public Node getNode(int row, int col) {
		Node currentcol = head, currentrow = head;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (i == row && j == col){ // node is the one entered
					return currentcol;
				}
				currentcol = currentcol.getRight(); // set currentcol to its right pointer
			}
			currentrow = currentrow.getDown(); // set currentrow to its down pointer
			currentcol = currentrow; // set currentcol to currentrow
		}
		return null;
	}
	// display the grid
	public void printGrid() {
		Node currentcol = head, currentrow = head;
		String output = null, row = null, col = null;
		System.out.print("          "); // print the blank space between row 0 and col 0
		// the first row of text is the cols
		for (int a = 0; a < cols; a++) {
			col = "col " + a; // set col to col + the col number
			// add spaces to col if its length is less than printwidth
			if (col.length() < printwidth) {
				for ( int b = col.length(); b < printwidth; b++) {
					col += " ";
				}
			}
			if (a == (cols - 1)) { // print and move the cursor to the next line
				System.out.println(col);
			}
			else {
				System.out.print(col);
			}
		}
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				output = currentcol.getValue().toString(); // set the output to currentcol's value
				row = "row " + i; // set row to row + the row number
				// trim or add spaces to output if its length is more or less than printwidth
				if (output.length() > printwidth) {
					output = output.substring(0, printwidth);
				}
				else {
					for ( int k = output.length(); k < printwidth; k++) {
						output += " ";
					}
				}
				// add spaces to row if its length is less than printwidth
				if (row.length() < printwidth) {
					for ( int c = row.length(); c < printwidth; c++) {
						row += " ";
					}
				}
				if (j == (cols - 1)) { // print and move the cursor to the next line
					if (j == 0 && cols == 1) { // print rows when there is only one col
						System.out.print(row);
					}
					System.out.println(output);
				}
				else { // print and leave the cursor on the current line
					if (j == 0) { // the first col of text is the rows
						System.out.print(row);
					}
					System.out.print(output);
					currentcol = currentcol.getRight(); // set currentcol to its right pointer
				}
			}
			currentrow = currentrow.getDown(); // set currentrow to its down pointer
			currentcol = currentrow; // set currentcol to currentrow
		}
	}
	// number the subgrid
	public void numberGrid(int fromrow, int torow, int fromcol, int tocol) {
		Node currentcol = head, currentrow = head;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (i >= fromrow && i <= torow && j >= fromcol && j <= tocol){ // node is in the subgrid
					currentcol.getValue().setDval((i * cols) + j); // numbers begin at 0
					currentcol.getValue().setTag("DBL");
				}
				currentcol = currentcol.getRight(); // set currentcol to its right pointer
			}
			currentrow = currentrow.getDown(); // set currentrow to its down pointer
			currentcol = currentrow; // set currentcol to currentrow
		}
	}
	// change values of the subgrid
	public void fillGrid(int fromrow, int torow, int fromcol, int tocol, String value) {
		Node currentcol = head, currentrow = head;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (i >= fromrow && i <= torow && j >= fromcol && j <= tocol){ // node is in the subgrid
					if (value.charAt(0) == '"') { // set value as a string if input begins with "
						currentcol.getValue().setSval(value.substring(1));
						currentcol.getValue().setTag("STRING");
					}
					else {
						try { // attempt to convert input to a double
							currentcol.getValue().setDval(Double.parseDouble(value));
							currentcol.getValue().setTag("DBL");
						}
						catch (Exception e) { // print error message and exit method
							System.out.println("Value can't be converted to double.");
							return;
						}
					}
				}
				currentcol = currentcol.getRight(); // set currentcol to its right pointer
			}
			currentrow = currentrow.getDown(); // set currentrow to its down pointer
			currentcol = currentrow; // set currentcol to currentrow
		}
	}
	// add two cells
	public void addCells(int row1, int col1, int row2, int col2, int row3, int col3) {
		Node node1 = getNode(row1, col1);
		Node node2 = getNode(row2, col2);
		Node node3 = getNode(row3, col3);
		if (node1.getValue().plus(node2.getValue()).getTag() != "INVALID") { // nodes with INVALID tags are not put into the grid
			node3.setValue(node1.getValue().plus(node2.getValue()));
		}
	}
	// multiply two cells
	public void multiplyCells(int row1, int col1, int row2, int col2, int row3, int col3) {
		Node node1 = getNode(row1, col1);
		Node node2 = getNode(row2, col2);
		Node node3 = getNode(row3, col3);
		if (node1.getValue().star(node2.getValue()).getTag() != "INVALID") { // nodes with INVALID tags are not put into the grid
			node3.setValue(node1.getValue().star(node2.getValue()));
		}
	}
	// subtract two cells
	public void subtractCells(int row1, int col1, int row2, int col2, int row3, int col3) {
		Node node1 = getNode(row1, col1);
		Node node2 = getNode(row2, col2);
		Node node3 = getNode(row3, col3);
		if (node1.getValue().minus(node2.getValue()).getTag() != "INVALID") { // nodes with INVALID tags are not put into the grid
			node3.setValue(node1.getValue().minus(node2.getValue()));
		}
	}
	// divide two cells
	public void divideCells(int row1, int col1, int row2, int col2, int row3, int col3) {
		Node node1 = getNode(row1, col1);
		Node node2 = getNode(row2, col2);
		Node node3 = getNode(row3, col3);
		if (node1.getValue().slash(node2.getValue()).getTag() != "INVALID") { // nodes with INVALID tags are not put into the grid
			node3.setValue(node1.getValue().slash(node2.getValue()));
		}
	}
	// change the tag of a cell
	public void assignCell(int row1, int col1, String tag) {
		Node node1 = getNode(row1, col1);
		switch(tag) { // two possible tags
		case "DBL" :
			node1.getValue().setTag("DBL");
			break;
		case "STRING" :
			node1.getValue().setTag("STRING");
			break;
		default : // print error message
			System.out.println("Not a proper tag.");
		}
	}
	// add cells of entire rows
	public void addRows(int row1, int row2, int row3) {
		for (int i = 0; i < cols; i++) {
			addCells(row1, i, row2, i, row3, i);
		}
	}
	// multiply cells of entire rows
	public void multiplyRows(int row1, int row2, int row3) {
		for (int i = 0; i < cols; i++) {
			multiplyCells(row1, i, row2, i, row3, i);
		}
	}
	// subtract cells of entire rows
	public void subtractRows(int row1, int row2, int row3) {
		for (int i = 0; i < cols; i++) {
			subtractCells(row1, i, row2, i, row3, i);
		}
	}
	// divide cells of entire rows
	public void divideRows(int row1, int row2, int row3) {
		for (int i = 0; i < cols; i++) {
			divideCells(row1, i, row2, i, row3, i);
		}
	}
	// add cells of entire cols
	public void addCols(int col1, int col2, int col3) {
		for (int i = 0; i < rows; i++) {
			addCells(i, col1, i, col2, i, col3);
		}
	}
	// multiply cells of entire cols
	public void multiplyCols(int col1, int col2, int col3) {
		for (int i = 0; i < rows; i++) {
			multiplyCells(i, col1, i, col2, i, col3);
		}
	}
	// subtract cells of entire cols
	public void subtractCols(int col1, int col2, int col3) {
		for (int i = 0; i < rows; i++) {
			subtractCells(i, col1, i, col2, i, col3);
		}
	}
	// divide cells of entire cols
	public void divideCols(int col1, int col2, int col3) {
		for (int i = 0; i < rows; i++) {
			divideCells(i, col1, i, col2, i, col3);
		}
	}
	// insert row at an existing row
	public void insertRow(int row1) {
		Node temphead = new Node(new Value()), newrow = temphead, rowabove = null;
		for (int i = 0; i < cols; i++) {
			if (i == (cols - 1)) { // circularly link the last node to the first 
				newrow.setRight(temphead);
			}
			else {
				newrow.setRight(new Node(new Value())); // set newrow's right pointer to a new node
				newrow = newrow.getRight(); // set newrow to its right pointer
			}
		}
		
		
		if (row1 == 0) { // rowabove the first row is the last row
			rowabove = getNode(rows - 1, 0);
		}
		else {
			rowabove = getNode(row1 - 1, 0);
		}
		for (int i = 0; i < cols; i++) {
			newrow.setDown(rowabove.getDown()); // set newrow's down pointers to rowabove's down pointers
			rowabove.setDown(newrow); // set rowabove's down pointers to newrow
			rowabove = rowabove.getRight();
			newrow = newrow.getRight();
		}
		if (row1 == 0) { // newrow becomes the new head
			head = newrow;
		}
		rows++;
	}
	// delete an existing row
	public void deleteRow(int row1) {
		if (rows == 1) { // need at least one row
			System.out.println("Can't delete anymore rows.");
		}
		else {
			Node rowabove = null, currentrow = getNode(row1, 0);
			if (row1 == 0) { // rowabove the first row is the last row
				head = head.getDown(); // node below head becomes the new head
				rowabove = getNode(rows - 1, 0);
			}
			else {
				rowabove = getNode(row1 - 1, 0);
			}
			for (int i = 0; i < cols; i++) {
				rowabove.setDown(currentrow.getDown()); // set rowabove's down pointers to currentrow's down pointers
				rowabove = rowabove.getRight(); 
				currentrow = currentrow.getRight();
			}
			rows--;
		}
	}
	// insert col at an existing col
	public void insertCol(int col1) {
		Node temphead = new Node(new Value()), newcol = temphead, colbefore = null;
		for (int i = 0; i < rows; i++) {
			if (i == (rows - 1)) { // circularly link the last node to the first 
				newcol.setDown(temphead);
			}
			else {
				newcol.setDown(new Node(new Value())); // set newrow's right pointer to a new node
				newcol = newcol.getDown(); // set newrow to its right pointer
			}
		}
		
		
		if (col1 == 0) { // colbefore the first col is the last col
			colbefore = getNode(0, cols - 1);
		}
		else {
			colbefore = getNode(0, col1 - 1);
		}
		for (int i = 0; i < rows; i++) {
			newcol.setRight(colbefore.getRight()); // set newcol's right pointers to colbefore's right pointers
			colbefore.setRight(newcol); // set colbefore's right pointers to newcol
			colbefore = colbefore.getDown();
			newcol = newcol.getDown();
		}
		if (col1 == 0) {
			head = newcol; // newcol becomes the new head
		}
		cols++;
	}
	// delete an existing col
	public void deleteCol(int col1) {
		if (cols == 1) { // need at least one col
			System.out.println("Can't delete anymore cols.");
		}
		else {
			Node colbefore = null, currentcol = getNode(0, col1);
			if (col1 == 0) { // colbefore the first col is the last col
				head = head.getRight(); // node to the right of head becomes the new head
				colbefore = getNode(0, cols - 1);
			}
			else {
				colbefore = getNode(0, col1 - 1);
			}
			for (int i = 0; i < cols; i++) {
				colbefore.setRight(currentcol.getRight()); // set colbefore's right pointers to currentcol's right pointers
				colbefore = colbefore.getDown();
				currentcol = currentcol.getDown();
			}
			cols--;
		}
	}
}