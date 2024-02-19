package com.example;


import java.util.ArrayList;  
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  

//defining the business logic  
@Service  
public class BooksService   
{  
@Autowired  
BooksRepository booksRepository;  
//getting all books record by using 
//the method findaAll() of CrudRepository  
public List<Books> getAllBooks()   
{  
List<Books> books = new ArrayList<Books>(); 
//long r=books.size();
//r=booksRepository.
booksRepository.findAll().forEach(books1 -> books.add(books1));  

return books;  
}  
//getting a specific record by using the method 
//findById() of CrudRepository  
public Books getBooksById(int id)   
{  
return booksRepository.findById(id).get();  
}  
//saving a specific record by using the method 
//save() of CrudRepository  
public void saveOrUpdate(Books bk)   
{  
booksRepository.save(bk);  
}  
//deleting a specific record by using the method deleteById() of CrudRepository  
public void delete(int id)   
{  
booksRepository.deleteById(id);  
}  
//updating a record  
public void update(Books books, int bookid)   
{  
booksRepository.save(books);  
}  
public long bcount()
{
	return booksRepository.count();
}
public void deleteall()
{
	booksRepository.deleteAll();
}
public int max1()
{
	List<Books> books = new ArrayList<Books>(); 
	//long r=books.size();
	//r=booksRepository.
	booksRepository.findAll().forEach(books1 -> books.add(books1));  
	int max=books.get(0).getPrice();
	for(int i=0;i<books.size();i++)
	{
	
		if(books.get(i).getPrice()>max)
		{
			max=books.get(i).getPrice();
		}
		
	}
	return max;
}
public String bookName(int id)   
{  
	Books b=booksRepository.findById(id).get(); 
	return b.getBookname();
}

}  

