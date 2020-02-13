package com.tharsis.person.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.ms.persist.RepositoryJPA;
import com.tharsis.person.domain.Student;

/**
 *
 * @author christian
 */
@RequestScoped
public class StudentLogic extends RepositoryJPA<Student, Serializable> {

    @Inject
    private PersonLogic personLogic;
    
    

    public void saveStudent(Student student) {
        student.setIdstudent(personLogic.savePerson(student.getPerson())
                .getIdperson());
        add(student);
    }

    public void updateStudent(Student student) {
        personLogic.editPerson(student.getPerson());
        update(student);
    }

    public void deleteStudent(Student student) {
        personLogic.deletePerson(student.getPerson());
    }

    public List<Student> findStudentById(Integer id) {
        
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

    public List<Student> allStudent() {
        return findAll("Student.findAllActive");
    }

    public List<Student> allStudent(int limit) {
        return findAll("Student.findAllActive", limit);
    }

}
