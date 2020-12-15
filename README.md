# Android-simplified-SQlite-database
This is a simplified android SQlite database library project

To use it:

Add it in your root build.gradle at the end of repositories:


    allprojects {

		repositories {
			...
			maven { url 'https://jitpack.io' }
		} 
	}
  
And add the deppendency

	dependencies {
	         implementation 'com.github.adhilMhdk:Android-simplified-SQlite-database:Tag'
    }
    
    
    
Usage :
--------------------------------------------------
Example to create a new table
-----------------------------------------

Create constant Database and table name

    private static final String DATABASE_NAME = "DATABASE_NAME";
    private static final String TABLE_NAME = "TABLE_NAME";
  
Create an object for SimplifiedDatabase

    SimplifiedDatabase database = new SimplifiedDatabase(this,DATABASE_NAME);

Create an arrayList of Row models

    ArrayList<TableRowModel> arrayList = new ArrayList<>();
    
In the new TableRowModel, the first parameter is name of row and second is row type

    arrayList.add(new TableRowModel("NAME_OF_ROW",  new Types().getString())); 
    
Finally call this method to create table
    
    database.createTable(TABLE_NAME,arrayList);

Example to insert data
----------------------------------------------

	private static final String DATABASE_NAME = "DATABASE_NAME";
	private static final String TABLE_NAME = "TABLE_NAME";
	
Create an object for SimplifiedDatabase

	SimplifiedDatabase database = new SimplifiedDatabase(this,DATABASE_NAME);
	
Create an arrayList of Insert data

	ArrayList<InsertData> arrayList = new ArrayList<>();
	
Create an object for InsertData and set the values


	InsertData insertData = new InsertData();
	insertData.setName("COLUMN_NAME");
	//If your value is string
	insertData.setStringValue("YOUR STRING VALUE");
	//ELSE
	insertData.setIntegerValue(0);  //YOUR INTEGER VALUE AND LEAVE setStringValue EMPTY
	
	//Add the insertdata into the arraylist
	arrayList.add(insertData)
Finally, This method insert data into your table
	
	database.insertData(TABLE_NAME,arrayList);




	
	
	

    
