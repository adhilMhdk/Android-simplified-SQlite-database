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
    arrayList.add(new TableRowModel("NAME OF ROW",  new Types().getString())); //TYPE OF ROW
Finally call this method to create table
    
    database.createTable(TABLE_NAME,arrayList);

    
