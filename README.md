# JPA_And_Hibernate_Demo_App

# This Application performs basic data base operations using JPA and Hibernate. It explains all basic terminologies used in implemeting JPA and Hibernate.

SQL : It queries from Tables
JPQL : It queries from Entities. (What ever JPQL queries we write it is internally converted into SQL by JPA implementation that is Hibernate)

Example:

SQL: Select * from COURSE;
JPQL: Select c from Course c;

#JPA and hibernate annotations
@Table
@Column 
@UpdateTimestamp - It tells when the row is updated last time and this is provided by hibernate.
@CreateTimestamp - It tells when the row created and this is provided by hibernate.

With the named query we can assigned the name with the query and reuse it again and again.
@NamedQuery
@NamedQueries

NativeQueries

Its always better to use JPQL but sometime we have to use Native queries as well like we have connect with a data base and some features are not supported by JPQL
In such situations we have no other options than to fire a Native queries.

Other situations when we have to go for a Native query like we have to do a mass update like we have to update all the rows in a specific table, in such situation
if we try to do it using JPQL the we need to get a single row and then update it again and again. We can not do mass update using JPA, so in such situations native queries is the solution.


@OneToOne
Any OneToOne relationship is always eager fetch by default.
And this might gives us a performance issues in our application. We can avoid this by using @OneToOne(fetch = FetchType.LAZY)
In Lazy fetching we will get those data what ever we needed at that point in time.


**** Session, Session factory, Entity Manager, Persistence context and Transaction ****

When we talk about transaction everything should succeed or nothing should succeed. So within the transaction if any one operation fails entire transaction will be rolled back.
That is why we are using @Transactional annotation.

In the JPA as soon as you are defining Transaction using @Transactional annotation you would be defining something called Persistence Context.
So we can say a Persistence Context is a place where all the entities we are using in our application are being stored and its results which we get from the database.
So any changes or updated in the value of an entity will be also reflected in the Persistence context.

It should be note that only after a particular transaction is completed, the data will be sent to the database not before that. And during the execution of a transaction the change in data (create or update)
is tracked by Persistence context of that transaction.

They way we interact with the Persistence context is by using Entity Manager. So when ever we are calling any method on entity manager we are actually playing with Persistence context.
So Persistence Context is actually keeping the track of any changes in the data and it is started at the beginning of a transaction and kills as soon as transaction ended.


For Example: There are multiple create and update operations takes place in a method which is annotated with @Transactional annotation.
At this time all the operations are treated under a single transaction.

    @Test
	@Transactional
	public void uderstandPersistenceContextTest() {
		// Operation1: Retrieve Student
		Student student = entityManager.find(Student.class, 20001L);
		// Operation2: Retrieve PassPort
		Passport passport = student.getPassport();
		// Operation3: Update Passport
		passport.setNumber("EMJPS654");
		// Operation4: Update Student
		student.setName("Rohit Sharma");
		
		
	}

Suppose if we remove @Transactional annotation then each operation (method call on entity manager's object) acts as if its own transaction. So as soon as operation ended transaction and its Persistence context is closed.
If we try to perform another operation we would get an exception like==> Could not initialize proxy - no session (In Hibernate terminology Session = Persistence Context). Because Persistence context is closed by then.

Persistence Context also gives access to the data base.

Note: In JPA we use Entity Manager to talk to the Persistence context 

While in Hibernate we use Session and Session Factory.





