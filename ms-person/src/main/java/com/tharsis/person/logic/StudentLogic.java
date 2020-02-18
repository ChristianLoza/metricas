package com.tharsis.person.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;

import com.kumuluz.ee.logs.cdi.Log;
import com.kumuluz.ee.logs.cdi.LogParams;
import com.ms.persist.RepositoryJPA;
import com.ms.util.UtilConstant;
import com.ms.util.UtilEncrypt;
import com.tharsis.person.domain.Student;

/**
 *
 * @author christian
 */
@RequestScoped
@Log(LogParams.METRICS)
public class StudentLogic extends RepositoryJPA<Student, Serializable> {
    
    public void saveStudent(Student student) {
        student.getPerson().setPassword(UtilEncrypt.encryptToSha1(student.getPerson().getPassword()));
        student.getPerson().setStatus(UtilConstant.ACTIVO);
        add(student);
    }

    public void updateStudent(Student student) {
        student.getPerson().setStatus(UtilConstant.ACTIVO);
        System.out.println(student.toString());
        update(student);
    }

    public void deleteStudent(int idStudent) {
        Student student = findById(Student.class, idStudent);        
        delete(student);
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
