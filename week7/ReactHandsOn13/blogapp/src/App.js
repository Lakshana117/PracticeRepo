
import React from "react";
import "./App.css";

function App() {
  const showBooks = true;
  const showBlog = true;
  const showCourse = true;

  const books = [
    { id: 101, bname: "Master React", price: 670 },
    { id: 102, bname: "Deep Dive into Angular 11", price: 800 },
    { id: 103, bname: "Mongo Essentials", price: 450 }
  ];

  const booklet = (
    <ul>
      {books.map((book) => (
        <div key={book.id}>
          <h3>{book.bname}</h3>
          <h4>{book.price}</h4>
        </div>
      ))}
    </ul>
  );

  const blogContent = (
    <div>
      <h3>React Learning</h3>
      <p>Stephen Biz</p>
      <p>Welcome to learning React!</p>
      <p>Installation: You can install React from npm.</p>
    </div>
  );

  const courseContent = (
    <div>
      <p>Angular - 4/5/2021</p>
      <p>React - 6/8/2020</p>
    </div>
  );

  return (
    <div className="App">
      <div className="container">
        {showBooks && (
          <div className="box">
            <h1 className="st2"> Book Details</h1>
            {booklet}
          </div>
        )}

        {showBlog && (
          <div className="box">
            <h1 className="v1"> Blog Details</h1>
            {blogContent}
          </div>
        )}

        {showCourse && (
          <div className="box">
            <h1 className="mystyle1"> Course Details</h1>
            {courseContent}
          </div>
        )}
      </div>
    </div>
  );
}

export default App;
