package com.alindus.iss.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.alindus.iss.domain.Client;
import com.alindus.iss.domain.Interview;
import com.alindus.iss.domain.InterviewRound;
import com.alindus.iss.domain.InterviewRound.InterviewStatus;
import com.alindus.iss.domain.InterviewType;
import com.alindus.iss.domain.Round;
import com.alindus.iss.domain.Technology;
import com.alindus.iss.domain.User;
import com.alindus.iss.domain.Vendor;

public interface InterviewRepository extends JpaRepository<Interview, Long> {

	@Modifying
	@Query(value = "delete from InterviewRound ir where ir.id=?1")
	public void removeInterviewRound(Long id);

	@Modifying
	@Query("update InterviewRound ir set ir.round=?2, ir.status=?3, ir.interviewType=?4, ir.interviewDate=?5, ir.interview=?6, ir.callTaker=?7 where ir.id=?1")
	public void updateInterviewRound(Long id, Round round, InterviewStatus interviewStatus, InterviewType interviewType,
			Date interviewDate, Interview interview, User callTaker);

	@Query("select c from Client c")
	public List<Client> findAllClient();

	@Query("select c from Client c where c.name=?1")
	public Client findClientByName(String name);

	@Query("select c from Client c where c.name like %?1%")
	public List<Client> findClientsByNameLike(String name);

	@Query("select v from Vendor v")
	public List<Vendor> findAllVendor();

	@Query("select v from Vendor v where v.name=?1")
	public Vendor findVendorByName(String name);

	@Query("select v from Vendor v where v.name like %?1%")
	public List<Vendor> findVendorsByNameLike(String name);

	@Query("select t from Technology t")
	public List<Technology> findAllTechnology();

	@Query("select t from Technology t where t.name=?1")
	public Technology findTechnologyByName(String name);

	@Query("select t from Technology t where t.name like %?1%")
	public List<Technology> findTechnologiesByNameLike(String name);

	@Query("select r from Round r")
	public List<Round> findAllRound();

	@Query("select r from Round r where r.name=?1")
	public Round findRoundByName(String name);

	@Query("select r from Round r where r.name like %?1%")
	public List<Round> findRoundByNameLike(String name);

	@Query("select it from InterviewType it")
	public List<InterviewType> findAllInterviewType();

	@Query("select it from InterviewType it where it.type=?1")
	public InterviewType findInterviewTypeByType(String type);

	@Query("select it from InterviewType it where it.type like %?1%")
	public List<InterviewType> findInterviewsTypeByTypeLike(String type);

	@Query("select ir from InterviewRound ir")
	public List<InterviewRound> getInterviewRounds();

	@Query(value = "select ir from InterviewRound ir where ir.interview = ?1")
	public List<InterviewRound> getInterviewRoundsByInterviewId(Interview interview);

}