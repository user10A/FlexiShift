package com.example.managerservice.repository;

import com.example.managerservice.ModelMigration.Manager;
import com.example.managerservice.dto.PickupPointsResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.Queue;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
    Optional<Manager> getManagerByEmail(String email);
    boolean existsManagerByEmail(String email);
//    @Query("SELECT pick FROM PickupPoint pick where pick.id = :id")
//    PickupPointsResponse getPickupPointsByPickId(@Param("id") Long pickId);
    /*Функция: get_manager_profile(manager_id)
Описание: Возвращает информацию о профиле управляющего по его ID.
Метод: Выполняет запрос к базе данных, извлекая данные о профиле управляющего (имя, фамилия, email, телефон, список ПВЗ).
Функция: update_manager_profile(manager_id, updated_data)
Описание: Обновляет информацию о профиле управляющего.
Метод: Получает обновленные данные о профиле, выполняет запрос к базе данных для обновления записи.
Функция: add_pos_to_manager(manager_id, pos_id)
Описание: Добавляет ПВЗ к аккаунту управляющего.*/
}