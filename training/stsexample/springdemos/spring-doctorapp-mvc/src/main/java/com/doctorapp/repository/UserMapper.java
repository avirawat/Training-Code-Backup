package com.doctorapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.doctorapp.model.Doctor;

public class UserMapper implements RowMapper<Doctor> {

	@Override
	public Doctor mapRow(ResultSet rs, int rowNum) throws SQLException {
		Doctor doctor = new Doctor();
		doctor.setDoctorId(rs.getInt("doctorId"));
		doctor.setDoctorName(rs.getString("doctorName"));
		doctor.setCity(rs.getString("city"));
		doctor.setSpecialisation(rs.getString("specialisation"));
		doctor.setExperience(rs.getInt("experience"));
		doctor.setFee(rs.getDouble("fee"));
		return doctor;
	}

}
