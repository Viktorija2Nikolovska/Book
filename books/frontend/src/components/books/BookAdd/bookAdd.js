import React from 'react';
import {useHistory} from 'react-router-dom';

const BookAdd = (props) => {

    const history = useHistory();
    const [formData, updateFormData] = React.useState({
        name: "",
        author: 0,
        category: 0,
        avaliableCopies: 1
    })

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }

    const onFormSubmit = (e) => {
        e.preventDefault();
        const name = formData.name;
        const author = formData.author;
        const category = formData.category;
        const avaliableCopies = formData.avaliableCopies;

        props.onAddBook(name, author,category,avaliableCopies);
        history.push("/books");
    }

    return(
        <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={onFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="name">Book name</label>
                        <input type="text"
                               className="form-control"
                               id="name"
                               name="name"
                               required
                               placeholder="Enter product name"
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="name">Category</label>
                        <input type="text"
                               className="form-control"
                               id="category"
                               name="category"
                               required
                               placeholder="Enter product name"
                               onChange={handleChange}
                        />
                    </div>



                    <div className="form-group">
                        <label>Author</label>
                        <select name="author" className="form-control" onChange={handleChange}>
                            {props.authors.map((term) =>
                                <option value={term.id}>{term.name}</option>
                            )}
                        </select>
                    </div>

                    <div className="form-group">
                        <label htmlFor="author">avaliableCopies</label>
                        <input type="text"
                               className="form-control"
                               id="avaliableCopies"
                               name="avaliableCopies"
                               placeholder="avaliableCopies"
                               required
                               onChange={handleChange}
                        />
                    </div>
                    <button id="submit" type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    )
}

export default BookAdd;
