package com.example;
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.web.bind.annotation.*;  
//mark class as Controller  
@RestController 
@RequestMapping("/") //api call address
public class BooksController   
{  
//autowire the BooksService class  
@Autowired  
BooksService booksService;  
//creating a get mapping that retrieves 
//all the books detail from the database   
@GetMapping("/book")  
private List<Books> getAllBooks()   
{  
	return booksService.getAllBooks();  
}  
//creating a get mapping that retrieves the detail 
//of a specific book  
@GetMapping("/book/{bookid}")  
private Books getBooks(@PathVariable("bookid") int bookid)   
{  
return booksService.getBooksById(bookid);  
}  
//creating a delete mapping that deletes a specified book  
@DeleteMapping("/book/{bookid}")  
private void deleteBook(@PathVariable("bookid") int bookid)   
{  
booksService.delete(bookid);  
}  
//creating post mapping that post the book 
//detail in the database  
@PostMapping("/booksave")  
private int saveBook(@RequestBody Books bk)   
{  
booksService.saveOrUpdate(bk);  
return bk.getBookid();  
}  
//creating put mapping that updates the book detail   
@PutMapping("/booksupdate")  
private Books update(@RequestBody Books books)   
{  
booksService.saveOrUpdate(books);  
return books;  
}  
@GetMapping("/bookscount")
private long bcount()
{
	return booksService.bcount();

}
@GetMapping("/maxprice")
private int max1()
{
	return (int)booksService.max1();
}
@DeleteMapping("/booksdeleteall")
private void deleteall()
{
	booksService.deleteall();
}



@GetMapping("/bookname/{bookid}")
private String bookName(@PathVariable("bookid") int bookid)   
{  
return booksService.bookName(bookid);  
} 
}  

