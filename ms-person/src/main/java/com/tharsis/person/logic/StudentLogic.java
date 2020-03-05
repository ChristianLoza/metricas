package com.tharsis.person.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;

import com.tharsis.persist.RepositoryJPA;
import com.tharsis.person.auth.Secured;
import com.tharsis.person.domain.Role;
import com.tharsis.person.domain.Student;
import com.tharsis.util.UtilConstant;
import com.tharsis.util.UtilEncrypt;

/**
 *
 * @author christian
 */
@RequestScoped
//@Log(LogParams.METRICS)
public class StudentLogic extends RepositoryJPA<Student, Serializable> {

    public void saveStudent(Student student) {
        student.getPerson().setPassword(UtilEncrypt.encryptToSha1(student.getPerson().getPassword()));
        student.getPerson().setStatus(UtilConstant.ENABLE);
        add(student);
    }

    public void updateStudent(int id, Student student) {
        Student findStudent = findById(Student.class, id);
        student.setIdstudent(findStudent.getIdstudent());
        student.getPerson().setIdperson(findStudent.getPerson().getIdperson());
        if ((student.getPerson().getPassword()).equals("")) {
            student.getPerson().setPassword(findStudent.getPerson().getPassword());
        } else {
            student.getPerson().setPassword(UtilEncrypt.encryptToSha1(student.getPerson().getPassword()));
        }
        update(student);
    }

    public void deleteStudent(int id) {
        Student student = findById(Student.class, id);
        student.getPerson().setStatus(UtilConstant.DISABLE);
        update(student);
    }

    public List<Student> findStudentById(int id) {
        Map<String, Object> param = new HashMap<>();
        param.put("idperson", id);
        List<Student> list = createNamedQuery("Student.findByIdstudent", param)
                .setMaxResults(1)
                .getResultList();
        return list;

    }

    public List<Student> findStudentByDni(String dni) {
        Map<String, Object> param = new HashMap<>();
        param.put("dni", dni);
        List<Student> list = createNamedQuery("Student.findByDnistudent", param)
                .setMaxResults(1)
                .getResultList();
        return list;
    }
    
    @Secured(Role.ORGANIZER)
    public List<Student> allStudent() {
        return findAll("Student.findAllActive");
    }

    public List<Student> allStudent(int limit) {
        return findAll("Student.findAllActive", limit);
    }

}
