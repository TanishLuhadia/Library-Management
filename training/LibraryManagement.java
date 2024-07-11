import java.util.*;
interface book
{
void setIssueDate(String date);
void setReturnDate(String date);
void setBookName(String bookName);
void setBookId(int id);
}

class Student implements book
{
private String name;
private String enrollmentNumber;
private String issueDate;
private String returnDate;
private String bookName;
private int bookId;

public boolean isAnyBookIssued;

public void setName(String name)
{
this.name=name;
}
public void setEnrollmentNumber(String enrollmentNumber)
{
this.enrollmentNumber=enrollmentNumber;
}

public String getName()
{
return this.name;
}
public String getEnrollmentNumber()
{
return this.enrollmentNumber;
}
public void setIssueDate(String date)
{
this.issueDate=date;
}
public void setReturnDate(String date)
{
this.returnDate=date;
}
public void setBookName(String bookName)
{
this.bookName=bookName;
}
public void setBookId(int id)
{
this.bookId=id;
}
public String getIssueDate()
{
return this.issueDate;
}
public String getReturnDate()
{
return this.returnDate;
}
public String getBookName()
{
return this.bookName;
}
public int bookId()
{
return this.bookId;
}

}

class LibraryManagement 
{
public Student Stud[]=new Student[10];
}

class main
{
public static void main(String gg[])
{
int numberOfStudent=0;
LibraryManagement l=new LibraryManagement();
Scanner sc=new Scanner(System.in);
int ch;
while(true)
{
System.out.println("1. Register student");
System.out.println("2. Issue book ");
System.out.println("3. Return book ");
System.out.println("4. Exit");
System.out.print("Enter your choice : ");
ch=sc.nextInt();
sc.nextLine();
if(ch==1)
{
System.out.print("Enter student name : ");
String studentName=sc.nextLine();
System.out.print("Enter enrollmentNumber : ");
String enrollmentNumber=sc.nextLine();
int found=0;
int i;
for(i=0;i<l.Stud.length;i++)
{
if(l.Stud[i]==null) break;

if(l.Stud[i].getEnrollmentNumber().equalsIgnoreCase(enrollmentNumber))
{
System.out.println("Student Already present : ");
System.out.println("Name : "+l.Stud[i].getName());
System.out.println("Enrollment Number : "+l.Stud[i].getEnrollmentNumber());
found=1;
break;
}
}
if(found==0)
{
Student  s=new Student();
s.setName(studentName);
s.setEnrollmentNumber(enrollmentNumber);
l.Stud[numberOfStudent]=s;
numberOfStudent++;
System.out.println("Student added");
}
}
else if(ch==2)
{
System.out.print("Enter student name : ");
String studentName=sc.nextLine();
System.out.print("Enter enrollmentNumber : ");
String enrollmentNumber=sc.nextLine();

int found=0;
int i;
for(i=0;i<l.Stud.length;i++)
{
if(l.Stud[i]==null) break;

if(l.Stud[i].getEnrollmentNumber().equalsIgnoreCase(enrollmentNumber))
{
found=1;
break;
}
}
if(found==0)
{
System.out.println("Student does'nt exist");
}
else
{
if(!l.Stud[i].isAnyBookIssued)
{
System.out.print("Enter today date (dd-mm-yyyy) : ");
String issueDate=sc.nextLine();
System.out.print("Enter Return date (dd-mm-yyyy) : ");
String returnDate=sc.nextLine();
System.out.print("Enter Book name ");
String bookName=sc.nextLine();
System.out.print("Enter book id  : ");
int bookId=sc.nextInt();

l.Stud[i].setIssueDate(issueDate);
l.Stud[i].setReturnDate(returnDate);
l.Stud[i].setBookName(bookName);
l.Stud[i].setBookId(bookId);
l.Stud[i].isAnyBookIssued=true;
System.out.println("Book issued successfully");
}
else
{
System.out.println("One book is already alloted to the student , please first submit it");
}
}
}
else if(ch==3)
{

System.out.print("Enter student name : ");
String studentName=sc.nextLine();
System.out.print("Enter enrollmentNumber : ");
String enrollmentNumber=sc.nextLine();

int found=0;
int i;
for(i=0;i<l.Stud.length;i++)
{
if(l.Stud[i]==null) break;

if(l.Stud[i].getEnrollmentNumber().equalsIgnoreCase(enrollmentNumber))
{
found=1;
break;
}
}
if(found==0)
{
System.out.println("Student does'nt exist");
}
else
{
if(!l.Stud[i].isAnyBookIssued) 
{
System.out.println("No book is issued to following student");
}
else
{
System.out.print("Enter today date (dd-mm-yyyy) : ");
String todayDate=sc.nextLine();
String returnDate=l.Stud[i].getReturnDate();
String dd[]=returnDate.split("-");
int day=Integer.parseInt(dd[0]);

String  ddd[]=todayDate.split("-");
int d=Integer.parseInt(ddd[0]);
if(d>day)
{
System.out.println("Fine is impossed , collect it");
System.out.println("Book returned successfully");
}
else
{
System.out.println("Book returned successfully");
}
l.Stud[i].isAnyBookIssued=false;
}
}



}
else if(ch==4)
{
break;
}
else
{
System.out.println("Select right option ");
continue;
}
}
}
}