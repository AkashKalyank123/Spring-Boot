package services;

import java.util.List;

import exception.ServiceException;
import modals.Student;

public interface StudentService {

	void save(Student student) throws ServiceException;
	void update(Student student);
	void delete(Student studentId);
	List<Student> findAll();
	Student findById(int studentId);
}
