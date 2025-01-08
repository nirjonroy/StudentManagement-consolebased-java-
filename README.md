<h1 style="text-align:center"> Java Console based Student management System </h1>
<hr/>
<h3> Task Description :</h3>
<p>
  Your task is to create a console application for managing student information. The information will be managed only by the admission officer(s). Upon starting the project, prompt the user to input their username and password. Validate this information from a file. If the provided password is incorrect, display an error message and request a reattempt.

Once successfully authenticated, the officer gains access to functionalities such as adding and viewing student information. The officer can input details like student ID, name, program, batch, password and CGPA. Additionally, the officer can search for student information using their ID and view all details except the password.

Likewise, the officer can assign courses to students. A student can take multiple courses. The application should have the functionality to search for advised course information based on a student's ID. All data, including student information and advised courses, must be stored and retrieved from a file.

</p>
<h3> Features :</h3>
<ul>
  <li>User Authentication, Role of manager can add student, assign course to student and show cources and student</li>
  <li>File-Based Data Storage: Easy to manage and modify without a database.</li>
  <li>User-Friendly Menu: Clear navigation for managing students and courses.</li>
  <li>Extensibility: The system can be expanded to include more features or integrate with a database.
</li>
</ul>

<h3>Program Overview</h3>
<p>The application follows the MVC (Model-View-Controller) architecture:</p>
<ul>
  <li>Model: Model: Represents the data (Student class).</li>
  <li> View: Handles user input and output ( ConsoleView class). </li>
  <li> Controller: Acts as the bridge between the model and the view, implementing the logic ( AdmissionController class). </li>
</ul>

