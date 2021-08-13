# My Quotes

This is an app that I built to learn internal android storage using the Room library for data persistence and dependency injection using Dagger Hilt.

I have used Truth for Unit and Instrumented testing.

## Contents:
- What is Room? and how to use it
- Dependency Injection
- Test Driven Development

## Room and how to use it
So, what is this Room thing? Room is an ORM (Object Relational Mapping) library used for data persistence. What Room does is that it provides an abstraction layer over SQLite making it very easy to play around with databases while giving you SQLites powerful properties.

Being among one of android's jetpack components, Room hugely simplifies and cleans how you work with SQLiteDatabase objects. One of its benefits is that SQL queries get verified at compile time. This is good cause if there's an error it's you as a dev that will experience it rather than pushing it to runtime.

### Elements of Room Database
To use Room, we have this components;
- Entity
- Dao (Data Access Objects)
- Database

#### Entity
To represent a table in Room, you prepend your data class with @Entity annotation. Room will feature that class as a table and the class fields as the table's columns.
 - @PrimaryKey -You use this to tell room to use that field as the primary key of the table
 - @ColumnInfo -Use this annotation to tell room to use the provided name as the name of a column in the table
 - @Ignore - the annotated field wont be covered by Room for persistence



