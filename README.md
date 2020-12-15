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


Clear a table
-------------

Create an object for SimplifiedDatabase

	SimplifiedDatabase database= new SimplifiedDatabase(this,DATABASE_NAME);
Call this method with table name as the parameter

	database.clearTable(TABLE_NAME);


Get column with Column id
-----------------------------

Create an object for SimplifiedDatabase

	SimplifiedDatabase database = new SimplifiedDatabase(this,DATABASE_NAME);
Call this method with first parameter as id and second as table name

        HashMap map = database.getColumnWithId("1",TABLE_NAME);
	String name = map.get("COLUMN_NAME").toString();

Query all items in a table
----------------------------

Create an object for SimplifiedDatabase

	SimplifiedDatabase database = new SimplifiedDatabase(this,DATABASE_NAME);
Call this method to query all data in table
	
	ArrayList<HashMap> map = database.queryAllItemsInTable(TABLE_NAME);
	for (int i = 0; i < maps.size(); i++) {
            HashMap map = maps.get(i);
            Toast.makeText(this, map.get("ROW_NAME").toString(), Toast.LENGTH_SHORT).show();
	    Toast.makeText(this, map.get("ROW_NAME_B").toString(), Toast.LENGTH_SHORT).show();
        }
	
Update table with id
---------------------

Create an object for SimplifiedDatabase

	SimplifiedDatabase database = new SimplifiedDatabase(this,DATABASE_NAME);
	
Call this method to update column.

The first parameter is table name, second is id, third one is row name and the last one is the update value

	database.updateColumnWithId(TABLE_NAME,"id","ROW_NAME","UPDATE_VALUE");
