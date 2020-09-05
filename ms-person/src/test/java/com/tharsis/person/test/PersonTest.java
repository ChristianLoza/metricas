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

import com.tharsis.person.auth.Token;
import com.tharsis.person.domain.Person;
import com.tharsis.person.domain.Role;
import com.tharsis.person.logic.PersonLogic;
import com.tharsis.person.resource.PersonResource;
import com.tharsis.person.resource.Resource;
import com.tharsis.person.vo.LoginVO;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;

/**
 *
 * @author christian
 */
@RunWith(Arquillian.class)
public class PersonTest {

    @Deployment
    public static JavaArchive createDeploy() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Resource.class)
                .addClass(Person.class)
                .addClass(PersonLogic.class)
                .addClass(LoginVO.class)
                .addClass(Role.class)
                .addClass(Token.class)
                .addClass(PersonResource.class)
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
    public void loginTest() {

        LoginVO loginVO = new LoginVO();
        loginVO.setDni("73444229");
        loginVO.setPassword("73444229");

        given().contentType(ContentType.JSON)
                .body(loginVO)
                .post("v1/login")
                .then()
                .statusCode(200)
                .extract()
                .response();

    }

}
