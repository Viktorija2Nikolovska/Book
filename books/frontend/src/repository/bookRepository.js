import axios from '../custom-axios/axios';

const bookService={
    fetchCategories:()=>{
        return axios.get("/categories");
    },
    fetchAuthors:()=>{
        return axios.get("/authors");
    },
    fetchBooks:()=>{
        return axios.get("/books");
    },
    deleteBook:(id)=>{
        return axios.delete(`/books/delete/${id}`);
    },
    addBook:(name,category,author,avaliableCopies)=>{
        return axios.post("/books/add",{
            "name":name,
            "category":category,
            "author":author,
            "avaliableCopies":avaliableCopies
        });
    },
    editBook:(id,name,category,author,avaliableCopies)=>{
        return axios.put(`/books/edit/${id}`,{
            "name":name,
            "category":category,
            "author":author,
            "avaliableCopies":avaliableCopies
        });
    },

    getBook:(id)=>
    {
        return axios.get(`/books/${id}`);
    }

}
export default bookService;