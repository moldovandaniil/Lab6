package com.example.lab6;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import model.Course;
import model.RegistrationSystem;
import model.Student;
import model.Teacher;
import repository.CourseRepository;
import repository.StudentRepository;
import repository.TeacherRepository;

import java.io.IOException;
import java.util.ArrayList;

public class HelloController {


    RegistrationSystem dataBank = createDataBank();



    @FXML
    private Button chooseStudent;

    @FXML
    private Button chooseTeacher;



    @FXML
    private Button checkLogin;

    @FXML
    private PasswordField loginNameTeacher;

    @FXML
    private PasswordField loginNameStudent;

    @FXML
    private PasswordField loginSurnameStudent;

    @FXML
    private PasswordField loginSurnameTeacher;

    public RegistrationSystem createDataBank(){
        CourseRepository courseRepository = new CourseRepository();
        StudentRepository studentRepository = new StudentRepository();
        TeacherRepository teacherRepository = new TeacherRepository();

        /*Creating three teacher examples*/
        Teacher teacher1 = new Teacher("Alex", "Unu", new ArrayList<>());
        Teacher teacher2 = new Teacher("Andrei", "Doi", new ArrayList<>());
        Teacher teacher3 = new Teacher("Mihai", "Trei", new ArrayList<>());

        /*Adding the teachers to the repositories*/
        teacherRepository.create(teacher1);
        teacherRepository.create(teacher2);
        teacherRepository.create(teacher3);

        /*Creating five students*/
        Student student1 = new Student("Alfa", "Alfaru",
                1234567, 0, new ArrayList<>());
        Student student2 = new Student("Beta", "Betaru",
                1234568, 24, new ArrayList<>());
        Student student3 = new Student("Teta", "Tetaru",
                1234569, 0, new ArrayList<>());
        Student student4 = new Student("Omega", "Megaru",
                1234563, 0, new ArrayList<>());
        Student student5 = new Student("Gamma", "Gammaru",
                1234564, 0, new ArrayList<>());

        /*Adding the students to the repositories*/
        studentRepository.create(student1);
        studentRepository.create(student2);
        studentRepository.create(student3);
        studentRepository.create(student4);
        studentRepository.create(student5);

        /*Creating three courses*/
        Course course1 = new Course("Mate", teacher1, 2, new ArrayList<>(), 8);
        Course course2 = new Course("Info", teacher2, 5, new ArrayList<>(), 5);
        Course course3 = new Course("Geo", teacher3, 5, new ArrayList<>(), 5);

        /*Adding the courses to the repositories
        and attributing courses to teachers*/
        courseRepository.create(course1);
        teacher1.addCourse(course1);
        courseRepository.create(course2);
        teacher2.addCourse(course2);
        courseRepository.create(course3);
        teacher3.addCourse(course3);


        /*Creating an instance of Registration System*/
        RegistrationSystem regSys = new RegistrationSystem(courseRepository.getAll(),
                studentRepository.getAll(), teacherRepository.getAll());

        regSys.register(courseRepository.getAll().get(0),
                studentRepository.getAll().get(0));

        return regSys;

    }


    @FXML
    private Button checkLoginStud;

    @FXML
    void actionCheckLogin(ActionEvent event) throws IOException {
        boolean foundName=false;
        boolean foundSurname=false;

        for (int i = 0; i < dataBank.teacherList.size(); i++)
        {

            if(loginNameTeacher.getText().equals(dataBank.teacherList.get(i).getFirstName())){
                foundName = true;

            }
            if (loginSurnameTeacher.getText().equals(dataBank.teacherList.get(i).getLastName())){
                foundSurname = true;
            }

        }

        if(foundName && foundSurname){



            Stage stage = (Stage) loginSurnameTeacher.getScene().getWindow();

            // do what you have to do
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("successLoginTeacher.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setTitle("Welcome");
            stage.setScene(scene);
            stage.show();
        }
        else{
            Stage stage = (Stage) loginSurnameTeacher.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("wrongLoginTeacher.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setTitle("Wrong login info");
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void actionCheckLoginStud(ActionEvent event) throws IOException {
        boolean foundName=false;
        boolean foundSurname=false;

        for (int i = 0; i < dataBank.studentList.size(); i++)
        {

            if(loginNameStudent.getText().equals(dataBank.studentList.get(i).getFirstName())){
                foundName = true;

            }
            if (loginSurnameStudent.getText().equals(dataBank.studentList.get(i).getLastName())){
                foundSurname = true;
            }

        }

        if(foundName && foundSurname){



            Stage stage = (Stage) loginSurnameStudent.getScene().getWindow();

            // do what you have to do
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("successLoginTeacher.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setTitle("Welcome");
            stage.setScene(scene);
            stage.show();
        }
        else{
            Stage stage = (Stage) loginSurnameStudent.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("wrongLoginTeacher.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setTitle("Wrong login info");
            stage.setScene(scene);
            stage.show();
        }

    }

    @FXML
    void actionLoginNameTeacher(ActionEvent event) {

    }

    @FXML
    void actionLoginSurnameTeacher(ActionEvent event) {

    }



    @FXML
    void chosenTeacher(ActionEvent event)throws IOException {

        Stage stage = (Stage) chooseTeacher.getScene().getWindow();
        // do what you have to do
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("loginPageTeacher.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Log in");
        stage.setScene(scene);
        stage.show();

    }


    @FXML
    void chosenStudent(ActionEvent event) throws IOException {
        Stage stage = (Stage) chooseTeacher.getScene().getWindow();
        // do what you have to do
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("loginPageStudent.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Log in");
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    private Button checkEnrolled;

    @FXML
    void actionCheckEnrolled(ActionEvent event) throws IOException {
        Stage stage = (Stage) checkEnrolled.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("enrolledStudents.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Enrolled Students");
        stage.setScene(scene);

        stage.show();
        for(int i=0; i<dataBank.teacherList.size(); i++){
            if(dataBank.teacherList.get(i).getFirstName().equals("Alex")){
                for(int j=0; j<dataBank.teacherList.get(i).getCourses().get(0).getStudentsEnrolled().size(); j++)
                System.out.println(dataBank.teacherList.get(i).getCourses().get(0).getStudentsEnrolled().get(i).getFirstName()+
                        " "+dataBank.teacherList.get(i).getCourses().get(0).getStudentsEnrolled().get(i).getLastName());
            }
        }


    }

    @FXML
    private Button wrongLogin;

    @FXML
    void actionWrongLogin(ActionEvent event) throws IOException {
        Stage stage = (Stage) wrongLogin.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("loginPageTeacher.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Log in");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private Button refreshEnrolled;

    @FXML
    void actionRefreshEnrolled(ActionEvent event) {

    }


}
