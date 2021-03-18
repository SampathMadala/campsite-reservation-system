package com.camping.reservation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.camping.reservation.model.UserInfo;

public interface CampsiteRepository extends JpaRepository<UserInfo, String> {
	Optional<UserInfo> findByUuid(String uuid);
	Optional<UserInfo> deleteByUuid(String uuid);
}
