package services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import exception.ServiceException;
import modals.Student;
import utils.DBUtil;

public class StudentServiceImpl implements StudentService{

	@Override
	public void save(Student student) throws ServiceException {
		String sql="INSERT INTO student(firstname,lastname,age,city,joningDate) VALUES(?,?,?,?,?)";
		try(Connection con=DBUtil.getConnection();
				PreparedStatement preparedStatement=(PreparedStatement) con.prepareStatement(sql);
		) {
				preparedStatement.setString(1, student.getFirstname());
				preparedStatement.setString(2, student.getLastname());
				preparedStatement.setInt(3, student.getAge());
				preparedStatement.setString(4,student.getCity());
				preparedStatement.setDate(5, new Date(System.currentTimeMillis()));
			
		} catch (SQLException e) {
			
			throw new ServiceException("Error while saving the student"+e.getMessage());
		}
		
	}

	@Override
	public void update(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Student studentId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student findById(int studentId) {
		// TODO Auto-generated method stub
		return null;
	}

}
