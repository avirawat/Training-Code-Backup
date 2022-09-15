package com.clinicapp.Repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.clinicapp.exceptions.ClinicNotFoundException;
import com.clinicapp.model.Clinic;

@Repository
public class ClinicRepositoryImpl implements IClinicRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate.setDataSource(dataSource);
	}
	
	
	@Override
	public void addClinic(Clinic clinic) {
	String insertSql="insert into clinic values(?,?,?,?,?)";
	Object[] arrayOfObject= {clinic.getClinicId(),clinic.getClinicName(),clinic.getCity(),clinic.getClinicType(),clinic.getConsultancyFee()};	
	jdbcTemplate.update(insertSql, arrayOfObject);
	
	
	}

	@Override
	public void deleteClinic(int clinicId) throws ClinicNotFoundException {
		String deleteSql="delete from clinic where clinicId=?";
		jdbcTemplate.update(deleteSql, clinicId);
		
		
	}

	@Override
	public void updateClinic(int clinicId, double consultancyFee) throws ClinicNotFoundException {
		String updateSql="update clinic set consultancyFee=? where clinicId=?";
		Object[] arrayOfObject= {consultancyFee,clinicId};
		jdbcTemplate.update(updateSql, arrayOfObject);
	}

	@Override
	public List<Clinic> getAllClinic() {
		String selectSql="select * from clinic";
		List<Clinic> allClinics=jdbcTemplate.query(selectSql,new UserMapper());
		return allClinics;
	}

	@Override
	public List<Clinic> getClinicByName(String clinicName) throws ClinicNotFoundException {
		String selectByNameSql="select * from clinic where clinicName=?";
		List<Clinic> clinicsByName=jdbcTemplate.query(selectByNameSql,new UserMapper(),clinicName);
		return clinicsByName;
	}

	@Override
	public List<Clinic> getClinicByCity(String clinicCity) throws ClinicNotFoundException {
		String selectByCitySql="select * from clinic where clinicCity=?";
		List<Clinic> clinicsByCity=jdbcTemplate.query(selectByCitySql,new UserMapper(),clinicCity);
		return clinicsByCity;
	}

	@Override
	public List<Clinic> getClinicByTyppe(String clinicType) throws ClinicNotFoundException {
		String selectByTypeSql="select * from clinic where clinicType=?";
		List<Clinic> clinicsByType=jdbcTemplate.query(selectByTypeSql,new UserMapper(),clinicType);
		return clinicsByType;
	}

	@Override
	public List<Clinic> getClinicByFee(double consultancyFee) throws ClinicNotFoundException {
		String selectByFeeSql="select * from clinic where consultancyFee<=?";
		List<Clinic> clinicsByFee=jdbcTemplate.query(selectByFeeSql,new UserMapper(),consultancyFee);
		return clinicsByFee;
	}

}
