import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); // open the scanner
		Grid grid = new Grid(); // create a grid object
		boolean on = true; // loop variable
		String entry = null, value = null, tag = null;
		int fromrow = 0, torow = 0, fromcol = 0, tocol = 0;
		int row1 = 0, col1 = 0, row2 = 0, col2 = 0, row3 = 0, col3 = 0;

		grid.buildGrid(); // construct the grid
		
		// print the menu
		System.out.println("Operations");
		System.out.println("   display           dis           assign cell       as");
		System.out.println("   fill              f             number            n");
		System.out.println("   add cells         a             subtract cells    s");
		System.out.println("   multiply cells    m             divide cells      d");
		System.out.println("   add rows          ar            subtract rows     sr");
		System.out.println("   multiply rows     mr            divide rows       dr");
		System.out.println("   add columns       ac            subtract columns  sc");
		System.out.println("   multiply columns  mc            divide columns    dc");
		System.out.println("   insert row        ir            insert column     ic");
		System.out.println("   delete row        delr          delete column     delc");
		System.out.println("   quit              q");
		// loop until the program is ended
		while (on) {
			// print the cursor
			System.out.print("-> ");
			if (in.hasNextLine()) {
				entry = in.nextLine(); // set entry to the text entered
			}
			switch(entry) {
				case "dis" :
					grid.printGrid(); // display the grid with rows and cols
					break;
				case "f" :
					System.out.print("from row: ");
					if (in.hasNextInt()) { // make sure input can be converted to int
						fromrow = in.nextInt();
						System.out.print("from column: ");
						if (in.hasNextInt()) { // "
							fromcol = in.nextInt();
							System.out.print("to row: ");
							if (in.hasNextInt()) { // "
								torow = in.nextInt();
								System.out.print("to column: ");
								if (in.hasNextInt()) { // "
									tocol = in.nextInt();
									in.nextLine();
									System.out.print("with value: ");
									if (in.hasNext()) {
										value = in.nextLine();
										if (fromrow < 0 || fromrow > grid.getRows() - 1 || fromcol < 0 || fromcol > grid.getCols() - 1 || torow < fromrow || torow > grid.getRows() - 1 || tocol < fromcol  || tocol > grid.getCols() - 1) { // make sure subgrid is in the grid
											System.out.println("Subgrid not in the grid.");
										}
										else {
											grid.fillGrid(fromrow, torow, fromcol, tocol, value); // fill the subgrid with the value
										}
									}
								}
							}
						}
					}
					break;
				case "a" :
					System.out.print("first node row: ");
					if (in.hasNextInt()) { // make sure input can be converted to int
						row1 = in.nextInt();
						System.out.print("first node column: ");
						if (in.hasNextInt()) { // "
							col1 = in.nextInt();
							System.out.print("second node row: ");
							if (in.hasNextInt()) { // "
								row2 = in.nextInt();
								System.out.print("second node column: ");
								if (in.hasNextInt()) { // "
									col2 = in.nextInt();
									System.out.print("destination node row: ");
									if (in.hasNextInt()) { // "
										row3 = in.nextInt();
										System.out.print("destination node column: ");
										if (in.hasNextInt()) { // "
											col3 = in.nextInt();					
											if (row1 < 0 || row1 > grid.getRows() - 1 || col1 < 0 || col1 > grid.getCols() - 1 || row2 < 0 || row2 > grid.getRows() - 1 || col2 < 0 || col2 > grid.getCols() - 1 || row3 < 0 || row3 > grid.getRows() - 1 || col3 < 0 || col3 > grid.getCols() - 1) { // make sure the nodes are in the grid
												System.out.println("Node(s) not in the grid.");
											}
											else {
												grid.addCells(row1, col1, row2, col2, row3, col3); // add the cells
											}
										}
									}
								}
							}
						}
					}
					in.nextLine();
					break;
				case "m" :
					System.out.print("first node row: ");
					if (in.hasNextInt()) { // make sure input can be converted to int
						row1 = in.nextInt();
						System.out.print("first node column: ");
						if (in.hasNextInt()) { // "
							col1 = in.nextInt();
							System.out.print("second node row: ");
							if (in.hasNextInt()) { // "
								row2 = in.nextInt();
								System.out.print("second node column: ");
								if (in.hasNextInt()) { // "
									col2 = in.nextInt();
									System.out.print("destination node row: ");
									if (in.hasNextInt()) { // "
										row3 = in.nextInt();
										System.out.print("destination node column: ");
										if (in.hasNextInt()) { // "
											col3 = in.nextInt();					
											if (row1 < 0 || row1 > grid.getRows() - 1 || col1 < 0 || col1 > grid.getCols() - 1 || row2 < 0 || row2 > grid.getRows() - 1 || col2 < 0 || col2 > grid.getCols() - 1 || row3 < 0 || row3 > grid.getRows() - 1 || col3 < 0 || col3 > grid.getCols() - 1) { // make sure the nodes are in the grid
												System.out.println("Node(s) not in the grid.");
											}
											else {
												grid.multiplyCells(row1, col1, row2, col2, row3, col3); // multiply the cells
											}
										}
									}
								}
							}
						}
					}
					in.nextLine();
					break;
				case "ar" :
					System.out.print("first row: ");
					if (in.hasNextInt()) { // make sure input can be converted to int
						row1 = in.nextInt();
						System.out.print("second row: ");
						if (in.hasNextInt()) { // "
							row2 = in.nextInt();
							System.out.print("target row: ");
							if (in.hasNextInt()) { // "
								row3 = in.nextInt();
								if (row1 < 0 || row1 > grid.getRows() - 1 || row2 < 0 || row2 > grid.getRows() - 1 || row3 < 0 || row3 > grid.getRows() - 1) { // make sure the rows are in the grid
									System.out.println("Row(s) not in the grid.");
								}
								else {
									grid.addRows(row1, row2, row3); // add the rows
								}
							}
						}
					}
					in.nextLine();
					break;
				case "mr" :
					System.out.print("first row: ");
					if (in.hasNextInt()) { // make sure input can be converted to int
						row1 = in.nextInt();
						System.out.print("second row: ");
						if (in.hasNextInt()) { // "
							row2 = in.nextInt();
							System.out.print("target row: ");
							if (in.hasNextInt()) { // "
								row3 = in.nextInt();
								if (row1 < 0 || row1 > grid.getRows() - 1 || row2 < 0 || row2 > grid.getRows() - 1 || row3 < 0 || row3 > grid.getRows() - 1) { // make sure the rows are in the grid
									System.out.println("Row(s) not in the grid.");
								}
								else {
									grid.multiplyRows(row1, row2, row3); // multiply the rows
								}
							}
						}
					}
					in.nextLine();
					break;
				case "ac" :
					System.out.print("first col: ");
					if (in.hasNextInt()) { // make sure input can be converted to int
						col1 = in.nextInt();
						System.out.print("second col: ");
						if (in.hasNextInt()) { // "
							col2 = in.nextInt();
							System.out.print("target col: ");
							if (in.hasNextInt()) { // "
								col3 = in.nextInt();
								if (col1 < 0 || col1 > grid.getCols() - 1 || col2 < 0 || col2 > grid.getCols() - 1 || col3 < 0 || col3 > grid.getCols() - 1) { // make sure the columns are in the grid
									System.out.println("Col(s) not in the grid.");
								}
								else {
									grid.addCols(col1, col2, col3); // add the columns
								}
							}
						}
					}
					in.nextLine();
					break;
				case "mc" :
					System.out.print("first col: ");
					if (in.hasNextInt()) { // make sure input can be converted to int
						col1 = in.nextInt();
						System.out.print("second col: ");
						if (in.hasNextInt()) { // "
							col2 = in.nextInt();
							System.out.print("target col: ");
							if (in.hasNextInt()) { // "
								col3 = in.nextInt();
								if (col1 < 0 || col1 > grid.getCols() - 1 || col2 < 0 || col2 > grid.getCols() - 1 || col3 < 0 || col3 > grid.getCols() - 1) { // make sure the columns are in the grid
									System.out.println("Col(s) not in the grid.");
								}
								else {
									grid.multiplyCols(col1, col2, col3); // multiply the columns
								}
							}
						}
					}
					in.nextLine();
					break;
				case "ir" :
					System.out.print("at row: ");
					if (in.hasNextInt()) { // make sure input can be converted to int
						row1 = in.nextInt();
						if (row1 < 0 || row1 > grid.getRows() - 1) { // make sure the row is in the grid
							System.out.println("Not in the grid.");
						}
						else {
							grid.insertRow(row1); // insert a row
						}
					}
					in.nextLine();
					break;
				case "delr" :
					System.out.print("row: ");
					if (in.hasNextInt()) { // make sure input can be converted to int
						row1 = in.nextInt();
						if (row1 < 0 || row1 > grid.getRows() - 1) { // make sure the row is in the grid
							System.out.println("Not in the grid.");
						}
						else {
							grid.deleteRow(row1); // delete the row
						}
					}
					in.nextLine();
					break;
				case "q" :
					in.close(); // close the scanner
					System.out.println("Goodbye.");
					on = false; // exit the program
					break;
				case "as" :
					System.out.print("node row: ");
					if (in.hasNextInt()) { // make sure input can be converted to int
						row1 = in.nextInt();
						System.out.print("node column: ");
						if (in.hasNextInt()) { // "
							col1 = in.nextInt();
							in.nextLine();
							System.out.print("with tag: ");
							if (in.hasNext()) {
								tag = in.nextLine();
								if (row1 < 0 || row1 > grid.getRows() - 1 || col1 < 0 || col1 > grid.getCols() - 1) { // make sure the node is in the grid
									System.out.println("Node not in the grid.");
								}
								else {
									grid.assignCell(row1, col1, tag); // assign the tag of the node
								}
							}
						}
					}
					break;
				case "n" :
					System.out.print("from row: ");
					if (in.hasNextInt()) { // make sure input can be converted to int
						fromrow = in.nextInt();
						System.out.print("from column: ");
						if (in.hasNextInt()) { // "
							fromcol = in.nextInt();
							System.out.print("to row: ");
							if (in.hasNextInt()) { // "
								torow = in.nextInt();
								System.out.print("to column: ");
								if (in.hasNextInt()) { // "
									tocol = in.nextInt();
									if (fromrow < 0 || fromrow > grid.getRows() - 1 || fromcol < 0 || fromcol > grid.getCols() - 1 || torow < fromrow || torow > grid.getRows() - 1 || tocol < fromcol  || tocol > grid.getCols() - 1) { // make sure the subgrid is in the grid
										System.out.println("Subgrid not in the grid.");
									}
									else {
										grid.numberGrid(fromrow, torow, fromcol, tocol); // number the subgrid
									}
								}
							}
						}
					}
					in.nextLine();
					break;
				case "s" :
					System.out.print("first node row: ");
					if (in.hasNextInt()) { // make sure input can be converted to int
						row1 = in.nextInt();
						System.out.print("first node column: ");
						if (in.hasNextInt()) { // "
							col1 = in.nextInt();
							System.out.print("second node row: ");
							if (in.hasNextInt()) { // "
								row2 = in.nextInt();
								System.out.print("second node column: ");
								if (in.hasNextInt()) { // "
									col2 = in.nextInt();
									System.out.print("destination node row: ");
									if (in.hasNextInt()) { // "
										row3 = in.nextInt();
										System.out.print("destination node column: ");
										if (in.hasNextInt()) { // "
											col3 = in.nextInt();					
											if (row1 < 0 || row1 > grid.getRows() - 1 || col1 < 0 || col1 > grid.getCols() - 1 || row2 < 0 || row2 > grid.getRows() - 1 || col2 < 0 || col2 > grid.getCols() - 1 || row3 < 0 || row3 > grid.getRows() - 1 || col3 < 0 || col3 > grid.getCols() - 1) { // make sure the nodes are in the grid
												System.out.println("Node(s) not in the grid.");
											}
											else {
												grid.subtractCells(row1, col1, row2, col2, row3, col3); // subtract the cells
											}
										}
									}
								}
							}
						}
					}
					in.nextLine();
					break;
				case "d" :
					System.out.print("first node row: ");
					if (in.hasNextInt()) { // make sure input can be converted to int
						row1 = in.nextInt();
						System.out.print("first node column: ");
						if (in.hasNextInt()) { // "
							col1 = in.nextInt();
							System.out.print("second node row: ");
							if (in.hasNextInt()) { // "
								row2 = in.nextInt();
								System.out.print("second node column: ");
								if (in.hasNextInt()) { // "
									col2 = in.nextInt();
									System.out.print("destination node row: ");
									if (in.hasNextInt()) { // "
										row3 = in.nextInt();
										System.out.print("destination node column: ");
										if (in.hasNextInt()) { // "
											col3 = in.nextInt();					
											if (row1 < 0 || row1 > grid.getRows() - 1 || col1 < 0 || col1 > grid.getCols() - 1 || row2 < 0 || row2 > grid.getRows() - 1 || col2 < 0 || col2 > grid.getCols() - 1 || row3 < 0 || row3 > grid.getRows() - 1 || col3 < 0 || col3 > grid.getCols() - 1) { // make sure the nodes are in the grid
												System.out.println("Node(s) not in the grid.");
											}
											else {
												grid.divideCells(row1, col1, row2, col2, row3, col3); // divide the cells
											}
										}
									}
								}
							}
						}
					}
					in.nextLine();
					break;
				case "sr" :
					System.out.print("first row: ");
					if (in.hasNextInt()) { // make sure input can be converted to int
						row1 = in.nextInt();
						System.out.print("second row: ");
						if (in.hasNextInt()) { // "
							row2 = in.nextInt();
							System.out.print("target row: ");
							if (in.hasNextInt()) { // "
								row3 = in.nextInt();
								if (row1 < 0 || row1 > grid.getRows() - 1 || row2 < 0 || row2 > grid.getRows() - 1 || row3 < 0 || row3 > grid.getRows() - 1) { // make sure the rows are in the grid
									System.out.println("Row(s) not in the grid.");
								}
								else {
									grid.subtractRows(row1, row2, row3); // subtract the rows
								}
							}
						}
					}
					in.nextLine();
					break;
				case "dr" :
					System.out.print("first row: ");
					if (in.hasNextInt()) { // make sure input can be converted to int
						row1 = in.nextInt();
						System.out.print("second row: ");
						if (in.hasNextInt()) { // "
							row2 = in.nextInt();
							System.out.print("target row: ");
							if (in.hasNextInt()) { // "
								row3 = in.nextInt();
								if (row1 < 0 || row1 > grid.getRows() - 1 || row2 < 0 || row2 > grid.getRows() - 1 || row3 < 0 || row3 > grid.getRows() - 1) { // make sure the rows are in the grid
									System.out.println("Row(s) not in the grid.");
								}
								else {
									grid.divideRows(row1, row2, row3); // divide the rows
								}
							}
						}
					}
					in.nextLine();
					break;
				case "sc" :
					System.out.print("first col: ");
					if (in.hasNextInt()) { // make sure input can be converted to int
						col1 = in.nextInt();
						System.out.print("second col: ");
						if (in.hasNextInt()) { // "
							col2 = in.nextInt();
							System.out.print("target col: ");
							if (in.hasNextInt()) { // "
								col3 = in.nextInt();
								if (col1 < 0 || col1 > grid.getCols() - 1 || col2 < 0 || col2 > grid.getCols() - 1 || col3 < 0 || col3 > grid.getCols() - 1) { // make sure the columns are in the grid
									System.out.println("Col(s) not in the grid.");
								}
								else {
									grid.subtractCols(col1, col2, col3); // subtract the columns
								}
							}
						}
					}
					in.nextLine();
					break;
				case "dc" :
					System.out.print("first col: ");
					if (in.hasNextInt()) { // make sure input can be converted to int
						col1 = in.nextInt();
						System.out.print("second col: ");
						if (in.hasNextInt()) { // "
							col2 = in.nextInt();
							System.out.print("target col: ");
							if (in.hasNextInt()) { // "
								col3 = in.nextInt();
								if (col1 < 0 || col1 > grid.getCols() - 1 || col2 < 0 || col2 > grid.getCols() - 1 || col3 < 0 || col3 > grid.getCols() - 1) { // make sure the columns are in the grid
									System.out.println("Col(s) not in the grid.");
								}
								else {
									grid.divideCols(col1, col2, col3); // divide the columns
								}
							}
						}
					}
					in.nextLine();
					break;
				case "ic" :
					System.out.print("at col: ");
					if (in.hasNextInt()) { // make sure input can be converted to int
						col1 = in.nextInt();
						if (col1 < 0 || col1 > grid.getCols() - 1) { // make sure the column is in the grid
							System.out.println("Not in the grid.");
						}
						else {
							grid.insertCol(col1); // insert a column
						}
					}
					in.nextLine();
					break;
				case "delc" :
					System.out.print("col: ");
					if (in.hasNextInt()) { // make sure input can be converted to int
						col1 = in.nextInt();
						if (col1 < 0 || col1 > grid.getCols() - 1) { // make sure the column is in the grid
							System.out.println("Not in the grid.");
						}
						else {
							grid.deleteCol(col1); // delete the column
						}
					}
					in.nextLine();
					break;
				default :
					System.out.println("Not a proper command."); // print error message
			}
		}
	}
}