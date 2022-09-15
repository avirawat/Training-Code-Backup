package com.clinicapp.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.clinicapp.model.Clinic;

public class UserMapper implements RowMapper<Clinic> {

	@Override
	public Clinic mapRow(ResultSet rs, int rowNum) throws SQLException {
		Clinic clinic=new Clinic();
		clinic.setClinicId(rs.getInt("clinicId"));
		clinic.setClinicName(rs.getString("clinicName"));
		clinic.setCity(rs.getString("clinicCity"));
		clinic.setClinicType(rs.getString("clinicType"));
		clinic.setConsultancyFee(rs.getDouble("consultancyFee"));
		return clinic;
	}

}
