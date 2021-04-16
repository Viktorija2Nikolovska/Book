
import './App.css';
import React, {Component} from "react";
import {BrowserRouter as Router, Redirect, Route} from 'react-router-dom'
import Authors from '../Authors/authors';
import Categories from '../Categories/categories';
import Books from '../Books/BookList/books';
import Header from '../Header/header';
import BookAdd from '../Books/BookAdd/bookAdd';
import bookService from "../../repository/bookRepository";
import BookEdit from "../Books/BookEdit/bookEdit";


class App extends Component {

  constructor(props) {
    super(props);
    this.state = {
      authors: [],
      books: [],
      categories: [],
      selectedBook: {}
    }
  }

  render() {
    return (
        <Router>
          <Header/>
          <main>
            <div className="container">
              <Route path={"/authors"} exact render={() =>
                  <Authors authors={this.state.authors}/>}/>
              <Route path={"/categories"} exact render={() =>
                  <Categories categories={this.state.categories}/>}/>
              <Route path={"/books/add"} exact render={() =>
                  <BookAdd categories={this.state.categories}
                              authors={this.state.authors}
                              onAddBook={this.addBook}/>}/>
              <Route path={"/boks/edit/:id"} exact render={() =>
                  <BookEdit categories={this.state.categories}
                               authors={this.state.authors}
                               onEditBook={this.editBook}
                               book={this.state.selectedBook}/>}/>
              <Route path={"/books"} exact render={() =>
                  <Books books={this.state.books}
                            onDelete={this.deleteBook}
                            onEdit={this.getBook}/>}/>
              <Redirect to={"/books"}/>
            </div>
          </main>
        </Router>
    );
  }

  componentDidMount() {
    this.loadAuthors();
    this.loadCategories();
    this.loadBooks();
  }

  loadManufacturers = () => {
    bookService.fetchAuthors()
        .then((data) => {
          this.setState({
            authors: data.data
          })
        });
  }

  loadProducts = () => {
    bookService.fetchBooks()
        .then((data) => {
          this.setState({
            books: data.data
          })
        });
  }

  loadCategories = () => {
    bookService.fetchCategories()
        .then((data) => {
          this.setState({
            categories: data.data
          })
        });
  }

  deleteBook = (id) => {
   bookService.deleteBook(id)
        .then(() => {
          this.loadBooks();
        });
  }

  addBook = (name, author, category,avaliableCopies) => {
    bookService.addBook(name, author,category,avaliableCopies)
        .then(() => {
          this.loadBooks();
        });
  }

  getBook = (id) => {
    bookService.getBook(id)
        .then((data) => {
          this.setState({
            selectedBook: data.data
          })
        })
  }

  editBook = (id, name, author,category,avaliableCopies) => {
    bookService.editBook(id, name, author,category,avaliableCopies)
        .then(() => {
          this.loadBooks();
        });
  }
}

export default App;
