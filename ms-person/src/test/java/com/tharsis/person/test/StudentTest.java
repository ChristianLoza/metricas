package com.tharsis.person.test;

import java.io.File;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.asset.FileAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tharsis.person.domain.Person;
import com.tharsis.person.domain.Role;
import com.tharsis.person.domain.Student;
import com.tharsis.person.logic.StudentLogic;
import com.tharsis.person.resource.Resource;
import com.tharsis.person.resource.StudentResource;

import static io.restassured.RestAssured.when;
import static io.restassured.RestAssured.with;
import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;

/**
 *
 * @author christian
 */
@RunWith(Arquillian.class)
public class StudentTest {

    @Deployment
    public static JavaArchive createDeploy() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Resource.class)
                .addClass(Person.class)
                .addClass(Role.class)
                .addClass(Student.class)
                .addClass(StudentLogic.class)
                .addClass(StudentResource.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsResource("config.yml", "config.yml")
                .addAsManifestResource(new FileAsset(new File("src/test/resources/META-INF/persistence.xml")),
                        "persistence.xml");
    }

    @Test
    @InSequence(-1)
    public void dependencyAppendTest() throws ClassNotFoundException {
        Assert.assertNotNull(Class.forName("javax.ws.rs.core.Application"));
    }

    @Test
    @RunAsClient
    public void saveStudent() {
        Student student = new Student();
        student.setIdnfc("NFC-123");
        Person person = new Person();
        student.setPerson(person);
        student.getPerson().setPassword("123");
        student.getPerson().setDni("46218218");
        student.getPerson().setEmail("4621821@localhost.com");
        student.getPerson().setName("Test user");
        student.getPerson().setLastname("Last username");

        with().body(student).contentType(ContentType.JSON)
                .when()
                .request("POST", "v1/student/add")
                .then()
                .statusCode(200);
    }

    @Test
    @RunAsClient
    public void updateStudent() {

    }

    @Test
    @RunAsClient
    public void deleteStudent() {

    }

    @Test
    @RunAsClient
    public void findStudentId() {

    }

    @Test
    @RunAsClient
    public void findStudentNfc() {

    }

    @Test
    @RunAsClient
    public void findStudentDni() {
        ResponseBody body = when().get("v1/student/list").getBody();
        System.out.println(body.asString());
        when().get("v1/student/list").then().statusCode(200);
    }

    @Test
    @RunAsClient
    public void getAllStudentTest() {
//        ResponseBody body =  when().get("v1/student/list").getBody();
//        System.out.println(body.asString());
        when().get("v1/student/list").then().statusCode(200);
    }

    @Test
    @RunAsClient
    public void getAllStudentTestLimit() {

    }

}
