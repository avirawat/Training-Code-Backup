package com.doctorapp.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.doctorapp.exception.DoctorNotFoundException;
import com.doctorapp.model.Doctor;

@Repository
public class DoctorRepositoryImpl implements IDoctorRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

//	public void setDataSource(DataSource dataSource) {
//		this.jdbcTemplate.setDataSource(dataSource);
//	}

	@Override
	public void addDoctor(Doctor doctor) {
		String insertSql = "insert into doctor values(?,?,?,?,?,?)";
		Object[] arrayOfObject = { doctor.getDoctorId(), doctor.getDoctorName(), doctor.getCity(),
				doctor.getSpecialisation(), doctor.getExperience(), doctor.getFee() };
		jdbcTemplate.update(insertSql, arrayOfObject);
	}

	@Override
	public void deleteDoctor(int doctorId) {
		String deleteSql = "delete from doctor where doctorId=?";
		jdbcTemplate.update(deleteSql, doctorId);

	}

	@Override
	public void updateDoctor(int doctorId, double fee) {
		String updateSql = "update doctor set fee=? where doctorId=?";
		Object[] arrayOfObject = { fee, doctorId };
		jdbcTemplate.update(updateSql, arrayOfObject);

	}

	@Override
	public List<Doctor> allDoctors() {
		String selectSql = "select * from doctor";
		return jdbcTemplate.query(selectSql, new UserMapper());
	}

	@Override
	public List<Doctor> getDoctorBySpeciality(String specialisation) throws DoctorNotFoundException {
		String specialitySql = "select * from doctor where specialisation=?";
		return jdbcTemplate.query(specialitySql, new UserMapper(), specialisation);
	}

	@Override
	public List<Doctor> getDoctorByCityAndExperience(String city, int experience) throws DoctorNotFoundException {
		String citySql = "select * from doctor where city=? and experience=?";
		return jdbcTemplate.query(citySql, new UserMapper(), city, experience);
	}

	@Override
	public List<Doctor> getDoctorByExperience(int experience) throws DoctorNotFoundException {
		String experienceSql = "select * from doctor where experience=?";
		return jdbcTemplate.query(experienceSql, new UserMapper(), experience);
	}

	@Override
	public List<Doctor> getDoctorByFee(double fee) throws DoctorNotFoundException {
		String feeBySql = "select * from doctor where fee<=?";
		return jdbcTemplate.query(feeBySql, new UserMapper(), fee);
	}

}
