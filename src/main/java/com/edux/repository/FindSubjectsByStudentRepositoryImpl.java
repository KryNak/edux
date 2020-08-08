package com.edux.repository;

import com.edux.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class FindSubjectsByStudentRepositoryImpl implements FindSubjectsByStudentRepository {

    private EntityManager entityManager;

    public FindSubjectsByStudentRepositoryImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<String> findSubjectsByStudent(Student student) {
        String query = "SELECT su.subject_name FROM subject su JOIN su.students st WHERE st.id_person = :id";

        TypedQuery<String> q = entityManager
                .createQuery(query , String.class)
                .setParameter("id", student.getId_person());

        return q.getResultList();
    }
}
